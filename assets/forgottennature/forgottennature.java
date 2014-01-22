package assets.forgottennature;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.logging.Level;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemReed;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.MapGenVillage;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;
import net.minecraftforge.oredict.OreDictionary;

import assets.forgottennature.Proxy.*;
import assets.forgottennature.Blocks.*;
import assets.forgottennature.Items.*;
import assets.forgottennature.WorldGen.*;
import assets.forgottennature.Biomes.*;

@Mod(modid="forgottennature", name="forgottennature", version="1.3.0")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)

public class forgottennature
{
	@SidedProxy(clientSide="assets.forgottennature.Proxy.FNClientProxy", serverSide="assets.forgottennature.Proxy.FNCommonProxy")
	public static FNCommonProxy proxy;
	
	//block&Item IDs
	public static int mushroomPlantID;
	public static int mushroomBlockID;
	public static int kCeleryOnionGarlicID;
	public static int peanutTurnipGingerID;
	public static int parsleyWChestnutRiceBroccoliID;
	public static int hempCottonBambooCornID;
	public static int grapeTomatoCabbagePineappleID;
	
	public static int ropeID;
	
	public static int newCropSeedsID;
	public static int newCropFoodID;
	public static int newCropGoodsID;
	public static int newFoodDishID;
	
	public static int newStonesID;
	public static int newGlassID;
    public static int leafIDindex;
    public static int logIDindex;
    public static int sapIDindex;
    public static int plankID;
    public static int plankID2;
    public static int fruitID;
    public static int ItemFruitID;
    public static int ItemNutID;
    public static int ItemNewFoodID;
    public static int ItemNewFoodID2;
    public static int ItemNewFoodID3;
    public static int ItemNewContainerID;
    public static int ItemNewCupID;
    
    public static int crystalToolIndex;
    public static int newToolIndex;
    public static int armorID;
    public static int crystalStoneID;
    public static int crystalItemID;
    public static int crystalWoodID;
    public static int blockCrystalID;
    public static int fenceID;
    public static int torchID;
    public static int groundID;
    public static int sawID;
    public static int sawItemID;
    public static int newFlowerID;
    public static int halfPlankID;
    public static int doubleHalfPlankID;
    public static int halfPlankID2;
    public static int doubleHalfPlankID2;
    public static int halfStoneID;
    public static int doubleHalfStoneID;
    public static int newStairsIdIndex;
    public static int powderID;
    public static int carbonItemsID;
    
    //biome ids
    public static int tropicalID;
    public static int redwoodID;
    public static int tropicalHillsID;
    public static int redwoodHillsID;
    public static int redwoodSnowHillsID;
    public static int redwoodSnowID;
    public static int crystalForestID;
    
	public static int newSeedWeight;
	public static int bamSpreadBuffer;
	public static boolean bambooGeneration;
	public static boolean bambooSpread;
    
    public static boolean lumberjack;
    public static boolean lumberjackDamage;
    public static int lumberjackPower;
    public static boolean leafDecay;
    //Trees and plants
    public static boolean AngelOak;
    public static boolean Eucalyptus;
    public static boolean Fig;
    public static boolean Jacaranda;
    public static boolean Sequoia;
    public static boolean Apple;
    public static boolean YellowMaple;
    public static boolean RedMaple;
    public static boolean DesertIronwood;
    public static boolean Cypress;
    public static boolean Cherry;
    public static boolean Acacia;
    public static boolean Joshua;
    public static boolean Willow;
    public static boolean decBush;
    public static boolean everBush;
    public static boolean palm;
    public static boolean dWillow;
    public static boolean cedar;
    public static boolean ginkgo;
    public static boolean poplar;
    public static boolean beech;
    public static boolean walnut;
    public static boolean wTopEucalyptus;
    public static boolean bukkit;
    public static boolean banana;
    public static boolean orange;
    public static boolean peach;
    public static boolean lemon;
    public static boolean blueberry;
    public static boolean raspberry;
    public static boolean blackberry;
    public static boolean huckleberry;
    //Biomes
    public static boolean redwoodForestc;
    public static boolean tropicalForestc;
    public static boolean tropicalForestHillsc;
    public static boolean redwoodForestHillsc;
    public static boolean redwoodForestHillsSnowc;
    public static boolean redwoodForestSnowc;
    public static boolean CrystalForest;
    
    //vanBiomes
    public static boolean vanDesert;
    public static boolean vanExtremeHills;
    public static boolean vanForest;
    public static boolean vanJungle;
    public static boolean vanPlains;
    public static boolean vanSwampland;
    public static boolean vanTaiga;

    
    public static boolean crystalGround;
    public static boolean figFruit;
    public static boolean crystalTools;
    public static boolean obsidianTools;
    public static boolean StoneGranite;
    public static boolean StoneChert;
    public static boolean StoneMarble;
    public static boolean StoneHornfels;
    public static boolean StoneGneiss;
    public static boolean stone = true;
    public static boolean carbonItems;
    public static boolean craftGunpowder;
    public static boolean crystalMushrooms;

    public static int newTreePerChunkCount;
    public static int newLeafDecayBuffer;
    public static int flowerGen;
    public static int extraAxe1ID;
    public static int extraAxe2ID;
    public static int extraAxe3ID;
    public static int extraAxe4ID;
    
    /*
     * Render IDs to avoid render overlap with other mod blocks
     */
    public static int FNLogRenderID;
    public static int FNFlowerPotRenderID;
    
    public static int flowerPotID;
    public static int flowerPotID2;
    public static int flowerPotID3;
    public static int flowerPotID4;
    
    //Block declarations
	public static Block kCelOniGar;
	public static Block turnGinPea;
	public static Block parsWChestRiceBrocc;
	public static Block hempCotBamCorn;
	public static Block grapeTomCabPine;
	public static Block rope;
	
    public static Block newLeaves;
    public static Block newLeaves2;
    public static Block newLeaves3;
    public static Block newLeaves4;
    public static Block newLeaves5;
    public static Block newLeaves6;
    public static Block netherLeaves;
    public static Block newLogs;
    public static Block newLogs2;
    public static Block newLogs3;
    public static Block newLogs4;
    public static Block netherLogs;
    public static Block newSap;
    public static Block newSap2;
    public static Block newSap3;
    public static Block newPlanks;
    public static Block newPlanks2;
    public static Block newFruit;
    public static Block crystalStone;
    public static Block crystalBlock;
    public static Block crystalWood;
    public static Block crystalLeaves;
    public static Block newFence;
    public static Block newTorch;
    public static Block newGround;
    public static Block newFlowers;
    public static Block newStairs1;
    public static Block newStairs2;
    public static Block newStairs3;
    public static Block newStairs4;
    public static Block newStairs5;
    public static Block newStairs6;
    public static Block newStairs7;
    public static Block newStairs8;
    public static Block newStairs9;
    public static Block newStairs10;
    public static Block newStairs11;
    public static Block newStairs12;
    public static Block newStairs13;
    public static Block newStairs14;
    public static Block newStairs15;
    public static Block newStoneStairs1;
    public static Block newStoneStairs2;
    public static Block newStoneStairs3;
    public static Block newStoneStairs4;
    public static BlockHalfSlab newHalfPlanks;
    public static BlockHalfSlab newDoubleHalfPlanks;
    public static BlockHalfSlab newHalfPlanks2;
    public static BlockHalfSlab newDoubleHalfPlanks2;
    public static BlockHalfSlab newHalfStone;
    public static BlockHalfSlab newDoubleHalfStone;
    public static Block LJ;
    public static Block FNStone;
    public static Block FNSandStone;
    public static Block FNGlass;
    public static Block newStones;
    public static Block mushroomCrystal;
    public static Block mushroomCrystalBlock;
    public static Block flowerPot;
    public static Block flowerPot2;
    public static Block flowerPot3;
    public static Block flowerPot4;
    public static Item flowerPotItem;
    public static Item flowerPotItem2;
    public static Item flowerPotItem3;
    public static Item flowerPotItem4;
    //armor
    public static Item helmetObsidian;
    public static Item plateObsidian;
    public static Item legsObsidian;
    public static Item bootsObsidian; 
    public static Item helmetTitanStone;
    public static Item plateTitanStone;
    public static Item legsTitanStone;
    public static Item bootsTitanStone;
    
