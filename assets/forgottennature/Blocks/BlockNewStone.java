package assets.forgottennature.Blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

import assets.forgottennature.forgottennature;
import assets.forgottennature.Items.ItemNewStone;

public class BlockNewStone extends Block
{
	@SideOnly(Side.CLIENT)
    private Icon[] field_94349_a;
	private int drop = 0;
	private int dropMet = 0;
	
    public BlockNewStone(int par1)
    {
        super(par1, Material.rock);
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
        this.field_94349_a = new Icon[10];

    	this.field_94349_a[0] = par1IconRegister.registerIcon("forgottennature:StoneChert");
		this.field_94349_a[1] = par1IconRegister.registerIcon("forgottennature:StoneGranite");
		this.field_94349_a[2] = par1IconRegister.registerIcon("forgottennature:StoneGneiss");
		this.field_94349_a[3] = par1IconRegister.registerIcon("forgottennature:StoneHornfels");
		this.field_94349_a[4] = par1IconRegister.registerIcon("forgottennature:StoneMarble");
		this.field_94349_a[5] = par1IconRegister.registerIcon("forgottennature:BricksGranite");
		this.field_94349_a[6] = par1IconRegister.registerIcon("forgottennature:BricksGneiss");
		this.field_94349_a[7] = par1IconRegister.registerIcon("forgottennature:BricksHornfels");
		this.field_94349_a[8] = par1IconRegister.registerIcon("forgottennature:BricksMarble");
		this.field_94349_a[9] = par1IconRegister.registerIcon("forgottennature:TitanStoneBlock");
    }

    public int quantityDropped(Random par1Random)
    {
        return 1;
    }
    
    public int idDropped(int par1, Random par2Random, int par3)
    {
    	if((par1 == 0 || par1 == 1) && par2Random.nextInt(35) == 0 && forgottennature.craftGunpowder)
    	{
    		drop = 1;
    		dropMet = par2Random.nextInt(2);
    		return forgottennature.powderID;
    	}
    	drop = 0;
    	return this.blockID;
    }
    public int damageDropped(int par1)
    {
    	if(drop == 1)
    		return dropMet;
        return par1 & 15;
    }
}