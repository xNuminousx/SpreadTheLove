package me.numin.love.utils;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * <b>ParticleEffect Library</b>
 * <p>
 * This library was created by @DarkBlade12 and allows you to display all
 * Minecraft particle effects on a Bukkit server
 * <p>
 * You are welcome to use it, modify it and redistribute it under the following
 * conditions:
 * <ul>
 * <li>Don't claim this class as your own
 * <li>Don't remove this disclaimer
 * </ul>
 * <p>
 * Special thanks:
 * <ul>
 * <li>@microgeek (original idea, names and packet parameters)
 * <li>@ShadyPotato (1.8 names, ids and packet parameters)
 * <li>@RingOfStorms (specific particle direction)
 * </ul>
 * <p>
 * <i>It would be nice if you provide credit to me if you use this class in a
 * published project</i>
 * 
 * @author DarkBlade12
 * @version 1.6
 */
public enum ParticleEffect {
	/**
	 * A particle effect which is displayed by exploding tnt and creepers:
	 * <ul>
	 * <li>It looks like a white cloud
	 * <li>The speed value influences the velocity at which the particle flies
	 * off
	 * </ul>
	 */
	EXPLOSION_NORMAL("explode", 0, -1), EXPLODE("explode", 0, -1),
	/**
	 * A particle effect which is displayed by exploding ghast fireballs and
	 * wither skulls:
	 * <ul>
	 * <li>It looks like a gray ball which is fading away
	 * <li>The speed value slightly influences the size of this particle effect
	 * </ul>
	 */
	EXPLOSION_LARGE("largeexplode", 1, -1), LARGE_EXPLODE("largeexplode", 1, -1),
	/**
	 * A particle effect which is displayed by exploding tnt and creepers:
	 * <ul>
	 * <li>It looks like a crowd of gray balls which are fading away
	 * <li>The speed value has no influence on this particle effect
	 * </ul>
	 */
	EXPLOSION_HUGE("hugeexplosion", 2, -1), HUGE_EXPLOSION("hugeexplosion", 2, -1),
	/**
	 * A particle effect which is displayed by launching fireworks:
	 * <ul>
	 * <li>It looks like a white star which is sparkling
	 * <li>The speed value influences the velocity at which the particle flies
	 * off
	 * </ul>
	 */
	FIREWORKS_SPARK("fireworksSpark", 3, -1),
	/**
	 * A particle effect which is displayed by swimming entities and arrows in
	 * water:
	 * <ul>
	 * <li>It looks like a bubble
	 * <li>The speed value influences the velocity at which the particle flies
	 * off
	 * </ul>
	 */
	WATER_BUBBLE("bubble", 4, -1, false, true), BUBBLE("bubble", 4, -1, false, true),
	/**
	 * A particle effect which is displayed by swimming entities and shaking
	 * wolves:
	 * <ul>
	 * <li>It looks like a blue drop
	 * <li>The speed value has no influence on this particle effect
	 * </ul>
	 */
	WATER_SPLASH("splash", 5, -1), SPLASH("splash", 5, -1),
	/**
	 * A particle effect which is displayed on water when fishing:
	 * <ul>
	 * <li>It looks like a blue droplet
	 * <li>The speed value influences the velocity at which the particle flies
	 * off
	 * </ul>
	 */
	WATER_WAKE("wake", 6, 7), WAKE("wake", 6, 7),
	/**
	 * A particle effect which is displayed by water:
	 * <ul>
	 * <li>It looks like a tiny blue square
	 * <li>The speed value has no influence on this particle effect
	 * </ul>
	 */
	SUSPENDED("suspended", 7, -1, false, true), SUSPEND("suspended", 7, -1, false, true),
	/**
	 * A particle effect which is displayed by air when close to bedrock and the
	 * in the void:
	 * <ul>
	 * <li>It looks like a tiny gray square
	 * <li>The speed value has no influence on this particle effect
	 * </ul>
	 */
	SUSPENDED_DEPTH("depthSuspend", 8, -1), DEPTH_SUSPEND("depthSuspend", 8, -1),
	/**
	 * A particle effect which is displayed when landing a critical hit and by
	 * arrows:
	 * <ul>
	 * <li>It looks like a light brown cross
	 * <li>The speed value influences the velocity at which the particle flies
	 * off
	 * </ul>
	 */
	CRIT("crit", 9, -1),
	/**
	 * A particle effect which is displayed when landing a hit with an enchanted
	 * weapon:
	 * <ul>
	 * <li>It looks like a cyan star
	 * <li>The speed value influences the velocity at which the particle flies
	 * off
	 * </ul>
	 */
	CRIT_MAGIC("magicCrit", 10, -1), MAGIC_CRIT("magicCrit", 10, -1),
	/**
	 * A particle effect which is displayed by primed tnt, torches, droppers,
	 * dispensers, end portals, brewing stands and monster spawners:
	 * <ul>
	 * <li>It looks like a little gray cloud
	 * <li>The speed value influences the velocity at which the particle flies
	 * off
	 * </ul>
	 */
	SMOKE_NORMAL("smoke", 11, -1), SMOKE("smoke", 11, -1),
	/**
	 * A particle effect which is displayed by fire, minecarts with furnace and
	 * blazes:
	 * <ul>
	 * <li>It looks like a large gray cloud
	 * <li>The speed value influences the velocity at which the particle flies
	 * off
	 * </ul>
	 */
	SMOKE_LARGE("largesmoke", 12, -1), LARGE_SMOKE("largesmoke", 12, -1),
	/**
	 * A particle effect which is displayed when splash potions or bottles o'
	 * enchanting hit something:
	 * <ul>
	 * <li>It looks like a white swirl
	 * <li>The speed value causes the particle to only move upwards when set to
	 * 0
	 * </ul>
	 */
	SPELL("spell", 13, -1),
	/**
	 * A particle effect which is displayed when instant splash potions hit
	 * something:
	 * <ul>
	 * <li>It looks like a white cross
	 * <li>The speed value causes the particle to only move upwards when set to
	 * 0
	 * </ul>
	 */
	SPELL_INSTANT("instantSpell", 14, -1), INSTANT_SPELL("instantSpell", 14, -1),
	/**
	 * A particle effect which is displayed by entities with active potion
	 * effects:
	 * <ul>
	 * <li>It looks like a colored swirl
	 * <li>The speed value causes the particle to be colored black when set to 0
	 * <li>The particle color gets lighter when increasing the speed and darker
	 * when decreasing the speed
	 * </ul>
	 */
	SPELL_MOB("mobSpell", 15, -1), MOB_SPELL("mobSpell", 15, -1),
	/**
	 * A particle effect which is displayed by entities with active potion
	 * effects applied through a beacon:
	 * <ul>
	 * <li>It looks like a transparent colored swirl
	 * <li>The speed value causes the particle to be always colored black when
	 * set to 0
	 * <li>The particle color gets lighter when increasing the speed and darker
	 * when decreasing the speed
	 * </ul>
	 */
	SPELL_MOB_AMBIENT("mobSpellAmbient", 16, -1), MOB_SPELL_AMBIENT("mobSpellAmbient", 16, -1),
	/**
	 * A particle effect which is displayed by witches:
	 * <ul>
	 * <li>It looks like a purple cross
	 * <li>The speed value causes the particle to only move upwards when set to
	 * 0
	 * </ul>
	 */
	SPELL_WITCH("witchMagic", 17, -1), WITCH_MAGIC("witchMagic", 17, -1),
	/**
	 * A particle effect which is displayed by blocks beneath a water source:
	 * <ul>
	 * <li>It looks like a blue drip
	 * <li>The speed value has no influence on this particle effect
	 * </ul>
	 */
	DRIP_WATER("dripWater", 18, -1),
	/**
	 * A particle effect which is displayed by blocks beneath a lava source:
	 * <ul>
	 * <li>It looks like an orange drip
	 * <li>The speed value has no influence on this particle effect
	 * </ul>
	 */
	DRIP_LAVA("dripLava", 19, -1),
	/**
	 * A particle effect which is displayed when attacking a villager in a
	 * village:
	 * <ul>
	 * <li>It looks like a cracked gray heart
	 * <li>The speed value has no influence on this particle effect
	 * </ul>
	 */
	VILLAGER_ANGRY("angryVillager", 20, -1), ANGRY_VILLAGER("angryVillager", 20, -1),
	/**
	 * A particle effect which is displayed when using bone meal and trading
	 * with a villager in a village:
	 * <ul>
	 * <li>It looks like a green star
	 * <li>The speed value has no influence on this particle effect
	 * </ul>
	 */
	VILLAGER_HAPPY("happyVillager", 21, -1), HAPPY_VILLAGER("happyVillager", 21, -1),
	/**
	 * A particle effect which is displayed by mycelium:
	 * <ul>
	 * <li>It looks like a tiny gray square
	 * <li>The speed value has no influence on this particle effect
	 * </ul>
	 */
	TOWN_AURA("townaura", 22, -1),
	/**
	 * A particle effect which is displayed by note blocks:
	 * <ul>
	 * <li>It looks like a colored note
	 * <li>The speed value causes the particle to be colored green when set to 0
	 * </ul>
	 */
	NOTE("note", 23, -1),
	/**
	 * A particle effect which is displayed by nether portals, endermen, ender
	 * pearls, eyes of ender, ender chests and dragon eggs:
	 * <ul>
	 * <li>It looks like a purple cloud
	 * <li>The speed value influences the spread of this particle effect
	 * </ul>
	 */
	PORTAL("portal", 24, -1),
	/**
	 * A particle effect which is displayed by enchantment tables which are
	 * nearby bookshelves:
	 * <ul>
	 * <li>It looks like a cryptic white letter
	 * <li>The speed value influences the spread of this particle effect
	 * </ul>
	 */
	ENCHANTMENT_TABLE("enchantmenttable", 25, -1),
	/**
	 * A particle effect which is displayed by torches, active furnaces, magma
	 * cubes and monster spawners:
	 * <ul>
	 * <li>It looks like a tiny flame
	 * <li>The speed value influences the velocity at which the particle flies
	 * off
	 * </ul>
	 */
	FLAME("flame", 26, -1),
	/**
	 * A particle effect which is displayed by lava:
	 * <ul>
	 * <li>It looks like a spark
	 * <li>The speed value has no influence on this particle effect
	 * </ul>
	 */
	LAVA("lava", 27, -1),
	/**
	 * A particle effect which is currently unused:
	 * <ul>
	 * <li>It looks like a transparent gray square
	 * <li>The speed value has no influence on this particle effect
	 * </ul>
	 */
	FOOTSTEP("footstep", 28, -1),
	/**
	 * A particle effect which is displayed when a mob dies:
	 * <ul>
	 * <li>It looks like a large white cloud
	 * <li>The speed value influences the velocity at which the particle flies
	 * off
	 * </ul>
	 */
	CLOUD("cloud", 29, -1),
	/**
	 * A particle effect which is displayed by redstone ore, powered redstone,
	 * redstone torches and redstone repeaters:
	 * <ul>
	 * <li>It looks like a tiny colored cloud
	 * <li>The speed value causes the particle to be colored red when set to 0
	 * </ul>
	 */
	REDSTONE("reddust", 30, -1), RED_DUST("reddust", 30, -1),
	/**
	 * A particle effect which is displayed when snowballs hit a block:
	 * <ul>
	 * <li>It looks like a little piece with the snowball texture
	 * <li>The speed value has no influence on this particle effect
	 * </ul>
	 */
	SNOWBALL("snowballpoof", 31, -1), SNOWBALL_POOF("snowballpoof", 31, -1),
	/**
	 * A particle effect which is currently unused:
	 * <ul>
	 * <li>It looks like a tiny white cloud
	 * <li>The speed value influences the velocity at which the particle flies
	 * off
	 * </ul>
	 */
	SNOW_SHOVEL("snowshovel", 32, -1),
	/**
	 * A particle effect which is displayed by slimes:
	 * <ul>
	 * <li>It looks like a tiny part of the slimeball icon
	 * <li>The speed value has no influence on this particle effect
	 * </ul>
	 */
	SLIME("slime", 33, -1),
	/**
	 * A particle effect which is displayed when breeding and taming animals:
	 * <ul>
	 * <li>It looks like a red heart
	 * <li>The speed value has no influence on this particle effect
	 * </ul>
	 */
	HEART("heart", 34, -1),
	/**
	 * A particle effect which is displayed by barriers:
	 * <ul>
	 * <li>It looks like a red box with a slash through it
	 * <li>The speed value has no influence on this particle effect
	 * </ul>
	 */
	BARRIER("barrier", 35, 8),
	/**
	 * A particle effect which is displayed when breaking a tool or eggs hit a
	 * block:
	 * <ul>
	 * <li>It looks like a little piece with an item texture
	 * </ul>
	 */
	ITEM_CRACK("iconcrack", 36, -1, true),
	/**
	 * A particle effect which is displayed when breaking blocks or sprinting:
	 * <ul>
	 * <li>It looks like a little piece with a block texture
	 * <li>The speed value has no influence on this particle effect
	 * </ul>
	 */
	BLOCK_CRACK("blockcrack", 37, -1, true),
	/**
	 * A particle effect which is displayed when falling:
	 * <ul>
	 * <li>It looks like a little piece with a block texture
	 * </ul>
	 */
	BLOCK_DUST("blockdust", 38, 7, true),
	/**
	 * A particle effect which is displayed when rain hits the ground:
	 * <ul>
	 * <li>It looks like a blue droplet
	 * <li>The speed value has no influence on this particle effect
	 * </ul>
	 */
	WATER_DROP("droplet", 39, 8),
	/**
	 * A particle effect which is currently unused:
	 * <ul>
	 * <li>It has no visual effect
	 * </ul>
	 */
	ITEM_TAKE("take", 40, 8),
	/**
	 * A particle effect (use unknown)
	 */
	MOB_APPEARANCE("mobappearance", 41, 8),
	/**
	 * A particle effect displayed by end rods and shelker bullets:
	 * <ul>
	 * <li>Looks like a white twinkly star that rises
	 * </ul>
	 */
	END_ROD("endRod", 43, 9),
	/**
	 * A particle effect created by the Ender Dragon when it breathes acid:
	 * <ul>
	 * <li>Looks similar to portal particles but bigger
	 * <li>A purple varaint of the cloud effect
	 * </ul>
	 */
	DRAGON_BREATH("dragonBreath", 42, 9),
	/**
	 * A particle effect which is displayed when mobs are damaged:
	 * <ul>
	 * <li>Looks like a black heart
	 * </ul>
	 */
	DAMAGE_INDICATOR("damageIndicator", 44, 9),
	/**
	 * A particle effect displayed when mobs are attacked with a sword:
	 * <ul>
	 * <li>Looks like a sweep of air
	 * </ul>
	 */
	SWEEP("sweepAttack", 45, 9),
	/***
	 * A particle effect displayed by floating sand and gravel blocks
	 * <ul>
	 * <li>Looks like a yellow/cream colored reddust
	 * <li>Has a downwards motion by default
	 * </ul>
	 */
	FALLING_DUST("fallingDust", 46, 10, true),
	/***
	 * The particles given off when a totem of undying is used
	 * <ul>
	 * <li>Looks like endRod shaped particles
	 * <li>Are between a yellow and green in color
	 * <li>Has a downwards motion by default
	 * </ul>
	 */
	TOTEM("talisman", 47, 11),
	/***
	 * A particle effect given off from llama spit entities
	 * <ul>
	 * <li>Looks like very large cloud
	 * <li>Has a downwards motion by default
	 * </ul>
	 */
	SPIT("spit", 48, 11);
	