    public static BiomeGenBase neoTropicalForest;
    public static BiomeGenBase neoRedwoodForest;
    public static BiomeGenBase neoTropicalForestHills;
    public static BiomeGenBase neoRedwoodForestHills;
    public static BiomeGenBase neoRedwoodForestSnowHills;
    public static BiomeGenBase neoRedwoodForestSnow;
    public static BiomeGenBase crystalForest;
    
    
//    WOOD(0, 59, 2.0F, 0, 15),
//    STONE(1, 131, 4.0F, 1, 5),
//    IRON(2, 250, 6.0F, 2, 14),
//    EMERALD(3, 1561, 8.0F, 3, 10),
//    GOLD(0, 32, 12.0F, 0, 22);
    public static EnumToolMaterial crystal = EnumHelper.addToolMaterial("Crystal", 1, 128, 7.0F, 2, 22);
    public static EnumToolMaterial darkCrystal = EnumHelper.addToolMaterial("Dark Crystal", 3, 1000, 7.0F, 3, 8);
    public static EnumToolMaterial obsidian = EnumHelper.addToolMaterial("Obsidian", 3, 1000, 10.0F, 3, 1);
    public static EnumToolMaterial titanStone = EnumHelper.addToolMaterial("titanStone", 3, 15000, 25.0F, 4, 22);
    public static EnumToolMaterial saw = EnumHelper.addToolMaterial("Saw", 3, 2000, 10.0F, 2, 14);
    
//    CLOTH(5, new int[]{1, 3, 2, 1}, 15),
//    CHAIN(15, new int[]{2, 5, 4, 1}, 12),
//    IRON(15, new int[]{2, 6, 5, 2}, 9),
//    GOLD(7, new int[]{2, 5, 3, 1}, 25),
//    DIAMOND(33, new int[]{3, 8, 6, 3}, 10);
    static EnumArmorMaterial armorObsidian = EnumHelper.addArmorMaterial("Obsidian", 29, new int[] {3, 8, 6, 3}, 1);
    static EnumArmorMaterial armorTitanStone = EnumHelper.addArmorMaterial("TitanStone", 50, new int[] {5, 10, 8, 5}, 25);
    
    @PostInit
    public void postInit(FMLPostInitializationEvent event)
    {}
    
