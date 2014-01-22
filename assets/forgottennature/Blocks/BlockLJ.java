package assets.forgottennature.Blocks;

import java.util.ArrayList;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

import assets.forgottennature.forgottennature;


public class BlockLJ extends BlockLog
{
	/** The type of tree this log came from. */
    public static final String[] woodType = new String[] {"oak", "spruce", "birch", "jungle"};
    @SideOnly(Side.CLIENT)
    private Icon[] field_111052_c;
    @SideOnly(Side.CLIENT)
    private Icon[] tree_top;
	
    public BlockLJ(int par1)
    {
        super(par1);
    }
    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random)
    {
        return 1;
    }

    /**
     * Called when the player destroys a block with an item that can harvest it. (i, j, k) are the coordinates of the
     * block and l is the block's subtype/damage.
     */
    public void harvestBlock(World par1World, EntityPlayer par2EntityPlayer, int par2, int par3, int par4, int par6)
    {
        super.harvestBlock(par1World, par2EntityPlayer, par2, par3, par4, par6);
        int ai[] = {par2, par3 + 1, par4};
        Boolean can = Boolean.valueOf(true);
        Boolean isAxe = false;
        ItemStack equipped = par2EntityPlayer.getCurrentEquippedItem();
        if(equipped != null && (equipped.getItem() == Item.itemsList[forgottennature.newToolIndex+1] 
        		|| equipped.getItem() == Item.itemsList[forgottennature.newToolIndex+5]
        		|| equipped.getItem() == Item.axeDiamond || equipped.getItem() == Item.itemsList[forgottennature.crystalToolIndex + 6] 
        			|| equipped.getItem() == Item.itemsList[forgottennature.crystalToolIndex + 1] || equipped.getItem() == Item.itemsList[forgottennature.sawID] 
        				|| equipped.getItem() == Item.itemsList[forgottennature.extraAxe1ID] || equipped.getItem() == Item.itemsList[forgottennature.extraAxe2ID] 
        					|| equipped.getItem() == Item.itemsList[forgottennature.extraAxe3ID] || equipped.getItem() == Item.itemsList[forgottennature.extraAxe4ID]))
        	isAxe = true;
        	
        if (isAxe && par1World.getBlockId(ai[0], ai[1], ai[2]) == Block.wood.blockID && forgottennature.lumberjack == true)
        {
            for (int i1 = -1; i1 <= 1; i1++)
            {
                for (int j1 = -1; j1 <= 0; j1++)
                {
                    for (int i2 = -1; i2 <= 1; i2++)
                    {
                        if ((i1 + par2 != par2 || j1 + par3 != par3 || i2 + par4 != par4) && par1World.getBlockId(i1 + par2, j1 + par3, i2 + par4) == Block.wood.blockID)
                        {
                            can = Boolean.valueOf(false);
                        }
                    }
                }
            }

            if (can.booleanValue())
            {
                int ai1[][] = new int[forgottennature.lumberjackPower][3];
                Boolean boolean2 = Boolean.valueOf(false);
                ai1[0][0] = par2;
                ai1[0][1] = par3 + 1;
                ai1[0][2] = par4;
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
                                    if (par1World.getBlockId(ai1[l2][0] + k3, ai1[l2][1] + i4, ai1[l2][2] + j4) != Block.wood.blockID)
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
                                        int ai2[] = {j6, k6, l6};
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
                    boolean2 = Boolean.valueOf(false);
                }
                while (boolean2.booleanValue());
                for (int i3 = 0; i3 < ai1.length; i3++)
                {
                    if (ai1[i3][1] > 0 && ai1[i3][1] < forgottennature.lumberjackPower && par1World.getBlockId(ai1[i3][0], ai1[i3][1], ai1[i3][2]) == Block.wood.blockID)
                    {
                    	int met = par1World.getBlockMetadata(ai1[i3][0], ai1[i3][1], ai1[i3][2]);
                    	if(met >= 8)
                    		met = met - 8;
                    	else
                    	if(met >= 4)
                    		met = met - 4;
                        dropBlockAsItem_do(par1World, par2, par3, par4, new ItemStack(Block.wood, 1, met));
                        par1World.setBlockToAir(ai1[i3][0], ai1[i3][1], ai1[i3][2]);
                        if(equipped.getItemDamage()+1 <= equipped.getMaxDamage() && forgottennature.lumberjackDamage)
                        	equipped.setItemDamage(equipped.getItemDamage()+1);
                    }
                }
            }
        }
    }
    
    @SideOnly(Side.CLIENT)
    protected Icon getSideIcon(int par1)
    {
        return this.field_111052_c[par1];
    }
    
    @SideOnly(Side.CLIENT)
    protected Icon getEndIcon(int par1)
    {
        return this.tree_top[par1];
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.field_111052_c = new Icon[woodType.length];
        this.tree_top = new Icon[woodType.length];

        for (int i = 0; i < this.field_111052_c.length; ++i)
        {
            this.field_111052_c[i] = par1IconRegister.registerIcon(this.getTextureName() + "_" + woodType[i]);
            this.tree_top[i] = par1IconRegister.registerIcon(this.getTextureName() + "_" + woodType[i] + "_top");
        }
    }
}
