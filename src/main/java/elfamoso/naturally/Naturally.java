package elfamoso.naturally;

import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.common.crafting.IIngredientSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import elfamoso.naturally.entity.PenguinEntity;
import elfamoso.naturally.entity.RatEntity;
import elfamoso.naturally.init.BlocksManager;
import elfamoso.naturally.init.ContainersManager;
import elfamoso.naturally.init.EntitiesManager;
import elfamoso.naturally.init.ItemsManager;
import elfamoso.naturally.init.RecipesManager;
import elfamoso.naturally.init.SoundsManager;
import elfamoso.naturally.init.TileEntitiesManager;
import elfamoso.naturally.item.crafting.InfusionRecipe;
import elfamoso.naturally.world.SpawnHandler;

@Mod("naturally")
public class Naturally
{
	
    public static final String MOD_ID = "naturally";
    public static final Logger log = LogManager.getLogger(MOD_ID);

    public Naturally() {
    	
    	IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
    	
    	bus.addListener(this::onSetup);
        
        EntitiesManager.ENTITY_TYPES.register(bus);
        BlocksManager.BLOCKS.register(bus);
        TileEntitiesManager.TILE_ENTITIES.register(bus);
        ContainersManager.CONTAINERS.register(bus);
        ItemsManager.ITEMS.register(bus);
        SoundsManager.SOUNDS.register(bus);
        RecipesManager.RECIPE_SERIALIZERS.register(bus);

        bus.addGenericListener(IRecipeSerializer.class, this::onRegisterRecipe);
        
        MinecraftForge.EVENT_BUS.register(this);
        
    }

    @SuppressWarnings("deprecation")
	private void onSetup(final FMLCommonSetupEvent e)
    {
        
    	DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(EntitiesManager.PENGUIN.get(), PenguinEntity.setCustomAttributes().build());
            GlobalEntityTypeAttributes.put(EntitiesManager.RAT.get(), RatEntity.setCustomAttributes().build());
        });
    	
    }
    
    private void onRegisterRecipe(RegistryEvent.Register<IRecipeSerializer<?>> event)
	{
		// forge registers ingredient serializers here for some reason, might as well do it here too
		//CraftingHelper.register(new ResourceLocation("jumbofurnace:tag_stack"), TagStackIngredient.SERIALIZER);
    	//CraftingHelper.register(new ResourceLocation("jumbofurnace:tag_stack"), (IIngredientSerializer<T>) RecipesManager.INFUSION_SERIALIZER.get());
	}
    
    @SubscribeEvent
    public void onBiomeLoading(BiomeLoadingEvent e) {
        SpawnHandler.onBiomeLoading(e);
    }
    
}
