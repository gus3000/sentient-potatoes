package io.github.gus3000.sentientpotatoes.init;

import io.github.gus3000.sentientpotatoes.SentientPotatoes;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SentientPotatoes.MODID);

    public static final RegistryObject<Block> POTATO_BLOCK = BLOCKS.register("potato_block", () -> new Block(
            BlockBehaviour.Properties.copy(Blocks.MELON)
                    .mapColor(MapColor.TERRACOTTA_BROWN)
                    .strength(1, 17)
                    .speedFactor(1.5f)
                    .lightLevel(state -> 15)
                    .requiresCorrectToolForDrops()
                    .pushReaction(PushReaction.DESTROY)
    ));
}
