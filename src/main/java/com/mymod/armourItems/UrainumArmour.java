package com.mymod.armourItems;

import com.mymod.Registration;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.extensions.IForgeItem;

public class UrainumArmour extends ArmorItem {
    public UrainumArmour(ArmorMaterial pMaterial, EquipmentSlot pSlot, Properties pProperties) {
        super(pMaterial, pSlot, pProperties);
    }

    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {

        if (player.getInventory().getArmor(0).getItem() == Registration.Uranium_Boots.get()) {
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, 1));
        }
        if (player.getInventory().getArmor(1).getItem() == Registration.Uranium_Leggings.get()) {
            player.addEffect(new MobEffectInstance(MobEffects.JUMP, 60, 1));
        }
        if (player.getInventory().getArmor(2).getItem() == Registration.Uranium_ChestPlate.get()) {

            int HealthBoost = 0;
                if (player.getEffect(MobEffects.HEALTH_BOOST) != null) {
                HealthBoost = player.getEffect(MobEffects.HEALTH_BOOST).getDuration();
            }else {
                HealthBoost = 0;
            }
            if (HealthBoost <= 60)
            {
                player.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 1200, 2));

            }
        }else {
            player.removeEffect(MobEffects.HEALTH_BOOST);
        }

        if (player.getInventory().getArmor(3).getItem() == Registration.Uranium_Helmet.get()) {
            player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 5));
        }
    }
}