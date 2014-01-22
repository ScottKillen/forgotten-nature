package assets.forgottennature.Biomes;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;

import assets.forgottennature.forgottennature;
import assets.forgottennature.WorldGen.genCrystal;
import assets.forgottennature.WorldGen.genCrystalMushroom;


public class BiomeGenCrystalForest extends BiomeGenBase
{
    public BiomeGenCrystalForest(int par1)
    {
        super(par1);
        spawnableCreatureList.clear();
        this.spawnableCreatureList.add(new SpawnListEntry(EntitySkeleton.class, 10, 1, 1));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityCreeper.class, 10, 1, 1));
        this.spawnableCreatureList.add(new SpawnListEntry(EntitySpider.class, 10, 1, 1));
        this.fillerBlock = (byte)Block.stone.blockID;
        this.minHeight = 0.1F;
        this.maxHeight = 0.3F;
        this.temperature = 0.8F;
        this.rainfall = 0.2F;
        this.setBiomeName("Crystal Forest");
    }
    
    @Override
	public BiomeDecorator createBiomeDecorator() {
		return new FNBiomeDecorator.Builder(this).treesPerChunk(0)
				.flowersPerChunk(0).grassPerChunk(0).build();
	}
    
    public int getBiomeFoliageColor()
    {
    	double d = (int)((1.0D + 1.0D) / 255D);
	    double d1 = (int)((1.0D + 1.0D) / 255D);
	    d1 /= d;
	    return ((ColorizerFoliage.getFoliageColor(d, d1) & 0x51eaec));
    }
    public int getBiomeGrassColor()
    {
	    double d = (int)((1.0D + 1.0D) / 255D);
	    double d1 = (int)((1.0D + 1.0D) / 255D);
	    d1 /= d;
	    return (ColorizerGrass.getGrassColor(d, d1) & 0x51eaec);
    }
}