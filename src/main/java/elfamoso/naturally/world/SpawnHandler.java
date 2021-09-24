package elfamoso.naturally.world;

import elfamoso.naturally.init.EntitiesManager;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class SpawnHandler {

	public static void onBiomeLoading(BiomeLoadingEvent e) {
		
        String biome = e.getName().toString();
        if (biome == null) return;
        
        //Biome biome = ForgeRegistries.BIOMES.getValue(biomeName);
        
        if(checkBiome(biome, Biomes.ICE_SPIKES) || checkBiome(biome, Biomes.FROZEN_RIVER) || checkBiome(biome, Biomes.FROZEN_OCEAN) || checkBiome(biome, Biomes.SNOWY_BEACH) || checkBiome(biome, Biomes.SNOWY_TUNDRA) || checkBiome(biome, Biomes.DEEP_FROZEN_OCEAN)) {
        	registerEntitySpawn(EntitiesManager.PENGUIN.get(), 3, 2, 7, EntityClassification.CREATURE, e);
        }
        
        if(checkBiome(biome, Biomes.JUNGLE) || checkBiome(biome, Biomes.JUNGLE_EDGE) || checkBiome(biome, Biomes.JUNGLE_HILLS)) {
        	registerEntitySpawn(EntitiesManager.RAT.get(), 35, 6, 8, EntityClassification.CREATURE, e);
        }
        
    }
	
	private static void registerEntitySpawn(EntityType<?> entity, int spawnRate, int minGroupSize, int maxGroupSize, EntityClassification classification, BiomeLoadingEvent e) {
		
        e.getSpawns().getSpawner(classification).add(new MobSpawnInfo.Spawners(entity, spawnRate, minGroupSize, maxGroupSize));
        
    }
	
	private static boolean checkBiome(String biome, RegistryKey<Biome> biomeReg) {
		
		if(biome.equals(biomeReg.location().toString())) return true;
		else return false;
		
	}
	
}
