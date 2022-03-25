package com.mymod;

import com.mojang.blaze3d.shaders.Effect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class MageArmorItem extends ArmorItem {

    boolean fullSetUranium = false;
    boolean uraniumHelmetEquipped = false;
    boolean uraniumChestPlateEquipped = false;
    boolean uraniumLeggingsEquipped = false;
    boolean uraniumBootsEquipped = false;

    /*
    public MageArmorItem(ArmorMaterial pMaterial, EquipmentSlot slot, Item.Properties properties) {
        super(pMaterial, slot, properties);
    }

    public void inventoryTick(Player player) {
        if (player.getItemBySlot(EquipmentSlot.HEAD).getItem() == Registration.Uranium_Helmet.get()) {

            uraniumHelmetEquipped = true;

        }
        if (player.getItemBySlot(EquipmentSlot.CHEST).getItem() == Registration.Uranium_ChestPlate.get()) {

            uraniumChestPlateEquipped = true;

        }
        if (player.getItemBySlot(EquipmentSlot.LEGS).getItem() == Registration.Uranium_Leggings.get()) {

            uraniumLeggingsEquipped = true;

        }
        if (player.getItemBySlot(EquipmentSlot.FEET).getItem() == Registration.Uranium_Boots.get()) {

            uraniumBootsEquipped = true;

        }

        if (uraniumHelmetEquipped && uraniumChestPlateEquipped && uraniumLeggingsEquipped && uraniumBootsEquipped) {
            fullSetUranium = true;
        }
    }*/


    public MageArmorItem(ArmorMaterial pMaterial, EquipmentSlot pSlot, Item.Properties pProperties) {
        super(pMaterial, pSlot, pProperties);
    }

    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {

        if (player.getInventory().getArmor(1).getItem() == Registration.Uranium_Helmet.get()) {
            uraniumHelmetEquipped = true;
        }if (player.getInventory().getArmor(2).getItem() == Registration.Uranium_ChestPlate.get()) {
            uraniumChestPlateEquipped = true;
        }if (player.getInventory().getArmor(3).getItem() == Registration.Uranium_Leggings.get()) {
            uraniumLeggingsEquipped = true;
        }if (player.getInventory().getArmor(4).getItem() == Registration.Uranium_Boots.get()) {

            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 1));

            uraniumBootsEquipped = true;
        }

        stack = player.getInventory().getArmor(2);
        MyMod.LOGGER.info("armour:" + stack);
        MyMod.LOGGER.info("armour:" + player.getInventory().getArmor(3));
    }


}
