package me.numin.love.actions;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import me.numin.love.Main;
import me.numin.love.utils.ParticleEffect;

public class Hug {
	
	int currPoint;
	long time;

	@SuppressWarnings("deprecation")
	public Hug(Player sender, Player target) {
		time = System.currentTimeMillis();
		String senderName = sender.getName();
		String targetName = target.getName();
		String pinkHeart = ChatColor.LIGHT_PURPLE + "♥";
		
		if (target.getWorld().equals(sender.getWorld())) {
			String header = pinkHeart + ChatColor.LIGHT_PURPLE + " " + ChatColor.BOLD + "huggies " + pinkHeart;
			String from = ChatColor.DARK_RED + "From: " + senderName;
			target.sendTitle(header, from);
			
			Location targetLocation = target.getLocation();
			ParticleEffect.FIREWORKS_SPARK.display(targetLocation, 0, 0, 0, (float) 0.2, 20);
			ParticleEffect.CLOUD.display(targetLocation, 3, 1, 3, 0.1F, 10);
			new BukkitRunnable() {
				@Override
				public void run() {
					targetEffects(target);
					if (System.currentTimeMillis() > time + 2000) {
						cancel();
					}
				}
			}.runTaskTimer(Main.plugin, 0, 3);
			
			sender.sendMessage(ChatColor.DARK_RED + "♡ " + ChatColor.LIGHT_PURPLE + "Hug successfully given to " + ChatColor.YELLOW + targetName);
		} else {
			sender.sendMessage(ChatColor.DARK_RED + "♡ " + ChatColor.RED + "That target is not in your world.");
		}
	}
	
	public void targetEffects(Player target) {
		Location targetLocation = target.getLocation();
		
		for (int i = 0; i < 5; i++) {
			currPoint += 360/30;
			if (currPoint > 360) {
				currPoint = 0;
			}
			double angle = currPoint * Math.PI / 180;
			double x = 0.4 * Math.cos(angle);
			double z = 0.4 * Math.sin(angle);
			targetLocation.add(x, 0.5, z);
			ParticleEffect.HEART.display(targetLocation, 0, 0, 0, 0, 1);
			targetLocation.subtract(x, 0.5, z);
		}
	}
}