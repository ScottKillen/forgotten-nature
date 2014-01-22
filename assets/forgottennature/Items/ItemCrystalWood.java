package assets.forgottennature.Items;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import assets.forgottennature.forgottennature;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemCrystalWood extends ItemBlock
{
    public static String[] blockNames = {"crystalLog", "*blackCrystalLog*", "crystalPlank","blackCrystalPlank"};
    public ItemCrystalWood(int i)
    {
        super(i);
        setMaxDamage(0);
        setHasSubtypes(true);
        LanguageRegistry.addName(new ItemStack(this,1,0), "Crystal Log");
        LanguageRegistry.addName(new ItemStack(this,1,1), "Dark Crytal Log");
        LanguageRegistry.addName(new ItemStack(this,1,2), "Crystal Plank");
        LanguageRegistry.addName(new ItemStack(this,1,3), "Dark Crystal Plank");
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
    	for(int j = 0; j < 4; j++)
    	{
    		list.add(new ItemStack(i, 1, j));
    	}
    }
    public String getUnlocalizedName(ItemStack i)
    {
	    switch(i.getItemDamage())
	    {
		    case 0:return "Crystal Log";
		    case 1:return "Dark Crystal Log";
		    case 2:return "Crystal Plank";
		    case 3:return "Dark Crystal Plank";
		    default:return "";
	    }
    }
}