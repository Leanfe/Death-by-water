package org.kelsi;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.kelsi.commands.reloadCMD;

public final class WaterDead extends JavaPlugin implements Listener {

    boolean enabled = getConfig().getBoolean("plugin.enabled");

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults(true);
        saveConfig();
        reloadConfig();
        
        getServer().getPluginManager().registerEvents(this, this);
        getCommand("wdreload").setExecutor(new ReloadCMD());
    }

    @Override
    public void onDisable() {
        super();
    }

    @EventHandler
    public void onPlayerMove(final PlayerMoveEvent event) {
        if (!enabled) return;
        if (event.getPlayer().getLocation().getBlock().getType() == Material.WATER) {
            event.getPlayer().damage(getConfig().getDouble("plugin.damage"));
        }
    }
}