	private static final Map<String, ParticleEffect> NAME_MAP = new HashMap<String, ParticleEffect>();
	private static final Map<Integer, ParticleEffect> ID_MAP = new HashMap<Integer, ParticleEffect>();
	// If range is less than 257 it automatically reverts back to 16 blocks for some reason.
	private static final int RANGE = 257;
	private final String name;
	private final int id;
	private final int requiredVersion;
	private final boolean requiresData;
	private final boolean requiresWater;

	// Initialize map for quick name and id lookup
	static {
		for (ParticleEffect effect : values()) {
			NAME_MAP.put(effect.name, effect);
			ID_MAP.put(effect.id, effect);
		}
		ParticlePacket.initialize();
	}

	/**
	 * Construct a new particle effect
	 * 
	 * @param name Name of this particle effect
	 * @param id Id of this particle effect
	 * @param requiredVersion Version which is required (1.x)
	 * @param requiresData Indicates whether additional data is required for
	 *            this particle effect
	 * @param requiresWater Indicates whether water is required for this
	 *            particle effect to display properly
	 */
	private ParticleEffect(String name, int id, int requiredVersion, boolean requiresData, boolean requiresWater) {
		this.name = name;
		this.id = id;
		this.requiredVersion = requiredVersion;
		this.requiresData = requiresData;
		this.requiresWater = requiresWater;
	}

