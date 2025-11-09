package wootrevived.ifwootaddon.registries;

import com.buuz135.industrial.module.ModuleCore;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import wootrevived.ifwootaddon.IFWootAddon;

import java.util.List;

public class IFItemsRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.Keys.ITEMS, IFWootAddon.MOD_ID);

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }

    public static final String STYGIAN_LASER_LENS_TAG = "stygian_laser_lens";
    public static final RegistryObject<Item> STYGIAN_LASER_LENS_ITEM = ITEMS.register(STYGIAN_LASER_LENS_TAG, () -> {
        Item item = new Item(new Item.Properties().stacksTo(1));
        List<Item> tabList = ModuleCore.TAB_CORE.getTabList();
        for(int i = 0; i < tabList.size(); ++i) {
            if(tabList.get(i) == ModuleCore.LASER_LENS[15].get()){
                ModuleCore.TAB_CORE.getTabList().add(i + 1, item);
                break;
            }
        }
        return item;
    });
}
