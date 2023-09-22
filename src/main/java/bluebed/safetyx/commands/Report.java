package bluebed.safetyx.commands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Report implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length > 0) {
                String targetName = args[0];
                Player target = Bukkit.getPlayer(targetName);
                if (target != null) {
                    if (args.length > 1) {
                        StringBuilder message = new StringBuilder();
                        for (int i = 1; i < args.length; i++) {
                            message.append(args[i]).append(" ");
                        }
                        String reason = message.substring(0, message.length() - 1);
                        String forOpwithReason = ChatColor.RED + p.getName() + ChatColor.WHITE + " has reported " + ChatColor.RED + targetName + ChatColor.WHITE + " for the reason " + ChatColor.RED + reason;
                        Bukkit.broadcast(forOpwithReason, "safetyx.seereports");
                        p.sendMessage("You have reported " + ChatColor.RED + targetName + ChatColor.WHITE + " for " + ChatColor.RED + reason);
                    } else {
                        String forOpwithoutReason = ChatColor.BLUE + p.getName() + ChatColor.WHITE + " has reported " + ChatColor.RED + targetName + ChatColor.WHITE + " with no reason.";
                        Bukkit.broadcast(forOpwithoutReason, "safetyx.seereports");
                        p.sendMessage("You have reported " + ChatColor.RED + targetName + ChatColor.WHITE + " with no reason.");
                    }
                } else {
                    p.sendMessage(ChatColor.RED + "Please add an online player! /report <player> <reason>");
                }
            } else {
                p.sendMessage(ChatColor.RED + "Please add a player! /report <player> <reason>");
            }
        } else {
            System.out.println("You are console! You cannot report players!!!");
        }
        return true;
    }
}
