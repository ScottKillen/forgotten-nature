package assets.forgottennature.WorldGen;
import java.util.Random;

import assets.forgottennature.forgottennature;

import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class genPalm extends WorldGenerator
{
    int leaf;
    int leafmeta;
    int logmeta;
    int log;
    public genPalm(int i, int j, int l, int k)
    {
        leaf = i;
        leafmeta = j;
        log = l;
        logmeta = k;
    }
    public boolean generate(World world, Random random, int i, int j, int k)
    {
        if (world.isRemote)
            return false;

        int i1 = i;
        int j1 = j;
        int k1 = k;
        int dir;
        int met = world.getBlockId(i, j, k);

        while ((met != 3) & (met != 2) & (met != 12))
        {
            j--;
            met = world.getBlockId(i, j, k);

            if (met == 8 | met == 9 | met == 1)
            {
                return false;
            }
        }

        dir = random.nextInt(4);
        int h = 6 + random.nextInt(5);
        if(log == forgottennature.logIDindex+2 && logmeta == 1)
        	h = h-2;

        if (random.nextInt(10) > 0)
        {
            world.setBlock(i, j, k, 3, 0, 2);

            for (j1 = 1; j1 <= h; j1++)
            {
                world.setBlock(i1, j + j1, k, log, logmeta, 2);

                if (j1 == h)
                {
                    leafGen(world, i1, j + j1, k, leaf, leafmeta);
                }
            }
        }
        else//////////////////An Under-arch Growth////////////////////
        {
            if (dir == 0)
            {
                growDirect(world, random, 1, 0, i1, j, k1, h, leaf, leafmeta, log, logmeta);
            }

            if (dir == 1)
            {
                growDirect(world, random, 0, 1, i1, j, k1, h, leaf, leafmeta, log, logmeta);
            }

            if (dir == 2)
            {
                growDirect(world, random, -1, 0, i1, j, k1, h, leaf, leafmeta, log, logmeta);
            }

            if (dir == 3)
            {
                growDirect(world, random, 0, -1, i1, j, k1, h, leaf, leafmeta, log, logmeta);
            }
        }

        return true;
    }
    public static void leafGen(World world, int i3, int j3, int k3, int leaf, int leafmeta)
    {
        for (int x = -3; x <= 3; x++)
        {
            for (int y = -3; y <= 3; y++)
            {
                if ((Math.abs(x) + Math.abs(y) <= 3) && world.getBlockId(i3 + x, j3, k3 + y) == 0)
                {
                    world.setBlock(i3 + x, j3, k3 + y, leaf, leafmeta, 2);
                }

                if ((Math.abs(x) + Math.abs(y) == 3) && Math.abs(x) != 0 && Math.abs(y) != 0)
                {
                    world.setBlock(i3 + x, j3, k3 + y, 0, 0, 2);
                }

                if (Math.abs(x) < 2 && Math.abs(y) < 2 && (Math.abs(x) != 1 || Math.abs(y) != 1))
                {
                    world.setBlock(i3 + x, j3 + 1, k3 + y, leaf, leafmeta, 2);
                }
            }
        }
    }
    public static void growDirect(World world, Random random, int iD, int kD, int i2, int j2, int k2, int hight, int leaf, int leafmeta, int log, int logmeta)
    {
        int iind = 0;
        int kind = 0;
        
        world.setBlock(i2, j2, k2, log, logmeta, 2);
        
        if (iD == 1)
        {
            world.setBlock(i2 - 1, j2, k2, log, logmeta, 2);
        }

        if (iD == -1)
        {
            world.setBlock(i2 + 1, j2, k2, log, logmeta, 2);
        }

        if (kD == 1)
        {
            world.setBlock(i2, j2, k2 - 1, log, logmeta, 2);
        }

        if (kD == -1)
        {
            world.setBlock(i2, j2, k2 + 1, log, logmeta, 2);
        }

        for (int j1 = 1; j1 <= hight; j1++)
        {
            if (iD == 1 && random.nextInt(2 + iind) == 0)
            {
                i2++;
            }

            if (iD == -1 && random.nextInt(2 + iind) == 0)
            {
                i2--;
            }

            if (kD == 1 && random.nextInt(2 + kind) == 0)
            {
                k2++;
            }

            if (kD == -1 && random.nextInt(2 + kind) == 0)
            {
                k2--;
            }

            iind++;
            kind++;
            world.setBlock(i2, j1 + j2, k2, log, logmeta, 2);

            if (j1 == hight)
            {
                leafGen(world, i2, j1 + j2, k2, leaf, leafmeta);
            }
        }
    }
}