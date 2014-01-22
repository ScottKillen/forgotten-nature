package assets.forgottennature.Items;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.Icon;

import assets.forgottennature.forgottennature;

import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemNewAxe extends ItemTool
{
	@SideOnly(Side.CLIENT)
    private Icon field_94594_d;
	int ID;
	
	/** an array of the blocks this axe is effective against */
    public static final Block[] blocksEffectiveAgainst = (new Block[] {
        	forgottennature.newPlanks,forgottennature.newLogs,forgottennature.newLogs2,forgottennature.newLogs3,
        	Block.planks, Block.bookShelf, Block.wood, Block.chest, Block.woodSingleSlab, Block.woodDoubleSlab, 
        	Block.pumpkin, Block.pumpkinLantern, forgottennature.crystalWood});

    public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
    {
        return par2Block != null && par2Block.blockMaterial == Material.wood ? this.efficiencyOnProperMaterial : super.getStrVsBlock(par1ItemStack, par2Block);
    }
    public ItemNewAxe(int i, EnumToolMaterial enumtoolmaterial)
    {
        super(i, 3, enumtoolmaterial, blocksEffectiveAgainst);
        maxStackSize = 1;
        ID = i;
        if(i == forgottennature.crystalToolIndex-255)
        	LanguageRegistry.addName(new ItemStack(this), "Light Crystal Axe");
        else if(i == forgottennature.crystalToolIndex-250)
        	LanguageRegistry.addName(new ItemStack(this), "Dark Crystal Axe");
        else if(i == forgottennature.newToolIndex-255)
        	LanguageRegistry.addName(new ItemStack(this), "Obsidian Axe");
        else if(i == forgottennature.sawID-256)
            LanguageRegistry.addName(new ItemStack(this), "Saw");
    }
    public Icon getIconFromDamage(int i)
    {
    	return this.field_94594_d;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
    	if(ID == forgottennature.crystalToolIndex-255)
    		this.field_94594_d = par1IconRegister.registerIcon("forgottennature:AxeLightCrystal");
    	else if(ID == forgottennature.crystalToolIndex-250)
    		this.field_94594_d = par1IconRegister.registerIcon("forgottennature:AxeDarkCrystal");
    	else if(ID == forgottennature.newToolIndex-255)
    		this.field_94594_d = par1IconRegister.registerIcon("forgottennature:AxeObsidian");
    	else if(ID == forgottennature.sawID-256)
    		this.field_94594_d = par1IconRegister.registerIcon("forgottennature:Saw");
    }
    
    public String getUnlocalizedName(ItemStack i)
    {
    	if(ID == forgottennature.crystalToolIndex-255)
    		return "caxe";
    	else if(ID == forgottennature.crystalToolIndex-250)
    		return "daxe";
    	else if(ID == forgottennature.newToolIndex-255)
    		return "oaxe";
    	else
    		return "saw";
    }
}