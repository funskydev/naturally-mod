package elfamoso.naturally.container;

import elfamoso.naturally.init.ContainersManager;
import elfamoso.naturally.init.RecipesManager;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.AbstractFurnaceContainer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.RecipeBookCategory;
import net.minecraft.util.IIntArray;

public class InfusionTableContainer extends AbstractFurnaceContainer {
	
	public InfusionTableContainer(int windowId, PlayerInventory playerInv) {
		super(ContainersManager.INFUSION_TABLE.get(), RecipesManager.INFUSION_TYPE, RecipeBookCategory.FURNACE, windowId, playerInv);
    }
	
	public InfusionTableContainer(int windowId, PlayerInventory playerInv, IInventory container, IIntArray data) {
		super(ContainersManager.INFUSION_TABLE.get(), RecipesManager.INFUSION_TYPE, RecipeBookCategory.FURNACE, windowId, playerInv, container, data);
    }
	
}
