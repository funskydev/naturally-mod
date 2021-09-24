package elfamoso.naturally.item.crafting;

import elfamoso.naturally.init.RecipesManager;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.AbstractCookingRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;

public class InfusionRecipe extends AbstractCookingRecipe {

	public InfusionRecipe(ResourceLocation id, String group, Ingredient ingredient, ItemStack result, float experience, int cookingTime) {
		super(RecipesManager.INFUSION_TYPE, id, group, ingredient, result, experience, cookingTime);
	}
	
	@Override
	public ItemStack getToastSymbol() {
		return new ItemStack(Blocks.BEACON);
	}
	
	@Override
	public IRecipeSerializer<?> getSerializer() {
		return RecipesManager.INFUSION_SERIALIZER.get();
	}

}
