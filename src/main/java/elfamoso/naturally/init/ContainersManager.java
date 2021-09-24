package elfamoso.naturally.init;

import elfamoso.naturally.Naturally;
import elfamoso.naturally.container.InfusionTableContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ContainersManager {
	
	public static final DeferredRegister<ContainerType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, Naturally.MOD_ID);
	
	public static final RegistryObject<ContainerType<InfusionTableContainer>> INFUSION_TABLE = CONTAINERS.register("infusion_table",
			() -> new ContainerType<>(InfusionTableContainer::new));
	
}
