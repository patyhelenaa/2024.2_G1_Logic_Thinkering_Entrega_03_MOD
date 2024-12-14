package com.example.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.world.BlockView;

public class ClockEnergy extends Block {
    public static final BooleanProperty ACTIVE = BooleanProperty.of("active");

    public ClockEnergy(AbstractBlock.Settings settings) {
        super(settings);
        // Define o estado inicial do bloco como "inativo"
        this.setDefaultState(this.stateManager.getDefaultState().with(ACTIVE, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(ACTIVE); // Adiciona a propriedade "active" ao bloco
    }

    @Override
    public boolean emitsRedstonePower(BlockState state) {
        return state.get(ACTIVE); // Só emite sinal se estiver "ativo"
    }

    @Override
    public int getWeakRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
        return state.get(ACTIVE) ? 15 : 0; // Emite potência máxima quando "ativo", senão 0
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        // Alterna o estado do bloco (ativo/inativo)
        boolean isActive = state.get(ACTIVE);
        world.setBlockState(pos, state.with(ACTIVE, !isActive), Block.NOTIFY_ALL);

        // Solicita uma nova atualização após 20 ticks (1 segundo)
        world.scheduleBlockTick(pos, this, 20);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, net.minecraft.entity.LivingEntity placer, net.minecraft.item.ItemStack itemStack) {
        // Quando o bloco é colocado, inicia o ciclo de atualizações
        if (!world.isClient) {
            world.scheduleBlockTick(pos, this, 20); // Primeira atualização após 20 ticks (1 segundo)
        }
    }
}