package elfamoso.naturally.block.infusiontable;

import elfamoso.naturally.container.InfusionTableContainer;
import elfamoso.naturally.init.RecipesManager;
import elfamoso.naturally.init.TileEntitiesManager;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.tileentity.AbstractFurnaceTileEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class InfusionTableTileEntity extends AbstractFurnaceTileEntity {

	public InfusionTableTileEntity() {
		//super(TileEntitiesManager.INFUSION_TABLE.get(), IRecipeType.SMELTING);
		super(TileEntitiesManager.INFUSION_TABLE.get(), RecipesManager.INFUSION_TYPE);
	}
	
	@Override
	protected ITextComponent getDefaultName() {
		return new TranslationTextComponent("container.naturally.infusion_table");
	}
	
	@Override
	protected Container createMenu(int id, PlayerInventory playerInv) {
		return new InfusionTableContainer(id, playerInv, this, this.dataAccess);
	}

	
	
}
