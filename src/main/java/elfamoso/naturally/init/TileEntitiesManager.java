package elfamoso.naturally.init;

import elfamoso.naturally.Naturally;
import elfamoso.naturally.block.infusiontable.InfusionTableTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntitiesManager {
	
	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Naturally.MOD_ID);
	
	public static final RegistryObject<TileEntityType<InfusionTableTileEntity>> INFUSION_TABLE = TILE_ENTITIES.register("infusion_table",
            () -> TileEntityType.Builder.of(InfusionTableTileEntity::new, BlocksManager.INFUSION_TABLE.get()).build(null));
	
}
