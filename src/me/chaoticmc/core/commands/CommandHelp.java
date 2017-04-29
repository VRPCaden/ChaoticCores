package me.chaoticmc.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.chaoticmc.core.util.Chat;

public class CommandHelp implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] a) {
		if(!(sender instanceof Player)){
			sender.sendMessage(Chat.f("&4Please use as player"));
		}
		if(cmd.getName().equalsIgnoreCase("help")) {
			Player p = (Player) sender;
			Chat.color(p, "&aHelp for &6ChaoticCore");
			Chat.color(p, "&9/help &8- &7Returns this. - &7Have permission: &a&lTRUE");
			
		}
		return false;
	}

}
