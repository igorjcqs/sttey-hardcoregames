package me.igormgs;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.help.HelpTopic;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scoreboard.Scoreboard;

import me.igormgs.others.NUIs;
import me.igormgs.score.ScoreboardHelper;
import me.igormgs.timers.Stats;

public class Eventos implements Listener {
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void joinEvent(PlayerJoinEvent e) {
		Player p = e .getPlayer();
		if(Main.stats == Stats.AGUARDANDO_JOGADORES) {
			e.setJoinMessage(null);
		} else if(Main.stats == Stats.INVENCIBILIDADE) {
			e.setJoinMessage("§7" + p.getName() + " entrou no torneio.");
		}
		
		p.setFoodLevel(20);
		p.setHealth(20);
		p.setSaturation(100);
		
		Location loki = new Location(p.getWorld(), 0, 190, 0);
		p.teleport(loki);
		
		Main.participando.add(p.getName());
		
		Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
		p.setScoreboard(scoreboard);
		Main.scoreboard.put(p, new ScoreboardHelper(scoreboard, "§b§lSINGLE KIT"));
		Main.score.add(p.getName());
		
		Framework.buildTabConstructor(p, "§c§m---§6§m---§e§m---§a§m---§3§m---§b§m---§5§m---§7§m[---]§5§m---§b§m---§3§m---§a§m---§e§m---§6§m---§c§m---§f\n\n§b§lSTTEY §f§lMC\n   §7Bem-vindo ao §aHG-A1\n", "\n\n§7Site §astteymc.com\n§7Discord §ads.stteymc.com\n\n  §6§lPROMOÇãO §f§7em toda nossa §a§lLOJA§f§7!\nAcesse: §aloja.stteymc.com\n\n§c§m---§6§m---§e§m---§a§m---§3§m---§b§m---§5§m---§7§m[---]§5§m---§b§m---§3§m---§a§m---§e§m---§6§m---§c§m---§f");
		
		Framework.sendTitle(p, "§b§lSINGLE KIT");
		Framework.sendSubTitle(p, "§eBem-vindo a sala §f#1");
		Framework.sendTimings(p, 10, 30, 10);
		
		ItemStack stack = new ItemStack(Material.CHEST);
		ItemMeta stackm = stack.getItemMeta();
		List<String> ls = new ArrayList<String>();
		ls.add(" ");
		ls.add("§8Selecione um kit de sua preferência.");
		stackm.setDisplayName("§aKit selector §7(Clique)");
		stackm.setLore(ls);
		stack.setItemMeta(stackm);
		p.getInventory().setItem(3, stack);
		
		ItemStack stack1 = new ItemStack(Material.STORAGE_MINECART);
		ItemMeta stackm1 = stack1.getItemMeta();
		List<String> ls1 = new ArrayList<String>();
		ls1.add(" ");
		ls1.add("§8Desfrute das opções do nosso menu.");
		stackm1.setDisplayName("§aMenu §7(Clique)");
		stackm1.setLore(ls1);
		stack1.setItemMeta(stackm1);
		p.getInventory().setItem(5, stack1);
	}
	
	@EventHandler
	public void quitEvent(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		if(Main.stats == Stats.AGUARDANDO_JOGADORES) {
			e.setQuitMessage(null);
		} else if(Main.stats == Stats.INVENCIBILIDADE) {
			e.setQuitMessage("§7" + p.getName() + " saiu do torneio.");
		}
		Main.participando.remove(p.getName());
	}
	
	@EventHandler
	public void interactEvent(PlayerInteractEvent e) {
	  Player p = e.getPlayer();	
		if(Main.stats == Stats.AGUARDANDO_JOGADORES) {
			if(p.getItemInHand().getType() == Material.CHEST) {
				NUIs.abrirSeletorDeKits(p);
				p.playSound(p.getLocation(), Sound.CLICK, 1f, 1f);
			}
			
			if(p.getItemInHand().getType() == Material.STORAGE_MINECART) {
				NUIs.abrirMenuPrincipal(p);
				p.playSound(p.getLocation(), Sound.CLICK, 1f, 1f);
			}
		}
	}
	