	/**
	 * Construct a new particle effect with {@link #requiresWater} set to
	 * <code>false</code>
	 * 
	 * @param name Name of this particle effect
	 * @param id Id of this particle effect
	 * @param requiredVersion Version which is required (1.x)
	 * @param requiresData Indicates whether additional data is required for
	 *            this particle effect
	 * @see #ParticleEffect(String, int, boolean, boolean)
	 */
	private ParticleEffect(String name, int id, int requiredVersion, boolean requiresData) {
		this(name, id, requiredVersion, requiresData, false);
	}

	/**
	 * Construct a new particle effect with {@link #requiresData} and
	 * {@link #requiresWater} set to <code>false</code>
	 * 
	 * @param name Name of this particle effect
	 * @param id Id of this particle effect
	 * @param requiredVersion Version which is required (1.x)
	 * @param requiresData Indicates whether additional data is required for
	 *            this particle effect
	 * @see #ParticleEffect(String, int, boolean)
	 */
	private ParticleEffect(String name, int id, int requiredVersion) {
		this(name, id, requiredVersion, false);
	}

	/**
	 * Returns the name of this particle effect
	 * 
	 * @return The name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the id of this particle effect
	 * 
	 * @return The id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Returns the required version for this particle effect (1.x)
	 * 
	 * @return The required version
	 */
	public int getRequiredVersion() {
		return requiredVersion;
	}

	/**
	 * Determine if additional data is required for this particle effect
	 * 
	 * @return Whether additional data is required or not
	 */
	public boolean getRequiresData() {
		return requiresData;
	}

	/**
	 * Determine if water is required for this particle effect to display
	 * properly
	 * 
	 * @return Whether water is required or not
	 */
	public boolean getRequiresWater() {
		return requiresWater;
	}

	/**
	 * Determine if this particle effect is supported by your current server
	 * version
	 * 
	 * @return Whether the particle effect is supported or not
	 */
	public boolean isSupported() {
		if (requiredVersion == -1) {
			return true;
		}
		return ParticlePacket.getVersion() >= requiredVersion;
	}

	/**
	 * Returns the particle effect with the given name
	 * 
	 * @param name Name of the particle effect
	 * @return The particle effect
	 */
	public static ParticleEffect fromName(String name) {
		for (Entry<String, ParticleEffect> entry : NAME_MAP.entrySet()) {
			if (!entry.getKey().equalsIgnoreCase(name)) {
				continue;
			}
			return entry.getValue();
		}
		return null;
	}

	/**
	 * Returns the particle effect with the given id
	 * 
	 * @param id Id of the particle effect
	 * @return The particle effect
	 */
	public static ParticleEffect fromId(int id) {
		for (Entry<Integer, ParticleEffect> entry : ID_MAP.entrySet()) {
			if (entry.getKey() != id) {
				continue;
			}
			return entry.getValue();
		}
		return null;
	}

	/**
	 * Determine if water is at a certain location
	 * 
	 * @param location Location to check
	 * @return Whether water is at this location or not
	 */
	private static boolean isWater(Location location) {
		Material material = location.getBlock().getType();
		return material == Material.WATER;
	}

	/**
	 * Determine if the distance between @param location and one of the players
	 * exceeds 256
	 * 
	 * @param location Location to check
	 * @return Whether the distance exceeds 256 or not
	 */
	@SuppressWarnings("unused")
	private static boolean isLongDistance(Location location, List<Player> players) {
		for (Player player : players) {
			if (player.getWorld().equals(location.getWorld()) && player.getLocation().distance(location) < 256) {
				continue;
			}
			return true;
		}
		return false;
	}

