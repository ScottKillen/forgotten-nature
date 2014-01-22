package assets.forgottennature.Biomes;

import java.util.List;
import java.util.Random;

import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;

public class BiomeGenTropicalForest extends BiomeGenBase
{
    public BiomeGenTropicalForest(int i)
    {
        super(i);
        spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class, 5, 4, 4));
        spawnableMonsterList.add(new SpawnListEntry(EntityOcelot.class, 2, 1, 1));
        this.minHeight = 0.0F;
        this.maxHeight = 0.4F;
        this.temperature = 0.9F;
        this.rainfall = 0.9F;
        this.setBiomeName("Neo Tropical Forest");
    }
    
    @Override
	public BiomeDecorator createBiomeDecorator() {
		return new FNBiomeDecorator.Builder(this).treesPerChunk(0)
				.flowersPerChunk(2).grassPerChunk(8).build();
	}
    
    public int getBiomeFoliageColor()
    {
    	double d = (int)((1.0D + 1.0D) / 255D);
	    double d1 = (int)((1.0D + 1.0D) / 255D);
	    d1 /= d;
	    return ((ColorizerFoliage.getFoliageColor(d, d1) & 0x6ecb01));
    }
    public int getBiomeGrassColor()
    {
	    double d = (int)((1.0D + 1.0D) / 255D);
	    double d1 = (int)((1.0D + 1.0D) / 255D);
	    d1 /= d;
	    return (ColorizerGrass.getGrassColor(d, d1) & 0x6ecb01);
    }
//    public WorldGenerator getRandomWorldGenForTrees(Random random)
//    {
//    	return (WorldGenerator)(random.nextInt(30) == 0 ? new genBeech(mod_forgottennature.leafID4, 0, mod_forgottennature.logID2, 6) : 
//        	(random.nextInt(11) == 0 ? new genWTEucalyptus(mod_forgottennature.leafID4, 3, mod_forgottennature.logID2, 14) : 
//        	(random.nextInt(11) == 0 ? new genEucalyptus(mod_forgottennature.leafID1, 7, mod_forgottennature.logID1, 4) :
//        		(random.nextInt(50) == 0 ? new genBukkit(mod_forgottennature.leafID4, 4, mod_forgottennature.logID3, 0) : 
//        		(random.nextInt(30) == 0 ? new genFruitBush(mod_forgottennature.leafID5, 3, 0) : //rasp
//        			(random.nextInt(30) == 0 ? new genFruitBush(mod_forgottennature.leafID5, 1, 0) : //blue
//        			(random.nextInt(30) == 0 ? new genFruitBush(mod_forgottennature.leafID5, 5, 0) : //black
//        				(random.nextInt(50) == 0 ? new genCocoa(mod_forgottennature.leafID4, 2, mod_forgottennature.logID2, 10):
//        				(random.nextInt(50) == 0 ? new genFruit(true, mod_forgottennature.leafID2, 3, 17, 0, 1) : //apple
//        					(random.nextInt(50) == 0 ? new genFruit(false, mod_forgottennature.leafID4, 6, mod_forgottennature.logID3, 4, 1) : //orange
//        					(random.nextInt(50) == 0 ? new genFruit(false, mod_forgottennature.leafID4, 7, mod_forgottennature.logID3, 6, 1) : //peach
//        						(random.nextInt(50) == 0 ? new genFruit(false, mod_forgottennature.leafID5, 0, mod_forgottennature.logID3, 8, 1) : //lemon
//        						(random.nextInt(50) == 0 ? new genCherry(mod_forgottennature.leafID2, 1, mod_forgottennature.logID1, 0) : //cherry
//        							(random.nextInt(61) == 0 ? new genWalnut(mod_forgottennature.leafID4, 1, mod_forgottennature.logID2, 8) :
//                					(random.nextInt(60) == 0 ? new genGinkgo(mod_forgottennature.leafID3, 6, mod_forgottennature.logID2, 4) :
//        						this.worldGeneratorTrees)))))))))))))));
//    }
}
