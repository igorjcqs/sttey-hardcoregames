package me.igormgs;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;
import org.spigotmc.ProtocolInjector;

import me.igormgs.timers.Stat_Invencibilidade;
import net.minecraft.server.v1_7_R4.ChatSerializer;
import net.minecraft.server.v1_7_R4.IChatBaseComponent;
import net.minecraft.server.v1_7_R4.PacketPlayOutChat;
import net.minecraft.server.v1_7_R4.PlayerConnection;

public class Framework {
	
	private static int VERSION = 47; 
	
	public static void enviarActionBar(Player p, String msg) {
		if(((CraftPlayer)p).getHandle().playerConnection.networkManager.getVersion() < VERSION) {
			return;
		}
		IChatBaseComponent cbc = ChatSerializer.a("{\"text\": \"" + msg + "\"}");
		PacketPlayOutChat pakt = new PacketPlayOutChat(cbc, (byte) 2);
		((CraftPlayer) p).getHandle().playerConnection.sendPacket(pakt);
	}

	public static void sendTitle(Player p, String title) {
	 if (((CraftPlayer) p).getHandle().playerConnection.networkManager.getVersion() < VERSION) {
	  return;
	 }
	 ((CraftPlayer) p).getHandle().playerConnection.sendPacket(new ProtocolInjector.PacketTitle(ProtocolInjector.PacketTitle.Action.TITLE, ChatSerializer.a("{\"text\": \"\"}").a(title)));
	}

	public static void sendSubTitle(Player p, String subtitle) {
	 if (((CraftPlayer) p).getHandle().playerConnection.networkManager.getVersion() < VERSION) {
	  return;
	 }
	 ((CraftPlayer) p).getHandle().playerConnection.sendPacket(new ProtocolInjector.PacketTitle(ProtocolInjector.PacketTitle.Action.SUBTITLE, ChatSerializer.a(
	   "{\"text\": \"\"}").a(subtitle)));
	}
	
	public static void spawnRandomFirework(Location loc) {
		 Firework fw = (Firework)loc.getWorld().spawnEntity(loc, EntityType.FIREWORK);
		 FireworkMeta fwm = fw.getFireworkMeta();
		  Random r = new Random();  
		  int rt = r.nextInt(4) + 1;
		  FireworkEffect.Type type = FireworkEffect.Type.BALL;
		  if (rt == 1) {
		  type = FireworkEffect.Type.BALL;
		  }
		  if (rt == 2) {
		  type = FireworkEffect.Type.BALL_LARGE;
		  }
		  if (rt == 3) {
		  type = FireworkEffect.Type.BURST;
		  }
		  if (rt == 4) {
		  type = FireworkEffect.Type.CREEPER;
		  }
		  if (rt == 5) {
		  type = FireworkEffect.Type.STAR;
		  } 
		  Color c1 = Color.RED;
		  Color c2 = Color.YELLOW;
		  Color c3 = Color.ORANGE; 
		  FireworkEffect effect = FireworkEffect.builder().flicker(r.nextBoolean()).withColor(c1).withColor(c2).withFade(c3).with(type).trail(r.nextBoolean()).build();
		  fwm.addEffect(effect);  
		  int rp = r.nextInt(2) + 1;
		  fwm.setPower(rp); 
		  fw.setFireworkMeta(fwm);
	}

	public static void sendTimings(Player p, int fadeIn, int stay, int fadeOut) {
	 if (((CraftPlayer) p).getHandle().playerConnection.networkManager.getVersion() < VERSION) {
	  return;
	 }
	 try {
	  Object handle = getHandle(p);
	  Object connection = getField(handle.getClass(), "playerConnection").get(handle);
	  Object packet = ProtocolInjector.PacketTitle.class.getConstructor(new Class[] { ProtocolInjector.PacketTitle.Action.class, Integer.TYPE, Integer.TYPE, Integer.TYPE }).newInstance(new Object[] { ProtocolInjector.PacketTitle.Action.TIMES, Integer.valueOf(fadeIn), Integer.valueOf(stay), Integer.valueOf(fadeOut) });
	  getMethod(connection.getClass(), "sendPacket", new Class[0]).invoke(connection, new Object[] { packet });
	 } catch (Exception e) {
	  e.printStackTrace();
	 }
	}

