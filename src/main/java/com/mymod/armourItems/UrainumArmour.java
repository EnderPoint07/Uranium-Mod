package com.mymod.armourItems;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.mymod.MyMod;
import com.mymod.Registration;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.TickTask;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.ServerLifecycleHooks;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Mod.EventBusSubscriber(modid = MyMod.MODID)
public class UrainumArmour extends ArmorItem {

    private static final UUID HEALTH_MODIFIER_UUID = UUID.fromString("021e9046-8014-4019-a87f-a0e797c33163");
    Multimap<Attribute, AttributeModifier> defaultModifiers;

    List<Map.Entry<Attribute, AttributeModifier>> entries = new ArrayList<>();

    public UrainumArmour(ArmorMaterial pMaterial, EquipmentSlot pSlot, Properties pProperties) {
        super(pMaterial, pSlot, pProperties);
        if(slot == EquipmentSlot.CHEST) {
            ImmutableMultimap.Builder<Attribute, AttributeModifier> b = new ImmutableMultimap.Builder<>();
            for (Map.Entry<Attribute, AttributeModifier> entry : super.getDefaultAttributeModifiers(slot).entries())
                b.put(entry);
            b.put(Attributes.MAX_HEALTH, new AttributeModifier(HEALTH_MODIFIER_UUID, "generic.max_health", 20, AttributeModifier.Operation.ADDITION));
            defaultModifiers = b.build();
        } else {
            defaultModifiers = super.getDefaultAttributeModifiers(slot);
        }
    }

    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {

        if (player.getInventory().getArmor(0).getItem() == Registration.Uranium_Boots.get()) {
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, 1));
        }
        if (player.getInventory().getArmor(1).getItem() == Registration.Uranium_Leggings.get()) {
            player.addEffect(new MobEffectInstance(MobEffects.JUMP, 60, 2));
        }

        if (player.getInventory().getArmor(3).getItem() == Registration.Uranium_Helmet.get()) {
            player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 2));
        }
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        return slot == this.slot ? this.defaultModifiers : super.getDefaultAttributeModifiers(slot);
    }

    @SubscribeEvent
    static void onEquip(LivingEquipmentChangeEvent event) {
        LivingEntity entity = event.getEntityLiving();
        if (!entity.getLevel().isClientSide && event.getFrom().is(Registration.Uranium_ChestPlate.get())) {
            MinecraftServer server = ServerLifecycleHooks.getCurrentServer();
            server.tell(new TickTask(server.getTickCount(), () -> {
                if (entity.getHealth() > entity.getMaxHealth())
                    entity.setHealth(entity.getMaxHealth());
            }));
        }
    }

}