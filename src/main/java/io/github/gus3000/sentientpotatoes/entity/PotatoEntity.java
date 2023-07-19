package io.github.gus3000.sentientpotatoes.entity;

import io.github.gus3000.sentientpotatoes.init.EntityInit;
import io.github.gus3000.sentientpotatoes.init.ItemInit;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.Nullable;

public class PotatoEntity extends Animal {
    public PotatoEntity(EntityType<PotatoEntity> type, Level level) {
        super(type, level);
    }

    public PotatoEntity(Level level, double x, double y, double z) {
        this(EntityInit.POTATO_ENTITY.get(), level); // I don't like this
        setPos(x, y, z);
    }

    public PotatoEntity(Level level, BlockPos pos) {
        this(level, pos.getX(), pos.getY(), pos.getZ());
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob otherParent) {
        return new PotatoEntity(level, blockPosition());
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.25));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1));
        this.goalSelector.addGoal(3, new FollowParentGoal(this, 1));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 6));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(7, new TemptGoal(this, 1, Ingredient.of(ItemInit.POTATO_ITEM.get()), false));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Pig.createAttributes();
    }

    public static boolean canSpawn(EntityType<PotatoEntity> entityType, LevelAccessor level, MobSpawnType spawnType, BlockPos position, RandomSource random) {
        //ex : level.getLevelData().isRaining()
        //ex: position.getY() > 40
        return Animal.checkAnimalSpawnRules(entityType,level,spawnType,position,random);
    }
}
