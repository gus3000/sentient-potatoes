package io.github.gus3000.sentientpotatoes.client.renderer;

import io.github.gus3000.sentientpotatoes.SentientPotatoes;
import io.github.gus3000.sentientpotatoes.client.model.PotatoEntityModel;
import io.github.gus3000.sentientpotatoes.entity.PotatoEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import org.jetbrains.annotations.NotNull;

public class PotatoEntityRenderer extends MobRenderer<PotatoEntity, PotatoEntityModel<PotatoEntity>> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(SentientPotatoes.MODID, "textures/entity/potato_entity.png");

    public PotatoEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new PotatoEntityModel<>(context.bakeLayer(PotatoEntityModel.LAYER_LOCATION)), 1);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull PotatoEntity entity) {
        return TEXTURE;
    }

}
