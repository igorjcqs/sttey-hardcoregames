package me.igormgs.timers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockSpreadEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.igormgs.DataException;
import me.igormgs.Framework;
import me.igormgs.Main;
import me.igormgs.Schematic;

public class GameManager {
	
	public static boolean ProtecaoFeast;

	@EventHandler
	public void onBlockSpread(BlockSpreadEvent event) {
		event.setCancelled(true);
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onBreakFeast(BlockBreakEvent e) {
		Player p = e.getPlayer();
		if (e.getBlock().getType() == Material.getMaterial(2)) {
			if (ProtecaoFeast) {
				e.setCancelled(true);
				p.sendMessage("§7Você não pode quebrar blocos do §aFeast!");
				return;
			}
			return;
		}
	}
	
	public static ArrayList<Block> cake = new ArrayList<>();

	@SuppressWarnings("deprecation")
	public static void verificar() {
		if ((Main.stats == Stats.ANDAMENTO) && (Main.participando.size() == 1))
			for (String s : Main.participando) {
				Player p = Bukkit.getPlayer(s);
				p.getInventory().clear();
				p.getInventory().setArmorContents(null);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 4.0F, 4.0F);
				p.playSound(p.getLocation(), Sound.AMBIENCE_THUNDER, 4.0F, 4.0F);
				p.setGameMode(GameMode.CREATIVE);

				ItemStack mlg = new ItemStack(Material.WATER_BUCKET);
				ItemMeta mlgmeta = mlg.getItemMeta();
				mlgmeta.setDisplayName("§7Balde");
				mlg.setItemMeta(mlgmeta);
				p.getInventory().setItem(4, mlg);

				Location pLoc = p.getLocation();
				Location winnerLoc = new Location(p.getWorld(), pLoc.getBlockX(), 110.0D, pLoc.getBlockZ());
				try {
					Schematic s1 = Schematic.getInstance().carregarSchematics(new File(Main.plugin.getDataFolder(), "Cake.schematic"));
					Schematic.getInstance().generateSchematic(Main.plugin.getServer().getWorlds().get(0), new Location(Main.plugin.getServer().getWorlds().get(0), winnerLoc.getX(), 180, winnerLoc.getZ()), s1, cake);
				} catch (IOException | DataException e) {
					e.printStackTrace();
					System.out.println("Não foi possível carregar o bolo.");
				}
				p.teleport(new Location(Main.plugin.getServer().getWorlds().get(0), winnerLoc.getX() + 8, 200, winnerLoc.getZ() + 8));
			
				
				Bukkit.getScheduler().scheduleAsyncRepeatingTask(Main.plugin, new Runnable() {
					
					@Override
					public void run() {
					    Framework.spawnRandomFirework(pLoc);
					}
				}, 10L, 10L);
				
				Main.stats = Stats.CONCLUINDO;
				Bukkit.broadcastMessage("§7=§8-§7=§8-§7=§8-§7=§8-§7=§8-§7=§8-§7=§8-§7=§8-§7=§8-§7=§8-§7=§8-§7=§8-§7=§8-§7=§8-§7=§7=§8-§7=§8-§7=§8-§7=§8-§7=§8-§7=§8-§7=§8-§7=§8-§7=§8-§7=§8-§7=§8-§7=§8-§7=§8-§7=§8-§7=");
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage("                                   §f§lVITóRIA");
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage(" §eO jogador §b" + p.getName() + " §evenceu a partida, parabéns!");
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage("§7=§8-§7=§8-§7=§8-§7=§8-§7=§8-§7=§8-§7=§8-§7=§8-§7=§8-§7=§8-§7=§8-§7=§8-§7=§8-§7=§8-§7=§7=§8-§7=§8-§7=§8-§7=§8-§7=§8-§7=§8-§7=§8-§7=§8-§7=§8-§7=§8-§7=§8-§7=§8-§7=§8-§7=§8-§7=");

				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
						@SuppressWarnings("deprecation")
						public void run() {
						p.kickPlayer("§7Voce Ganhou A Partida \n §7Voce conseguiu §a§7Kills");
						Bukkit.shutdown();
						for (Player ps : Bukkit.getOnlinePlayers())
							if (!ps.getName().equals(ps.getName())) {
								ps.kickPlayer("§a" + ps.getName() + " §7Ganhou A Partida");
							} else {
								Main.participando.size();
							}
					}
				}, 800L);
			}
	}

}