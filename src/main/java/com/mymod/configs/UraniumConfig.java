package com.mymod.configs;

import net.minecraftforge.common.ForgeConfigSpec;

public class UraniumConfig {
    public static ForgeConfigSpec.IntValue OVERWORLD_VEINSIZE;
    public static ForgeConfigSpec.IntValue OVERWORLD_AMOUNT;

    public static ForgeConfigSpec.IntValue DEEPSLATE_VEINSIZE;
    public static ForgeConfigSpec.IntValue DEEPSLATE_AMOUNT;

    public static ForgeConfigSpec.IntValue END_VEINSIZE;
    public static ForgeConfigSpec.IntValue END_AMOUNT;

    public static ForgeConfigSpec.IntValue NETHER_VEINSIZE;
    public static ForgeConfigSpec.IntValue NETHER_AMOUNT;

    public static void CommonConfig(ForgeConfigSpec.Builder builder) {

        builder.push("Overworld");
        OVERWORLD_VEINSIZE = builder.defineInRange("OVERWORLD_VEINSIZE", 5, 1, 25);
        OVERWORLD_AMOUNT = builder.defineInRange("OVERWORLD_AMOUNT", 3, 1, 25);
        builder.pop();

        builder.push("DeepSlate");
        DEEPSLATE_VEINSIZE = builder.defineInRange("DEEPSLATE_VEINSIZE", 5, 1, 25);
        DEEPSLATE_AMOUNT = builder.defineInRange("DEEPSLATE_AMOUNT", 3, 1, 25);
        builder.pop();

        builder.push("End");
        END_VEINSIZE = builder.defineInRange("END_VEINSIZE", 20, 1, 25);
        END_AMOUNT = builder.defineInRange("END_AMOUNT", 12, 1, 25);
        builder.pop();

        builder.push("Nether");
        NETHER_VEINSIZE = builder.defineInRange("NETHER_VEINSIZE", 10, 1, 25);
        NETHER_AMOUNT = builder.defineInRange("NETHER_AMOUNT", 6, 1, 25);
        builder.pop();
    }
}