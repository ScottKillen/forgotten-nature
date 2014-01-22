package assets.forgottennature.Blocks;

import java.util.*;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

import assets.forgottennature.forgottennature;

public class BlockNewLogs2 extends Block
{
	@SideOnly(Side.CLIENT)
    private Icon[] field_94349_a;
	
    public BlockNewLogs2(int i)
    {
        super(i, Material.wood);
        setBurnProperties(this.blockID, 5, 5);
    }

    @SideOnly(Side.CLIENT)
    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public Icon getIcon(int i, int j)
    {
    	return (i == 1 || i == 0) && (j % 2 == 0) ? field_94349_a[0] : 
    		((i == 5 || i == 4) && (j % 2 == 1) ? field_94349_a[0] : 
    		((j == 0 || j == 1) ? field_94349_a[1] : ((j == 2 || j == 3) ? field_94349_a[2] : 
    		((j == 4 || j == 5) ? field_94349_a[3] : ((j == 6 || j == 7) ? field_94349_a[4] : 
    		((j == 8 || j == 9) ? field_94349_a[5] : ((j == 10 || j == 11) ? field_94349_a[6] : 
    		((j == 12 || j == 13) ? field_94349_a[7] : field_94349_a[8]))))))));
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.field_94349_a = new Icon[9];

    	this.field_94349_a[0] = par1IconRegister.registerIcon("forgottennature:LogCrossSection");
		this.field_94349_a[1] = par1IconRegister.registerIcon("forgottennature:LogDesertWillow");
		this.field_94349_a[2] = par1IconRegister.registerIcon("forgottennature:LogCedar");
		this.field_94349_a[3] = par1IconRegister.registerIcon("forgottennature:LogGinkgo");
		this.field_94349_a[4] = par1IconRegister.registerIcon("forgottennature:LogBeech");
		this.field_94349_a[5] = par1IconRegister.registerIcon("forgottennature:LogWalnut");
		this.field_94349_a[6] = par1IconRegister.registerIcon("forgottennature:LogCocoa");
		this.field_94349_a[7] = par1IconRegister.registerIcon("forgottennature:LogCocoaFruit");
		this.field_94349_a[8] = par1IconRegister.registerIcon("forgottennature:LogWTEucalyptus");
    }
    
    public int quantityDropped(Random random)
    {
        return 1;
    }

    public int idDropped(int i, Random random, int j)
    {
        return this.blockID;
    }
     
