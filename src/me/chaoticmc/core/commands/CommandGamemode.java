package me.chaoticmc.core.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.chaoticmc.core.util.Chat;

public class CommandGamemode implements CommandExecutor{
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] a) {
		if(!(sender instanceof Player)){
			sender.sendMessage(Chat.f("&4Please use as player"));
			return false;
		}else{
			if(sender.isOp() || sender.hasPermission("")){
				
			}else{
				sender.sendMessage(Chat.f("&4You dont have permissions"));
			}
		}
		return false;
	}
}
