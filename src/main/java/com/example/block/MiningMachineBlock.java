package com.example.block;

import com.example.block.entity.MiningMachineBlockEntity;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class MiningMachineBlock extends BlockWithEntity {

    private final List<BlockPos> blocksToMine = new ArrayList<>();

    public MiningMachineBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends MiningMachineBlock> getCodec() {
        return createCodec(MiningMachineBlock::new);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new MiningMachineBlockEntity(pos, state);
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
        if (!world.isClient) {
            startMining((ServerWorld) world, pos);
        }
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof MiningMachineBlockEntity miningMachineBlockEntity) {
                ItemScatterer.spawn(world, pos, miningMachineBlockEntity);
                world.updateComparators(pos,this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient) {
            NamedScreenHandlerFactory screenHandlerFactory = state.createScreenHandlerFactory(world, pos);
            if (screenHandlerFactory != null) {
                player.openHandledScreen(screenHandlerFactory);
            }
        }
        return ActionResult.SUCCESS;
    }

    private void startMining(ServerWorld world, BlockPos pos) {
        // Preencher a lista de blocos a serem minerados
        int radius = 5;
        for (int x = -radius; x <= radius; x++) {
            for (int y = -radius; y <= radius; y++) {
                for (int z = -radius; z <= radius; z++) {
                    BlockPos targetPos = pos.add(new Vec3i(x, y, z));
                    BlockState targetState = world.getBlockState(targetPos);

                    // Verificar se não é o próprio bloco nem Bedrock
                    if (targetPos.equals(pos) || targetState.getBlock() == Blocks.BEDROCK) {
                        continue;
                    }

                    // Adicionar o bloco à lista de blocos a serem minerados
                    if (!targetState.isAir()) {
                        blocksToMine.add(targetPos);
                    }
                }
            }
        }

        // Agendar o primeiro tick de mineração
        if (!blocksToMine.isEmpty()) {
            world.scheduleBlockTick(pos, this, 20);
        }
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!blocksToMine.isEmpty()) {
            // Quebrar o próximo bloco na lista
            BlockPos targetPos = blocksToMine.getFirst();
            BlockState targetState = world.getBlockState(targetPos);

            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof MiningMachineBlockEntity miningMachineEntity) {
                List<ItemStack> drops = Block.getDroppedStacks(
                        targetState,
                        world,
                        targetPos,
                        world.getBlockEntity(targetPos),
                        null,
                        ItemStack.EMPTY
                );

                boolean canStoreAllDrops = true;
                for (ItemStack drop : drops) {
                    if (!miningMachineEntity.canStoreItem(drop)) {
                        canStoreAllDrops = false;
                        break;
                    }
                }

                // Move o bloco para final da lista, uma vez que não é possível armazenar
                // todos os seus drops, e segue com a mineração dos demais blocos.
                if (!canStoreAllDrops) {
                    blocksToMine.addLast(blocksToMine.removeFirst());
                    world.scheduleBlockTick(pos, this, 20);
                    return;
                }

                for (ItemStack item : drops) {
                    miningMachineEntity.addItemToInventory(item);
                }

                blocksToMine.removeFirst();
                world.setBlockState(targetPos, Blocks.AIR.getDefaultState(), 3);
            }
        }

        // Agendar o próximo tick de mineração, se houver blocos restantes
        if (!blocksToMine.isEmpty()) {
            world.scheduleBlockTick(pos, this, 20);
        }
    }
}
