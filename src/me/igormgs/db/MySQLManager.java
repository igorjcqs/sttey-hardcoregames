package me.igormgs.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

import org.bukkit.entity.Player;

import me.igormgs.Main;

public class MySQLManager {
	
	  private static MySQL db;
	  public Main plugin;
	  
	  public MySQLManager(Main plugin2) {
		  this.plugin = plugin2;
	  }
	  
	  public void setupSQL()
	    throws SQLException{
	      db = new MySQL(this.plugin, 
	        Main.plugin.getConfig().getString("mysql.host-name"), 
	        Main.plugin.getConfig().getString("mysql.porta"), 
	        Main.plugin.getConfig().getString("mysql.database"), 
	        Main.plugin.getConfig().getString("mysql.usuario"), 
	        Main.plugin.getConfig().getString("mysql.senha"));
	      db.openConnection();
	      Statement statement = db.getConnection().createStatement();
	      statement.executeUpdate("CREATE TABLE IF NOT EXISTS `dados_hg` (`uuid` varchar(255), `username` varchar(255), `kills` int(16), `mortes` int(16), `vitorias` int(16), `partidas` int(16))");
	      plugin.database = true;
	    }
	  
	  public void closeDB() {
	    db.closeConnection();
	  }
	  
	  public static void firstJoinPlayer(Player p) throws SQLException {
	    if (!db.checkConnection()) {
	      db.openConnection();
	    }
	    Statement s = db.getConnection().createStatement();
	    
	    ResultSet rs = s.executeQuery("SELECT * FROM dados_hg WHERE `uuid`='" + p.getUniqueId() + "';");
	    if (rs.next()) {
	      return;
	    }
	    s.executeUpdate("INSERT INTO dados_hg (`uuid`, `username`, `kills`, `mortes`, `vitorias`, `partidas`) VALUES ('" + p.getUniqueId() + "', '" + p.getName() + "', '" + 0 + "', '" + 0 + "', '" + 0 + "', '" + 0 + "');");
	    Main.plugin.getLogger().log(Level.INFO,  "Os dados do jogador "+ p.getName() + "(" + p.getUniqueId() + ") foram inseridos com sucesso no banco de dados.");
	  }
	  
	  public static int getCoins(Player p) throws SQLException {
		String name = p.getUniqueId().toString();
		 if (!db.checkConnection()) {
		   db.openConnection();
		 }
		 Statement s = db.getConnection().createStatement();
		 ResultSet rs = s.executeQuery("SELECT * FROM dados_lobby WHERE `uuid`='" + name + "';");
		 if (!rs.next()) {
		   return 0;
		 }
		 int retorno = rs.getInt("coins");
		    
		 return retorno;
	  }
	  
	  public static void updateVerify(Player p) throws SQLException {
		String name = p.getUniqueId().toString();
		if (!db.checkConnection()) {
		  db.openConnection();
		}
	    Statement s = db.getConnection().createStatement();
		s.executeUpdate("UPDATE dados_lobby SET `verificado`='SIM' WHERE `uuid`='" + name + "';");
	  }
	  
	  public static int getRank(Player p) throws SQLException {
		String name = p.getUniqueId().toString();
		 if (!db.checkConnection()) {
		   db.openConnection();
		 }
		 Statement s = db.getConnection().createStatement();
		 ResultSet rs = s.executeQuery("SELECT * FROM dados_lobby WHERE `uuid`='" + name + "';");
		 if (!rs.next()) {
		   return 0;
		 }
		 int retorno = rs.getInt("rank");
		    
		 return retorno;
	  }
	  
}