	/**
	 * Displays a particle effect which is only visible for all players within a
	 * certain range in the world of @param center
	 * 
	 * @param offsetX Maximum distance particles can fly away from the center on
	 *            the x-axis
	 * @param offsetY Maximum distance particles can fly away from the center on
	 *            the y-axis
	 * @param offsetZ Maximum distance particles can fly away from the center on
	 *            the z-axis
	 * @param speed Display speed of the particles
	 * @param amount Amount of particles
	 * @param center Center location of the effect
	 * @param range Range of the visibility
	 * @throws ParticleVersionException If the particle effect is not supported
	 *             by the server version
	 * @throws ParticleDataException If the particle effect requires additional
	 *             data
	 * @throws IllegalArgumentException If the particle effect requires water
	 *             and none is at the center location
	 * @see ParticlePacket
	 * @see ParticlePacket#sendTo(Location, double)
	 */
	public void display(float offsetX, float offsetY, float offsetZ, float speed, int amount, Location center, double range) throws ParticleVersionException, ParticleDataException, IllegalArgumentException {
		if (!isSupported()) {
			throw new ParticleVersionException("This particle effect is not supported by your server version");
		}
		if (requiresData) {
			throw new ParticleDataException("This particle effect requires additional data");
		}
		if (requiresWater && !isWater(center)) {
			throw new IllegalArgumentException("There is no water at the center location");
		}

		if (this == ParticleEffect.REDSTONE || this == ParticleEffect.RED_DUST) {
			Color color = Color.fromRGB((int)(offsetX), (int)(offsetY), (int)(offsetZ));
			center.getWorld().spawnParticle(mapParticleType(this), center, amount, offsetX, offsetY, offsetZ, speed, new Particle.DustOptions(color, 1));
		} else {
			center.getWorld().spawnParticle(mapParticleType(this), center, amount, offsetX, offsetY, offsetZ, speed, null);
		}
		//new ParticlePacket(this, offsetX, offsetY, offsetZ, speed, amount, range > 256, null).sendTo(center, range);
	}

	private Particle mapParticleType(ParticleEffect effect) {
		switch (effect) {
			case EXPLOSION_NORMAL:
			case EXPLODE:
				return Particle.EXPLOSION_NORMAL;
			case EXPLOSION_LARGE:
			case LARGE_EXPLODE:
				return Particle.EXPLOSION_LARGE;
			case HUGE_EXPLOSION:
			case EXPLOSION_HUGE:
				return Particle.EXPLOSION_HUGE;
			case FIREWORKS_SPARK:
				return Particle.FIREWORKS_SPARK;
			case WATER_BUBBLE:
			case BUBBLE:
				return Particle.WATER_BUBBLE;
			case SPLASH:
			case WATER_SPLASH:
				return Particle.WATER_SPLASH;
			case WATER_WAKE:
			case WAKE:
				return Particle.WATER_WAKE;
			case SUSPEND:
			case SUSPENDED:
				return Particle.SUSPENDED;
			case SUSPENDED_DEPTH:
			case DEPTH_SUSPEND:
				return Particle.SUSPENDED_DEPTH;
			case CRIT:
				return Particle.CRIT;
			case CRIT_MAGIC:
			case MAGIC_CRIT:
				return Particle.CRIT_MAGIC;
			case SMOKE:
			case SMOKE_NORMAL:
				return Particle.SMOKE_NORMAL;
			case SMOKE_LARGE:
			case LARGE_SMOKE:
				return Particle.SMOKE_LARGE;
			case SPELL:
				return Particle.SPELL;
			case SPELL_INSTANT:
			case INSTANT_SPELL:
				return Particle.SPELL_INSTANT;
			case SPELL_MOB:
			case MOB_SPELL:
				return Particle.SPELL_MOB;
			case MOB_SPELL_AMBIENT:
			case SPELL_MOB_AMBIENT:
				return Particle.SPELL_MOB_AMBIENT;
			case SPELL_WITCH:
			case WITCH_MAGIC:
				return Particle.SPELL_WITCH;
			case DRIP_WATER:
				return Particle.DRIP_WATER;
			case DRIP_LAVA:
				return Particle.DRIP_LAVA;
			case ANGRY_VILLAGER:
			case VILLAGER_ANGRY:
				return Particle.VILLAGER_ANGRY;
			case VILLAGER_HAPPY:
			case HAPPY_VILLAGER:
				return Particle.VILLAGER_HAPPY;
			case TOWN_AURA:
				return Particle.TOWN_AURA;
			case NOTE:
				return Particle.NOTE;
			case PORTAL:
				return Particle.PORTAL;
			case ENCHANTMENT_TABLE:
				return Particle.ENCHANTMENT_TABLE;
			case FLAME:
				return Particle.FLAME;
			case LAVA:
				return Particle.LAVA;
			case CLOUD:
				return Particle.CLOUD;
			case RED_DUST:
			case REDSTONE:
				return Particle.REDSTONE;
			case SNOWBALL:
			case SNOWBALL_POOF:
				return Particle.SNOWBALL;
			case SNOW_SHOVEL:
				return Particle.SNOW_SHOVEL;
			case SLIME:
				return Particle.SLIME;
			case HEART:
				return Particle.HEART;
			case BARRIER:
				return Particle.BARRIER;
			case ITEM_CRACK:
				return Particle.ITEM_CRACK;
			case BLOCK_CRACK:
				return Particle.BLOCK_CRACK;
			case BLOCK_DUST:
				return Particle.BLOCK_DUST;
			case WATER_DROP:
				return Particle.WATER_DROP;
			case MOB_APPEARANCE:
				return Particle.MOB_APPEARANCE;
			case END_ROD:
				return Particle.END_ROD;
			case DRAGON_BREATH:
				return Particle.DRAGON_BREATH;
			case DAMAGE_INDICATOR:
				return Particle.DAMAGE_INDICATOR;
			case SWEEP:
				return Particle.SWEEP_ATTACK;
			case FALLING_DUST:
				return Particle.FALLING_DUST;
			case TOTEM:
				return Particle.TOTEM;
			case SPIT:
				return Particle.SPIT;
			default:
				return Particle.SPIT;
		}
	}

	/**
	 * Displays a particle effect which is only visible for all players within a
	 * certain range in the world of @param center
	 * 
	 * @param offsetX Maximum distance particles can fly away from the center on
	 *            the x-axis
	 * @param offsetY Maximum distance particles can fly away from the center on
	 *            the y-axis
	 * @param offsetZ Maximum distance particles can fly away from the center on
	 *            the z-axis
	 * @param speed Display speed of the particles
	 * @param amount Amount of particles
	 * @param center Center location of the effect
	 * @throws ParticleVersionException If the particle effect is not supported
	 *             by the server version
	 * @throws ParticleDataException If the particle effect requires additional
	 *             data
	 * @throws IllegalArgumentException If the particle effect requires water
	 *             and none is at the center location
	 * @see ParticlePacket
	 * @see ParticlePacket#sendTo(Location, double)
	 */
	public void display(Location center, float offsetX, float offsetY, float offsetZ, float speed, int amount) {
		display(offsetX, offsetY, offsetZ, speed, amount, center, RANGE);
	}

