package wootrevived.ifwootaddon.upgrades;

import com.buuz135.industrial.module.ModuleCore;
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

public class MobCrusher extends WootUpgradeItem {
    public MobCrusher(int level) { super(new Properties(), level); }

    @Override
    public void modifyDrops(WootDropsProperties properties, CompoundTag upgradeTag) {
        int experience = properties.getExperience() * 20;
        if(experience <= 0)
            return;
        properties.setExperience(0);

        List<FluidStack> fluids = properties.getFluidDrops();
        fluids.add(new FluidStack(ModuleCore.ESSENCE.getSourceFluid().get(), experience));
    }

    /* Upgrade Item registration */

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.Keys.ITEMS, IFWootAddon.MOD_ID);

    public static void register(WootUpgradeItemRegistration registration){
        ITEMS.register(registration.getWootEventBus());
        registration.register(MOB_CRUSHER_ITEM);
    }

    public static final String MOB_CRUSHER_TAG = "mob_crusher_upgrade";
    public static final RegistryObject<MobCrusher> MOB_CRUSHER_ITEM = ITEMS.register(MOB_CRUSHER_TAG, () -> new MobCrusher(1));
}
