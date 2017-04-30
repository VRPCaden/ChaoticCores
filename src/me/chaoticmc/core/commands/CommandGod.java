package me.chaoticmc.core.commands;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import me.chaoticmc.core.util.Chat;

public class CommandGod implements CommandExecutor, Listener {
	
	public static ArrayList<Player> god = new ArrayList<Player>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(Chat.f("&4Error &8» &cYou must be logged in to use this command."));
		}
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("god")) {
			if(p.hasPermission("chaoticmc.command.god")) {
				if(!(god.contains(p))) {
					god.add(p);
					Chat.color(p, "&aGodmode &8» &7Your god mode has been &aenabled&7.");
					
				}else{
					god.remove(p);
					Chat.color(p, "&cGodmode &8» &7Your god mode has been &cdisabled&7.");
				}
			}
		}
		return false;
	}
	
	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		if(e.getEntity() instanceof Player) {
			if(god.contains(e.getEntity())) {
				e.setCancelled(true);
			}
			
		}
	}

}
