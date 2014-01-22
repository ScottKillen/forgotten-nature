package assets.forgottennature.Biomes;

import java.util.Random;

import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;

import assets.forgottennature.WorldGen.genCedar;
import assets.forgottennature.WorldGen.genEverBush;
import assets.forgottennature.WorldGen.genSequoia;


public class BiomeGenNeoRedwoodForest extends BiomeGenBase
{
    public BiomeGenNeoRedwoodForest(int i)
    {
        super(i);
        spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class, 5, 4, 4));
        this.minHeight = 0.1F;
        this.maxHeight = 0.4F;
        this.temperature = 0.7F;
        this.rainfall = 0.7F;
        this.setBiomeName("Redwood Forest");
    }
    
    @Override
	public BiomeDecorator createBiomeDecorator() {
		return new FNBiomeDecorator.Builder(this).treesPerChunk(0)
				.flowersPerChunk(2).grassPerChunk(4).build();
	}
    
    public int getBiomeFoliageColor()
    {
    	double d = (int)((1.0D + 1.0D) / 255D);
	    double d1 = (int)((1.0D + 1.0D) / 255D);
	    d1 /= d;
	    return ((ColorizerFoliage.getFoliageColor(d, d1) & 0x33aa22));
    }
    public int getBiomeGrassColor()
    {
	    double d = (int)((1.0D + 1.0D) / 255D);
	    double d1 = (int)((1.0D + 1.0D) / 255D);
	    d1 /= d;
	    return (ColorizerGrass.getGrassColor(d, d1) & 0x33aa22);
    }
}
