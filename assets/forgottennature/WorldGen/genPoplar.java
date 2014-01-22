package assets.forgottennature.WorldGen;
import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class genPoplar extends WorldGenerator
{
    int leaf;
    int leafmeta;
    int log;
    int logmeta;
    public genPoplar(int i, int j, int k, int l)
    {
        leaf = i;
        leafmeta = j;
        log = k;
        logmeta = l;
    }
    public boolean generate(World world, Random random, int i, int j, int k)
    {
    	if(world.isRemote)
    		return false;
        int met;
        int i1 = i;
        int j1 = j;
        int k1 = k;
        int h1 = 0;
        int h2 = 0;
        int h3 = 0;
        int hight = 1;

        if (random.nextInt(7) < 2)
        {
            h1 = 1;
        }

        if (random.nextInt(7) < 2)
        {
            h2 = 1;
        }

        if (random.nextInt(2) == 0)
        {
            h3 = 1;
        }

        hight = hight + h1 + h2 + h3;
        met = world.getBlockId(i, j, k);

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

        for (int jn = 0; jn <= 6 * hight + 1; jn++)
        {
            if (jn != 6 * hight + 1)
            {
                //////////
                world.setBlock(i1, j1 + jn, k1, log, logmeta, 2);	//
            }																			//
            if (hight == 1 && jn > 2)													//
            {																			//
                for (int x = -1; x <= 1; x++)											//
                {																		//
                    for (int y = -1; y <= 1; y++)										//
                    {																	//Building the trunk
                        if (Math.abs(x) != 1 || Math.abs(y) != 1)						//and one layer of leaves
                        {
                            if (world.getBlockId(i1 + x, j1 + jn, k1 + y) == 0)			//
                            {
                                world.setBlock(i1 + x, j1 + jn, k1 + y, leaf, leafmeta, 2);
                            }
                        }																//
                    }																	//
                }																	//////////
            }																		//////////
            if (hight == 2 && jn > 2)												//////////
            {
                for (int x = -2; x <= 2; x++)
                {
                    for (int y = -2; y <= 2; y++)
                    {
                        if ((Math.abs(x) <= 1 && Math.abs(y) <= 1) && (Math.abs(x) != 1 || Math.abs(y) != 1))
                        {
                            if (world.getBlockId(i1 + x, j1 + jn, k1 + y) == 0)	//first layer of leaves
                            {
                                world.setBlock(i1 + x, j1 + jn, k1 + y, leaf, leafmeta, 2);
                            }
                        }
                        if ((Math.abs(x) <= 1 && Math.abs(y) <= 1) && jn == 7)
                        {
                            if (world.getBlockId(i1 + x, j1 + jn, k1 + y) == 0)	
                            {
                                world.setBlock(i1 + x, j1 + jn, k1 + y, leaf, leafmeta, 2);
                            }
                        }

                        if ((Math.abs(x) != 2 || Math.abs(y) != 2) && (Math.abs(x) != 2 || Math.abs(y) != 1) && (Math.abs(x) != 1 || Math.abs(y) != 2) && jn <= 6 * hight - 1 && jn > 3)
                        {
                            //
                            if (world.getBlockId(i1 + x, j1 + jn, k1 + y) == 0)//second layer of leaves
                            {
                                world.setBlock(i1 + x, j1 + jn, k1 + y, leaf, leafmeta, 2);
                            }
                        }
                    }
                }
            }

            if (hight == 3 & jn > 2)												//////////
            {																			//
                for (int x = -2; x <= 2; x++)											//
                {																		//
                    for (int y = -2; y <= 2; y++)										//
                    {																	//
                        if ((Math.abs(x) <= 1 && Math.abs(y) <= 1) && (Math.abs(x) != 1 || Math.abs(y) != 1))
                        {																//
                            if (world.getBlockId(i1 + x, j1 + jn, k1 + y) == 0)			//first layer of leaves
                            {
                                world.setBlock(i1 + x, j1 + jn, k1 + y, leaf, leafmeta, 2);
                            }
                        }																//
                        if ((Math.abs(x) != 2 || Math.abs(y) != 2) && (Math.abs(x) != 2 || Math.abs(y) != 1) && (Math.abs(x) != 1 || Math.abs(y) != 2) && jn <= 6 * hight && jn > 3)
                        {																//
                            if (world.getBlockId(i1 + x, j1 + jn, k1 + y) == 0)			//2nd layer of leaves
                            {
                                world.setBlock(i1 + x, j1 + jn, k1 + y, leaf, leafmeta, 2);
                            }															//
                        }																//
                    }																	//
                }																		//
            }																		//////////
            if (hight == 4 & jn > 2)												//////////
            {																			//
                for (int x = -3; x <= 3; x++)											//
                {																		//
                    for (int y = -3; y <= 3; y++)										//
                    {																	//
                        if ((Math.abs(x) <= 1 && Math.abs(y) <= 1) && (Math.abs(x) != 1 || Math.abs(y) != 1))
                        {																//
                            if (world.getBlockId(i1 + x, j1 + jn, k1 + y) == 0)			//1st layer of leaves
                            {
                                world.setBlock(i1 + x, j1 + jn, k1 + y, leaf, leafmeta, 2);
                            }															//
                        }																//
                        if (Math.abs(x) <= 1 && Math.abs(y) <= 1 && jn <= 14 && jn >= 2)//
                        {																//
                            if (world.getBlockId(i1 + x, j1 + jn, k1 + y) == 0)			//2nd layer of leaves
                            {
                                world.setBlock(i1 + x, j1 + jn, k1 + y, leaf, leafmeta, 2);
                            }
                        }																//
                        if (Math.abs(x) <= 2 && Math.abs(y) <= 2 && (Math.abs(x) != 2 || Math.abs(y) != 2) && (jn == 6 * hight | jn == 5))
                        {
                            															//
                            if (world.getBlockId(i1 + x, j1 + jn, k1 + y) == 0)			//
                            {
                                world.setBlock(i1 + x, j1 + jn, k1 + y, leaf, leafmeta, 2);
                            }
                        }																//

                        if ((Math.abs(x) != 3 || Math.abs(y) != 3) && (Math.abs(x) != 3 || Math.abs(y) != 2) && (Math.abs(x) != 2 || Math.abs(y) != 3) && jn <= 6 * hight - 1 && jn > 5)
                        {																//
                            if (world.getBlockId(i1 + x, j1 + jn, k1 + y) == 0)			//3rd layer of leaves
                            {
                                world.setBlock(i1 + x, j1 + jn, k1 + y, leaf, leafmeta, 2);
                            }
                        }																//
                    }																	//
                }																		//
            }																		//////////
        }																				//																					//

        return true;																	//
    }																					//
}																					//////////
