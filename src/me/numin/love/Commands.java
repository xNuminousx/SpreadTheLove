package me.numin.love;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {
	
	

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		String bullet = ChatColor.DARK_RED + "♡ ";
		
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
		
		if (lable.equalsIgnoreCase("spreadthelove") || lable.equalsIgnoreCase("stl")) {
			if (args.length == 0) {
				//Header (information about SpreadTheLove)
				sender.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "♡ SPREAD THE LOVE ♡");
				sender.sendMessage(ChatColor.LIGHT_PURPLE + "--------------------");
				
				sender.sendMessage("");
				
				//Commands list
				sender.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "To hug:");
				sender.sendMessage(bullet + ChatColor.AQUA + "/stl hug");
				
				sender.sendMessage("");
				
				sender.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "To kiss:");
				sender.sendMessage(bullet + ChatColor.AQUA + "/stl kiss");
				
				sender.sendMessage("");
				
				sender.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "To wear love:");
				sender.sendMessage(bullet + ChatColor.AQUA + "/stl lovetrail");
				return true;
			} else if (args.length == 1) {
				if (sender instanceof Player) {
					Player p = (Player) sender;
					
					if (args[0].equalsIgnoreCase("hug")) {
						p.sendMessage("Hug command works!");
						return true;
					} else if (args[0].equalsIgnoreCase("kiss")) {
						p.sendMessage("Kiss command works!");
						return true;
					} else if (args[0].equalsIgnoreCase("lovetrail")) {
						
						p.sendMessage("Love trail works!");
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
					}
				}
			}
			return false;
		}
		return false;
	}

}
