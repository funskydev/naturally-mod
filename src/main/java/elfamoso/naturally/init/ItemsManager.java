package elfamoso.naturally.init;

import elfamoso.naturally.Naturally;
import elfamoso.naturally.item.CustomSpawnEggItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemsManager {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Naturally.MOD_ID);
	
	public static final RegistryObject<CustomSpawnEggItem> PENGUIN_SPAWN_EGG = ITEMS.register("penguin_spawn_egg",
            () -> new CustomSpawnEggItem(EntitiesManager.PENGUIN, 0x141412, 0xF9B417, new Item.Properties().tab(ItemGroup.TAB_MISC)));
	
	public static final RegistryObject<CustomSpawnEggItem> RAT_SPAWN_EGG = ITEMS.register("rat_spawn_egg",
            () -> new CustomSpawnEggItem(EntitiesManager.RAT, 0x141412, 0xF9B417, new Item.Properties().tab(ItemGroup.TAB_MISC)));
	
	public static final RegistryObject<BlockItem> OAK_STUMP = ITEMS.register("oak_stump",
            () -> new BlockItem(BlocksManager.OAK_STUMP.get(), new Item.Properties().tab(ItemGroup.TAB_DECORATIONS)));
	
	public static final RegistryObject<BlockItem> SPRUCE_STUMP = ITEMS.register("spruce_stump",
            () -> new BlockItem(BlocksManager.SPRUCE_STUMP.get(), new Item.Properties().tab(ItemGroup.TAB_DECORATIONS)));
	
	public static final RegistryObject<BlockItem> INFUSION_TABLE = ITEMS.register("infusion_table",
            () -> new BlockItem(BlocksManager.INFUSION_TABLE.get(), new Item.Properties().tab(ItemGroup.TAB_DECORATIONS)));
	
}