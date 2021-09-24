package elfamoso.naturally.container;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;

public class InfusionTableSlot extends Slot {

	public InfusionTableSlot(IInventory inv, int slotId, int xPos, int yPos) {
		
		super(inv, slotId, xPos, yPos);
		
	}
	
	/*@Override
	public boolean isItemValid(ItemStack stack) {
		return stack.isEmpty() || stack.getItem() == Item.getItemFromBlock(Blocks.DIRT);
	}*/

}
