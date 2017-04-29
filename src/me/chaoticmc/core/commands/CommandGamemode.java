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

			
			
			if(cmd.getName().equalsIgnoreCase("gm")){
				if(sender.isOp() || sender.hasPermission("chaoticmc.command.gamemode")){
					Player p = (Player) sender;
					if(p.getGameMode() == GameMode.CREATIVE){
						p.setGameMode(GameMode.SURVIVAL);
						sender.sendMessage(Chat.f("&aGamemode&8 » &7Your gamemode was set to &cSurvival Mode&7."));
						return false;
					}else{
						p.setGameMode(GameMode.CREATIVE);
						sender.sendMessage(Chat.f("&aGamemode&8 » &7Your gamemode was set to &aCreative Mode&7."));
						return false;
					}
				}else{
					sender.sendMessage(Chat.f("&cPermission&8 » &7You do not have permissions for this action."));
					return false;
				}
			}
			if(cmd.getName().equalsIgnoreCase("gms")){
				if(sender.isOp() || sender.hasPermission("chaoticmc.command.gamemode")){
					Player p = (Player) sender;
					p.setGameMode(GameMode.SURVIVAL);
					sender.sendMessage(Chat.f("&aGamemode&8 » &7Your gamemode was set to &cSurvival Mode&7."));
					
				}else{
					sender.sendMessage(Chat.f("&cPermission&8 » &7You do not have permissions for this action."));
					
				}
			}
			if(cmd.getName().equalsIgnoreCase("gmc")){
				if(sender.isOp() || sender.hasPermission("chaoticmc.command.gamemode")){
					Player p = (Player) sender;
					p.setGameMode(GameMode.CREATIVE);
					sender.sendMessage(Chat.f("&aGamemode&8 » &7Your gamemode was set to &aCreative Mode&7."));
					return false;
				}else{
					sender.sendMessage(Chat.f("&cPermission&8 » &7You do not have permissions for this action."));
					return false;
				}
			}

		}
		return false;
	}
}