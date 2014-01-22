package assets.forgottennature.WorldGen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBeach;
import net.minecraft.world.biome.BiomeGenDesert;
import net.minecraft.world.biome.BiomeGenForest;
import net.minecraft.world.biome.BiomeGenHell;
import net.minecraft.world.biome.BiomeGenHills;
import net.minecraft.world.biome.BiomeGenPlains;
import net.minecraft.world.biome.BiomeGenSwamp;
import net.minecraft.world.biome.BiomeGenTaiga;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import assets.forgottennature.forgottennature;
import assets.forgottennature.Biomes.*;

import cpw.mods.fml.common.IWorldGenerator;

public class FNWorldGenerator implements IWorldGenerator 
{

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) 
    {
    	if(world.provider.dimensionId == 0)
    	{
        	int i = chunkX*16;
        	int j = chunkZ*16;
        	BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(i, j);
        	float biomeRain = world.getWorldChunkManager().getBiomeGenAt(i, j).rainfall;
            int il; //= world.getHeightValue(i + random.nextInt(24) + 8, j + random.nextInt(24) + 8);
    		float biomeTemp = world.getWorldChunkManager().getBiomeGenAt(i, j).temperature;
    		float biomeMinHeight = world.getWorldChunkManager().getBiomeGenAt(i, j).minHeight;
            int k;
            int l;
            int num;
            int blackOrBlue;
            
          //new flower generation in all biomes if grass exists
            if(random.nextInt(10) == 0 && !(biome instanceof BiomeGenCrystalForest))
        	{
            	num = random.nextInt(10);
            	for(int ll = 0; ll < forgottennature.flowerGen; ll++)
            	{
                    k = i + random.nextInt(8) + 8;
                    l = j + random.nextInt(8) + 8;
                    il = world.getHeightValue(k, l);
                    if(world.getBlockId(k, il - 1, l) == Block.grass.blockID)
                    {
    	            	world.setBlock(k, il, l, forgottennature.newFlowerID, num, 2);
    	            	world.setBlock(k, il, l, forgottennature.newFlowerID, num, 2);
    	            	world.setBlock(k, il, l, forgottennature.newFlowerID, num, 2);
    	            	world.setBlock(k, il, l, forgottennature.newFlowerID, num, 2);
    	            	world.setBlock(k, il, l, forgottennature.newFlowerID, num, 2);
    	            	world.setBlock(k, il, l, forgottennature.newFlowerID, num, 2);
    	            	world.setBlock(k, il, l, forgottennature.newFlowerID, num, 2);
    	            	world.setBlock(k, il, l, forgottennature.newFlowerID, num, 2);
                    }
            	}
        	}
            for(int ll = 0; ll < 15; ll++)
        	{
            	if(forgottennature.StoneChert && random.nextInt(5) == 0)
            	{
	        		il = i + random.nextInt(10);
	        		k = j + random.nextInt(10);
	        		l = random.nextInt(60) + 4;
	        		new WorldGenMinable(forgottennature.newStonesID,0,10,1).generate(world,random,il,l,k);
	        		l = random.nextInt(25) + 4;
	        		new WorldGenMinable(forgottennature.newStonesID,0,10,1).generate(world,random,il,l,k);
            	}
            	if(forgottennature.StoneGranite && random.nextInt(5) == 0)
            	{
	        		il = i + random.nextInt(10);
	        		k = j + random.nextInt(10);
	        		l = random.nextInt(60) + 4;
	        		new WorldGenMinable(forgottennature.newStonesID,1,20,1).generate(world,random,il,l,k);
	        		l = random.nextInt(25) + 4;
	        		new WorldGenMinable(forgottennature.newStonesID,1,20,1).generate(world,random,il,l,k);
            	}
            	if(forgottennature.StoneGneiss && random.nextInt(5) == 0)
            	{
	        		il = i + random.nextInt(10);
	        		k = j + random.nextInt(10);
	        		l = random.nextInt(60) + 4;
	        		new WorldGenMinable(forgottennature.newStonesID,2,20,1).generate(world,random,il,l,k);
	        		l = random.nextInt(25) + 4;
	        		new WorldGenMinable(forgottennature.newStonesID,2,20,1).generate(world,random,il,l,k);
            	}
            	if(forgottennature.StoneHornfels && random.nextInt(5) == 0)
            	{
	        		il = i + random.nextInt(10);
	        		k = j + random.nextInt(10);
	        		l = random.nextInt(60) + 4;
	        		new WorldGenMinable(forgottennature.newStonesID,3,20,1).generate(world,random,il,l,k);
	        		l = random.nextInt(25) + 4;
	        		new WorldGenMinable(forgottennature.newStonesID,3,20,1).generate(world,random,il,l,k);
            	}
            	if(forgottennature.StoneMarble && random.nextInt(5) == 0)
            	{
	        		il = i + random.nextInt(10);
	        		k = j + random.nextInt(10);
	        		l = random.nextInt(60) + 4;
	        		new WorldGenMinable(forgottennature.newStonesID,4,20,1).generate(world,random,il,l,k);
	        		l = random.nextInt(25) + 4;
	        		new WorldGenMinable(forgottennature.newStonesID,4,20,1).generate(world,random,il,l,k);
            	}
        	}
            //bamboo generation
            if (biomeRain > 0.8F && biomeTemp > 0.5F && !(biome instanceof BiomeGenSwamp))
            {
            	if(random.nextInt(2) == 0)
            	{
    	        	for(int ll = 0; ll < 3; ll++)
    	        	{
    	                k = i + random.nextInt(14) + 8;
    	                l = j + random.nextInt(14) + 8;
    	                il = world.getHeightValue(k, l);
    	                if(world.getBlockId(k, il - 1, l) == Block.grass.blockID && forgottennature.bambooGeneration)
    	                world.setBlock(k, il, l, forgottennature.hempCottonBambooCornID, 8, 2);
    	        	}
            	}
            }
            if (biomeTemp == 0.0F && biomeRain == 0.8F)//taigamountain
            {
            	if (random.nextInt(20) == 0 && forgottennature.cedar) //cedar
                {
                    genCedar tree = new genCedar(forgottennature.leafIDindex+2, 5, forgottennature.logIDindex+1, 2);
                    k = i + random.nextInt(12) +8;
                    l = j + random.nextInt(12) +8;
                    il = world.getHeightValue(k, l);
                    tree.generate(world, random, k, il, l);
                }
            	if (random.nextInt(9) == 0 && forgottennature.everBush) //everBush
                {
                    genEverBush tree = new genEverBush(forgottennature.leafIDindex+2, 2, 1);
                    k = i + random.nextInt(12) +8;
                    l = j + random.nextInt(12) +8;
                    il = world.getHeightValue(k, l);
                    tree.generate(world, random, k, il, l);
                }
            }
          //Trees++ and vanilla biome instances
            if (biome instanceof BiomeGenBeach)
            {
                if (random.nextInt(7) == 0 && forgottennature.palm)
                {
                    genPalm tree = new genPalm(forgottennature.leafIDindex+2, 3, forgottennature.logIDindex, 14); //palm tree
                    k = i + random.nextInt(12) +8;
                    l = j + random.nextInt(12) +8;
                    il = world.getHeightValue(k, l);
                    tree.generate(world, random, k, il, l);
                }

                if (random.nextInt(7) == 0 && forgottennature.banana)
                {
                    genPalm tree = new genPalm(forgottennature.leafIDindex+3, 5, forgottennature.logIDindex+2, 1); //banana tree
                    k = i + random.nextInt(12) +8;
                    l = j + random.nextInt(12) +8;
                    il = world.getHeightValue(k, l);
                    tree.generate(world, random, k, il, l);
                }
            }

            if (biome instanceof BiomeGenDesert)
            {
                if (random.nextInt(45) == 0 && forgottennature.DesertIronwood) //ironwood
                {
                    genDesertTree tree = new genDesertTree(forgottennature.leafIDindex, 6, forgottennature.logIDindex, 2);
                    k = i + random.nextInt(12) +8;
                    l = j + random.nextInt(12) +8;
                    il = world.getHeightValue(k, l);
                    tree.generate(world, random, k, il, l);
                }

                if (random.nextInt(50) == 0 && forgottennature.Joshua) //joshua
                {
                    genJoshua tree = new genJoshua(forgottennature.leafIDindex+1, 7, forgottennature.logIDindex, 10);
                    k = i + random.nextInt(12) +8;
                    l = j + random.nextInt(12) +8;
                    il = world.getHeightValue(k, l);
                    tree.generate(world, random, k, il, l);
                }

                if (random.nextInt(51) == 0 && forgottennature.dWillow) //dWillow
                {
                    genDWillow tree = new genDWillow(forgottennature.leafIDindex+2, 4, forgottennature.logIDindex+1, 0);
                    k = i + random.nextInt(12) +8;
                    l = j + random.nextInt(12) +8;
                    il = world.getHeightValue(k, l);
                    tree.generate(world, random, k, il, l);
                }
            }

            if ((biome instanceof BiomeGenPlains))
            {
                if (random.nextInt(12) == 0 && forgottennature.Cypress) //cypress
                {
                    genCypress tree = new genCypress(forgottennature.leafIDindex, 5, 17, 1);
                    k = i + random.nextInt(12) +8;
                    l = j + random.nextInt(12) +8;
                    il = world.getHeightValue(k, l);
                    tree.generate(world, random, k, il, l);
                }

                if (random.nextInt(14) == 0 && forgottennature.poplar) //poplar
                {
                    int size = 2 + random.nextInt(6);
                    genPoplar tree = new genPoplar(forgottennature.leafIDindex+2, 7, 17, 1);
                    k = i + random.nextInt(12) +8;
                    l = j + random.nextInt(12) +8;
                    il = world.getHeightValue(k, l);
                    tree.generate(world, random, k, il, l);
                }

                if (random.nextInt(24) == 0 && forgottennature.Acacia) //acacia
                {
                    genAcacia tree = new genAcacia(forgottennature.leafIDindex+1, 6, forgottennature.logIDindex, 8);
                    k = i + random.nextInt(12) +8;
                    l = j + random.nextInt(12) +8;
                    il = world.getHeightValue(k, l);
                    tree.generate(world, random, k, il, l);
                }

                if (random.nextInt(60) == 0 && forgottennature.Fig) //fig
                {
                    genFig tree = new genFig(forgottennature.leafIDindex, 4, 0, 2);
                    k = i + random.nextInt(12) +8;
                    l = j + random.nextInt(12) +8;
                    il = world.getHeightValue(k, l);
                    tree.generate(world, random, k, il, l);
                }
            }

            if ((biome instanceof BiomeGenHills))
            {
                if (random.nextInt(40) == 0 && forgottennature.huckleberry)//huckleberrybush
                {
                    genFruitBush tree = new genFruitBush(forgottennature.leafIDindex+5, 0, 0);
                    k = i + random.nextInt(12) +8;
                    l = j + random.nextInt(12) +8;
                    il = world.getHeightValue(k, l);
                    tree.generate(world, random, k, il, l);
                }
            }

            if ((biome instanceof BiomeGenForest))
            {
                if (random.nextInt(80) == 0 && forgottennature.bukkit) //bukkit
                {
                    genBukkit tree = new genBukkit(forgottennature.leafIDindex+3, 4, forgottennature.logIDindex+2, 0);
                    k = i + random.nextInt(12) +8;
                    l = j + random.nextInt(12) +8;
                    il = world.getHeightValue(k, l);
                    tree.generate(world, random, k, il, l);
                }

                if (random.nextInt(30) == 0 && forgottennature.raspberry) //raspberrybush
                {
                    genFruitBush tree = new genFruitBush(forgottennature.leafIDindex+4, 3, 0);
                    k = i + random.nextInt(12) +8;
                    l = j + random.nextInt(12) +8;
                    il = world.getHeightValue(k, l);
                    tree.generate(world, random, k, il, l);
                }
                
                if (random.nextInt(30) == 0 && forgottennature.blueberry) //blueberrybush
                {
                    genFruitBush tree = new genFruitBush(forgottennature.leafIDindex+4, 1, 0);
                    k = i + random.nextInt(12) +8;
                    l = j + random.nextInt(12) +8;
                    il = world.getHeightValue(k, l);
                    tree.generate(world, random, k, il, l);
                }

                if (random.nextInt(30) == 0 && forgottennature.blackberry) //blackberrybush
                {
                    genFruitBush tree = new genFruitBush(forgottennature.leafIDindex+4, 5, 0);
                    k = i + random.nextInt(12) +8;
                    l = j + random.nextInt(12) +8;
                    il = world.getHeightValue(k, l);
                    tree.generate(world, random, k, il, l);
                }

                if (random.nextInt(40) == 0 && forgottennature.Apple) //apple
                {
                    genFruit tree = new genFruit(true, forgottennature.leafIDindex+1, 3, 17, 0, 1);
                    k = i + random.nextInt(12) +8;
                    l = j + random.nextInt(12) +8;
                    il = world.getHeightValue(k, l);
                    tree.generate(world, random, k, il, l);
                }

                if (random.nextInt(40) == 0 && forgottennature.orange) //orange
                {
                    genFruit tree = new genFruit(false, forgottennature.leafIDindex+3, 6, forgottennature.logIDindex+2, 2, 1);
                    k = i + random.nextInt(12) +8;
                    l = j + random.nextInt(12) +8;
                    il = world.getHeightValue(k, l);
                    tree.generate(world, random, k, il, l);
                }

                if (random.nextInt(40) == 0 && forgottennature.peach) //peach
                {
                    genFruit tree = new genFruit(false, forgottennature.leafIDindex+3, 7, forgottennature.logIDindex+2, 3, 1);
                    k = i + random.nextInt(12) +8;
                    l = j + random.nextInt(12) +8;
                    il = world.getHeightValue(k, l);
                    tree.generate(world, random, k, il, l);
                }

                if (random.nextInt(40) == 0 && forgottennature.lemon) //lemon
                {
                    genFruit tree = new genFruit(false, forgottennature.leafIDindex+4, 0, forgottennature.logIDindex+2, 4, 1);
                    k = i + random.nextInt(12) +8;
                    l = j + random.nextInt(12) +8;
                    il = world.getHeightValue(k, l);
                    tree.generate(world, random, k, il, l);
                }

                if (random.nextInt(41) == 0 && forgottennature.Cherry) //cherry
                {
                    genCherry tree = new genCherry(forgottennature.leafIDindex+1, 1, forgottennature.logIDindex, 0);
                    k = i + random.nextInt(12) +8;
                    l = j + random.nextInt(12) +8;
                    il = world.getHeightValue(k, l);
                    tree.generate(world, random, k, il, l);
                }

                if (random.nextInt(42) == 0 && forgottennature.Jacaranda) //jacaranda
                {
                    k = i + random.nextInt(12) +8;
                    l = j + random.nextInt(12) +8;
                    il = world.getHeightValue(k, l);
                    new genCherry(forgottennature.leafIDindex, 3, 17, 0).generate(world, random, k, il, l);
                    k = i + random.nextInt(18);
                    l = j + random.nextInt(18);
                    il = world.getHeightValue(k, l);
                    new genCherry(forgottennature.leafIDindex, 3, 17, 0).generate(world, random, k, il, l);
                    k = i + random.nextInt(18);
                    l = j + random.nextInt(18);
                    il = world.getHeightValue(k, l);
                    new genCherry(forgottennature.leafIDindex, 3, 17, 0).generate(world, random, k, il, l);
                    k = i + random.nextInt(18);
                    l = j + random.nextInt(18);
                    il = world.getHeightValue(k, l);
                    new genCherry(forgottennature.leafIDindex, 3, 17, 0).generate(world, random, k, il, l);
                }

                if (random.nextInt(50) == 0 && forgottennature.Eucalyptus) //eucalyptus
                {
                    genEucalyptus tree = new genEucalyptus(forgottennature.leafIDindex, 7, forgottennature.logIDindex, 4);
                    k = i + random.nextInt(12) +8;
                    l = j + random.nextInt(12) +8;
                    il = world.getHeightValue(k, l);
                    tree.generate(world, random, k, il, l);
                }

                if (random.nextInt(50) == 0 && forgottennature.wTopEucalyptus) //WTeucalyptus
                {
                    genWTEucalyptus tree = new genWTEucalyptus(forgottennature.leafIDindex+3, 3, forgottennature.logIDindex+1, 14);
                    k = i + random.nextInt(12) +8;
                    l = j + random.nextInt(12) +8;
                    il = world.getHeightValue(k, l);
                    tree.generate(world, random, k, il, l);
                }

                if (random.nextInt(50) == 0 && forgottennature.walnut) //walnut
                {
                    genWalnut tree = new genWalnut(forgottennature.leafIDindex+3, 1, forgottennature.logIDindex+1, 8);
                    k = i + random.nextInt(12) +8;
                    l = j + random.nextInt(12) +8;
                    il = world.getHeightValue(k, l);
                    tree.generate(world, random, k, il, l);
                }

                if (random.nextInt(50) == 0 && forgottennature.beech) //beech
                {
                    genBeech tree = new genBeech(forgottennature.leafIDindex+3, 0, forgottennature.logIDindex+1, 6);
                    k = i + random.nextInt(12) +8;
                    l = j + random.nextInt(12) +8;
                    il = world.getHeightValue(k, l);
                    tree.generate(world, random, k, il, l);
                }

                if (random.nextInt(51) == 0 && forgottennature.ginkgo) //ginkgo
                {
                    genGinkgo tree = new genGinkgo(forgottennature.leafIDindex+2, 6, forgottennature.logIDindex+1, 4);
                    k = i + random.nextInt(12) +8;
                    l = j + random.nextInt(12) +8;
                    il = world.getHeightValue(k, l);
                    tree.generate(world, random, k, il, l);
                }

                if (random.nextInt(10) == 0 && forgottennature.decBush) //decbush
                {
                    genDecBush tree = new genDecBush(forgottennature.leafIDindex+2, 1, 0);
                    k = i + random.nextInt(12) +8;
                    l = j + random.nextInt(12) +8;
                    il = world.getHeightValue(k, l);
                    tree.generate(world, random, k, il, l);
                }
                
                if (random.nextInt(200) == 0 && forgottennature.AngelOak) //angeloak
                {
                    genAngel tree = new genAngel(forgottennature.leafIDindex, 1);
                    k = i + random.nextInt(12) +8;
                    l = j + random.nextInt(12) +8;
                    il = world.getHeightValue(k, l);
                    tree.generate(world, random, k, il, l);
                }
            }

            if ((biome instanceof BiomeGenSwamp))
            {
                if (random.nextInt(55) == 0 && forgottennature.Willow) //SWillow
                {
                    int size = 2 + random.nextInt(6);
                    genWillow tree = new genWillow(forgottennature.leafIDindex+2, 0, forgottennature.logIDindex, 12, size);
                    k = i + random.nextInt(12) +8;
                    l = j + random.nextInt(12) +8;
                    il = world.getHeightValue(k, l);
                    tree.generate(world, random, k, il, l);
                }
            }

            if ((biome instanceof BiomeGenTaiga))
            {
                if (random.nextInt(20) == 0 && forgottennature.RedMaple) //rMaple
                {
                    genCherry tree = new genCherry(forgottennature.leafIDindex, 0, 17, 0);
                    k = i + random.nextInt(12) +8;
                    l = j + random.nextInt(12) +8;
                    il = world.getHeightValue(k, l);
                    tree.generate(world, random, k, il, l);
                }
                else
                if (random.nextInt(20) == 0 && forgottennature.YellowMaple) //yMaple
                {
                    genCherry tree = new genCherry(forgottennature.leafIDindex, 2, 17, 0);
                    k = i + random.nextInt(12) +8;
                    l = j + random.nextInt(12) +8;
                    il = world.getHeightValue(k, l);
                    tree.generate(world, random, k, il, l);
                }

                if (random.nextInt(150) == 0 && forgottennature.Sequoia) //sequoia
                {
                    genSequoia tree = new genSequoia(forgottennature.leafIDindex+1, 0, forgottennature.logIDindex, 6);
                    k = i + random.nextInt(12) +8;
                    l = j + random.nextInt(12) +8;
                    il = world.getHeightValue(k, l);
                    tree.generate(world, random, k, il, l);
                }
                else
                if (random.nextInt(15) == 0 && forgottennature.cedar) //cedar
                {
                    genCedar tree = new genCedar(forgottennature.leafIDindex+2, 5, forgottennature.logIDindex+1, 2);
                    k = i + random.nextInt(12) +8;
                    l = j + random.nextInt(12) +8;
                    il = world.getHeightValue(k, l);
                    tree.generate(world, random, k, il, l);
                }

                if (random.nextInt(9) == 0 && forgottennature.everBush) //everBush
                {
                    genEverBush tree = new genEverBush(forgottennature.leafIDindex+2, 2, 1);
                    k = i + random.nextInt(12) +8;
                    l = j + random.nextInt(12) +8;
                    il = world.getHeightValue(k, l);
                    tree.generate(world, random, k, il, l);
                }
            }
          //FN biomes
            if (biome instanceof BiomeGenCrystalForest)
            {
            	for (int l2 = 0; l2 < 2; l2++)//crystal 'flower'
                {
	            	if(random.nextInt(60) == 0)
		        		blackOrBlue = 1;
		        	else blackOrBlue = 0;
		        	for (int ll = 0; ll < 15; ll++)
		        	{
		                k = i + random.nextInt(12) +8;
		                l = j + random.nextInt(12) +8;
		                il = world.getHeightValue(k, l);
		                if(world.getBlockId(k, il - 1, l) == Block.grass.blockID || world.getBlockId(k, il - 1, l) == forgottennature.groundID)
		                	world.setBlock(k, il, l, forgottennature.crystalStoneID, blackOrBlue, 2);
		        	}
                }
		        	
            	int size = 2;
            	if(random.nextInt(25) == 0)
                {
                	size = 4;
                	if(random.nextInt(20) == 0)
                		size = 8;
                }
            	for(int iter = 0; iter <= forgottennature.newTreePerChunkCount; iter++)
            	{
	            	if (random.nextInt(20) > 0) //crystal
	                {
	            		genCrystal tree = new genCrystal(forgottennature.leafIDindex+6, 1, forgottennature.crystalWoodID, 0, size);
	                    k = i + random.nextInt(12) +8;
	                    l = j + random.nextInt(12) +8;
	                    il = world.getHeightValue(k, l);
	                    tree.generate(world, random, k, il, l);
	                }
	            	else if (random.nextInt(20) > 0) //darkcrystal
	                {
	            		genCrystal tree = new genCrystal(forgottennature.leafIDindex+6, 0, forgottennature.crystalWoodID, 1, size);
	                    k = i + random.nextInt(12) +8;
	                    l = j + random.nextInt(12) +8;
	                    il = world.getHeightValue(k, l);
	                    tree.generate(world, random, k, il, l);
	                }
	            	if(forgottennature.crystalMushrooms && random.nextInt(80) == 0)
	            	{
	            		genCrystalMushroom tree = new genCrystalMushroom(0);
	                    k = i + random.nextInt(12) +8;
	                    l = j + random.nextInt(12) +8;
	                    il = world.getHeightValue(k, l);
	                    tree.generate(world, random, k, il, l);
	            	}
            	}
            	for(int ll = 0; ll < 15; ll++)
            	{
            		il = i + random.nextInt(10);
            		k = j + random.nextInt(10);
            		l = random.nextInt(64) + 4;
            		new WorldGenMinable(forgottennature.blockCrystalID,2).generate(world,random,il,l,k);
            		l = random.nextInt(25) + 4;
            		new WorldGenMinable(forgottennature.blockCrystalID,2).generate(world,random,il,l,k);
            	}
            }
            if (biome instanceof BiomeGenNeoRedwoodForest || biome instanceof BiomeGenNeoRedwoodForestHills || 
            		biome instanceof BiomeGenNeoRedwoodForestSnow || biome instanceof BiomeGenNeoRedwoodForestSnowHills)
            {
            	for(int iter = 0; iter <= forgottennature.newTreePerChunkCount; iter++)
            	{
	            	if (random.nextInt(10) == 0 && forgottennature.Sequoia) //sequoia
	                {
	            		genSequoia tree = new genSequoia(forgottennature.leafIDindex+1, 0, forgottennature.logIDindex, 6);
	                    k = i + random.nextInt(12) +8;
	                    l = j + random.nextInt(12) +8;
	                    il = world.getHeightValue(k, l);
	                    tree.generate(world, random, k, il, l);
	                }
	            	else
	            	if (random.nextInt(3) > 0 && forgottennature.cedar) //cedar
	                {
	            		genCedar tree = new genCedar(forgottennature.leafIDindex+2, 5, forgottennature.logIDindex+1, 2);
	                    k = i + random.nextInt(12) +8;
	                    l = j + random.nextInt(12) +8;
	                    il = world.getHeightValue(k, l);
	                    tree.generate(world, random, k, il, l);
	                }
	            	else if (forgottennature.everBush) // evergreenBush
	                {
	            		genEverBush tree = new genEverBush(forgottennature.leafIDindex+2, 2, 1);
	                    k = i + random.nextInt(12) +8;
	                    l = j + random.nextInt(12) +8;
	                    il = world.getHeightValue(k, l);
	                    tree.generate(world, random, k, il, l);
	                }
            	}
            }
            if (biome instanceof BiomeGenTropicalForest || biome instanceof BiomeGenNeoTropicalForestHills)
            {
            	for(int iter = 0; iter <= forgottennature.newTreePerChunkCount; iter++)
            	{
	            	if (random.nextInt(30) == 0 && forgottennature.beech) //beech
	                {
	                    genBeech tree = new genBeech(forgottennature.leafIDindex+3, 0, forgottennature.logIDindex+1, 6);
	                    k = i + random.nextInt(12) +8;
	                    l = j + random.nextInt(12) +8;
	                    il = world.getHeightValue(k, l);
	                    tree.generate(world, random, k, il, l);
	                }
	            	else
	            	if (random.nextInt(11) == 0 && forgottennature.wTopEucalyptus) //genWTEucalyptus
	                {
	            		genWTEucalyptus tree = new genWTEucalyptus(forgottennature.leafIDindex+3, 3, forgottennature.logIDindex+1, 14);
	                    k = i + random.nextInt(12) +8;
	                    l = j + random.nextInt(12) +8;
	                    il = world.getHeightValue(k, l);
	                    tree.generate(world, random, k, il, l);
	                }
	            	else
	            	if (random.nextInt(11) == 0 && forgottennature.Eucalyptus) //genEucalyptus
	                {
	            		genEucalyptus tree = new genEucalyptus(forgottennature.leafIDindex, 7, forgottennature.logIDindex, 4);
	                    k = i + random.nextInt(12) +8;
	                    l = j + random.nextInt(12) +8;
	                    il = world.getHeightValue(k, l);
	                    tree.generate(world, random, k, il, l);
	                }
	            	else
	            	if (random.nextInt(50) == 0 && forgottennature.bukkit) //bukkit
	                {
	            		genBukkit tree = new genBukkit(forgottennature.leafIDindex+3, 4, forgottennature.logIDindex+2, 0);
	                    k = i + random.nextInt(12) +8;
	                    l = j + random.nextInt(12) +8;
	                    il = world.getHeightValue(k, l);
	                    tree.generate(world, random, k, il, l);
	                }
	            	else
	            	if (random.nextInt(30) == 0 && forgottennature.raspberry) //rasp
	                {
	            		genFruitBush tree = new genFruitBush(forgottennature.leafIDindex+4, 3, 0);
	                    k = i + random.nextInt(12) +8;
	                    l = j + random.nextInt(12) +8;
	                    il = world.getHeightValue(k, l);
	                    tree.generate(world, random, k, il, l);
	                }
	            	else
	            	if (random.nextInt(30) == 0 && forgottennature.blueberry) //blue
	                {
	            		genFruitBush tree = new genFruitBush(forgottennature.leafIDindex+4, 1, 0);
	                    k = i + random.nextInt(12) +8;
	                    l = j + random.nextInt(12) +8;
	                    il = world.getHeightValue(k, l);
	                    tree.generate(world, random, k, il, l);
	                }
	            	else
	            	if (random.nextInt(30) == 0 && forgottennature.blackberry) //black
	                {
	            		genFruitBush tree = new genFruitBush(forgottennature.leafIDindex+4, 5, 0);
	                    k = i + random.nextInt(12) +8;
	                    l = j + random.nextInt(12) +8;
	                    il = world.getHeightValue(k, l);
	                    tree.generate(world, random, k, il, l);
	                }
	            	else
	            	if (random.nextInt(50) == 0 && forgottennature.Apple) //apple
	                {
	            		genFruit tree = new genFruit(true, forgottennature.leafIDindex+1, 3, 17, 0, 1);
	                    k = i + random.nextInt(12) +8;
	                    l = j + random.nextInt(12) +8;
	                    il = world.getHeightValue(k, l);
	                    tree.generate(world, random, k, il, l);
	                }
	            	else
	            	if (random.nextInt(50) == 0 && forgottennature.orange) //orange
	                {
	            		genFruit tree = new genFruit(false, forgottennature.leafIDindex+3, 6, forgottennature.logIDindex+2, 2, 1);
	                    k = i + random.nextInt(12) +8;
	                    l = j + random.nextInt(12) +8;
	                    il = world.getHeightValue(k, l);
	                    tree.generate(world, random, k, il, l);
	                }
	            	else
	            	if (random.nextInt(50) == 0 && forgottennature.peach) //peach
	                {
	            		genFruit tree = new genFruit(false, forgottennature.leafIDindex+3, 7, forgottennature.logIDindex+2, 3, 1);
	                    k = i + random.nextInt(12) +8;
	                    l = j + random.nextInt(12) +8;
	                    il = world.getHeightValue(k, l);
	                    tree.generate(world, random, k, il, l);
	                }
	            	else
	            	if (random.nextInt(50) == 0 && forgottennature.lemon) //lemon
	                {
	            		genFruit tree = new genFruit(false, forgottennature.leafIDindex+4, 0, forgottennature.logIDindex+2, 4, 1);
	                    k = i + random.nextInt(12) +8;
	                    l = j + random.nextInt(12) +8;
	                    il = world.getHeightValue(k, l);
	                    tree.generate(world, random, k, il, l);
	                }
	            	else
	            	if (random.nextInt(50) == 0 && forgottennature.Cherry) //cherry
	                {
	            		genCherry tree = new genCherry(forgottennature.leafIDindex+1, 1, forgottennature.logIDindex, 0);
	                    k = i + random.nextInt(12) +8;
	                    l = j + random.nextInt(12) +8;
	                    il = world.getHeightValue(k, l);
	                    tree.generate(world, random, k, il, l);
	                }
	            	else
	                if (random.nextInt(61) == 0 && forgottennature.walnut) //walnut
	                {
	                    genWalnut tree = new genWalnut(forgottennature.leafIDindex+3, 1, forgottennature.logIDindex+1, 8);
	                    k = i + random.nextInt(12) +8;
	                    l = j + random.nextInt(12) +8;
	                    il = world.getHeightValue(k, l);
	                    tree.generate(world, random, k, il, l);
	                }
	                else
	                if (random.nextInt(60) == 0 && forgottennature.ginkgo) //ginkgo
	                {
	                    genGinkgo tree = new genGinkgo(forgottennature.leafIDindex+2, 6, forgottennature.logIDindex+1, 4);
	                    k = i + random.nextInt(12) +8;
	                    l = j + random.nextInt(12) +8;
	                    il = world.getHeightValue(k, l);
	                    tree.generate(world, random, k, il, l);
	                }
	                if (random.nextInt(42) == 0 && forgottennature.Jacaranda) //jacaranda
	                {
	                    k = i + random.nextInt(12) +8;
	                    l = j + random.nextInt(12) +8;
	                    il = world.getHeightValue(k, l);
	                    new genCherry(forgottennature.leafIDindex, 3, 17, 0).generate(world, random, k, il, l);
	                    k = i + random.nextInt(18);
	                    l = j + random.nextInt(18);
	                    il = world.getHeightValue(k, l);
	                    new genCherry(forgottennature.leafIDindex, 3, 17, 0).generate(world, random, k, il, l);
	                    k = i + random.nextInt(18);
	                    l = j + random.nextInt(18);
	                    il = world.getHeightValue(k, l);
	                    new genCherry(forgottennature.leafIDindex, 3, 17, 0).generate(world, random, k, il, l);
	                    k = i + random.nextInt(18);
	                    l = j + random.nextInt(18);
	                    il = world.getHeightValue(k, l);
	                    new genCherry(forgottennature.leafIDindex, 3, 17, 0).generate(world, random, k, il, l);
	                }
	                else if (forgottennature.decBush)
	                {
	                    genDecBush tree = new genDecBush(forgottennature.leafIDindex+2, 1, 0);
	                    k = i + random.nextInt(18) + 6;
	                    l = j + random.nextInt(18) + 6;
	                    il = world.getHeightValue(k, l);
	                    tree.generate(world, random, k, il, l);
	                }
            	}
            }
            
            if (biome instanceof BiomeGenHell)
            {
	            if (random.nextInt(15) == 0) //nether ash
	            {
	                genNetherTree tree = new genNetherTree(0, 0, 1);
	                k = i + random.nextInt(12) +8;
	                l = j + random.nextInt(12) +8;
	                il = 80;
	                tree.generate(world, random, k, il, l);
	            }
	            else if (random.nextInt(15) == 0) //nether blaze
	            {
	                genNetherTree tree = new genNetherTree(1, 1, 1);
	                k = i + random.nextInt(12) +8;
	                l = j + random.nextInt(12) +8;
	                il = 80;
	                tree.generate(world, random, k, il, l);
	            }
	            else if (random.nextInt(15) == 0)//nether mushroom
	            {
	            	genNetherMushroom tree = new genNetherMushroom(forgottennature.logIDindex+4);
	                k = i + random.nextInt(12) +8;
	                l = j + random.nextInt(12) +8;
	                il = 80;
	                tree.generate(world, random, k, il, l);
	            }
            }
        }
    }
}
