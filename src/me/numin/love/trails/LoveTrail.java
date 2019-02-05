package me.numin.love.trails;

import java.util.Random;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Particle.DustOptions;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;

import me.numin.love.Main;
import me.numin.love.api.API;
import me.numin.love.api.API.TrailType;
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
		}.runTaskTimer(Main.plugin, 0, 4);
	}
	
	public void progress(Player player, TrailType trailtype) {
		if (trailtype == TrailType.MOVE) {
			//running animation
			ParticleEffect.INSTANT_SPELL.display(player.getLocation(), 2, 2, 2, 0, 1);
			
		} else if (trailtype == TrailType.STILL) {
			
			//still animation
			ParticleEffect.HEART.display(player.getLocation(), 1, 1, 1, 0, 1);
			if (API.enableLGBT) {
				player.getWorld().spawnParticle(Particle.REDSTONE, player.getLocation(), 5, 1, 1, 1, 1, rainbow());
			}
			
		} else if (trailtype == TrailType.SNEAK && player.isSneaking()) {
			//heart animation
			Location location = player.getLocation();
			
			int points = 20;
			double size = 20;
			double posHeight = 2.5;
			boolean isRainbow = API.enableLGBT();
			Color color;
			DustOptions dustOptions;
			int red = 255,green = 0,blue = 0;
			if (isRainbow) {
				dustOptions = rainbow();
			} else {
				color = Color.fromBGR(blue, green, red);
				dustOptions = new DustOptions(color, 1);
			}
			
			//Half 1
			for (int i = 0; i < points; i++) {
				double angle = 360 / 1.0245 * i;
				angle = Math.toRadians(angle);
				double x = (16 * (Math.sin(angle) * Math.sin(angle) * Math.sin(angle)))/size;
				double y = (13 * Math.cos(angle) - (5 * Math.cos(2 * angle)) - (2 * Math.cos(3 * angle)) - Math.cos(4 * angle))/size;
				location.add(x, y + posHeight, 0);
				player.getWorld().spawnParticle(Particle.REDSTONE, location, 1, 0, 0, 0, 0, dustOptions);
				location.subtract(x, y + posHeight, 0);
			}
			
			//Half 2
			for (int i = 0; i < points; i++) {
				double angle = 360 / 1.0245 * -i;
				angle = Math.toRadians(angle);
				double x = (16 * (Math.sin(angle) * Math.sin(angle) * Math.sin(angle)))/size;
				double y = (13 * Math.cos(angle) - (5 * Math.cos(2 * angle)) - (2 * Math.cos(3 * angle)) - Math.cos(4 * angle))/size;
				location.add(x, y + posHeight, 0);
				player.getWorld().spawnParticle(Particle.REDSTONE, location, 1, 0, 0, 0, 0, dustOptions);
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
	
	public DustOptions rainbow() {
		Random rand = new Random();
		int r = rand.nextInt(255);
		int g = rand.nextInt(255);
		int b = rand.nextInt(255);
		Color color = Color.fromBGR(b, g, r);
		return new DustOptions(color, 1);
	}
	
}
