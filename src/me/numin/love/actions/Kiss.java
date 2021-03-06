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
		boolean progress;
		String senderName = sender.getName();
		String targetName = target.getName();
		String header = ChatColor.DARK_RED + "* " + ChatColor.LIGHT_PURPLE + "smooch" + ChatColor.DARK_RED + " *";
		String from = ChatColor.DARK_RED + "From: " + senderName;
		
		if (!target.isOnline() || target.equals(null)) {
			sender.sendMessage(bullet + ChatColor.RED + "That player may be offline or does not exist.");
			progress = false;
			return;
		} else {
			progress = true;
		}
		if (target.getWorld().equals(sender.getWorld()) && progress) {
			target.sendTitle(header, from);
			sender.sendMessage(randomizedMessage(targetName));
			
			Location targetEye = target.getEyeLocation().add(target.getEyeLocation().getDirection().multiply(0.4));
			Location senderEye = sender.getEyeLocation().add(sender.getEyeLocation().getDirection().multiply(0.4));
			ParticleEffect.WATER_WAKE.display(0, 0, 0, 0.02F, 5, targetEye, 10);
			ParticleEffect.WATER_WAKE.display(0, 0, 0, 0.02F, 5, senderEye, 10);
			return;
			
		} else {
			sender.sendMessage(bullet + ChatColor.RED + "That player is not in your world.");
			return;
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