package io.github.gus3000.sentientpotatoes.events;

import io.github.gus3000.sentientpotatoes.SentientPotatoes;
import io.github.gus3000.sentientpotatoes.entity.PotatoEntity;
import io.github.gus3000.sentientpotatoes.init.EntityInit;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SentientPotatoes.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonModEvents {
    @SubscribeEvent
    public static void entityAttributes(EntityAttributeCreationEvent event) {
        event.put(EntityInit.POTATO_ENTITY.get(), PotatoEntity.createAttributes().build());
    }

    @SubscribeEvent
    public static void registerSpawnPlacements(SpawnPlacementRegisterEvent event) {
        // TODO probably remove as it cannot spawn naturally
        event.register(
                EntityInit.POTATO_ENTITY.get(),
                SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.WORLD_SURFACE,
                PotatoEntity::canSpawn,
                SpawnPlacementRegisterEvent.Operation.OR
        );
    }
}
