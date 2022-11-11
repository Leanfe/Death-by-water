package org.kelsi.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class ReloadCMD implements CommandExecutor {

    Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("WaterDead");

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            plugin.reloadConfig();
            return true;
        }
        
        Player player = (Player)sender;

        if (player.hasPermission("wd.reload")) {
            plugin.reloadConfig();
            plugin.saveConfig();
            player.sendMessage("Plugin has reloaded!");
            return true;
        }
        
        player.sendMessage("[ERROR] ReloadCMD has crashed!");
        return false;
    }
}
