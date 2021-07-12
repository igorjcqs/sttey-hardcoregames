package me.igormgs.score;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import me.igormgs.Main;
import me.igormgs.others.StringTimer;
import me.igormgs.timers.Stats;

public class Scoreboards extends BukkitRunnable {

 @SuppressWarnings("deprecation")
 public void run() {
  for (Player player : Bukkit.getOnlinePlayers()) {
   if (Main.stats == Stats.AGUARDANDO_JOGADORES) {
     ScoreboardHelper scoreboardHelper = Main.scoreboard.get(player);
     scoreboardHelper.clear();
     scoreboardHelper.add("", "");
     scoreboardHelper.add(" §fCargo ", Main.verificarTag(player));
     scoreboardHelper.add("", "");
     scoreboardHelper.add(" §fIniciando em", " §a" + StringTimer.TimerGame(Main.TimerIniciando));
     scoreboardHelper.add(" §fKit", " §bNenhum");
     scoreboardHelper.add(" §fExtra", " §bNenhum");
     scoreboardHelper.add("", "");
     scoreboardHelper.add(" §fSala", " §a#1");
     scoreboardHelper.add(" §fOnline", " §a" + Main.participando.size());
     scoreboardHelper.add("", "");
     scoreboardHelper.add("§awww.stteymc", "§a.com");
     scoreboardHelper.update(player);
   }
  }
  if (Main.stats == Stats.INVENCIBILIDADE) {
   for (Player player : Bukkit.getOnlinePlayers()) {
    if (Main.score.contains(player.getName())) {
        ScoreboardHelper scoreboardHelper = Main.scoreboard.get(player);
        scoreboardHelper.clear();
        scoreboardHelper.add("", "");
        scoreboardHelper.add(" §fInvencível ", "§fpor §a" + StringTimer.TimerGame(Main.TimerInvencibilidade));
        scoreboardHelper.add(" §fKit", " §bNenhum");
        scoreboardHelper.add(" §fExtra", " §bNenhum");
        scoreboardHelper.add("", "");
        scoreboardHelper.add(" §fSala", " §a#1");
        scoreboardHelper.add(" §fOnline", " §a" + Main.participando.size());
        scoreboardHelper.add("", "");
        scoreboardHelper.add("§awww.stteymc", "§a.com");
        scoreboardHelper.update(player);
    }
   }
  }
  if (Main.stats == Stats.ANDAMENTO) {
   for(Player player : Bukkit.getOnlinePlayers()) {
    if(Main.score.contains(player.getName())) {
     ScoreboardHelper scoreboardHelper = Main.scoreboard.get(player);
     scoreboardHelper.clear();
     scoreboardHelper.add("", "");
     scoreboardHelper.add(" §fTempo ", " §a" + StringTimer.TimerGame(Main.TimerAndamento));
     scoreboardHelper.add(" §fKit", " §bNenhum");
     scoreboardHelper.add(" §fExtra", " §bNenhum");
     scoreboardHelper.add("", "");
     scoreboardHelper.add(" §fAbates ", "§e0");
     scoreboardHelper.add("", "");
     scoreboardHelper.add(" §fSala", " §a#1");
     scoreboardHelper.add(" §fOnline", " §a" + Main.participando.size());
     scoreboardHelper.add("", "");
     scoreboardHelper.add("§awww.stteymc", "§a.com");
     scoreboardHelper.update(player);
    }
   }
  }
 }

 public static Scoreboard getScoreBoard() {
  final ScoreboardManager manager = Bukkit.getScoreboardManager();
  final Scoreboard board = manager.getNewScoreboard();
  return board;
 }

 public static void clearScoreboard(final Player p) {
  getScoreBoard().clearSlot(DisplaySlot.SIDEBAR);
  p.setScoreboard(getScoreBoard());
 }

}