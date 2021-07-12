package me.igormgs.others;

public class StringTimer {
  public static String TimerGame(int time) {
    int min = time / 60;
    int seg = time % 60;
    return min + "m " + (seg < 10 ? "" : "") + seg + "s";
  }
}