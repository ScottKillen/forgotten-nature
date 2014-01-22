package assets.forgottennature.Items;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
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

public class ItemFoodDish extends ItemFood
{
	@SideOnly(Side.CLIENT)
	private Icon field_94594_d;

    private int oniGar;
    private int pTGinger;
    private int wChestnut;
    
    public ItemFoodDish(int i)
    {
        super(i, 6, 1.0F, false);
        setMaxDamage(0);
        setHasSubtypes(true);
        setMaxStackSize(64);
		LanguageRegistry.addName(new ItemStack(this,1,0), "Veggie Bowl (Resistance)");	  //celGingPars
		LanguageRegistry.addName(new ItemStack(this,1,1), "Veggie Bowl (Speed)");		  //oniGarCorn
		LanguageRegistry.addName(new ItemStack(this,1,2), "Veggie Bowl (The Getaway)");	  //ParsGrapeBroc
		LanguageRegistry.addName(new ItemStack(this,1,3), "Veggie Bowl (Major Fleeing)"); //oniGarCornParGrapeBroc
		LanguageRegistry.addName(new ItemStack(this,1,4), "Veggie Bowl (Mining)");		  //garTomTom/ GarGarTom
		LanguageRegistry.addName(new ItemStack(this,1,5), "Veggie Bowl (Clensing Regen)");//PeaPeaTurn/PeaTurnTrun/PeaTurnCab/PeaPeaCab/PeaCabCab
		LanguageRegistry.addName(new ItemStack(this,1,6), "Veggie Bowl (Regen)");		  //CornGingRice
		LanguageRegistry.addName(new ItemStack(this,1,7), "Veggie Bowl (Regen Berserk)"); //TomGrapeBroc
		LanguageRegistry.addName(new ItemStack(this,1,9), "Veggie Bowl (Night-Eye Regen)");		 //PinePine(Corn,gin,rice,tom,grape,broc)
		LanguageRegistry.addName(new ItemStack(this,1,10), "Veggie Bowl (Amphibious Regen)");	 //WchestWchest(corn/gin/rice/tom/grape/broc)
		LanguageRegistry.addName(new ItemStack(this,1,11), "Veggie Bowl (Amphibious Night-Eye)");//WchestWchestPinePine
		LanguageRegistry.addName(new ItemStack(this,1,12), "Veggie Bowl (Warrior)");			 //grapePineTomRice
    }

