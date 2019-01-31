package me.numin.love.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.numin.love.Main;
import me.numin.love.actions.Hug;
import me.numin.love.trails.LoveTrail;

public class Commands implements CommandExecutor {
	
	

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		String bullet = ChatColor.DARK_RED + "♡ ";
		String unspecifiedPlayer = bullet + ChatColor.RED + "Please specify a player.";
		
		String prideEnabled = ChatColor.RED + "" + ChatColor.BOLD + "P" +
								ChatColor.GOLD + "" + ChatColor.BOLD + "R" +
								ChatColor.YELLOW + "" + ChatColor.BOLD + "I" +
								ChatColor.GREEN + "" + ChatColor.BOLD + "D" +
								ChatColor.AQUA + "" + ChatColor.BOLD + "E " +
								ChatColor.DARK_RED + "" + ChatColor.BOLD +
								"mode initiated!";
		
		String prideDisabled = ChatColor.RED + "" + ChatColor.BOLD + "P" +
								ChatColor.GOLD + "" + ChatColor.BOLD + "R" +
								ChatColor.YELLOW + "" + ChatColor.BOLD + "I" +
								ChatColor.GREEN + "" + ChatColor.BOLD + "D" +
								ChatColor.AQUA + "" + ChatColor.BOLD + "E " +
								ChatColor.DARK_RED + "" + ChatColor.BOLD +
								"mode closed!";
		
		//1 Word Commands
		if (lable.equalsIgnoreCase("spreadthelove") || lable.equalsIgnoreCase("stl")) {
			if (args.length == 0) {
				//Header (information about SpreadTheLove)
				sender.sendMessage(ChatColor.LIGHT_PURPLE + "--------------------");
				sender.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "♡ SPREAD THE LOVE ♡");
				sender.sendMessage(ChatColor.LIGHT_PURPLE + "--------------------");
				
				sender.sendMessage("");
				
				//Commands list
				sender.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "To hug:");
				sender.sendMessage(bullet + ChatColor.AQUA + "/stl hug [target username]");
				
				sender.sendMessage("");
				
				sender.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "To kiss:");
				sender.sendMessage(bullet + ChatColor.AQUA + "/stl kiss [target username]");
				
				sender.sendMessage("");
				
				sender.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "To wear love:");
				sender.sendMessage(bullet + ChatColor.AQUA + "/stl lovetrail");
				return true;
			
			
			//2 Word Commands	
			} else if (args.length == 1) {
				if (sender instanceof Player) {
					Player p = (Player) sender;
					
					//Hug command
					if (args[0].equalsIgnoreCase("hug")) {
						p.sendMessage(unspecifiedPlayer);
						return true;
					
					//Kiss command	
					} else if (args[0].equalsIgnoreCase("kiss")) {
						p.sendMessage(unspecifiedPlayer);
						return true;
					
					//Trail command	
					} else if (args[0].equalsIgnoreCase("lovetrail")) {
						
						if (Main.playTrail == false) {
							Main.plugin.love.add(p);
							Main.playTrail = true;
							new LoveTrail(p);
							p.sendMessage("Trail enabled");
						} else {
							Main.plugin.love.remove(p);
							Main.playTrail = false;
							p.sendMessage("Trail disabled");
						}
						return true;
					} else {
						sender.sendMessage(ChatColor.RED + "Unknown command! Try: " + ChatColor.YELLOW + "/spreadthelove" + ChatColor.RED + " or " + ChatColor.YELLOW + "/stl");
						return true;
					}
				} else {
					sender.sendMessage("You're not a player!");
					return false;
				}
			
				
			//3 Word Commands	
			} else if (args.length == 2) {
				if (sender instanceof Player) {
					Player p = (Player) sender;
					
					//Enable/Disable "pride mode"
					if (args[0].equalsIgnoreCase("lovetrail") & args[1].equalsIgnoreCase("pride")) {
						if (!Main.enableLGBT()) {
							Main.enableLGBT(true);
							p.sendMessage(prideEnabled);
						} else {
							Main.enableLGBT(false);
							p.sendMessage(prideDisabled);
						}
						return true;
					} else if (args[0].equalsIgnoreCase("hug") && !args[1].isEmpty()) {
						for (Player target : Bukkit.getOnlinePlayers()) {
							if (args[1].equalsIgnoreCase(target.getName())) {
								new Hug((Player) sender, target);
								return true;
							} else {
								sender.sendMessage("The player may be offline or does not exist.");
								return true;
							}
						}
						return true;
					}
				}
			}
			return false;
		}
		return false;
	}

}