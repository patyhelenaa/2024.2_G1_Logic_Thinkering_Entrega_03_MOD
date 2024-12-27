package com.example;

public class Item {
    private ConcreteItem concreteItem = new ConcreteItem("");
    private ConcreteItem teste = (ConcreteItem) concreteItem.clone();

    private ConcreteArmor concreteArmorCopper = new ConcreteArmor("", "HELMET", "REINFORCED_COPPER");
    private ConcreteArmor reinforcedCopperHelmet = (ConcreteArmor) concreteArmorCopper.clone();
    private ConcreteArmor reinforcedCopperChestplate = (ConcreteArmor) concreteArmorCopper.clone();
    private ConcreteArmor reinforcedCopperLeggings = (ConcreteArmor) concreteArmorCopper.clone();
    private ConcreteArmor reinforcedCopperBoots = (ConcreteArmor) concreteArmorCopper.clone();

    private ConcreteArmor concreteArmorEmerald = new ConcreteArmor("", "HELMET", "REINFORCED_EMERALD");
    private ConcreteArmor reinforcedEmeraldHelmet = (ConcreteArmor) concreteArmorEmerald.clone();
    private ConcreteArmor reinforcedEmeraldChestplate = (ConcreteArmor) concreteArmorEmerald.clone();
    private ConcreteArmor reinforcedEmeraldLeggings = (ConcreteArmor) concreteArmorEmerald.clone();
    private ConcreteArmor reinforcedEmeraldBoots = (ConcreteArmor) concreteArmorEmerald.clone();

    private ConcreteArmor concreteArmorAmethyst = new ConcreteArmor("", "HELMET", "REINFORCED_AMETHYST");
    private ConcreteArmor reinforcedAmethystHelmet = (ConcreteArmor) concreteArmorAmethyst.clone();
    private ConcreteArmor reinforcedAmethystChestplate = (ConcreteArmor) concreteArmorAmethyst.clone();
    private ConcreteArmor reinforcedAmethystLeggings = (ConcreteArmor) concreteArmorAmethyst.clone();
    private ConcreteArmor reinforcedAmethystBoots = (ConcreteArmor) concreteArmorAmethyst.clone();

    private ConcreteTool reinforcedCopperSword = new ConcreteTool("", "SWORD", "REINFORCED_COPPER");
    private ConcreteTool reinforcedEmeraldSword = new ConcreteTool("", "SWORD", "REINFORCED_EMERALD");
    private ConcreteTool reinforcedAmethystSword = new ConcreteTool("", "SWORD", "REINFORCED_AMETHYST");

    private ConcreteTool reinforcedCopperAxe = new ConcreteTool("", "AXE", "REINFORCED_COPPER");
    private ConcreteTool reinforcedEmeraldAxe = new ConcreteTool("", "AXE", "REINFORCED_EMERALD");
    private ConcreteTool reinforcedAmethystAxe = new ConcreteTool("", "AXE", "REINFORCED_AMETHYST");

    public Item() {
        teste.setId("teste");

        reinforcedCopperHelmet.setId("reinforced_copper_helmet");
        reinforcedCopperChestplate.setType("CHESTPLATE");
        reinforcedCopperChestplate.setId("reinforced_copper_chestplate");
        reinforcedCopperLeggings.setType("LEGGINGS");
        reinforcedCopperLeggings.setId("reinforced_copper_leggings");
        reinforcedCopperBoots.setType("BOOTS");
        reinforcedCopperBoots.setId("reinforced_copper_boots");

        reinforcedEmeraldHelmet.setId("reinforced_emerald_helmet");
        reinforcedEmeraldChestplate.setType("CHESTPLATE");
        reinforcedEmeraldChestplate.setId("reinforced_emerald_chestplate");
        reinforcedEmeraldLeggings.setType("LEGGINGS");
        reinforcedEmeraldLeggings.setId("reinforced_emerald_leggings");
        reinforcedEmeraldBoots.setType("BOOTS");
        reinforcedEmeraldBoots.setId("reinforced_emerald_boots");

        reinforcedAmethystHelmet.setId("reinforced_amethyst_helmet");
        reinforcedAmethystChestplate.setType("CHESTPLATE");
        reinforcedAmethystChestplate.setId("reinforced_amethyst_chestplate");
        reinforcedAmethystLeggings.setType("LEGGINGS");
        reinforcedAmethystLeggings.setId("reinforced_amethyst_leggings");
        reinforcedAmethystBoots.setType("BOOTS");
        reinforcedAmethystBoots.setId("reinforced_amethyst_boots");

        reinforcedCopperSword.setId("reinforced_copper_sword");
        reinforcedEmeraldSword.setId("reinforced_emerald_sword");
        reinforcedAmethystSword.setId("reinforced_amethyst_sword");

        reinforcedCopperAxe.setId("reinforced_copper_axe");
        reinforcedEmeraldAxe.setId("reinforced_emerald_axe");
        reinforcedAmethystAxe.setId("reinforced_amethyst_axe");
    }

}
