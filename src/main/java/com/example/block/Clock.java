package com.example.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.world.BlockView;

public class Clock extends Block {

    public Clock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    public boolean emitsRedstonePower(BlockState state) {
        return true; // Indica que o bloco emite sinal de redstone
    }

    @Override
    public int getWeakRedstonePower(BlockState state, BlockView world, net.minecraft.util.math.BlockPos pos, net.minecraft.util.math.Direction direction) {
        return 10; // Potência máxima de redstone
    }
}