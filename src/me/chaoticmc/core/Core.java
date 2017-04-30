package me.chaoticmc.core;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import me.chaoticmc.core.commands.CommandFly;
import me.chaoticmc.core.commands.CommandGamemode;
import me.chaoticmc.core.commands.CommandGod;
import me.chaoticmc.core.commands.CommandHelp;
import me.chaoticmc.core.commands.CommandVanish;
import me.chaoticmc.core.events.Events;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

public class Core extends JavaPlugin {
	Plugin plugin;
	
	public void registerCommands() {
		getCommand("help").setExecutor(new CommandHelp());
		getCommand("gm").setExecutor(new CommandGamemode());
		getCommand("gmc").setExecutor(new CommandGamemode());
		getCommand("gms").setExecutor(new CommandGamemode());
		getCommand("fly").setExecutor(new CommandFly());
	    getCommand("god").setExecutor(new CommandGod());
	    getCommand("v").setExecutor(new CommandVanish());
	}
	
	public void registerEvents() {
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new Events(), this);
		pm.registerEvents(new CommandGod(), this);
	}
	public static Permission permission = null;
    public static Economy economy = null;
    public static Chat chat = null;

    private boolean setupPermissions()
    {
        RegisteredServiceProvider<Permission> permissionProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.permission.Permission.class);
        if (permissionProvider != null) {
            permission = permissionProvider.getProvider();
        }
        return (permission != null);
    }

    private boolean setupChat()
    {
        RegisteredServiceProvider<Chat> chatProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.chat.Chat.class);
        if (chatProvider != null) {
            chat = chatProvider.getProvider();
        }

        return (chat != null);
    }

    private boolean setupEconomy()
    {
        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) {
            economy = economyProvider.getProvider();
        }

        return (economy != null);
    }
	public void onEnable(){
		setupEconomy();
		setupPermissions();
		setupChat();
		registerEvents();
		registerCommands();
		plugin = this;
		PluginDescriptionFile pdfFile = getDescription();
		Logger logger = getLogger();
		logger.info(pdfFile.getName() + " Enabled!");
	}
	
	public void onDisable() {
		plugin = null;
		PluginDescriptionFile pdfFile = getDescription();
		Logger logger = getLogger();
		logger.info(pdfFile.getName() + " Disabled!");
	}
	
	
}
