package net.frinzthecoder.opfruits.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab OPFRUITS_TAB =  new CreativeModeTab("opfruitstab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.OPFRUITS.get());
        }
    };
}
