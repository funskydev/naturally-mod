package elfamoso.naturally.util;

import elfamoso.naturally.Naturally;
import elfamoso.naturally.client.gui.InfusionTableScreen;
import elfamoso.naturally.client.render.PenguinRender;
import elfamoso.naturally.client.render.RatRender;
import elfamoso.naturally.init.EntitiesManager;
import elfamoso.naturally.item.CustomSpawnEggItem;
import elfamoso.naturally.world.SpawnHandler;
import elfamoso.naturally.init.ContainersManager;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Naturally.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {
	
	@SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent e) {
		e.enqueueWork(() -> ScreenManager.register(ContainersManager.INFUSION_TABLE.get(), InfusionTableScreen::new));
		
        RenderingRegistry.registerEntityRenderingHandler(EntitiesManager.PENGUIN.get(), PenguinRender::new);
        RenderingRegistry.registerEntityRenderingHandler(EntitiesManager.RAT.get(), RatRender::new);
    }

    @SubscribeEvent
    public static void onRegisterEntities(final RegistryEvent.Register<EntityType<?>> e) {
        CustomSpawnEggItem.initSpawnEggs();
    }
    
}
