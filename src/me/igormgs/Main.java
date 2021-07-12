package me.igormgs;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.igormgs.db.EndDB;
import me.igormgs.db.MySQLManager;
import me.igormgs.others.BlinkEffect;
import me.igormgs.others.BorderBlocks;
import me.igormgs.score.ScoreboardHelper;
import me.igormgs.score.Scoreboards;
import me.igormgs.timers.Stat_Iniciando;
import me.igormgs.timers.Stats;

public class Main extends JavaPlugin {
	
	public static Plugin plugin;
	
	public static Integer MinimoJogadores = Integer.valueOf(1);
	public static ArrayList<String> participando = new ArrayList<String>();
	
	public static List<String> automsg = new ArrayList<String>();
	
	public static HashMap<Player, ScoreboardHelper> scoreboard = new HashMap<>();
	public static ArrayList<String> score = new ArrayList<>();
	
	public static int TimerAndamento = 0;
	
	public static Stats stats;
	public static Integer TimerIniciando = Integer.valueOf(301);
	public static Integer TimerInvencibilidade = Integer.valueOf(120);
	public static Integer TimerEffect = Integer.valueOf(5);
	
	public static BlinkEffect blink = new BlinkEffect();
	
	public static ReentrantLock lock = new ReentrantLock(true);
    public static String SQL_HOST = null;
	public static String SQL_PORT = null;
	public static String SQL_USER = null;
	public static String SQL_PASS = null;
	public static String SQL_DATA = null;
	public static Boolean SQL_DSC = Boolean.valueOf(false);
	private static Connection con;
	public MySQLManager mysql = new MySQLManager(this);
	public boolean database = false;
		  
		  public void onLoad() {
			  plugin = this;
			  saveDefaultConfig();
			  automsg = getConfig().getStringList("AutoMsg:");
			  Bukkit.getServer().unloadWorld("world", false);
			  deleteDir(new File("world"));
			  try {
				mysql.setupSQL();
			} catch (Exception e) {
				e.printStackTrace();
			}
		  }
	  
	  public static synchronized void SQLconnect(){
		    try{
		      plugin.getLogger().info("Conectando ao MySQL...");
		      Class.forName("com.mysql.jdbc.Driver").newInstance();
		      String conn = "jdbc:mysql://" + SQL_HOST + ":" + SQL_PORT + "/" + 
		        SQL_DATA;
		      con = DriverManager.getConnection(conn, SQL_USER, SQL_PASS);
		    }
		    catch (ClassNotFoundException ex){
		      plugin.getLogger().warning("MySQL Driver nao encontrado!");
		    }
		    catch (SQLException ex){
		      plugin.getLogger().warning("Erro ao tentar conectar ao Mysql!");
		    }
		    catch (Exception ex){
		      plugin.getLogger().warning("Erro desconhecido enquanto tentava conectar ao MySQL.");
		    }
		  }
		  
		  public static void SQLdisconnect(){
		    EndDB end = new EndDB(plugin, Main.plugin.getLogger(), con);
		    ExecutorService executor = Executors.newCachedThreadPool();
		    executor.execute(end);
		    executor.shutdown();
		  }

	public static void deleteDir(File dir) {
		if (dir.isDirectory()) {
			String[] children = dir.list();
			for (int i = 0; i < children.length; i++) {
				deleteDir(new File(dir, children[i]));
			}
		}
		dir.delete();
	}
	
