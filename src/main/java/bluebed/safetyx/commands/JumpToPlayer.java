package bluebed.safetyx.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class JumpToPlayer implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length > 0) {
                String targetName = args[0];
                Player target = Bukkit.getPlayer(targetName);
                if (target != null) {
                    player.sendMessage("Jumping to " + ChatColor.RED + targetName);
                    Location loc = target.getLocation();
                    player.teleport(loc);
                } else {
                    player.sendMessage(ChatColor.RED + "You need to add a online player! /jtp <player> ");
                }
            } else {
                player.sendMessage(ChatColor.RED + "You need to add a player name! /jtp <player>");
            }
        } else {
            System.out.println("You cannot jump to players! You are console!");
        }

        return true;
    }
}
