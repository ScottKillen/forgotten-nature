package assets.forgottennature.Items;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemRope extends Item
{
	@SideOnly(Side.CLIENT)
	private Icon field_94594_d;

    public ItemRope(int i)
    {
        super(i);
        setMaxDamage(0);
        setHasSubtypes(true);
        setMaxStackSize(64);
		LanguageRegistry.addName(new ItemStack(this,1,0), "Rope");
    }
    public Icon getIconFromDamage(int i)
    {
    	return this.field_94594_d;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.field_94594_d = par1IconRegister.registerIcon("forgottennature:Rope");
    }
    public int getMetadata(int par1)
    {
        return par1 & 15;
    }

    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer entityplayer, World world, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
    	byte var8 = 0;
    	int ID = world.getBlockId(par4, par5, par6);
    	if(ID == Block.cobblestone.blockID || ID == Block.cobblestoneMossy.blockID || ID == 1 || ID == Block.stoneBrick.blockID || ID == Block.sandStone.blockID)
    	{
	        switch (par7)
	        {
	            case 2:
	            	if (entityplayer.canPlayerEdit(par4, par5, par6 - 1, par7, par1ItemStack))
	                var8 = 1;
	            	for(int y = 0; y < 256; y++)
	            	{
	            		if(world.getBlockId(par4, par5 - y, par6 - 1) == 0)
	            			world.setBlock(par4, par5 - y, par6 - 1, this.itemID, var8, 2);
	            		else
	            			y = 300;
	            	}
	            	break;
	            case 3:
	            	if (entityplayer.canPlayerEdit(par4, par5, par6 + 1, par7, par1ItemStack))
	                var8 = 4;
	            	for(int y = 0; y < 256; y++)
	            	{
	            		if(world.getBlockId(par4, par5 - y, par6 + 1) == 0)
	            			world.setBlock(par4, par5 - y, par6 + 1, this.itemID, var8, 2);
	            		else
	            			y = 300;
	            	}
	                break;
	            case 4:
	            	if (entityplayer.canPlayerEdit(par4 - 1, par5, par6, par7, par1ItemStack))
	                var8 = 8;
	            	for(int y = 0; y < 256; y++)
	            	{
	            		if(world.getBlockId(par4 - 1, par5 - y, par6) == 0)
	            			world.setBlock(par4 - 1, par5 - y, par6, this.itemID, var8, 2);
	            		else
	            			y = 300;
	            	}
	                break;
	            case 5:
	            	if (entityplayer.canPlayerEdit(par4 + 1, par5, par6, par7, par1ItemStack))
	                var8 = 2;
	            	for(int y = 0; y < 256; y++)
	            	{
	            		if(world.getBlockId(par4 + 1, par5 - y, par6) == 0)
	            			world.setBlock(par4 + 1, par5 - y, par6, this.itemID, var8, 2);
	            		else
	            			y = 300;
	            	}
	        }
	            --par1ItemStack.stackSize;
	            return true;
    	}
    	else
    		return false;
    }
    public String getUnlocalizedName(ItemStack i)
    {
		return "rope";
    }
}
