package moony.compactcrafting;

import java.util.logging.Level;

import moony.compactcrafting.blocks.BlockCompactCoalBlock;
import moony.compactcrafting.blocks.BlockCompactCobblestone;
import moony.compactcrafting.blocks.BlockCompactDirt;
import moony.compactcrafting.blocks.BlockCompactGlass;
import moony.compactcrafting.blocks.BlockCompactGravel;
import moony.compactcrafting.blocks.BlockCompactNetherrack;
import moony.compactcrafting.blocks.BlockCompactSand;
import moony.compactcrafting.blocks.BlockGlassBrickBlock;
import moony.compactcrafting.core.handler.CC_SoundHandler;
import moony.compactcrafting.core.handler.GuiHandler;
import moony.compactcrafting.core.proxys.CommonProxy;
import moony.compactcrafting.creativetabs.CompactTab;
import moony.compactcrafting.fuels.CompactFuel;
import moony.compactcrafting.items.ItemC1DiamondAxe;
import moony.compactcrafting.items.ItemC1DiamondPickaxe;
import moony.compactcrafting.items.ItemC1DiamondShovel;
import moony.compactcrafting.items.ItemC1GoldAxe;
import moony.compactcrafting.items.ItemC1GoldPickaxe;
import moony.compactcrafting.items.ItemC1GoldenShovel;
import moony.compactcrafting.items.ItemC1IronAxe;
import moony.compactcrafting.items.ItemC1IronPickaxe;
import moony.compactcrafting.items.ItemC1IronShovel;
import moony.compactcrafting.items.ItemC1StoneAxe;
import moony.compactcrafting.items.ItemC1StonePickaxe;
import moony.compactcrafting.items.ItemC1StoneShovel;
import moony.compactcrafting.items.ItemC1WoodenAxe;
import moony.compactcrafting.items.ItemC1WoodenPickaxe;
import moony.compactcrafting.items.ItemC1WoodenShovel;
import moony.compactcrafting.items.ItemC2DiamondAxe;
import moony.compactcrafting.items.ItemC2DiamondPickaxe;
import moony.compactcrafting.items.ItemC2GoldAxe;
import moony.compactcrafting.items.ItemC2GoldPickaxe;
import moony.compactcrafting.items.ItemC2IronAxe;
import moony.compactcrafting.items.ItemC2IronPickaxe;
import moony.compactcrafting.items.ItemC2StoneAxe;
import moony.compactcrafting.items.ItemC2StonePickaxe;
import moony.compactcrafting.items.ItemC2WoodenAxe;
import moony.compactcrafting.items.ItemC2WoodenPickaxe;
import moony.compactcrafting.items.ItemCompactCoal;
import moony.compactcrafting.items.ItemCompactRedstoneCrystal;
import moony.compactcrafting.items.ItemGlassBrick;
import moony.compactcrafting.lib.ItemIDs;
import moony.compactcrafting.tileentitys.TileEntityCompactChest;
import moony.compactcrafting.tileentitys.TilePressureMachine;
import moony.compactcrafting.worldgenerators.WorldGeneratorCCB;
import moony.compactcrafting.worldgenerators.WorldGeneratorCNR;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "CC", name = "CCMain", version = "4.0")
public class CCMain
{

	@Instance("CC")
	public static CCMain instance;

	public static final String modid = "CC";

	private GuiHandler guiHandler = new GuiHandler();

	@SidedProxy(clientSide = "moony.compactcrafting.core.proxys.ClientProxy", serverSide = "moony.compactcrafting.core.proxys.CommonProxy")
	// Tells Forge the location of your proxies
	public static CommonProxy proxy;

	public static final int sideBottom = 0;
	public static final int sideTop = 1;
	public static final int sideNorth = 2;
	public static final int sideSouth = 3;
	public static final int sideWest = 4;
	public static final int sideEast = 5;

	// Blocks
	public static Block CompactDirt;
	public static Block CompactCobblestone;
	public static Block CompactCoalBlock;
	public static Block CompactNetherrack;
	public static Block CompactGlass;
	public static Block CompactSand;
	public static Block CompactGravel;
	public static Block CompactChest;
	public static Block pressureMachineIdle;
	public static Block pressureMachineActive;
	public static Block GlassBrickBlock;

