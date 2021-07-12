package me.igormgs.others;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import me.igormgs.Main;
import me.igormgs.timers.Stats;

public class BorderMove implements Listener
{
    @EventHandler
    public void ForcefieldDamagePositive(final PlayerMoveEvent e) {
        final Player p = e.getPlayer();
        final Location loc = p.getLocation();
        final World w = p.getWorld();
        if (w.getSpawnLocation().getWorld().setSpawnLocation(0, 120, 0) && (Math.abs(loc.getBlockX() + w.getSpawnLocation().getBlockX()) >= 500 || Math.abs(loc.getBlockZ() + w.getSpawnLocation().getBlockZ()) >= 500) && Main.participando.contains(p.getName())) {
            p.setFireTicks(500);
            p.damage(8.5);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                }
            }, 80L);
        }
    }
    
    @EventHandler
    public void ForcefieldDamagePositive2(final PlayerMoveEvent e) {
        if (Main.stats == Stats.AGUARDANDO_JOGADORES) {
            final Player p = e.getPlayer();
            final Location loc = p.getLocation();
            final World w = p.getWorld();
            if (w.getSpawnLocation().getWorld().setSpawnLocation(0, 120, 0) && (Math.abs(loc.getBlockX() + w.getSpawnLocation().getBlockX()) >= 30 || Math.abs(loc.getBlockZ() + w.getSpawnLocation().getBlockZ()) >= 30) && Main.participando.contains(p.getName())) {
                Bukkit.getServer().getWorld("world");
                Location teleportLocation = null;
                final int x = 2;
                int y = 75;
                final int z = -2;
                boolean isOnLand = false;
                while (!isOnLand) {
                    teleportLocation = new Location(p.getWorld(), (double)x, (double)y, (double)z);
                    if (teleportLocation.getBlock().getType() != Material.AIR) {
                        isOnLand = true;
                    }
                    else {
                        --y;
                    }
                }
                p.teleport(new Location(p.getWorld(), teleportLocation.getX(), teleportLocation.getY() + 1.0, teleportLocation.getZ()));
            }
        }
    }
}