	/**
	 * Displays a particle effect which is only visible for the specified
	 * players
	 * 
	 * @param offsetX Maximum distance particles can fly away from the center on
	 *            the x-axis
	 * @param offsetY Maximum distance particles can fly away from the center on
	 *            the y-axis
	 * @param offsetZ Maximum distance particles can fly away from the center on
	 *            the z-axis
	 * @param speed Display speed of the particles
	 * @param amount Amount of particles
	 * @param center Center location of the effect
	 * @param players Receivers of the effect
	 * @throws ParticleVersionException If the particle effect is not supported
	 *             by the server version
	 * @throws ParticleDataException If the particle effect requires additional
	 *             data
	 * @throws IllegalArgumentException If the particle effect requires water
	 *             and none is at the center location
	 * @see ParticlePacket
	 * @see ParticlePacket#sendTo(Location, List)
	 */
	public void display(float offsetX, float offsetY, float offsetZ, float speed, int amount, Location center, List<Player> players) throws ParticleVersionException, ParticleDataException, IllegalArgumentException {
		if (!isSupported()) {
			throw new ParticleVersionException("This particle effect is not supported by your server version");
		}
		if (requiresData) {
			throw new ParticleDataException("This particle effect requires additional data");
		}
		if (requiresWater && !isWater(center)) {
			throw new IllegalArgumentException("There is no water at the center location");
		}

		if (this == ParticleEffect.REDSTONE || this == ParticleEffect.RED_DUST) {
			Color color = Color.fromRGB((int)(offsetX), (int)(offsetY), (int)(offsetZ));
			center.getWorld().spawnParticle(mapParticleType(this), center, amount, offsetX, offsetY, offsetZ, speed, new Particle.DustOptions(color, 1));
		} else {
			center.getWorld().spawnParticle(mapParticleType(this), center, amount, offsetX, offsetY, offsetZ, speed, null);
		}

		//new ParticlePacket(this, offsetX, offsetY, offsetZ, speed, amount, isLongDistance(center, players), null).sendTo(center, players);
	}

	/**
	 * Displays a single particle which flies into a determined direction and is
	 * only visible for all players within a certain range in the world
	 * of @param center
	 * 
	 * @param direction Direction of the particle
	 * @param speed Display speed of the particle
	 * @param center Center location of the effect
	 * @param range Range of the visibility
	 * @throws ParticleVersionException If the particle effect is not supported
	 *             by the server version
	 * @throws ParticleDataException If the particle effect requires additional
	 *             data
	 * @throws IllegalArgumentException If the particle effect requires water
	 *             and none is at the center location
	 * @see ParticlePacket
	 * @see ParticlePacket#sendTo(Location, double)
	 */
	public void display(Vector direction, float speed, Location center, double range) throws ParticleVersionException, ParticleDataException, IllegalArgumentException {
		if (!isSupported()) {
			throw new ParticleVersionException("This particle effect is not supported by your server version");
		}
		if (requiresData) {
			throw new ParticleDataException("This particle effect requires additional data");
		}
		if (requiresWater && !isWater(center)) {
			throw new IllegalArgumentException("There is no water at the center location");
		}

		if (this == ParticleEffect.REDSTONE || this == ParticleEffect.RED_DUST) {
			Color color = Color.fromRGB((int)(direction.getX()), (int)(direction.getY()), (int)(direction.getZ()));
			center.getWorld().spawnParticle(mapParticleType(this), center, 1, direction.getX(), direction.getY(), direction.getZ(), speed, new Particle.DustOptions(color, 1));
		} else {
			center.getWorld().spawnParticle(mapParticleType(this), center, 1, direction.getX(), direction.getY(), direction.getZ(), speed, null);
		}


		//new ParticlePacket(this, direction, speed, range > 256, null).sendTo(center, range);
	}

	/**
	 * Displays a single particle which flies into a determined direction and is
	 * only visible for the specified players
	 * 
	 * @param direction Direction of the particle
	 * @param speed Display speed of the particle
	 * @param center Center location of the effect
	 * @param players Receivers of the effect
	 * @throws ParticleVersionException If the particle effect is not supported
	 *             by the server version
	 * @throws ParticleDataException If the particle effect requires additional
	 *             data
	 * @throws IllegalArgumentException If the particle effect requires water
	 *             and none is at the center location
	 * @see ParticlePacket
	 * @see ParticlePacket#sendTo(Location, List)
	 */
	public void display(Vector direction, float speed, Location center, List<Player> players) throws ParticleVersionException, ParticleDataException, IllegalArgumentException {
		if (!isSupported()) {
			throw new ParticleVersionException("This particle effect is not supported by your server version");
		}
		if (requiresData) {
			throw new ParticleDataException("This particle effect requires additional data");
		}
		if (requiresWater && !isWater(center)) {
			throw new IllegalArgumentException("There is no water at the center location");
		}

		if (this == ParticleEffect.REDSTONE || this == ParticleEffect.RED_DUST) {
			Color color = Color.fromRGB((int)(direction.getX()), (int)(direction.getY()), (int)(direction.getZ()));
			center.getWorld().spawnParticle(mapParticleType(this), center, 1, direction.getX(), direction.getY(), direction.getZ(), speed, new Particle.DustOptions(color, 1));
		} else {
			center.getWorld().spawnParticle(mapParticleType(this), center, 1, direction.getX(), direction.getY(), direction.getZ(), speed, null);
		}

		//new ParticlePacket(this, direction, speed, isLongDistance(center, players), null).sendTo(center, players);
	}

	/**
	 * Displays a particle effect which requires additional data and is only
	 * visible for all players within a certain range in the world of @param
	 * center
	 * 
	 * @param data Data of the effect
	 * @param offsetX Maximum distance particles can fly away from the center on
	 *            the x-axis
	 * @param offsetY Maximum distance particles can fly away from the center on
	 *            the y-axis
	 * @param offsetZ Maximum distance particles can fly away from the center on
	 *            the z-axis
	 * @param speed Display speed of the particles
	 * @param amount Amount of particles
	 * @param center Center location of the effect
	 * @param range Range of the visibility
	 * @throws ParticleVersionException If the particle effect is not supported
	 *             by the server version
	 * @throws ParticleDataException If the particle effect does not require
	 *             additional data
	 * @see ParticlePacket
	 * @see ParticlePacket#sendTo(Location, double)
	 */
	public void display(ParticleData data, float offsetX, float offsetY, float offsetZ, float speed, int amount, Location center, double range) throws ParticleVersionException, ParticleDataException {
		if (!isSupported()) {
			throw new ParticleVersionException("This particle effect is not supported by your server version");
		}
		if (!requiresData) {
			throw new ParticleDataException("This particle effect does not require additional data");
		}

		if (data instanceof BlockData) {
			BlockData blockData = (BlockData)data;
			Material material = blockData.getMaterial();

			center.getWorld().spawnParticle(mapParticleType(this), center, amount, offsetX, offsetY, offsetZ, speed, material.createBlockData());
		} else if (data instanceof ItemData) {
			ItemData itemData = (ItemData)data;
			Material material = itemData.getMaterial();

			center.getWorld().spawnParticle(mapParticleType(this), center, amount, offsetX, offsetY, offsetZ, speed, new ItemStack(material));
		}

		//new ParticlePacket(this, offsetX, offsetY, offsetZ, speed, amount, range > 256, data).sendTo(center, range);
	}

