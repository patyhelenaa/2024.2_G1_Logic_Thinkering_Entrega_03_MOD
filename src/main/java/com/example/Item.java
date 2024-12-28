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


    private ConcreteTool reinforcedCopperSword = new ConcreteTool("reinforced_copper_sword", "SWORD", "REINFORCED_COPPER");
    private ConcreteTool reinforcedCopperAxe = reinforcedCopperSword.clone();
    private ConcreteTool reinforcedCopperPickaxe = reinforcedCopperSword.clone();
    private ConcreteTool reinforcedCopperShovel = reinforcedCopperSword.clone();
    private ConcreteTool reinforcedCopperHoe = reinforcedCopperSword.clone();


    private ConcreteTool reinforcedEmeraldSword = new ConcreteTool("reinforced_emerald_sword", "SWORD", "REINFORCED_EMERALD");
    private ConcreteTool reinforcedEmeraldAxe = reinforcedEmeraldSword.clone();
    private ConcreteTool reinforcedEmeraldPickaxe = reinforcedEmeraldSword.clone();
    private ConcreteTool reinforcedEmeraldShovel = reinforcedEmeraldSword.clone();
    private ConcreteTool reinforcedEmeraldHoe = reinforcedEmeraldSword.clone();


    private ConcreteTool reinforcedAmethystSword = new ConcreteTool("reinforced_amethyst_sword", "SWORD", "REINFORCED_AMETHYST");
    private ConcreteTool reinforcedAmethystAxe = reinforcedAmethystSword.clone();
    private ConcreteTool reinforcedAmethystPickaxe = reinforcedAmethystSword.clone();
    private ConcreteTool reinforcedAmethystShovel = reinforcedAmethystSword.clone();
    private ConcreteTool reinforcedAmethystHoe = reinforcedAmethystSword.clone();


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
        reinforcedCopperAxe.setType("AXE");
        reinforcedEmeraldAxe.setId("reinforced_emerald_axe");
        reinforcedEmeraldAxe.setType("AXE");
        reinforcedAmethystAxe.setId("reinforced_amethyst_axe");
        reinforcedAmethystAxe.setType("AXE");

        reinforcedCopperPickaxe.setId("reinforced_copper_pickaxe");
        reinforcedCopperPickaxe.setType("PICKAXE");
        reinforcedEmeraldPickaxe.setId("reinforced_emerald_pickaxe");
        reinforcedEmeraldPickaxe.setType("PICKAXE");
        reinforcedAmethystPickaxe.setId("reinforced_amethyst_pickaxe");
        reinforcedAmethystPickaxe.setType("PICKAXE");

        reinforcedCopperShovel.setId("reinforced_copper_shovel");
        reinforcedCopperShovel.setType("SHOVEL");
        reinforcedEmeraldShovel.setId("reinforced_emerald_shovel");
        reinforcedEmeraldShovel.setType("SHOVEL");
        reinforcedAmethystShovel.setId("reinforced_amethyst_shovel");
        reinforcedAmethystShovel.setType("SHOVEL");

        reinforcedCopperHoe.setId("reinforced_copper_hoe");
        reinforcedCopperHoe.setType("HOE");
        reinforcedEmeraldHoe.setId("reinforced_emerald_hoe");
        reinforcedEmeraldHoe.setType("HOE");
        reinforcedAmethystHoe.setId("reinforced_amethyst_hoe");
        reinforcedAmethystHoe.setType("HOE");

        reinforcedCopperShard.setId("reinforced_copper_ingot");
        reinforcedEmeraldShard.setId("reinforced_emerald_shard");
        reinforcedAmethystShard.setId("reinforced_amethyst_shard");
    }

}
