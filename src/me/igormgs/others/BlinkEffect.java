package me.igormgs.others;

public class BlinkEffect {
	
	private int i = 1;
	private String 	texto = "§f§lHARDCOREGAMES";
	public BlinkEffect(){
		
	}
	
	public void next(){
		if (i == 1){
			texto = "§f§lS§b§lINGLE KIT";
		}
		if (i == 2){
			texto = "§b§lS§f§lI§b§lNGLE KIT";
		}
		if (i == 3){
			texto = "§b§lSI§f§lN§b§lGLE KIT";
		}
		if (i == 4){
			texto = "§b§lSIN§f§lG§b§lLE KIT";
		}
		if (i == 5){
			texto = "§b§lSING§f§lL§b§lE KIT";
		}
		if (i == 6){
			texto = "§b§lSINGL§f§lE§b§l KIT";
		}
		if (i == 7){
			texto = "§b§lSINGLE §f§lK§b§lIT";
		}
		if (i == 8){
			texto = "§b§lSINGLE K§f§lI§b§lT";
		}
		if (i == 9){
			texto = "§b§lSINGLE KI§f§lT";
		}
		if (i == 10){
			texto = "§f§lSINGLE KIT";
		}
		if (i == 11){
			texto = "§b§lSINGLE KIT";
		}
		if (i == 12){
			texto = "§f§lSINGLE KIT";
		}
		if (i == 14){
			texto = "§b§lSINGLE KIT";
			i = 0;
		}
		i++;
	}
	public String getText(){
		return texto;
	}

}
