package assets.forgottennature.Blocks;

import java.util.Random;
import java.util.ArrayList;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

import assets.forgottennature.forgottennature;

public class BlockGrapeTomCabPine extends BlockFlower
{
	@SideOnly(Side.CLIENT)
    private Icon[] field_94349_a;
	
	private int seedID;
	private int foodID;
	
    public BlockGrapeTomCabPine(int par1)
    {
        super(par1);
        this.seedID = forgottennature.newCropSeedsID;
        this.foodID = forgottennature.newCropFoodID;
        this.setTickRandomly(true);
        this.setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 0.5F, 0.9F);
    }

    @SideOnly(Side.CLIENT)

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public Icon getIcon(int par1, int par2)
    {
    		return this.field_94349_a[par2];
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.field_94349_a = new Icon[16];

        for (int i = 0; i < this.field_94349_a.length; ++i)
        {
        	if(i < 4)
            	this.field_94349_a[i] = par1IconRegister.registerIcon("forgottennature:Tomato_" + i);
        	else if(i > 3 && i < 8)
        		this.field_94349_a[i] = par1IconRegister.registerIcon("forgottennature:Cabbage_" + (i - 4));
        	else if(i > 7 && i < 12)
        		this.field_94349_a[i] = par1IconRegister.registerIcon("forgottennature:Pineapple_" + (i - 8));
        	else if(i > 11)
        		this.field_94349_a[i] = par1IconRegister.registerIcon("forgottennature:Grapes_" + (i - 12));
        	}
    }
    
    protected boolean canThisPlantGrowOnThisBlockID(int par1)
    {
        return par1 == Block.tilledField.blockID || par1 == this.blockID;
    }

    public boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer entityplayer, int par2, float par3, float par4, float par5)
    {
		int full;
        ItemStack equipped = entityplayer.getCurrentEquippedItem();
    	int met = world.getBlockMetadata(i, j, k);
    	if (equipped != null && (equipped.getItem() == Item.dyePowder) && (equipped.getItemDamage() == 15))  //if bone meal
        {
        	full = 0;
        	if (met < 3)
        		full = 3;
        	else if (met > 3 && met < 7)
        		full = 7;
        	else if (met > 7 && met < 11)
        		full = 11;
        	else if(met > 11)
        		full = 15;
        	else
        		return false;
        	world.setBlockMetadataWithNotify(i, j, k, full, 3);
            equipped.stackSize -= 1;
        }
    	else
        if ((met == 13 || met == 15) && !world.isRemote)
        {
            world.setBlockMetadataWithNotify(i, j, k, met - 1, 3);
            dropBlockAsItem_do(world, i, j, k, new ItemStack(Item.itemsList[foodID],1,14));//grapes
        }        
        return true;
    }
    
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        super.updateTick(par1World, par2, par3, par4, par5Random);

        if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9)
        {
            int var6 = par1World.getBlockMetadata(par2, par3, par4);

            if(var6 < 14 && par1World.getBlockId(par2, par3 - 1, par4) == this.blockID)
            {
            	par1World.setBlock(par2, par3, par4, 0, 0, 2);
            }
            
            if(par5Random.nextInt(10) == 0 && par1World.getBlockId(par2, par3 - 1, par4) == Block.dirt.blockID && par1World.getBlockId(par2, par3 + 1, par4) == 0 && (var6 == 12 || var6 == 13))
            {
            	par1World.setBlock(par2, par3 + 1, par4, this.blockID, 14, 2);
            }
            
            if (var6 < 3 || var6 > 3 && var6 < 7 || var6 > 7 && var6 < 11 || var6 == 12 || var6 == 14)
            {
                float var7 = this.getGrowthRate(par1World, par2, par3, par4);

                if (par5Random.nextInt((int)(25.0F / var7) + 1) == 0)
                {
                    ++var6;
                    par1World.setBlock(par2, par3, par4, this.blockID, var6, 2);
                }
            }
        }
    }

    /**
     * Gets the growth rate for the crop. Setup to encourage rows by halving growth rate if there is diagonals, crops on
     * different sides that aren't opposing, and by adding growth for every crop next to this one (and for crop below
     * this one). Args: x, y, z
     */
    private float getGrowthRate(World par1World, int par2, int par3, int par4)
    {
        float var5 = 1.0F;
        int var6 = par1World.getBlockId(par2, par3, par4 - 1);
        int var7 = par1World.getBlockId(par2, par3, par4 + 1);
        int var8 = par1World.getBlockId(par2 - 1, par3, par4);
        int var9 = par1World.getBlockId(par2 + 1, par3, par4);
        int var10 = par1World.getBlockId(par2 - 1, par3, par4 - 1);
        int var11 = par1World.getBlockId(par2 + 1, par3, par4 - 1);
        int var12 = par1World.getBlockId(par2 + 1, par3, par4 + 1);
        int var13 = par1World.getBlockId(par2 - 1, par3, par4 + 1);
        boolean var14 = var8 == this.blockID || var9 == this.blockID;
        boolean var15 = var6 == this.blockID || var7 == this.blockID;
        boolean var16 = var10 == this.blockID || var11 == this.blockID || var12 == this.blockID || var13 == this.blockID;

        for (int var17 = par2 - 1; var17 <= par2 + 1; ++var17)
        {
            for (int var18 = par4 - 1; var18 <= par4 + 1; ++var18)
            {
                int var19 = par1World.getBlockId(var17, par3 - 1, var18);
                float var20 = 0.0F;

                if (var19 == Block.tilledField.blockID)
                {
                    var20 = 1.0F;

                    if (par1World.getBlockMetadata(var17, par3 - 1, var18) > 0)
                    {
                        var20 = 2.0F;
                    }
                }

                if (var17 != par2 || var18 != par4)
                {
                    var20 /= 3.0F;
                }

                var5 += var20;
            }
        }

        if (var16 || var14 && var15)
        {
            var5 /= 2.0F;
        }

        return var5;
    }

    public int getRenderType()
    {
        return 1;
    }

    /**
     * Drops the block items with a specified chance of dropping the specified items
     */
    public void dropBlockAsItemWithChance(World world, int i, int j, int k, int met, float par6, int par7)
    {
        super.dropBlockAsItemWithChance(world, i, j, k, met, par6, par7);
        met = met & 15;
        if (met == 3)
        {
        	dropBlockAsItem_do(world, i, j, k, new ItemStack(Item.itemsList[foodID],1,11));//tomato
        }
        else if (met == 7)
        {
        	dropBlockAsItem_do(world, i, j, k, new ItemStack(Item.itemsList[foodID],1,12));//cabbage
        }
        else if (met == 11)
        {
        	dropBlockAsItem_do(world, i, j, k, new ItemStack(Item.itemsList[foodID],1,13));//pineapple
        }
        else if (met == 15 || met == 13)
        {
        	dropBlockAsItem_do(world, i, j, k, new ItemStack(Item.itemsList[foodID],1,14));//grapes
        }
        
        for (int n = 0; n < 5; n++)
        {
            if ((met == 3) && (world.rand.nextInt(3) == 0))
            {
            	dropBlockAsItem_do(world, i, j, k, new ItemStack(Item.itemsList[seedID],1,4));//tomatoes
            }
            else if ((met == 7) && (world.rand.nextInt(3) == 0))
            {
            	dropBlockAsItem_do(world, i, j, k, new ItemStack(Item.itemsList[seedID],1,5));//cabbage
            }
            else if ((met == 11) && (world.rand.nextInt(3) == 0))
            {
            	dropBlockAsItem_do(world, i, j, k, new ItemStack(Item.itemsList[seedID],1,6));//pineapple
            }
            else if ((met == 15 || met == 13) && (world.rand.nextInt(3) == 0))
            {
            	dropBlockAsItem_do(world, i, j, k, new ItemStack(Item.itemsList[seedID],1,7));//grapes
            }
        }
    }

    public int quantityDropped(Random par1Random)
    {
        return 0;
    }
}