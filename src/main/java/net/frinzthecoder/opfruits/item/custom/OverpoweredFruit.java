package net.frinzthecoder.opfruits.item.custom;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class OverpoweredFruit extends Item {
    public static final FoodProperties foodProperties = new FoodProperties.Builder()
            .nutrition(20)
            .saturationMod(5f)
            .alwaysEat()
            .build();
    public OverpoweredFruit(Properties properties) {
        super(properties
                .food(foodProperties)
                .rarity(Rarity.EPIC));
    }

}
