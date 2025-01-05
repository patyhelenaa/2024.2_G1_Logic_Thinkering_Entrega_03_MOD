package com.logic_thinkering

import com.logic_thinkering.digitalcircuits.*
import com.logic_thinkering.items.ReinforcedCopperShield
import com.logic_thinkering.items.ReinforcedCopperSword
import net.fabricmc.api.ModInitializer
import net.minecraft.block.AbstractBlock.Settings
import net.minecraft.block.Blocks
import net.minecraft.item.ItemGroups
import org.slf4j.Logger
import org.slf4j.LoggerFactory

private fun startup() {
    logger.info("Initializing Logic Thinkering mod, Kotlin side!")

    registerBlocks {
        group(LogicThinkeringItemGroup.LOGICTHINKERING_GROUP)
        settings(Settings.copy(Blocks.REPEATER))
        decorator {
            if (it is AbstractLogicGate)
                LogicLoggerDecorator(it)
            else {
                it
            }
        }
        ::ORGate with "or_gate"
        ::ANDGate with "and_gate"
        ::XORGate with "xor_gate"
        ::NOTGate with "not_gate"
        ::NORGate with "nor_gate"
        ::NANDGate with "nand_gate"
        ::XNORGate with "xnor_gate"
    }

    registerItems {
        group(ItemGroups.COMBAT)
        ReinforcedCopperShield() with "reinforced_copper_shield"
        ReinforcedCopperSword() with "reinforced_sword"
    }

    ModComponents.initialize()
}

const val MOD_ID = "logic_thinkering"
val logger: Logger = LoggerFactory.getLogger(MOD_ID)
/**
 * Object responsible for initializing the mod.
 * Registering blocks, items and componentes and setting the mod's identifier.
 */
object LogicThinkeringKotlin : ModInitializer {
    fun initialize() = startup()
    override fun onInitialize() = startup()
}
