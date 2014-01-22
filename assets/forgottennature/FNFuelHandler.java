package assets.forgottennature;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class FNFuelHandler implements IFuelHandler 
{
	public int getBurnTime(ItemStack fuel) 
	{
		int i = fuel.itemID;
		int j = fuel.getItemDamage();
        if(i == forgottennature.newLogs.blockID || i == forgottennature.newSap2.blockID || i == forgottennature.newSap3.blockID)
        {
           return 500;
        }
        if(i == forgottennature.plankID)
        {
           return 300;
        }
        if(i == forgottennature.newSap.blockID || i == forgottennature.newSap2.blockID || i == forgottennature.newSap3.blockID)
        {
           return 100;
        }
        if(i == forgottennature.carbonItemsID && j == 0) 
        {
           return 12800;
        }
        if(i == forgottennature.carbonItemsID && j == 1)
        {
           return 102400;
        }
        if(i == forgottennature.carbonItemsID && j == 2)
        {
           return 800;
        }
        return 0;
	}
}
