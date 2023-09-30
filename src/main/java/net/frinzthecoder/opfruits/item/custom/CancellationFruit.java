package net.frinzthecoder.opfruits.item.custom;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class CancellationFruit extends Item {
    public static final FoodProperties foodProperties = new FoodProperties.Builder()
            .nutrition(0)
            .alwaysEat()
            .build();
    public CancellationFruit(Properties properties) {
        super(properties
                .food(foodProperties)
                .rarity(Rarity.EPIC));
    }

}
