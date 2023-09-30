package net.frinzthecoder.opfruits.item.custom;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class SacrificialFruit extends Item {
    public static final FoodProperties foodProperties = new FoodProperties.Builder()
            .nutrition(0)
            .alwaysEat()
            .build();
    public SacrificialFruit(Properties properties) {
        super(properties
                .food(foodProperties)
                .rarity(Rarity.EPIC));
    }

}
