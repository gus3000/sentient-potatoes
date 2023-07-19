package io.github.gus3000.sentientpotatoes.events;

import io.github.gus3000.sentientpotatoes.SentientPotatoes;
import io.github.gus3000.sentientpotatoes.client.model.PotatoEntityModel;
import io.github.gus3000.sentientpotatoes.client.renderer.PotatoEntityRenderer;
import io.github.gus3000.sentientpotatoes.entity.PotatoEntity;
import io.github.gus3000.sentientpotatoes.init.EntityInit;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SentientPotatoes.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityInit.POTATO_ENTITY.get(), PotatoEntityRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(PotatoEntityModel.LAYER_LOCATION, PotatoEntityModel::createBodyLayer);
    }
}
