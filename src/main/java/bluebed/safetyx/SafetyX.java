package bluebed.safetyx;

import bluebed.safetyx.commands.JumpToPlayer;
import bluebed.safetyx.commands.Report;
import bluebed.safetyx.commands.StaffChat;
import org.bukkit.plugin.java.JavaPlugin;

public final class SafetyX extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Starting SafetyX");
        this.getCommand("report").setExecutor(new Report());
        this.getCommand("jtp").setExecutor(new JumpToPlayer());
        this.getCommand("staffchat").setExecutor(new StaffChat());
        System.out.println("Loaded SafetyX Successfully");
    }

    @Override
    public void onDisable() {
        System.out.println("Shutting down SafetyX");
    }
}