	public static final ToolMaterial C1IRON = EnumHelper.addToolMaterial(
			"C1IRON", 2, 1000, 7.0F, 3, 14);
	public static final ToolMaterial C1DIAMOND = EnumHelper
			.addToolMaterial("C1DIAMOND", 3, 6244, 9.0F, 4, 10);
	public static final ToolMaterial C1GOLD = EnumHelper.addToolMaterial(
			"C1GOLD", 0, 128, 13.0F, 0, 22);
	public static final ToolMaterial C1STONE = EnumHelper.addToolMaterial(
			"C1STONE", 1, 524, 5.0F, 2, 5);
	public static final ToolMaterial C1WOOD = EnumHelper.addToolMaterial(
			"C1WOOD", 0, 236, 3.0F, 0, 15);
	public static final ToolMaterial C2IRON = EnumHelper.addToolMaterial(
			"C2IRON", 2, 3600, 10.0F, 5, 14);
	public static final ToolMaterial C2DIAMOND = EnumHelper
			.addToolMaterial("C2DIAMOND", 3, 20000, 15.0F, 7, 10);
	public static final ToolMaterial C2GOLD = EnumHelper.addToolMaterial(
			"C2GOLD", 0, 450, 18.0F, 0, 22);
	public static final ToolMaterial C2STONE = EnumHelper.addToolMaterial(
			"C2STONE", 1, 1950, 8.0F, 3, 5);
	public static final ToolMaterial C2WOOD = EnumHelper.addToolMaterial(
			"C2WOOD", 0, 900, 4.0F, 0, 15);
	// Configurations
	int CompactCobblestoneID;
	int CompactCoalBlockID;
	int CompactNetherrackID;
	int CompactDirtID;
	int CompactGlassID;
	int CompactSandID;
	int CompactGravelID;
	int GlassBrickBlockID;

	public static int BlockOn;
	public static int EasterEggOn;
	static int WorldGenOn;

	// Items
	public static Item CompactCoal;
	public static Item C1IronPickaxe;
	public static Item C1DiamondPickaxe;
	public static Item C1GoldPickaxe;
	public static Item C1StonePickaxe;
	public static Item C1WoodenPickaxe;
	public static Item C2IronPickaxe;
	public static Item C2DiamondPickaxe;
	public static Item C2GoldPickaxe;
	public static Item C2WoodenPickaxe;
	public static Item C2StonePickaxe;
	public static Item C1IronAxe;
	public static Item C1DiamondAxe;
	public static Item C1GoldAxe;
	public static Item C1StoneAxe;
	public static Item C1WoodenAxe;
	public static Item C2IronAxe;
	public static Item C2DiamondAxe;
	public static Item C2GoldAxe;
	public static Item C2StoneAxe;
	public static Item C2WoodenAxe;
	public static Item CompactRedstoneCrystal;
	public static Item GlassBrick;
	public static Item C1IronShovel;
	public static Item C1DiamondShovel;
	public static Item C1GoldenShovel;
	public static Item C1StoneShovel;
	public static Item C1WoodenShovel;

	// Achievements
	public static AchievementPage CompactCraftingPage;

	public static CompactAchievement achievements;

	// Creative Tabs
	public static CreativeTabs compactTab = new CompactTab("compactTab");

	// Methods

