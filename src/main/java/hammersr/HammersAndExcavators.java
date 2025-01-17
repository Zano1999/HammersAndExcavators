package hammersr;

import hammersr.Items.ExcavatorItem;
import hammersr.Items.HammerItem;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.material.ToolMaterial;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.*;
import turniplabs.halplibe.util.GameStartEntrypoint;
import turniplabs.halplibe.util.RecipeEntrypoint;


public class HammersAndExcavators implements ModInitializer, GameStartEntrypoint, RecipeEntrypoint {
    public static final String MOD_ID = "hammersr";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static BlockBuilder standardBlockBuilder = new BlockBuilder(MOD_ID);
	public static Item hammerWooden;
	public static Item hammerStone;
	public static Item hammerIron;
	public static Item hammerGold;
	public static Item hammerSteel;
	public static Item hammerDiamond;
	public static Item excavatorWooden;
	public static Item excavatorStone;
	public static Item excavatorIron;
	public static Item excavatorGold;
	public static Item excavatorSteel;
	public static Item excavatorDiamond;
	public static Block diamondSteelBlock;
	public static Block HardenedCobble;
	public static Block HardenedLog;
	//public static Item diamondSteelBlock;

	//private HammersAndExcavators() {}
	@Override
	public void initNamespaces() {
		RecipeBuilder.initNameSpace(MOD_ID);
	}

	@Override
    public void onInitialize() {
        LOGGER.info("HammersAndExcavators initialized.");
    }

	@Override
	public void beforeGameStart() {

		hammerWooden = ItemHelper.createItem(MOD_ID,new HammerItem("WoodenHammer",32006, ToolMaterial.wood),"wooden_hammer.png");
		hammerStone = ItemHelper.createItem(MOD_ID,new HammerItem("StoneHammer",32007, ToolMaterial.stone),"stone_hammer.png");
		hammerIron = ItemHelper.createItem(MOD_ID,new HammerItem("IronHammer",32008, ToolMaterial.iron),"iron_hammer.png");
		hammerGold = ItemHelper.createItem(MOD_ID,new HammerItem("GoldHammer",32009, ToolMaterial.gold),"golden_hammer.png");
		hammerSteel = ItemHelper.createItem(MOD_ID,new HammerItem("SteelHammer",32010, ToolMaterial.steel),"steel_hammer.png");
		hammerDiamond = ItemHelper.createItem(MOD_ID,new HammerItem("DiamondHammer",32011, ToolMaterial.diamond),"diamond_hammer.png");

		excavatorWooden = ItemHelper.createItem(MOD_ID,new ExcavatorItem("WoodenExcavator",32012, ToolMaterial.wood),"wooden_excavator.png");
		excavatorStone = ItemHelper.createItem(MOD_ID,new ExcavatorItem("StoneExcavator",32013, ToolMaterial.stone),"stone_excavator.png");
		excavatorIron = ItemHelper.createItem(MOD_ID,new ExcavatorItem("IronExcavator",32014, ToolMaterial.iron),"iron_excavator.png");
		excavatorGold = ItemHelper.createItem(MOD_ID,new ExcavatorItem("GoldExcavator",32015, ToolMaterial.gold),"golden_excavator.png");
		excavatorSteel = ItemHelper.createItem(MOD_ID,new ExcavatorItem("SteelExcavator",32016, ToolMaterial.steel),"steel_excavator.png");
		excavatorDiamond = ItemHelper.createItem(MOD_ID,new ExcavatorItem("DiamondExcavator",32017, ToolMaterial.diamond),"diamond_excavator.png");
		diamondSteelBlock = standardBlockBuilder.setTextures("diamondSteelBlock.png").build(new Block("diamondSteelBlock",3100, Material.metal));
		HardenedCobble = standardBlockBuilder.setTextures("HardenedCobbleStone.png").build(new Block("HardenedCobble",3101, Material.stone));
		HardenedLog = standardBlockBuilder.setSideTextures("HardenedLogSides.png").setTopBottomTexture("HardenedLogTopBottom.png").build(new Block("HardenedLog",3102, Material.woodWet));


	}

	@Override
	public void afterGameStart() {

	}

