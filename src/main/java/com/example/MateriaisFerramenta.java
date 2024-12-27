package com.example;

import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;

public interface MateriaisFerramenta {

    ToolMaterial REINFORCED_COPPER = new ToolMaterial(BlockTags.INCORRECT_FOR_STONE_TOOL, 200, 6.5F, 2.0F, 14, ItemTags.STONE_TOOL_MATERIALS);
    ToolMaterial REINFORCED_EMERALD = new ToolMaterial(BlockTags.INCORRECT_FOR_STONE_TOOL, 200, 6.5F, 3.0F, 14, ItemTags.STONE_TOOL_MATERIALS);
    ToolMaterial REINFORCED_AMETHYST = new ToolMaterial(BlockTags.INCORRECT_FOR_STONE_TOOL, 131, 2.0F, 1.0F, 14, ItemTags.STONE_TOOL_MATERIALS);

    static ToolMaterial valueOf(String name) {
        return switch (name.toUpperCase()) {
            case "REINFORCED_COPPER" -> REINFORCED_COPPER;
            case "REINFORCED_EMERALD" -> REINFORCED_EMERALD;
            case "REINFORCED_AMETHYST" -> REINFORCED_AMETHYST;
            default -> throw new IllegalArgumentException("Unknown material: " + name);
        };
    }
}