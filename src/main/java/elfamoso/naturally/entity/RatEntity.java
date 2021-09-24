package elfamoso.naturally.entity;

import elfamoso.naturally.init.EntitiesManager;
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

public class RatEntity extends AnimalEntity {

	private static final Ingredient FOOD_ITEMS = Ingredient.of(Items.ANVIL);
	
	public RatEntity(EntityType<? extends AnimalEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.createMobAttributes()
        		.add(Attributes.MAX_HEALTH, 4.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.25D);
    }
    
    @Override
    protected void registerGoals() {
        super.registerGoals();
        goalSelector.addGoal(0, new SwimGoal(this));
        goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
        goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
        goalSelector.addGoal(3, new TemptGoal(this, 1.1D, false, FOOD_ITEMS));
        goalSelector.addGoal(4, new FollowParentGoal(this, 1.1D));
        //goalSelector.addGoal(5, new FollowMobGoal(PlayerEntity, lerpX, restrictRadius, restrictRadius));
        goalSelector.addGoal(5, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 1.0D, 60));
        goalSelector.addGoal(7, new LookRandomlyGoal(this));
        
    }
    
    @Override
    public boolean isFood(ItemStack is) {
        return FOOD_ITEMS.test(is);
    }

    @Override
	public AgeableEntity getBreedOffspring(ServerWorld serverWorld, AgeableEntity ageableEntity) {
		RatEntity rat = (RatEntity) EntitiesManager.RAT.get().create(serverWorld);
		return rat;
	}
    
    // SOUNDS
	
    @Override
    protected SoundEvent getAmbientSound() {
    	//SoundEve,
    	return SoundEvents.SILVERFISH_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damage) {
    	return SoundEvents.SILVERFISH_HURT;
    }
    
    @Override
    protected SoundEvent getDeathSound() {
    	return SoundEvents.SILVERFISH_DEATH;
    }
    
    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.SILVERFISH_STEP, 0.15F, 1.0F);
    }
    
    @Override
    protected float getSoundVolume() {
    	return 0.4F;
    }

}
