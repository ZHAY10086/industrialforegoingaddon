package wootrevived.ifwootaddon.datagen.recipes;

import com.buuz135.industrial.module.ModuleAgricultureHusbandry;
import com.buuz135.industrial.module.ModuleCore;
import com.buuz135.industrial.module.ModuleResourceProduction;
import com.buuz135.industrial.recipe.DissolutionChamberRecipe;
import com.buuz135.industrial.recipe.LaserDrillFluidRecipe;
import com.buuz135.industrial.recipe.LaserDrillOreRecipe;
import com.buuz135.industrial.recipe.LaserDrillRarity;
import com.buuz135.industrial.utils.IndustrialTags;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.common.conditions.ItemExistsCondition;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import net.neoforged.neoforge.fluids.FluidStack;
import wootrevived.ifwootaddon.registries.IFItemsRegistry;
import wootrevived.ifwootaddon.upgrades.LaserDrill;
import wootrevived.ifwootaddon.upgrades.MobCrusher;
import wootrevived.ifwootaddon.upgrades.MobSlaughterFactory;
import wootrevived.woot.registries.FluidsRegistry;
import wootrevived.woot.registries.ItemsRegistry;
import wootrevived.woot.registries.UpgradeItemsRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class IndustrialForegoing {
    public static void registerRecipes(RecipeOutput output) {
        createDissolutionChamberRecipe(output, LaserDrill.LASER_DRILL_TAG, new DissolutionChamberRecipe(
                List.of(
                        Ingredient.of(UpgradeItemsRegistry.UPGRADE_BASE_ITEM.get()),
                        Ingredient.of(IndustrialTags.Items.MACHINE_FRAME_ADVANCED),
                        Ingredient.of(UpgradeItemsRegistry.UPGRADE_BASE_ITEM.get()),
                        Ingredient.of(ModuleResourceProduction.FLUID_LASER_BASE.getBlock()),
                        Ingredient.of(ModuleResourceProduction.FLUID_LASER_BASE.getBlock()),
                        Ingredient.of(IndustrialTags.Items.GEAR_DIAMOND),
                        Ingredient.of(ModuleResourceProduction.LASER_DRILL.getBlock()),
                        Ingredient.of(IndustrialTags.Items.GEAR_DIAMOND)
                ),
                new FluidStack(FluidsRegistry.SOURCE_VITALITY_FUEL_FLUID.get(), 2000),
                150,
                Optional.of(LaserDrill.LASER_DRILL_ITEM.get().getDefaultInstance()),
                Optional.empty()
        ));

        createDissolutionChamberRecipe(output, MobCrusher.MOB_CRUSHER_TAG, new DissolutionChamberRecipe(
                List.of(
                        Ingredient.of(UpgradeItemsRegistry.UPGRADE_BASE_ITEM.get()),
                        Ingredient.of(IndustrialTags.Items.MACHINE_FRAME_ADVANCED),
                        Ingredient.of(UpgradeItemsRegistry.UPGRADE_BASE_ITEM.get()),
                        Ingredient.of(ModuleAgricultureHusbandry.MOB_CRUSHER.getBlock()),
                        Ingredient.of(ModuleAgricultureHusbandry.MOB_CRUSHER.getBlock()),
                        Ingredient.of(Items.NETHERITE_SCRAP),
                        Ingredient.of(IndustrialTags.Items.GEAR_DIAMOND),
                        Ingredient.of(Items.NETHERITE_SCRAP)
                ),
                new FluidStack(FluidsRegistry.SOURCE_VITALITY_FUEL_FLUID.get(), 2000),
                150,
                Optional.of(MobCrusher.MOB_CRUSHER_ITEM.get().getDefaultInstance()),
                Optional.empty()
        ));

        createDissolutionChamberRecipe(output, MobSlaughterFactory.MOB_SLAUGHTER_FACTORY_TAG, new DissolutionChamberRecipe(
                List.of(
                        Ingredient.of(UpgradeItemsRegistry.UPGRADE_BASE_ITEM.get()),
                        Ingredient.of(IndustrialTags.Items.MACHINE_FRAME_SIMPLE),
                        Ingredient.of(UpgradeItemsRegistry.UPGRADE_BASE_ITEM.get()),
                        Ingredient.of(ModuleAgricultureHusbandry.SLAUGHTER_FACTORY.getBlock()),
                        Ingredient.of(ModuleAgricultureHusbandry.SLAUGHTER_FACTORY.getBlock()),
                        Ingredient.of(IndustrialTags.Items.GEAR_GOLD),
                        Ingredient.of(Items.REDSTONE),
                        Ingredient.of(IndustrialTags.Items.GEAR_GOLD)
                ),
                new FluidStack(FluidsRegistry.SOURCE_VITALITY_FUEL_FLUID.get(), 2000),
                150,
                Optional.of(MobSlaughterFactory.MOB_SLAUGHTER_FACTORY_ITEM.get().getDefaultInstance()),
                Optional.empty()
        ));

        createDissolutionChamberRecipe(output, IFItemsRegistry.STYGIAN_LASER_LENS_TAG, new DissolutionChamberRecipe(
                List.of(
                        Ingredient.of(Tags.Items.GLASS_PANES),
                        Ingredient.of(Tags.Items.GLASS_PANES),
                        Ingredient.of(Tags.Items.GLASS_PANES),
                        Ingredient.of(Tags.Items.GLASS_PANES),
                        Ingredient.of(new ItemStack(ItemsRegistry.STYGIAN_INGOT_ITEM.get()))
                ),
                new FluidStack(ModuleCore.LATEX.getSourceFluid().get(), 250),
                100,
                Optional.of(IFItemsRegistry.STYGIAN_LASER_LENS_ITEM.get().getDefaultInstance()),
                Optional.empty()
        ));

        createLaserDrillOreItemRecipe(
                output,
                ItemsRegistry.STYGIAN_DUST_ITEM.get(),
                2,
                new LaserDrillRarity(new LaserDrillRarity.BiomeRarity(List.of(), List.of()), new LaserDrillRarity.DimensionRarity(List.of(BuiltinDimensionTypes.NETHER), List.of()), 7, 117, 10)
        );

        createLaserDrillFluidRecipe(output, "warden_mob_tears", "minecraft", new LaserDrillFluidRecipe(
                new FluidStack(FluidsRegistry.SOURCE_MOB_TEARS_FLUID.get(), 30000),
                Ingredient.of(IFItemsRegistry.STYGIAN_LASER_LENS_ITEM.get()),
                ResourceLocation.fromNamespaceAndPath("minecraft", "warden"),
                new LaserDrillRarity[]{new LaserDrillRarity(new LaserDrillRarity.BiomeRarity(new ArrayList<>(), new ArrayList<>()), new LaserDrillRarity.DimensionRarity(new ArrayList<>(), new ArrayList<>()), -64, 256, 8)}
        ));
        createLaserDrillFluidRecipe(output, "wither_mob_tears", "minecraft", new LaserDrillFluidRecipe(
                new FluidStack(FluidsRegistry.SOURCE_MOB_TEARS_FLUID.get(), 20000),
                Ingredient.of(IFItemsRegistry.STYGIAN_LASER_LENS_ITEM.get()),
                ResourceLocation.fromNamespaceAndPath("minecraft", "wither"),
                new LaserDrillRarity[]{new LaserDrillRarity(new LaserDrillRarity.BiomeRarity(new ArrayList<>(), new ArrayList<>()), new LaserDrillRarity.DimensionRarity(new ArrayList<>(), new ArrayList<>()), -64, 256, 8)}
        ));
        createLaserDrillFluidRecipe(output, "ender_dragon_mob_tears", "minecraft", new LaserDrillFluidRecipe(
                new FluidStack(FluidsRegistry.SOURCE_MOB_TEARS_FLUID.get(), 10000),
                Ingredient.of(IFItemsRegistry.STYGIAN_LASER_LENS_ITEM.get()),
                ResourceLocation.fromNamespaceAndPath("minecraft", "ender_dragon"),
                new LaserDrillRarity[]{new LaserDrillRarity(new LaserDrillRarity.BiomeRarity(new ArrayList<>(), new ArrayList<>()), new LaserDrillRarity.DimensionRarity(new ArrayList<>(), new ArrayList<>()), -64, 256, 8)}
        ));
        createLaserDrillFluidRecipe(output, "wither_skeleton_mob_tears", "minecraft", new LaserDrillFluidRecipe(
                new FluidStack(FluidsRegistry.SOURCE_MOB_TEARS_FLUID.get(), 5000),
                Ingredient.of(IFItemsRegistry.STYGIAN_LASER_LENS_ITEM.get()),
                ResourceLocation.fromNamespaceAndPath("minecraft", "wither_skeleton"),
                new LaserDrillRarity[]{new LaserDrillRarity(new LaserDrillRarity.BiomeRarity(new ArrayList<>(), new ArrayList<>()), new LaserDrillRarity.DimensionRarity(new ArrayList<>(), new ArrayList<>()), -64, 256, 8)}
        ));
        createLaserDrillFluidRecipe(output, "ghast_mob_tears", "minecraft", new LaserDrillFluidRecipe(
                new FluidStack(FluidsRegistry.SOURCE_MOB_TEARS_FLUID.get(), 5000),
                Ingredient.of(IFItemsRegistry.STYGIAN_LASER_LENS_ITEM.get()),
                ResourceLocation.fromNamespaceAndPath("minecraft", "ghast"),
                new LaserDrillRarity[]{new LaserDrillRarity(new LaserDrillRarity.BiomeRarity(new ArrayList<>(), new ArrayList<>()), new LaserDrillRarity.DimensionRarity(new ArrayList<>(), new ArrayList<>()), -64, 256, 8)}
        ));
        createLaserDrillFluidRecipe(output, "enderman_mob_tears", "minecraft", new LaserDrillFluidRecipe(
                new FluidStack(FluidsRegistry.SOURCE_MOB_TEARS_FLUID.get(), 5000),
                Ingredient.of(IFItemsRegistry.STYGIAN_LASER_LENS_ITEM.get()),
                ResourceLocation.fromNamespaceAndPath("minecraft", "enderman"),
                new LaserDrillRarity[]{new LaserDrillRarity(new LaserDrillRarity.BiomeRarity(new ArrayList<>(), new ArrayList<>()), new LaserDrillRarity.DimensionRarity(new ArrayList<>(), new ArrayList<>()), -64, 256, 8)}
        ));
        createLaserDrillFluidRecipe(output, "blaze_mob_tears", "minecraft", new LaserDrillFluidRecipe(
                new FluidStack(FluidsRegistry.SOURCE_MOB_TEARS_FLUID.get(), 2000),
                Ingredient.of(IFItemsRegistry.STYGIAN_LASER_LENS_ITEM.get()),
                ResourceLocation.fromNamespaceAndPath("minecraft", "blaze"),
                new LaserDrillRarity[]{new LaserDrillRarity(new LaserDrillRarity.BiomeRarity(new ArrayList<>(), new ArrayList<>()), new LaserDrillRarity.DimensionRarity(new ArrayList<>(), new ArrayList<>()), -64, 256, 8)}
        ));
        createLaserDrillFluidRecipe(output, "zombie_mob_tears", "minecraft", new LaserDrillFluidRecipe(
                new FluidStack(FluidsRegistry.SOURCE_MOB_TEARS_FLUID.get(), 1000),
                Ingredient.of(IFItemsRegistry.STYGIAN_LASER_LENS_ITEM.get()),
                ResourceLocation.fromNamespaceAndPath("minecraft", "zombie"),
                new LaserDrillRarity[]{new LaserDrillRarity(new LaserDrillRarity.BiomeRarity(new ArrayList<>(), new ArrayList<>()), new LaserDrillRarity.DimensionRarity(new ArrayList<>(), new ArrayList<>()), -64, 256, 8)}
        ));
        createLaserDrillFluidRecipe(output, "skeleton_mob_tears", "minecraft", new LaserDrillFluidRecipe(
                new FluidStack(FluidsRegistry.SOURCE_MOB_TEARS_FLUID.get(), 1000),
                Ingredient.of(IFItemsRegistry.STYGIAN_LASER_LENS_ITEM.get()),
                ResourceLocation.fromNamespaceAndPath("minecraft", "skeleton"),
                new LaserDrillRarity[]{new LaserDrillRarity(new LaserDrillRarity.BiomeRarity(new ArrayList<>(), new ArrayList<>()), new LaserDrillRarity.DimensionRarity(new ArrayList<>(), new ArrayList<>()), -64, 256, 8)}
        ));
        createLaserDrillFluidRecipe(output, "creeper_mob_tears", "minecraft", new LaserDrillFluidRecipe(
                new FluidStack(FluidsRegistry.SOURCE_MOB_TEARS_FLUID.get(), 1000),
                Ingredient.of(IFItemsRegistry.STYGIAN_LASER_LENS_ITEM.get()),
                ResourceLocation.fromNamespaceAndPath("minecraft", "creeper"),
                new LaserDrillRarity[]{new LaserDrillRarity(new LaserDrillRarity.BiomeRarity(new ArrayList<>(), new ArrayList<>()), new LaserDrillRarity.DimensionRarity(new ArrayList<>(), new ArrayList<>()), -64, 256, 8)}
        ));
        createLaserDrillFluidRecipe(output, "spider_mob_tears", "minecraft", new LaserDrillFluidRecipe(
                new FluidStack(FluidsRegistry.SOURCE_MOB_TEARS_FLUID.get(), 1000),
                Ingredient.of(IFItemsRegistry.STYGIAN_LASER_LENS_ITEM.get()),
                ResourceLocation.fromNamespaceAndPath("minecraft", "spider"),
                new LaserDrillRarity[]{new LaserDrillRarity(new LaserDrillRarity.BiomeRarity(new ArrayList<>(), new ArrayList<>()), new LaserDrillRarity.DimensionRarity(new ArrayList<>(), new ArrayList<>()), -64, 256, 8)}
        ));
        createLaserDrillFluidRecipe(output, "cow_mob_tears", "minecraft", new LaserDrillFluidRecipe(
                new FluidStack(FluidsRegistry.SOURCE_MOB_TEARS_FLUID.get(), 500),
                Ingredient.of(IFItemsRegistry.STYGIAN_LASER_LENS_ITEM.get()),
                ResourceLocation.fromNamespaceAndPath("minecraft", "cow"),
                new LaserDrillRarity[]{new LaserDrillRarity(new LaserDrillRarity.BiomeRarity(new ArrayList<>(), new ArrayList<>()), new LaserDrillRarity.DimensionRarity(new ArrayList<>(), new ArrayList<>()), -64, 256, 8)}
        ));
        createLaserDrillFluidRecipe(output, "sheep_mob_tears", "minecraft", new LaserDrillFluidRecipe(
                new FluidStack(FluidsRegistry.SOURCE_MOB_TEARS_FLUID.get(), 500),
                Ingredient.of(IFItemsRegistry.STYGIAN_LASER_LENS_ITEM.get()),
                ResourceLocation.fromNamespaceAndPath("minecraft", "sheep"),
                new LaserDrillRarity[]{new LaserDrillRarity(new LaserDrillRarity.BiomeRarity(new ArrayList<>(), new ArrayList<>()), new LaserDrillRarity.DimensionRarity(new ArrayList<>(), new ArrayList<>()), -64, 256, 8)}
        ));
        createLaserDrillFluidRecipe(output, "chicken_mob_tears", "minecraft", new LaserDrillFluidRecipe(
                new FluidStack(FluidsRegistry.SOURCE_MOB_TEARS_FLUID.get(), 500),
                Ingredient.of(IFItemsRegistry.STYGIAN_LASER_LENS_ITEM.get()),
                ResourceLocation.fromNamespaceAndPath("minecraft", "chicken"),
                new LaserDrillRarity[]{new LaserDrillRarity(new LaserDrillRarity.BiomeRarity(new ArrayList<>(), new ArrayList<>()), new LaserDrillRarity.DimensionRarity(new ArrayList<>(), new ArrayList<>()), -64, 256, 8)}
        ));
        createLaserDrillFluidRecipe(output, "pig_mob_tears", "minecraft", new LaserDrillFluidRecipe(
                new FluidStack(FluidsRegistry.SOURCE_MOB_TEARS_FLUID.get(), 500),
                Ingredient.of(IFItemsRegistry.STYGIAN_LASER_LENS_ITEM.get()),
                ResourceLocation.fromNamespaceAndPath("minecraft", "pig"),
                new LaserDrillRarity[]{new LaserDrillRarity(new LaserDrillRarity.BiomeRarity(new ArrayList<>(), new ArrayList<>()), new LaserDrillRarity.DimensionRarity(new ArrayList<>(), new ArrayList<>()), -64, 256, 8)}
        ));
    }

    public static void createDissolutionChamberRecipe(RecipeOutput recipeOutput, String name, DissolutionChamberRecipe recipe) {
        ResourceLocation rl = ResourceLocation.fromNamespaceAndPath("ifwootaddon", "dissolution_chamber/" + name);
        AdvancementHolder advancementHolder = recipeOutput.advancement().addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(rl)).rewards(AdvancementRewards.Builder.recipe(rl)).requirements(AdvancementRequirements.Strategy.OR).build(rl);
        List<ICondition> conditions = new ArrayList<>();
        if (recipe.output.isPresent()) {
            conditions.add(new ItemExistsCondition(BuiltInRegistries.ITEM.getKey(((ItemStack)recipe.output.get()).getItem())));
        }

        recipeOutput.accept(rl, recipe, advancementHolder, conditions.toArray(new ICondition[conditions.size()]));
    }

    public static void createLaserDrillOreItemRecipe(RecipeOutput recipeOutput, ItemLike itemLike, int color, LaserDrillRarity... rarity) {
        Ingredient output = Ingredient.of(new ItemLike[]{itemLike});
        LaserDrillOreRecipe recipe = new LaserDrillOreRecipe(output, color, rarity);
        ResourceLocation rl = ResourceLocation.fromNamespaceAndPath("ifwootaddon", "laser_drill_ore/" + BuiltInRegistries.ITEM.getKey(itemLike.asItem()).getPath());
        AdvancementHolder advancementHolder = recipeOutput.advancement().addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(rl)).rewards(AdvancementRewards.Builder.recipe(rl)).requirements(AdvancementRequirements.Strategy.OR).build(rl);
        recipeOutput.accept(rl, recipe, advancementHolder);
    }

    public static void createLaserDrillFluidRecipe(RecipeOutput recipeOutput, String name, String modIdCondition, LaserDrillFluidRecipe recipe) {
        ResourceLocation rl = ResourceLocation.fromNamespaceAndPath("ifwootaddon", "laser_drill_fluid/" + name);
        AdvancementHolder advancementHolder = recipeOutput.advancement().addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(rl)).rewards(AdvancementRewards.Builder.recipe(rl)).requirements(AdvancementRequirements.Strategy.OR).build(rl);
        recipeOutput.accept(rl, recipe, advancementHolder, new ICondition[]{new ModLoadedCondition(modIdCondition)});
    }
}
