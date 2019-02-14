package me.numin.love.trails;

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
import me.numin.love.api.API.TrailType;
import me.numin.love.utils.ParticleEffect;

public class LoveTrail implements Listener {

	DustOptions rainbowDust;
	boolean riseRed = true, riseGreen = true, riseBlue = true;
	boolean red = true, green = false, blue = false;
	int r = 255;
	int g = 0;
	int b = 0;
	
	public LoveTrail(Player player) {
		new BukkitRunnable() {
			@Override
			public void run() {
				if (Main.plugin.love.contains(player) && player.isOnline()) {
					progress(player, TrailType.STILL);
					if (player.isSneaking()) {
						playHeart(player);
					}
				} else {
					cancel();
				}
			}
		}.runTaskTimer(Main.plugin, 0, 4);
	}
	public void progress(Player player, TrailType trailtype) {
		if (trailtype == TrailType.MOVE) {
			ParticleEffect.INSTANT_SPELL.display(player.getLocation(), 2, 2, 2, 0, 1);
		} else if (trailtype == TrailType.STILL) {
			ParticleEffect.HEART.display(player.getLocation(), 1, 2, 1, 0, 1);
			if (Main.plugin.lgbt.contains(player)) {
				player.getWorld().spawnParticle(Particle.REDSTONE, player.getLocation().add(0, 1, 0), 10, 0.5, 1, 0.5, 1, rainbow());
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
	public void playHeart(Player player) {
		Location location = player.getLocation();
		
		int points = 20;
		double size = 20;
		double posHeight = 2.5;
		Color color;
		DustOptions dustOptions;
		int red = 255,green = 0,blue = 0;
		if (Main.plugin.lgbt.contains(player)) {
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
	
	public DustOptions rainbow() {
		int speed = 17;
		if (red) {
			if (riseRed) {
				r+= speed;
				if (r >= 255) {
					r = 255;
					riseBlue = false;
					green = true;
				}
			} else {
				r-= speed;
				if (r <= speed) {
					r = 0;
					riseRed = true;
					blue = true;
				}
			}
		}
		if (green) {
			if (riseGreen) {
				g+= speed;
				if (g >= 255) {
					g = 255;
					riseRed = false;
				}
			} else {
				g-= speed;
				if (g <= speed) {
					g = 0;
					riseGreen = true;
					riseRed =true;
				}
			}
		}
		if (blue) {
			if (riseBlue) {
				b+= speed;
				if (b >= 255) {
					b = 255;
					riseGreen = false;
				}
			} else {
				b-= speed;
				if (b <= speed) {
					b = 0;
					riseBlue = true;
				}
			}
		}
		Color color = Color.fromRGB(r, g, b);
		return new DustOptions(color, 1);
	}
}