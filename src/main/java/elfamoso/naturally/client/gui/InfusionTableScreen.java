package elfamoso.naturally.client.gui;

import elfamoso.naturally.Naturally;
import elfamoso.naturally.container.InfusionTableContainer;
import net.minecraft.client.gui.recipebook.FurnaceRecipeGui;
import net.minecraft.client.gui.screen.inventory.AbstractFurnaceScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

//@OnlyIn(Dist.CLIENT)
public class InfusionTableScreen extends AbstractFurnaceScreen<InfusionTableContainer> {
	
	private static final ResourceLocation TEXTURE = new ResourceLocation(Naturally.MOD_ID, "textures/gui/containers/infusion_table.png");
	
	public InfusionTableScreen(InfusionTableContainer container, PlayerInventory playerInv, ITextComponent title) {
		
		super(container, new FurnaceRecipeGui(), playerInv, title, TEXTURE);
		
	}

}
