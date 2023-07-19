package io.github.gus3000.sentientpotatoes.init;

import io.github.gus3000.sentientpotatoes.SentientPotatoes;
import io.github.gus3000.sentientpotatoes.entity.PotatoEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityInit {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, SentientPotatoes.MODID);

    public static final RegistryObject<EntityType<PotatoEntity>> POTATO_ENTITY = ENTITIES.register("potato_entity", () -> EntityType.Builder.<PotatoEntity>of(PotatoEntity::new, MobCategory.CREATURE)
            .sized(1,1)
            .build(new ResourceLocation(SentientPotatoes.MODID, "potato_entity").toString()));
}
