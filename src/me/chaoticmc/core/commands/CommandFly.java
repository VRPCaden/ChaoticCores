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
				p.setFlying(false);
				sender.sendMessage(Chat.f("&4&l[&6&lFly&f&l]&6&l Fly Disabled"));
				return false;
			}else{
				p.setFlying(true);
				sender.sendMessage(Chat.f("&4&l[&6&lFly&f&l]&6&l Fly Enabled"));
				return false;
			}
		}else{
			sender.sendMessage(Chat.f("&4You dont have permissions"));
			return false;
		}
	}
}
