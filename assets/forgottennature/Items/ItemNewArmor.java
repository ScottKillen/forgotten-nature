package assets.forgottennature.Items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import assets.forgottennature.forgottennature;

public class ItemNewArmor extends ItemArmor
{
	@SideOnly(Side.CLIENT)
    private Icon field_94604_cx[];
//    	"chestPlateTitanStone", "helmetTitanStone", "leggingsTitanStone", "bootsTitanStone"};
    private int armID;

        public ItemNewArmor(int i, EnumArmorMaterial enumarmormaterial, int j, int k)
        {
                super(i, enumarmormaterial, j, k);
                armID = i;
        }
        
        @SideOnly(Side.CLIENT)
        public Icon getIconFromDamage(int par1)
        {
        	if(armID == forgottennature.armorID)
        		return this.field_94604_cx[0];
        	if(armID == forgottennature.armorID+1)
        		return this.field_94604_cx[1];
        	if(armID == forgottennature.armorID+2)
        		return this.field_94604_cx[2];
        	if(armID == forgottennature.armorID+3)
        		return this.field_94604_cx[3];
        	if(armID == forgottennature.armorID+4)
        		return this.field_94604_cx[4];
        	if(armID == forgottennature.armorID+5)
        		return this.field_94604_cx[5];
        	if(armID == forgottennature.armorID+6)
        		return this.field_94604_cx[6];
        	return this.field_94604_cx[7];
        }
        @SideOnly(Side.CLIENT)
        public void registerIcons(IconRegister par1IconRegister)
        {
            super.registerIcons(par1IconRegister);
            this.field_94604_cx = new Icon[8];
            
            this.field_94604_cx[0] = par1IconRegister.registerIcon("forgottennature:helmetObsidian");
            this.field_94604_cx[1] = par1IconRegister.registerIcon("forgottennature:chestPlateObsidian");
            this.field_94604_cx[2] = par1IconRegister.registerIcon("forgottennature:leggingsObsidian");
            this.field_94604_cx[3] = par1IconRegister.registerIcon("forgottennature:bootsObsidian");
            this.field_94604_cx[4] = par1IconRegister.registerIcon("forgottennature:helmetTitanStone");
            this.field_94604_cx[5] = par1IconRegister.registerIcon("forgottennature:chestPlateTitanStone");
            this.field_94604_cx[6] = par1IconRegister.registerIcon("forgottennature:leggingsTitanStone");
            this.field_94604_cx[7] = par1IconRegister.registerIcon("forgottennature:bootsTitanStone");
        }

		public String getArmorTexture(ItemStack itemstack, Entity entity, int slot, int layer)
        {
			if(armID <= forgottennature.armorID+3)
			{
	            if(armID == forgottennature.armorID || armID == (forgottennature.armorID+1) || itemstack.itemID == (forgottennature.armorID+3))
	            {
	                    return "forgottennature:textures/armor/obsidianArmor_1.png";//all but legs
	            }
	            if(armID == (forgottennature.armorID+2))//legs
	            {
	                    return "forgottennature:textures/armor/obsidianArmor_2.png";
	            }
	            else
	            return "forgottennature:textures/armor/obsidianArmor_1.png";
			}
			if(armID == forgottennature.armorID+4 || armID == (forgottennature.armorID+5) || itemstack.itemID == (forgottennature.armorID+7))
            {
                    return "forgottennature:textures/armor/titanStoneArmor_1.png";//all but legs
            }
            if(armID == (forgottennature.armorID+6))//legs
            {
                    return "forgottennature:textures/armor/titanStoneArmor_2.png";
            }
            else
            return "forgottennature:textures/armor/titanStoneArmor_1.png";
        }
}