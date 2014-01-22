package assets.forgottennature.Items;

import java.util.List;

import assets.forgottennature.forgottennature;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTorch extends ItemBlock
{
	Block currentBlock;
	
    public ItemTorch(int i)
    {
        super(i);
        setMaxDamage(0);
        setHasSubtypes(true);
        currentBlock = Block.blocksList[i+256];
        LanguageRegistry.instance().addName(new ItemStack(this), "Crystal Torch");
    }
    public Icon getIconFromDamage(int i)
    {
        return currentBlock.getIcon(0, i);
    }
    public int getMetadata(int i)
    {
        return i;
    }
    @SideOnly(Side.CLIENT)
    public void getSubItems(int i, CreativeTabs tabs, List list)
    {
    		list.add(new ItemStack(i, 1, 0));
    }
}