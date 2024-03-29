package assets.forgottennature.Items;

import java.util.ArrayList;

import assets.forgottennature.forgottennature;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.entity.player.UseHoeEvent;

import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemNewHoe extends ItemHoe
{
	@SideOnly(Side.CLIENT)
    private Icon field_94594_d;
	int ID;
	
	protected EnumToolMaterial theToolMaterial;
    public ItemNewHoe(int par1, EnumToolMaterial par2EnumToolMaterial)
    {
        super(par1, par2EnumToolMaterial);
        this.maxStackSize = 1;
        this.setMaxDamage(par2EnumToolMaterial.getMaxUses());
        ID = par1;
        if(ID == forgottennature.crystalToolIndex-252)
        	LanguageRegistry.addName(new ItemStack(this), "Light Crystal Hoe");
        else if(ID == forgottennature.crystalToolIndex-249)
        	LanguageRegistry.addName(new ItemStack(this), "Dark Crystal Hoe");
        else if(ID == forgottennature.newToolIndex-254)
        	LanguageRegistry.addName(new ItemStack(this), "Obsidian Hoe");
    }
    public Icon getIconFromDamage(int i)
    {
    	return this.field_94594_d;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
    	if(ID == forgottennature.crystalToolIndex-252)
    		this.field_94594_d = par1IconRegister.registerIcon("forgottennature:HoeLightCrystal");
    	else if(ID == forgottennature.crystalToolIndex-249)
    		this.field_94594_d = par1IconRegister.registerIcon("forgottennature:HoeDarkCrystal");
    	else if(ID == forgottennature.newToolIndex-254)
    		this.field_94594_d = par1IconRegister.registerIcon("forgottennature:HoeObsidian");
    }
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
        {
            return false;
        }
        else
        {
            UseHoeEvent event = new UseHoeEvent(par2EntityPlayer, par1ItemStack, par3World, par4, par5, par6);
            if (MinecraftForge.EVENT_BUS.post(event))
            {
                return false;
            }
            if (event.getResult() == Result.ALLOW)
            {
                par1ItemStack.damageItem(1, par2EntityPlayer);
                return true;
            }

            int var11 = par3World.getBlockId(par4, par5, par6);
            int var12 = par3World.getBlockId(par4, par5 + 1, par6);

            if ((par7 == 0 || var12 != 0 || var11 != Block.grass.blockID) && var11 != Block.dirt.blockID)
            {
                return false;
            }
            else
            {
                Block var13 = Block.tilledField;
                par3World.playSoundEffect((double)((float)par4 + 0.5F), (double)((float)par5 + 0.5F), (double)((float)par6 + 0.5F), var13.stepSound.getStepSound(), (var13.stepSound.getVolume() + 1.0F) / 2.0F, var13.stepSound.getPitch() * 0.8F);

                if (par3World.isRemote)
                {
                    return true;
                }
                else
                {
                    par3World.setBlock(par4, par5, par6, var13.blockID, 0, 2);
                    par1ItemStack.damageItem(1, par2EntityPlayer);
                    return true;
                }
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public boolean isFull3D()
    {
        return true;
    }
    public String getUnlocalizedName(ItemStack i)
    {
    	if(ID == forgottennature.crystalToolIndex-252)
    		return "choe";
    	else if(ID == forgottennature.crystalToolIndex-249)
    		return "dhoe";
    	else
    		return "ohoe";
    }
}