	@Override
	public void onRecipesReady() {
		//Blocks
		RecipeBuilder.Shaped(MOD_ID).setShape("BIB", "IOI", "BIB").addInput('B',Item.diamond).addInput('O',Block.blockSteel).addInput('I',Item.ingotSteel).create("DiamondSteelBlock",new ItemStack(diamondSteelBlock, 1));
		RecipeBuilder.Shaped(MOD_ID).setShape("LPL", "PCP", "LPL").addInput('L',Block.logOak).addInput('C',Item.coal).addInput('P',Block.planksOak).create("HardenedLog",new ItemStack(HardenedLog, 1));
		RecipeBuilder.Shaped(MOD_ID).setShape("SCS", "CSC", "SCS").addInput('S',Block.stonePolished).addInput('C',Block.cobbleStone).create("HardenedCobble",new ItemStack(HardenedCobble, 1));
		//Hammers
		RecipeBuilder.Shaped(MOD_ID).setShape("BOB", "OSO", " S ").addInput('B',HardenedLog).addInput('O', Block.planksOak).addInput('S',Item.stick).create("WoodenHammer", new ItemStack(hammerWooden, 1));
		RecipeBuilder.Shaped(MOD_ID).setShape("BOB", "OSO", " S ").addInput('B',HardenedLog).addInput('O', Block.planksOakPainted.withDisabledNeighborNotifyOnMetadataChange()).addInput('S',Item.stick).create("PWoodenHammer", new ItemStack(hammerWooden, 1));
		RecipeBuilder.Shaped(MOD_ID).setShape("BOB", "OSO", " S ").addInput('B',HardenedCobble).addInput('O', Block.stone).addInput('S',Item.stick).create("StoneHammer", new ItemStack(hammerStone, 1));
		RecipeBuilder.Shaped(MOD_ID).setShape("BOB", "OSO", " S ").addInput('B',Block.blockIron).addInput('O', Item.ingotIron).addInput('S',Item.stick).create("IronHammer", new ItemStack(hammerIron, 1));
		RecipeBuilder.Shaped(MOD_ID).setShape("BOB", "OSO", " S ").addInput('B',Block.blockGold).addInput('O', Item.ingotGold).addInput('S',Item.stick).create("GoldHammer", new ItemStack(hammerGold, 1));
		RecipeBuilder.Shaped(MOD_ID).setShape("BOB", "OSO", " S ").addInput('B',Block.blockSteel).addInput('O', Item.ingotSteel).addInput('S',Item.stick).create("SteelHammer", new ItemStack(hammerSteel, 1));
		RecipeBuilder.Shaped(MOD_ID).setShape("BOB", "OSO", " S ").addInput('B',diamondSteelBlock).addInput('O', Item.diamond).addInput('S',Item.stick).create("DiamondHammer", new ItemStack(hammerDiamond, 1));
		//excavators
		RecipeBuilder.Shaped(MOD_ID).setShape(" O ", "BSB", " S ").addInput('B',HardenedLog).addInput('O', Block.planksOak).addInput('S',Item.stick).create("WoodenHammer", new ItemStack(excavatorWooden, 1));
		RecipeBuilder.Shaped(MOD_ID).setShape(" O ", "BSB", " S ").addInput('B',HardenedLog).addInput('O', Block.planksOakPainted).addInput('S',Item.stick).create("PWoodenHammer", new ItemStack(excavatorWooden, 1));
		RecipeBuilder.Shaped(MOD_ID).setShape(" O ", "BSB", " S ").addInput('B',HardenedCobble).addInput('O', Block.cobbleStone).addInput('S',Item.stick).create("StoneHammer", new ItemStack(excavatorStone, 1));
		RecipeBuilder.Shaped(MOD_ID).setShape(" O ", "BSB", " S ").addInput('B',Block.blockIron).addInput('O', Item.ingotIron).addInput('S',Item.stick).create("IronHammer", new ItemStack(excavatorIron, 1));
		RecipeBuilder.Shaped(MOD_ID).setShape(" O ", "BSB", " S ").addInput('B',Block.blockGold).addInput('O', Item.ingotGold).addInput('S',Item.stick).create("GoldHammer", new ItemStack(excavatorGold, 1));
		RecipeBuilder.Shaped(MOD_ID).setShape(" O ", "BSB", " S ").addInput('B',Block.blockSteel).addInput('O', Item.ingotSteel).addInput('S',Item.stick).create("SteelHammer", new ItemStack(excavatorSteel, 1));
		RecipeBuilder.Shaped(MOD_ID).setShape(" O ", "BSB", " S ").addInput('B',diamondSteelBlock).addInput('O', Item.diamond).addInput('S',Item.stick).create("DiamondHammer", new ItemStack(excavatorDiamond, 1));

	}


}
