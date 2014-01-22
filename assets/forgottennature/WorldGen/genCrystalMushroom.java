package assets.forgottennature.WorldGen;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import assets.forgottennature.forgottennature;

public class genCrystalMushroom extends WorldGenerator

{
	int type;
    int block = forgottennature.mushroomBlockID;
    
    public genCrystalMushroom(int flag)
    {
        type = flag;
    }
    public boolean generate(World world, Random random, int i, int j, int k)
    {
    	if(world.isRemote)
    		return false;

        int l = random.nextInt(15) + 6;//height
        if (random.nextInt(10) == 0)
        	l = l + random.nextInt(10) + 1;
        
        if (j < 4 || j + l + 1 >= 256)
        {
            return false;
        }
        
        int met = world.getBlockId(i, j, k);
        
        while ((met != 3) && (met != 1) && (met != 2) && met != forgottennature.groundID && met != forgottennature.mushroomBlockID)
        {
            j--;
            met = world.getBlockId(i, j, k);

            if (met == 8 | met == 9 | met == 1)
            {
                return false;
            }
        }
        j = j + 1;

        world.setBlock(i, j - 1, k, forgottennature.groundID, 0, 2);

        for (int l1 = 0; l1 < l; l1++)
        {
        	if(l > 17)
        	{
        		for (int x = -1; x < 2; x++)
        		{
        			for (int y = -1; y < 2; y++)
        			{
        				if (Math.abs(x) + Math.abs(y) < 2)
        					world.setBlock(i + x, j + l1, k + y, block, 0, 2);
        			}
        		}
        	}
        	else
        		world.setBlock(i, j + l1, k, block, 0, 2);

            if (l1 == l - 1)
            {
                genCap(world, random, type, i, j + l1, k, block, 1, l);
            }
        }

        return true;
    }
    public static void genCap(World world, Random random, int type, int i3, int j3, int k3, int block, int blockmeta, int l)
    {
    	int height = l/6;
    	int mult;
    	int tier = 0;
    	int x = 0;
    	j3 = j3 + 1;
        for (int z = 0; z <= random.nextInt(Math.abs(l/2 - 2)) + 2; z++)
        {
            for (int y = -height; y <= height; y++)
            {
            	for (x = -height; x <= height; x++)
            	{
            		mult = x*x+y*y;
	                if (mult <= height * height && mult >= (tier) * (tier))
	                {
	                    if (world.getBlockId(i3 + x, j3 - z, k3 + y) == 0)
	                    {
	                        world.setBlock(i3 + x, j3 - z, k3 + y, block, blockmeta, 2);
	                    }
	                }
	                if(x == height && y == x)
	                	tier = x;
            	}
            }
            if(height == l/6)
            	height = l/3;
            else if(height == l/3)
            	height = l/2;
            else if(height == l/2)
            	height = l * 2/3;
            else
            	height = l * 5/6;
        }
    }
}

