package me.igormgs.timers;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import me.igormgs.Framework;
import me.igormgs.Main;

public class Stat_Iniciando {
	
	public static Integer ReIniciando = Integer.valueOf(180);

	public static void iniciar() {
		Main.stats = Stats.AGUARDANDO_JOGADORES;
		new BukkitRunnable() {
			@SuppressWarnings("deprecation")
			public void run() {
				Main.TimerIniciando -= 1;
				switch (Main.TimerIniciando) {
				case 300:
					Bukkit.broadcastMessage("§eDando inicio ao torneio dentro de §b§l5 §f§eminutos.");
					for(Player jogadores : Bukkit.getOnlinePlayers()) {
						Framework.sendTitle(jogadores, " ");
						Framework.sendSubTitle(jogadores, "§eIniciando em §b§l5§f §eminutos.");
						jogadores.playSound(jogadores.getLocation(), Sound.CLICK, 1F, 1F);
					}
					break;
				case 240:
					Bukkit.broadcastMessage("§eDando inicio ao torneio dentro de §b§l4 §f§eminutos.");
					for(Player jogadores : Bukkit.getOnlinePlayers()) {
						Framework.sendTitle(jogadores, " ");
						Framework.sendSubTitle(jogadores, "§eIniciando em §b§l4§f §eminutos.");
						jogadores.playSound(jogadores.getLocation(), Sound.CLICK, 1F, 1F);
					}
				    break;
				case 180:
					Bukkit.broadcastMessage("§eDando inicio ao torneio dentro de §b§l3 §f§eminutos.");
					for(Player jogadores : Bukkit.getOnlinePlayers()) {
						Framework.sendTitle(jogadores, " ");
						Framework.sendSubTitle(jogadores, "§eIniciando em §b§l3§f §eminutos.");
						jogadores.playSound(jogadores.getLocation(), Sound.CLICK, 1F, 1F);
					}
					break;
				case 120:
					Bukkit.broadcastMessage("§eDando inicio ao torneio dentro de §b§l2 §f§eminutos.");
					for(Player jogadores : Bukkit.getOnlinePlayers()) {
						Framework.sendTitle(jogadores, " ");
						Framework.sendSubTitle(jogadores, "§eIniciando em §b§l2§f §eminutos.");
						jogadores.playSound(jogadores.getLocation(), Sound.CLICK, 1F, 1F);
					}
					break;
				case 60:
					Bukkit.broadcastMessage("§eDando inicio ao torneio dentro de §b§l1 §f§eminuto.");
					for(Player jogadores : Bukkit.getOnlinePlayers()) {
						Framework.sendTitle(jogadores, " ");
						Framework.sendSubTitle(jogadores, "§eIniciando em §b§l1§f §eminutos.");
						jogadores.playSound(jogadores.getLocation(), Sound.CLICK, 1F, 1F);
					}
					break;
				case 30:
					Bukkit.broadcastMessage("§eDando inicio ao torneio dentro de §b§l30 §f§esegundos.");
					for(Player jogadores : Bukkit.getOnlinePlayers()) {
						Framework.sendTitle(jogadores, " ");
						Framework.sendSubTitle(jogadores, "§eIniciando em §b§l30§f §esegundos.");
						jogadores.playSound(jogadores.getLocation(), Sound.CLICK, 1F, 1F);
					}
					break;
				case 20:
					Bukkit.broadcastMessage("§eDando inicio ao torneio dentro de §b§l20 §f§esegundos.");
					for(Player jogadores : Bukkit.getOnlinePlayers()) {
						Framework.sendTitle(jogadores, " ");
						Framework.sendSubTitle(jogadores, "§eIniciando em §b§l20§f §esegundos.");
						jogadores.playSound(jogadores.getLocation(), Sound.CLICK, 1F, 1F);
					}
					break;
				case 10:
					Bukkit.broadcastMessage("§eDando inicio ao torneio dentro de §b§l10 §f§esegundos.");
					for(Player jogadores : Bukkit.getOnlinePlayers()) {
						Framework.sendTitle(jogadores, " ");
						Framework.sendSubTitle(jogadores, "§eIniciando em §b§l10§f §esegundos.");
						Location loki = new Location(jogadores.getWorld(), 0, 170, 0);
						jogadores.teleport(loki);
						jogadores.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 120, 50));
						jogadores.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 120, 1000));
						jogadores.playSound(jogadores.getLocation(), Sound.CLICK, 1F, 1F);
					}
					break;
				case 5:
					Bukkit.broadcastMessage("§eDando inicio ao torneio dentro de §b§l5 §f§esegundos.");
					for (Player p : Bukkit.getOnlinePlayers()) {
						p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 120, 50));
						p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 120, 1000));
						for(Player jogadores : Bukkit.getOnlinePlayers()) {
							jogadores.playSound(jogadores.getLocation(), Sound.CLICK, 1F, 1F);
						}
					}
					Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.plugin, new Runnable() {
						
						@Override
						public void run() {
							TimerSecondFive_Parte1 parte01 = new TimerSecondFive_Parte1();
							Location localizacaoParte01 = new Location(Bukkit.getServer().getWorld("world"), 0, 162, -10);
							parte01.aplicarParticulas(localizacaoParte01);
							
							TimerSecondFive_Parte2 parte02 = new TimerSecondFive_Parte2();
							Location localizacaoParte02 = new Location(Bukkit.getServer().getWorld("world"), 0, 162, 10);
							parte02.aplicarParticulas(localizacaoParte02);
							
							TimerSecondFive_Parte3 parte03 = new TimerSecondFive_Parte3();
							Location localizacaoParte03 = new Location(Bukkit.getServer().getWorld("world"), 10, 162, 0);
							parte03.aplicarParticulas(localizacaoParte03);
							
							TimerSecondFive_Parte4 parte04 = new TimerSecondFive_Parte4();
							Location localizacaoParte04 = new Location(Bukkit.getServer().getWorld("world"), -10, 162, 0);
							parte04.aplicarParticulas(localizacaoParte04);
						}
					}, 5L);
					
					Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.plugin, new Runnable() {
						
						@Override
						public void run() {
							TimerSecondFive_Parte1 parte01 = new TimerSecondFive_Parte1();
							Location localizacaoParte01 = new Location(Bukkit.getServer().getWorld("world"), 0, 162, -10);
							parte01.aplicarParticulas(localizacaoParte01);
							
							TimerSecondFive_Parte2 parte02 = new TimerSecondFive_Parte2();
							Location localizacaoParte02 = new Location(Bukkit.getServer().getWorld("world"), 0, 162, 10);
							parte02.aplicarParticulas(localizacaoParte02);
							
							TimerSecondFive_Parte3 parte03 = new TimerSecondFive_Parte3();
							Location localizacaoParte03 = new Location(Bukkit.getServer().getWorld("world"), 10, 162, 0);
							parte03.aplicarParticulas(localizacaoParte03);
							
							TimerSecondFive_Parte4 parte04 = new TimerSecondFive_Parte4();
							Location localizacaoParte04 = new Location(Bukkit.getServer().getWorld("world"), -10, 162, 0);
							parte04.aplicarParticulas(localizacaoParte04);
						}
					}, 10L);
					
					Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.plugin, new Runnable() {
						
						@Override
						public void run() {
							TimerSecondFive_Parte1 parte01 = new TimerSecondFive_Parte1();
							Location localizacaoParte01 = new Location(Bukkit.getServer().getWorld("world"), 0, 162, -10);
							parte01.aplicarParticulas(localizacaoParte01);
							
							TimerSecondFive_Parte2 parte02 = new TimerSecondFive_Parte2();
							Location localizacaoParte02 = new Location(Bukkit.getServer().getWorld("world"), 0, 162, 10);
							parte02.aplicarParticulas(localizacaoParte02);
							
							TimerSecondFive_Parte3 parte03 = new TimerSecondFive_Parte3();
							Location localizacaoParte03 = new Location(Bukkit.getServer().getWorld("world"), 10, 162, 0);
							parte03.aplicarParticulas(localizacaoParte03);
							
							TimerSecondFive_Parte4 parte04 = new TimerSecondFive_Parte4();
							Location localizacaoParte04 = new Location(Bukkit.getServer().getWorld("world"), -10, 162, 0);
							parte04.aplicarParticulas(localizacaoParte04);
						}
					}, 15L);
					
					Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.plugin, new Runnable() {
						
						@Override
						public void run() {
							TimerSecondFive_Parte1 parte01 = new TimerSecondFive_Parte1();
							Location localizacaoParte01 = new Location(Bukkit.getServer().getWorld("world"), 0, 162, -10);
							parte01.aplicarParticulas(localizacaoParte01);
							
							TimerSecondFive_Parte2 parte02 = new TimerSecondFive_Parte2();
							Location localizacaoParte02 = new Location(Bukkit.getServer().getWorld("world"), 0, 162, 10);
							parte02.aplicarParticulas(localizacaoParte02);
							
							TimerSecondFive_Parte3 parte03 = new TimerSecondFive_Parte3();
							Location localizacaoParte03 = new Location(Bukkit.getServer().getWorld("world"), 10, 162, 0);
							parte03.aplicarParticulas(localizacaoParte03);
							
							TimerSecondFive_Parte4 parte04 = new TimerSecondFive_Parte4();
							Location localizacaoParte04 = new Location(Bukkit.getServer().getWorld("world"), -10, 162, 0);
							parte04.aplicarParticulas(localizacaoParte04);
						}
					}, 20L);
					break;
				case 4:
					Bukkit.broadcastMessage("§eDando inicio ao torneio dentro de §b§l4 §f§esegundos.");
					for (Player p : Bukkit.getOnlinePlayers()) {
						p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 120, 50));
						p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 120, 1000));
						for(Player jogadores : Bukkit.getOnlinePlayers()) {
							jogadores.playSound(jogadores.getLocation(), Sound.CLICK, 1F, 1F);
						}
					}
					Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.plugin, new Runnable() {
						
						@Override
						public void run() {
							TimerSecondFour_Parte1 parte01 = new TimerSecondFour_Parte1();
							Location localizacaoParte01 = new Location(Bukkit.getServer().getWorld("world"), 0, 162, -10);
							parte01.aplicarParticulas(localizacaoParte01);
							
							TimerSecondFour_Parte2 parte02 = new TimerSecondFour_Parte2();
							Location localizacaoParte02 = new Location(Bukkit.getServer().getWorld("world"), 0, 162, 10);
							parte02.aplicarParticulas(localizacaoParte02);
							
							TimerSecondFour_Parte3 parte03 = new TimerSecondFour_Parte3();
							Location localizacaoParte03 = new Location(Bukkit.getServer().getWorld("world"), 10, 162, 0);
							parte03.aplicarParticulas(localizacaoParte03);
							
							TimerSecondFour_Parte4 parte04 = new TimerSecondFour_Parte4();
							Location localizacaoParte04 = new Location(Bukkit.getServer().getWorld("world"), -10, 162, 0);
							parte04.aplicarParticulas(localizacaoParte04);
						}
					}, 5L);
					
					Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.plugin, new Runnable() {
						
						@Override
						public void run() {
							TimerSecondFour_Parte1 parte01 = new TimerSecondFour_Parte1();
							Location localizacaoParte01 = new Location(Bukkit.getServer().getWorld("world"), 0, 162, -10);
							parte01.aplicarParticulas(localizacaoParte01);
							
							TimerSecondFour_Parte2 parte02 = new TimerSecondFour_Parte2();
							Location localizacaoParte02 = new Location(Bukkit.getServer().getWorld("world"), 0, 162, 10);
							parte02.aplicarParticulas(localizacaoParte02);
							
							TimerSecondFour_Parte3 parte03 = new TimerSecondFour_Parte3();
							Location localizacaoParte03 = new Location(Bukkit.getServer().getWorld("world"), 10, 162, 0);
							parte03.aplicarParticulas(localizacaoParte03);
							
							TimerSecondFour_Parte4 parte04 = new TimerSecondFour_Parte4();
							Location localizacaoParte04 = new Location(Bukkit.getServer().getWorld("world"), -10, 162, 0);
							parte04.aplicarParticulas(localizacaoParte04);
						}
					}, 10L);
					
					Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.plugin, new Runnable() {
						
						@Override
						public void run() {
							TimerSecondFour_Parte1 parte01 = new TimerSecondFour_Parte1();
							Location localizacaoParte01 = new Location(Bukkit.getServer().getWorld("world"), 0, 162, -10);
							parte01.aplicarParticulas(localizacaoParte01);
							
							TimerSecondFour_Parte2 parte02 = new TimerSecondFour_Parte2();
							Location localizacaoParte02 = new Location(Bukkit.getServer().getWorld("world"), 0, 162, 10);
							parte02.aplicarParticulas(localizacaoParte02);
							
							TimerSecondFour_Parte3 parte03 = new TimerSecondFour_Parte3();
							Location localizacaoParte03 = new Location(Bukkit.getServer().getWorld("world"), 10, 162, 0);
							parte03.aplicarParticulas(localizacaoParte03);
							
							TimerSecondFour_Parte4 parte04 = new TimerSecondFour_Parte4();
							Location localizacaoParte04 = new Location(Bukkit.getServer().getWorld("world"), -10, 162, 0);
							parte04.aplicarParticulas(localizacaoParte04);
						}
					}, 15L);
					
					Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.plugin, new Runnable() {
						
						@Override
						public void run() {
							TimerSecondFour_Parte1 parte01 = new TimerSecondFour_Parte1();
							Location localizacaoParte01 = new Location(Bukkit.getServer().getWorld("world"), 0, 162, -10);
							parte01.aplicarParticulas(localizacaoParte01);
							
							TimerSecondFour_Parte2 parte02 = new TimerSecondFour_Parte2();
							Location localizacaoParte02 = new Location(Bukkit.getServer().getWorld("world"), 0, 162, 10);
							parte02.aplicarParticulas(localizacaoParte02);
							
							TimerSecondFour_Parte3 parte03 = new TimerSecondFour_Parte3();
							Location localizacaoParte03 = new Location(Bukkit.getServer().getWorld("world"), 10, 162, 0);
							parte03.aplicarParticulas(localizacaoParte03);
							
							TimerSecondFour_Parte4 parte04 = new TimerSecondFour_Parte4();
							Location localizacaoParte04 = new Location(Bukkit.getServer().getWorld("world"), -10, 162, 0);
							parte04.aplicarParticulas(localizacaoParte04);
						}
					}, 20L);
					break;
				case 3:
					Bukkit.broadcastMessage("§eDando inicio ao torneio dentro de §b§l3 §f§esegundos.");
					for (Player p : Bukkit.getOnlinePlayers()) {
						p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 120, 50));
						p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 120, 1000));
						for(Player jogadores : Bukkit.getOnlinePlayers()) {
							jogadores.playSound(jogadores.getLocation(), Sound.CLICK, 1F, 1F);
						}
					}
					
					Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.plugin, new Runnable() {
						
						@Override
						public void run() {
							TimerSecondThree_Parte1 parte01 = new TimerSecondThree_Parte1();
							Location localizacaoParte01 = new Location(Bukkit.getServer().getWorld("world"), 0, 162, -10);
							parte01.aplicarParticulas(localizacaoParte01);
							
							TimerSecondThree_Parte2 parte02 = new TimerSecondThree_Parte2();
							Location localizacaoParte02 = new Location(Bukkit.getServer().getWorld("world"), 0, 162, 10);
							parte02.aplicarParticulas(localizacaoParte02);
							
							TimerSecondThree_Parte3 parte03 = new TimerSecondThree_Parte3();
							Location localizacaoParte03 = new Location(Bukkit.getServer().getWorld("world"), 10, 162, 0);
							parte03.aplicarParticulas(localizacaoParte03);
							
							TimerSecondThree_Parte4 parte04 = new TimerSecondThree_Parte4();
							Location localizacaoParte04 = new Location(Bukkit.getServer().getWorld("world"), -10, 162, 0);
							parte04.aplicarParticulas(localizacaoParte04);
						}
					}, 5L);
					
					Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.plugin, new Runnable() {
						
						@Override
						public void run() {
							TimerSecondThree_Parte1 parte01 = new TimerSecondThree_Parte1();
							Location localizacaoParte01 = new Location(Bukkit.getServer().getWorld("world"), 0, 162, -10);
							parte01.aplicarParticulas(localizacaoParte01);
							
							TimerSecondThree_Parte2 parte02 = new TimerSecondThree_Parte2();
							Location localizacaoParte02 = new Location(Bukkit.getServer().getWorld("world"), 0, 162, 10);
							parte02.aplicarParticulas(localizacaoParte02);
							
							TimerSecondThree_Parte3 parte03 = new TimerSecondThree_Parte3();
							Location localizacaoParte03 = new Location(Bukkit.getServer().getWorld("world"), 10, 162, 0);
							parte03.aplicarParticulas(localizacaoParte03);
							
							TimerSecondThree_Parte4 parte04 = new TimerSecondThree_Parte4();
							Location localizacaoParte04 = new Location(Bukkit.getServer().getWorld("world"), -10, 162, 0);
							parte04.aplicarParticulas(localizacaoParte04);
						}
					}, 10L);
					
					Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.plugin, new Runnable() {
						
						@Override
						public void run() {
							TimerSecondThree_Parte1 parte01 = new TimerSecondThree_Parte1();
							Location localizacaoParte01 = new Location(Bukkit.getServer().getWorld("world"), 0, 162, -10);
							parte01.aplicarParticulas(localizacaoParte01);
							
							TimerSecondThree_Parte2 parte02 = new TimerSecondThree_Parte2();
							Location localizacaoParte02 = new Location(Bukkit.getServer().getWorld("world"), 0, 162, 10);
							parte02.aplicarParticulas(localizacaoParte02);
							
							TimerSecondThree_Parte3 parte03 = new TimerSecondThree_Parte3();
							Location localizacaoParte03 = new Location(Bukkit.getServer().getWorld("world"), 10, 162, 0);
							parte03.aplicarParticulas(localizacaoParte03);
							
							TimerSecondThree_Parte4 parte04 = new TimerSecondThree_Parte4();
							Location localizacaoParte04 = new Location(Bukkit.getServer().getWorld("world"), -10, 162, 0);
							parte04.aplicarParticulas(localizacaoParte04);
						}
					}, 15L);
					
					Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.plugin, new Runnable() {
						
						@Override
						public void run() {
							TimerSecondThree_Parte1 parte01 = new TimerSecondThree_Parte1();
							Location localizacaoParte01 = new Location(Bukkit.getServer().getWorld("world"), 0, 162, -10);
							parte01.aplicarParticulas(localizacaoParte01);
							
							TimerSecondThree_Parte2 parte02 = new TimerSecondThree_Parte2();
							Location localizacaoParte02 = new Location(Bukkit.getServer().getWorld("world"), 0, 162, 10);
							parte02.aplicarParticulas(localizacaoParte02);
							
							TimerSecondThree_Parte3 parte03 = new TimerSecondThree_Parte3();
							Location localizacaoParte03 = new Location(Bukkit.getServer().getWorld("world"), 10, 162, 0);
							parte03.aplicarParticulas(localizacaoParte03);
							
							TimerSecondThree_Parte4 parte04 = new TimerSecondThree_Parte4();
							Location localizacaoParte04 = new Location(Bukkit.getServer().getWorld("world"), -10, 162, 0);
							parte04.aplicarParticulas(localizacaoParte04);
						}
					}, 20L);
					break;
				case 2:
					Bukkit.broadcastMessage("§eDando inicio ao torneio dentro de §b§l2 §f§esegundos.");
					for (Player p : Bukkit.getOnlinePlayers()) {
						p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 120, 50));
						p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 120, 1000));
						for(Player jogadores : Bukkit.getOnlinePlayers()) {
							jogadores.playSound(jogadores.getLocation(), Sound.CLICK, 1F, 1F);
						}
					}
					Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.plugin, new Runnable() {
						
						@Override
						public void run() {
							TimerSecondTwo_Parte1 parte01 = new TimerSecondTwo_Parte1();
							Location localizacaoParte01 = new Location(Bukkit.getServer().getWorld("world"), 0, 162, -10);
							parte01.aplicarParticulas(localizacaoParte01);
							
							TimerSecondTwo_Parte2 parte02 = new TimerSecondTwo_Parte2();
							Location localizacaoParte02 = new Location(Bukkit.getServer().getWorld("world"), 0, 162, 10);
							parte02.aplicarParticulas(localizacaoParte02);
							
							TimerSecondTwo_Parte3 parte03 = new TimerSecondTwo_Parte3();
							Location localizacaoParte03 = new Location(Bukkit.getServer().getWorld("world"), 10, 162, 0);
							parte03.aplicarParticulas(localizacaoParte03);
							
							TimerSecondTwo_Parte4 parte04 = new TimerSecondTwo_Parte4();
							Location localizacaoParte04 = new Location(Bukkit.getServer().getWorld("world"), -10, 162, 0);
							parte04.aplicarParticulas(localizacaoParte04);
						}
					}, 5L);
					
					Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.plugin, new Runnable() {
						
						@Override
						public void run() {
							TimerSecondTwo_Parte1 parte01 = new TimerSecondTwo_Parte1();
							Location localizacaoParte01 = new Location(Bukkit.getServer().getWorld("world"), 0, 162, -10);
							parte01.aplicarParticulas(localizacaoParte01);
							
							TimerSecondTwo_Parte2 parte02 = new TimerSecondTwo_Parte2();
							Location localizacaoParte02 = new Location(Bukkit.getServer().getWorld("world"), 0, 162, 10);
							parte02.aplicarParticulas(localizacaoParte02);
							
							TimerSecondTwo_Parte3 parte03 = new TimerSecondTwo_Parte3();
							Location localizacaoParte03 = new Location(Bukkit.getServer().getWorld("world"), 10, 162, 0);
							parte03.aplicarParticulas(localizacaoParte03);
							
							TimerSecondTwo_Parte4 parte04 = new TimerSecondTwo_Parte4();
							Location localizacaoParte04 = new Location(Bukkit.getServer().getWorld("world"), -10, 162, 0);
							parte04.aplicarParticulas(localizacaoParte04);
						}
					}, 10L);
					
					Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.plugin, new Runnable() {
						
						@Override
						public void run() {
							TimerSecondTwo_Parte1 parte01 = new TimerSecondTwo_Parte1();
							Location localizacaoParte01 = new Location(Bukkit.getServer().getWorld("world"), 0, 162, -10);
							parte01.aplicarParticulas(localizacaoParte01);
							
							TimerSecondTwo_Parte2 parte02 = new TimerSecondTwo_Parte2();
							Location localizacaoParte02 = new Location(Bukkit.getServer().getWorld("world"), 0, 162, 10);
							parte02.aplicarParticulas(localizacaoParte02);
							
							TimerSecondTwo_Parte3 parte03 = new TimerSecondTwo_Parte3();
							Location localizacaoParte03 = new Location(Bukkit.getServer().getWorld("world"), 10, 162, 0);
							parte03.aplicarParticulas(localizacaoParte03);
							
							TimerSecondTwo_Parte4 parte04 = new TimerSecondTwo_Parte4();
							Location localizacaoParte04 = new Location(Bukkit.getServer().getWorld("world"), -10, 162, 0);
							parte04.aplicarParticulas(localizacaoParte04);
						}
					}, 15L);
					
					Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.plugin, new Runnable() {
						
						@Override
						public void run() {
							TimerSecondTwo_Parte1 parte01 = new TimerSecondTwo_Parte1();
							Location localizacaoParte01 = new Location(Bukkit.getServer().getWorld("world"), 0, 162, -10);
							parte01.aplicarParticulas(localizacaoParte01);
							
							TimerSecondTwo_Parte2 parte02 = new TimerSecondTwo_Parte2();
							Location localizacaoParte02 = new Location(Bukkit.getServer().getWorld("world"), 0, 162, 10);
							parte02.aplicarParticulas(localizacaoParte02);
							
							TimerSecondTwo_Parte3 parte03 = new TimerSecondTwo_Parte3();
							Location localizacaoParte03 = new Location(Bukkit.getServer().getWorld("world"), 10, 162, 0);
							parte03.aplicarParticulas(localizacaoParte03);
							
							TimerSecondTwo_Parte4 parte04 = new TimerSecondTwo_Parte4();
							Location localizacaoParte04 = new Location(Bukkit.getServer().getWorld("world"), -10, 162, 0);
							parte04.aplicarParticulas(localizacaoParte04);
						}
					}, 20L);
					break;
				case 1:
					Bukkit.broadcastMessage("§eDando inicio ao torneio dentro de §b§l1 §f§esegundo.");
					for (Player p : Bukkit.getOnlinePlayers()) {
						p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 120, 50));
						p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 120, 1000));
						for(Player jogadores : Bukkit.getOnlinePlayers()) {
							jogadores.playSound(jogadores.getLocation(), Sound.CLICK, 1F, 1F);
						}
					}
					Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.plugin, new Runnable() {
						
						@Override
						public void run() {
							TimerSecondOne_Parte1 parte01 = new TimerSecondOne_Parte1();
							Location localizacaoParte01 = new Location(Bukkit.getServer().getWorld("world"), 0, 162, -10);
							parte01.aplicarParticulas(localizacaoParte01);
							
							TimerSecondOne_Parte2 parte02 = new TimerSecondOne_Parte2();
							Location localizacaoParte02 = new Location(Bukkit.getServer().getWorld("world"), 0, 162, 10);
							parte02.aplicarParticulas(localizacaoParte02);
							
							TimerSecondOne_Parte3 parte03 = new TimerSecondOne_Parte3();
							Location localizacaoParte03 = new Location(Bukkit.getServer().getWorld("world"), 10, 162, 0);
							parte03.aplicarParticulas(localizacaoParte03);
							
							TimerSecondOne_Parte4 parte04 = new TimerSecondOne_Parte4();
							Location localizacaoParte04 = new Location(Bukkit.getServer().getWorld("world"), -10, 162, 0);
							parte04.aplicarParticulas(localizacaoParte04);
						}
					}, 5L);
					
					Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.plugin, new Runnable() {
						
						@Override
						public void run() {
							TimerSecondOne_Parte1 parte01 = new TimerSecondOne_Parte1();
							Location localizacaoParte01 = new Location(Bukkit.getServer().getWorld("world"), 0, 162, -10);
							parte01.aplicarParticulas(localizacaoParte01);
							
							TimerSecondOne_Parte2 parte02 = new TimerSecondOne_Parte2();
							Location localizacaoParte02 = new Location(Bukkit.getServer().getWorld("world"), 0, 162, 10);
							parte02.aplicarParticulas(localizacaoParte02);
							
							TimerSecondOne_Parte3 parte03 = new TimerSecondOne_Parte3();
							Location localizacaoParte03 = new Location(Bukkit.getServer().getWorld("world"), 10, 162, 0);
							parte03.aplicarParticulas(localizacaoParte03);
							
							TimerSecondOne_Parte4 parte04 = new TimerSecondOne_Parte4();
							Location localizacaoParte04 = new Location(Bukkit.getServer().getWorld("world"), -10, 162, 0);
							parte04.aplicarParticulas(localizacaoParte04);
						}
					}, 10L);
					
					Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.plugin, new Runnable() {
						
						@Override
						public void run() {
							TimerSecondOne_Parte1 parte01 = new TimerSecondOne_Parte1();
							Location localizacaoParte01 = new Location(Bukkit.getServer().getWorld("world"), 0, 162, -10);
							parte01.aplicarParticulas(localizacaoParte01);
							
							TimerSecondOne_Parte2 parte02 = new TimerSecondOne_Parte2();
							Location localizacaoParte02 = new Location(Bukkit.getServer().getWorld("world"), 0, 162, 10);
							parte02.aplicarParticulas(localizacaoParte02);
							
							TimerSecondOne_Parte3 parte03 = new TimerSecondOne_Parte3();
							Location localizacaoParte03 = new Location(Bukkit.getServer().getWorld("world"), 10, 162, 0);
							parte03.aplicarParticulas(localizacaoParte03);
							
							TimerSecondOne_Parte4 parte04 = new TimerSecondOne_Parte4();
							Location localizacaoParte04 = new Location(Bukkit.getServer().getWorld("world"), -10, 162, 0);
							parte04.aplicarParticulas(localizacaoParte04);
						}
					}, 15L);
					
					Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.plugin, new Runnable() {
						
						@Override
						public void run() {
							TimerSecondOne_Parte1 parte01 = new TimerSecondOne_Parte1();
							Location localizacaoParte01 = new Location(Bukkit.getServer().getWorld("world"), 0, 162, -10);
							parte01.aplicarParticulas(localizacaoParte01);
							
							TimerSecondOne_Parte2 parte02 = new TimerSecondOne_Parte2();
							Location localizacaoParte02 = new Location(Bukkit.getServer().getWorld("world"), 0, 162, 10);
							parte02.aplicarParticulas(localizacaoParte02);
							
							TimerSecondOne_Parte3 parte03 = new TimerSecondOne_Parte3();
							Location localizacaoParte03 = new Location(Bukkit.getServer().getWorld("world"), 10, 162, 0);
							parte03.aplicarParticulas(localizacaoParte03);
							
							TimerSecondOne_Parte4 parte04 = new TimerSecondOne_Parte4();
							Location localizacaoParte04 = new Location(Bukkit.getServer().getWorld("world"), -10, 162, 0);
							parte04.aplicarParticulas(localizacaoParte04);
						}
					}, 20L);
					break;
				case 0:
					if (Main.participando.size() < Main.MinimoJogadores.intValue()) {
						Main.TimerIniciando = Integer.valueOf(ReIniciando.intValue());
						Bukkit.broadcastMessage("§eContagem reiniciada, numero mínimo de jogadores presentes não obtido.");
						for(Player jogadores : Bukkit.getOnlinePlayers()) {
							Framework.sendTitle(jogadores, " ");
							Framework.sendSubTitle(jogadores, "§eContagem reiniciada.");
							jogadores.playSound(jogadores.getLocation(), Sound.CLICK, 1F, 1F);
						}
						return;
					}
					Framework.iniciarPartida();
					cancel();
					break;

				}

			}
		}.runTaskTimer(Main.plugin, 0, 20);
	}

}