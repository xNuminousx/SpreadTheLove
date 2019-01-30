package me.numin.love.trails;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;

import me.numin.love.Main;
import me.numin.love.Main.TrailType;
import me.numin.love.utils.ParticleEffect;

public class LoveTrail implements Listener {

	public LoveTrail(Player player) {
		new BukkitRunnable() {
			@Override
			public void run() {
				if (Main.plugin.love.contains(player)) {
					progress(player, TrailType.STILL);
					progress(player, TrailType.SNEAK);
				}
			}
		}.runTaskTimer(Main.plugin, 0, 3);
	}
	
	public void progress(Player player, TrailType trailtype) {
		if (trailtype == TrailType.MOVE) {
			//running animation
			ParticleEffect.INSTANT_SPELL.display(player.getLocation(), 3, 2, 3, 0, 1);
			
		} else if (trailtype == TrailType.STILL) {
			//still animation
			ParticleEffect.HEART.display(player.getLocation(), 2, 2, 2, 0, 1);
		} else if (trailtype == TrailType.SNEAK && player.isSneaking()) {
			//heart animation
			Location location = player.getLocation();
			
			int points = 20;
			double size = 20;
			double posHeight = 3;
			ParticleEffect effect = ParticleEffect.RED_DUST;
			boolean isRainbow = Main.enableLGBT();
			float dustSpeed;
			if (isRainbow) {
				dustSpeed = 1;
			} else {
				dustSpeed = 0;
			}
			
			//Half 1
			for (int i = 0; i < points; i++) {
				double angle = 360 / 1.0245 * i;
				angle = Math.toRadians(angle);
				double x = (16 * (Math.sin(angle) * Math.sin(angle) * Math.sin(angle)))/size;
				double y = (13 * Math.cos(angle) - (5 * Math.cos(2 * angle)) - (2 * Math.cos(3 * angle)) - Math.cos(4 * angle))/size;
				location.add(x, y + posHeight, 0);
				effect.display(location, 0, 0, 0, dustSpeed, 1);
				location.subtract(x, y + posHeight, 0);
			}
			
			//Half 2
			for (int i = 0; i < points; i++) {
				double angle = 360 / 1.0245 * -i;
				angle = Math.toRadians(angle);
				double x = (16 * (Math.sin(angle) * Math.sin(angle) * Math.sin(angle)))/size;
				double y = (13 * Math.cos(angle) - (5 * Math.cos(2 * angle)) - (2 * Math.cos(3 * angle)) - Math.cos(4 * angle))/size;
				location.add(x, y + posHeight, 0);
				effect.display(location, 0, 0, 0, dustSpeed, 1);
				location.subtract(x, y + posHeight, 0);
			}
		}
	}
	
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		Player player = e.getPlayer();
		
		if (Main.plugin.love.contains(player)) {
			progress(player, TrailType.MOVE);
		}
	}
}
