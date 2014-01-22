package assets.forgottennature.Blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import assets.forgottennature.forgottennature;

public class BlockNewFence extends BlockFence
{
	@SideOnly(Side.CLIENT)
    private Icon[] field_94349_a;
	
    public BlockNewFence(int par1, String par2Str)
    {
        super(par1, par2Str, Material.wood);
    }

    public BlockNewFence(int par1, String par2Str, Material par3Material)
    {
        super(par1, par2Str, par3Material);
    }
    
    public int quantityDropped(Random random)
    {
        return 0;
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
        this.field_94349_a = new Icon[15];

    	this.field_94349_a[0] = par1IconRegister.registerIcon("forgottennature:PlankBrown");
    	this.field_94349_a[1] = par1IconRegister.registerIcon("forgottennature:PlankPurple");	
    	this.field_94349_a[2] = par1IconRegister.registerIcon("forgottennature:PlankDarkRed");	
    	this.field_94349_a[3] = par1IconRegister.registerIcon("forgottennature:PlankDarkYellow");
    	this.field_94349_a[4] = par1IconRegister.registerIcon("forgottennature:PlankPeach");	
    	this.field_94349_a[5] = par1IconRegister.registerIcon("forgottennature:PlankOrange");	
    	this.field_94349_a[6] = par1IconRegister.registerIcon("forgottennature:PlankBrightwood");
    	this.field_94349_a[7] = par1IconRegister.registerIcon("forgottennature:PlankRedwood");	
    	this.field_94349_a[8] = par1IconRegister.registerIcon("forgottennature:PlankAcacia");	
    	this.field_94349_a[9] = par1IconRegister.registerIcon("forgottennature:PlankBrightYellow");
    	this.field_94349_a[10] = par1IconRegister.registerIcon("forgottennature:PlankOld");		
    	this.field_94349_a[11] = par1IconRegister.registerIcon("forgottennature:PlankBamboo");	
    	this.field_94349_a[12] = par1IconRegister.registerIcon("forgottennature:PlankDriedBamboo");	
    	this.field_94349_a[13] = par1IconRegister.registerIcon("forgottennature:LightCrystalPlank");
    	this.field_94349_a[14] = par1IconRegister.registerIcon("forgottennature:DarkCrystalPlank");
    }
    
