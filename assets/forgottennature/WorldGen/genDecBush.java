package assets.forgottennature.WorldGen;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class genDecBush extends WorldGenerator
{
    int leaf;
    int leafmeta;
    int logmeta;
    public genDecBush(int i, int j, int k)
    {
        leaf = i;
        leafmeta = j;
        logmeta = k;
    }
    public boolean generate(World world, Random random, int i, int j, int k)
    {
    	if(world.isRemote)
    		return false;
        int i1 = i;
        int j1 = j;
        int k1 = k;
        int met = world.getBlockId(i, j, k);

        while ((met != 3) & (met != 2))
        {
            j--;
            met = world.getBlockId(i, j, k);

            if (met == 8 | met == 9 | met == 1)
            {
                return false;
            }
        }

        world.setBlock(i1, j, k1, 3, 0, 2);
        j1 = j + 1;
        world.setBlock(i1, j1, k1, 17, 0, 2);
        int r = random.nextInt(11);

        if (r > 2)
        {
            leafGen(world, random, 2, r, i1, j1, k1, leaf, leafmeta);
        }

        if (r == 2 || r == 1)
        {
            world.setBlock(i1, j1 + 1, k1, 17, 0, 2);
            world.setBlock(i1, j1, k1 + 1, 17, 0, 2);
            world.setBlock(i1, j1, k1 - 1, 17, 0, 2);
            world.setBlock(i1 + 1, j1, k1, 17, 0, 2);
            world.setBlock(i1 - 1, j1, k1, 17, 0, 2);
            leafGen(world, random, 2, r, i1, j1, k1, leaf, leafmeta);
        }

        if (r == 0)
        {
            world.setBlock(i1, j1 + 1, k1, 17, 0, 2);
            world.setBlock(i1, j1, k1 + 1, 17, 0, 2);
            world.setBlock(i1, j1, k1 - 1, 17, 0, 2);
            world.setBlock(i1 + 1, j1, k1, 17, 0, 2);
            world.setBlock(i1 - 1, j1, k1, 17, 0, 2);
            leafGen(world, random, 3, r, i1, j1, k1, leaf, leafmeta);
        }

        return true;
    }
    public static void leafGen(World world, Random random, int var, int ran, int i3, int j3, int k3, int leaf, int leafmeta)
    {
    	int met1;
        for (int x = -var; x <= var; x++)
        {
            for (int y = -var; y <= var; y++)
            {
            	met1 = world.getBlockId(i3 + x, j3, k3 + y);
                if (ran > 2)
                {
                    if ((Math.abs(x) != var || Math.abs(y) != var) && (Math.abs(x) != var - 1 || Math.abs(y) != var) && (Math.abs(x) != var || Math.abs(y) != var - 1) && (met1 == 0 || met1 == 31 || met1 == 37 || met1 == 38 || met1 == 78))
                    {
                        world.setBlock(i3 + x, j3, k3 + y, leaf, leafmeta, 2);
                    }

                    if (Math.abs(x) < var && Math.abs(y) < var && (Math.abs(x) != var - 1 || Math.abs(y) != var - 1) && world.getBlockId(i3 + x, j3 + 1, k3 + y) == 0)
                    {
                        world.setBlock(i3 + x, j3 + 1, k3 + y, leaf, leafmeta, 2);
                        if(world.getBlockId(i3 + x, j3 - 1, k3 + y) == 0)
                        	world.setBlock(i3 + x, j3 - 1, k3 + y, leaf, leafmeta, 2);
                    }
                }

                if (ran == 2 || ran == 1)
                {
                    if ((Math.abs(x) != var || Math.abs(y) != var) && (met1 == 0 || met1 == 31 || met1 == 37 || met1 == 38 || met1 == 78))
                    {
                        world.setBlock(i3 + x, j3, k3 + y, leaf, leafmeta, 2);
                    }

                    if ((Math.abs(x) != var || Math.abs(y) != var) && (Math.abs(x) != var - 1 || Math.abs(y) != var) && (Math.abs(x) != var || Math.abs(y) != var - 1) && world.getBlockId(i3 + x, j3 + 1, k3 + y) == 0)
                    {
                        world.setBlock(i3 + x, j3 + 1, k3 + y, leaf, leafmeta, 2);
                        if(world.getBlockId(i3 + x, j3 - 1, k3 + y) == 0)
                        	world.setBlock(i3 + x, j3 - 1, k3 + y, leaf, leafmeta, 2);
                    }

                    if (Math.abs(x) < var && Math.abs(y) < var && (Math.abs(x) != var - 1 || Math.abs(y) != var - 1) && world.getBlockId(i3 + x, j3 + 2, k3 + y) == 0)
                    {
                        world.setBlock(i3 + x, j3 + 2, k3 + y, leaf, leafmeta, 2);
                    }
                }

                if (ran == 0)
                {
                    if ((Math.abs(x) != var || Math.abs(y) != var) && (Math.abs(x) != var - 1 || Math.abs(y) != var) && (Math.abs(x) != var || Math.abs(y) != var - 1) && (met1 == 0 || met1 == 31 || met1 == 37 || met1 == 38 || met1 == 78))
                    {
                        world.setBlock(i3 + x, j3, k3 + y, leaf, leafmeta, 2);
                    }

                    if ((Math.abs(x) + Math.abs(y) < 4) && world.getBlockId(i3 + x, j3 + 1, k3 + y) == 0)
                    {
                        world.setBlock(i3 + x, j3 + 1, k3 + y, leaf, leafmeta, 2);
                        if(world.getBlockId(i3 + x, j3 - 1, k3 + y) == 0)
                        	world.setBlock(i3 + x, j3 - 1, k3 + y, leaf, leafmeta, 2);
                    }

                    if (Math.abs(x) < var && Math.abs(y) < var && (Math.abs(x) + Math.abs(y) < 3) && world.getBlockId(i3 + x, j3 + 2, k3 + y) == 0)
                    {
                        world.setBlock(i3 + x, j3 + 2, k3 + y, leaf, leafmeta, 2);
                    }
                }
            }
        }
    }
}