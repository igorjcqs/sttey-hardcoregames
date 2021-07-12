package me.igormgs.others;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDamageEvent;

import me.igormgs.Main;
import me.igormgs.timers.Stats;

public class WorldBorder
{
    private static Integer shed_id;
    private static HashMap<Player, Location> locations;
    public static HashMap<BorderType, Border> BORDERS;
    
    static {
        WorldBorder.shed_id = null;
        WorldBorder.locations = new HashMap<Player, Location>();
        WorldBorder.BORDERS = new HashMap<BorderType, Border>();
    }
    
    private static boolean inBorderCheck(final Location checkHere, final BorderType t) {
        if (!WorldBorder.BORDERS.containsKey(t)) {
            return true;
        }
        final Border border = WorldBorder.BORDERS.get(t);
        return checkHere.getX() <= border.radius && checkHere.getZ() <= border.radius && checkHere.getX() >= -border.radius && checkHere.getZ() >= -border.radius;
    }
    
    public static boolean inBorder(final Location c, final BorderType t) {
        if (t == BorderType.STOP) {
            return inBorderCheck(c, BorderType.STOP);
        }
        if (t == BorderType.WARN) {
            return inBorderCheck(c, BorderType.WARN) || !inBorderCheck(c, BorderType.STOP);
        }
        return t != BorderType.SHRINK || !WorldBorder.BORDERS.containsKey(BorderType.SHRINK) || inBorderCheck(c, BorderType.SHRINK);
    }
    
    public static void WorldBorderMove() {
        WorldBorder.shed_id = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.plugin, (Runnable)new Runnable() {
            @SuppressWarnings("deprecation")
			@Override
            public void run() {
                Player[] arrayOfPlayer;
                for (int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length, i = 0; i < j; ++i) {
                    final Player p = arrayOfPlayer[i];
                    if (!WorldBorder.inBorder(p.getLocation(), BorderType.STOP)) {
                        if (Main.stats == Stats.AGUARDANDO_JOGADORES) {
                            if (p.isInsideVehicle()) {
                                p.getVehicle().eject();
                            }
                            if (WorldBorder.locations.containsKey(p) && WorldBorder.inBorder(WorldBorder.locations.get(p), BorderType.STOP)) {
                                p.teleport((Location)WorldBorder.locations.get(p));
                            }
                        }
                        else {
                            final EntityDamageEvent entitydamage = new EntityDamageEvent((Entity)p, EntityDamageEvent.DamageCause.CUSTOM, 4.0);
                            if (entitydamage instanceof Player) {
                                ((Player)entitydamage.getEntity()).damage(4.0);
                            }
                            Bukkit.getPluginManager().callEvent((Event)entitydamage);
                        }
                    }
                    else if (Main.stats == Stats.AGUARDANDO_JOGADORES && !WorldBorder.inBorder(p.getLocation(), BorderType.WARN)) {
                        p.sendMessage("§aVoce esta perto do forcefield!");
                    }
                }
            }
        }, 0L, 20L);
    }
    
    public static void cancel() {
        if (WorldBorder.shed_id != null) {
            Bukkit.getServer().getScheduler().cancelTask((int)WorldBorder.shed_id);
            WorldBorder.shed_id = null;
        }
    }
}
