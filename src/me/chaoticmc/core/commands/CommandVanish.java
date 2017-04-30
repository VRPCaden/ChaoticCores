package me.chaoticmc.core.commands;

<<<<<<< HEAD
=======
import java.util.ArrayList;

>>>>>>> 64bf9520c8fad2c50ee0bcd3eec167f91969bff4
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.chaoticmc.core.util.Chat;

public class CommandVanish implements CommandExecutor{
<<<<<<< HEAD
=======
	ArrayList<Player> vanished = new ArrayList<Player>();
>>>>>>> 64bf9520c8fad2c50ee0bcd3eec167f91969bff4

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] a) {
		if(!(sender instanceof Player)){
			sender.sendMessage(Chat.f("&4Please use as player"));
			return false;
		}else{
			if(sender.hasPermission("chaoticmc.command.vanish")){
				Player p = (Player) sender;
<<<<<<< HEAD
				Bukkit.getOnlinePlayers(){
					
=======
				for(Player players: Bukkit.getOnlinePlayers()){
					if(vanished.contains(p)){
						vanished.remove(p);
						players.showPlayer(p);
						sender.sendMessage(Chat.f("&aVanish&7 » &7You are now &cUn-Vanished"));
						return false;
					}
					if(!vanished.contains(p)){
						vanished.add(p);
						players.hidePlayer(p);
						sender.sendMessage(Chat.f("&aVanish&7 » &7You are now &aVanished"));
						return false;
					}
>>>>>>> 64bf9520c8fad2c50ee0bcd3eec167f91969bff4
				}
			}else{
				sender.sendMessage(Chat.f("&cPermission&8 Â» &7You do not have permissions for this action."));
				return false;
			}
		}
		return false;
	}

}
