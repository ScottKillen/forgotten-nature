package assets.forgottennature.WorldGen;
import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class genWTEucalyptus extends WorldGenerator
{
    int leaf;
    int leafmeta;
    int log;
    int logmeta;
    public genWTEucalyptus(int l, int lm, int i, int k)
    {
        leaf = l;
        leafmeta = lm;
        log = i;
        logmeta = k;
    }
    public boolean generate(World world, Random random, int i, int j, int k)
    {
    	if(world.isRemote)
    		return false;
        int l = random.nextInt(24) + 8;
        int k3 = l;
        int j1 = j;
        int met = world.getBlockId(i, j, k);

        while (met != 3 && met != 2)
        {
            j--;
            met = world.getBlockId(i, j, k);

            if (met == 8 || met == 9 || met == 1)
            {
                return false;
            }
        }

        if (met != 2 && met != 3)
        {
            return false;
        }

        world.setBlock(i, j, k, 3, 0 , 2);

        for (int k1 = 1; k1 <= l; k1++)
        {
            world.setBlock(i, j + k1, k, log, logmeta, 2);
        }

        j1 = j + (l / 2);
        k3 = 1;

        for (; j1 <= j + l; j1++)
        {
            if (random.nextInt(5) > 2 || j1 == j + l)
            {
                if (random.nextInt(20) < 1)
                {
                    k3 = 2;
                }

                if (random.nextInt(4) == 0 && j1 - j > 10 && j1 - j < 20)
                {
                    k3 = 2;
                }

                if (j1 - j >= 20)
                {
                    k3 = 3;
                }

                for (int i2 = -k3; i2 <= k3; i2++)
                {
                    for (int k2 = -k3; k2 <= k3; k2++)
                    {
                        if ((k3 != Math.abs(i2) || k3 != Math.abs(k2)) && world.getBlockId(i + i2, j1, k + k2) == 0)
                        {
                            world.setBlock(i + i2, j1, k + k2, leaf, leafmeta, 2);
                        }

                        if (k3 == 3 && (Math.abs(i2) == 3 && Math.abs(k2) == 2 || Math.abs(i2) == 2 && Math.abs(k2) == 3))
                        {
                            world.setBlock(i + i2, j1, k + k2, 0, 0, 2);
                        }

                        if (j1 == j + l && Math.abs(i2) < 3 && Math.abs(k2) < 3 && (Math.abs(i2) != 2 || Math.abs(k2) != 2))
                        {
                            if (k3 > 1)
                            {
                                world.setBlock(i + i2, j1 + 1, k + k2, leaf, leafmeta, 2);
                            }

                            if (k3 == 1 && (Math.abs(i2) != 1 || Math.abs(k2) != 1))
                            {
                                world.setBlock(i + i2, j1 + 1, k + k2, leaf, leafmeta, 2);
                            }
                        }
                    }
                }
            }
        }

        for (int j3 = l / 2; j3 <= l - 5; j3++)
        {
            if (random.nextInt(9) == 0)
            {
                branches(world, random, i, j + j3, k, -1, 0, leaf, leafmeta, l, log, logmeta);
            }

            if (random.nextInt(9) == 0)
            {
                branches(world, random, i, j + j3, k, 1, 0, leaf, leafmeta, l, log, logmeta);
            }

            if (random.nextInt(9) == 0)
            {
                branches(world, random, i, j + j3, k, 0, -1, leaf, leafmeta, l, log, logmeta);
            }

            if (random.nextInt(9) == 0)
            {
                branches(world, random, i, j + j3, k, 0, 1, leaf, leafmeta, l, log, logmeta);
            }

            if (random.nextInt(9) == 0)
            {
                branches(world, random, i, j + j3, k, -1, 1, leaf, leafmeta, l, log, logmeta);
            }

            if (random.nextInt(9) == 0)
            {
                branches(world, random, i, j + j3, k, -1, -1, leaf, leafmeta, l, log, logmeta);
            }

            if (random.nextInt(9) == 0)
            {
                branches(world, random, i, j + j3, k, 1, 1, leaf, leafmeta, l, log, logmeta);
            }

            if (random.nextInt(9) == 0)
            {
                branches(world, random, i, j + j3, k, 1, -1, leaf, leafmeta, l, log, logmeta);
            }
        }

        return true;
    }
    public static void branches(World world, Random random, int ii, int jj, int kk, int iD, int kD, int leaf, int leafmeta, int l, int log, int logmeta)
    {
        for (int br = 0; br < 8; br++)
        {
            if (iD == -1)
            {
                ii--;
            }

            if (iD == 1)
            {
                ii++;
            }

            if (kD == -1)
            {
                kk--;
            }

            if (kD == 1)
            {
                kk++;
            }

            world.setBlock(ii, jj, kk, log, logmeta, 2);

            if ((br == 4 || br == 7) && l >= 13)
            {
                genLeaves(world, ii, jj, kk, leaf, leafmeta);
            }

            if ((br == 4 || br == 7) && l < 13)
            {
                genLeavesS(world, ii, jj, kk, leaf, leafmeta);
            }

            jj++;
        }
    }
    public static void genLeaves(World world, int i3, int j3, int k3, int leaf, int leafmeta)
    {
        for (int x = -3; x <= 3; x++)
        {
            for (int y = -3; y <= 3; y++)
            {
                if ((Math.abs(x) != 3 || Math.abs(y) != 3) && (Math.abs(x) != 2 || Math.abs(y) != 3) && (Math.abs(x) != 3 || Math.abs(y) != 2))
                {
                    if (world.getBlockId(i3 + x, j3, k3 + y) == 0)
                    {
                        world.setBlock(i3 + x, j3, k3 + y, leaf, leafmeta, 2);
                    }
                }

                if ((Math.abs(x) < 3 && Math.abs(y) < 3) && (Math.abs(x) != 2 || Math.abs(y) != 2))
                {
                    if (world.getBlockId(i3 + x, j3 - 1, k3 + y) == 0)
                    {
                        world.setBlock(i3 + x, j3 - 1, k3 + y, leaf, leafmeta, 2);
                    }

                    if (world.getBlockId(i3 + x, j3 + 1, k3 + y) == 0)
                    {
                        world.setBlock(i3 + x, j3 + 1, k3 + y, leaf, leafmeta, 2);
                    }
                }
            }
        }
    }
    public static void genLeavesS(World world, int i3, int j3, int k3, int leaf, int leafmeta)
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

                    if (world.getBlockId(i3 + x, j3 - 1, k3 + y) == 0)
                    {
                        world.setBlock(i3 + x, j3 - 1, k3 + y, leaf, leafmeta, 2);
                    }
                }
            }
        }
    }
}