	  public static String verificarTag(Player p) {
		  try {
			if(MySQLManager.getRank(p) == 0) {
				return "§7§lMEMBRO";
			}
			if(MySQLManager.getRank(p) == 1) {
				return "§a§lVIP";
			}
			if(MySQLManager.getRank(p) == 2) {
				return "§e§lVIP+";
			}
			if(MySQLManager.getRank(p) == 3) {
				return "§6§lPRO";
			}
			if(MySQLManager.getRank(p) == 4) {
				return "§d§lULTRA";
			}
			if(MySQLManager.getRank(p) == 5) {
				return "§1§lBETA";
			}
			if(MySQLManager.getRank(p) == 6) {
				return "§3§lSTTEY";
			}
			if(MySQLManager.getRank(p) == 7) {
				return "§b§lYOUTUBER";
			}
			if(MySQLManager.getRank(p) == 8) {
				return "§3§lYOUTUBER+";
			}
			if(MySQLManager.getRank(p) == 9) {
				return "§2§lHELPER";
			}
			if(MySQLManager.getRank(p) == 10) {
				return "§d§lBUILDER";
			}
			if(MySQLManager.getRank(p) == 11) {
				return "§d§lTRIAL";
			}
			if(MySQLManager.getRank(p) == 12) {
				return "§5§lMOD";
			}
			if(MySQLManager.getRank(p) == 13) {
				return "§c§lADM";
			}
			if(MySQLManager.getRank(p) == 14) {
				return "§4§lCEO";
			}
			if(MySQLManager.getRank(p) == 15) {
				return "§4§lCTI";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "MEMBRO";
	  }
	  
	public static ArrayList<Block> glad = new ArrayList<>();
	
	@SuppressWarnings("deprecation")
	public void onEnable() {
		
		plugin = this;
		
		System.out.println("[STTEYMC] - HARDCOREGAMES ATIVADO!");
		
		automsg = getConfig().getStringList("Mensagens");
		
		carregarComandos();
		carregarEventos();
		
		Stat_Iniciando.iniciar();
		
		new Scoreboards().runTaskTimer(Main.plugin, 1, 20);
		ItemStack Resultado = new ItemStack(Material.MUSHROOM_SOUP, 1);
		ItemMeta Cactos = Resultado.getItemMeta();
		Resultado.setItemMeta(Cactos);
		ShapelessRecipe CraftCactos = new ShapelessRecipe(Resultado);
		CraftCactos.addIngredient(1, Material.CACTUS);
		CraftCactos.addIngredient(1, Material.BOWL);
		Bukkit.getServer().addRecipe(CraftCactos);

		ItemMeta Cocoa = Resultado.getItemMeta();
		Resultado.setItemMeta(Cocoa);
		ShapelessRecipe CraftCocoa = new ShapelessRecipe(Resultado);
		CraftCocoa.addIngredient(1, Material.INK_SACK, 3);
		CraftCocoa.addIngredient(1, Material.BOWL);
		Bukkit.getServer().addRecipe(CraftCocoa);
		
		BorderBlocks.gerarBorda();
		
		try {
			Schematic s = Schematic.getInstance().carregarSchematics(new File(plugin.getDataFolder(), "StteySmashGlad.schematic"));
			Schematic.getInstance().generateSchematic(plugin.getServer().getWorlds().get(0), new Location(plugin.getServer().getWorlds().get(0), -35D, 160.0D, -35D), s, glad);
		} catch (IOException | DataException e) {
			e.printStackTrace();
			System.out.println("Não foi possível carregar o cubo kevin.");
		}
		
		Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		
		Bukkit.getScheduler().scheduleAsyncRepeatingTask(plugin, new Runnable() {
			
			@Override
			public void run() {
				Random msg = new Random();
		        int r = msg.nextInt(Main.automsg.size());
		        Bukkit.broadcastMessage(((String)Main.automsg.get(r)).replaceAll("&", "§"));
			}
		}, 1400L, 1400L);
		
	}
	
	public void onDisable() {
		
		System.out.println("[STTEYMC] - HARDCOREGAMES DESATIVADO!");
		
	}
	
	void carregarEventos() {
		PluginManager pm = Bukkit.getServer().getPluginManager();
		pm.registerEvents(new Eventos(), this);
	}
	
	void carregarComandos() {
		getCommand("lobby").setExecutor(new Comandos());
		getCommand("tempo").setExecutor(new Comandos());
	}

}