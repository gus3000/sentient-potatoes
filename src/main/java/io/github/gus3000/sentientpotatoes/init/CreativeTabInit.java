package io.github.gus3000.sentientpotatoes.init;

import io.github.gus3000.sentientpotatoes.SentientPotatoes;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.Logging;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

@Mod.EventBusSubscriber(modid = SentientPotatoes.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CreativeTabInit {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SentientPotatoes.MODID);

    public static final List<Supplier<? extends ItemLike>> POTATO_TAB_ITEMS = new ArrayList<>();
    public static final RegistryObject<CreativeModeTab> POTATO_TAB = TABS.register("potato_tab",() -> CreativeModeTab.builder()
            .title(Component.translatable("creativetab.sentientpotatoes.potato_tab"))
//            .icon(ItemInit.POTATO_ITEM) //does not work
//            .icon(() -> new ItemStack(ItemInit.POTATO_ITEM.get()))
            .icon(ItemInit.POTATO_ITEM.get()::getDefaultInstance)
            .displayItems((displayParams, output) -> {
//                output.accept(ItemInit.POTATO_ITEM.get());
//                output.accept(ItemInit.POTATO_BLOCK_ITEM.get());
                POTATO_TAB_ITEMS.forEach(itemLike -> output.accept(itemLike.get()));
            })
            .build()
    );

    public static <T extends ItemLike> List<Supplier<? extends ItemLike>> addToTab(RegistryObject<T> itemLike) {
        POTATO_TAB_ITEMS.add(itemLike);
        return POTATO_TAB_ITEMS;
    }

    @SubscribeEvent
    public static void buildContents(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ItemInit.POTATO_BLOCK_ITEM);
        }
    }
}
