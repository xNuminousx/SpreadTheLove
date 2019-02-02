package me.numin.love.gui;

import java.lang.reflect.InvocationTargetException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import me.numin.love.actions.Hug;
import me.numin.love.api.API;
import me.numin.love.utils.AnvilGUI;
import me.numin.love.utils.AnvilGUI.AnvilClickEvent;

public class GUIListener implements Listener {
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		Player player = (Player)event.getWhoClicked();
		
		if (event.getInventory().getName() != GUI.guiName) {
			return;
		
		} else if (event.getCurrentItem() == null || event.getCurrentItem().getItemMeta() == null || event.getCurrentItem().getItemMeta().getDisplayName().equals(null)) {
			event.setCancelled(true);
			return;
		} else if (event.getCurrentItem().getItemMeta().getDisplayName().contains("To Hug")) {
			event.setCancelled(true);
			
			GUI.openAnvil(player);
            AnvilGUI gui = new AnvilGUI(player, new AnvilGUI.AnvilClickEventHandler() {

				@Override
				public void onAnvilClick(AnvilClickEvent event) {
					if (event.getSlot() == AnvilGUI.AnvilSlot.OUTPUT) {
						event.setWillClose(true);
						event.setWillDestroy(true);
						
						for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
							if (onlinePlayer.getName().equalsIgnoreCase(event.getName())) {
								new Hug(player, onlinePlayer);
							} else {
								onlinePlayer.sendMessage(ChatColor.DARK_RED + "♡ " + ChatColor.RED + "The player may be offline or does not exist.");
							}
						}
					} else {
						event.setWillClose(false);
						event.setWillDestroy(false);
					}
				}
            	
            });
            gui.setSlot(AnvilGUI.AnvilSlot.INPUT_LEFT, API.createItem(Material.PAPER, "Enter Name"));
            
            try {
                gui.open();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
			return;
		} else {
			event.setCancelled(true);
			return;
		}
	}
	
}