	/**
	 * Displays a particle effect which requires additional data and is only
	 * visible for the specified players
	 * 
	 * @param data Data of the effect
	 * @param offsetX Maximum distance particles can fly away from the center on
	 *            the x-axis
	 * @param offsetY Maximum distance particles can fly away from the center on
	 *            the y-axis
	 * @param offsetZ Maximum distance particles can fly away from the center on
	 *            the z-axis
	 * @param speed Display speed of the particles
	 * @param amount Amount of particles
	 * @param center Center location of the effect
	 * @param players Receivers of the effect
	 * @throws ParticleVersionException If the particle effect is not supported
	 *             by the server version
	 * @throws ParticleDataException If the particle effect does not require
	 *             additional data
	 * @see ParticlePacket
	 * @see ParticlePacket#sendTo(Location, List)
	 */
	public void display(ParticleData data, float offsetX, float offsetY, float offsetZ, float speed, int amount, Location center, List<Player> players) throws ParticleVersionException, ParticleDataException {
		if (!isSupported()) {
			throw new ParticleVersionException("This particle effect is not supported by your server version");
		}
		if (!requiresData) {
			throw new ParticleDataException("This particle effect does not require additional data");
		}

		if (data instanceof BlockData) {
			BlockData blockData = (BlockData)data;
			Material material = blockData.getMaterial();

			center.getWorld().spawnParticle(mapParticleType(this), center, amount, offsetX, offsetY, offsetZ, speed, material.createBlockData());
		} else if (data instanceof ItemData) {
			ItemData itemData = (ItemData)data;
			Material material = itemData.getMaterial();

			center.getWorld().spawnParticle(mapParticleType(this), center, amount, offsetX, offsetY, offsetZ, speed, new ItemStack(material));
		}
		//new ParticlePacket(this, offsetX, offsetY, offsetZ, speed, amount, isLongDistance(center, players), data).sendTo(center, players);
	}

	/**
	 * Displays a single particle which requires additional data that flies into
	 * a determined direction and is only visible for all players within a
	 * certain range in the world of @param center
	 * 
	 * @param data Data of the effect
	 * @param direction Direction of the particle
	 * @param speed Display speed of the particles
	 * @param center Center location of the effect
	 * @param range Range of the visibility
	 * @throws ParticleVersionException If the particle effect is not supported
	 *             by the server version
	 * @throws ParticleDataException If the particle effect does not require
	 *             additional data
	 * @see ParticlePacket
	 * @see ParticlePacket#sendTo(Location, double)
	 */
	public void display(ParticleData data, Vector direction, float speed, Location center, double range) throws ParticleVersionException, ParticleDataException {
		if (!isSupported()) {
			throw new ParticleVersionException("This particle effect is not supported by your server version");
		}
		if (!requiresData) {
			throw new ParticleDataException("This particle effect does not require additional data");
		}

		if (data instanceof BlockData) {
			BlockData blockData = (BlockData)data;
			Material material = blockData.getMaterial();

			center.getWorld().spawnParticle(mapParticleType(this), center, 1, direction.getX(), direction.getY(), direction.getZ(), speed, material.createBlockData());
		} else if (data instanceof ItemData) {
			ItemData itemData = (ItemData)data;
			Material material = itemData.getMaterial();

			center.getWorld().spawnParticle(mapParticleType(this), center, 1, direction.getX(), direction.getY(), direction.getZ(), speed, new ItemStack(material));
		}

		//new ParticlePacket(this, direction, speed, range > 256, data).sendTo(center, range);
	}

	/**
	 * Displays a single particle which requires additional data that flies into
	 * a determined direction and is only visible for the specified players
	 * 
	 * @param data Data of the effect
	 * @param direction Direction of the particle
	 * @param speed Display speed of the particles
	 * @param center Center location of the effect
	 * @param players Receivers of the effect
	 * @throws ParticleVersionException If the particle effect is not supported
	 *             by the server version
	 * @throws ParticleDataException If the particle effect does not require
	 *             additional data
	 * @see ParticlePacket
	 * @see ParticlePacket#sendTo(Location, List)
	 */
	public void display(ParticleData data, Vector direction, float speed, Location center, List<Player> players) throws ParticleVersionException, ParticleDataException {
		if (!isSupported()) {
			throw new ParticleVersionException("This particle effect is not supported by your server version");
		}
		if (!requiresData) {
			throw new ParticleDataException("This particle effect does not require additional data");
		}

		if (data instanceof BlockData) {
			BlockData blockData = (BlockData)data;
			Material material = blockData.getMaterial();

			center.getWorld().spawnParticle(mapParticleType(this), center, 1, direction.getX(), direction.getY(), direction.getZ(), speed, material.createBlockData());
		} else if (data instanceof ItemData) {
			ItemData itemData = (ItemData)data;
			Material material = itemData.getMaterial();

			center.getWorld().spawnParticle(mapParticleType(this), center, 1, direction.getX(), direction.getY(), direction.getZ(), speed, new ItemStack(material));
		}
		//new ParticlePacket(this, direction, speed, isLongDistance(center, players), data).sendTo(center, players);
	}

	/**
	 * Represents the particle data for effects like
	 * {@link ParticleEffect#ITEM_CRACK}, {@link ParticleEffect#BLOCK_CRACK} and
	 * {@link ParticleEffect#BLOCK_DUST}
	 * <p>
	 * This class is part of the <b>ParticleEffect Library</b> and follows the
	 * same usage conditions
	 * 
	 * @author DarkBlade12
	 * @since 1.6
	 */
	public static abstract class ParticleData {
		private final Material material;
		private int[] packetData;

		/**
		 * Construct a new particle data
		 * 
		 * @param material Material of the item/block
		 * @param data Data value of the item/block
		 */
		@SuppressWarnings("deprecation")
		public ParticleData(Material material) {
			this.material = material;
			this.packetData = new int[] { material.getId() };
		}

		/**
		 * Returns the material of this data
		 * 
		 * @return The material
		 */
		public Material getMaterial() {
			return material;
		}

