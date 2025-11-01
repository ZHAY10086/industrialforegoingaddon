package wootrevived.ifwootaddon.upgrades;

import com.buuz135.industrial.module.ModuleCore;
import com.buuz135.industrial.recipe.LaserDrillFluidRecipe;
import com.hrznstudio.titanium.util.RecipeUtil;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.Item;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import wootrevived.api.WootUpgradeItem;
import wootrevived.api.interfaces.WootDropsProperties;
import wootrevived.api.registrations.WootUpgradeItemRegistration;
import wootrevived.ifwootaddon.IFWootAddon;

import java.util.List;

public class LaserDrill extends WootUpgradeItem {
    public LaserDrill(int level) { super(new Properties(), level); }

    @Override
    @SuppressWarnings("unchecked")
    public void modifyDrops(WootDropsProperties properties, CompoundTag upgradeTag) {
        List<FluidStack> fluids = properties.getFluidDrops();

        List<LaserDrillFluidRecipe> fluidRecipes = (List<LaserDrillFluidRecipe>) RecipeUtil.getRecipes(properties.getLevel(), ModuleCore.LASER_DRILL_FLUID_TYPE.get());
        for(LaserDrillFluidRecipe recipe : fluidRecipes){
            if(!recipe.entity.equals(LaserDrillFluidRecipe.EMPTY) &&
                    recipe.entity.equals(ForgeRegistries.ENTITY_TYPES.getKey(properties.getFactoryMob().getEntityType()))){
                fluids.add(FluidStack.loadFluidStackFromNBT(recipe.output));
            }
        }
    }

    /* Upgrade Item registration */

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.Keys.ITEMS, IFWootAddon.MOD_ID);

    public static void register(WootUpgradeItemRegistration registration){
        ITEMS.register(registration.getWootEventBus());
        registration.register(LASER_DRILL_ITEM);
    }

    public static final String LASER_DRILL_TAG = "laser_drill_upgrade";
    public static final RegistryObject<LaserDrill> LASER_DRILL_ITEM = ITEMS.register(LASER_DRILL_TAG, () -> new LaserDrill(1));
}
