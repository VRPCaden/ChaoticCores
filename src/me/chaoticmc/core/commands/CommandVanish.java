package me.chaoticmc.core.commands;


import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.chaoticmc.core.util.Chat;

public class CommandVanish implements CommandExecutor{

	ArrayList<Player> vanished = new ArrayList<Player>();


	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] a) {
		if(!(sender instanceof Player)){
			sender.sendMessage(Chat.f("&4Please use as player"));
			return false;
		}else{
			if(cmd.getName().equalsIgnoreCase("v")) {
				if(sender.hasPermission("chaoticmc.command.vanish")){
					Player p = (Player) sender;

				
			

					for(Player players : Bukkit.getOnlinePlayers()){
						if(vanished.contains(p)){
							vanished.remove(p);
							players.showPlayer(p);
							sender.sendMessage(Chat.f("&aVanish&7 » &7You are now &cUn-Vanished"));
							return false;
						}
						if(!vanished.contains(p)){
							vanished.add(p);
							players.hidePlayer(p);
							sender.sendMessage(Chat.f("&aVanish&7 » &7You are now &aVanished"));
							return false;
						}

					}
				}else{
					sender.sendMessage(Chat.f("&cPermission&8 Â» &7You do not have permissions for this action."));
					return false;
				}
<<<<<<< HEAD
			}else{
				sender.sendMessage(Chat.f("&cPermission&8 � &7You do not have permissions for this action."));
				return false;
=======
>>>>>>> ecc02820ebae62e9b69a3365060edb4c83115972
			}
		}
		return false;
	}
}
