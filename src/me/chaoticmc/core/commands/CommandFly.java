package me.chaoticmc.core.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.chaoticmc.core.util.Chat;

public class CommandFly implements CommandExecutor{
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] a) {
		Player p = (Player) sender;
		if(p.isOp() == true || p.hasPermission("chaoticmc.command.fly")){
			if(p.isFlying() == true){
				p.setAllowFlight(false);
				sender.sendMessage(Chat.f("&aFlight&8 » &7Your fly mode has been &cdisabled"));
				return false;
			}else{
				p.setAllowFlight(true);
				sender.sendMessage(Chat.f("&aFlight&8 » &7Your fly mode has been &aenabled"));
				return false;
			}
		}else{
			sender.sendMessage(Chat.f("&cPermission&8 » &7You do not have permissions for this action."));
			return false;
		}
	}
}
