package me.chaoticmc.core.commands;

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
				Player p = (Player) sender;
				Bukkit.getOnlinePlayers(){
					
				}
			}else{
				sender.sendMessage(Chat.f("&cPermission&8 » &7You do not have permissions for this action."));
				return false;
			}
		}
		return false;
	}

}
