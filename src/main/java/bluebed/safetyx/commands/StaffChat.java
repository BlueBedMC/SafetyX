package bluebed.safetyx.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StaffChat implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        if (args.length > 0) {
            StringBuilder messageBuilder = new StringBuilder();
            for (int i = 0; i < args.length; i++) {
                messageBuilder.append(args[i]).append(" ");
            }
            String message = messageBuilder.substring(0, messageBuilder.length() - 1);
            Bukkit.broadcast(ChatColor.RED + "Staff Chat" + ChatColor.WHITE + " | " + player.getDisplayName() + ChatColor.RED + " > " + ChatColor.WHITE + message, "safteyx.staffchat");
        } else {
            player.sendMessage(ChatColor.RED + "Wrong usage! /staffchat <message>");
        }

        return true;
    }
}
