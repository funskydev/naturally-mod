package elfamoso.naturally.init;

import elfamoso.naturally.Naturally;
import elfamoso.naturally.entity.PenguinEntity;
import elfamoso.naturally.entity.RatEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntitiesManager {
	
	public static EntityType<?> penguinEntity;
	
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, Naturally.MOD_ID);

    // Entity Types
    public static final RegistryObject<EntityType<PenguinEntity>> PENGUIN = ENTITY_TYPES.register("penguin", () -> EntityType.Builder.of(PenguinEntity::new, EntityClassification.CREATURE)
                    .sized(0.5f, 1.3f) // Hitbox Size
                    .build(new ResourceLocation(Naturally.MOD_ID, "penguin").toString()));
    
    public static final RegistryObject<EntityType<RatEntity>> RAT = ENTITY_TYPES.register("rat", () -> EntityType.Builder.of(RatEntity::new, EntityClassification.CREATURE)
            .sized(0.5f, 0.4f) // Hitbox Size
            .build(new ResourceLocation(Naturally.MOD_ID, "rat").toString()));
    
	
}
