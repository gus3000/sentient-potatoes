package io.github.gus3000.sentientpotatoes.init;

import io.github.gus3000.sentientpotatoes.SentientPotatoes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SentientPotatoes.MODID);

    public static final RegistryObject<Item> POTATO_ITEM = register("potato_item",
            () -> new Item(new Item.Properties()
                    .stacksTo(16)
                    .food(new FoodProperties.Builder()
                            .nutrition(5)
                            .saturationMod(.2f)
                            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 200, 2), 1f)
                            .build())
                    .rarity(Rarity.EPIC)
            )
    );


    // ------------------ Block items ----------------
    public static final RegistryObject<BlockItem> POTATO_BLOCK_ITEM = register("potato_block",
            () -> new BlockItem(
                    BlockInit.POTATO_BLOCK.get(),
                    new Item.Properties()
                            .rarity(Rarity.UNCOMMON)
            )
    );

    // ------------------ Spawn eggs items ----------------
    public static final RegistryObject<ForgeSpawnEggItem> POTATO_ENTITY_SPAWN_EGG = register("potato_entity_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.POTATO_ENTITY, 0x896a3d, 0xa47631, new Item.Properties()));

    private static <T extends Item> RegistryObject<T> register(String name, Supplier<T> supplier) {
        return register(name, supplier, true);
    }

    private static <T extends Item> RegistryObject<T> register(String name, Supplier<T> supplier, boolean addToCreativeTab) {
        var item = ITEMS.register(name, supplier);
        if (addToCreativeTab)
            CreativeTabInit.addToTab(item);
        return item;
    }
}
