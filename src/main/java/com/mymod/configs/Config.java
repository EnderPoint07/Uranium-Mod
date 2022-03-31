package com.mymod.configs;

import com.mymod.MyMod;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

public class Config {
    public static void register() {
        registerServerConfigs();
        registerCommonConfigs();
        MyMod.LOGGER.info("TESTS");
        registerClientConfigs();
    }

    private static void registerClientConfigs() {
    }

    private static void registerServerConfigs() {
    }

    private static void registerCommonConfigs() {
        ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
        UraniumConfig.CommonConfig(COMMON_BUILDER);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, COMMON_BUILDER.build(), "uraniumConfig.toml");
    }
}