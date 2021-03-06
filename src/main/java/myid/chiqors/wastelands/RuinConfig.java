package myid.chiqors.wastelands;

import java.util.ArrayList;
import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;
import myid.chiqors.wastelands.utils.CustomItemStack;
import myid.chiqors.wastelands.world.gen.WastelandGeneratorInfo;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;

public class RuinConfig
{
	//public static String[] ruinedCiv1LootRaw;
	//public static String[] barnHouseLootRaw;
	//public static String[] ruinedLootRaw;
	//public static String[] spawnerLootRaw;
	//public static String[] treeHouseLootRaw;
	//public static String[] tentLootRaw;
	//public static String[] farmLootRaw;
	
	public static String[] easyLoot;
	public static String[] midLoot;
	public static String[] hardLoot;
	
	public static String[] ruinEasyLoot;
	public static String[] ruinRareLoot;
	public static String[] seedLoot;
	
	public static String[] startLoot;
	
	public static boolean easyLootRepeat;
	public static boolean midLootRepeat;
	public static boolean hardLootRepeat;
	public static boolean ruinEasyLootRepeat;
	public static boolean ruinRareLootRepeat;
	public static boolean seedLootRepeat;
	public static boolean startLootRepeat;
	
	public static int easyLootMax;
	public static int easyLootMin;
	public static int midLootMax;
	public static int midLootMin;
	public static int hardLootMax;
	public static int hardLootMin;
	public static int ruinEasyLootMax;
	public static int ruinEasyLootMin;
	public static int ruinRareLootMax;
	public static int ruinRareLootMin;
	public static int seedLootMax;
	public static int seedLootMin;
	public static int startLootMax;
	public static int startLootMin;
	
