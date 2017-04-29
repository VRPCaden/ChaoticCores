package me.chaoticmc.core.commands;

import org.bukkit.GameMode;
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
			if(cmd.equals("gm")){
				if(sender.isOp() || sender.hasPermission("chaoticmc.command.gamemode")){
					Player p = (Player) sender;
					if(p.getGameMode() == GameMode.CREATIVE){
						p.setGameMode(GameMode.SURVIVAL);
						sender.sendMessage(Chat.f("&4&l[&6&lGamemode&f&l]&6&l Gamemode set to Survival"));
						return false;
					}else{
						p.setGameMode(GameMode.CREATIVE);
						sender.sendMessage(Chat.f("&4&l[&6&lGamemode&f&l]&6&l Gamemode set to Creative"));
						return false;
					}
				}else{
					sender.sendMessage(Chat.f("&4You dont have permissions"));
					return false;
				}
			}
			if(cmd.equals("gms")){
				if(sender.isOp() || sender.hasPermission("chaoticmc.command.gamemode")){
					Player p = (Player) sender;
					p.setGameMode(GameMode.SURVIVAL);
					sender.sendMessage(Chat.f("&4&l[&6&lGamemode&f&l]&6&l Gamemode set to Survival"));
					return false;
				}else{
					sender.sendMessage(Chat.f("&4You dont have permissions"));
					return false;
				}
			}
			if(cmd.equals("gmc")){
				if(sender.isOp() || sender.hasPermission("chaoticmc.command.gamemode")){
					Player p = (Player) sender;
					p.setGameMode(GameMode.CREATIVE);
					sender.sendMessage(Chat.f("&4&l[&6&lGamemode&f&l]&6&l Gamemode set to Creative"));
					return false;
				}else{
					sender.sendMessage(Chat.f("&4You dont have permissions"));
					return false;
				}
			}
		}
		return false;
	}
}