		/**
		 * Returns the data as an int array for packet construction
		 * 
		 * @return The data for the packet
		 */
		public int[] getPacketData() {
			return packetData;
		}

		/**
		 * Returns the data as a string for pre 1.8 versions
		 * 
		 * @return The data string for the packet
		 */
		public String getPacketDataString() {
			return "_" + packetData[0] + "_" + packetData[1];
		}

		/**
		 * Sets the packet data. Should be an integer array. For ITEM_CRACK and
		 * BLOCK_DUST, it should be [id, meta] but for BLOCK_CRACK it should be
		 * [id + (meta * 4096)]
		 * 
		 * @param data The packet data.
		 */
		public void setPacketData(int[] data) {
			packetData = data;
		}
	}

	/**
	 * Represents the item data for the {@link ParticleEffect#ITEM_CRACK} effect
	 * <p>
	 * This class is part of the <b>ParticleEffect Library</b> and follows the
	 * same usage conditions.
	 * 
	 * @author DarkBlade12
	 * @since 1.6
	 */
	public static final class ItemData extends ParticleData {
		/**
		 * Construct a new item data.
		 * 
		 * @param material Material of the item
		 * @param data Data value of the item
		 * @see ParticleData#ParticleData(Material, byte)
		 */
		public ItemData(Material material) {
			super(material);
		}
	}

	/**
	 * Represents the block data for the {@link ParticleEffect#BLOCK_CRACK} and
	 * {@link ParticleEffect#BLOCK_DUST} effects
	 * <p>
	 * This class is part of the <b>ParticleEffect Library</b> and follows the
	 * same usage conditions
	 *
	 * @author DarkBlade12
	 * @since 1.6
	 */
	public static final class BlockData extends ParticleData {
		/**
		 * Construct a new block data
		 *
		 * @param material Material of the block
		 * @param data Data value of the block
		 * @throws IllegalArgumentException If the material is not a block
		 * @see ParticleData#ParticleData(Material, byte)
		 */
		@SuppressWarnings("deprecation")
		public BlockData(Material material) throws IllegalArgumentException {
			super(material);
			if (!material.isBlock()) {
				throw new IllegalArgumentException("The material is not a block");
			}

			this.setPacketData(new int[] { material.getId() });
		}
	}

	/**
	 * Represents a runtime exception that is thrown if the displayed particle
	 * effect requires data and has none or vice-versa
	 * <p>
	 * This class is part of the <b>ParticleEffect Library</b> and follows the
	 * same usage conditions
	 * 
	 * @author DarkBlade12
	 * @since 1.6
	 */
	private static final class ParticleDataException extends RuntimeException {
		private static final long serialVersionUID = 3203085387160737484L;

		/**
		 * Construct a new particle data exception
		 * 
		 * @param message Message that will be logged
		 * @param cause Cause of the exception
		 */
		public ParticleDataException(String message) {
			super(message);
		}
	}

	/**
	 * Represents a runtime exception that is thrown if the displayed particle
	 * effect requires a newer version
	 * <p>
	 * This class is part of the <b>ParticleEffect Library</b> and follows the
	 * same usage conditions
	 * 
	 * @author DarkBlade12
	 * @since 1.6
	 */
	private static final class ParticleVersionException extends RuntimeException {
		private static final long serialVersionUID = 3203085387160737484L;

		/**
		 * Construct a new particle version exception
		 * 
		 * @param message Message that will be logged
		 * @param cause Cause of the exception
		 */
		public ParticleVersionException(String message) {
			super(message);
		}
	}

	/**
	 * Represents a particle effect packet with all attributes which is used for
	 * sending packets to the players
	 * <p>
	 * This class is part of the <b>ParticleEffect Library</b> and follows the
	 * same usage conditions
	 * 
	 * @author DarkBlade12
	 * @since 1.5
	 */
	@SuppressWarnings("unused")
	public static final class ParticlePacket {
		private static int version;
		private static Class<?> enumParticle;
		private static Constructor<?> packetConstructor;
		private static Method getHandle;
		private static Field playerConnection;
		private static Method sendPacket;
		private static boolean initialized;
		private final ParticleEffect effect;
		private final float offsetX;
		private final float offsetY;
		private final float offsetZ;
		private final float speed;
		private final int amount;
		private final boolean longDistance;
		private final ParticleData data;
		private Object packet;

		/**
		 * Construct a new particle packet
		 * 
		 * @param effect Particle effect
		 * @param offsetX Maximum distance particles can fly away from the
		 *            center on the x-axis
		 * @param offsetY Maximum distance particles can fly away from the
		 *            center on the y-axis
		 * @param offsetZ Maximum distance particles can fly away from the
		 *            center on the z-axis
		 * @param speed Display speed of the particles
		 * @param amount Amount of particles
		 * @param longDistance Indicates whether the maximum distance is
		 *            increased from 256 to 65536
		 * @param data Data of the effect
		 * @throws IllegalArgumentException If the speed is lower than 0 or the
		 *             amount is lower than 1
		 * @see #initialize()
		 */
		public ParticlePacket(ParticleEffect effect, float offsetX, float offsetY, float offsetZ, float speed, int amount, boolean longDistance, ParticleData data) throws IllegalArgumentException {
			initialize();
			if (speed < 0) {
				throw new IllegalArgumentException("The speed is lower than 0");
			}
			this.effect = effect;
			this.offsetX = offsetX;
			this.offsetY = offsetY;
			this.offsetZ = offsetZ;
			this.speed = speed;
			this.amount = amount;
			this.longDistance = longDistance;
			this.data = data;
		}

		/**
		 * Construct a new particle packet of a single particle flying into a
		 * determined direction
		 * 
		 * @param effect Particle effect
		 * @param direction Direction of the particle
		 * @param speed Display speed of the particle
		 * @param longDistance Indicates whether the maximum distance is
		 *            increased from 256 to 65536
		 * @param data Data of the effect
		 * @throws IllegalArgumentException If the speed is lower than 0
		 * @see #initialize()
		 */
		public ParticlePacket(ParticleEffect effect, Vector direction, float speed, boolean longDistance, ParticleData data) throws IllegalArgumentException {
			initialize();
			if (speed < 0) {
				throw new IllegalArgumentException("The speed is lower than 0");
			}
			this.effect = effect;
			this.offsetX = (float) direction.getX();
			this.offsetY = (float) direction.getY();
			this.offsetZ = (float) direction.getZ();
			this.speed = speed;
			this.amount = 0;
			this.longDistance = longDistance;
			this.data = data;
		}

