package assets.forgottennature.Items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemReed;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

import assets.forgottennature.forgottennature;

public class NewItemReed extends ItemReed
{
	@SideOnly(Side.CLIENT)
	private Icon field_94594_d;
	private Block block;

    /** The ID of the block the reed will spawn when used from inventory bar. */
    private int spawnID;

    public NewItemReed(int par1, Block par2Block)
    {
        super(par1, par2Block);
        this.spawnID = par2Block.blockID;
        block = par2Block;
    }
    
    public Icon getIconFromDamage(int i)
    {
    	return this.field_94594_d;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.field_94594_d = par1IconRegister.registerIcon("forgottennature:flowerPot");
    }
    public int getMetadata(int par1)
    {
        return par1 & 15;
    }
    
}
