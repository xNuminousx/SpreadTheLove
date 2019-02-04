package me.numin.love.gui;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

import me.numin.love.api.API;

public class GUI {
	
	public static String guiName = "Spread the Love!";
	
	public static void openGUI(Player player) {
		Inventory inv = Bukkit.createInventory(player, 9, guiName);
		
		inv.setItem(0, API.createItem(Material.APPLE, "To Hug", ChatColor.DARK_RED, Arrays.asList("Hug your lover!")));
		inv.setItem(4, API.createItem(Material.RED_MUSHROOM, "To Kiss", ChatColor.YELLOW, Arrays.asList("Give 'em a big wet kiss!")));
		inv.setItem(8, API.createItem(Material.COMPASS, "To Wear Love", ChatColor.LIGHT_PURPLE, Arrays.asList("Wear love with..... pride .....")));
		
		player.openInventory(inv);
	}
	
	public static void openAnvil(Player player)  {
		Inventory inv = Bukkit.createInventory(player, InventoryType.ANVIL);
		
		inv.setItem(0, API.createItem(Material.PAPER, "Enter a name", ChatColor.AQUA, Arrays.asList("to hug them!")));
		
		player.openInventory(inv);
	}
}
