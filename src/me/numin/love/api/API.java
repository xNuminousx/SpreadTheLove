package me.numin.love.api;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class API {
	
	public static boolean enableLGBT;
	
	public enum TrailType {
		MOVE, STILL, SNEAK
	}
	
	public static ItemStack createItem(Material icon, String name, ChatColor color, List<String> description) {
		ItemStack item = new ItemStack(icon);
		ItemMeta itemMeta = item.getItemMeta();
		
		itemMeta.setDisplayName(color + "" + ChatColor.BOLD + name);
		itemMeta.setLore(description);
		
		item.setItemMeta(itemMeta);
		
		return item;
	}
	
	public static ItemStack createItem(Material icon, String name) {
		ItemStack item = new ItemStack(icon);
		ItemMeta itemMeta = item.getItemMeta();
		
		itemMeta.setDisplayName(name);
		
		item.setItemMeta(itemMeta);
		
		return item;
	}
}
