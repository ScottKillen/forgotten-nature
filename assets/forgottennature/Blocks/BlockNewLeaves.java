package assets.forgottennature.Blocks;

import java.util.*;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeavesBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

import assets.forgottennature.forgottennature;

public class BlockNewLeaves extends BlockLeavesBase implements IShearable
{
	@SideOnly(Side.CLIENT)
    private Icon[] field_94349_a;
	
	private int fruitID;
	private boolean leafDecay;
	private int newLeafDecayBuffer;
    public BlockNewLeaves(int i, boolean m, int n, int l)
    {
        super(i, Material.leaves, true);
        setTickRandomly(true);
        setBurnProperties(this.blockID, 30, 60);
        fruitID = l;
        leafDecay = m;
        newLeafDecayBuffer = n;
    }
    
    @SideOnly(Side.CLIENT)
    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public Icon getIcon(int par1, int par2)
    {
    	if(par2>7)
    		par2=par2-8;
    	
    	int fan = 1;
    	if(!this.isOpaqueCube() == true)
    		fan = 0;
    	if(fan == 0)
    		return this.field_94349_a[par2];
    	else
    		return this.field_94349_a[par2+8];
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.field_94349_a = new Icon[16];

    	
    	this.field_94349_a[0] = par1IconRegister.registerIcon("forgottennature:RedMapleLeaves");
		this.field_94349_a[1] = par1IconRegister.registerIcon("forgottennature:AngelLeaves");
		this.field_94349_a[2] = par1IconRegister.registerIcon("forgottennature:YellowMapleLeaves");
		this.field_94349_a[3] = par1IconRegister.registerIcon("forgottennature:JacarandaLeaves");
		this.field_94349_a[4] = par1IconRegister.registerIcon("forgottennature:FigLeaves");
		this.field_94349_a[5] = par1IconRegister.registerIcon("forgottennature:CypressLeaves");
		this.field_94349_a[6] = par1IconRegister.registerIcon("forgottennature:DesertIronwoodLeaves");
		this.field_94349_a[7] = par1IconRegister.registerIcon("forgottennature:EucalyptusLeaves");
    	this.field_94349_a[8] = par1IconRegister.registerIcon("forgottennature:RedMapleLeavesSolid");
		this.field_94349_a[9] = par1IconRegister.registerIcon("forgottennature:AngelLeavesSolid");
		this.field_94349_a[10] = par1IconRegister.registerIcon("forgottennature:YellowMapleLeavesSolid");
		this.field_94349_a[11] = par1IconRegister.registerIcon("forgottennature:JacarandaLeavesSolid");
		this.field_94349_a[12] = par1IconRegister.registerIcon("forgottennature:FigLeavesSolid");
		this.field_94349_a[13] = par1IconRegister.registerIcon("forgottennature:CypressLeavesSolid");
		this.field_94349_a[14] = par1IconRegister.registerIcon("forgottennature:DesertIronwoodLeavesSolid");
		this.field_94349_a[15] = par1IconRegister.registerIcon("forgottennature:EucalyptusLeavesSolid");
    }
    
