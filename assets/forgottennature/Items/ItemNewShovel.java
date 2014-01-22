package assets.forgottennature.Items;

import java.util.ArrayList;

import assets.forgottennature.forgottennature;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.Icon;

import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemNewShovel extends ItemTool
{
	@SideOnly(Side.CLIENT)
    private Icon field_94594_d; 
	int ID;
	
    public static final Block[] blocksEffectiveAgainst = new Block[] {Block.grass, Block.dirt, Block.sand, Block.gravel, Block.snow, Block.blockSnow, Block.blockClay, Block.tilledField, Block.slowSand, Block.mycelium};
	
    public ItemNewShovel(int i, EnumToolMaterial enumtoolmaterial)
    {
        super(i, 2, enumtoolmaterial, blocksEffectiveAgainst);
        maxStackSize = 1;
        ID = i;
        if(ID == forgottennature.crystalToolIndex-254)
        	LanguageRegistry.addName(new ItemStack(this), "Light Crystal Shovel");
        else if(ID == forgottennature.crystalToolIndex-248)
        	LanguageRegistry.addName(new ItemStack(this), "Dark Crystal Shovel");
        else if(ID == forgottennature.newToolIndex-253)
        	LanguageRegistry.addName(new ItemStack(this), "Obsidian Shovel");
    }
    public Icon getIconFromDamage(int i)
    {
    	return this.field_94594_d;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
    	if(ID == forgottennature.crystalToolIndex-254)
    		this.field_94594_d = par1IconRegister.registerIcon("forgottennature:ShovelLightCrystal");
    	else if(ID == forgottennature.crystalToolIndex-248)
    		this.field_94594_d = par1IconRegister.registerIcon("forgottennature:ShovelDarkCrystal");
    	else if(ID == forgottennature.newToolIndex-253)
    		this.field_94594_d = par1IconRegister.registerIcon("forgottennature:ShovelObsidian");
    }
    public boolean canHarvestBlock(Block block)
    {
    	return block == Block.snow ? true : block == Block.blockSnow;
    }
    
    public String getUnlocalizedName(ItemStack i)
    {
    	if(ID == forgottennature.crystalToolIndex-254)
    		return "cshovel";
    	else if(ID == forgottennature.crystalToolIndex-248)
    		return "dshovel";
    	else
    		return "oshovel";
    }
}