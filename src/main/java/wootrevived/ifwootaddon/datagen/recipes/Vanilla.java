package wootrevived.ifwootaddon.datagen.recipes;

import com.buuz135.industrial.module.ModuleCore;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.registries.DeferredHolder;
import wootrevived.ifwootaddon.IFWootAddon;
import wootrevived.ifwootaddon.datagen.Recipes;
import wootrevived.ifwootaddon.registries.IFItemsRegistry;
import wootrevived.woot.registries.ItemsRegistry;

import java.util.Arrays;

public class Vanilla {
    public static void registerRecipes(Recipes recipes, RecipeOutput output){
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, IFItemsRegistry.STYGIAN_LASER_LENS_ITEM.get(), 1)
                .requires(Ingredient.of(Arrays.stream(ModuleCore.LASER_LENS).map(DeferredHolder::get).map(Item::getDefaultInstance)))
                .requires(ItemsRegistry.STYGIAN_INGOT_ITEM.get())
                .group(IFWootAddon.MOD_ID)
                .unlockedBy("0", recipes.hasItem(ItemsRegistry.STYGIAN_INGOT_ITEM.get()))
                .save(output, IFWootAddon.location("laser_lens_all"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, IFItemsRegistry.STYGIAN_LASER_LENS_ITEM.get(), 1)
                .requires(IFItemsRegistry.STYGIAN_LASER_LENS_ITEM.get())
                .requires(ItemsRegistry.STYGIAN_INGOT_ITEM.get())
                .group(IFWootAddon.MOD_ID)
                .unlockedBy("0", recipes.hasItem(IFItemsRegistry.STYGIAN_LASER_LENS_ITEM.get()))
                .unlockedBy("1", recipes.hasItem(ItemsRegistry.STYGIAN_INGOT_ITEM.get()))
                .save(output, IFWootAddon.location("laser_lens_self"));

        for(int i = 0; i < ModuleCore.LASER_LENS.length; i++){
            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModuleCore.LASER_LENS[i].get(), 1)
                    .requires(IFItemsRegistry.STYGIAN_LASER_LENS_ITEM.get())
                    .requires(DyeColor.byId(i).getTag())
                    .group(IFWootAddon.MOD_ID)
                    .unlockedBy("0", recipes.hasItem(IFItemsRegistry.STYGIAN_LASER_LENS_ITEM.get()))
                    .unlockedBy("1", recipes.hasItem(DyeColor.byId(i).getTag()))
                    .save(output, IFWootAddon.location("laser_lens_" + DyeColor.byId(i).getName()));
        }
    }
}
