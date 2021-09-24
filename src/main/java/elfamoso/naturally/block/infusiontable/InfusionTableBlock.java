package elfamoso.naturally.block.infusiontable;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.block.AbstractFurnaceBlock;

public class InfusionTableBlock extends AbstractFurnaceBlock {

	public InfusionTableBlock(Properties properties) {

		super(properties);

	}

	@Override
	public TileEntity newBlockEntity(IBlockReader blockReader) {
		return new InfusionTableTileEntity();
	}

	@Override
	protected void openContainer(World world, BlockPos pos, PlayerEntity entity) {

		TileEntity tileEntity = world.getBlockEntity(pos);
		
		if (tileEntity instanceof InfusionTableTileEntity) {
			entity.openMenu((INamedContainerProvider) tileEntity);
			//entity.awardStat(Stats.INTERACT_WITH_FURNACE);
			
		}

	}
	
	@Override
	public static boolean isFuel(ItemStack p_213991_0_) {
		return net.minecraftforge.common.ForgeHooks.getBurnTime(p_213991_0_) > 0;
	}
	
}
