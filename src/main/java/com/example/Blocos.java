package com.example;

import com.example.block.miningmachine.MiningMachineBlock;
import com.example.block.ClockEnergy;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.*;

public class Blocos {

    public static final Block CLOCK = RegistrarBlocos.registrarBloco(
            "clock",
            ClockEnergy::new,
            AbstractBlock.Settings.create().strength(4f).requiresTool()
    );

    public static final Block BLOCO_MINERACAO = RegistrarBlocos.registrarBloco(
            "bloco_mineracao",
            MiningMachineBlock::new,
            AbstractBlock.Settings.create().strength(4f).requiresTool()
    );

    public static final Block MATRIZ_FIOS = RegistrarBlocos.registrarBloco(
            "matriz_fios",
            Block::new,
            AbstractBlock.Settings.create().strength(4f).requiresTool()
    );

    public static void inicializa() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(Blocos.CLOCK);
            entries.add(Blocos.BLOCO_MINERACAO);
            entries.add(Blocos.MATRIZ_FIOS);
        });
    }
}