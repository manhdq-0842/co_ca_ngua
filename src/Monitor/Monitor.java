package Monitor;

import Games.DummiesGame;
import Player.Player;
import Util.Circle;
import Util.Horse;
import Util.Trai;

public class Monitor {
	Circle[] circles = DummiesGame.circles;//bien tinh ko bi thay doi gia tri
	private Trai[] trais;
	private Horse horse;
	private Player[] players;
	
	
	public Monitor(Circle[] circles,Horse horses, Trai[] trais, Player[] players) {
		this.circles = circles;
		this.trais = trais;
		this.players = players;
		this.horse = horses;
	}

	
	public int tinhdiem() {
		
		return 0;
	}
	
	public boolean winner() {
		return false;
	}
}