    /**
     * Adds all intersecting collision boxes to a list. (Be sure to only add boxes to the list if they intersect the
     * mask.) Parameters: World, X, Y, Z, mask, list, colliding entity
     */
    public void addCollisionBoxesToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity)
    {
        boolean flag = this.canConnectFenceTo(par1World, par2, par3, par4 - 1);
        boolean flag1 = this.canConnectFenceTo(par1World, par2, par3, par4 + 1);
        boolean flag2 = this.canConnectFenceTo(par1World, par2 - 1, par3, par4);
        boolean flag3 = this.canConnectFenceTo(par1World, par2 + 1, par3, par4);
        float f = 0.375F;
        float f1 = 0.625F;
        float f2 = 0.375F;
        float f3 = 0.625F;

        if (flag)
        {
            f2 = 0.0F;
        }

        if (flag1)
        {
            f3 = 1.0F;
        }

        if (flag || flag1)
        {
            this.setBlockBounds(f, 0.0F, f2, f1, 1.5F, f3);
            super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
        }

        f2 = 0.375F;
        f3 = 0.625F;

        if (flag2)
        {
            f = 0.0F;
        }

        if (flag3)
        {
            f1 = 1.0F;
        }

        if (flag2 || flag3 || !flag && !flag1)
        {
            this.setBlockBounds(f, 0.0F, f2, f1, 1.5F, f3);
            super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, par7Entity);
        }

        if (flag)
        {
            f2 = 0.0F;
        }

        if (flag1)
        {
            f3 = 1.0F;
        }

        this.setBlockBounds(f, 0.0F, f2, f1, 1.0F, f3);
    }

    /**
     * Updates the blocks bounds based on its current state. Args: world, x, y, z
     */
    public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        boolean flag = this.canConnectFenceTo(par1IBlockAccess, par2, par3, par4 - 1);
        boolean flag1 = this.canConnectFenceTo(par1IBlockAccess, par2, par3, par4 + 1);
        boolean flag2 = this.canConnectFenceTo(par1IBlockAccess, par2 - 1, par3, par4);
        boolean flag3 = this.canConnectFenceTo(par1IBlockAccess, par2 + 1, par3, par4);
        float f = 0.375F;
        float f1 = 0.625F;
        float f2 = 0.375F;
        float f3 = 0.625F;

        if (flag)
        {
            f2 = 0.0F;
        }

        if (flag1)
        {
            f3 = 1.0F;
        }

        if (flag2)
        {
            f = 0.0F;
        }

        if (flag3)
        {
            f1 = 1.0F;
        }

        this.setBlockBounds(f, 0.0F, f2, f1, 1.0F, f3);
    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube()
    {
        return false;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public boolean getBlocksMovement(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        return false;
    }

    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
        return 11;
    }

    /**
     * Returns true if the specified block can be connected by a fence
     */
    public boolean canConnectFenceTo(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        int l = par1IBlockAccess.getBlockId(par2, par3, par4);

        if (l != this.blockID && l != Block.fenceGate.blockID)
        {
            Block block = Block.blocksList[l];
            return block != null && block.blockMaterial.isOpaque() && block.renderAsNormalBlock() ? block.blockMaterial != Material.pumpkin : false;
        }
        else
        {
            return true;
        }
    }

    public static boolean isIdAFence(int par0)
    {
        return par0 == Block.fence.blockID || par0 == Block.netherFence.blockID || par0 == forgottennature.newFence.blockID;
    }

    @SideOnly(Side.CLIENT)

    /**
     * Returns true if the given side of this block type should be rendered, if the adjacent block is at the given
     * coordinates.  Args: blockAccess, x, y, z, side
     */
    public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
        return true;
    }
    
    public void harvestBlock(World world, EntityPlayer entityplayer, int i, int j, int k, int l)
    {
        super.harvestBlock(world, entityplayer, i, j, k, l);
        l = l & 15;
        if (l == 0)
        {
            dropBlockAsItem_do(world, i, j, k, new ItemStack(this, 1, 0));    //brown
        }

        if (l == 1)
        {
            dropBlockAsItem_do(world, i, j, k, new ItemStack(this, 1, 1));    //purple
        }

        if (l == 2)
        {
            dropBlockAsItem_do(world, i, j, k, new ItemStack(this, 1, 2));    //dark red
        }

        if (l == 3)
        {
            dropBlockAsItem_do(world, i, j, k, new ItemStack(this, 1, 3));    //dark yellow
        }

        if (l == 4)
        {
            dropBlockAsItem_do(world, i, j, k, new ItemStack(this, 1, 4));    //peach
        }

        if (l == 5)
        {
            dropBlockAsItem_do(world, i, j, k, new ItemStack(this, 1, 5));    //orange
        }

        if (l == 6)
        {
            dropBlockAsItem_do(world, i, j, k, new ItemStack(this, 1, 6));    //brightwood
        }

        if (l == 7)
        {
            dropBlockAsItem_do(world, i, j, k, new ItemStack(this, 1, 7));    //vibrantRedwood
        }
        
        if (l == 8)
        {
            dropBlockAsItem_do(world, i, j, k, new ItemStack(this, 1, 8));    //acacia
        }
        
        if (l == 9)
        {
            dropBlockAsItem_do(world, i, j, k, new ItemStack(this, 1, 9));    //brightYellow
        }
        
        if (l == 10)
        {
            dropBlockAsItem_do(world, i, j, k, new ItemStack(this, 1, 10));    //oldWood
        }
        
        if (l == 11)
        {
            dropBlockAsItem_do(world, i, j, k, new ItemStack(this, 1, 11));    //bamboo
        }
        
        if (l == 12)
        {
            dropBlockAsItem_do(world, i, j, k, new ItemStack(this, 1, 12));    //dried bamboo
        }
        
        if (l == 13)
        {
            dropBlockAsItem_do(world, i, j, k, new ItemStack(this, 1, 13));    //crystal
        }
        
        if (l == 14)
        {
            dropBlockAsItem_do(world, i, j, k, new ItemStack(this, 1, 14));    //dcrystal
        }
    }
    public void dropBlockAsItemWithChance(World world, int i, int j, int k, int l, float f, int i1)
    {
        super.dropBlockAsItemWithChance(world, i, j, k, l, f, i1);
       
    }
}
