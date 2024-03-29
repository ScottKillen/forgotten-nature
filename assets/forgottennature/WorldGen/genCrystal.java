package assets.forgottennature.WorldGen;
import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import assets.forgottennature.forgottennature;

public class genCrystal extends WorldGenerator
{
    int leaf;
    int leafmeta;
    int log;
    int logmeta;
    int size;
    public genCrystal(int i, int j, int k, int l, int m)
    {
        leaf = i;
        leafmeta = j;
        log = k;
        logmeta = l;
        size = m;
    }
    public boolean generate(World world, Random random, int i, int j, int k)
    {
    	if(world.isRemote)
    		return false;
        int i1 = i;
        int j1 = j;
        int k1 = k;
        int met = world.getBlockId(i, j, k);

        while ((met != 3) && (met != 2) && met != forgottennature.groundID)
        {
            j--;
            met = world.getBlockId(i, j, k);

            if (met == 8 | met == 9 | met == 1)
            {
                return false;
            }
        }

        j1 = j + 1;
        int hl;
        int h = random.nextInt(2*size-1) + size;
        if(!forgottennature.crystalGround)
        	world.setBlock(i1, j1 - 1, k1, 3, 0, 2);
        else
        	world.setBlock(i1, j1 - 1, k1, forgottennature.groundID, 0, 2);

        for (int jj = 0; jj <= h; jj++)
        {
            world.setBlock(i1, j1 + jj, k1, log, logmeta, 2);

            if (jj == h)
            {
                leafGen(world, i1, j1 + jj, k1, leaf, leafmeta);
            }

            if (jj > 3 & jj < h)
            {
                hl = h / (jj - 2) + 1;

                if (random.nextInt(hl) == 0)
                {
                    branch(world, random, h, i1, j1, jj, k1, -1, 0, leaf, leafmeta, log, logmeta);
                }

                if (random.nextInt(hl) == 0)
                {
                    branch(world, random, h, i1, j1, jj, k1, 1, 0, leaf, leafmeta, log, logmeta);
                }

                if (random.nextInt(hl) == 0)
                {
                    branch(world, random, h, i1, j1, jj, k1, 0, -1, leaf, leafmeta, log, logmeta);
                }

                if (random.nextInt(hl) == 0)
                {
                    branch(world, random, h, i1, j1, jj, k1, 0, 1, leaf, leafmeta, log, logmeta);
                }

                if (random.nextInt(hl) == 0)
                {
                    branch(world, random, h, i1, j1, jj, k1, -1, 1, leaf, leafmeta, log, logmeta);
                }

                if (random.nextInt(hl) == 0)
                {
                    branch(world, random, h, i1, j1, jj, k1, -1, -1, leaf, leafmeta, log, logmeta);
                }

                if (random.nextInt(hl) == 0)
                {
                    branch(world, random, h, i1, j1, jj, k1, 1, 1, leaf, leafmeta, log, logmeta);
                }

                if (random.nextInt(hl) == 0)
                {
                    branch(world, random, h, i1, j1, jj, k1, 1, -1, leaf, leafmeta, log, logmeta);
                }
            }
        }

        return true;
    }
    public static void branch(World world, Random random, int H, int ii, int j, int jj, int kk, int iD, int kD, int leaf, int leafmeta, int log, int logmeta)
    {
        int index = 0;
        int lengthToGo = H - jj;
        jj = jj + j;

        while (index <= lengthToGo)
        {
            if (iD == -1 && random.nextInt(3) > 0)
            {
                ii--;

                if (kD == 0 && random.nextInt(4) == 0)
                {
                    kk = kk + random.nextInt(3) - 1;
                }
            }

            if (iD == 1 && random.nextInt(3) > 0)
            {
                ii++;

                if (kD == 0 && random.nextInt(4) == 0)
                {
                    kk = kk + random.nextInt(3) - 1;
                }
            }

            if (kD == -1 && random.nextInt(3) > 0)
            {
                kk--;

                if (iD == 0 && random.nextInt(4) == 0)
                {
                    ii = ii + random.nextInt(3) - 1;
                }
            }

            if (kD == 1 && random.nextInt(3) > 0)
            {
                kk++;

                if (iD == 0 && random.nextInt(4) == 0)
                {
                    ii = ii + random.nextInt(3) - 1;
                }
            }

            if (world.getBlockId(ii, j + jj, kk) == 0 || world.getBlockId(ii, j + jj, kk) == leaf)
            {
                world.setBlock(ii, jj, kk, log, logmeta, 2);
            }

            if (random.nextInt(3) > 0)
            {
                jj++;
            }

            if (index == lengthToGo || random.nextInt(6) == 0)
            {
                world.setBlock(ii, jj, kk, log, logmeta, 2);
                leafGen(world, ii, jj, kk, leaf, leafmeta);
            }

            index++;
        }
    }
    public static void leafGen(World world, int i3, int j3, int k3, int leaf, int leafmeta)
    {
        for (int x = -3; x <= 3; x++)
        {
            for (int y = -3; y <= 3; y++)
            {
                if ((Math.abs(x) != 3 || Math.abs(y) != 3) && (Math.abs(x) != 2 || Math.abs(y) != 3) && (Math.abs(x) != 3 || Math.abs(y) != 2) && world.getBlockId(i3 + x, j3, k3 + y) == 0)
                {
                    world.setBlock(i3 + x, j3, k3 + y, leaf, leafmeta, 2);
                }

                if (Math.abs(x) < 3 && Math.abs(y) < 3 && (Math.abs(x) != 2 || Math.abs(y) != 2))
                {
                    if (world.getBlockId(i3 + x, j3 + 1, k3 + y) == 0)
                    {
                        world.setBlock(i3 + x, j3 + 1, k3 + y, leaf, leafmeta, 2);
                    }

                    if (world.getBlockId(i3 + x, j3 - 1, k3 + y) == 0)
                    {
                        world.setBlock(i3 + x, j3 - 1, k3 + y, leaf, leafmeta, 2);
                    }
                }

                if (Math.abs(x) + Math.abs(y) < 2)
                {
                    if (world.getBlockId(i3 + x, j3 + 2, k3 + y) == 0)
                    {
                        world.setBlock(i3 + x, j3 + 2, k3 + y, leaf, leafmeta, 2);
                    }

                    if (world.getBlockId(i3 + x, j3 - 2, k3 + y) == 0)
                    {
                        world.setBlock(i3 + x, j3 - 2, k3 + y, leaf, leafmeta, 2);
                    }
                }
            }
        }
    }
}