package elfamoso.naturally.entity;

import elfamoso.naturally.entity.ai.MoveOnIceGoal;
import elfamoso.naturally.init.EntitiesManager;
import elfamoso.naturally.init.SoundsManager;
import net.minecraft.block.BlockState;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class PenguinEntity extends AnimalEntity {

	private static final Ingredient FOOD_ITEMS = Ingredient.of(Items.COD, Items.SALMON, Items.TROPICAL_FISH, Items.PUFFERFISH);

    public PenguinEntity(EntityType<? extends AnimalEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.createMobAttributes()
        		.add(Attributes.MAX_HEALTH, 10.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.2D);
    }
    
    @Override
    protected void registerGoals() {
        super.registerGoals();
        goalSelector.addGoal(0, new SwimGoal(this));
        goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
        goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
        goalSelector.addGoal(3, new TemptGoal(this, 1.1D, false, FOOD_ITEMS));
        goalSelector.addGoal(4, new FollowParentGoal(this, 1.1D));
        goalSelector.addGoal(5, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 1.0D, 60));
        goalSelector.addGoal(7, new LookRandomlyGoal(this));
        goalSelector.addGoal(8, new MoveOnIceGoal(this, 1.0D, 10, 3));
        
    }

    /*protected float getStandingEyeHeight(Pose p_213348_1_, EntitySize p_213348_2_) {
    	return this.isBaby() ? p_213348_2_.height * 0.85F : p_213348_2_.height * 0.92F;
    }*/
    
    // DROPS
    
    /*@Override
    protected int getExperienceReward() {
    	CowEntity
    	return 1;
    }*/
    
    /*Override
    protected ResourceLocation getLootTable() {
        return LootTableHandler.FOLIAATH;
    }*/
    
    // FOODS
    
    @Override
    public boolean isFood(ItemStack is) {
        return FOOD_ITEMS.test(is);
    }
    
	@Override
	public AgeableEntity getBreedOffspring(ServerWorld serverWorld, AgeableEntity ageableEntity) {
		PenguinEntity penguin = (PenguinEntity) EntitiesManager.PENGUIN.get().create(serverWorld);
		return penguin;
	}
    
	// SOUNDS
	
    @Override
    protected SoundEvent getAmbientSound() {
    	//SoundEve,
    	return SoundsManager.ENTITY_PENGUIN_AMBIENT.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damage) {
    	return SoundsManager.ENTITY_PENGUIN_HURT.get();
    }
    
    @Override
    protected SoundEvent getDeathSound() {
    	return SoundEvents.DOLPHIN_DEATH;
    }
    
    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.PIG_STEP, 0.15F, 1.0F);
    }
    
    @Override
    protected float getSoundVolume() {
    	return 0.4F;
    }

    // SPAWNING
    
    /*@Override
    public boolean canSpawn(IWorld world, SpawnReason reason) {
        Biome biome = world.getBiome(getPosition());
        int i = MathHelper.floor(this.getPosX());
        int j = MathHelper.floor(this.getBoundingBox().minY);
        int k = MathHelper.floor(this.getPosZ());
        BlockPos pos = new BlockPos(i, j, k);
        Block floor = world.getBlockState(pos.down()).getBlock();
        BlockState floorDown1 = world.getBlockState(pos.down(2));
        BlockState floorDown2 = world.getBlockState(pos.down(3));
        boolean notInTree = true;
        BlockState topBlock = biome.getGenerationSettings().getSurfaceBuilder().get().getConfig().getTop();
        if (floor instanceof LeavesBlock && floorDown1 != topBlock && floorDown2 != topBlock) notInTree = false;
        return super.canSpawn(world, reason) && notInTree && getEntitiesNearby(AnimalEntity.class, 5, 5, 5, 5).isEmpty() && world.getDifficulty() != Difficulty.PEACEFUL;
    }*/
    
}
