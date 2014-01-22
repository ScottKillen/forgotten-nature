package assets.forgottennature.Blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import assets.forgottennature.forgottennature;
import assets.forgottennature.WorldGen.genCrystalMushroom;


import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockCrystalMushroom extends BlockFlower
{
	@SideOnly(Side.CLIENT)
    private Icon[] field_94349_a;
	
    public BlockCrystalMushroom(int par1)
    {
        super(par1);
        float var3 = 0.2F;
        this.setBlockBounds(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, var3 * 2.0F, 0.5F + var3);
        this.setTickRandomly(true);
    }

    @SideOnly(Side.CLIENT)

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public Icon getIcon(int par1, int par2)
    {
        return this.field_94349_a[par2];
    }
    
    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (par5Random.nextInt(25) == 0)
        {
            byte var6 = 4;
            int var7 = 5;
            int var8;
            int var9;
            int var10;

            for (var8 = par2 - var6; var8 <= par2 + var6; ++var8)
            {
                for (var9 = par4 - var6; var9 <= par4 + var6; ++var9)
                {
                    for (var10 = par3 - 1; var10 <= par3 + 1; ++var10)
                    {
                        if (par1World.getBlockId(var8, var10, var9) == this.blockID)
                        {
                            --var7;

                            if (var7 <= 0)
                            {
                                return;
                            }
                        }
                    }
                }
            }

            var8 = par2 + par5Random.nextInt(3) - 1;
            var9 = par3 + par5Random.nextInt(2) - par5Random.nextInt(2);
            var10 = par4 + par5Random.nextInt(3) - 1;

            for (int var11 = 0; var11 < 4; ++var11)
            {
                if (par1World.isAirBlock(var8, var9, var10) && this.canBlockStay(par1World, var8, var9, var10))
                {
                    par2 = var8;
                    par3 = var9;
                    par4 = var10;
                }

                var8 = par2 + par5Random.nextInt(3) - 1;
                var9 = par3 + par5Random.nextInt(2) - par5Random.nextInt(2);
                var10 = par4 + par5Random.nextInt(3) - 1;
            }

            if (par1World.isAirBlock(var8, var9, var10) && this.canBlockStay(par1World, var8, var9, var10))
            {
                par1World.setBlock(var8, var9, var10, this.blockID, 0, 2);
            }
        }
    }

    /**
     * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
     */
    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
    {
        return super.canPlaceBlockAt(par1World, par2, par3, par4) && this.canBlockStay(par1World, par2, par3, par4);
    }

    /**
     * Gets passed in the blockID of the block below and supposed to return true if its allowed to grow on the type of
     * blockID passed in. Args: blockID
     */
    protected boolean canThisPlantGrowOnThisBlockID(int par1)
    {
        return Block.opaqueCubeLookup[par1];
    }

    /**
     * Can this block stay at this position.  Similar to canPlaceBlockAt except gets checked often with plants.
     */
    public boolean canBlockStay(World par1World, int par2, int par3, int par4)
    {
        if (par3 >= 0 && par3 < 256)
        {
            int var5 = par1World.getBlockId(par2, par3 - 1, par4);
            Block soil = Block.blocksList[var5];
            return (soil != null && soil.canSustainPlant(par1World, par2, par3 - 1, par4, ForgeDirection.UP, this) || soil == forgottennature.newGround);
        }
        else
        {
            return false;
        }
    }

    public boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer entityplayer, int par2, float par3, float par4, float par5)
    {
    	genCrystalMushroom var7 = new genCrystalMushroom(0);
        ItemStack equipped = entityplayer.getCurrentEquippedItem();
        if (equipped == null)
        {
            return false;
        }
        if ((equipped.getItem() == Item.dyePowder) && (equipped.getItemDamage() == 15))  //if bone meal
        {
        	var7.generate(world, world.rand, i, j, k);
            equipped.stackSize -= 1;
        }
        return false;
    }

    public int quantityDropped(Random random)
    {
        return 0;
    }
    public void dropBlockAsItemWithChance(World world, int i, int j, int k, int l, float f, int i1)
    {
        super.dropBlockAsItemWithChance(world, i, j, k, l, f, i1);
        for(int n = 0; n < 3; n++)
        {
	        if (world.rand.nextInt(2) == 0)
	        {
	            dropBlockAsItem_do(world, i, j, k, new ItemStack(Item.itemsList[forgottennature.crystalItemID], 1, 1));    //crystal
	        }
	
//	        if ((l & 3) == 1 && world.rand.nextInt(2) == 0)
//	        {
//	            dropBlockAsItem_do(world, i, j, k, new ItemStack(Item.itemsList[forgottennature.crystalItemID], 1, 4));    //blackCrystal
//	        }
        }
    }
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.field_94349_a = new Icon[1];

        this.field_94349_a[0] = par1IconRegister.registerIcon("forgottennature:CrystalMushroom");
    }
}
