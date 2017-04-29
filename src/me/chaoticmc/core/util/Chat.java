package me.chaoticmc.core.util;

import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class Chat {
	
	public static String f(String input) {
		return ChatColor.translateAlternateColorCodes('&', input);
	}
	public static void color(Player p, String input) {
		p.sendMessage(f(input));
	}

}