	private static boolean ClassListEqual(Class<?>[] l1, Class<?>[] l2) {
	 boolean equal = true;
	 if (l1.length != l2.length) {
	  return false;
	 }
	 for (int i = 0; i < l1.length; i++) {
	  if (l1[i] != l2[i]) {
	    equal = false;
	    break;
	   }
	  }
	  return equal;
	 }

	 private static Field getField(Class<?> clazz, String name) {
	  try {
	   Field field = clazz.getDeclaredField(name);
	   field.setAccessible(true);
	   return field;
	  } catch (Exception e) {
	   e.printStackTrace();
	  }
	  return null;
	 }

	 private static Method getMethod(Class<?> clazz, String name, Class<?>... args) {
	  for (Method m : clazz.getMethods()) {
	   if ((m.getName().equals(name)) && ((args.length == 0) || (ClassListEqual(args, m.getParameterTypes())))) {
	    m.setAccessible(true);
	    return m;
	   }
	  }
	  return null;
	 }

	 private static Object getHandle(Object obj) {
	  try {
	   return getMethod(obj.getClass(), "getHandle", new Class[0]).invoke(obj, new Object[0]);
	  } catch (Exception e) {
	   e.printStackTrace();
	  }
	  return null;
	 }

	 public static void reset(Player p) {
	  if (((CraftPlayer) p).getHandle().playerConnection.networkManager.getVersion() < VERSION) {
	   return;
	  }
	  ((CraftPlayer) p).getHandle().playerConnection.sendPacket(new ProtocolInjector.PacketTitle(ProtocolInjector.PacketTitle.Action.RESET));
	 }

	 public static void clear(Player p) {
	  if (((CraftPlayer) p).getHandle().playerConnection.networkManager.getVersion() < VERSION) {
	   return;
	  }
	  ((CraftPlayer) p).getHandle().playerConnection.sendPacket(new ProtocolInjector.PacketTitle(ProtocolInjector.PacketTitle.Action.CLEAR));
	 }
	 
	 public static void buildTabConstructor(Player p, String texto1, String texto2) {
	     PlayerConnection connect = ((CraftPlayer) p).getHandle().playerConnection;
	     IChatBaseComponent top = ChatSerializer.a("{'text':'" + texto1 + "\n '}");

	     IChatBaseComponent bottom = ChatSerializer.a("{'extra': [{'color': 'aqua', 'text': '" + texto2 + "', 'underline': 'true'}], 'color': 'gold', 'text': ''}");
	      if (((CraftPlayer) p).getHandle().playerConnection.networkManager.getVersion() < 47) {
	          return;
	      }
	     connect.sendPacket(new ProtocolInjector.PacketTabHeader(top, bottom));
	 }
	 
	  public static String getShortStr(String name) {
		    if (name.length() == 16)
		    {
		      return name.substring(0, name.length() - 5);
		    }
		    
		    if (name.length() == 15)
		    {
		      return name.substring(0, name.length() - 4);
		    }
		    
		    return name;
		  }
	  
	  @SuppressWarnings("deprecation")
	public static void iniciarPartida() {
		  ((World) Bukkit.getServer().getWorlds().get(0)).setTime(0L);
			((World) Bukkit.getServer().getWorlds().get(0)).setStorm(false);
			((World) Bukkit.getServer().getWorlds().get(0)).setThundering(false);
			Stat_Invencibilidade.iniciar();
			for(Iterator<?> i=Main.glad.iterator(); i.hasNext();){
				Block b=(Block)i.next();
					if (b.getType() == Material.getMaterial(95)) {
					b.setType(Material.AIR);
				}
			}
			for (Player p : Bukkit.getServer().getOnlinePlayers()) {
				p.playSound(p.getLocation(), Sound.AMBIENCE_THUNDER, 4.0F, 4.0F);
				p.getInventory().clear();
				sendTitle(p, " ");
				sendSubTitle(p, "§7Seja o ultimo de pé.");
				p.sendMessage("§eTorneio iniciado.");
			}
	  }


}