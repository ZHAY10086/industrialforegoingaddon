package wootrevived.ifwootaddon.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.loaders.DynamicFluidContainerModelBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import wootrevived.ifwootaddon.IFWootAddon;
import wootrevived.ifwootaddon.registries.IFItemsRegistry;
import wootrevived.ifwootaddon.upgrades.LaserDrill;
import wootrevived.ifwootaddon.upgrades.MobCrusher;
import wootrevived.ifwootaddon.upgrades.MobSlaughterFactory;

import java.util.Objects;

public class Items extends ItemModelProvider {
    public Items(PackOutput packOutput, ExistingFileHelper existingFileHelper) {
        super(packOutput, IFWootAddon.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        itemGenerated(MobCrusher.MOB_CRUSHER_ITEM);
        itemGenerated(MobSlaughterFactory.MOB_SLAUGHTER_FACTORY_ITEM);
        itemGenerated(LaserDrill.LASER_DRILL_ITEM);
        itemGenerated(IFItemsRegistry.STYGIAN_LASER_LENS_ITEM);
    }

    public ResourceLocation getItemResource(Item item){
        return Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item)).withPrefix("item/");
    }

    public ResourceLocation getBlockResource(Block block){
        return Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block)).withPrefix("block/");
    }

    public void itemBucket(RegistryObject<?> item, RegistryObject<?> fluid){
        ResourceLocation itemResource = getItemResource((Item) item.get());
        getBuilder(itemResource.getPath())
                .parent(getExistingFile(ResourceLocation.tryBuild("forge", "item/bucket")))
                .customLoader(DynamicFluidContainerModelBuilder::begin)
                .fluid((Fluid)fluid.get());
    }

    public void parentedBlock(RegistryObject<?> item, RegistryObject<?> block){
        ResourceLocation itemResource = getItemResource((Item) item.get());
        ResourceLocation blockResource = getBlockResource((Block) block.get());
        getBuilder(itemResource.getPath())
                .parent(getExistingFile(blockResource));
    }

    public void itemGenerated(RegistryObject<?> item){
        ResourceLocation itemResource = getItemResource((Item) item.get());
        getBuilder(itemResource.getPath())
                .parent(getExistingFile(mcLoc("item/generated")))
                .texture("layer0", itemResource);
    }

    public void itemGenerated(RegistryObject<?> item, ResourceLocation texture){
        ResourceLocation itemResource = getItemResource((Item) item.get());
        getBuilder(itemResource.getPath())
                .parent(getExistingFile(mcLoc("item/generated")))
                .texture("layer0", texture);
    }

    public void itemHandheld(RegistryObject<?> item){
        ResourceLocation itemResource = getItemResource((Item) item.get());
        getBuilder(itemResource.getPath())
                .parent(getExistingFile(mcLoc("item/handheld")))
                .texture("layer0", itemResource);
    }
}