    @Init
    public void load(FMLInitializationEvent event)
    {
        if(lumberjack)
        {
            Block.blocksList[17] = null;
        	LJ = new BlockLJ(17).setHardness(2.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("log").setTextureName("log");
        }
        
        {
        	flowerPot = new BlockNewFlowerPot(flowerPotID).setHardness(0.0F).setStepSound(Block.soundPowderFootstep).setUnlocalizedName("flowerPot1");
        	flowerPot2 = new BlockNewFlowerPot2(flowerPotID2).setHardness(0.0F).setStepSound(Block.soundPowderFootstep).setUnlocalizedName("flowerPot2");
        	flowerPot3 = new BlockNewFlowerPot3(flowerPotID3).setHardness(0.0F).setStepSound(Block.soundPowderFootstep).setUnlocalizedName("flowerPot3");
        	flowerPot4 = new BlockNewFlowerPot4(flowerPotID4).setHardness(0.0F).setStepSound(Block.soundPowderFootstep).setUnlocalizedName("flowerPot4");
        	flowerPotItem = (new NewItemReed(flowerPotID, flowerPot)).setUnlocalizedName("flowerPot1").setCreativeTab(this.tabFN);
        	flowerPotItem2 = (new NewItemReed(flowerPotID2, flowerPot2)).setUnlocalizedName("flowerPot2").setCreativeTab(this.tabFN);
        	flowerPotItem3 = (new NewItemReed(flowerPotID3, flowerPot3)).setUnlocalizedName("flowerPot3").setCreativeTab(this.tabFN);
        	flowerPotItem4 = (new NewItemReed(flowerPotID4, flowerPot4)).setUnlocalizedName("flowerPot4").setCreativeTab(this.tabFN);
        }
                
        mushroomCrystalBlock = new BlockCrystalMushroomBlock(mushroomBlockID).setHardness(2.0F).setStepSound(Block.soundGlassFootstep).setLightValue(0.9F).setUnlocalizedName("Crystal Mushroom Block").setCreativeTab(this.tabFN);
        mushroomCrystal = new BlockCrystalMushroom(mushroomPlantID).setHardness(0.5F).setStepSound(Block.soundGlassFootstep).setLightValue(0.8F).setUnlocalizedName("Crystal Mushroom").setCreativeTab(this.tabFN);
        //leaves
        newLeaves = new BlockNewLeaves(leafIDindex, leafDecay, newLeafDecayBuffer, fruitID).setHardness(0.2F).setLightOpacity(1).setStepSound(Block.soundGrassFootstep).setCreativeTab(this.tabFN) ;
        newLeaves2 = new BlockNewLeaves2(leafIDindex+1, leafDecay, newLeafDecayBuffer).setHardness(0.2F).setLightOpacity(1).setStepSound(Block.soundGrassFootstep).setCreativeTab(this.tabFN) ;
        newLeaves3 = new BlockNewLeaves3(leafIDindex+2, leafDecay, newLeafDecayBuffer, fruitID).setHardness(0.2F).setLightOpacity(1).setStepSound(Block.soundGrassFootstep).setCreativeTab(this.tabFN) ;
        newLeaves4 = new BlockNewLeaves4(leafIDindex+3, leafDecay, newLeafDecayBuffer, fruitID).setHardness(0.2F).setLightOpacity(1).setStepSound(Block.soundGrassFootstep).setCreativeTab(this.tabFN) ;
        newLeaves5 = new BlockNewLeaves5(leafIDindex+4, leafDecay, newLeafDecayBuffer, ItemFruitID).setHardness(0.2F).setLightOpacity(1).setStepSound(Block.soundGrassFootstep).setCreativeTab(this.tabFN) ;
        newLeaves6 = new BlockNewLeaves6(leafIDindex+5, leafDecay, newLeafDecayBuffer, ItemFruitID).setHardness(0.2F).setLightOpacity(1).setStepSound(Block.soundGrassFootstep).setCreativeTab(this.tabFN) ;
	    crystalLeaves = new BlockCrystalLeaves(leafIDindex+6).setHardness(0.3F).setLightOpacity(0).setStepSound(Block.soundGrassFootstep).setLightValue(0.9F).setCreativeTab(this.tabFN);
	    netherLeaves = new BlockNetherLeaves(leafIDindex+7, leafDecay, newLeafDecayBuffer).setHardness(0.2F).setLightOpacity(1).setStepSound(Block.soundGrassFootstep).setCreativeTab(this.tabFN) ;
        //logs
	    newLogs = new BlockNewLogs(logIDindex).setHardness(2.0F).setStepSound(Block.soundWoodFootstep).setCreativeTab(this.tabFN) ;
        newLogs2 = new BlockNewLogs2(logIDindex+1).setHardness(2.0F).setStepSound(Block.soundWoodFootstep).setCreativeTab(this.tabFN) ;
        newLogs3 = new BlockNewLogs3(logIDindex+2).setHardness(2.0F).setStepSound(Block.soundWoodFootstep).setCreativeTab(this.tabFN) ;
        newLogs4 = new BlockNewLogs4(logIDindex+3).setHardness(2.0F).setStepSound(Block.soundWoodFootstep);
        netherLogs = new BlockNetherLogs(logIDindex+4).setHardness(2.0F).setStepSound(Block.soundWoodFootstep).setCreativeTab(this.tabFN) ;
        //saps
        newSap = new BlockNewSap(sapIDindex).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setCreativeTab(this.tabFN) ;
        newSap2 = new BlockNewSap2(sapIDindex+1).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setCreativeTab(this.tabFN) ;
        newSap3 = new BlockNewSap3(sapIDindex+2).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setCreativeTab(this.tabFN) ;
        
        newPlanks = new BlockNewPlanks(plankID).setHardness(2.0F).setResistance(5F).setStepSound(Block.soundWoodFootstep).setCreativeTab(this.tabFN) ;
        newPlanks2 = new BlockNewPlanks2(plankID2).setHardness(2.0F).setResistance(5F).setStepSound(Block.soundWoodFootstep).setCreativeTab(this.tabFN) ;
        newFruit = new BlockNewFruit(fruitID, 0, ItemNutID, ItemFruitID).setHardness(0.2F).setLightOpacity(1).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("fruit");
        crystalStone = new BlockCrystalStone(crystalStoneID).setHardness(0.5F).setStepSound(Block.soundGlassFootstep).setLightValue(0.9F).setUnlocalizedName("crystalStone").setCreativeTab(this.tabFN);
        crystalBlock = new BlockCrystalBlock(blockCrystalID).setHardness(2.0F).setStepSound(Block.soundGlassFootstep).setLightValue(1.0F).setUnlocalizedName("crystalBlock").setCreativeTab(this.tabFN);
        crystalWood = new BlockCrystalWood(crystalWoodID).setHardness(2.0F).setStepSound(Block.soundWoodFootstep).setLightValue(0.96F).setUnlocalizedName("crystalWood").setCreativeTab(this.tabFN);
        newFence = new BlockNewFence(fenceID, "wood", Material.wood).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("fence");
        newTorch = new BlockNewTorch(torchID, 167).setHardness(0.0F).setStepSound(Block.soundGlassFootstep).setLightValue(1.0F).setCreativeTab(this.tabFN);
        newGround = new BlockNewGroundcover(groundID).setHardness(0.5F).setStepSound(Block.soundGravelFootstep).setLightValue(0.6F).setCreativeTab(this.tabFN);
        newFlowers = new BlockNewFlowers(newFlowerID).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("Flowers").setCreativeTab(this.tabFN); 
        newHalfPlanks = (BlockHalfSlab)(new BlockNewSlab(halfPlankID, false, Material.wood).setHardness(2.0F).setResistance(5F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("Half Plank").setCreativeTab(this.tabFN)); 
        newDoubleHalfPlanks = (BlockHalfSlab)(new BlockNewSlab(doubleHalfPlankID, true, Material.wood).setHardness(2.0F).setResistance(5F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("Half Plank")); 
        newHalfPlanks2 = (BlockHalfSlab)(new BlockNewSlab(halfPlankID2, false, Material.wood).setHardness(2.0F).setResistance(5F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("Half Plank").setCreativeTab(this.tabFN)); 
        newDoubleHalfPlanks2 = (BlockHalfSlab)(new BlockNewSlab(doubleHalfPlankID2, true, Material.wood).setHardness(2.0F).setResistance(5F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("Half Plank")); 
        newStairs1 = (new BlockNewStairs(newStairsIdIndex, newPlanks, 0)).setUnlocalizedName("stairsWood0").setCreativeTab(this.tabFN);
        newStairs2 = (new BlockNewStairs(newStairsIdIndex + 1, newPlanks, 1)).setUnlocalizedName("stairsWood1").setCreativeTab(this.tabFN);
        newStairs3 = (new BlockNewStairs(newStairsIdIndex + 2, newPlanks, 2)).setUnlocalizedName("stairsWood2").setCreativeTab(this.tabFN);
        newStairs4 = (new BlockNewStairs(newStairsIdIndex + 3, newPlanks, 3)).setUnlocalizedName("stairsWood3").setCreativeTab(this.tabFN);
        newStairs5 = (new BlockNewStairs(newStairsIdIndex + 4, newPlanks, 4)).setUnlocalizedName("stairsWood4").setCreativeTab(this.tabFN);
        newStairs6 = (new BlockNewStairs(newStairsIdIndex + 5, newPlanks, 5)).setUnlocalizedName("stairsWood5").setCreativeTab(this.tabFN);
        newStairs7 = (new BlockNewStairs(newStairsIdIndex + 6, newPlanks, 6)).setUnlocalizedName("stairsWood6").setCreativeTab(this.tabFN);
        newStairs8 = (new BlockNewStairs(newStairsIdIndex + 7, newPlanks, 7)).setUnlocalizedName("stairsWood7").setCreativeTab(this.tabFN);
        newStairs9 = (new BlockNewStairs(newStairsIdIndex + 8, newPlanks, 8)).setUnlocalizedName("stairsWood8").setCreativeTab(this.tabFN);
        newStairs10 = (new BlockNewStairs(newStairsIdIndex + 9, newPlanks, 9)).setUnlocalizedName("stairsWood9").setCreativeTab(this.tabFN);
        newStairs11 = (new BlockNewStairs(newStairsIdIndex + 10, newPlanks, 10)).setUnlocalizedName("stairsWood10").setCreativeTab(this.tabFN);
        newStairs12 = (new BlockNewStairs(newStairsIdIndex + 11, newPlanks, 11)).setUnlocalizedName("stairsWood11").setCreativeTab(this.tabFN);
        newStairs13 = (new BlockNewStairs(newStairsIdIndex + 12, newPlanks, 12)).setUnlocalizedName("stairsWood12").setCreativeTab(this.tabFN);
        newStairs14 = (new BlockNewStairs(newStairsIdIndex + 13, crystalWood, 2)).setUnlocalizedName("stairsWood13").setLightValue(0.8F).setCreativeTab(this.tabFN);
        newStairs15 = (new BlockNewStairs(newStairsIdIndex + 14, crystalWood, 3)).setUnlocalizedName("stairsWood14").setLightValue(0.8F).setCreativeTab(this.tabFN);
        
        kCelOniGar = new BlockKCelOniGar(kCeleryOnionGarlicID).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("newCrops1");
		turnGinPea = new BlockPeaTurnGinger(peanutTurnipGingerID).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("newCrops2");
		parsWChestRiceBrocc = new BlockParsWChestRiceBroc(parsleyWChestnutRiceBroccoliID).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("newCrops3");
		hempCotBamCorn = new BlockHempCotBamCorn(hempCottonBambooCornID).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("newCrops4").setCreativeTab(this.tabFN);
		grapeTomCabPine = new BlockGrapeTomCabPine(grapeTomatoCabbagePineappleID).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("newCrops5");
		rope = new BlockRope(ropeID).setHardness(0.5F).setResistance(1F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("Rope");
        
        FNGlass = new FNBlockGlass(newGlassID, Material.glass, false).setHardness(0.3F).setStepSound(Block.soundGlassFootstep).setUnlocalizedName("glass").setCreativeTab(this.tabFN);
       
        if(stone)
        {
        	newStones = new BlockNewStone(newStonesID).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("Stone2").setCreativeTab(this.tabFN);;
			Item.itemsList[newStonesID] = (new ItemNewStone(newStonesID - 256)).setUnlocalizedName("Stone2");
			newHalfStone = (BlockHalfSlab)(new BlockNewSlab(halfStoneID, false, Material.rock).setHardness(2.0F).setResistance(5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("Half block").setCreativeTab(this.tabFN)); 
	        newDoubleHalfStone = (BlockHalfSlab)(new BlockNewSlab(doubleHalfStoneID, true, Material.rock).setHardness(2.0F).setResistance(5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("Half block")); 
	        Item.itemsList[halfStoneID] = (new ItemNewHalfPlanks(halfStoneID - 256, newHalfStone, newDoubleHalfStone, false)).setUnlocalizedName("half block");
	        Item.itemsList[doubleHalfStoneID] = (new ItemNewHalfPlanks(doubleHalfStoneID - 256, newHalfStone, newDoubleHalfStone, true)).setUnlocalizedName("half block");
	        newStoneStairs1 = (new BlockNewStairs(newStairsIdIndex + 15, newStones, 5)).setUnlocalizedName("stairsStone1").setCreativeTab(this.tabFN);	        
	        newStoneStairs2 = (new BlockNewStairs(newStairsIdIndex + 16, newStones, 6)).setUnlocalizedName("stairsStone2").setCreativeTab(this.tabFN);
	        newStoneStairs3 = (new BlockNewStairs(newStairsIdIndex + 17, newStones, 7)).setUnlocalizedName("stairsStone3").setCreativeTab(this.tabFN);
	        newStoneStairs4 = (new BlockNewStairs(newStairsIdIndex + 18, newStones, 8)).setUnlocalizedName("stairsStone4").setCreativeTab(this.tabFN);
        }
        
		Item.itemsList[torchID] = (new ItemTorch(torchID - 256).setUnlocalizedName("cTorch"));
		Item.itemsList[groundID] = (new ItemGeneral(groundID - 256).setUnlocalizedName("cground"));
		for(int add = 0; add < 19; add++)
		{
			if(add < 15)
				Item.itemsList[newStairsIdIndex + add] = (new ItemGeneral(newStairsIdIndex - 256 + add).setUnlocalizedName("newStairs" + add));
			if(add > 14 && stone) 
				Item.itemsList[newStairsIdIndex + add] = (new ItemGeneral(newStairsIdIndex - 256 + add).setUnlocalizedName("newStairs" + add));
		}
		Item.itemsList[mushroomBlockID] = (new ItemGeneral(mushroomBlockID - 256).setUnlocalizedName("cMBlock"));
		Item.itemsList[mushroomPlantID] = (new ItemGeneral(mushroomPlantID - 256).setUnlocalizedName("cMushroom"));
		Item.itemsList[newGlassID] = (new ItemNewGlass(newGlassID - 256));
		for(int add = 0; add < 8; add++)
		{
			Item.itemsList[leafIDindex + add] = (new ItemNewLeaves(leafIDindex - 256 + add));
		}
        Item.itemsList[sapIDindex] = (new ItemNewSap(sapIDindex - 256));
        Item.itemsList[sapIDindex+1] = (new ItemNewSap2(sapIDindex - 255));
        Item.itemsList[sapIDindex+2] = (new ItemNewSap3(sapIDindex - 254));
        Item.itemsList[logIDindex] = (new ItemNewLogs(logIDindex - 256));
        Item.itemsList[logIDindex+1] = (new ItemNewLogs2(logIDindex - 255));
        Item.itemsList[logIDindex+2] = (new ItemNewLogs3(logIDindex - 254));
        Item.itemsList[logIDindex+3] = (new ItemNewLogs4(logIDindex - 253));
        Item.itemsList[logIDindex+4] = (new ItemNetherLogs(logIDindex - 252));
        Item.itemsList[newFlowerID] = (new ItemNewFlowers(newFlowerID - 256));
        Item.itemsList[plankID] = (new ItemNewPlanks(plankID - 256));
        Item.itemsList[plankID2] = (new ItemNewPlanks2(plankID2 - 256));
        
        Item.itemsList[halfPlankID] = (new ItemNewHalfPlanks(halfPlankID - 256, newHalfPlanks, newDoubleHalfPlanks, false)).setUnlocalizedName("half plank");
        Item.itemsList[doubleHalfPlankID] = (new ItemNewHalfPlanks(doubleHalfPlankID - 256, newHalfPlanks, newDoubleHalfPlanks, true)).setUnlocalizedName("half plank");
        Item.itemsList[halfPlankID2] = (new ItemNewHalfPlanks(halfPlankID2 - 256, newHalfPlanks2, newDoubleHalfPlanks2, false)).setUnlocalizedName("half plank");
        Item.itemsList[doubleHalfPlankID2] = (new ItemNewHalfPlanks(doubleHalfPlankID2 - 256, newHalfPlanks2, newDoubleHalfPlanks2, true)).setUnlocalizedName("half plank");
        Item.itemsList[crystalStoneID] = (new ItemCrystalStone(crystalStoneID-256)).setUnlocalizedName("CrystalStone");
        Item.itemsList[blockCrystalID] = (new ItemCrystalBlock(blockCrystalID-256)).setUnlocalizedName("CrystalBlock");
        Item.itemsList[crystalWoodID] = (new ItemCrystalWood(crystalWoodID-256)).setUnlocalizedName("Crystalwood");
        Item.itemsList[fenceID] = (new ItemNewFence(fenceID-256, fenceID)).setUnlocalizedName("Fence").setCreativeTab(this.tabFN);
        Item.itemsList[ropeID] = (new ItemRope(ropeID-256)).setUnlocalizedName("Rope").setCreativeTab(this.tabFN);
        Item.itemsList[hempCottonBambooCornID] = (new ItemBamboo(hempCottonBambooCornID-256)).setUnlocalizedName("Bamboo");
		
        Item.itemsList[ItemFruitID] = (new ItemFruit(ItemFruitID-256)).setCreativeTab(this.tabFN);
        Item.itemsList[ItemNewFoodID] = (new ItemNewFood(ItemNewFoodID-256)).setCreativeTab(this.tabFN);
        Item.itemsList[ItemNewFoodID2] = (new ItemNewFood2(ItemNewFoodID2-256)).setContainerItem(Item.bowlEmpty).setCreativeTab(this.tabFN);
        Item.itemsList[ItemNewFoodID3] = (new ItemNewFood3(ItemNewFoodID3-256)).setContainerItem(Item.itemsList[ItemNewCupID]).setCreativeTab(this.tabFN);
        Item.itemsList[ItemNewCupID] = (new ItemNewCup(ItemNewCupID-256)).setCreativeTab(this.tabFN);
        Item.itemsList[ItemNutID] = (new ItemNut(ItemNutID-256)).setCreativeTab(this.tabFN);
        Item.itemsList[ItemNewContainerID] = (new ItemNewContainer(ItemNewContainerID-256)).setContainerItem(Item.bucketEmpty).setCreativeTab(this.tabFN);
        
        Item.itemsList[crystalToolIndex] = (new ItemNewPA(crystalToolIndex-256,crystal)).setCreativeTab(this.tabFN);
        Item.itemsList[crystalToolIndex + 1] = (new ItemNewAxe(crystalToolIndex-255,crystal)).setCreativeTab(this.tabFN);
        Item.itemsList[crystalToolIndex + 2] = (new ItemNewShovel(crystalToolIndex-254,crystal)).setCreativeTab(this.tabFN);
        Item.itemsList[crystalToolIndex + 3] = (new ItemNewSword(crystalToolIndex-253,crystal)).setCreativeTab(this.tabFN);
        Item.itemsList[crystalToolIndex + 4] = (new ItemNewHoe(crystalToolIndex-252,crystal)).setCreativeTab(this.tabFN);
        Item.itemsList[crystalToolIndex + 5] = (new ItemNewPA(crystalToolIndex-251,darkCrystal)).setCreativeTab(this.tabFN);
        Item.itemsList[crystalToolIndex + 6] = (new ItemNewAxe(crystalToolIndex-250,darkCrystal)).setCreativeTab(this.tabFN);
        Item.itemsList[crystalToolIndex + 7] = (new ItemNewHoe(crystalToolIndex-249,darkCrystal)).setCreativeTab(this.tabFN);
        Item.itemsList[crystalToolIndex + 8] = (new ItemNewShovel(crystalToolIndex-248,darkCrystal)).setCreativeTab(this.tabFN);
        Item.itemsList[crystalToolIndex + 9] = (new ItemNewSword(crystalToolIndex-247,darkCrystal)).setCreativeTab(this.tabFN);
        
        if(obsidianTools)
        {
        	helmetObsidian = (new ItemNewArmor(armorID, armorObsidian, FNClientProxy.armorObsidian, 0)).setUnlocalizedName("helmetObsidian").setCreativeTab(this.tabFN);
  	        plateObsidian = (new ItemNewArmor(armorID+1, armorObsidian, FNClientProxy.armorObsidian, 1)).setUnlocalizedName("chestPlateObsidian").setCreativeTab(this.tabFN);
  	        legsObsidian = (new ItemNewArmor(armorID+2, armorObsidian, FNClientProxy.armorObsidian, 2)).setUnlocalizedName("leggingsObsidian").setCreativeTab(this.tabFN);
  	        bootsObsidian = (new ItemNewArmor(armorID+3, armorObsidian, FNClientProxy.armorObsidian, 3)).setUnlocalizedName("bootsObsidian").setCreativeTab(this.tabFN);
  	        helmetTitanStone = (new ItemNewArmor(armorID+4, armorTitanStone, FNClientProxy.armorTitanStone, 0)).setUnlocalizedName("helmetTitanStone").setCreativeTab(this.tabFN);
	        plateTitanStone = (new ItemNewArmor(armorID+5, armorTitanStone, FNClientProxy.armorTitanStone, 1)).setUnlocalizedName("chestPlateTitanStone").setCreativeTab(this.tabFN);
	        legsTitanStone = (new ItemNewArmor(armorID+6, armorTitanStone, FNClientProxy.armorTitanStone, 2)).setUnlocalizedName("leggingsTitanStone").setCreativeTab(this.tabFN);
  	        bootsTitanStone = (new ItemNewArmor(armorID+7, armorTitanStone, FNClientProxy.armorTitanStone, 3)).setUnlocalizedName("bootsTitanStone").setCreativeTab(this.tabFN);
	        
	        Item.itemsList[newToolIndex] = (new ItemNewPA(newToolIndex-256,obsidian)).setCreativeTab(this.tabFN);
	        Item.itemsList[newToolIndex + 1] = (new ItemNewAxe(newToolIndex-255,obsidian)).setCreativeTab(this.tabFN);
	        Item.itemsList[newToolIndex + 2] = (new ItemNewHoe(newToolIndex-254,obsidian)).setCreativeTab(this.tabFN);
	        Item.itemsList[newToolIndex + 3] = (new ItemNewShovel(newToolIndex-253,obsidian)).setCreativeTab(this.tabFN);
	        Item.itemsList[newToolIndex + 4] = (new ItemNewSword(newToolIndex-252,obsidian)).setCreativeTab(this.tabFN);
	        Item.itemsList[newToolIndex + 5] = (new ItemTitanStonePA(newToolIndex-251,titanStone)).setCreativeTab(this.tabFN);
	        Item.itemsList[newToolIndex + 6] = (new ItemNewSword(newToolIndex-250,titanStone)).setCreativeTab(this.tabFN);
        }
        Item.itemsList[sawID] = (new ItemNewAxe(sawID-256,saw)).setCreativeTab(this.tabFN);
        
        Item.itemsList[crystalItemID] = (new ItemCrystal(crystalItemID-256)).setUnlocalizedName("Crystal").setCreativeTab(this.tabFN);
        Item.itemsList[sawItemID] = (new ItemSawItems(sawItemID-256)).setCreativeTab(this.tabFN);
        Item.itemsList[powderID] = (new ItemPowder(powderID - 256)).setCreativeTab(this.tabFN);
		Item.itemsList[newCropSeedsID] = (new ItemNewCropSeeds(newCropSeedsID-256, kCeleryOnionGarlicID, peanutTurnipGingerID, parsleyWChestnutRiceBroccoliID, hempCottonBambooCornID, grapeTomatoCabbagePineappleID, Block.tilledField.blockID)).setUnlocalizedName("NewSeeds").setCreativeTab(this.tabFN);
		Item.itemsList[newCropFoodID] = (new ItemNewCropFood(newCropFoodID-256, kCeleryOnionGarlicID, peanutTurnipGingerID, parsleyWChestnutRiceBroccoliID)).setUnlocalizedName("NewFood").setCreativeTab(this.tabFN);
		Item.itemsList[newCropGoodsID] = (new ItemNewCropGoods(newCropGoodsID-256)).setCreativeTab(this.tabFN);
		Item.itemsList[newFoodDishID] = (new ItemFoodDish(newFoodDishID-256)).setContainerItem(Item.bowlEmpty).setCreativeTab(this.tabFN);
        
		Item.itemsList[carbonItemsID] = (new ItemCarbon(carbonItemsID-256)).setCreativeTab(this.tabFN);
		
		proxy.registerRenderStuff();
        FNClientProxy.registerRenderStuff();
        FNClientProxy.newRecipes();

        GameRegistry.addSmelting(newLogs.blockID, new ItemStack(Item.coal,1,1), 1);
        GameRegistry.addSmelting(newLogs2.blockID, new ItemStack(Item.coal,1,1), 1);
        GameRegistry.addSmelting(newLogs3.blockID, new ItemStack(Item.coal,1,1), 1);
        
        neoTropicalForest = (new BiomeGenTropicalForest(tropicalID));
	    neoRedwoodForest = (new BiomeGenNeoRedwoodForest(redwoodID));
	    neoTropicalForestHills = (new BiomeGenNeoTropicalForestHills(tropicalHillsID));
	    neoRedwoodForestHills = (new BiomeGenNeoRedwoodForestHills(redwoodHillsID));
	    neoRedwoodForestSnowHills = (new BiomeGenNeoRedwoodForestSnowHills(redwoodSnowHillsID));
	    neoRedwoodForestSnow = (new BiomeGenNeoRedwoodForestSnow(redwoodSnowID));
	    crystalForest = (new BiomeGenCrystalForest(crystalForestID));
	    
	    if (tropicalForestc == true)
	    	GameRegistry.addBiome(neoTropicalForest);
	    else
	    	GameRegistry.removeBiome(neoTropicalForest);
	    if (redwoodForestc == true)
	    	GameRegistry.addBiome(neoRedwoodForest);
	    else
	    	GameRegistry.removeBiome(neoRedwoodForest);
	    if (tropicalForestHillsc == true)
	    	GameRegistry.addBiome(neoTropicalForestHills);
	    else
	    	GameRegistry.removeBiome(neoTropicalForestHills);
	    if (redwoodForestHillsc == true)
	    	GameRegistry.addBiome(neoRedwoodForestHills);
	    else
	    	GameRegistry.removeBiome(neoRedwoodForestHills);
	    if (redwoodForestHillsSnowc == true)
	    	GameRegistry.addBiome(neoRedwoodForestSnowHills);
	    else
	    	GameRegistry.removeBiome(neoRedwoodForestSnowHills);
	    if (redwoodForestSnowc == true)
	    	GameRegistry.addBiome(neoRedwoodForestSnow);
	    else
	    	GameRegistry.removeBiome(neoRedwoodForestSnow);
	    if (CrystalForest == true)
	    	GameRegistry.addBiome(crystalForest);
	    else
	    	GameRegistry.removeBiome(crystalForest);
        
        if (vanDesert == false)
			GameRegistry.removeBiome(BiomeGenBase.desert);
        if (vanExtremeHills == false)
			GameRegistry.removeBiome(BiomeGenBase.extremeHills);
        if (vanForest == false)
			GameRegistry.removeBiome(BiomeGenBase.forest);
        if (vanJungle == false)
			GameRegistry.removeBiome(BiomeGenBase.jungle);
        if (vanPlains == false)
			GameRegistry.removeBiome(BiomeGenBase.plains);
        if (vanSwampland == false)
			GameRegistry.removeBiome(BiomeGenBase.swampland);
        if (vanTaiga == false)
			GameRegistry.removeBiome(BiomeGenBase.taiga);
        
      //add seeds to tall grass
		for(int x = 0; x < 11; x++)
		{
			MinecraftForge.addGrassSeed(new ItemStack(newCropSeedsID, 1, x), newSeedWeight);
		}
		MinecraftForge.addGrassSeed(new ItemStack(newCropFoodID, 1, 1), newSeedWeight);
		MinecraftForge.addGrassSeed(new ItemStack(newCropFoodID, 1, 2), newSeedWeight);
		MinecraftForge.addGrassSeed(new ItemStack(newCropFoodID, 1, 4), newSeedWeight);
		MinecraftForge.addGrassSeed(new ItemStack(newCropFoodID, 1, 5), newSeedWeight);
		MinecraftForge.addGrassSeed(new ItemStack(newCropFoodID, 1, 6), newSeedWeight);
		MinecraftForge.addGrassSeed(new ItemStack(newCropFoodID, 1, 9), newSeedWeight);
		
		{//ore dictionary
			OreDictionary.registerOre("plankWood", newPlanks);
			OreDictionary.registerOre("plankWood", newPlanks2);
			OreDictionary.registerOre("logWood", newLogs);
			OreDictionary.registerOre("logWood", newLogs2);
			OreDictionary.registerOre("logWood", newLogs3);
			OreDictionary.registerOre("logWood", newLogs4);
			OreDictionary.registerOre("logWood", netherLogs);
		}
    }
    
    public static CreativeTabs tabFN = new CreativeTabs("tabFN") {
        public ItemStack getIconItemStack() {
                return new ItemStack(Item.itemsList[sapIDindex], 1, 8);
        }
    };
    
    public static void addVillages()
    {
    	enableVillageSpawnBiomeChanges();
        MapGenVillage.villageSpawnBiomes.add(neoTropicalForest);
        MapGenVillage.villageSpawnBiomes.add(neoTropicalForestHills);
        MapGenVillage.villageSpawnBiomes.add(neoRedwoodForestHills);
        MapGenVillage.villageSpawnBiomes.add(neoRedwoodForest);
        MapGenVillage.villageSpawnBiomes.add(neoRedwoodForestSnowHills);
        MapGenVillage.villageSpawnBiomes.add(neoRedwoodForestSnow);
        MapGenVillage.villageSpawnBiomes.add(crystalForest);
    }
    
    private static void enableVillageSpawnBiomeChanges() 
    {
		final List<BiomeGenBase> villageSpawnBiomes = new ArrayList();
		villageSpawnBiomes.addAll(MapGenVillage.villageSpawnBiomes);
		// get MapGenVillageSpawnBiomes.villageSpawnBiomes field
		Field field = MapGenVillage.class.getDeclaredFields()[0];
		field.setAccessible(true);
		// Make the field non final and set it
		try {
			Field modifiersField = Field.class.getDeclaredField("modifiers");
			modifiersField.setAccessible(true);
			modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

			field.set(null, villageSpawnBiomes);
		} catch (Exception e) {
			FMLLog.log(Level.SEVERE, e, "Could not access village spawn biomes.", new Object[1]);;
		}
	}
    
    @PreInit
	public void preInit(FMLPreInitializationEvent event)
	  {
    	Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
        try 
        {
        cfg.load();
        
        kCeleryOnionGarlicID = cfg.get(Configuration.CATEGORY_BLOCK, "CeleryOnionGarlicID", 162).getInt();
		peanutTurnipGingerID = cfg.get(Configuration.CATEGORY_BLOCK, "PeanutTurnipGingerID", 163).getInt();
		parsleyWChestnutRiceBroccoliID = cfg.get(Configuration.CATEGORY_BLOCK, "ParsleyWChestnutRiceBroccoliID", 164).getInt();
		hempCottonBambooCornID = cfg.get(Configuration.CATEGORY_BLOCK, "HempCottonBambooCornID", 165).getInt();
		grapeTomatoCabbagePineappleID = cfg.get(Configuration.CATEGORY_BLOCK, "GrapeTomatoCabbagePineappleID", 166).getInt();
		
        torchID = cfg.get(Configuration.CATEGORY_BLOCK, "torchID", 175).getInt();
		ropeID = cfg.get(Configuration.CATEGORY_BLOCK, "ropeID", 176).getInt();
        halfPlankID = cfg.get(Configuration.CATEGORY_BLOCK, "New Half Planks ID", 177).getInt();
        doubleHalfPlankID = cfg.get(Configuration.CATEGORY_BLOCK, "New DoubleHalf Planks ID", 178).getInt();
        halfPlankID2 = cfg.get(Configuration.CATEGORY_BLOCK, "New Half Planks ID2", 179).getInt();
        doubleHalfPlankID2 = cfg.get(Configuration.CATEGORY_BLOCK, "New DoubleHalf Planks ID2", 180).getInt();
        mushroomBlockID = cfg.get(Configuration.CATEGORY_BLOCK, "Crystal Mushroom ID", 181).getInt();
        mushroomPlantID = cfg.get(Configuration.CATEGORY_BLOCK, "Crystal MushroomBlock ID", 182).getInt();
        fenceID = cfg.get(Configuration.CATEGORY_BLOCK, "fenceID", 183).getInt();
        newGlassID = cfg.get(Configuration.CATEGORY_BLOCK, "New Glass ID", 184).getInt();
        newStonesID = cfg.get(Configuration.CATEGORY_BLOCK, "New Stones ID", 185).getInt();
        halfStoneID = cfg.get(Configuration.CATEGORY_BLOCK, "New Half StoneID", 186).getInt();
        doubleHalfStoneID = cfg.get(Configuration.CATEGORY_BLOCK, "New DoubleHalf StoneID", 187).getInt();
        flowerPotID = cfg.get(Configuration.CATEGORY_BLOCK, "New Flower Pot ID", 188).getInt();
        flowerPotID2 = cfg.get(Configuration.CATEGORY_BLOCK, "New Flower Pot ID2", 189).getInt();
        flowerPotID3 = cfg.get(Configuration.CATEGORY_BLOCK, "New Flower Pot ID3", 190).getInt();
        flowerPotID4 = cfg.get(Configuration.CATEGORY_BLOCK, "New Flower Pot ID4", 191).getInt();
        
        //stair id index
        Property stairs = cfg.get(Configuration.CATEGORY_BLOCK, "New Stair Index", 200);
        stairs.comment = "This Stair ID is the zero index for 19 stair IDs. 0-18";
        newStairsIdIndex = stairs.getInt(200);
		
		groundID = cfg.get(Configuration.CATEGORY_BLOCK, "groundID", 4071).getInt();
        crystalWoodID = cfg.get(Configuration.CATEGORY_BLOCK, "crystalWoodID", 4072).getInt();
        crystalStoneID = cfg.get(Configuration.CATEGORY_BLOCK, "crystalStoneID", 4073).getInt();
        blockCrystalID = cfg.get(Configuration.CATEGORY_BLOCK, "crystalBlockID", 4074).getInt();
        
        fruitID = cfg.get(Configuration.CATEGORY_BLOCK, "fruitID", 4075).getInt();
        plankID = cfg.get(Configuration.CATEGORY_BLOCK, "plankID", 4076).getInt();
        plankID2 = cfg.get(Configuration.CATEGORY_BLOCK, "plankID2", 4078).getInt();
        
        logIDindex = cfg.get(Configuration.CATEGORY_BLOCK, "logIDindex", 4079).getInt();//index for 5IDs (0-4)
        leafIDindex = cfg.get(Configuration.CATEGORY_BLOCK, "leafIDindex", 4084).getInt();//Index for 8IDs (0-7)
        newFlowerID = cfg.get(Configuration.CATEGORY_BLOCK, "FlowerID", 4092).getInt();
        sapIDindex = cfg.get(Configuration.CATEGORY_BLOCK, "sapIDindex", 4093).getInt();//index for 3IDs (0-2)
        
        
        /////////////////////////////////////////////////////////////////////////////////////////////////////
        //whether bamboo will generate and spread or not.
        bambooGeneration = cfg.get(Configuration.CATEGORY_GENERAL, "Bamboo Generation", true).getBoolean(true);
        bambooSpread = cfg.get(Configuration.CATEGORY_GENERAL, "Bamboo Spread", true).getBoolean(true);
        //bamboo spread
		Property bamSpreadb = cfg.get(Configuration.CATEGORY_GENERAL, "Bamboo Spread Buffer", 200);
		bamSpreadb.comment = "BAMBOO SPREAD BUFFER (below) sets the spread mitigation for bamboo. The higher it is set, the slower it spreads.";
		bamSpreadBuffer = bamSpreadb.getInt(200);
		if(bamSpreadBuffer < 1)
			bamSpreadBuffer = 1;
		//seed drop chance
		Property seedDrop = cfg.get(Configuration.CATEGORY_GENERAL, "Crop Seeds Drop Weight", 10);
		seedDrop.comment = "CROP SEEDS DROP WEIGHT (below) is the chance in which new seeds will drop from tall grass. Setting it to zero will DISABLE all new seed drops. " +
				"10 sets the drop chance equal to wheat seeds. Higher numbers will make the new seeds more common than wheat seeds.";
        newSeedWeight = seedDrop.getInt(10);
        
        ItemFruitID = cfg.get(Configuration.CATEGORY_ITEM, "ItemFruitID", 20000).getInt();
        ItemNutID = cfg.get(Configuration.CATEGORY_ITEM, "ItemNutID", 20001).getInt();
        ItemNewFoodID = cfg.get(Configuration.CATEGORY_ITEM, "ItemNewFoodID", 20002).getInt();
        ItemNewContainerID = cfg.get(Configuration.CATEGORY_ITEM, "ItemNewContainerID", 20003).getInt();
        crystalToolIndex = cfg.get(Configuration.CATEGORY_ITEM, "Crystal Tool Index 0-9", 20004).getInt();
        crystalItemID = cfg.get(Configuration.CATEGORY_ITEM, "crystalItemID", 20014).getInt();
        sawID = cfg.get(Configuration.CATEGORY_ITEM, "SawID", 20015).getInt();
        sawItemID = cfg.get(Configuration.CATEGORY_ITEM, "Saw Items ID", 20016).getInt();
        ItemNewFoodID2 = cfg.get(Configuration.CATEGORY_ITEM, "ItemNewFoodID2", 20018).getInt();
        ItemNewFoodID3 = cfg.get(Configuration.CATEGORY_ITEM, "ItemNewFoodID3", 20019).getInt();
        ItemNewCupID = cfg.get(Configuration.CATEGORY_ITEM, "ItemNewCupID", 20020).getInt();
        powderID = cfg.get(Configuration.CATEGORY_ITEM, "ItemPowderID", 20021).getInt();
		newCropSeedsID = cfg.get(Configuration.CATEGORY_ITEM, "NewCropSeedsID", 20022).getInt();
		newCropFoodID = cfg.get(Configuration.CATEGORY_ITEM, "NewCropFoodID", 20023).getInt();
		newCropGoodsID = cfg.get(Configuration.CATEGORY_ITEM, "NewCropGoodsID", 20024).getInt();
		newFoodDishID = cfg.get(Configuration.CATEGORY_ITEM, "FoodDishID", 20025).getInt();
		carbonItemsID = cfg.get(Configuration.CATEGORY_ITEM, "CarbonItemsID", 20026).getInt();
        newToolIndex = cfg.get(Configuration.CATEGORY_ITEM, "New Tool Index 0-6", 20027).getInt();
        armorID = cfg.get(Configuration.CATEGORY_ITEM, "Armor Index 0-7", 20034).getInt();
        
        //biome ids
        tropicalID = cfg.get(Configuration.CATEGORY_GENERAL, "Biomes: Neo Tropical Forest ID", 70).getInt();
        redwoodID = cfg.get(Configuration.CATEGORY_GENERAL, "Biomes: Neo Redwood Forest ID", 71).getInt();
        tropicalHillsID = cfg.get(Configuration.CATEGORY_GENERAL, "Biomes: Neo Tropical Forest Hills ID", 72).getInt();
        redwoodHillsID = cfg.get(Configuration.CATEGORY_GENERAL, "Biomes: Neo Redwood Forest Hills ID", 73).getInt();
        redwoodSnowHillsID = cfg.get(Configuration.CATEGORY_GENERAL, "Biomes: Neo Redwood Forest Snow Hills ID", 74).getInt();
        redwoodSnowID = cfg.get(Configuration.CATEGORY_GENERAL, "Biomes: Neo Redwood Forest Snow ID", 75).getInt();
        crystalForestID = cfg.get(Configuration.CATEGORY_GENERAL, "Biomes: Crystal Forest ID", 76).getInt();
        
        extraAxe1ID = cfg.get(Configuration.CATEGORY_ITEM, "extraAxe1ID", 0).getInt();
        if(extraAxe1ID == 0)
        	extraAxe1ID = crystalToolIndex + 6;
        extraAxe2ID = cfg.get(Configuration.CATEGORY_ITEM, "extraAxe2ID", 0).getInt();
        if(extraAxe2ID == 0)
        	extraAxe2ID = crystalToolIndex + 6;
        extraAxe3ID = cfg.get(Configuration.CATEGORY_ITEM, "extraAxe3ID", 0).getInt();
        if(extraAxe3ID == 0)
        	extraAxe3ID = crystalToolIndex + 6;
        extraAxe4ID = cfg.get(Configuration.CATEGORY_ITEM, "extraAxe4ID", 0).getInt();
        if(extraAxe4ID == 0)
        	extraAxe4ID = crystalToolIndex + 6;

        crystalTools = cfg.get(Configuration.CATEGORY_GENERAL, "Crafting: Crystal Tools", true).getBoolean(true);
        obsidianTools = cfg.get(Configuration.CATEGORY_GENERAL, "Crafting: Obsidian Tools and Armor", true).getBoolean(true);
        lumberjack = cfg.get(Configuration.CATEGORY_GENERAL, "Lumberjack", true).getBoolean(true);
        lumberjackDamage = cfg.get(Configuration.CATEGORY_GENERAL, "Lumberjack Extra damage to Axe", true).getBoolean(true);
        lumberjackPower = cfg.get(Configuration.CATEGORY_GENERAL, "Lumberjack Power", 1600).getInt();
        Fig = cfg.get(Configuration.CATEGORY_GENERAL, "Trees: Fig", true).getBoolean(true);
        Apple = cfg.get(Configuration.CATEGORY_GENERAL, "Trees: Apple", true).getBoolean(true);
        Cherry = cfg.get(Configuration.CATEGORY_GENERAL, "Trees: Cherry", true).getBoolean(true);
        Acacia = cfg.get(Configuration.CATEGORY_GENERAL, "Trees: Acacia", true).getBoolean(true);
        Joshua = cfg.get(Configuration.CATEGORY_GENERAL, "Trees: Joshua", true).getBoolean(true);
        Willow = cfg.get(Configuration.CATEGORY_GENERAL, "Trees: Willow", true).getBoolean(true);
        Cypress = cfg.get(Configuration.CATEGORY_GENERAL, "Trees: Cypress", true).getBoolean(true);
        Sequoia = cfg.get(Configuration.CATEGORY_GENERAL, "Trees: Sequoia", true).getBoolean(true);
        RedMaple = cfg.get(Configuration.CATEGORY_GENERAL, "Trees: Red Maple", true).getBoolean(true);
        AngelOak = cfg.get(Configuration.CATEGORY_GENERAL, "Trees: Angel Oak", true).getBoolean(true);
        Jacaranda = cfg.get(Configuration.CATEGORY_GENERAL, "Trees: Jacaranda", true).getBoolean(true);
        leafDecay = cfg.get(Configuration.CATEGORY_GENERAL, "Trees: Leaf Decay", true).getBoolean(true);
        Eucalyptus = cfg.get(Configuration.CATEGORY_GENERAL, "Trees: Eucalyptus", true).getBoolean(true);
        YellowMaple = cfg.get(Configuration.CATEGORY_GENERAL, "Trees: Yellow Maple", true).getBoolean(true);
        DesertIronwood = cfg.get(Configuration.CATEGORY_GENERAL, "Trees: Desert Ironwood", true).getBoolean(true);
        decBush = cfg.get(Configuration.CATEGORY_GENERAL, "Bushes: Deciduous Bush", true).getBoolean(true);
        everBush = cfg.get(Configuration.CATEGORY_GENERAL, "Bushes: Evergreen Bush", true).getBoolean(true);
        palm = cfg.get(Configuration.CATEGORY_GENERAL, "Trees: Palm", true).getBoolean(true);
        dWillow = cfg.get(Configuration.CATEGORY_GENERAL, "Trees: Desert Willow", true).getBoolean(true);
        cedar = cfg.get(Configuration.CATEGORY_GENERAL, "Trees: Cedar", true).getBoolean(true);
        ginkgo = cfg.get(Configuration.CATEGORY_GENERAL, "Trees: Ginkgo", true).getBoolean(true);
        poplar = cfg.get(Configuration.CATEGORY_GENERAL, "Trees: Poplar", true).getBoolean(true);
        beech = cfg.get(Configuration.CATEGORY_GENERAL, "Trees: Beech", true).getBoolean(true);
        walnut = cfg.get(Configuration.CATEGORY_GENERAL, "Trees: Walnut", true).getBoolean(true);
        wTopEucalyptus = cfg.get(Configuration.CATEGORY_GENERAL, "Trees: WideTop Eucalyptus", true).getBoolean(true);
        bukkit = cfg.get(Configuration.CATEGORY_GENERAL, "Trees: Bukkit Tree", true).getBoolean(true);
        banana = cfg.get(Configuration.CATEGORY_GENERAL, "Trees: Banana", true).getBoolean(true);
        orange = cfg.get(Configuration.CATEGORY_GENERAL, "Trees: Orange", true).getBoolean(true);
        peach = cfg.get(Configuration.CATEGORY_GENERAL, "Trees: Peach", true).getBoolean(true);
        lemon = cfg.get(Configuration.CATEGORY_GENERAL, "Trees: Lemon", true).getBoolean(true);
        blueberry = cfg.get(Configuration.CATEGORY_GENERAL, "Bushes: Blueberry Bush", true).getBoolean(true);
        raspberry = cfg.get(Configuration.CATEGORY_GENERAL, "Bushes: Raspberry Bush", true).getBoolean(true);
        blackberry = cfg.get(Configuration.CATEGORY_GENERAL, "Bushes: Blackberry Bush", true).getBoolean(true);
        huckleberry = cfg.get(Configuration.CATEGORY_GENERAL, "Bushes: Huckleberry Bush", true).getBoolean(true);
        redwoodForestc = cfg.get(Configuration.CATEGORY_GENERAL, "Biomes: Redwood Forest", true).getBoolean(true);
        tropicalForestc = cfg.get(Configuration.CATEGORY_GENERAL, "Biomes: Tropical Forest", true).getBoolean(true);
        tropicalForestHillsc = cfg.get(Configuration.CATEGORY_GENERAL, "Biomes: Tropical Forest Hills", true).getBoolean(true);
        redwoodForestHillsc = cfg.get(Configuration.CATEGORY_GENERAL, "Biomes: Redwood Forest Hills", true).getBoolean(true);
        redwoodForestHillsSnowc = cfg.get(Configuration.CATEGORY_GENERAL, "Biomes: Redwood Forest Snow Hills", true).getBoolean(true);
        redwoodForestSnowc = cfg.get(Configuration.CATEGORY_GENERAL, "Biomes: Redwood Forest Snow", true).getBoolean(true);
        CrystalForest = cfg.get(Configuration.CATEGORY_GENERAL, "Biomes: Crystal Forest", true).getBoolean(true);
        crystalMushrooms = cfg.get(Configuration.CATEGORY_GENERAL, "Crystal Mushrooms", true).getBoolean(true);
        
        vanDesert = cfg.get(Configuration.CATEGORY_GENERAL, "Biomes: Vanilla Desert", true).getBoolean(true);
        vanExtremeHills = cfg.get(Configuration.CATEGORY_GENERAL, "Biomes: Vanilla Extreme Hills", true).getBoolean(true);
        vanForest = cfg.get(Configuration.CATEGORY_GENERAL, "Biomes: Vanilla Forest", true).getBoolean(true);
        vanJungle = cfg.get(Configuration.CATEGORY_GENERAL, "Biomes: Vanilla Jungle", true).getBoolean(true);
        vanPlains = cfg.get(Configuration.CATEGORY_GENERAL, "Biomes: Vanilla Plains", true).getBoolean(true);
        vanSwampland = cfg.get(Configuration.CATEGORY_GENERAL, "Biomes: Vanilla Swampland", true).getBoolean(true);
        vanTaiga = cfg.get(Configuration.CATEGORY_GENERAL, "Biomes: Vanilla Taiga", true).getBoolean(true);
        
        figFruit = cfg.get(Configuration.CATEGORY_GENERAL, "Fig Fruit", true).getBoolean(true);
        StoneGranite = cfg.get(Configuration.CATEGORY_GENERAL, "Stone: Granite Generation", true).getBoolean(true);
        StoneChert = cfg.get(Configuration.CATEGORY_GENERAL, "Stone: Chert Generation", true).getBoolean(true);
        StoneMarble = cfg.get(Configuration.CATEGORY_GENERAL, "Stone: Marble Generation", true).getBoolean(true);
        StoneHornfels = cfg.get(Configuration.CATEGORY_GENERAL, "Stone: Hornfels Generation", true).getBoolean(true);
        StoneGneiss = cfg.get(Configuration.CATEGORY_GENERAL, "Stone: Gneiss Generation", true).getBoolean(true);
        if(!StoneGranite && !StoneChert && !StoneHornfels && !StoneMarble && !StoneGneiss)
        	stone = false;
        
        craftGunpowder = cfg.get(Configuration.CATEGORY_GENERAL, "Crafting: Gunpowder", true).getBoolean(true);
        newTreePerChunkCount = cfg.get(Configuration.CATEGORY_GENERAL, "New Trees Per Chunk", 3).getInt();
        FNLogRenderID = cfg.get(Configuration.CATEGORY_GENERAL, "LogRenderID", 50).getInt();
        FNFlowerPotRenderID = cfg.get(Configuration.CATEGORY_GENERAL, "FlowerPotRenderID", 51).getInt();
        newLeafDecayBuffer = cfg.get(Configuration.CATEGORY_GENERAL, "New Leaf Decay Buffer", 2).getInt();
        carbonItems = cfg.get(Configuration.CATEGORY_GENERAL, "Carbon Item Recipes", true).getBoolean(true);

		Property flowerGroups = cfg.get(Configuration.CATEGORY_GENERAL, "FN flower generation", 8);
		flowerGroups.comment = "This determines how many times a group of FN flowers will try to generate for every 10 chunks. Default value is 8";
        flowerGen = flowerGroups.getInt(8);
        } 
    	catch (Exception err) 
	    {FMLLog.log(Level.SEVERE, err, "Forgotten Nature has a problem loading configuration", new Object[0]);} 
    	finally 
    	{cfg.save();}
    }
}