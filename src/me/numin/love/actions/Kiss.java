package me.numin.love.actions;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import me.numin.love.utils.ParticleEffect;

public class Kiss {
	
	private String bullet = ChatColor.DARK_RED + "♡ ";
	
	@SuppressWarnings("deprecation")
	public Kiss(Player sender, Player target) {
		String senderName = sender.getName();
		String targetName = target.getName();
		String header = ChatColor.DARK_RED + "* " + ChatColor.LIGHT_PURPLE + "smooch" + ChatColor.DARK_RED + " *";
		String from = ChatColor.DARK_RED + "From: " + senderName;
		
		if (target.getWorld().equals(sender.getWorld())) {
			target.sendTitle(header, from);
			sender.sendMessage(randomizedMessage(targetName));
			
			Location targetEye = target.getLocation();
			Location senderEye = sender.getLocation();
			double x = 0.2;
			double y = 1.5;
			double z = 0.2;
			targetEye.add(x, y, z);
			senderEye.add(x, y, z);
			ParticleEffect.WAKE.display(targetEye, 0, 0, 0, 0.02F, 5);
			ParticleEffect.WAKE.display(senderEye, 0, 0, 0, 0.02F, 5);
			
		} else {
			sender.sendMessage(bullet + ChatColor.RED + "That target is not in your world.");
		}
	}
	
	public String randomizedMessage(String targetName) {
		Random random = new Random();
		int r = random.nextInt(4);
		
		if (r == 1) {
			return bullet + ChatColor.LIGHT_PURPLE + "That was quite inappropriate! ... But " + ChatColor.AQUA + targetName + ChatColor.LIGHT_PURPLE + " liked it.......";
		} else if (r == 2) {
			return bullet + ChatColor.LIGHT_PURPLE + "That was a wet one!";
		} else if (r == 3) {
			return bullet + ChatColor.AQUA + targetName + ChatColor.LIGHT_PURPLE + " is embarrassed... Lets be sneaky next time!";
		} else {
			return bullet + ChatColor.LIGHT_PURPLE + "*blush*";
		}
	}

}