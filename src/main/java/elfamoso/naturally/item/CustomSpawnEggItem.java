package elfamoso.naturally.item;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

public class CustomSpawnEggItem extends SpawnEggItem {
	
	protected static final List<CustomSpawnEggItem> UNADDED_EGGS = new ArrayList<>();
    private final Lazy<? extends EntityType<?>> entityTypeSupplier;

    public CustomSpawnEggItem(final RegistryObject<? extends EntityType<?>> entityTypeSupplier, final int primaryColour, final int secondaryColour, final Item.Properties properties) {
        
    	super(null, primaryColour, secondaryColour, properties);
        this.entityTypeSupplier = Lazy.of(entityTypeSupplier::get);
        UNADDED_EGGS.add(this);
        
    }
    
    public static void initSpawnEggs() {
    	
    	final Map<EntityType<?>, SpawnEggItem> EGGS = ObfuscationReflectionHelper.getPrivateValue(SpawnEggItem.class, null, "field_195987_b");
        
        // Make crash
        /*IDispenseItemBehavior dispenseBehaviour = new IDispenseItemBehavior() {
        	@Override
			public ItemStack dispense(IBlockSource source, ItemStack stack) {
                Direction direction = source.getBlockState().getBedDirection(source.getLevel(), source.getPos());
                //(DispenserBlock.FACING);
                EntityType<?> type = ((SpawnEggItem) stack.getItem()).getType(stack.getTag());
                type.spawn(source.getLevel(), stack, null, source.getPos().offset(direction.getNormal()),
                        SpawnReason.DISPENSER, direction != Direction.UP, false);
                stack.shrink(1);
                return stack;
            }
        };*/
        
        DefaultDispenseItemBehavior dispenseBehaviour = new DefaultDispenseItemBehavior();
        
        for (final SpawnEggItem spawnEgg : UNADDED_EGGS) {
            EGGS.put(spawnEgg.getType(null), spawnEgg);
            DispenserBlock.registerBehavior(spawnEgg, dispenseBehaviour);
        }
        
        UNADDED_EGGS.clear();
    }
    
    @Override
    public EntityType<?> getType(CompoundNBT nbt) {
        return this.entityTypeSupplier.get();
    }
	
}
