package com.logicthinkering.weapon.base

import com.logicthinkering.weapon.WeaponBehavior
import net.minecraft.entity.LivingEntity
import net.minecraft.item.ItemStack
import net.minecraft.item.SwordItem
import net.minecraft.item.ToolMaterial
import net.minecraft.item.tooltip.TooltipType
import net.minecraft.text.Text

abstract class BaseWeapon(
    material: ToolMaterial,
    settings: Settings
) : SwordItem(material, settings), WeaponBehavior {
    override fun onHit(stack: ItemStack, target: LivingEntity, attacker: LivingEntity): Boolean {
        return super.postHit(stack, target, attacker)
    }

    override fun appendTooltip(stack: ItemStack, world: TooltipContext?, tooltip: MutableList<Text>, context: TooltipType) {
        super.appendTooltip(stack, world, tooltip, context)
    }
}