package com.example.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class AutoMiningBlock extends Block {
    public static boolean isMiningEnabled = false;

    public AutoMiningBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    //@Override
    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
        if (!world.isClient) {
            startMining((ServerWorld) world, pos);
        }
    }

    private void startMining(ServerWorld world, BlockPos pos) {
        int radius = 20;
        for (int x = -radius; x < radius; x++) {
            for (int y = -radius; y < radius; y++) {
                for (int z = -radius; z < radius; z++) {
                    BlockPos targetPos = pos.add(x, y, z);
                    BlockState targetState = world.getBlockState(targetPos);
                    // Verificar se o bloco é sólido
                    if (targetState.isSolidBlock(world, targetPos)) {
                        world.breakBlock(targetPos, true);
                    }
                }
            }
        }
    }

    public static void toggleMining() {
        isMiningEnabled = !isMiningEnabled;
    }
}



