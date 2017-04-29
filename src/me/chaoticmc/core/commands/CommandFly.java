package me.chaoticmc.core.commands;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.chaoticmc.core.util.Chat;

public class CommandFly implements CommandExecutor{
	ArrayList<Player> flying = new ArrayList<Player>();
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] a) {
		if(sender instanceof Player) {
			
			if(cmd.getName().equalsIgnoreCase("fly")) {
				Player p = (Player) sender;
				if(p.isOp() == true || p.hasPermission("chaoticmc.command.fly")){
					if(flying.contains(p)){
						p.setAllowFlight(false);
						flying.remove(p);
						sender.sendMessage(Chat.f("&aFlight&8 » &7Your fly mode has been &cdisabled"));
						return true;
					}else{
						flying.add(p);
						p.setAllowFlight(true);
						sender.sendMessage(Chat.f("&aFlight&8 » &7Your fly mode has been &aenabled"));
						return true;
					}
				}else{
					sender.sendMessage(Chat.f("&cPermission&8 » &7You do not have permissions for this action."));
					return false;
				}
			}
		}else{
			sender.sendMessage(Chat.f("&4Error> &cLogin to use this command!"));
		}
		return false;
	}
}
