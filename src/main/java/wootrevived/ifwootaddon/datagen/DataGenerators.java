package wootrevived.ifwootaddon.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import wootrevived.ifwootaddon.IFWootAddon;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = IFWootAddon.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        PackOutput packOutput = generator.getPackOutput();
        if(event.includeServer()) {
            generator.addProvider(true, new Recipes(packOutput, lookupProvider));
        }
        if(event.includeClient()) {
            generator.addProvider(true, new Items(packOutput, existingFileHelper));
            generator.addProvider(true, new Languages(packOutput));
        }
    }
}