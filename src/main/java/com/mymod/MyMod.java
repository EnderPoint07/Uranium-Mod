package com.mymod;

import com.mymod.world.gen.OreGen;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MyMod.MODID)
public class MyMod
{
    public static final String MODID = "mymod";

        // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public static final String TAB_NAME = "Uranium Mod";

    public static final CreativeModeTab UraniumMod_Tab = new CreativeModeTab(TAB_NAME) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.DIAMOND);
        }
    };

    public MyMod() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        Registration.init();
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());

        event.enqueueWork(OreGen::registerConfiguredFeatures);

    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("MyMod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.messageSupplier().get()).
                collect(Collectors.toList()));
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {

            //public static final Block UraniumBlock = new Block(BlockBehaviour.Properties.of(Material.METAL).noOcclusion().strength(2).sound(SoundType.AMETHYST).lightLevel(value -> 20).requiresCorrectToolForDrops()).setRegistryName(MODID, "uraniumblock");
       // public static final Block UraniumOre = new OreBlock(BlockBehaviour.Properties.of(Material.METAL).strength(2.2f).sound(SoundType.METAL).lightLevel(value -> 5).requiresCorrectToolForDrops()).setRegistryName("uranium_ore");

        //public static final Item UraniumShards = new Item(new Item.Properties().stacksTo(64).tab(UraniumMod_Tab).rarity(Rarity.RARE)).setRegistryName(MODID, "uranium_shard");
        //public static final Item RawUranium = new Item((new Item.Properties().rarity(Rarity.RARE).tab(UraniumMod_Tab).stacksTo(68))).setRegistryName(MODID, "raw_uranium");

        @SubscribeEvent
            public static void RegisterBlocks(final RegistryEvent.Register<Block> event) {
            // register a new block here
            //event.getRegistry().register(UraniumBlock);
            //event.getRegistry().register(UraniumOre);

            LOGGER.info("HELLO from Register Block");


        }

        @SubscribeEvent
        public static void  RegisterItemBlocks(final RegistryEvent.Register<Item> event) {
            //event.getRegistry().register(new BlockItem(RegistryEvents.UraniumBlock, new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS).rarity(Rarity.EPIC).stacksTo(64)).setRegistryName(UraniumBlock.getRegistryName()));
            //event.getRegistry().register(new BlockItem(RegistryEvents.UraniumOre, new Item.Properties().tab(UraniumMod_Tab).stacksTo(64).rarity(Rarity.UNCOMMON)).setRegistryName(UraniumOre.getRegistryName()));

            //event.getRegistry().register(UraniumShards);
            //event.getRegistry().register(RawUranium);
        }

    }
}