	@EventHandler
	public void quebrar(BlockBreakEvent e) {
		if(Main.stats == Stats.AGUARDANDO_JOGADORES) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void colocar(BlockPlaceEvent e) {
		if(Main.stats == Stats.AGUARDANDO_JOGADORES) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void interagir(PlayerInteractEvent e) {
		if(Main.stats == Stats.AGUARDANDO_JOGADORES) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void fome(FoodLevelChangeEvent e) {
		if(Main.stats == Stats.AGUARDANDO_JOGADORES) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void comandoInexistente(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		String comando = e.getMessage().split(" ")[0];
		HelpTopic ht = Bukkit.getServer().getHelpMap().getHelpTopic(comando);
		if(ht == null) {
			p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
		    p.sendMessage("§a§lCHAT §fComando não encontrado.");
		    Framework.sendTitle(p, "§4§lERRO");
		    Framework.sendSubTitle(p, "§fComando não registrado.");
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void pegar(PlayerPickupItemEvent e) {
		if(Main.stats == Stats.AGUARDANDO_JOGADORES) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void dropar(PlayerDropItemEvent e) {
		if(Main.stats == Stats.AGUARDANDO_JOGADORES) {
			e.setCancelled(true);
		}
	}
		
	@EventHandler
	public void dano(EntityDamageEvent e) {
		if(Main.stats == Stats.AGUARDANDO_JOGADORES) {
			e.setCancelled(true);
		} else if(Main.stats == Stats.INVENCIBILIDADE) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void shh(PlayerCommandPreprocessEvent e) {
	  Player p = e.getPlayer();
		if(e.getMessage().toLowerCase().startsWith("/me")) {
			p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
		    p.sendMessage("§a§lCHAT §fComando não encontrado.");
		    Framework.sendTitle(p, "§4§lERRO");
		    Framework.sendSubTitle(p, "§fComando não registrado.");
			e.setCancelled(true);
		}
		if(e.getMessage().toLowerCase().startsWith("/bukkit:me")) {
			p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
		    p.sendMessage("§a§lCHAT §fComando não encontrado.");
		    Framework.sendTitle(p, "§4§lERRO");
		    Framework.sendSubTitle(p, "§fComando não registrado.");
			e.setCancelled(true);
		}
		if(e.getMessage().toLowerCase().startsWith("/bukkit:?")) {
			p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
		    p.sendMessage("§a§lCHAT §fComando não encontrado.");
		    Framework.sendTitle(p, "§4§lERRO");
		    Framework.sendSubTitle(p, "§fComando não registrado.");
			e.setCancelled(true);
		}
		if(e.getMessage().toLowerCase().startsWith("/bukkit:ver")) {
			p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
		    p.sendMessage("§a§lCHAT §fComando não encontrado.");
		    Framework.sendTitle(p, "§4§lERRO");
		    Framework.sendSubTitle(p, "§fComando não registrado.");
			e.setCancelled(true);
		}
		if(e.getMessage().toLowerCase().startsWith("/ver")) {
			p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
		    p.sendMessage("§a§lCHAT §fComando não encontrado.");
		    Framework.sendTitle(p, "§4§lERRO");
		    Framework.sendSubTitle(p, "§fComando não registrado.");
			e.setCancelled(true);
		}
		if(e.getMessage().toLowerCase().startsWith("/versions")) {
			p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
		    p.sendMessage("§a§lCHAT §fComando não encontrado.");
		    Framework.sendTitle(p, "§4§lERRO");
		    Framework.sendSubTitle(p, "§fComando não registrado.");
			e.setCancelled(true);
		}
		if(e.getMessage().toLowerCase().startsWith("/bukkit:versions")) {
			p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
		    p.sendMessage("§a§lCHAT §fComando não encontrado.");
		    Framework.sendTitle(p, "§4§lERRO");
		    Framework.sendSubTitle(p, "§fComando não registrado.");
			e.setCancelled(true);
		}
		if(e.getMessage().toLowerCase().startsWith("/?")) {
			p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
		    p.sendMessage("§a§lCHAT §fComando não encontrado.");
		    Framework.sendTitle(p, "§4§lERRO");
		    Framework.sendSubTitle(p, "§fComando não registrado.");
			e.setCancelled(true);
		}
		if(e.getMessage().toLowerCase().startsWith("/pl")) {
			p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
		    p.sendMessage("§a§lCHAT §fComando não encontrado.");
		    Framework.sendTitle(p, "§4§lERRO");
		    Framework.sendSubTitle(p, "§fComando não registrado.");
			e.setCancelled(true);
		}
		if(e.getMessage().toLowerCase().startsWith("/plugins")) {
			p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
		    p.sendMessage("§a§lCHAT §fComando não encontrado.");
		    Framework.sendTitle(p, "§4§lERRO");
		    Framework.sendSubTitle(p, "§fComando não registrado.");
			e.setCancelled(true);
		}
		if(e.getMessage().toLowerCase().startsWith("/bukkit:plugins")) {
			p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
		    p.sendMessage("§a§lCHAT §fComando não encontrado.");
		    Framework.sendTitle(p, "§4§lERRO");
		    Framework.sendSubTitle(p, "§fComando não registrado.");
			e.setCancelled(true);
		}
		if(e.getMessage().toLowerCase().startsWith("/bukkit:pl")) {
			p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
		    p.sendMessage("§a§lCHAT §fComando não encontrado.");
		    Framework.sendTitle(p, "§4§lERRO");
		    Framework.sendSubTitle(p, "§fComando não registrado.");
			e.setCancelled(true);
		}
		if(e.getMessage().toLowerCase().startsWith("/about")) {
			p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
		    p.sendMessage("§a§lCHAT §fComando não encontrado.");
		    Framework.sendTitle(p, "§4§lERRO");
		    Framework.sendSubTitle(p, "§fComando não registrado.");
			e.setCancelled(true);
		}
		if(e.getMessage().toLowerCase().startsWith("/bukkit:about")) {
			p.playSound(p.getLocation(), Sound.EXPLODE, 1.0F, 1.0F);
		    p.sendMessage("§a§lCHAT §fComando não encontrado.");
		    Framework.sendTitle(p, "§4§lERRO");
		    Framework.sendSubTitle(p, "§fComando não registrado.");
			e.setCancelled(true);
		}
	}

}