package me.michaelkrauty.TeleportTo;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class TeleportTo extends JavaPlugin {
	
	public static final Logger log = Logger.getLogger("Minecraft");
		
	@Override
	public void onEnable() {
		log.info("[TeleportTo] Teleportation on standby!");
	}

	@Override
	public void onDisable() {
		log.info("[TeleportTo] Teleportion disabled!");
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		Player player = (Player) sender;
		if (args.length != 1) {
			sender.sendMessage(ChatColor.RED + "Usage: /to <player>");
			return true;
		}
		
		Player teleport = this.getServer().getPlayer(args[0]);
		
		if(teleport == null) {
			sender.sendMessage(ChatColor.RED + "Player " + args[0] + " is not online.");
			return true;
			
		}
		
		if(commandLabel.equalsIgnoreCase("to")) {
			Player targetPlayer = player.getServer().getPlayer(args[0]);
			Location targetPlayerLocation = targetPlayer.getLocation();
			sender.sendMessage(ChatColor.GOLD + "Teleported to " + targetPlayer.getName());
			player.teleport(targetPlayerLocation);
			return true;
		}
		
		return false;
		
	}
	
}
