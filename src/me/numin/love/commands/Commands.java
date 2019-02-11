package me.numin.love.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.numin.love.Main;
import me.numin.love.actions.Hug;
import me.numin.love.actions.Kiss;
import me.numin.love.api.API;
import me.numin.love.gui.GUI;
import me.numin.love.trails.LoveTrail;

public class Commands implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		String bullet = ChatColor.DARK_RED + "♡ ";
		String unspecifiedPlayer = bullet + ChatColor.RED + "Please specify a player.";
		String invalidPlayer = bullet + ChatColor.RED + "That player may be offline or does not exist.";
		String noPerm = bullet + ChatColor.RED + "You do not have the necessary permissions.";
		String unknownCommand = bullet + ChatColor.RED + "Unknown command! Try: " + ChatColor.YELLOW + "/spreadthelove" + ChatColor.RED + " or " + ChatColor.YELLOW + "/stl";
		
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
				sender.sendMessage(ChatColor.DARK_GRAY + "         - Numin");
				sender.sendMessage(ChatColor.LIGHT_PURPLE + "--------------------");
				
				sender.sendMessage("");
				
				//Commands list
				
				sender.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "To open GUI:");
				sender.sendMessage(bullet + ChatColor.AQUA + "/stl gui");
				
				sender.sendMessage("");
				
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
						if (!p.hasPermission("love.hug")) {
							p.sendMessage(noPerm);
						} else {
							p.sendMessage(unspecifiedPlayer);
						}
						return true;
					
					//Kiss command	
					} else if (args[0].equalsIgnoreCase("kiss")) {
						if (!p.hasPermission("love.kiss")) {
							p.sendMessage(noPerm);
						} else {
							p.sendMessage(unspecifiedPlayer);
						}
						return true;
					
					//Trail command	
					} else if (args[0].equalsIgnoreCase("lovetrail")) {
						if (!p.hasPermission("love.lovetrail")) {
							p.sendMessage(noPerm);
						} else {
							if (API.playTrail == false && !Main.plugin.love.contains(p)) {
								Main.plugin.love.add(p);
								API.playTrail = true;
								new LoveTrail(p);
								p.sendMessage(bullet + ChatColor.GREEN + "LoveTrail enabled");
							} else if (Main.plugin.love.contains(p)){
								Main.plugin.love.remove(p);
								API.playTrail = false;
								p.sendMessage(bullet + ChatColor.RED + "LoveTrail disabled");
							}
						}
						return true;
					
					//GUI command	
					} else if (args[0].equalsIgnoreCase("gui")) {
						if (!p.hasPermission("love.gui")) {
							p.sendMessage(noPerm);
						} else {
							GUI.openGUI(p);
						}
						return true;
					} else if (args[0].equalsIgnoreCase("pride")) {
						if (!Main.plugin.lgbt.contains(p)) {
							Main.plugin.lgbt.add(p);
							p.sendMessage(prideEnabled);
						} else {
							Main.plugin.lgbt.remove(p);
							p.sendMessage(prideDisabled);
						}
						return true;
					} else {
						p.sendMessage(unknownCommand);
						return true;
					}
				} else {
					sender.sendMessage("You're not a player!");
					return true;
				}
			
				
			//3 Word Commands	
			} else if (args.length == 2) {
				if (sender instanceof Player) {
					Player player = (Player) sender;
					if (args[0].equalsIgnoreCase("hug") && !args[1].isEmpty()) {
						if (player.hasPermission("love.hug")) {
							for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
								String targetName = onlinePlayer.getName();
								String input = args[1];
								if (input.equalsIgnoreCase(targetName)) {
									new Hug((Player) sender, onlinePlayer);
								} else {
									sender.sendMessage(invalidPlayer);
								}
							}
						} else {
							player.sendMessage(noPerm);
						}
						return true;
					} else if (args[0].equalsIgnoreCase("kiss") && !args[1].isEmpty()) {
						if (player.hasPermission("love.kiss")) {
							for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
								String targetName = onlinePlayer.getName();
								String input = args[1];
								if (input.equalsIgnoreCase(targetName)) {
									new Kiss((Player) sender, onlinePlayer);
								} else {
									sender.sendMessage(invalidPlayer);
								}
							}
						} else {
							player.sendMessage(noPerm);
						}
						return true;
					} else {
						player.sendMessage(unknownCommand);
						return true;
					}
				} else {
					sender.sendMessage("You're not a player!");
					return false;
				}
			}
			return false;
		}
		return false;
	}

}