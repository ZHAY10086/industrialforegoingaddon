package wootrevived.ifwootaddon.datagen.recipes;

import com.buuz135.industrial.module.ModuleAgricultureHusbandry;
import com.buuz135.industrial.module.ModuleResourceProduction;
import com.buuz135.industrial.recipe.DissolutionChamberRecipe;
import com.buuz135.industrial.recipe.LaserDrillFluidRecipe;
import com.buuz135.industrial.recipe.LaserDrillOreRecipe;
import com.buuz135.industrial.recipe.LaserDrillRarity;
import com.buuz135.industrial.utils.IndustrialTags;
import com.hrznstudio.titanium.recipe.generator.IJSONGenerator;
import com.hrznstudio.titanium.recipe.generator.IJsonFile;
import com.hrznstudio.titanium.recipe.generator.TitaniumSerializableProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.fluids.FluidStack;
import wootrevived.ifwootaddon.IFWootAddon;
import wootrevived.ifwootaddon.upgrades.LaserDrill;
import wootrevived.ifwootaddon.upgrades.MobCrusher;
import wootrevived.ifwootaddon.upgrades.MobSlaughterFactory;
import wootrevived.woot.registries.FluidsRegistry;
import wootrevived.woot.registries.ItemsRegistry;
import wootrevived.woot.registries.UpgradeItemsRegistry;

import java.util.Map;

public class IFWootSerializableProvider extends TitaniumSerializableProvider {
    public IFWootSerializableProvider(DataGenerator generatorIn) {
        super(generatorIn, IFWootAddon.MOD_ID);
    }