    public void harvestBlock(World world, EntityPlayer entityplayer, int i, int j, int k, int l)
    {
        super.harvestBlock(world, entityplayer, i, j, k, l);
        int ai[] = {i, j + 1, k};
        Boolean boolean1 = Boolean.valueOf(true);
        Boolean isAxe = false;
        ItemStack equipped = entityplayer.getCurrentEquippedItem();
        if(equipped != null && (equipped.getItem() == Item.itemsList[forgottennature.newToolIndex+1] 
        		|| equipped.getItem() == Item.itemsList[forgottennature.newToolIndex+5]  
        		|| equipped.getItem() == Item.axeDiamond || equipped.getItem() == Item.itemsList[forgottennature.crystalToolIndex + 6] 
        			|| equipped.getItem() == Item.itemsList[forgottennature.crystalToolIndex + 1] || equipped.getItem() == Item.itemsList[forgottennature.sawID] 
        				|| equipped.getItem() == Item.itemsList[forgottennature.extraAxe1ID] || equipped.getItem() == Item.itemsList[forgottennature.extraAxe2ID] 
        					|| equipped.getItem() == Item.itemsList[forgottennature.extraAxe3ID] || equipped.getItem() == Item.itemsList[forgottennature.extraAxe4ID]))
        	isAxe = true;

        if (isAxe && world.getBlockId(ai[0], ai[1], ai[2]) == this.blockID && forgottennature.lumberjack == true)
        {
            for (int i1 = -1; i1 <= 1; i1++)
            {
                for (int k1 = -1; k1 <= 0; k1++)
                {
                    for (int i2 = -1; i2 <= 1; i2++)
                    {
                        if ((i1 + i != i || k1 + j != j || i2 + k != k) && world.getBlockId(i1 + i, k1 + j, i2 + k) == this.blockID)
                        {
                            boolean1 = Boolean.valueOf(false);
                        }
                    }
                }
            }

            if (boolean1.booleanValue())
            {
                int ai1[][] = new int[forgottennature.lumberjackPower][3];
                Boolean boolean2 = Boolean.valueOf(false);
                ai1[0][0] = i;
                ai1[0][1] = j + 1;
                ai1[0][2] = k;
                int j2 = 1;

                do
                {
                    for (int l2 = 0; l2 < ai1.length && ai1[l2] != null; l2++)
                    {
                        for (int k3 = -1; k3 <= 1; k3++)
                        {
                            for (int i4 = -1; i4 <= 1; i4++)
                            {
                                for (int j4 = -1; j4 <= 1; j4++)
                                {
                                    if (world.getBlockId(ai1[l2][0] + k3, ai1[l2][1] + i4, ai1[l2][2] + j4) != this.blockID)
                                    {
                                        continue;
                                    }

                                    Boolean boolean3 = Boolean.valueOf(false);

                                    for (int k4 = 0; k4 < ai1.length; k4++)
                                    {
                                        if (ai1[k4][1] <= 0 || ai1[k4][1] >= 150)
                                        {
                                            continue;
                                        }

                                        int i5 = ai1[l2][0];
                                        int k5 = ai1[l2][1];
                                        int i6 = ai1[l2][2];
                                        int j6 = k3 + i5;
                                        int k6 = i4 + k5;
                                        int l6 = j4 + i6;
                                        int ai2[] =
                                        {
                                            j6, k6, l6
                                        };

                                        if (ai2[0] != ai1[k4][0] || ai2[1] != ai1[k4][1] || ai2[2] != ai1[k4][2])
                                        {
                                            continue;
                                        }

                                        boolean3 = Boolean.valueOf(true);
                                        break;
                                    }

                                    if (!boolean3.booleanValue() && j2 < ai1.length)
                                    {
                                        int l4 = ai1[l2][0];
                                        int j5 = ai1[l2][1];
                                        int l5 = ai1[l2][2];
                                        ai1[j2][0] = k3 + l4;
                                        ai1[j2][1] = i4 + j5;
                                        ai1[j2][2] = j4 + l5;
                                        boolean2 = Boolean.valueOf(true);
                                        j2++;
                                    }
                                }
                            }
                        }
                    }

                    if (!boolean2.booleanValue())
                    {
                        break;
                    }

                    boolean2 = Boolean.valueOf(false);
                }
                while (true);

                int met;
                for (int i3 = 0; i3 < ai1.length; i3++)
                {
                	met = world.getBlockMetadata(ai1[i3][0], ai1[i3][1], ai1[i3][2]);
                    if (ai1[i3][1] > 0 && ai1[i3][1] < forgottennature.lumberjackPower && world.getBlockId(ai1[i3][0], ai1[i3][1], ai1[i3][2]) == this.blockID)
                    {
                    	if(met % 2 == 0)
                    		dropBlockAsItem_do(world, i, j, k, new ItemStack(Block.blocksList[this.blockID], 1, met));
                    	else
                    		dropBlockAsItem_do(world, i, j, k, new ItemStack(Block.blocksList[this.blockID], 1, met-1));                        
                    	world.setBlockToAir(ai1[i3][0], ai1[i3][1], ai1[i3][2]);
                        if(equipped.getItemDamage()+1 <= equipped.getMaxDamage() && forgottennature.lumberjackDamage)
                        	equipped.setItemDamage(equipped.getItemDamage()+1);
                    }
                }
            }
        }
    }
    
    public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
    {
    	byte var7 = 4;
        int var8 = var7 + 1;

        if (par1World.checkChunksExist(par2 - var8, par3 - var8, par4 - var8, par2 + var8, par3 + var8, par4 + var8))
        {
            for (int var9 = -var7; var9 <= var7; ++var9)
            {
                for (int var10 = -var7; var10 <= var7; ++var10)
                {
                    for (int var11 = -var7; var11 <= var7; ++var11)
                    {
                        int var12 = par1World.getBlockId(par2 + var9, par3 + var10, par4 + var11);

                        if (Block.blocksList[var12] != null)
                        {
                            Block.blocksList[var12].beginLeavesDecay(par1World, par2 + var9, par3 + var10, par4 + var11);
                        }
                    }
                }
            }
        }
    }

    public int damageDropped(int i)
    {
    	if(i % 2 == 1)
    		return i - 1;
    	else
    		return i;
    }
	
	@Override
    public boolean canSustainLeaves(World world, int x, int y, int z)
    {
        return true;
    }

    @Override
    public boolean isWood(World world, int x, int y, int z)
    {
        return true;
    }
    
    @Override
	public int getRenderType() 
    {
    	return forgottennature.FNLogRenderID;
    }
}