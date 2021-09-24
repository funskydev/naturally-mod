package elfamoso.naturally.init;

import elfamoso.naturally.Naturally;
import elfamoso.naturally.item.crafting.InfusionRecipe;
import elfamoso.naturally.item.crafting.InfusionRecipeSerializer;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RecipesManager {

	public static final IRecipeType<InfusionRecipe> INFUSION_TYPE = register("infusion");

	public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Naturally.MOD_ID);

	public static final RegistryObject<IRecipeSerializer<InfusionRecipe>> INFUSION_SERIALIZER = RECIPE_SERIALIZERS.register("infusion",
			() -> new InfusionRecipeSerializer<>(InfusionRecipe::new, 10));

	static <T extends IRecipe<?>> IRecipeType<T> register(String name) {

		return IRecipeType.register(Naturally.MOD_ID + ":" + name);

	}

}
