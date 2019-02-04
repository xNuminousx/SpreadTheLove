package me.numin.love;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import me.numin.love.commands.Commands;
import me.numin.love.gui.GUIListener;
import me.numin.love.trails.LoveTrail;

public class Main extends JavaPlugin implements Listener {
	
	public static Main plugin;
	public ArrayList<Player> love = new ArrayList<Player>();
	
	public void onEnable() {
		plugin = this;
		
		getCommand("spreadthelove").setExecutor(new Commands());
		getCommand("stl").setExecutor(new Commands());
		Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
		Bukkit.getServer().getPluginManager().registerEvents(new LoveTrail(null), plugin);
		Bukkit.getServer().getPluginManager().registerEvents(new GUIListener(), plugin);
		
		plugin.getLogger().info("Successfully enabled SpreadTheLove v" + plugin.getDescription().getVersion());
	}
	public void onDisable() {
		love.clear();
		plugin.getLogger().info("Successfully enabled SpreadTheLove v" + plugin.getDescription().getVersion());
	}
}
