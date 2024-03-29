package assets.forgottennature.Items;

import java.util.ArrayList;

import assets.forgottennature.forgottennature;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTitanStonePA extends ItemTool
{
	@SideOnly(Side.CLIENT)
    private Icon field_94594_d;
	
	private static Block[] blocksEffectiveAgainst = (new Block[] {forgottennature.newPlanks,
			forgottennature.newLogs,forgottennature.newLogs2,forgottennature.newLogs3, Block.planks, 
			Block.bookShelf, Block.wood, Block.chest, Block.woodSingleSlab, Block.woodDoubleSlab, 
        	Block.pumpkin, Block.pumpkinLantern, forgottennature.crystalWood, Block.grass, Block.dirt, 
        	Block.sand, Block.gravel, Block.snow, Block.blockSnow, Block.blockClay, Block.tilledField, 
        	Block.slowSand, Block.mycelium, Block.cobblestone, Block.woodSingleSlab, Block.woodDoubleSlab, 
        	Block.stone, Block.sandStone, Block.cobblestoneMossy, Block.oreIron, Block.blockIron, 
        	Block.oreCoal, Block.blockGold, Block.oreGold, Block.oreDiamond, Block.blockDiamond, Block.ice, 
        	Block.oreLapis, Block.blockLapis, Block.obsidian, forgottennature.crystalStone});
    
    public boolean canHarvestBlock(Block par1Block)
    {
        return par1Block == Block.obsidian ? this.toolMaterial.getHarvestLevel() >= 1 : 
        	(par1Block != Block.blockDiamond && par1Block != Block.oreDiamond ? 
			(par1Block == Block.oreEmerald ? this.toolMaterial.getHarvestLevel() >= 1 : 
			(par1Block != Block.blockGold && par1Block != Block.oreGold ? 
			(par1Block != Block.blockIron && par1Block != Block.oreIron ? 
			(par1Block != Block.blockLapis && par1Block != Block.oreLapis ? 
			(par1Block != Block.oreRedstone && par1Block != Block.oreRedstoneGlowing ? 
			(par1Block.blockMaterial == Material.rock ? true : par1Block.blockMaterial == Material.iron) : 
			this.toolMaterial.getHarvestLevel() >= 1) : this.toolMaterial.getHarvestLevel() >= 1) : 
			this.toolMaterial.getHarvestLevel() >= 1) : this.toolMaterial.getHarvestLevel() >= 2)) : 
			this.toolMaterial.getHarvestLevel() >= 1);
    }
    public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
    {
        return par2Block != null && (par2Block.blockMaterial == Material.iron || 
        		par2Block.blockMaterial == Material.rock || par2Block.blockMaterial == Material.wood) ? 
        			this.efficiencyOnProperMaterial : 
        			super.getStrVsBlock(par1ItemStack, par2Block);
    }
	
    public ItemTitanStonePA(int i, EnumToolMaterial enumtoolmaterial)
    {
        super(i, 2, enumtoolmaterial, blocksEffectiveAgainst);
        maxStackSize = 1;
        LanguageRegistry.addName(new ItemStack(this), "Titan Stone Pickaxe");
    }
    public Icon getIconFromDamage(int i)
    {
    	return this.field_94594_d;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.field_94594_d = par1IconRegister.registerIcon("forgottennature:PickaxeTitanStone");
    }

    public String getUnlocalizedName(ItemStack i)
    {
    	return "tspaxe";
    }
    
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer entityplayer, World world, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
    	byte var8 = 0;
    	ItemStack equipped = entityplayer.getCurrentEquippedItem();
    	int ID = 0;
    	Block block;
    	if (!entityplayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
            return false;
    	if(ID != Block.bedrock.blockID)
    	//4,5,6=>i,j,k
    	{
    		if (par7 == 1 || par7 == 0)
            {
                for(int i = -1; i <= 1; i++)
                {
                	for(int j = 0; j <= 2; j++)
                	{
                		for(int k = -1; k <= 1; k++)
                		{
                			if(par7 == 1)
                				ID = world.getBlockId(par4 + i, par5 - j, par6 + k);
                			else
                				ID = world.getBlockId(par4 + i, par5 + j, par6 + k);
                			
                			if(ID != Block.bedrock.blockID && ID != Block.waterStill.blockID && 
                					ID != Block.waterMoving.blockID && ID != Block.lavaStill.blockID && 
                					ID != Block.lavaMoving.blockID)
                			{
                				if(par7 == 1)
                					world.destroyBlock(par4 + i, par5 - j, par6 + k, true);
                				else
                					world.destroyBlock(par4 + i, par5 + j, par6 + k, true);
                				
                        		if(equipped.getItemDamage()+1 <= equipped.getMaxDamage())
                        			par1ItemStack.damageItem(1, entityplayer);
                			}
                		}
                	}
                }
            }
    		
    		if (par7 == 2 || par7 == 3)
            {
                for(int i = -1; i <= 1; i++)
                {
                	for(int j = -1; j <= 1; j++)
                	{
                		for(int k = 0; k <= 2; k++)
                		{
                			if(par7 == 3)
                				ID = world.getBlockId(par4 + i, par5 + j, par6 - k);
                			else
                				ID = world.getBlockId(par4 + i, par5 + j, par6 + k);
                			
                			if(ID != Block.bedrock.blockID && ID != Block.waterStill.blockID && 
                					ID != Block.waterMoving.blockID && ID != Block.lavaStill.blockID && 
                					ID != Block.lavaMoving.blockID)
                			{
                				if(par7 == 3)
                					world.destroyBlock(par4 + i, par5 + j, par6 - k, true);
                				else
                					world.destroyBlock(par4 + i, par5 + j, par6 + k, true);
                				
                        		if(equipped.getItemDamage()+1 <= equipped.getMaxDamage())
                        			par1ItemStack.damageItem(1, entityplayer);
                			}
                		}
                	}
                }
            }
    		if (par7 == 4 || par7 == 5)
            {
                for(int i = 0; i <= 2; i++)
                {
                	for(int j = -1; j <= 1; j++)
                	{
                		for(int k = -1; k <= 1; k++)
                		{
                			if(par7 == 5)
                				ID = world.getBlockId(par4 - i, par5 + j, par6 + k);
                			else
                				ID = world.getBlockId(par4 + i, par5 + j, par6 + k);
                			
                			if(ID != Block.bedrock.blockID && ID != Block.waterStill.blockID && 
                					ID != Block.waterMoving.blockID && ID != Block.lavaStill.blockID && 
                					ID != Block.lavaMoving.blockID)
                			{
                				if(par7 == 5)
                					world.destroyBlock(par4 - i, par5 + j, par6 + k, true);
                				else
                					world.destroyBlock(par4 + i, par5 + j, par6 + k, true);
                				
                        		if(equipped.getItemDamage()+1 <= equipped.getMaxDamage())
                        			par1ItemStack.damageItem(1, entityplayer);
                			}
                		}
                	}
                }
            }
    		return true;
    	}    	
    	else
    		return false;
    }
}