	// Before Initialising (What do to before initialisation)
	@EventHandler
	public void preInit(FMLPreInitializationEvent evt)
	{

		// Register Rendering
		proxy.registerRenderThings();
		MinecraftForge.EVENT_BUS.register(new CC_SoundHandler());

		// Configuration Initialising
		Configuration cfg = new Configuration(
				evt.getSuggestedConfigurationFile());

		// Load any previous configurations
		cfg.load();

		// Get Blocks, Items and others, and put them into the Configuration
		try
		{

			BlockOn = cfg
					.get(cfg.CATEGORY_GENERAL,
							"Compact Crafting Blocks On or Off", 1,
							"Set to 0 to disable all Compact Crafting Blocks, and set to 1 to enable them")
					.getInt();

			WorldGenOn = cfg
					.get(cfg.CATEGORY_GENERAL,
							"World Generation on or off",
							1,
							"Set to 0 to disable Compact Crafting world generation, and set to 1 to enable it")
					.getInt();

			EasterEggOn = cfg
					.get(cfg.CATEGORY_GENERAL, "Easter Egg on or off", 1,
							"Set to 0 to disable Compact Crafting Easter Egg, and set to 1 to enable it")
					.getInt();
		} catch (Exception e)
		{
			FMLLog.log(Level.SEVERE, "Compact Crafting has trouble loading config", e);
		} finally
		{

			// Save the Configuration
			cfg.save();
		}

		// Initialise all the Items
		CompactCoal = new ItemCompactCoal(ItemIDs.CompactCoalID)
				.setUnlocalizedName("CompactCoal");
		C1IronPickaxe = new ItemC1IronPickaxe(ItemIDs.C1IronPickaxeID, C1IRON)
				.setUnlocalizedName("C1IronPickaxe");
		C1DiamondPickaxe = new ItemC1DiamondPickaxe(ItemIDs.C1DiamondPickaxeID,
				C1DIAMOND).setUnlocalizedName("C1DiamondPickaxe");
		C1GoldPickaxe = new ItemC1GoldPickaxe(ItemIDs.C1GoldPickaxeID, C1GOLD)
				.setUnlocalizedName("C1GoldenPickaxe");
		C1StonePickaxe = new ItemC1StonePickaxe(ItemIDs.C1StonePickaxeID,
				C1STONE).setUnlocalizedName("C1StonePickaxe");
		C1WoodenPickaxe = new ItemC1WoodenPickaxe(ItemIDs.C1WoodenPickaxeID,
				C1WOOD).setUnlocalizedName("C1WoodenPickaxe");
		C2IronPickaxe = new ItemC2IronPickaxe(ItemIDs.C2IronPickaxeID, C2IRON)
				.setUnlocalizedName("C2IronPickaxe");
		C2DiamondPickaxe = new ItemC2DiamondPickaxe(ItemIDs.C2DiamondPickaxeID,
				C2DIAMOND).setUnlocalizedName("C2DiamondPickaxe");
		C2GoldPickaxe = new ItemC2GoldPickaxe(ItemIDs.C2GoldenPickaxeID, C2GOLD)
				.setUnlocalizedName("C2GoldenPickaxe");
		C2StonePickaxe = new ItemC2StonePickaxe(ItemIDs.C2StonePickaxeID,
				C2STONE).setUnlocalizedName("C2StonePickaxe");
		C2WoodenPickaxe = new ItemC2WoodenPickaxe(ItemIDs.C2WoodenPickaxeID,
				C2WOOD).setUnlocalizedName("C2WoodenPickaxe");
		C1IronAxe = new ItemC1IronAxe(ItemIDs.C1IronAxeID, C1IRON)
				.setUnlocalizedName("C1IronAxe");
		C1DiamondAxe = new ItemC1DiamondAxe(ItemIDs.C1DiamondAxeID, C1DIAMOND);
		C1GoldAxe = new ItemC1GoldAxe(ItemIDs.C1GoldAxeID, C1GOLD)
				.setUnlocalizedName("C1GoldenAxe");
		C1StoneAxe = new ItemC1StoneAxe(ItemIDs.C1StoneAxeID, C1STONE)
				.setUnlocalizedName("C1StoneAxe");
		C1WoodenAxe = new ItemC1WoodenAxe(ItemIDs.C1WoodenAxeID, C1WOOD)
				.setUnlocalizedName("C1WoodenAxe");
		C2IronAxe = new ItemC2IronAxe(ItemIDs.C2IronAxeID, C2IRON)
				.setUnlocalizedName("C2IronAxe");
		C2DiamondAxe = new ItemC2DiamondAxe(ItemIDs.C2DiamondAxeID, C2DIAMOND)
				.setUnlocalizedName("C2DiamondAxe");
		C2GoldAxe = new ItemC2GoldAxe(ItemIDs.C2GoldAxeID, C2GOLD)
				.setUnlocalizedName("C2GoldenAxe");
		C2StoneAxe = new ItemC2StoneAxe(ItemIDs.C2StoneAxeID, C2STONE)
				.setUnlocalizedName("C2StoneAxe");
		C2WoodenAxe = new ItemC2WoodenAxe(ItemIDs.C2WoodenAxeID, C2WOOD)
				.setUnlocalizedName("C2WoodenAxe");
		CompactRedstoneCrystal = new ItemCompactRedstoneCrystal(
				ItemIDs.CompactRedstoneCrystalID)
				.setUnlocalizedName("CompactRedstoneCrystal");
		GlassBrick = new ItemGlassBrick(ItemIDs.GlassBrickID)
				.setUnlocalizedName("GlassBrick");
		C1IronShovel = new ItemC1IronShovel(ItemIDs.C1IronShovel, C1IRON)
				.setUnlocalizedName("C1IronShovel");
		C1DiamondShovel = new ItemC1DiamondShovel(ItemIDs.C1DiamondShovel,
				C1DIAMOND).setUnlocalizedName("C1DiamondShovel");
		C1GoldenShovel = new ItemC1GoldenShovel(ItemIDs.C1GoldenShovel, C1GOLD)
				.setUnlocalizedName("C1GoldenShovel");
		C1StoneShovel = new ItemC1StoneShovel(ItemIDs.C1StoneShovel, C1STONE)
				.setUnlocalizedName("C1StoneShovel");
		C1WoodenShovel = new ItemC1WoodenShovel(ItemIDs.C1WoodenShovel, C1WOOD)
				.setUnlocalizedName("C1WoodenShovel");

		// Initialise all the Blocks
		CompactCobblestone = new BlockCompactCobblestone(Material.rock)
		.setHardness(3.2F).setResistance(4.0F).setBlockName("CompactCobblestone");
		
		CompactCoalBlock = new BlockCompactCoalBlock(Material.rock)
		.setHardness(3.0F).setBlockName("CompactCoalBlock");
		
		CompactNetherrack = new BlockCompactNetherrack(Material.rock)
		.setHardness(0.44F).setBlockName("CompactNetherrack");
		
		CompactDirt = new BlockCompactDirt(Material.ground)
		.setHardness(0.6F).setBlockName("CompactDirt");
		
		CompactGlass = new BlockCompactGlass(Material.glass, false)
				.setHardness(0.3F).setBlockName("CompactGlass");
		
		CompactSand = new BlockCompactSand(Material.sand)
				.setHardness(0.6F).setBlockName("CompactSand");
		
		CompactGravel = new BlockCompactGravel().setHardness(0.7F)
				.setBlockName("CompactGravel");
		
		//CompactChest = new BlockCompactChest(Material.wood).setHardness(
		//		0.7F).setBlockName("CompactChest");
		
		pressureMachineIdle = new BlockPressureMachine(false, Material.iron)
		.setHardness(0.7F).setCreativeTab(this.compactTab)
		.setBlockName("PressureMachineIdle");
		
		GlassBrickBlock = new BlockGlassBrickBlock(Material.glass, false)
		.setHardness(0.3F).setBlockName("GlassBrickBlock");

		// Initialise Achievements
		achievements = new CompactAchievement();

	}

