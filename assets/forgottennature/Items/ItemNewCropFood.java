package assets.forgottennature.Items;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import assets.forgottennature.forgottennature;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemNewCropFood extends ItemFood
{
	@SideOnly(Side.CLIENT)
	private Icon[] field_94594_d;

    private int oniGar;
    private int pTGinger;
    private int wChestnut;
    
    public ItemNewCropFood(int i, int par1, int par2, int par3)
    {
        super(i, 2, 0.2F, false);
        oniGar = par1;
        pTGinger = par2;
        wChestnut = par3;
        setMaxDamage(0);
        setHasSubtypes(true);
        setMaxStackSize(64);
        LanguageRegistry.addName(new ItemStack(this,1,0), "Knob Celery Sticks");
		LanguageRegistry.addName(new ItemStack(this,1,1), "Onion Bulb");
		LanguageRegistry.addName(new ItemStack(this,1,2), "Garlic Bulb");
		LanguageRegistry.addName(new ItemStack(this,1,3), "Corn Ear");
		LanguageRegistry.addName(new ItemStack(this,1,4), "Peanuts");
		LanguageRegistry.addName(new ItemStack(this,1,5), "Turnip");
		LanguageRegistry.addName(new ItemStack(this,1,6), "Ginger Bulb");
		LanguageRegistry.addName(new ItemStack(this,1,7), "Parsley");
		LanguageRegistry.addName(new ItemStack(this,1,9), "Water Chestnut");
		LanguageRegistry.addName(new ItemStack(this,1,10), "Rice");
		LanguageRegistry.addName(new ItemStack(this,1,11), "Tomato");
		LanguageRegistry.addName(new ItemStack(this,1,12), "Cabbage");
		LanguageRegistry.addName(new ItemStack(this,1,13), "Pineapple");
		LanguageRegistry.addName(new ItemStack(this,1,14), "Grapes");
		LanguageRegistry.addName(new ItemStack(this,1,15), "Broccoli");
    }
    public Icon getIconFromDamage(int i)
    {
    	return this.field_94594_d[i];
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.field_94594_d = new Icon[16];

        this.field_94594_d[0] = par1IconRegister.registerIcon("forgottennature:CropCelery");
        this.field_94594_d[1] = par1IconRegister.registerIcon("forgottennature:CropOnion");
        this.field_94594_d[2] = par1IconRegister.registerIcon("forgottennature:CropGarlic");
        this.field_94594_d[3] = par1IconRegister.registerIcon("forgottennature:CropCorn");
        this.field_94594_d[4] = par1IconRegister.registerIcon("forgottennature:CropPeanuts");
        this.field_94594_d[5] = par1IconRegister.registerIcon("forgottennature:CropTurnip");
        this.field_94594_d[6] = par1IconRegister.registerIcon("forgottennature:CropGinger");
        this.field_94594_d[7] = par1IconRegister.registerIcon("forgottennature:CropParsley");
        this.field_94594_d[9] = par1IconRegister.registerIcon("forgottennature:CropWaterChestnut");
        this.field_94594_d[10] = par1IconRegister.registerIcon("forgottennature:CropRice");
        this.field_94594_d[11] = par1IconRegister.registerIcon("forgottennature:CropTomato");
        this.field_94594_d[12] = par1IconRegister.registerIcon("forgottennature:CropCabbage");
        this.field_94594_d[13] = par1IconRegister.registerIcon("forgottennature:CropPineapple");
        this.field_94594_d[14] = par1IconRegister.registerIcon("forgottennature:CropGrapes");
        this.field_94594_d[15] = par1IconRegister.registerIcon("forgottennature:CropBroccoli");
    }
    
    public int getMetadata(int par1)
    {
        return par1 & 15;
    }

    public ItemStack onEaten(ItemStack itemstack, World par2World, EntityPlayer entityplayer)
    {
        --itemstack.stackSize;
        entityplayer.getFoodStats().addStats(this);
        par2World.playSoundAtEntity(entityplayer, "random.burp", 0.5F, par2World.rand.nextFloat() * 0.1F + 0.9F);

        if (itemstack.getItemDamage() == 0)//celery
        {
        	entityplayer.addPotionEffect(new PotionEffect(Potion.resistance.id, 10 * 20, 2));
        }
        else
        if (itemstack.getItemDamage() == 1)//onion
        {
        	entityplayer.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 10 * 20, 2));
        }
        else
        if (itemstack.getItemDamage() == 2)//garlic
        {
        	entityplayer.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 10 * 20, 1));
        	entityplayer.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 10 * 20, 1));
        }
        else
        if (itemstack.getItemDamage() == 3)//Corn
        {
        	entityplayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 1 * 20, 1));
        	entityplayer.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 10 * 20, 1));
        }
        else
        if (itemstack.getItemDamage() == 4)//Peanuts
        {
        	entityplayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 2 * 20, 1));
        }
        else
        if (itemstack.getItemDamage() == 5)//turnips
        {
        	entityplayer.clearActivePotions();
        	entityplayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 2 * 20, 1));
        }
        else
        if (itemstack.getItemDamage() == 6)//ginger
        {
        	entityplayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 1 * 20, 1));
        	entityplayer.addPotionEffect(new PotionEffect(Potion.resistance.id, 10 * 20, 1));
        }
        else
        if (itemstack.getItemDamage() == 7)//parsley
        {
        	entityplayer.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 10 * 20, 1));
        	entityplayer.addPotionEffect(new PotionEffect(Potion.resistance.id, 10 * 20, 1));
        }
        else
        if (itemstack.getItemDamage() == 9)//WChestnut
        {
        	entityplayer.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 10 * 20, 1));
        	entityplayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 1 * 20, 1));
        }
        else
        if (itemstack.getItemDamage() == 10)//rice
        {
        	entityplayer.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 10 * 20, 1));
        	entityplayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 1 * 20, 1));
        }
        else
        if (itemstack.getItemDamage() == 11)//tomatoes
        {
        	entityplayer.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 7 * 20, 1));
        	entityplayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 1 * 20, 1));
        	entityplayer.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 7 * 20, 1));
        }
        else
        if (itemstack.getItemDamage() == 12)//cabbage
        {
        	entityplayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 1 * 20, 2));
        }
        else
        if (itemstack.getItemDamage() == 13)//pineapples
        {
        	entityplayer.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 10 * 20, 1));
        	entityplayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 1 * 20, 1));
        	entityplayer.addPotionEffect(new PotionEffect(Potion.nightVision.id, 10 * 20, 1));
        }
        else
        if (itemstack.getItemDamage() == 14)//grapes
        {
        	entityplayer.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 10 * 20, 1));
        	entityplayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 1 * 20, 1));
        	entityplayer.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 10 * 20, 1));
        }
        else
        if (itemstack.getItemDamage() == 15)//broccoli
        {
        	entityplayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 1 * 20, 2));
        	entityplayer.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 10 * 20, 2));
        }
		return itemstack;
    }
    public boolean onItemUse(ItemStack itemstack, EntityPlayer par2EntityPlayer, World world, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        if (par7 != 1)
            return false;
        else if (par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, itemstack) && par2EntityPlayer.canPlayerEdit(par4, par5 + 1, par6, par7, itemstack))
        {
        	int var8 = world.getBlockId(par4, par5, par6);
            if (var8 == Block.tilledField.blockID && world.isAirBlock(par4, par5 + 1, par6))
            {
            	if(itemstack.getItemDamage() == 1)
                	world.setBlock(par4, par5 + 1, par6, this.oniGar, 4, 2);//onion
            	else
            	if(itemstack.getItemDamage() == 2)
            		world.setBlock(par4, par5 + 1, par6, this.oniGar, 8, 2);//garlic
            	else
            	if(itemstack.getItemDamage() == 4)
                	world.setBlock(par4, par5 + 1, par6, this.pTGinger, 0, 2);//peanuts
            	else
            	if(itemstack.getItemDamage() == 5)
            		world.setBlock(par4, par5 + 1, par6, this.pTGinger, 4, 2);//turnip
            	else
            	if(itemstack.getItemDamage() == 6)
                	world.setBlock(par4, par5 + 1, par6, this.pTGinger, 8, 2);//ginger
                else
                if(itemstack.getItemDamage() == 9)
                	world.setBlock(par4, par5 + 1, par6, this.wChestnut, 8, 2);//wchestnut
                --itemstack.stackSize;
                return true;
            }
            else
                return false;
        }
        else
            return false;
    }
   
    @SideOnly(Side.CLIENT)
    public void getSubItems(int i, CreativeTabs tabs, List list)
    {
    	for(int j = 0; j < 16; j++)
    	{
    		if(j == 8)
    			j++;
    		list.add(new ItemStack(i, 1, j));
    	}
    }
    public String getUnlocalizedName(ItemStack i)
    {
	    switch(i.getItemDamage())
	    {
		    case 0:return "KnobCSticks";
		    case 1:return "Onion Bulb";
		    case 2:return "Garlic Bulb";
		    case 3:return "Corn Ear";
		    case 4:return "Peanuts";
		    case 5:return "Turnip";
		    case 6:return "Ginger";
		    case 7:return "Parsley";
		    case 8:return "Cotton";
		    case 9:return "Water Chestnut";
		    case 10:return "Rice";
		    case 11:return "Tomato";
		    case 12:return "Cabbage";
		    case 13:return "Pineapple";
		    case 14:return "Grapes";
		    case 15:return "Broccoli";
		    default:return "";
	    }
    }
}