package wootrevived.ifwootaddon;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import org.jetbrains.annotations.NotNull;
import wootrevived.ifwootaddon.registries.IFItemsRegistry;

@Mod(IFWootAddon.MOD_ID)
public class IFWootAddon
{
    public static final String MOD_ID = "ifwootaddon";

    public IFWootAddon(IEventBus bus)
    {
        IFItemsRegistry.register(bus);
    }

    public static @NotNull ResourceLocation location(String path) {
        return ResourceLocation.fromNamespaceAndPath(IFWootAddon.MOD_ID, path);
    }
}