	// Initialising (What do to during initialisation)
	@EventHandler
	public void load(FMLInitializationEvent evt)
	{

		NetworkRegistry.instance().registerGuiHandler(this, guiHandler);

		GameRegistry.registerTileEntity(TileEntityCompactChest.class,
				"tecompactchest");
		GameRegistry.registerTileEntity(TilePressureMachine.class,
				"pressuremachine");

		// Registering Blocks

		if (BlockOn == 1)
		{
			if (CompactCobblestoneID != 999)
			{
				GameRegistry.registerBlock(CompactCobblestone,
						"CompactCobblestone");
			}
			if (CompactCoalBlockID != 999)
			{
				GameRegistry
						.registerBlock(CompactCoalBlock, "CompactCoalBlock");
			}
			if (CompactNetherrackID != 999)
			{
				GameRegistry.registerBlock(CompactNetherrack,
						"CompactNetherrack");
			}
			if (CompactDirtID != 999)
			{
				GameRegistry.registerBlock(CompactDirt, "CompactDirt");
			}
			if (CompactGlassID != 999)
			{
				GameRegistry.registerBlock(CompactGlass, "CompactGlass");
			}
			if (CompactSandID != 999)
			{
				GameRegistry.registerBlock(CompactSand, "CompactSand");
			}
			if (CompactGravelID != 999)
			{
				GameRegistry.registerBlock(CompactGravel, "CompactGravel");
			}
			if (GlassBrickBlockID != 999)
			{
				GameRegistry.registerBlock(GlassBrickBlock, "GlassBrickBlock");
			}

		}
		// Handlers
		GameRegistry.registerCraftingHandler(new CraftingHandler());

		GameRegistry.registerBlock(pressureMachineIdle, "PressureMachineIdle");

		// Registering Names for Blocks
		LanguageRegistry.addName(CompactCobblestone, "Compact Cobblestone");
		LanguageRegistry.addName(CompactCoalBlock, "Compact Coal Block");
		LanguageRegistry.addName(CompactNetherrack, "Compact Netherrack");
		LanguageRegistry.addName(CompactDirt, "Compact Dirt");
		LanguageRegistry.addName(CompactGlass, "Compact Glass");
		LanguageRegistry.addName(CompactSand, "Compact Sand");
		LanguageRegistry.addName(CompactGravel, "Compact Gravel");
		LanguageRegistry.addName(pressureMachineIdle, "Pressure Machine");
		LanguageRegistry.addName(GlassBrickBlock, "Glass Brick Block");

		// Registering Names for Items
		LanguageRegistry.instance().addNameForObject(CompactCoal, "en_US",
				"Compact Coal");
		LanguageRegistry.addName(CompactRedstoneCrystal,
				"Compact Redstone Crystal");
		LanguageRegistry.addName(GlassBrick, "Glass Brick");

		LanguageRegistry.addName(C1IronPickaxe, "|Iron Pickaxe|");
		LanguageRegistry.addName(C1DiamondPickaxe, "|Diamond Pickaxe|");
		LanguageRegistry.instance().addNameForObject(C1GoldPickaxe, "en_US",
				"|Golden Pickaxe|");
		LanguageRegistry.instance().addNameForObject(C1StonePickaxe, "en_US",
				"|Stone Pickaxe|");
		LanguageRegistry.addName(C1WoodenPickaxe, "|Wooden Pickaxe|");

		LanguageRegistry.addName(C2IronPickaxe, "||Iron Pickaxe||");
		LanguageRegistry.addName(C2DiamondPickaxe, "||Diamond Pickaxe||");
		LanguageRegistry.addName(C2GoldPickaxe, "||Golden Pickaxe||");
		LanguageRegistry.addName(C2StonePickaxe, "||Stone Pickaxe||");
		LanguageRegistry.addName(C2WoodenPickaxe, "||Wooden Pickaxe||");

		LanguageRegistry.addName(C1IronAxe, "|Iron Axe|");
		LanguageRegistry.addName(C1DiamondAxe, "|Diamond Axe|");
		LanguageRegistry.addName(C1GoldAxe, "|Golden Axe|");
		LanguageRegistry.addName(C1StoneAxe, "|Stone Axe|");
		LanguageRegistry.addName(C1WoodenAxe, "|Wooden Axe|");

		LanguageRegistry.addName(C2IronAxe, "||Iron Axe||");
		LanguageRegistry.addName(C2DiamondAxe, "||Diamond Axe||");
		LanguageRegistry.addName(C2GoldAxe, "||Golden Axe||");
		LanguageRegistry.addName(C2StoneAxe, "||Stone Axe||");
		LanguageRegistry.addName(C2WoodenAxe, "||Wooden Axe||");

		LanguageRegistry.addName(C1IronShovel, "|Iron Shovel|");
		LanguageRegistry.addName(C1DiamondShovel, "|Diamond Shovel|");
		LanguageRegistry.addName(C1GoldenShovel, "|Golden Shovel|");
		LanguageRegistry.addName(C1StoneShovel, "|Stone Shovel|");
		LanguageRegistry.addName(C1WoodenShovel, "|Wooden Shovel|");

		// Registering Names for others
		LanguageRegistry.instance().addStringLocalization(
				"itemGroup.compactTab", "en_US", "Compact Crafting");

		// Achievement Pages, Names and Descriptions

		this.addAchievementName("compactBlockAchievement", "Compact Something");
		this.addAchievementDesc("compactBlockAchievement",
				"Compact a raw material using the workbench.");

		this.addAchievementName("compactGlassAchievement", "Compact Smelting");
		this.addAchievementDesc("compactGlassAchievement",
				"Smelt Compact Sand to get Compact Glass");

		CompactCraftingPage = new AchievementPage("Compact Crafting",
				achievements.compactBlockAchieve,
				achievements.compactGlassAchieve);
		AchievementPage.registerAchievementPage(CompactCraftingPage);

		// Registering others

		GameRegistry.registerFuelHandler(new CompactFuel());

		if (WorldGenOn == 1)
		{
			GameRegistry.registerWorldGenerator(new WorldGeneratorCCB());
			GameRegistry.registerWorldGenerator(new WorldGeneratorCNR());
		}
		// Shaped Recipes
		GameRegistry.addRecipe(new ItemStack(this.CompactCobblestone),
				new Object[]
				{ "XXX", "XXX", "XXX", 'X', Block.cobblestone });
		GameRegistry.addRecipe(new ItemStack(this.CompactCoal), new Object[]
		{ "   ", "XX ", "XX ", 'X', Item.coal });
		GameRegistry.addRecipe(new ItemStack(this.CompactRedstoneCrystal),
				new Object[]
				{ "   ", "XX ", "XX ", 'X', Item.redstone });
		GameRegistry.addRecipe(new ItemStack(this.GlassBrickBlock),
				new Object[]
				{ "   ", "XX ", "XX ", 'X', this.GlassBrick });
		GameRegistry.addRecipe(new ItemStack(this.CompactCoalBlock),
				new Object[]
				{ "XXX", "XXX", "XXX", 'X', CCMain.CompactCoal });
		GameRegistry.addRecipe(new ItemStack(this.CompactNetherrack),
				new Object[]
				{ "XXX", "XXX", "XXX", 'X', Block.netherrack });
		GameRegistry.addRecipe(new ItemStack(this.CompactDirt), new Object[]
		{ "XXX", "XXX", "XXX", 'X', Block.dirt });
		GameRegistry.addRecipe(new ItemStack(this.CompactSand), new Object[]
		{ "XXX", "XXX", "XXX", 'X', Block.sand });

		// Shapeless Recipes
		GameRegistry.addShapelessRecipe(new ItemStack(Block.cobblestone, 9),
				CCMain.CompactCobblestone);
		GameRegistry.addShapelessRecipe(new ItemStack(Item.coal, 4),
				CCMain.CompactCoal);
		GameRegistry.addShapelessRecipe(new ItemStack(CCMain.CompactCoal, 9),
				CCMain.CompactCoalBlock);
		GameRegistry.addShapelessRecipe(new ItemStack(Block.netherrack, 9),
				CCMain.CompactNetherrack);
		GameRegistry.addShapelessRecipe(new ItemStack(Block.dirt, 9),
				CCMain.CompactDirt);
		GameRegistry.addShapelessRecipe(new ItemStack(Block.sand, 9),
				CCMain.CompactSand);

		GameRegistry.addShapelessRecipe(new ItemStack(CCMain.C1IronPickaxe, 1),
				Item.pickaxeSteel, Item.pickaxeSteel, Item.pickaxeSteel,
				Item.pickaxeSteel);
		GameRegistry.addShapelessRecipe(new ItemStack(CCMain.C1DiamondPickaxe,
				1), Item.pickaxeDiamond, Item.pickaxeDiamond,
				Item.pickaxeDiamond, Item.pickaxeDiamond);
		GameRegistry.addShapelessRecipe(new ItemStack(CCMain.C1GoldPickaxe, 1),
				Item.pickaxeGold, Item.pickaxeGold, Item.pickaxeGold,
				Item.pickaxeGold);
		GameRegistry.addShapelessRecipe(
				new ItemStack(CCMain.C1StonePickaxe, 1), Item.pickaxeStone,
				Item.pickaxeStone, Item.pickaxeStone, Item.pickaxeStone);
		GameRegistry.addShapelessRecipe(
				new ItemStack(CCMain.C1WoodenPickaxe, 1), Item.pickaxeWood,
				Item.pickaxeWood, Item.pickaxeWood, Item.pickaxeWood);

		GameRegistry.addShapelessRecipe(new ItemStack(CCMain.C2IronPickaxe, 1),
				CCMain.C1IronPickaxe, CCMain.C1IronPickaxe,
				CCMain.C1IronPickaxe, CCMain.C1IronPickaxe);
		GameRegistry.addShapelessRecipe(new ItemStack(CCMain.C2DiamondPickaxe,
				1), CCMain.C1DiamondPickaxe, CCMain.C1DiamondPickaxe,
				CCMain.C1DiamondPickaxe, CCMain.C1DiamondPickaxe);
		GameRegistry.addShapelessRecipe(new ItemStack(CCMain.C2GoldPickaxe, 1),
				CCMain.C1GoldPickaxe, CCMain.C1GoldPickaxe,
				CCMain.C1GoldPickaxe, CCMain.C1GoldPickaxe);
		GameRegistry.addShapelessRecipe(
				new ItemStack(CCMain.C2StonePickaxe, 1), CCMain.C1StonePickaxe,
				CCMain.C1StonePickaxe, CCMain.C1StonePickaxe,
				CCMain.C1StonePickaxe);
		GameRegistry.addShapelessRecipe(
				new ItemStack(CCMain.C2WoodenPickaxe, 1),
				CCMain.C1WoodenPickaxe, CCMain.C1WoodenPickaxe,
				CCMain.C1WoodenPickaxe, CCMain.C1WoodenPickaxe);

		GameRegistry.addShapelessRecipe(new ItemStack(CCMain.C1IronAxe, 1),
				Item.axeSteel, Item.axeSteel, Item.axeSteel, Item.axeSteel);
		GameRegistry.addShapelessRecipe(new ItemStack(CCMain.C1DiamondAxe, 1),
				Item.axeDiamond, Item.axeDiamond, Item.axeDiamond,
				Item.axeDiamond);
		GameRegistry.addShapelessRecipe(new ItemStack(CCMain.C1GoldAxe, 1),
				Item.axeGold, Item.axeGold, Item.axeGold, Item.axeGold);
		GameRegistry.addShapelessRecipe(new ItemStack(CCMain.C1StoneAxe, 1),
				Item.axeStone, Item.axeStone, Item.axeStone, Item.axeStone);
		GameRegistry.addShapelessRecipe(new ItemStack(CCMain.C1WoodenAxe, 1),
				Item.axeWood, Item.axeWood, Item.axeWood, Item.axeWood);

		GameRegistry.addShapelessRecipe(new ItemStack(CCMain.C2IronAxe, 1),
				CCMain.C1IronAxe, CCMain.C1IronAxe, CCMain.C1IronAxe,
				CCMain.C1IronAxe);
		GameRegistry.addShapelessRecipe(new ItemStack(CCMain.C2DiamondAxe, 1),
				CCMain.C1DiamondAxe, CCMain.C1DiamondAxe, CCMain.C1DiamondAxe,
				CCMain.C1DiamondAxe);
		GameRegistry.addShapelessRecipe(new ItemStack(CCMain.C2GoldAxe, 1),
				CCMain.C1GoldAxe, CCMain.C1GoldAxe, CCMain.C1GoldAxe,
				CCMain.C1GoldAxe);
		GameRegistry.addShapelessRecipe(new ItemStack(CCMain.C2StoneAxe, 1),
				CCMain.C1StoneAxe, CCMain.C1StoneAxe, CCMain.C1StoneAxe,
				CCMain.C1StoneAxe);
		GameRegistry.addShapelessRecipe(new ItemStack(CCMain.C2WoodenAxe, 1),
				CCMain.C1WoodenAxe, CCMain.C1WoodenAxe, CCMain.C1WoodenAxe,
				CCMain.C1WoodenAxe);

		GameRegistry.addShapelessRecipe(new ItemStack(CCMain.C1IronShovel, 1),
				Item.shovelSteel, Item.shovelSteel, Item.shovelSteel,
				Item.shovelSteel);
		GameRegistry.addShapelessRecipe(
				new ItemStack(CCMain.C1DiamondShovel, 1), Item.shovelDiamond,
				Item.shovelDiamond, Item.shovelDiamond, Item.shovelDiamond);
		GameRegistry.addShapelessRecipe(
				new ItemStack(CCMain.C1GoldenShovel, 1), Item.shovelGold,
				Item.shovelGold, Item.shovelGold, Item.shovelGold);
		GameRegistry.addShapelessRecipe(new ItemStack(CCMain.C1StoneShovel, 1),
				Item.shovelStone, Item.shovelStone, Item.shovelStone,
				Item.shovelStone);
		GameRegistry.addShapelessRecipe(
				new ItemStack(CCMain.C1WoodenShovel, 1), Item.shovelWood,
				Item.shovelWood, Item.shovelWood, Item.shovelWood);

		// Smelting Recipes
		GameRegistry.addSmelting(CCMain.CompactSand.blockID, new ItemStack(
				CCMain.CompactGlass), 5);

	}

	// Method to add an Achievement Name
	private void addAchievementName(String ach, String name)
	{
		LanguageRegistry.instance().addStringLocalization("achievement." + ach,
				"en_US", name);
	}

	// Method to add an Achievement Description
	private void addAchievementDesc(String ach, String desc)
	{
		LanguageRegistry.instance().addStringLocalization(
				"achievement." + ach + ".desc", "en_US", desc);
	}

	// Post Initialising (What do to after initialisation)
	@EventHandler
	public void postInit(FMLPostInitializationEvent evt)
	{

	}

}