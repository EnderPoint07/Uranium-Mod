package com.mymod;

import com.mymod.armourItems.UrainumArmour;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Registration {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MyMod.MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MyMod.MODID);

    public static void init()
    {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(bus);
        ITEMS.register(bus);

    }

    public static final RegistryObject<Block> UraniumBlock = BLOCKS.register("uraniumblock", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).noOcclusion().strength(2).sound(SoundType.AMETHYST).lightLevel(value -> 20).requiresCorrectToolForDrops()));
        public static final RegistryObject<Item> UraniumBlock_Item = fromBlock(UraniumBlock, new Item.Properties().tab(MyMod.UraniumMod_Tab).rarity(Rarity.EPIC).stacksTo(64));

    public static final RegistryObject<Block> UraniumOre = BLOCKS.register("uranium_ore", () -> new OreBlock(BlockBehaviour.Properties.of(Material.METAL).strength(2.2f).sound(SoundType.METAL).lightLevel(value -> 5).requiresCorrectToolForDrops()));
        public static final RegistryObject<Item> UraniumOre_Item = fromBlock(UraniumOre, new Item.Properties().tab(MyMod.UraniumMod_Tab).stacksTo(64).rarity(Rarity.UNCOMMON));

    public static final RegistryObject<Item> UraniumShards = ITEMS.register("uranium_shard", () -> new Item(new Item.Properties().stacksTo(64).tab(MyMod.UraniumMod_Tab).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> RawUranium = ITEMS.register("raw_uranium", () -> new Item(new Item.Properties().rarity(Rarity.RARE).tab(MyMod.UraniumMod_Tab   ).stacksTo(68)));

    public static final RegistryObject<ArmorItem> Uranium_Helmet  = ITEMS.register("uranium_helmet", () -> new UrainumArmour( ArmorMaterialInit.URANIUM , EquipmentSlot.HEAD, new Item.Properties().tab(MyMod.UraniumMod_Tab).stacksTo(1).rarity(Rarity.EPIC).fireResistant()));
    public static final RegistryObject<ArmorItem> Uranium_ChestPlate  = ITEMS.register("uranium_chestplate", () -> new UrainumArmour( ArmorMaterialInit.URANIUM , EquipmentSlot.CHEST, new Item.Properties().tab(MyMod.UraniumMod_Tab).stacksTo(1).rarity(Rarity.EPIC).fireResistant()));
    public static final RegistryObject<ArmorItem> Uranium_Leggings  = ITEMS.register("uranium_leggings", () -> new UrainumArmour( ArmorMaterialInit.URANIUM , EquipmentSlot.LEGS, new Item.Properties().tab(MyMod.UraniumMod_Tab).stacksTo(1).rarity(Rarity.EPIC).fireResistant()));
    public static final RegistryObject<ArmorItem> Uranium_Boots = ITEMS.register("uranium_boots", () -> new UrainumArmour( ArmorMaterialInit.URANIUM , EquipmentSlot.FEET, new Item.Properties().tab(MyMod.UraniumMod_Tab).stacksTo(1).rarity(Rarity.EPIC).fireResistant()));

    public static <B extends Block> RegistryObject<Item> fromBlock(RegistryObject<B> block, Item.Properties properties)
    {
        return ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), properties));
    }
}