    @Override
    public void add(Map<IJsonFile, IJSONGenerator> serializables) {
        new DissolutionChamberRecipe(
                IFWootAddon.location(LaserDrill.LASER_DRILL_TAG),
                new Ingredient.Value[]{
                        new Ingredient.ItemValue(new ItemStack(UpgradeItemsRegistry.UPGRADE_BASE_ITEM.get())),
                        new Ingredient.TagValue(IndustrialTags.Items.MACHINE_FRAME_ADVANCED),
                        new Ingredient.ItemValue(new ItemStack(UpgradeItemsRegistry.UPGRADE_BASE_ITEM.get())),
                        new Ingredient.ItemValue(new ItemStack(ModuleResourceProduction.FLUID_LASER_BASE.getKey().get())),
                        new Ingredient.ItemValue(new ItemStack(ModuleResourceProduction.FLUID_LASER_BASE.getKey().get())),
                        new Ingredient.TagValue(IndustrialTags.Items.GEAR_DIAMOND),
                        new Ingredient.ItemValue(new ItemStack(ModuleResourceProduction.LASER_DRILL.getKey().get())),
                        new Ingredient.TagValue(IndustrialTags.Items.GEAR_DIAMOND),
                },
                new FluidStack(FluidsRegistry.SOURCE_VITALITY_FUEL_FLUID.get(), 2000),
                150,
                new ItemStack(LaserDrill.LASER_DRILL_ITEM.get()),
                FluidStack.EMPTY
        );
        new DissolutionChamberRecipe(
                IFWootAddon.location(MobCrusher.MOB_CRUSHER_TAG),
                new Ingredient.Value[]{
                        new Ingredient.ItemValue(new ItemStack(UpgradeItemsRegistry.UPGRADE_BASE_ITEM.get())),
                        new Ingredient.TagValue(IndustrialTags.Items.MACHINE_FRAME_ADVANCED),
                        new Ingredient.ItemValue(new ItemStack(UpgradeItemsRegistry.UPGRADE_BASE_ITEM.get())),
                        new Ingredient.ItemValue(new ItemStack(ModuleAgricultureHusbandry.MOB_CRUSHER.getKey().get())),
                        new Ingredient.ItemValue(new ItemStack(ModuleAgricultureHusbandry.MOB_CRUSHER.getKey().get())),
                        new Ingredient.ItemValue(new ItemStack(Items.NETHERITE_SCRAP)),
                        new Ingredient.TagValue(IndustrialTags.Items.GEAR_DIAMOND),
                        new Ingredient.ItemValue(new ItemStack(Items.NETHERITE_SCRAP)),
                },
                new FluidStack(FluidsRegistry.SOURCE_VITALITY_FUEL_FLUID.get(), 2000),
                150,
                new ItemStack(MobCrusher.MOB_CRUSHER_ITEM.get()),
                FluidStack.EMPTY
        );
        new DissolutionChamberRecipe(
                IFWootAddon.location(MobSlaughterFactory.MOB_SLAUGHTER_FACTORY_TAG),
                new Ingredient.Value[]{
                        new Ingredient.ItemValue(new ItemStack(UpgradeItemsRegistry.UPGRADE_BASE_ITEM.get())),
                        new Ingredient.TagValue(IndustrialTags.Items.MACHINE_FRAME_SIMPLE),
                        new Ingredient.ItemValue(new ItemStack(UpgradeItemsRegistry.UPGRADE_BASE_ITEM.get())),
                        new Ingredient.ItemValue(new ItemStack(ModuleAgricultureHusbandry.SLAUGHTER_FACTORY.getKey().get())),
                        new Ingredient.ItemValue(new ItemStack(ModuleAgricultureHusbandry.SLAUGHTER_FACTORY.getKey().get())),
                        new Ingredient.TagValue(IndustrialTags.Items.GEAR_GOLD),
                        new Ingredient.ItemValue(new ItemStack(Items.REDSTONE)),
                        new Ingredient.TagValue(IndustrialTags.Items.GEAR_GOLD),
                },
                new FluidStack(FluidsRegistry.SOURCE_VITALITY_FUEL_FLUID.get(), 2000),
                150,
                new ItemStack(MobSlaughterFactory.MOB_SLAUGHTER_FACTORY_ITEM.get()),
                FluidStack.EMPTY
        );
        DissolutionChamberRecipe.RECIPES.forEach(dissolutionChamberRecipe -> serializables.put(dissolutionChamberRecipe, dissolutionChamberRecipe));

        LaserDrillOreRecipe.createNether(
                ItemsRegistry.STYGIAN_DUST_TAG,
                Ingredient.of(ItemsRegistry.STYGIAN_DUST_ITEM.get()),
                2, 7, 117, 10, null
        );
        LaserDrillOreRecipe.RECIPES.forEach(dissolutionChamberRecipe -> serializables.put(dissolutionChamberRecipe, dissolutionChamberRecipe));

        new LaserDrillFluidRecipe(
                "warden",
                new FluidStack(FluidsRegistry.SOURCE_MOB_TEARS_FLUID.get(), 30000).writeToNBT(new CompoundTag()),
                10,
                new ResourceLocation("minecraft", "warden"),
                new LaserDrillRarity[]{new LaserDrillRarity(new ResourceKey[0], new ResourceKey[0], -64, 256, 8)}
        );
        new LaserDrillFluidRecipe(
                "wither",
                new FluidStack(FluidsRegistry.SOURCE_MOB_TEARS_FLUID.get(), 20000).writeToNBT(new CompoundTag()),
                10,
                new ResourceLocation("minecraft", "wither"),
                new LaserDrillRarity[]{new LaserDrillRarity(new ResourceKey[0], new ResourceKey[0], -64, 256, 8)}
        );
        new LaserDrillFluidRecipe(
                "ender_dragon",
                new FluidStack(FluidsRegistry.SOURCE_MOB_TEARS_FLUID.get(), 10000).writeToNBT(new CompoundTag()),
                10,
                new ResourceLocation("minecraft", "ender_dragon"),
                new LaserDrillRarity[]{new LaserDrillRarity(new ResourceKey[0], new ResourceKey[0], -64, 256, 8)}
        );
        new LaserDrillFluidRecipe(
                "wither_skeleton",
                new FluidStack(FluidsRegistry.SOURCE_MOB_TEARS_FLUID.get(), 5000).writeToNBT(new CompoundTag()),
                10,
                new ResourceLocation("minecraft", "wither_skeleton"),
                new LaserDrillRarity[]{new LaserDrillRarity(new ResourceKey[0], new ResourceKey[0], -64, 256, 8)}
        );
        new LaserDrillFluidRecipe(
                "ghast",
                new FluidStack(FluidsRegistry.SOURCE_MOB_TEARS_FLUID.get(), 5000).writeToNBT(new CompoundTag()),
                10,
                new ResourceLocation("minecraft", "ghast"),
                new LaserDrillRarity[]{new LaserDrillRarity(new ResourceKey[0], new ResourceKey[0], -64, 256, 8)}
        );
        new LaserDrillFluidRecipe(
                "enderman",
                new FluidStack(FluidsRegistry.SOURCE_MOB_TEARS_FLUID.get(), 5000).writeToNBT(new CompoundTag()),
                10,
                new ResourceLocation("minecraft", "enderman"),
                new LaserDrillRarity[]{new LaserDrillRarity(new ResourceKey[0], new ResourceKey[0], -64, 256, 8)}
        );
        new LaserDrillFluidRecipe(
                "blaze",
                new FluidStack(FluidsRegistry.SOURCE_MOB_TEARS_FLUID.get(), 2000).writeToNBT(new CompoundTag()),
                10,
                new ResourceLocation("minecraft", "blaze"),
                new LaserDrillRarity[]{new LaserDrillRarity(new ResourceKey[0], new ResourceKey[0], -64, 256, 8)}
        );
        new LaserDrillFluidRecipe(
                "zombie",
                new FluidStack(FluidsRegistry.SOURCE_MOB_TEARS_FLUID.get(), 1000).writeToNBT(new CompoundTag()),
                10,
                new ResourceLocation("minecraft", "zombie"),
                new LaserDrillRarity[]{new LaserDrillRarity(new ResourceKey[0], new ResourceKey[0], -64, 256, 8)}
        );
        new LaserDrillFluidRecipe(
                "skeleton",
                new FluidStack(FluidsRegistry.SOURCE_MOB_TEARS_FLUID.get(), 1000).writeToNBT(new CompoundTag()),
                10,
                new ResourceLocation("minecraft", "skeleton"),
                new LaserDrillRarity[]{new LaserDrillRarity(new ResourceKey[0], new ResourceKey[0], -64, 256, 8)}
        );
        new LaserDrillFluidRecipe(
                "creeper",
                new FluidStack(FluidsRegistry.SOURCE_MOB_TEARS_FLUID.get(), 1000).writeToNBT(new CompoundTag()),
                10,
                new ResourceLocation("minecraft", "creeper"),
                new LaserDrillRarity[]{new LaserDrillRarity(new ResourceKey[0], new ResourceKey[0], -64, 256, 8)}
        );
        new LaserDrillFluidRecipe(
                "spider",
                new FluidStack(FluidsRegistry.SOURCE_MOB_TEARS_FLUID.get(), 1000).writeToNBT(new CompoundTag()),
                10,
                new ResourceLocation("minecraft", "spider"),
                new LaserDrillRarity[]{new LaserDrillRarity(new ResourceKey[0], new ResourceKey[0], -64, 256, 8)}
        );
        new LaserDrillFluidRecipe(
                "cow",
                new FluidStack(FluidsRegistry.SOURCE_MOB_TEARS_FLUID.get(), 500).writeToNBT(new CompoundTag()),
                10,
                new ResourceLocation("minecraft", "cow"),
                new LaserDrillRarity[]{new LaserDrillRarity(new ResourceKey[0], new ResourceKey[0], -64, 256, 8)}
        );
        new LaserDrillFluidRecipe(
                "sheep",
                new FluidStack(FluidsRegistry.SOURCE_MOB_TEARS_FLUID.get(), 500).writeToNBT(new CompoundTag()),
                10,
                new ResourceLocation("minecraft", "sheep"),
                new LaserDrillRarity[]{new LaserDrillRarity(new ResourceKey[0], new ResourceKey[0], -64, 256, 8)}
        );
        new LaserDrillFluidRecipe(
                "chicken",
                new FluidStack(FluidsRegistry.SOURCE_MOB_TEARS_FLUID.get(), 500).writeToNBT(new CompoundTag()),
                10,
                new ResourceLocation("minecraft", "chicken"),
                new LaserDrillRarity[]{new LaserDrillRarity(new ResourceKey[0], new ResourceKey[0], -64, 256, 8)}
        );
        new LaserDrillFluidRecipe(
                "pig",
                new FluidStack(FluidsRegistry.SOURCE_MOB_TEARS_FLUID.get(), 500).writeToNBT(new CompoundTag()),
                10,
                new ResourceLocation("minecraft", "pig"),
                new LaserDrillRarity[]{new LaserDrillRarity(new ResourceKey[0], new ResourceKey[0], -64, 256, 8)}
        );
        LaserDrillFluidRecipe.RECIPES.forEach(dissolutionChamberRecipe -> serializables.put(dissolutionChamberRecipe, dissolutionChamberRecipe));

    }
}
