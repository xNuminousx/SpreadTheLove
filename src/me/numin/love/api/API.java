package me.numin.love.api;

public class API {
	
	public static boolean enableLGBT;
	public static boolean playTrail = false;
	
	public enum TrailType {
		MOVE, STILL, SNEAK
	}
	
	public static boolean enableLGBT() {
		return enableLGBT;
	}
	public static boolean enableLGBT(boolean arg) {
		enableLGBT = arg;
		return enableLGBT;
	}

}
