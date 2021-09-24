package elfamoso.naturally.init;


import elfamoso.naturally.Naturally;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SoundsManager {
	
	public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Naturally.MOD_ID);

    //public static final RegistryObject<SoundEvent> LASER = create("laser");
    //public static final RegistryObject<SoundEvent> SUNSTRIKE = create("sunstrike");

    //public static final RegistryObject<SoundEvent> ENTITY_WROUGHT_PRE_SWING_1 = create("wroughtnaut.pre_swing1");

	//PENGUIN
	
    public static final RegistryObject<SoundEvent> ENTITY_PENGUIN_AMBIENT = create("penguin.ambient");
    public static final RegistryObject<SoundEvent> ENTITY_PENGUIN_HURT = create("penguin.hurt");
	
    private static RegistryObject<SoundEvent> create(String name) {
    	
        return SOUNDS.register(name, () -> new SoundEvent(new ResourceLocation(Naturally.MOD_ID, name)));
        
    }
    
}
