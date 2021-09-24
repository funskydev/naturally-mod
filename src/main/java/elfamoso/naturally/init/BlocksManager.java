package elfamoso.naturally.init;

import elfamoso.naturally.Naturally;
import elfamoso.naturally.block.StumpBlock;
import elfamoso.naturally.block.infusiontable.InfusionTableBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlocksManager {
	
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Naturally.MOD_ID);
	
	public static final RegistryObject<StumpBlock> OAK_STUMP = BLOCKS.register("oak_stump",
			() -> new StumpBlock(AbstractBlock.Properties.of(Material.WOOD).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
	
	public static final RegistryObject<StumpBlock> SPRUCE_STUMP = BLOCKS.register("spruce_stump",
			() -> new StumpBlock(AbstractBlock.Properties.of(Material.WOOD).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
	
	public static final RegistryObject<InfusionTableBlock> INFUSION_TABLE = BLOCKS.register("infusion_table",
			() -> new InfusionTableBlock(AbstractBlock.Properties.of(Material.WOOD).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
	
}
