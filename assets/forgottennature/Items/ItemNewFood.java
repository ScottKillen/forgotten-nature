package assets.forgottennature.Items;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemNewFood extends ItemFood
{
	@SideOnly(Side.CLIENT)
	private Icon[] field_94594_d;

    public ItemNewFood(int i)
    {
        super(i, 8, 0.6F, false);
        setMaxDamage(0);
        setHasSubtypes(true);
        setMaxStackSize(64);
        LanguageRegistry.addName(new ItemStack(this, 1, 0), "Blackberry Bread");
        LanguageRegistry.addName(new ItemStack(this, 1, 1), "Huckleberry Bread");
        LanguageRegistry.addName(new ItemStack(this, 1, 2), "Blueberry Bread");
        LanguageRegistry.addName(new ItemStack(this, 1, 3), "Raspberry Bread");
        LanguageRegistry.addName(new ItemStack(this, 1, 4), "Fruit Nut Bread");
    }
    public Icon getIconFromDamage(int i)
    {
    	return this.field_94594_d[i];
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.field_94594_d = new Icon[5];

        this.field_94594_d[0] = par1IconRegister.registerIcon("forgottennature:FoodBlackberryBread");
        this.field_94594_d[1] = par1IconRegister.registerIcon("forgottennature:FoodHuckleberryBread");
        this.field_94594_d[2] = par1IconRegister.registerIcon("forgottennature:FoodBlueberryBread");
        this.field_94594_d[3] = par1IconRegister.registerIcon("forgottennature:FoodRaspberryBread");
        this.field_94594_d[4] = par1IconRegister.registerIcon("forgottennature:FoodBerryNutBread");
    }
    public int getMetadata(int par1)
    {
        return par1 & 15;
    }

    @SideOnly(Side.CLIENT)
    public void getSubItems(int i, CreativeTabs tabs, List list)
    {
    	for(int j = 0; j < 5; j++)
    	{
    		list.add(new ItemStack(i, 1, j));
    	}
    }
    public String getUnlocalizedName(ItemStack i)
    {
	    switch(i.getItemDamage())
	    {
		    case 0:return "black";
		    case 1:return "huckle";
		    case 2:return "blue";
		    case 3:return "rasp";
		    case 4:return "berrynut";
		    default:return "";
	    }
    }
}
