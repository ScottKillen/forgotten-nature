package assets.forgottennature.Items;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import assets.forgottennature.forgottennature;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemNetherLeaves extends ItemBlock
{
    public ItemNetherLeaves(int i)
    {
        super(i);
        setMaxDamage(0);
        setHasSubtypes(true);
    }
    public int getMetadata(int i)
    {
        return i;
    }
    public int getPlacedBlockMetadata(int damage)
    {
        return damage;
    }
    @SideOnly(Side.CLIENT)
    public void getSubItems(int i, CreativeTabs tabs, List list)
    {
    	for(int j = 0; j < 2; j++)
    	{
    		list.add(new ItemStack(i, 1, j));
    	}
    }
    public String getUnlocalizedName(ItemStack i)
    {
	    switch(i.getItemDamage())
	    {
		    case 0:return "netherash leaves";
		    case 1:return "netherblaze leaves";
		    default:return "";
	    }
    }
}