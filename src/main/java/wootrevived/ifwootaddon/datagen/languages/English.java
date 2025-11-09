package wootrevived.ifwootaddon.datagen.languages;

import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;
import wootrevived.ifwootaddon.IFWootAddon;
import wootrevived.ifwootaddon.registries.IFItemsRegistry;
import wootrevived.ifwootaddon.upgrades.LaserDrill;
import wootrevived.ifwootaddon.upgrades.MobCrusher;
import wootrevived.ifwootaddon.upgrades.MobSlaughterFactory;

public class English extends LanguageProvider {
    public English(PackOutput output){
        super(output, IFWootAddon.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add(MobCrusher.MOB_CRUSHER_ITEM.get(), "Mob Crusher Upgrade");
        add(MobSlaughterFactory.MOB_SLAUGHTER_FACTORY_ITEM.get(), "Mob Slaughter Factory Upgrade");
        add(LaserDrill.LASER_DRILL_ITEM.get(), "Laser Drill Upgrade");
        add(IFItemsRegistry.STYGIAN_LASER_LENS_ITEM.get(), "Stygian Laser Lens");
    }
}