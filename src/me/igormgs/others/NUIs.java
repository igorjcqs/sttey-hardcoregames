package me.igormgs.others;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class NUIs {
	
	public static void abrirSeletorDeKits(Player p) {
		Inventory gui = Bukkit.createInventory(p, 54, "§8Seletor de Kits, Página §n1");
		
		p.openInventory(gui);
	}
	
	public static void abrirMenuPrincipal(Player p) {
		Inventory gui = Bukkit.createInventory(p, 36, "§8Menu Principal");
		
		p.openInventory(gui);
	}

}