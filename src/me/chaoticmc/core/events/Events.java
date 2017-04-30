package me.chaoticmc.core.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.chaoticmc.core.Core;
import me.chaoticmc.core.util.Chat;

public class Events implements Listener {
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		if(e.getPlayer().hasPermission("chaoticmc.chat.color")) {
			Chat.f(e.getMessage());
		}else{
			if(e.getMessage().contains("&")) {
				e.getPlayer().sendMessage(Chat.f("&4&lACCESS: &cYou do not have access to this action."));
			}
		}
		if(Core.permission.getPrimaryGroup(e.getPlayer()).equals("Owner")) {
			e.setFormat(Chat.f("&8[&4&lOwner&8] &4" + e.getPlayer().getName() + " &8» &b" + e.getMessage()));
		}
	}
}
