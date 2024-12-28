package com.example;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class GuiaInventario {
    public static final RegistryKey<ItemGroup> LOGICTHINKERING_GRUPO;
    public static final ItemGroup LOGICTHINKERING_ITEM_GRUPO;

    static {
        LOGICTHINKERING_ITEM_GRUPO = FabricItemGroup.builder()
                .icon(() -> new ItemStack(Items.CRAFTER))
                .displayName(Text.translatable("Logic Thinkering"))
                .build();
        LOGICTHINKERING_GRUPO = RegistryKey.of(
                Registries.ITEM_GROUP.getKey(),
                Identifier.of(ExampleMod.MOD_ID, "logicthinkering")
        );
        Registry.register(Registries.ITEM_GROUP, LOGICTHINKERING_GRUPO, LOGICTHINKERING_ITEM_GRUPO);
    }

    private GuiaInventario() {
        throw new UnsupportedOperationException("Esta é uma classe utilitária e não pode ser instanciada.");
    }

    public static void adicionarItem(Item item) {
        ItemGroupEvents.modifyEntriesEvent(LOGICTHINKERING_GRUPO).register(itemGroup -> itemGroup.add(item));
    }
}
