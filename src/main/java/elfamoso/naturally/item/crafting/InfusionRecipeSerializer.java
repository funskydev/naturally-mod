package elfamoso.naturally.item.crafting;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipe;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class InfusionRecipeSerializer<T extends InfusionRecipe> extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<T> {
	
	private final InfusionRecipeSerializer.IFactory<T> factory;
	
	private final int defaultCookingTime;
	
	public InfusionRecipeSerializer(InfusionRecipeSerializer.IFactory<T> factory, int cookingTime) {
		
		this.factory = factory;
		
		this.defaultCookingTime = cookingTime;
		
	}
	
	@Override
	public T fromJson(ResourceLocation recipeId, JsonObject json) {
		String s = JSONUtils.getAsString(json, "group", "");
		JsonElement jsonelement = (JsonElement) (JSONUtils.isArrayNode(json, "ingredient")
				? JSONUtils.getAsJsonArray(json, "ingredient")
				: JSONUtils.getAsJsonObject(json, "ingredient"));
		Ingredient ingredient = Ingredient.fromJson(jsonelement);
		// Forge: Check if primitive string to keep vanilla or a object which can
		// contain a count field.
		if (!json.has("result"))
			throw new com.google.gson.JsonSyntaxException("Missing result, expected to find a string or object");
		ItemStack itemstack;
		if (json.get("result").isJsonObject())
			itemstack = ShapedRecipe.itemFromJson(JSONUtils.getAsJsonObject(json, "result"));
		else {
			String s1 = JSONUtils.getAsString(json, "result");
			ResourceLocation resourcelocation = new ResourceLocation(s1);
			itemstack = new ItemStack(Registry.ITEM.getOptional(resourcelocation).orElseThrow(() -> {
				return new IllegalStateException("Item: " + s1 + " does not exist");
			}));
		}
		float f = JSONUtils.getAsFloat(json, "experience", 0.0F);
		int i = JSONUtils.getAsInt(json, "cookingtime", this.defaultCookingTime);
		return this.factory.create(recipeId, s, ingredient, itemstack, f, i);
	}



	@Override
	public T fromNetwork(ResourceLocation recipeId, PacketBuffer json) {
		String str = json.readUtf(32767);
		Ingredient ingredient = Ingredient.fromNetwork(json);
		ItemStack itemstack = json.readItem();
		float f = json.readFloat();
		int i = json.readVarInt();
		return this.factory.create(recipeId, str, ingredient, itemstack, f, i);
	}
	
	@Override
	public void toNetwork(PacketBuffer buffer, InfusionRecipe recipeType) {
		buffer.writeUtf(recipeType.getGroup());
		recipeType.getIngredients().get(0).toNetwork(buffer);
		buffer.writeItem(recipeType.getResultItem());
		buffer.writeFloat(recipeType.getExperience());
		buffer.writeVarInt(recipeType.getCookingTime());
	}
	
	public interface IFactory<T extends InfusionRecipe> {
		T create(ResourceLocation recipeId, String group, Ingredient ingredient, ItemStack result, float experience, int cookingTime);
	}

}
