package com.example.block.miningmachine;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

import java.util.List;

public class LineMiningStrategy implements MiningStrategy {

    private final int length;

    public LineMiningStrategy(int length) {
        this.length = length;
    }

    @Override
    public void mine(ServerWorld world, BlockPos pos, List<BlockPos> blocksToMine) {
        for (int i = 1; i < length; i++) {
            // A cada iteração, a posição se move para frente ao longo do eixo X
            BlockPos targetPos = pos.add(0, 0, i); // Movendo ao longo do eixo X (pode ser alterado para Z)

            // Minerando uma área 3x3 ao redor de targetPos, incluindo o eixo Y
            for (int x = -1; x <= 1; x++) {
                for (int y = 0; y <= 2; y++) {
                    for (int z = -1; z <= 1; z++) {
                        BlockPos areaPos = targetPos.add(x, y, z); // Calculando a posição dos blocos no 3x3x3
                        BlockState targetState = world.getBlockState(areaPos);

                        // Ignora o próprio bloco e a Bedrock
                        if (areaPos.equals(pos) || targetState.getBlock() == Blocks.BEDROCK) {
                            continue;
                        }

                        // Adiciona o bloco à lista de blocos a serem minerados, se não for ar
                        if (!targetState.isAir()) {
                            blocksToMine.add(areaPos);
                        }
                    }
                }
            }
        }
    }
}