    public int getMetadata(int par1)
    {
        return par1 & 15;
    }
    public Icon getIconFromDamage(int i)
    {
    	return this.field_94594_d;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.field_94594_d = par1IconRegister.registerIcon("forgottennature:VeggieBowl");
    }
    public ItemStack onEaten(ItemStack itemstack, World par2World, EntityPlayer entityplayer)
    {
        --itemstack.stackSize;
        entityplayer.getFoodStats().addStats(this);
        par2World.playSoundAtEntity(entityplayer, "random.burp", 0.5F, par2World.rand.nextFloat() * 0.1F + 0.9F);

        if (itemstack.getItemDamage() == 0)//Veggie Bowl (resistance): celGingPars
        {
        	entityplayer.addPotionEffect(new PotionEffect(Potion.resistance.id, 20 * 20, 1));
        	entityplayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 3 * 20, 1));
        	entityplayer.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 10 * 20, 1));
        }
        else
        if (itemstack.getItemDamage() == 1)//Veggie Bowl (speed): oniGarCorn
        {
        	entityplayer.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 20 * 20, 1));
        	entityplayer.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 20 * 20, 1));
        	entityplayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 3 * 20, 1));
        }
        else
        if (itemstack.getItemDamage() == 2)//Veggie Bowl (The Getaway): ParsGrapeBroc
        {
        	entityplayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 3 * 20, 1));
        	entityplayer.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 20 * 20, 2));
        	entityplayer.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 5 * 20, 1));
        	entityplayer.addPotionEffect(new PotionEffect(Potion.resistance.id, 10 * 20, 1));
        }
        else
        if (itemstack.getItemDamage() == 3)//Veggie Bowl (Major Fleeing): oniGarCornParGrapeBroc
        {
        	entityplayer.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 30 * 20, 2));
        	entityplayer.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 15 * 20, 1));
        	entityplayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 3 * 20, 1));
        	entityplayer.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 5 * 20, 1));
        	entityplayer.addPotionEffect(new PotionEffect(Potion.resistance.id, 10 * 20, 1));
        }
        else
        if (itemstack.getItemDamage() == 4)//Veggie Bowl (Mining): garTomTom/ GarGarTom
        {
        	entityplayer.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 10 * 20, 1));
        	entityplayer.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 25 * 20, 2));
        	entityplayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 3 * 20, 1));
        }
        else
        if (itemstack.getItemDamage() == 5)//Veggie Bowl (Clensing Regen): PeaPeaTurn/PeaTurnTrun/PeaTurnCab/PeaPeaCab/PeaCabCab
        {
        	entityplayer.clearActivePotions();
        	entityplayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 10 * 20, 1));
        }
        else
        if (itemstack.getItemDamage() == 6)//Veggie Bowl (regen): CornGingRice 
        {
        	entityplayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 1 * 20, 3));
        	entityplayer.addPotionEffect(new PotionEffect(Potion.resistance.id, 5 * 20, 1));
        	entityplayer.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 10 * 20, 1));
        	entityplayer.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 10 * 20, 1));
        }
        else
        if (itemstack.getItemDamage() == 7)//Veggie Bowl (Regen Berserk): TomGrapeBroc
        {
        	entityplayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 5 * 20, 1));
        	entityplayer.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 10 * 20, 2));
        	entityplayer.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 10 * 20, 1));
        }
        else
        if (itemstack.getItemDamage() == 9)//Veggie Bowl (NightEye Regen): PinePine(Corn,gin,rice,tom,grape,broc)
        {
        	entityplayer.addPotionEffect(new PotionEffect(Potion.nightVision.id, 15 * 20, 1));
        	entityplayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 2 * 20, 2));
        }
        else
    	if (itemstack.getItemDamage() == 10)//Veggie Bowl (Amphibious Regen): WchestWchest(corn/gin/rice/tom/grape/broc)
        {
        	entityplayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 2 * 20, 2));
        	entityplayer.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 15 * 20, 1));
        }
        else
        if (itemstack.getItemDamage() == 11)//Veggie Bowl (Amphibious NightEye): WchestWchestPinePine
        {
        	entityplayer.addPotionEffect(new PotionEffect(Potion.nightVision.id, 15 * 20, 1));
        	entityplayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 4 * 20, 1));
        	entityplayer.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 15 * 20, 1));
        }
        else
        if (itemstack.getItemDamage() == 12)//Veggie Bowl (Warrior): grapePineTomRice
        {
        	entityplayer.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 20 * 20, 1));
        	entityplayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 7 * 20, 1));
        }
        entityplayer.inventory.addItemStackToInventory(new ItemStack(Item.bowlEmpty));
		return itemstack;
    }
    @SideOnly(Side.CLIENT)
    public void getSubItems(int i, CreativeTabs tabs, List list)
    {
    	for(int j = 0; j < 13; j++)
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
		    case 0:return "Veggie Bowl (Resistance)";
		    case 1:return "Veggie Bowl (speed)";
		    case 2:return "Veggie Bowl (The Getaway)";
		    case 3:return "Veggie Bowl(Major Fleeing)";
		    case 4:return "Veggie Bowl(Mining)";
		    case 5:return "Veggie Bowl(Clensing Regen)";
		    case 6:return "Veggie Bowl(Regen)";
		    case 7:return "Veggie Bowl(regen berserk)";
		    case 8:return "empty";
		    case 9:return "Veggie Bowl(nighteye Regen)";
		    case 10:return "Veggie Bowl(amphibious regen)";
		    case 11:return "Veggie Bowl(amphibious nighteye)";
		    case 12:return "Veggie Bowl(warrior)";
		    default:return "";
	    }
    }
}
