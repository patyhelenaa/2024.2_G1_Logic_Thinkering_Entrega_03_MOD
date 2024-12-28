package com.example;

public class Item {
    private ConcreteItem concreteItem = new ConcreteItem("");
    private ConcreteItem reinforcedCopperShard = concreteItem.clone();
    private ConcreteItem reinforcedEmeraldShard = concreteItem.clone();
    private ConcreteItem reinforcedAmethystShard = concreteItem.clone();

    private ConcreteArmor reinforcedCopperHelmet = new ConcreteArmor("reinforced_copper_helmet", "HELMET", "REINFORCED_COPPER");
    private ConcreteArmor reinforcedCopperChestplate = reinforcedCopperHelmet.clone();
    private ConcreteArmor reinforcedCopperLeggings = reinforcedCopperHelmet.clone();
    private ConcreteArmor reinforcedCopperBoots = reinforcedCopperHelmet.clone();

    private ConcreteArmor reinforcedEmeraldHelmet = new ConcreteArmor("reinforced_emerald_helmet", "HELMET", "REINFORCED_EMERALD");
    private ConcreteArmor reinforcedEmeraldChestplate = reinforcedEmeraldHelmet.clone();
    private ConcreteArmor reinforcedEmeraldLeggings = reinforcedEmeraldHelmet.clone();
    private ConcreteArmor reinforcedEmeraldBoots = reinforcedEmeraldHelmet.clone();

    private ConcreteArmor reinforcedAmethystHelmet = new ConcreteArmor("reinforced_amethyst_helmet", "HELMET", "REINFORCED_AMETHYST");
    private ConcreteArmor reinforcedAmethystChestplate = reinforcedAmethystHelmet.clone();
    private ConcreteArmor reinforcedAmethystLeggings = reinforcedAmethystHelmet.clone();
    private ConcreteArmor reinforcedAmethystBoots = reinforcedAmethystHelmet.clone();


    private ConcreteTool reinforcedCopperSword = new ConcreteTool("", "SWORD", "REINFORCED_COPPER");
    private ConcreteTool reinforcedCopperAxe = new ConcreteTool("", "AXE", "REINFORCED_COPPER");
    private ConcreteTool reinforcedCopperPickaxe = new ConcreteTool("", "PICKAXE", "REINFORCED_COPPER");
    private ConcreteTool reinforcedCopperShovel = new ConcreteTool("", "SHOVEL", "REINFORCED_COPPER");
    private ConcreteTool reinforcedCopperHoe = new ConcreteTool("", "HOE", "REINFORCED_COPPER");


    private ConcreteTool reinforcedEmeraldSword = new ConcreteTool("", "SWORD", "REINFORCED_EMERALD");
    private ConcreteTool reinforcedEmeraldAxe = new ConcreteTool("", "AXE", "REINFORCED_EMERALD");
    private ConcreteTool reinforcedEmeraldPickaxe = new ConcreteTool("", "PICKAXE", "REINFORCED_EMERALD");
    private ConcreteTool reinforcedEmeraldShovel = new ConcreteTool("", "SHOVEL", "REINFORCED_EMERALD");
    private ConcreteTool reinforcedEmeraldHoe = new ConcreteTool("", "HOE", "REINFORCED_EMERALD");


    private ConcreteTool reinforcedAmethystSword = new ConcreteTool("", "SWORD", "REINFORCED_AMETHYST");
    private ConcreteTool reinforcedAmethystAxe = new ConcreteTool("", "AXE", "REINFORCED_AMETHYST");
    private ConcreteTool reinforcedAmethystPickaxe = new ConcreteTool("", "PICKAXE", "REINFORCED_AMETHYST");
    private ConcreteTool reinforcedAmethystShovel = new ConcreteTool("", "SHOVEL", "REINFORCED_AMETHYST");
    private ConcreteTool reinforcedAmethystHoe = new ConcreteTool("", "HOE", "REINFORCED_AMETHYST");


    public Item() {

        reinforcedCopperChestplate.setType("CHESTPLATE");
        reinforcedCopperChestplate.setId("reinforced_copper_chestplate");
        reinforcedEmeraldChestplate.setType("CHESTPLATE");
        reinforcedEmeraldChestplate.setId("reinforced_emerald_chestplate");
        reinforcedAmethystChestplate.setType("CHESTPLATE");
        reinforcedAmethystChestplate.setId("reinforced_amethyst_chestplate");

        reinforcedCopperLeggings.setType("LEGGINGS");
        reinforcedCopperLeggings.setId("reinforced_copper_leggings");
        reinforcedEmeraldLeggings.setType("LEGGINGS");
        reinforcedEmeraldLeggings.setId("reinforced_emerald_leggings");
        reinforcedAmethystLeggings.setType("LEGGINGS");
        reinforcedAmethystLeggings.setId("reinforced_amethyst_leggings");

        reinforcedCopperBoots.setType("BOOTS");
        reinforcedCopperBoots.setId("reinforced_copper_boots");
        reinforcedEmeraldBoots.setType("BOOTS");
        reinforcedEmeraldBoots.setId("reinforced_emerald_boots");
        reinforcedAmethystBoots.setType("BOOTS");
        reinforcedAmethystBoots.setId("reinforced_amethyst_boots");

        reinforcedCopperSword.setId("reinforced_copper_sword");
        reinforcedEmeraldSword.setId("reinforced_emerald_sword");
        reinforcedAmethystSword.setId("reinforced_amethyst_sword");

        reinforcedCopperAxe.setId("reinforced_copper_axe");
        reinforcedEmeraldAxe.setId("reinforced_emerald_axe");
        reinforcedAmethystAxe.setId("reinforced_amethyst_axe");

        reinforcedCopperPickaxe.setId("reinforced_copper_pickaxe");
        reinforcedEmeraldPickaxe.setId("reinforced_emerald_pickaxe");
        reinforcedAmethystPickaxe.setId("reinforced_amethyst_pickaxe");

        reinforcedCopperShovel.setId("reinforced_copper_shovel");
        reinforcedEmeraldShovel.setId("reinforced_emerald_shovel");
        reinforcedAmethystShovel.setId("reinforced_amethyst_shovel");

        reinforcedCopperHoe.setId("reinforced_copper_hoe");
        reinforcedEmeraldHoe.setId("reinforced_emerald_hoe");
        reinforcedAmethystHoe.setId("reinforced_amethyst_hoe");

        reinforcedCopperShard.setId("reinforced_copper_ingot");
        reinforcedEmeraldShard.setId("reinforced_emerald_shard");
        reinforcedAmethystShard.setId("reinforced_amethyst_shard");
    }

}
