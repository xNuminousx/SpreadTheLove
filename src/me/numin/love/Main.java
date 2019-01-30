package me.numin.love;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	
	public static Main plugin;
	public ArrayList<Player> love = new ArrayList<Player>();
	public static boolean playTrail = false;
	public static boolean enableLGBT;
	
	public enum TrailType {
		MOVE, STILL, SNEAK
	}
	
	public void onEnable() {
		plugin = this;
		
		getCommand("spreadthelove").setExecutor(new Commands());
		getCommand("stl").setExecutor(new Commands());
		Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
		Bukkit.getServer().getPluginManager().registerEvents(new LoveTrail(null), plugin);
		
		plugin.getLogger().info("Successfully enabled SpreadTheLove v" + plugin.getDescription().getVersion());
	}
	public void onDisable() {
		
		plugin.getLogger().info("Successfully enabled SpreadTheLove v" + plugin.getDescription().getVersion());
	}
	public static boolean enableLGBT() {
		return enableLGBT;
	}
	public static boolean enableLGBT(boolean arg) {
		enableLGBT = arg;
		return enableLGBT;
	}

}