    public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
    {
        byte var5 = 1;
        int var6 = var5 + 1;

        if (par1World.checkChunksExist(par2 - var6, par3 - var6, par4 - var6, par2 + var6, par3 + var6, par4 + var6))
        {
            for (int var7 = -var5; var7 <= var5; ++var7)
            {
                for (int var8 = -var5; var8 <= var5; ++var8)
                {
                    for (int var9 = -var5; var9 <= var5; ++var9)
                    {
                        int var10 = par1World.getBlockId(par2 + var7, par3 + var8, par4 + var9);

                        if (Block.blocksList[var10] != null)
                        {
                            Block.blocksList[var10].beginLeavesDecay(par1World, par2 + var7, par3 + var8, par4 + var9);
                        }
                    }
                }
            }
        }
    }
    public void updateTick(World world, int i, int j, int k, Random random)
    {
    	if (!world.isRemote)
        {
	        //super.updateTick(world, i, j, k, random);
    		int l = world.getBlockMetadata(i, j, k);
	        if ((l & 7) == 4 && world.getBlockLightValue(i, j + 1, k) >= 9 && forgottennature.figFruit)
	        {
	            if (world.getBlockId(i, j - 1, k) == 0 && world.getBlockId(i, j + 1, k) == Block.wood.blockID)
	            {
	                if (random.nextInt(130) == 0)
	                {
	                    world.setBlock(i, j - 1, k, fruitID, 2, 2);
	                }
	            }
	        }	
	        if (((l & 8)!= 0) && leafDecay == true && random.nextInt(newLeafDecayBuffer) == 0)
	        {
	        	byte var7 = 4;
                int var8 = var7 + 1;
                byte var9 = 32;
                int var10 = var9 * var9;
                int var11 = var9 / 2;
                if (this.adjacentTreeBlocks == null)
                {
                    this.adjacentTreeBlocks = new int[var9 * var9 * var9];
                }
                int var12;
                if (world.checkChunksExist(i - var8, j - var8, k - var8, i + var8, j + var8, k + var8))
                {
                    int var13;
                    int var14;
                    int var15;

                    for (var12 = -var7; var12 <= var7; ++var12)
                    {
                        for (var13 = -var7; var13 <= var7; ++var13)
                        {
                            for (var14 = -var7; var14 <= var7; ++var14)
                            {
                                var15 = world.getBlockId(i + var12, j + var13, k + var14);
                                
                                Block block = Block.blocksList[var15];

                                if (block != null && block.canSustainLeaves(world, i + var12, j + var13, k + var14))
                                {
                                    this.adjacentTreeBlocks[(var12 + var11) * var10 + (var13 + var11) * var9 + var14 + var11] = 0;
                                }
                                else if (block != null && block.isLeaves(world, i + var12, j + var13, k + var14))
                                {
                                    this.adjacentTreeBlocks[(var12 + var11) * var10 + (var13 + var11) * var9 + var14 + var11] = -2;
                                }
                                else
                                {
                                    this.adjacentTreeBlocks[(var12 + var11) * var10 + (var13 + var11) * var9 + var14 + var11] = -1;
                                }
                            }
                        }
                    }
                    for (var12 = 1; var12 <= 4; ++var12)
                    {
                        for (var13 = -var7; var13 <= var7; ++var13)
                        {
                            for (var14 = -var7; var14 <= var7; ++var14)
                            {
                                for (var15 = -var7; var15 <= var7; ++var15)
                                {
                                    if (this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11) * var9 + var15 + var11] == var12 - 1)
                                    {
                                        if (this.adjacentTreeBlocks[(var13 + var11 - 1) * var10 + (var14 + var11) * var9 + var15 + var11] == -2)
                                        {
                                            this.adjacentTreeBlocks[(var13 + var11 - 1) * var10 + (var14 + var11) * var9 + var15 + var11] = var12;
                                        }

                                        if (this.adjacentTreeBlocks[(var13 + var11 + 1) * var10 + (var14 + var11) * var9 + var15 + var11] == -2)
                                        {
                                            this.adjacentTreeBlocks[(var13 + var11 + 1) * var10 + (var14 + var11) * var9 + var15 + var11] = var12;
                                        }

                                        if (this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11 - 1) * var9 + var15 + var11] == -2)
                                        {
                                            this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11 - 1) * var9 + var15 + var11] = var12;
                                        }

                                        if (this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11 + 1) * var9 + var15 + var11] == -2)
                                        {
                                            this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11 + 1) * var9 + var15 + var11] = var12;
                                        }

                                        if (this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11) * var9 + (var15 + var11 - 1)] == -2)
                                        {
                                            this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11) * var9 + (var15 + var11 - 1)] = var12;
                                        }

                                        if (this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11) * var9 + var15 + var11 + 1] == -2)
                                        {
                                            this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11) * var9 + var15 + var11 + 1] = var12;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                var12 = this.adjacentTreeBlocks[var11 * var10 + var11 * var9 + var11];
                if (var12 >= 0)
                {
                    world.setBlockMetadataWithNotify(i, j, k, l & -9, 4);
                }
                else
                {
                    this.removeLeaves(world, i, j, k);
                }
            }
        }
    }
    private void removeLeaves(World world, int i, int j, int k)
    {
        dropBlockAsItem(world, i, j, k, world.getBlockMetadata(i, j, k), 0);
        world.setBlockToAir(i, j, k);
    }
    public int quantityDropped(Random random)
    {
        return random.nextInt(20) != 0 ? 0 : 0;
    }
    public void dropBlockAsItemWithChance(World world, int i, int j, int k, int l, float f, int i1)
    {
        int ran = world.rand.nextInt(14);
        super.dropBlockAsItemWithChance(world, i, j, k, l, f, i1);
		if (world.rand.nextInt(14) < 1)
        {
            if ((l & 7) == 0)
            {
                dropBlockAsItem_do(world, i, j, k, new ItemStack(forgottennature.newSap, 1, 2));    //red maple
            }
            if ((l & 7) == 1 && ran == 0)
            {
                dropBlockAsItem_do(world, i, j, k, new ItemStack(forgottennature.newSap, 1, 3));    //angel oak
            }
            if ((l & 7) == 2)
            {
                dropBlockAsItem_do(world, i, j, k, new ItemStack(forgottennature.newSap, 1, 4));    //yellow maple
            }
            if ((l & 7) == 3)
            {
                dropBlockAsItem_do(world, i, j, k, new ItemStack(forgottennature.newSap, 1, 5));    //jacaranda
            }
            if ((l & 7) == 4 && ran == 0)
            {
                dropBlockAsItem_do(world, i, j, k, new ItemStack(forgottennature.newSap, 1, 9));    //fig
            }
            if ((l & 7) == 5)
            {
                dropBlockAsItem_do(world, i, j, k, new ItemStack(forgottennature.newSap, 1, 10));    //cypress
            }
            if ((l & 7) == 6)
            {
                dropBlockAsItem_do(world, i, j, k, new ItemStack(forgottennature.newSap, 1, 0));    //desert tree
            }
            if ((l & 7) == 7)
            {
                dropBlockAsItem_do(world, i, j, k, new ItemStack(forgottennature.newSap, 1, 7));    //eucalyptus
            }
        }
    }
    public void harvestBlock(World par1World, EntityPlayer par2EntityPlayer, int par3, int par4, int par5, int par6)
    {
        super.harvestBlock(par1World, par2EntityPlayer, par3, par4, par5, par6);
    }
    public int damageDropped(int i)
    {
        return i & 7;
    }
    
    public boolean isOpaqueCube()
    {
        return !Block.leaves.graphicsLevel;
    }

    public void onEntityWalking(World world, int i, int j, int k, Entity entity)
    {
        super.onEntityWalking(world, i, j, k, entity);
    }
    int adjacentTreeBlocks[];
	
    @Override
    public boolean isShearable(ItemStack item, World world, int x, int y, int z)
    {
        return true;
    }

    @Override
    public ArrayList<ItemStack> onSheared(ItemStack item, World world, int x, int y, int z, int fortune)
    {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        ret.add(new ItemStack(this, 1, world.getBlockMetadata(x, y, z) & 7));
        return ret;
    }

    @Override
    public void beginLeavesDecay(World world, int x, int y, int z)
    {
        world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z) | 8, 4);
    }

    @Override
    public boolean isLeaves(World world, int x, int y, int z)
    {
        return true;
    }
}
