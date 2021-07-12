package me.igormgs.timers;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import me.igormgs.Main;

public class Stat_Invencibilidade {
	
	public static void iniciar() {
		Main.stats = Stats.INVENCIBILIDADE;
		new BukkitRunnable() {
			public void run() {

				Main.TimerInvencibilidade -= 1;
			
				switch (Main.TimerInvencibilidade) {
				case 120:
					Bukkit.broadcastMessage("§eResta apenas §b§l2 §fminutos de invencibilidade, prepare-se.");
					break;
				case 60:
					Bukkit.broadcastMessage("§eResta apenas §b§l1 §fminutos de invencibilidade, prepare-se.");
					break;
				case 30:
					Bukkit.broadcastMessage("§eResta apenas §b§l30 §fsegundos de invencibilidade, prepare-se.");
					break;
				case 20:
					Bukkit.broadcastMessage("§eResta apenas §b§l20 §fsegundos de invencibilidade, prepare-se.");
					break;
				case 10:
					Bukkit.broadcastMessage("§eResta apenas §b§l10 §fsegundos de invencibilidade, prepare-se.");
					break;
				case 5:
					Bukkit.broadcastMessage("§eResta apenas §b§l5 §fsegundos de invencibilidade, prepare-se.");
					break;
				case 4:
					Bukkit.broadcastMessage("§eResta apenas §b§l4 §fsegundos de invencibilidade, prepare-se.");
					break;
				case 3:
					Bukkit.broadcastMessage("§eResta apenas §b§l3 §fsegundos de invencibilidade, prepare-se.");
					break;
				case 2:
					Bukkit.broadcastMessage("§eResta apenas §b§l2 §fsegundos de invencibilidade, prepare-se.");
					break;
				case 1:
					Bukkit.broadcastMessage("§eResta apenas §b§l1 §fsegundos de invencibilidade, prepare-se.");
					break;
					
				case 0:
					Bukkit.broadcastMessage("§eA invencibilidade acabou, bom jogo!");
					Stat_Andamento.iniciar();
					cancel();
					break;
				}
			}
		}.runTaskTimer(Main.plugin, 0, 20);
	}

}