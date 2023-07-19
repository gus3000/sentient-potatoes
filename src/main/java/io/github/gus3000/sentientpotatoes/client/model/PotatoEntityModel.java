package io.github.gus3000.sentientpotatoes.client.model;

// Made with Blockbench 4.7.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class PotatoEntityModel<T extends Entity> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "potatoentitymodel"), "main");
    private final ModelParts parts;


    public PotatoEntityModel(ModelPart r) {
        ModelPart root = r.getChild("root");

        ModelPart body = root.getChild("body");

        ModelPart legs = root.getChild("legs");
        ModelPart rightLeg = legs.getChild("right_leg");
        ModelPart leftLeg = legs.getChild("left_leg");
        this.parts = new ModelParts(root,body,legs,rightLeg,leftLeg);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -2.5F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.5F, 0.0F));

        PartDefinition legs = root.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition right_leg = legs.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(4, 9).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, -4.0F, 0.5F));

        PartDefinition left_leg = legs.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 9).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, -4.0F, 0.5F));

        return LayerDefinition.create(meshdefinition, 16, 16);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.parts.body.yRot = netHeadYaw * Mth.DEG_TO_RAD;
        this.parts.body.xRot = headPitch * Mth.DEG_TO_RAD;

        final float SWING_SPEED = 1.5f;
        final float SWING_AMPLITUDE = 1.4f;
        this.parts.leftLeg.xRot = Mth.cos(limbSwing * SWING_SPEED) * SWING_AMPLITUDE * limbSwingAmount;
        this.parts.rightLeg.xRot = Mth.cos(limbSwing * SWING_SPEED + Mth.PI) * SWING_AMPLITUDE * limbSwingAmount;

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        this.parts.root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    private record ModelParts(
            ModelPart root,
            ModelPart body,
            ModelPart legs,
            ModelPart rightLeg,
            ModelPart leftLeg
            ) {}
}