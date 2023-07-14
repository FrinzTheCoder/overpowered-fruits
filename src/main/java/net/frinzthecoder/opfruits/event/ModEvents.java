package net.frinzthecoder.opfruits.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.frinzthecoder.opfruits.OverpoweredFruits;
import net.frinzthecoder.opfruits.item.ModItems;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Mod.EventBusSubscriber(modid = OverpoweredFruits.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void addCustomTrade(VillagerTradesEvent event){
        if(event.getType() == VillagerProfession.FARMER){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack target = new ItemStack(ModItems.OPFRUITS_SEEDS.get());
            ItemStack price = new ItemStack(Items.EMERALD,48);
            int villagerLevel = 5;
            trades.get(villagerLevel).add( (trader,rand) -> new MerchantOffer(
                    price, ItemStack.EMPTY, target, 5, 10, 30, 0.2F, 0
            ));
        }
    }

    @SubscribeEvent
    public static void addEffectAfterEat(LivingEntityUseItemEvent.Finish event){
        if(!event.getEntity().getLevel().isClientSide() &&
                event.getEntity() instanceof Player player &&
                event.getItem().is(ModItems.OPFRUITS.get())){
                addRandomEffectsToPlayer(player);
        }
    }

    private static void addRandomEffectsToPlayer(Player player){
        ArrayList<MobEffect> effects = getRandomEffectsToPlayer();
        for (MobEffect effect : effects) {
            player.addEffect(new MobEffectInstance(effect, 20 * 60 * 30, 4));
        }
    }

    private static ArrayList<MobEffect> getRandomEffectsToPlayer(){
        ArrayList<MobEffect> effectsToBeApplied = new ArrayList<>();

        ArrayList<MobEffect> positiveEffects = new ArrayList<>(Arrays.asList(
                MobEffects.MOVEMENT_SPEED, MobEffects.DIG_SPEED, MobEffects.DAMAGE_BOOST, MobEffects.JUMP,
                MobEffects.REGENERATION, MobEffects.DAMAGE_RESISTANCE, MobEffects.FIRE_RESISTANCE, MobEffects.WATER_BREATHING,
                MobEffects.INVISIBILITY, MobEffects.NIGHT_VISION, MobEffects.HEALTH_BOOST, MobEffects.ABSORPTION,
                MobEffects.SATURATION, MobEffects.LUCK, MobEffects.SLOW_FALLING, MobEffects.CONDUIT_POWER,
                MobEffects.DOLPHINS_GRACE // 17, HEAL NOT INCLUDED
        ));

        ArrayList<MobEffect> negativeEffects = new ArrayList<>(Arrays.asList(
                MobEffects.MOVEMENT_SLOWDOWN,MobEffects.DIG_SLOWDOWN,MobEffects.CONFUSION,MobEffects.BLINDNESS,
                MobEffects.HUNGER,MobEffects.WEAKNESS,MobEffects.POISON,MobEffects.WITHER,
                MobEffects.LEVITATION, MobEffects.UNLUCK, MobEffects.DARKNESS // 10, HARM NOT INCLUDED
        ));

        int numOfEffects = getRandomNumber(3,5);
        for(int i=0;i<numOfEffects;i++){
            if(getRandomNumber(0,5)==0){
                while(true){
                    int idx = getRandomNumber(0,negativeEffects.size()-1);
                    MobEffect effect = negativeEffects.get(idx);
                    if(!effectsToBeApplied.contains(effect)){
                        effectsToBeApplied.add(effect);
                        break;
                    }
                }
            }
            else{
                while(true){
                    int idx = getRandomNumber(0,positiveEffects.size()-1);
                    MobEffect effect = positiveEffects.get(idx);
                    if(!effectsToBeApplied.contains(effect)){
                        effectsToBeApplied.add(effect);
                        break;
                    }
                }
            }
        }
        return effectsToBeApplied;
    }

    private static int getRandomNumber(int min, int max){
        int range = max-min+1;
        return (int)(Math.random()*range)+min;
    }
}
