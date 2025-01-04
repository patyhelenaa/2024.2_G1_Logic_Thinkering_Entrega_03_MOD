package com.logic_thinkering.itens;

import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;

public interface ToolMaterial {

    net.minecraft.item.ToolMaterial REINFORCED_COPPER = new net.minecraft.item.ToolMaterial(BlockTags.INCORRECT_FOR_STONE_TOOL, 200, 6.5F, 2.0F, 14, ItemTags.STONE_TOOL_MATERIALS);
    net.minecraft.item.ToolMaterial REINFORCED_EMERALD = new net.minecraft.item.ToolMaterial(BlockTags.INCORRECT_FOR_STONE_TOOL, 250, 6.5F, 3.0F, 14, ItemTags.STONE_TOOL_MATERIALS);
    net.minecraft.item.ToolMaterial REINFORCED_AMETHYST = new net.minecraft.item.ToolMaterial(BlockTags.INCORRECT_FOR_STONE_TOOL, 500, 6.5F, 5.0F, 14, ItemTags.STONE_TOOL_MATERIALS);

    static net.minecraft.item.ToolMaterial valueOf(String name) {
        return switch (name.toUpperCase()) {
            case "REINFORCED_COPPER" -> REINFORCED_COPPER;
            case "REINFORCED_EMERALD" -> REINFORCED_EMERALD;
            case "REINFORCED_AMETHYST" -> REINFORCED_AMETHYST;
            default -> throw new IllegalArgumentException("Unknown material: " + name);
        };
    }
}