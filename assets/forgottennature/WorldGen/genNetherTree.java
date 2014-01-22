package assets.forgottennature.WorldGen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import assets.forgottennature.forgottennature;

public class genNetherTree extends WorldGenerator
{
    int leaf = forgottennature.leafIDindex+7;
    int leafmeta;
    int I;
    int log = forgottennature.logIDindex+4;
    int logmeta;
    int dir = 0;
    public genNetherTree(int i, int k, int is)
    {
        leafmeta = i;
        logmeta = k;
        I = is;
    }
    public boolean generate(World world, Random random, int i, int j, int k)
    {
    	if(world.isRemote)
    		return false;
        if (I == 0)
        {
            return false;
        }

        int l = random.nextInt(3) + 2;

        if (j < 1 || j + l + 1 > 256)
        {
            return false;
        }

        int ID = world.getBlockId(i, j - 1, k);
        
        while (ID != Block.netherrack.blockID)//check growable spot
        {
            j--;
            ID = world.getBlockId(i, j, k);

            if (ID == 8 || ID == 9 || ID == 1 || ID == 7)
            {
                return false;
            }
        }
        if(world.getBlockId(i, j+1, k) != 0)
        	return false;
        
        j = j + 1;

        int brightest = world.getBlockLightValue(i, j, k);
        int next = 0;
        world.setBlock(i, j - 1, k, Block.netherrack.blockID, 0, 2);
        world.setBlock(i, j + 1, k, log, logmeta, 2);
        
        for(int x = - 1; x < 2; x++)
        {
        	for(int y = - 1; y < 2; y++)
        	{
        		next = world.getBlockLightValue(i + x, j, k + y);
        		if (next > brightest)
        		{
        			brightest = next;
        			if (x == -1 && y == x)
        				dir = 1;
        			else
        			if (x == -1 && y == 0)
        				dir = 2;
        			else
        			if (x == -1 && y == 1)
        				dir = 3;
        			else
        			if (x == 0 && y == 1)
        				dir = 4;
        			else
        			if (x == 1 && y == x)
        				dir = 5;
        			else
        			if (x == 1 && y == 0)
        				dir = 6;
        			else
        			if (x == 1 && y == -1)
        				dir = 7;
        			else
        			if (x == 0 && y == -1)
        				dir = 8;
        		}
        	}
        }
        
        for (int l1 = 0; l1 < l; l1++)
        {
        	if(dir == 0)
        	{
        		world.setBlock(i, j + l1, k, log, logmeta, 2);
        		if (l1 == l - 1)
                    genLeaves(world, random, i, j + l1, k, leaf, leafmeta);
        		for (int j3 = 0; j3 <= 1; j3++)
                {
                    if (random.nextInt(8) == 0)
                    {
                        branches(world, random, i, j + j3, k, 1, 0, leaf, leafmeta, log, logmeta);
                    }
                    if (random.nextInt(8) == 0)
                    {
                        branches(world, random, i, j + j3, k, -1, 0, leaf, leafmeta, log, logmeta);
                    }
                    if (random.nextInt(8) == 0)
                    {
                        branches(world, random, i, j + j3, k, -1, 1, leaf, leafmeta, log, logmeta);
                    }
                    if (random.nextInt(8) == 0)
                    {
                        branches(world, random, i, j + j3, k, 0, 1, leaf, leafmeta, log, logmeta);
                    }
                    if (random.nextInt(8) == 0)
                    {
                        branches(world, random, i, j + j3, k, 0, -1, leaf, leafmeta, log, logmeta);
                    }
                    if (random.nextInt(8) == 0)
                    {
                        branches(world, random, i, j + j3, k, 1, 1, leaf, leafmeta, log, logmeta);
                    }
                    if (random.nextInt(8) == 0)
                    {
                        branches(world, random, i, j + j3, k, -1, -1, leaf, leafmeta, log, logmeta);
                    }
                    if (random.nextInt(8) == 0)
                    {
                        branches(world, random, i, j + j3, k, 1, -1, leaf, leafmeta, log, logmeta);
                    }
                }
        	}
        	else
        	if(dir == 1)
        	{
        		world.setBlock(i - 1*l1, j + l1, k - 1*l1, log, logmeta, 2);
        		if (l1 == l - 1)
                    genLeaves(world, random, i - 1*l1, j + l1, k - 1*l1, leaf, leafmeta);
        		for (int j3 = 0; j3 <= 1; j3++)
                {
                    if (random.nextInt(2) == 0)
                    {
                        branches(world, random, i, j + j3, k, -1, 0, leaf, leafmeta, log, logmeta);
                    }

                    if (random.nextInt(2) == 0)
                    {
                        branches(world, random, i, j + j3, k, 0, -1, leaf, leafmeta, log, logmeta);
                    }
                }
        	}
        	else
        	if(dir == 2)
        	{
        		world.setBlock(i - 1*l1, j + l1, k, log, logmeta, 2);
        		if (l1 == l - 1)
                    genLeaves(world, random, i - 1*l1, j + l1, k, leaf, leafmeta);
        		for (int j3 = 0; j3 <= 1; j3++)
                {
                    if (random.nextInt(2) == 0)
                    {
                        branches(world, random, i, j + j3, k, -1, -1, leaf, leafmeta, log, logmeta);
                    }

                    if (random.nextInt(2) == 0)
                    {
                        branches(world, random, i, j + j3, k, -1, 1, leaf, leafmeta, log, logmeta);
                    }
                }
        	}
        	else
        	if(dir == 3)
        	{
        		world.setBlock(i - 1*l1, j + l1, k + 1*l1, log, logmeta, 2);
        		if (l1 == l - 1)
                    genLeaves(world, random, i - 1*l1, j + l1, k + 1*l1, leaf, leafmeta);
        		for (int j3 = 0; j3 <= 1; j3++)
                {
                    if (random.nextInt(2) == 0)
                    {
                        branches(world, random, i, j + j3, k, -1, 0, leaf, leafmeta, log, logmeta);
                    }

                    if (random.nextInt(2) == 0)
                    {
                        branches(world, random, i, j + j3, k, 1, 0, leaf, leafmeta, log, logmeta);
                    }
                }
        	}
        	else
        	if(dir == 4)
        	{
        		world.setBlock(i, j + l1, k + 1*l1, log, logmeta, 2);
        		if (l1 == l - 1)
                    genLeaves(world, random, i, j + l1, k + 1*l1, leaf, leafmeta);
        		for (int j3 = 0; j3 <= 1; j3++)
                {
                    if (random.nextInt(2) == 0)
                    {
                        branches(world, random, i, j + j3, k, -1, 1, leaf, leafmeta, log, logmeta);
                    }

                    if (random.nextInt(2) == 0)
                    {
                        branches(world, random, i, j + j3, k, 1, 1, leaf, leafmeta, log, logmeta);
                    }
                }
        	}
        	else
        	if(dir == 5)
        	{
        		world.setBlock(i + 1*l1, j + l1, k + 1*l1, log, logmeta, 2);
        		if (l1 == l - 1)
                    genLeaves(world, random, i + 1*l1, j + l1, k + 1*l1, leaf, leafmeta);
        		for (int j3 = 0; j3 <= 1; j3++)
                {
                    if (random.nextInt(2) == 0)
                    {
                        branches(world, random, i, j + j3, k, 0, 1, leaf, leafmeta, log, logmeta);
                    }

                    if (random.nextInt(2) == 0)
                    {
                        branches(world, random, i, j + j3, k, 1, 0, leaf, leafmeta, log, logmeta);
                    }
                }
        	}
        	else
    		if(dir == 6)
    		{
        		world.setBlock(i + 1*l1, j + l1, k, log, logmeta, 2);
        		if (l1 == l - 1)
                    genLeaves(world, random, i + 1*l1, j + l1, k, leaf, leafmeta);
        		for (int j3 = 0; j3 <= 1; j3++)
                {
                    if (random.nextInt(2) == 0)
                    {
                        branches(world, random, i, j + j3, k, 1, 1, leaf, leafmeta, log, logmeta);
                    }

                    if (random.nextInt(2) == 0)
                    {
                        branches(world, random, i, j + j3, k, 1, -1, leaf, leafmeta, log, logmeta);
                    }
                }
    		}
    		else
        	if(dir == 7)
        	{
        		world.setBlock(i + 1*l1, j + l1, k - 1*l1, log, logmeta, 2);
        		if (l1 == l - 1)
                    genLeaves(world, random, i + 1*l1, j + l1, k - 1*l1, leaf, leafmeta);
        		for (int j3 = 0; j3 <= 1; j3++)
                {
                    if (random.nextInt(2) == 0)
                    {
                        branches(world, random, i, j + j3, k, 1, 0, leaf, leafmeta, log, logmeta);
                    }

                    if (random.nextInt(2) == 0)
                    {
                        branches(world, random, i, j + j3, k, 0, -1, leaf, leafmeta, log, logmeta);
                    }
                }
        	}
        	else
        	if(dir == 8)
        	{
        		world.setBlock(i, j + l1, k - 1*l1, log, logmeta, 2);
        		if (l1 == l - 1)
                    genLeaves(world, random, i, j + l1, k - 1*l1, leaf, leafmeta);
        		for (int j3 = 0; j3 <= 1; j3++)
                {
                    if (random.nextInt(2) == 0)
                    {
                        branches(world, random, i, j + j3, k, -1, -1, leaf, leafmeta, log, logmeta);
                    }

                    if (random.nextInt(2) == 0)
                    {
                        branches(world, random, i, j + j3, k, 1, -1, leaf, leafmeta, log, logmeta);
                    }
                }
        	}
        }
        return true;
    }
    public static void branches(World world, Random random, int ii, int jj, int kk, int iD, int kD, int leaf, int leafmeta, int log, int logmeta)
    {
        for (int br = 0; br < 4; br++)
        {
            if (iD == -1 && random.nextInt(2) == 0)
                ii--;

            if (iD == 1 && random.nextInt(2) == 0)
                ii++;

            if (kD == -1 && random.nextInt(2) == 0)
                kk--;

            if (kD == 1 && random.nextInt(2) == 0)
                kk++;

            world.setBlock(ii, jj, kk,  log, logmeta, 2);

            if (br == 3)
                genLeaves(world, random, ii, jj, kk, leaf, leafmeta);

            jj++;
        }
    }
    public static void genLeaves(World world, Random random, int i3, int j3, int k3, int leaf, int leafmeta)
    {
        for (int x = -2; x <= 2; x++)
        {
            for (int y = -2; y <= 2; y++)
            {
                if (Math.abs(x) != 2 || Math.abs(y) != 2)
                {
                    if (world.getBlockId(i3 + x, j3, k3 + y) == 0)
                    {
                        world.setBlock(i3 + x, j3, k3 + y, leaf, leafmeta, 2);
                    }
                }

                if ((Math.abs(x) < 2 && Math.abs(y) < 2) && (Math.abs(x) != 1 || Math.abs(y) != 1))
                {
                    if (world.getBlockId(i3 + x, j3 + 1, k3 + y) == 0)
                    {
                        world.setBlock(i3 + x, j3 + 1, k3 + y, leaf, leafmeta, 2);
                    }
                }
                
                if ((Math.abs(x) < 2 && Math.abs(y) < 2) && (Math.abs(x) != 1 || Math.abs(y) != 1))
                {
                    if (world.getBlockId(i3 + x, j3 - 1, k3 + y) == 0)
                    {
                        world.setBlock(i3 + x, j3 - 1, k3 + y, leaf, leafmeta, 2);
                    }
                }
            }
        }
    }
}
