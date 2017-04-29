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
			return false;
		}
		if(cmd.getName().equalsIgnoreCase("help")) {
			Player p = (Player) sender;
			Chat.color(p, "&aHelp for &6ChaoticCore");
			Chat.color(p, "&9/help &8- &7Returns this. - &7Have permission: &a&lTRUE");
<<<<<<< HEAD
			Chat.color(p, "&cSome commands are hidden because you have no permission. ");
=======
			Chat.color(p, "&9/gm &8- Toggles your gamemode");
			Chat.color(p, "&9/gmc &8- Puts you in creative");
			Chat.color(p, "&9/gms &8- Puts you in surival");
			Chat.color(p, "&9/fly &8- Turns fly on/off");
			return false;
>>>>>>> f3bfe04ee7d584c4e576b3c7e9cf15ceea62a6d0
		}
		return false;
	}

}
