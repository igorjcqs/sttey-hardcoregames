package me.igormgs.timers;

import java.util.Iterator;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.scheduler.BukkitRunnable;

import me.igormgs.Main;

public class Stat_Andamento {
	
	 public static void checar() {
		    GameManager.verificar();
		    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
		      public void run() {
		        checar();
		      }
		    }, 600L);
		  }
	
	public static void iniciar() {
		Main.stats = Stats.ANDAMENTO;
		new BukkitRunnable() {
			@SuppressWarnings({})
			public void run() {
				Main.TimerAndamento += 1;
				for(Iterator<?> i=Main.glad.iterator(); i.hasNext();){
					Block b=(Block)i.next();
						if (b.getType() == Material.GLASS) {
						b.setType(Material.AIR);
					}
				}
				switch (Main.TimerAndamento) {
				case 450:
					//minifeast
					break;
				case 850:
					//minifeast
					break;
				case 900:
					//feast
					break;
				case 960:
					//feast
					break;
				case 1020:
					//feast e minifeast
					break;
				case 1080:
					//feast
					break;
				case 1140:
					//feast e minifeast
					break;
				case 1195:
					//feast
					break;
				case 1196:
					//feast
					break;
				case 1197:
					//feast
					break;
				case 1198:
					//feast
					break;
				case 1199:
					//feast
					break;
				case 1200:
					//feast
					break;
				case 3600:
					//arena
					break;
				case 3900:
					//arena
					break;
				case 4000:
					Bukkit.shutdown();
					cancel();
					break;
				}
				checar();
			}
		}.runTaskTimer(Main.plugin, 0, 20);
	}

}