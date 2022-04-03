package com.mymod;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

public final class ArmorMaterialInit {
    public static final ArmorMaterial URANIUM = new baseArmourMat(100, new int[]{950, 1400, 1800, 1000},
            new int[]{20, 35, 50, 27}, 3.2f, 1.85f, MyMod.MODID + ":uranium",
            SoundEvents.AMETHYST_BLOCK_CHIME, () -> Ingredient.of(Registration.UraniumShards.get()));

    private ArmorMaterialInit() {
    }
}