		/**
		 * Initializes {@link #packetConstructor}, {@link #getHandle},
		 * {@link #playerConnection} and {@link #sendPacket} and sets
		 * {@link #initialized} to <code>true</code> if it succeeds
		 * <p>
		 * <b>Note:</b> These fields only have to be initialized once, so it
		 * will return if {@link #initialized} is already set to
		 * <code>true</code>
		 * 
		 * @throws VersionIncompatibleException if your bukkit version is not
		 *             supported by this library
		 */
		public static void initialize() throws VersionIncompatibleException {
			version = 13;
			/*if (initialized) {
				return;
			}
			try {
				version = Integer.parseInt(PackageType.getServerVersion().split("_")[1]);
				if (version > 7 && version < 13) {
					enumParticle = PackageType.MINECRAFT_SERVER.getClass("EnumParticle");
				} else if (version >= 13) {
					enumParticle = null;

				}
				Class<?> packetClass = PackageType.MINECRAFT_SERVER.getClass(version < 7 ? "Packet63WorldParticles" : "PacketPlayOutWorldParticles");
				packetConstructor = ReflectionHandler.getConstructor(packetClass);
				getHandle = ReflectionHandler.getMethod("CraftPlayer", PackageType.CRAFTBUKKIT_ENTITY, "getHandle");
				playerConnection = ReflectionHandler.getField("EntityPlayer", PackageType.MINECRAFT_SERVER, false, "playerConnection");
				sendPacket = ReflectionHandler.getMethod(playerConnection.getType(), "sendPacket", PackageType.MINECRAFT_SERVER.getClass("Packet"));
			}
			catch (Exception exception) {
				exception.printStackTrace();
				throw new VersionIncompatibleException("Your current bukkit version seems to be incompatible with this library", exception);
			}*/
			initialized = true;
		}

		/**
		 * Returns the version of your server (1.x)
		 * 
		 * @return The version number
		 */
		public static int getVersion() {
			return version;
		}

		/**
		 * Determine if {@link #packetConstructor}, {@link #getHandle},
		 * {@link #playerConnection} and {@link #sendPacket} are initialized
		 * 
		 * @return Whether these fields are initialized or not
		 * @see #initialize()
		 */
		public static boolean isInitialized() {
			return initialized;
		}

		/**
		 * Sends the packet to a single player and caches it
		 * 
		 * @param center Center location of the effect
		 * @param player Receiver of the packet
		 * @throws PacketInstantiationException if instantion fails due to an
		 *             unknown error
		 * @throws PacketSendingException if sending fails due to an unknown
		 *             error
		 */
		public void sendTo(Location center, Player player) throws PacketInstantiationException, PacketSendingException {

			/*if (packet == null) {
				try {
					packet = packetConstructor.newInstance();
					Object id;
					if (version < 8) {
						id = effect.getName();
						if (data != null) {
							id += data.getPacketDataString();
						}
					} else {
						id = enumParticle.getEnumConstants()[effect.getId()];
					}
					ReflectionHandler.setValue(packet, true, "a", id);
					ReflectionHandler.setValue(packet, true, "b", (float) center.getX());
					ReflectionHandler.setValue(packet, true, "c", (float) center.getY());
					ReflectionHandler.setValue(packet, true, "d", (float) center.getZ());
					ReflectionHandler.setValue(packet, true, "e", offsetX);
					ReflectionHandler.setValue(packet, true, "f", offsetY);
					ReflectionHandler.setValue(packet, true, "g", offsetZ);
					ReflectionHandler.setValue(packet, true, "h", speed);
					ReflectionHandler.setValue(packet, true, "i", amount);
					if (version > 7) {
						ReflectionHandler.setValue(packet, true, "j", longDistance);
						ReflectionHandler.setValue(packet, true, "k", data == null ? new int[0] : data.getPacketData());
					}
				}
				catch (Exception exception) {
					throw new PacketInstantiationException("Packet instantiation failed", exception);
				}
			}
			try {
				sendPacket.invoke(playerConnection.get(getHandle.invoke(player)), packet);
			}
			catch (Exception exception) {
				throw new PacketSendingException("Failed to send the packet to player '" + player.getName() + "'", exception);
			}*/
		}

		/**
		 * Sends the packet to all players in the list
		 * 
		 * @param center Center location of the effect
		 * @param players Receivers of the packet
		 * @throws IllegalArgumentException If the player list is empty
		 * @see #sendTo(Location center, Player player)
		 */
		public void sendTo(Location center, List<Player> players) throws IllegalArgumentException {
			if (players.isEmpty()) {
				throw new IllegalArgumentException("The player list is empty");
			}
			for (Player player : players) {
				sendTo(center, player);
			}
		}

		/**
		 * Sends the packet to all players in a certain range
		 * 
		 * @param center Center location of the effect
		 * @param range Range in which players will receive the packet (Maximum
		 *            range for particles is usually 16, but it can differ for
		 *            some types)
		 * @throws IllegalArgumentException If the range is lower than 1
		 * @see #sendTo(Location center, Player player)
		 */
		public void sendTo(Location center, double range) throws IllegalArgumentException {
			if (range < 1) {
				throw new IllegalArgumentException("The range is lower than 1");
			}
			
			double squared = range * range;
			for (Player player : Bukkit.getOnlinePlayers()) {
				if (player.getWorld() != center.getWorld() || player.getLocation().distanceSquared(center) > squared) {
					continue;
				}
				sendTo(center, player);
			}
		}

		/**
		 * Represents a runtime exception that is thrown if a bukkit version is
		 * not compatible with this library
		 * <p>
		 * This class is part of the <b>ParticleEffect Library</b> and follows
		 * the same usage conditions
		 * 
		 * @author DarkBlade12
		 * @since 1.5
		 */
		private static final class VersionIncompatibleException extends RuntimeException {
			private static final long serialVersionUID = 3203085387160737484L;

			/**
			 * Construct a new version incompatible exception
			 * 
			 * @param message Message that will be logged
			 * @param cause Cause of the exception
			 */
			public VersionIncompatibleException(String message, Throwable cause) {
				super(message, cause);
			}
		}

		/**
		 * Represents a runtime exception that is thrown if packet instantiation
		 * fails
		 * <p>
		 * This class is part of the <b>ParticleEffect Library</b> and follows
		 * the same usage conditions
		 * 
		 * @author DarkBlade12
		 * @since 1.4
		 */
		private static final class PacketInstantiationException extends RuntimeException {
			private static final long serialVersionUID = 3203085387160737484L;

			/**
			 * Construct a new packet instantiation exception
			 * 
			 * @param message Message that will be logged
			 * @param cause Cause of the exception
			 */
			public PacketInstantiationException(String message, Throwable cause) {
				super(message, cause);
			}
		}

		/**
		 * Represents a runtime exception that is thrown if packet sending fails
		 * <p>
		 * This class is part of the <b>ParticleEffect Library</b> and follows
		 * the same usage conditions
		 * 
		 * @author DarkBlade12
		 * @since 1.4
		 */
		private static final class PacketSendingException extends RuntimeException {
			private static final long serialVersionUID = 3203085387160737484L;

			/**
			 * Construct a new packet sending exception
			 * 
			 * @param message Message that will be logged
			 * @param cause Cause of the exception
			 */
			public PacketSendingException(String message, Throwable cause) {
				super(message, cause);
			}
		}
	}
}