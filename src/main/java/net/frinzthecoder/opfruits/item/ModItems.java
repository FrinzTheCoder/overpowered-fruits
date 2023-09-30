package net.frinzthecoder.opfruits.item;

import net.frinzthecoder.opfruits.OverpoweredFruits;
import net.frinzthecoder.opfruits.block.ModBlocks;
import net.frinzthecoder.opfruits.item.custom.CancellationFruit;
import net.frinzthecoder.opfruits.item.custom.OverpoweredFruit;
import net.frinzthecoder.opfruits.item.custom.SacrificialFruit;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, OverpoweredFruits.MOD_ID);

    public static final RegistryObject<Item> OPFRUITS_SEEDS = ITEMS.register("opfruit_seeds",
            () -> new ItemNameBlockItem(ModBlocks.OVERPOWERED_FRUIT_CROP.get(),
                    new Item.Properties().tab(ModCreativeModeTab.OPFRUITS_TAB))
    );

    public static final RegistryObject<Item> OPFRUITS = ITEMS.register("opfruit",
            () -> new OverpoweredFruit(new Item.Properties().tab(ModCreativeModeTab.OPFRUITS_TAB)));

    public static final RegistryObject<Item> CANCELLATIONFRUITS = ITEMS.register("cancellationfruit",
            () -> new CancellationFruit(new Item.Properties().tab(ModCreativeModeTab.OPFRUITS_TAB)));

    public static final RegistryObject<Item> SACRIFICIALFRUITS = ITEMS.register("sacrificialfruit",
            () -> new SacrificialFruit(new Item.Properties().tab(ModCreativeModeTab.OPFRUITS_TAB)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
