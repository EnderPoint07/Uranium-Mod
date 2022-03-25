package com.mymod;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public class baseArmourMat implements ArmorMaterial {

    private final int enchantibility;
    private final int[] duribility, damageReduction;
    private final float kbResistance, toughness;
    private final String name;
    private final SoundEvent equipSound;
    private final Supplier<Ingredient> repairMat;

    public baseArmourMat(int enchantibility, int[] duribility, int[] damageReduction, float kbResistance,
                         float toughness, String name, SoundEvent equipSound, Supplier<Ingredient> repairMat) {
        this.enchantibility = enchantibility;
        this.duribility = duribility;
        this.damageReduction = damageReduction;
        this.kbResistance = kbResistance;
        this.toughness = toughness;
        this.name = name;
        this.equipSound = equipSound;
        this.repairMat = repairMat;
    }


    @Override
    public int getDefenseForSlot(EquipmentSlot slot) {
        return this.damageReduction[slot.getIndex()];
    }

    @Override
    public int getDurabilityForSlot(EquipmentSlot slot) {
        return this.duribility[slot.getIndex()];
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantibility;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public float getKnockbackResistance() {
        return this.kbResistance;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairMat.get();
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }


}