	public static int midLootChance;
	public static int hardLootChance;
	public static int rareRuinLootChance;
	
	
	public static void load(Configuration config)
	{
		config.load();
		
		config.setCategoryComment("Loot Amount", "Total itemstacks in chests. Randomized between max and min");
		
		easyLootMax = config.getInt("Common village chest items MAX", "Loot Amount", 3, 0, 27, "");
		easyLootMin = config.getInt("Common village chest items MIN", "Loot Amount", 2, 0, 27, "");
		easyLootRepeat = config.getBoolean("Common village chest item duplicates", "Loot Amount", true, "Set to false to prevent item duplicates in a spawned chest. If items MAX > total types of items, item MAX = total types");
		midLootMax = config.getInt("Uncommon village chest items MAX", "Loot Amount", 5, 0, 27, "");
		midLootMin = config.getInt("Uncommon village chest items MIN", "Loot Amount", 3, 0, 27, "");
		midLootRepeat = config.getBoolean("Uncommon village chest item duplicates", "Loot Amount", true, "Set to false to prevent item duplicates in a spawned chest. If items MAX > total types of items, item MAX = total types");
		hardLootMax = config.getInt("Rare village chest items MAX", "Loot Amount", 8, 0, 27, "");
		hardLootMin = config.getInt("Rare village chest items MIN", "Loot Amount", 4, 0, 27, "");
		hardLootRepeat = config.getBoolean("Rare village chest item duplicates", "Loot Amount", true, "Set to false to prevent item duplicates in a spawned chest. If items MAX > total types of items, item MAX = total types");
		
		ruinEasyLootMax = config.getInt("Common ruin chest items MAX", "Loot Amount", 2, 0, 27, "Ruins are random structures spread through the wasteland outside of towns");
		ruinEasyLootMin = config.getInt("Common ruin chest items MIN", "Loot Amount", 1, 0, 27, "");
		ruinEasyLootRepeat = config.getBoolean("Common ruin chest item duplicates", "Loot Amount", true, "Set to false to prevent item duplicates in a spawned chest. If items MAX > total types of items, item MAX = total types");
		ruinRareLootMax = config.getInt("Rare ruin chest items MAX", "Loot Amount", 4, 0, 27, "");
		ruinRareLootMin = config.getInt("Rare ruin chest items MIN", "Loot Amount", 2, 0, 27, "");
		ruinRareLootRepeat = config.getBoolean("Rare ruin chest item duplicates", "Loot Amount", true, "Set to false to prevent item duplicates in a spawned chest. If items MAX > total types of items, item MAX = total types");
		
		seedLootMax = config.getInt("Seed/farm ruin chest items MAX", "Loot Amount", 1, 0, 27, "Seed chests spawn in ruined structures");
		seedLootMin = config.getInt("Seed/farm ruin chest items MIN", "Loot Amount", 1, 0, 27, "");
		seedLootRepeat = config.getBoolean("Seed/farm ruin chest item duplicates", "Loot Amount", true, "Set to false to prevent item duplicates in a spawned chest. If items MAX > total types of items, item MAX = total types");
		
		startLootMax = config.getInt("Bunker chest items MAX", "Loot Amount", 6, 0, 27, "Items in spawn bunker chest (if enabled)");
		startLootMin = config.getInt("Bunker chest items MIN", "Loot Amount", 6, 0, 27, "");
		startLootRepeat = config.getBoolean("Bunker chest item duplicates", "Loot Amount", false, "Set to false to prevent item duplicates in a spawned chest. If items MAX > total types of items, item MAX = total types");
		
		config.setCategoryComment("Loot List", "Add item names chest loot. Do NOT skip or add blank lines. Format for items:\n" + 
				"mod_name:item_name,max,min\nCheck mod language registry for item names. max = maximum stack size, min = minimum stack size. If max/min stack size > game stack limit, game will chose the stack limit.");
		
		easyLoot = config.get("Loot List", "Common village chest loot items", new String[] { 
				"minecraft:mushroom_stew,1,1", "minecraft:bread,2,1",  "minecraft:wheat,6,2", "minecraft:apple,3,1",
				"minecraft:gunpowder,8,2", "minecraft:string,8,2", "minecraft:dye,4,2", "minecraft:rotten_flesh,6,1"
				}).getStringList();
		
		midLoot = config.get("Loot List", "Uncommon village chest loot items", new String[] { 
				"minecraft:bucket,1,1", "minecraft:bread,4,2",  "minecraft:iron_ingot,2,1", "minecraft:compass,1,1",
				"minecraft:map,1,1", "minecraft:egg,2,1", "minecraft:leather_chestplate,1,1"
				}).getStringList();
		
		hardLoot = config.get("Loot List", "Rare village chest loot items", new String[] { 
				"minecraft:potato,4,1", "minecraft:carrot,4,1",  "minecraft:water_bucket,1,1", "minecraft:cooked_porkchop,4,1", "minecraft:cooked_beef,4,1",
				"minecraft:flint_and_steel,1,1", "minecraft:feather,12,2", "minecraft:gold_ingot,3,1", "minecraft:diamond,2,1", "minecraft:milk_bucket,1,1"
				}).getStringList();
		
		ruinEasyLoot = config.get("Loot List", "Common ruins chest loot items", new String[] { 
				"minecraft:mushroom_stew,1,1", "minecraft:bread,4,1",  "minecraft:wheat,2,1", "minecraft:apple,3,1",
				"minecraft:string,6,2", "minecraft:rotten_flesh,8,2"
				}).getStringList();
		
		ruinRareLoot = config.get("Loot List", "Rare ruins chest loot items", new String[] { 
				"minecraft:bucket,1,1", "minecraft:cooked_porkchop,3,2", "minecraft:cooked_beef,4,1",
				"minecraft:feather,8,2", "minecraft:iron_ingot,3,1"
				}).getStringList();
		
		seedLoot = config.get("Loot List", "Ruins seed chest loot items", new String[] { 
				"minecraft:wheat_seeds,8,2"
				}).getStringList();
		
		startLoot = config.get("Loot List", "Start bunker chest loot items", new String[] { 
				"minecraft:stone_sword,1,1", "minecraft:bread,2,2", "minecraft:leather_helmet,1,1",
				"minecraft:leather_boots,1,1", "minecraft:cooked_chicken,3,2", "minecraft:glass_bottle,2,1"
				}).getStringList();
		
		config.setCategoryComment("Loot Rarity", "Rarity of uncommon and rare chests. Spawn chance 1 in N (higher numbers = lower spawn chance)");
		
		midLootChance = config.getInt("Uncommon village loot chance", "Loot Rarity", 6, 1, 10000, "If not picked, defaults to common village chest loot");
		hardLootChance = config.getInt("Rare village loot chance", "Loot Rarity", 8, 1, 10000, "If not picked, checks rarity of uncommon village chest loot");
		rareRuinLootChance = config.getInt("Uncommon chest village MAX", "Loot Rarity", 8, 1, 10000, "If not picked, defaults to common ruin chest loot");
		
		config.save();
	}
	
	public static CustomItemStack[] getLoot(String[] rawStringArray)
	{
		CustomItemStack[] items = new CustomItemStack[rawStringArray.length];
		int max, min;
		String mod, item;
		for(int i = 0; i < rawStringArray.length; i++)
		{
			if (rawStringArray[i].length() > 0)
			{
				
				String split[] = rawStringArray[i].split(",");
				if (split.length == 3)
				{
					max = Integer.parseInt(split[1]);
					min = Integer.parseInt(split[2]);
				}
				else
				{
					max = 1;
					min = 1;
				}
				String[] modidAndName = split[0].split(":");
				mod = modidAndName[0];
				item = modidAndName[1];
				
				items[i] = new CustomItemStack(GameRegistry.findItemStack(mod, item, 1), max, min);
			}
		}
		
		return items;
	}
}
