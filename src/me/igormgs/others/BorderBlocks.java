package me.igormgs.others;

import java.util.*;
import org.bukkit.*;

public class BorderBlocks
{
    @SuppressWarnings("deprecation")
	public static void gerarBorda() {
        for (int x = -500; x <= 500; ++x) {
            if (x == -500 || x == 500) {
                for (int z = -500; z <= 500; ++z) {
                    for (int y = 0; y <= 130; ++y) {
                        final Location loc = new Location(Bukkit.getWorld("world"), (double)x, (double)y, (double)z);
                        if (!loc.getChunk().isLoaded()) {
                            loc.getChunk().load();
                        }
                        if (new Random().nextBoolean()) {
                            loc.getBlock().setType(Material.getMaterial(155));
                        }
                        else {
                            loc.getBlock().setType(Material.getMaterial(20));
                        }
                    }
                }
            }
        }
        for (int z2 = -500; z2 <= 500; ++z2) {
            if (z2 == -500 || z2 == 500) {
                for (int x2 = -500; x2 <= 500; ++x2) {
                    for (int y = 0; y <= 130; ++y) {
                        final Location loc = new Location(Bukkit.getWorld("world"), (double)x2, (double)y, (double)z2);
                        if (!loc.getChunk().isLoaded()) {}
                        loc.getChunk().load();
                        if (new Random().nextBoolean()) {
                            loc.getBlock().setType(Material.getMaterial(155));
                        }
                        else {
                            loc.getBlock().setType(Material.getMaterial(20));
                        }
                    }
                }
            }
        }
        for (int x = -500; x <= 500; ++x) {
            if (x == -500 || x == 500) {
                for (int z = -500; z <= 500; ++z) {
                    for (int y = 0; y <= 500; ++y) {
                        final Location loc = new Location(Bukkit.getWorld("world"), (double)x, (double)y, (double)z);
                        if (!loc.getChunk().isLoaded()) {
                            loc.getChunk().load();
                        }
                        if (new Random().nextBoolean()) {
                            loc.getBlock().setType(Material.getMaterial(155));
                        }
                        else {
                            loc.getBlock().setType(Material.getMaterial(20));
                        }
                    }
                }
            }
        }
        for (int z2 = -500; z2 <= 500; ++z2) {
            if (z2 == -500 || z2 == 500) {
                for (int x2 = -500; x2 <= 500; ++x2) {
                    for (int y = 0; y <= 500; ++y) {
                        final Location loc = new Location(Bukkit.getWorld("world"), (double)x2, (double)y, (double)z2);
                        if (!loc.getChunk().isLoaded()) {}
                        loc.getChunk().load();
                        if (new Random().nextBoolean()) {
                            loc.getBlock().setType(Material.getMaterial(155));
                        }
                        else {
                            loc.getBlock().setType(Material.getMaterial(20));
                        }
                    }
                }
            }
        }
    }
}
