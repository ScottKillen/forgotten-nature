package assets.forgottennature.Blocks;

import java.util.*;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

import assets.forgottennature.forgottennature;

public class BlockNewFruit extends Block
{
	@SideOnly(Side.CLIENT)
    private Icon[] field_94349_a;
	
	private int ItemNutID;
	private int ItemFruitID;
    public BlockNewFruit(int i, int j, int k, int l)
    {
        super(i, Material.plants);
        setTickRandomly(true);
        ItemNutID = k;
        ItemFruitID = l;
    }
    public boolean isOpaqueCube()
    {
        return false;
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
        this.field_94349_a = new Icon[8];

    	this.field_94349_a[0] = par1IconRegister.registerIcon("forgottennature:FoodWalnuts");
		this.field_94349_a[1] = par1IconRegister.registerIcon("forgottennature:Bananas");
		this.field_94349_a[2] = par1IconRegister.registerIcon("forgottennature:FruitFig");
		this.field_94349_a[3] = par1IconRegister.registerIcon("forgottennature:FoodCoconut");
		this.field_94349_a[4] = par1IconRegister.registerIcon("forgottennature:FoodGinkgoNuts");
		this.field_94349_a[5] = par1IconRegister.registerIcon("forgottennature:FruitOrange");
		this.field_94349_a[6] = par1IconRegister.registerIcon("forgottennature:FruitPeach");
		this.field_94349_a[7] = par1IconRegister.registerIcon("forgottennature:FruitLemon");
    }
    
    public void updateTick(World world, int i, int j, int k, Random random)
    {
    	super.updateTick(world, i, j, k, random);
    	int ll = world.getBlockId(i, j + 1, k);
        int ll2 = world.getBlockMetadata(i, j, k) & 15;
        if (ll == 0)
        {
            if (ll2 == 0)
                dropBlockAsItem_do(world, i, j, k, new ItemStack(ItemNutID, 1, 1));    	//walnuts
            else
            if (ll2 == 1)
                dropBlockAsItem_do(world, i, j, k, new ItemStack(ItemFruitID, 1, 0));   //banana
            else
            if (ll2 == 4)
                dropBlockAsItem_do(world, i, j, k, new ItemStack(ItemNutID, 1, 0));    	//ginkgo nuts
            else
            if (ll2 == 5)
                dropBlockAsItem_do(world, i, j, k, new ItemStack(ItemFruitID, 1, 2));   //orange
            else
            if (ll2 == 6)
                dropBlockAsItem_do(world, i, j, k, new ItemStack(ItemFruitID, 1, 3));   //peach
            else
            if (ll2 == 7)
                dropBlockAsItem_do(world, i, j, k, new ItemStack(ItemFruitID, 1, 9));   //lemon
            else
            if (ll2 == 2)
                dropBlockAsItem_do(world, i, j, k, new ItemStack(ItemFruitID, 1, 1));   //fig
            else
            if (ll2 == 3)
                dropBlockAsItem_do(world, i, j, k, new ItemStack(ItemNutID, 1, 2));    	//coconut
            world.setBlockToAir(i, j, k);
        }
        if (world.getBlockLightValue(i, j + 1, k) >= 9 && random.nextInt(8) == 0)
        {
            if (ll2 == 1 && random.nextInt(4) == 0 && ll == forgottennature.leafIDindex+3 && world.getBlockId(i, j - 1, k) == 0)
            {
                world.setBlock(i, j - 1, k, this.blockID, 1, 2);
            }
        }
    }
    public int quantityDropped(Random random)
    {
        return random.nextInt(20) != 0 ? 0 : 0;
    }
    public void dropBlockAsItemWithChance(World world, int i, int j, int k, int l, float f, int i1)
    {
        super.dropBlockAsItemWithChance(world, i, j, k, l, f, i1);
        for (int next = 1; next < 4; next++)
        {
            if (world.rand.nextInt(next + next - 1) == 0)
            {
                if ((l & 15) == 0)
                    dropBlockAsItem_do(world, i, j, k, new ItemStack(ItemNutID, 1, 1));    //walnuts
                if ((l & 15) == 1)
                    dropBlockAsItem_do(world, i, j, k, new ItemStack(ItemFruitID, 1, 0));    //banana
                if ((l & 15) == 4)
                    dropBlockAsItem_do(world, i, j, k, new ItemStack(ItemNutID, 1, 0));    //ginkgo nuts
            }
        }
        if ((l & 15) == 5)
            dropBlockAsItem_do(world, i, j, k, new ItemStack(ItemFruitID, 1, 2));    //orange
        if ((l & 15) == 6)
            dropBlockAsItem_do(world, i, j, k, new ItemStack(ItemFruitID, 1, 3));    //peach
        if ((l & 15) == 7)
            dropBlockAsItem_do(world, i, j, k, new ItemStack(ItemFruitID, 1, 9));    //lemon
        if ((l & 15) == 2)
            dropBlockAsItem_do(world, i, j, k, new ItemStack(ItemFruitID, 1, 1));    //fig
        if ((l & 15) == 3)
            dropBlockAsItem_do(world, i, j, k, new ItemStack(ItemNutID, 1, 2));    //coconut
    }
    public int damageDropped(int i)
    {
        return i & 15;
    }

    public int getRenderType()
    {
        return 1;
    }
}
