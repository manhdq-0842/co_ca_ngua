package Games;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import Player.Player;
import Util.Circle;
import Util.Horse;
import Util.Trai;
import Util.Vedich;
import Util.Xucxac;


public class RenderGame extends JPanel implements Runnable, MouseListener,ActionListener {
	Circle[] circles = DummiesGame.circles;
	Vedich[] vedich = DummiesGame.vedich;
	private static final long serialVersionUID = 1L;
	private static final int SCALE = 30;
	private static final int HUD = 70;
	private static final int HUD1 = 170;
	private static final int WIDTH = 17;
	private static final int HEIGHT = 16;
	int j = 1;
	Thread thread;
	private boolean exitGame = false;
	
	public Trai[] trais;
 	private Player[] players;
 	private Horse[][] horses = new Horse[4][4];//mang 2 chieu 4 phan tu
 	
 	private int X;
 	private int Y;
 	
 	
 	int turn  = 0; // nguoi choi
	int soBuoc = 0;//buoc di
 	boolean isActive = false;
 	public final JButton bt3 =  new JButton("");
 	
	public RenderGame(Trai[] trais,  Player[] players) {
		this.trais = trais; 
		this.players = players;
		setPreferredSize(new Dimension(WIDTH * SCALE+HUD1, HEIGHT * SCALE+HUD)); /*ham nay dung de tao kich thuoc cho component*/
		setFocusable(true);
		requestFocus();//tao kich thuoc cho jframe
		turn = 0;
		Xucxac.setSocham(0);
		horses[0] = players[0].getHorses();
		horses[1] = players[1].getHorses();
		horses[2] = players[2].getHorses();
		horses[3] = players[3].getHorses();
		
		JButton bt =  new JButton();
		bt.setIcon(new ImageIcon(Handler.ImageTool.getImage(83)));
		bt.setBounds(18*30, 30, 100, 30);
		this.add(bt);
		bt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				bt3.setIcon(new ImageIcon(Handler.ImageTool.getImage(30+turn)));
				if (isActive == false) {
				Random rand = new Random();
				soBuoc = rand.nextInt(6) + 1;
				Xucxac.setSocham(soBuoc);
				System.out.println(soBuoc + " turn " + (turn+1));
				isActive = true;
				//X = 0; Y = 0;
				}
			}
			
		});
		
		final JButton bt2 =  new JButton("");
		bt2.setIcon(new ImageIcon(Handler.ImageTool.getImage(82)));
		bt2.setBounds(18*30+100+10, 0, 30, 30);
		this.add(bt2);
		bt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	if(j==0){
            		bt2.setIcon(new ImageIcon(Handler.ImageTool.getImage(82))); 
            		Start.music.stop();
            		Start.music.play();
            		j = 1;
            	}else{
            		bt2.setIcon(new ImageIcon(Handler.ImageTool.getImage(81)));
            		Start.music.stop();
            		j = 0;
        		}
            }
        });
		
		//bt3
		bt3.setIcon(new ImageIcon(Handler.ImageTool.getImage(30+turn)));
		bt3.setBounds(18*30+40, 300, 30, 30);
		this.add(bt3);
		bt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            		bt3.setIcon(new ImageIcon(Handler.ImageTool.getImage(30+turn))); 
            }
        });
		
		
		JButton boluot =  new JButton();
		boluot.setIcon(new ImageIcon(Handler.ImageTool.getImage(84)));
		boluot.setBounds(18*30, 7*30, 100, 30);
		this.add(boluot);
		boluot.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
			
			Xucxac.setSocham(0);
			isActive = false;	
			if (turn < 3)
				turn++;
			else 
				turn = 0;
			}
			});
	
	}
	
	public void addNotify() {
		super.addNotify();
		if(thread == null) {
			addMouseListener(this);
			thread = new Thread(this);
			thread.start();
		}
	}

	@Override
	public void run() {												//code chạy
		
		while(!exitGame) {	
															
			if (isActive)									
			{
				//System.out.println("turn " + turn);
				if (Xucxac.isTrangthai() == 6) {
				int go = players[turn].go(X, Y, soBuoc, turn);
				
				if(go != 0  && go != 1 && go !=2) {
					Xucxac.setSocham(0);
					int luot = go;
					trais[luot -10].setSoCaNguaTrongChuong((trais[luot - 10].getSoCaNguaTrongChuong()+1));
					go = players[luot - 10].vetrai(luot);
					go = players[turn].tienquan(X, Y, soBuoc, turn);
				}
				
				if(go == 2) { //xuat quan
					trais[turn].setSoCaNguaTrongChuong(trais[turn].getSoCaNguaTrongChuong()-1);
					Xucxac.setSocham(0);
					isActive = false;//xuc tiep
				}
				
				if (go == 1) {		//da thuc hien
					Xucxac.setSocham(0);
					isActive = false;//xuc tiep
				}
			}
				else if (trais[turn].getSoCaNguaTrongChuong() != 4)//so ca ngua trong chuong < 4
				{
					int go = players[turn].go(X, Y, soBuoc, turn);
					if(go != 0  && go != 1) {//da ngua
						Xucxac.setSocham(0);
						int luot = go;
						players[luot - 10].vetrai(luot);
						go = players[turn].tienquan(X, Y, soBuoc, turn);
					}
					
					if (go == 1 ) {
						//System.out.println("So ca trong trai " + trais[turn].getSoCaNguaTrongChuong());
						turn++;
						if (turn == 4)						//den nguoi thu 4 thi quay tro ve nguoi dau tien
							turn = 0;
						Xucxac.setSocham(0);
						isActive = false;
					}
				}
				else {
					//System.out.println("So ca trong trai"+trais[turn].getSoCaNguaTrongChuong());
					turn++;
					if (turn == 4)
						turn = 0;
					isActive = false;
				}
				
			}
			/*cap nhat vi tri moi cho ca ngua*/
			repaint();
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {//tạo giao diện
		super.paintComponent(g);
		g.drawImage(Handler.ImageTool.getImage(40 +Xucxac.isTrangthai()), 19*30, 100, 60, 60,null);
		for (Vedich v: vedich) 
			g.drawImage(Handler.ImageTool.getImage(v.getValue()), v.getX()*SCALE + SCALE, v.getY()*SCALE + SCALE, SCALE, SCALE,null);
		for (Trai t : trais)//element
			g.drawImage(Handler.ImageTool.getImage(t.getID()), t.getX()*SCALE + SCALE, t.getY()*SCALE+SCALE,5*SCALE,5*SCALE,null);//(id,x,y,width,height,i)
		for (Circle c: circles) 
			g.drawImage(Handler.ImageTool.getImage(c.getValueID()), c.getX()*SCALE + SCALE, c.getY()*SCALE + SCALE, SCALE, SCALE,null);//circle
		for (Horse h: horses[0]) 
			g.drawImage(Handler.ImageTool.getImage(h.getID()), h.getX()*SCALE + SCALE, h.getY()*SCALE + SCALE, SCALE, SCALE,null);
		for (Horse h: horses[1]) 
			g.drawImage(Handler.ImageTool.getImage(h.getID()), h.getX()*SCALE + SCALE, h.getY()*SCALE + SCALE, SCALE, SCALE,null);
		for (Horse h: horses[2]) 
			g.drawImage(Handler.ImageTool.getImage(h.getID()), h.getX()*SCALE + SCALE, h.getY()*SCALE + SCALE, SCALE, SCALE,null);
		for (Horse h: horses[3]) 
			g.drawImage(Handler.ImageTool.getImage(h.getID()), h.getX()*SCALE + SCALE, h.getY()*SCALE + SCALE, SCALE, SCALE,null);
	} 
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		// click to go//click hien thi toa do cua X va Y
		X = (int) arg0.getX()/SCALE -1;
		Y = (int) arg0.getY()/SCALE -1;
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	

}
