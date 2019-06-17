package Games;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

import Player.Human;
import Player.Player;
import Util.Circle;
import Util.Trai;
import Util.Vedich;

public class DummiesGame {//tong hop giao dien game
	public static Circle[] circles;//vong tron
	public static  Vedich[] vedich;
	public static int currChoice = 4;
	
	
	public static void main(String args[]) {
		
		final JFrame window = new JFrame("Cờ Cá Ngựa");//ten jframe
		
		java.awt.EventQueue.invokeLater(new Runnable() {
	    	public void run() {
	    		Start start = new Start(window);
	    		start.setVisible(true);
	    	}		
	    });
		Player[] players = new Player[4];//4 nguoi choi
		Trai[] trais = new Trai[4];//4 cai trại
		trais[0] = new Trai(0, 0,10);//10 la id ảnh
		trais[1] = new Trai(0, 10,11);
		trais[2] = new Trai(10, 10,12);
		trais[3] = new Trai(10, 0,13);
		
		circles = createCircles();
		vedich = createVedich();
		//4 nguoi choi voi so ngua ban dau duoc khoi tao
		players[0] = new Human(51, 1, 0, trais[0].getHorses(),players, trais);
		players[1] = new Human(52, 1, 0, trais[1].getHorses(),players, trais);
		players[2] = new Human(53, 1, 0, trais[2].getHorses(),players, trais);
		players[3] = new Human(54, 1, 0, trais[3].getHorses(),players, trais);
		RenderGame render = new RenderGame(trais, players);//truyen vao players
		render.setLayout(null);
		window.add(render);//add giao diện vào jframe
		window.setResizable(false);
		window.pack();
		window.setLocationRelativeTo(null);

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static Circle[] createCircles() {
		Circle[] c = new Circle[56];
		int j = 1;
		int k =0;
		c[0] = new Circle(7, 0, 20, k++,10);//(x,y,id,j) voi j la so o cua vong lap
		c[j++] = new Circle(6, 0, 21, k++,10);
		for (int i = 1; i < 7; i++) 
			c[j++] = new Circle(6, i, 20, k++,10);
		for (int i = 5; i >= 0; i--)
			c[j++] = new Circle(i, 6, 20, k++,10);
		c[j++] = new Circle(0, 7, 20, k++,10);
		c[j++] = new Circle(0, 8, 22, k++,10);
		for (int i = 1; i < 7; i++) 
			c[j++] = new Circle(i, 8, 20, k++,10);
		for (int i = 9; i < 15; i++) 
			c[j++] = new Circle(6, i, 20, k++,10);
		c[j++] = new Circle(7, 14, 20, k++,10);
		c[j++] = new Circle(8, 14, 24, k++,10);
		for (int i = 13; i >= 8; i--) 
			c[j++] = new Circle(8, i, 20, k++,10);
		for (int i = 9; i < 15; i++) 
			c[j++] = new Circle(i, 8, 20, k++,10);
		c[j++] = new Circle(14, 7, 20, k++,10);
		c[j++] = new Circle(14, 6, 23, k++,10);
		for (int i = 13; i >= 8; i--) 
			c[j++] = new Circle(i, 6, 20, k++,10);
		for (int i = 5; i >= 0; i--)
			c[j++] = new Circle(8, i, 20, k++,10);
		return c;
	}
	
	public static Vedich[] createVedich(){
		Vedich[] vd = new Vedich[24];
		int j = 0;
		vd[j++] = new Vedich(7,1,1,0);//6->11
		vd[j++]= new Vedich(7,2,2,1);
		vd[j++]= new Vedich(7,3,3,2);
		vd[j++]= new Vedich(7,4,4,3);
		vd[j++]= new Vedich(7,5,5,4);		
		vd[j++]= new Vedich(7,6,6,5);
		
		vd[j++]= new Vedich(1,7,1,6);//0->5
		vd[j++]= new Vedich(2,7,2,7);
		vd[j++]= new Vedich(3,7,3,8);
		vd[j++]= new Vedich(4,7,4,9);
		vd[j++]= new Vedich(5,7,5,10);
		vd[j++]= new Vedich(6,7,6,11);
		
		
		vd[j++]= new Vedich(7,13,1,12);//12->17
		vd[j++]= new Vedich(7,12,2,13);
		vd[j++]= new Vedich(7,11,3,14);
		vd[j++]= new Vedich(7,10,4,15);
		vd[j++]= new Vedich(7,9,5,16);
		vd[j++]= new Vedich(7,8,6,17);
		
		vd[j++]= new Vedich(13,7,1,18);//18->23
		vd[j++]= new Vedich(12,7,2,19);
		vd[j++]= new Vedich(11,7,3,20);
		vd[j++]= new Vedich(10,7,4,21);
		vd[j++]= new Vedich(9,7,5,22);
		vd[j++]= new Vedich(8,7,6,23);

		return vd;
		
	}
	
}
