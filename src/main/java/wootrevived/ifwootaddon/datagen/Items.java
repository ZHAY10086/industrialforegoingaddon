package wootrevived.ifwootaddon.datagen;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.loaders.DynamicFluidContainerModelBuilder;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;
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
        return Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(item)).withPrefix("item/");
    }

    public ResourceLocation getBlockResource(Block block){
        return Objects.requireNonNull(BuiltInRegistries.BLOCK.getKey(block)).withPrefix("block/");
    }

    public void itemBucket(DeferredHolder<Item, ? extends Item> item, DeferredHolder<Fluid, ? extends Fluid> fluid){
        ResourceLocation itemResource = getItemResource(item.get());
        getBuilder(itemResource.getPath())
                .parent(getExistingFile(ResourceLocation.tryBuild("neoforge", "item/bucket")))
                .customLoader(DynamicFluidContainerModelBuilder::begin)
                .fluid(fluid.get());
    }

    public void parentedBlock(DeferredHolder<Item, ? extends Item> item, DeferredHolder<Block, ? extends Block> block){
        ResourceLocation itemResource = getItemResource(item.get());
        ResourceLocation blockResource = getBlockResource(block.get());
        getBuilder(itemResource.getPath())
                .parent(getExistingFile(blockResource));
    }

    public void itemGenerated(DeferredHolder<Item, ? extends Item> item){
        ResourceLocation itemResource = getItemResource(item.get());
        getBuilder(itemResource.getPath())
                .parent(getExistingFile(mcLoc("item/generated")))
                .texture("layer0", itemResource);
    }

    public void itemGenerated(DeferredHolder<Item, ? extends Item> item, ResourceLocation texture){
        ResourceLocation itemResource = getItemResource(item.get());
        getBuilder(itemResource.getPath())
                .parent(getExistingFile(mcLoc("item/generated")))
                .texture("layer0", texture);
    }

    public void itemHandheld(DeferredHolder<Item, ? extends Item> item){
        ResourceLocation itemResource = getItemResource(item.get());
        getBuilder(itemResource.getPath())
                .parent(getExistingFile(mcLoc("item/handheld")))
                .texture("layer0", itemResource);
    }
}