package com.logic_thinkering.digitalcircuits

import com.logic_thinkering.LogicThinkeringKotlin
import com.logic_thinkering.logger
import com.mojang.serialization.MapCodec
import net.minecraft.block.AbstractRedstoneGateBlock
import net.minecraft.block.BlockState
import net.minecraft.entity.LivingEntity
import net.minecraft.item.ItemStack
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

class LogGateDecorator(gate: AbstractLogicGate) : AbstractLogicGate(gate.settings, gate.logicStrategy) {
    override fun getCodec(): MapCodec<AbstractRedstoneGateBlock>? = null

    override fun onPlaced(
        world: World?,
        pos: BlockPos?,
        state: BlockState?,
        placer: LivingEntity?,
        itemStack: ItemStack?
    ) {
        logger.info("Placing logic gate at {}", pos!!)
    }
}