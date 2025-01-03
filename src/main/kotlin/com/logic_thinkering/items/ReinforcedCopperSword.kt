package com.logic_thinkering.items

import com.logic_thinkering.materials.ReinforcedCopperMaterial
import com.logic_thinkering.weapon.WeaponBehavior
import com.logic_thinkering.weapon.base.BaseWeapon
import com.logic_thinkering.weapon.decorator.ChargeableWeaponDecorator
import net.minecraft.entity.LivingEntity
import net.minecraft.item.ItemStack
import net.minecraft.item.tooltip.TooltipType
import net.minecraft.text.Text

class ReinforcedCopperSword(
    material: ReinforcedCopperMaterial = ReinforcedCopperMaterial,
    settings: Settings = Settings()
) : BaseWeapon(material, settings) {
    private val decoratedWeapon: WeaponBehavior = ChargeableWeaponDecorator(
        weapon = this,
        maxCharge = 3,
        baseAttackDamage = material.attackDamage + 3.0f
    )

    override fun postHit(stack: ItemStack, target: LivingEntity, attacker: LivingEntity): Boolean {
        return decoratedWeapon.onHit(stack, target, attacker)
    }

    override fun appendTooltip(
        stack: ItemStack,
        world: TooltipContext?,
        tooltip: MutableList<Text>,
        context: TooltipType
    ) {
        decoratedWeapon.appendTooltip(stack, world, tooltip, context)
    }
}