package me.chaoticmc.core.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.chaoticmc.core.util.Chat;

public class CommandVanish implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] a) {
		if(!(sender instanceof Player)){
			sender.sendMessage(Chat.f("&4Please use as player"));
			return false;
		}else{
			if(sender.hasPermission("chaoticmc.command.vanish")){
				ArrayList<Player> vanished = new ArrayList<Player>();
				Player p = (Player) sender;
				for(Player players: Bukkit.getServer().getOnlinePlayers()){
					if(vanished.contains(p)){
						players.showPlayer(p);
						vanished.remove(p);
						sender.sendMessage(Chat.f("&aVanish&7 » &7You are now &cUn-Vanished"));
						return false;
					}else{
						players.hidePlayer(p);
						vanished.add(p);
						sender.sendMessage(Chat.f("&aVanish&7 » &7You are now &aVanished"));
						return false;
					}
				}
			}else{
				sender.sendMessage(Chat.f("&cPermission&8 Â» &7You do not have permissions for this action."));
				return false;
			}
		}
		return false;
	}

}
