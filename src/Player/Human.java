package Player;

import Games.DummiesGame;
import Games.RenderGame;
import Util.Circle;
import Util.Horse;
import Util.Trai;
import Util.Vedich;

public class Human extends Player  {
	Circle[] circles = DummiesGame.circles;
	Vedich[] vedich = DummiesGame.vedich;
	private Trai[] trais;
	private Player[] players;
	public Human(int ID, int diemXP, int diemdung, Horse[] horses,Player[] players, Trai[] trais) {
		super(ID, diemXP, diemdung, horses);
		this.players = players;
		this.trais = trais;
		
	}

	@Override
	public int go(int X, int Y, int soBuoc, int turn) {
		if(winner() == 1) {
			System.out.println("Nguoi chien thang la nguoi choi thu " + turn);
			return 0;
			}
		
		if (soBuoc != 0) {
			if (soBuoc == 6) {
				for (Horse h: getHorses()) {
					if (h.getPosition() == -1) {
						int i = 0;
						switch(turn) {
						case 0: 
							i = 1;					
							break;
						case 1: 
							i = 15;								
							break;
						case 2:
							i = 29;					
							break;
						default:
							i = 43;					
							break;
						}
						
						if (X == h.getX() && Y == h.getY()) {
							if(circles[i].getDanhdau() == 10) {
							circles[i].setDanhdau(turn);
							xuatquan(h, i,turn);
								 return 2;
							}
							else return 0;
						}
					}
				}
			}
			
			for (Horse h: getHorses()) {
										
				int pos = h.getPosition();	
				int pid = h.getWinner();
				if (pos == -1) {
					continue;
				}
				//ve dich
				if( pid != -1 && h.getSteped() == 55) {
				if((vedich[pid].getX() == X && vedich[pid].getY()  == Y && h.getWinner() != -1)){
				vedich(h, turn, soBuoc,pos);
				return 1;
					}
				}
				else
				if ((h.getX() == X && h.getY() == Y && h.getWinner() == - 1)) {
					//di qua o thu 0
					
					if(pos + soBuoc > 55) {
						pos = pos - 56;
					}
											
					if(((pos + soBuoc) == 1 || (pos + soBuoc == 15) || (pos + soBuoc) == 29 || (pos + soBuoc) == 43) && (h.getSteped() + soBuoc < 55)) {
						if(pos<0) {
							circles[pos + 56].setDanhdau(10);
						}
						else {
						circles[pos].setDanhdau(10);
						}
						pos = pos + 1;
						h.setSteped(1);
					}
					
						//da ngua
						if((circles[pos + soBuoc].getDanhdau()) != 10 && (h.getSteped() + soBuoc <= 55)) {
							if((circles[pos + soBuoc].getDanhdau()) != turn){
							int luot = circles[pos+ soBuoc].getDanhdau();
							circles[pos+ soBuoc].setDanhdau(-1);
																				
							return  luot + 10;					
							}
							else return 0;//khong duoc di
						}
					if((h.getSteped() + soBuoc) > 55 && h.getSteped() != 55) {
							return 0;
						}	

				
					if(h.getSteped() == 55) {
						circles[pos].setDanhdau(10);
						vedich(h, turn, soBuoc,pos);
						return 1;
						}
					else {
						int x = circles[pos+soBuoc].getX();
						int y = circles[pos+soBuoc].getY();
						
						if(pos >= 0 && h.getSteped() <= 55) {
							circles[pos].setDanhdau(10);	
							circles[pos + soBuoc].setDanhdau(turn);		
						}
						
						if(pos < 0 && h.getSteped() <= 55) {
							circles[pos + 56].setDanhdau(10);	
							circles[pos+ soBuoc].setDanhdau(turn);		//da xong set lai circles cua nguoi choi vua da ngua	
						}
								
						h.setX(x);
						h.setY(y);
						h.setWinner(-1);
						h.setPosition(circles[pos+soBuoc].getPos());

						
						if((h.getSteped() + soBuoc) <= 55 ) {
						h.setSteped(soBuoc);
						//System.out.println("steps " + h.getSteped());
						}
						return 1;
							}
						}
					}
				}
		return 0;//ham chua thuc hien
	}
	
	public int xuatquan(Horse h, int vitri,int turn) {//i la cac so 1-15-29-43 tuy thuoc vao mau` quan ca ngua
					
					h.setX(circles[vitri].getX());
					h.setY(circles[vitri].getY());
					h.setPosition(circles[vitri].getPos());
					h.setSteped(0);
		return 1;
	}

	public int tienquan(int X, int Y, int soBuoc, int turn) {
		for (Horse h: getHorses()) {
			int pos = h.getPosition();	
			if (pos == -1) {
					continue;
						}
			
			if (circles[pos].getX() == X && circles[pos].getY() == Y) {
				if(pos + soBuoc >55) {
				}
				
				if(((pos + soBuoc) == 1 || (pos + soBuoc == 15) || (pos + soBuoc) == 29 || (pos + soBuoc) == 43) && (h.getSteped() + soBuoc < 55)) {
					pos = pos + 1;
					h.setSteped(1);
				}
				
				int x = circles[pos+soBuoc].getX();
				int y = circles[pos+soBuoc].getY();
				
				if(pos >= 0) {
					circles[pos].setDanhdau(10);	
					circles[pos+ soBuoc].setDanhdau(turn);		//da xong set lai circles cua nguoi choi vua da ngua
				}
				
				if(pos < 0 && h.getSteped() != 0) {
					circles[pos + 56].setDanhdau(10);	
					circles[pos+ soBuoc].setDanhdau(turn);		//da xong set lai circles cua nguoi choi vua da ngua	
				}
				
				h.setX(x);
				h.setY(y);
				h.setPosition(circles[pos+soBuoc].getPos());
				if((h.getSteped() + soBuoc) <= 55 ) {
					h.setSteped(soBuoc);
				}
				
				
				return 1;
				}
			}		
		return 0;		
	}
	
	
	public int vetrai(int turn) {//da ngua ve chuong
		int vitri = 0;
					for(Horse h: getHorses()) {
						if(h.getPosition() == -1) {
							continue;
						}
						for(Circle c: circles) {
							if(c.getDanhdau()== -1) {
								vitri = c.getPos();	
							}
						}
						
						if(h.getPosition() == vitri) {
							int traiID = h.getID()- 20;
							for (Trai trai: trais) {
								if (trai.getID() == traiID) {
									Horse[] horses = trai.getHorses();
									int p = 0;
									for (Horse horse: horses) {
										
										if (horse.getX() == h.getX() && horse.getY() == h.getY()) {
											if (p == 0) {
												h.setX(trai.getX()+1);
												h.setY(trai.getY()+1);
												h.setPosition(-1);
												h.setSteped(-h.getSteped());
												h.setWinner(-1);
												trai.setSoCaNguaTrongChuong(trai.getSoCaNguaTrongChuong()+1);
											}
											else if (p == 1) {
												h.setX(trai.getX()+3);
												h.setY(trai.getY()+1);
												h.setPosition(-1);
												h.setSteped(-h.getSteped());
												h.setWinner(-1);
												trai.setSoCaNguaTrongChuong(trai.getSoCaNguaTrongChuong()+1);
											}
											else if (p == 2) {
												h.setX(trai.getX()+1);
												h.setY(trai.getY()+3);
												h.setPosition(-1);
												h.setSteped(-h.getSteped());
												h.setWinner(-1);
												trai.setSoCaNguaTrongChuong(trai.getSoCaNguaTrongChuong()+1);
											}
											else {
												h.setX(trai.getX()+3);
												h.setY(trai.getY()+3);
												h.setPosition(-1);
												h.setSteped(-h.getSteped());
												h.setWinner(-1);
												trai.setSoCaNguaTrongChuong(trai.getSoCaNguaTrongChuong()+1);
											}
									
										}
										p++;
									}
								}
							}
						}
					}
					
					circles[vitri].setDanhdau(10);
					return 1;
	}
	
	public int vedich(Horse horse,int turn,int socham,int pos) {
			switch(turn) {
			case 0:
				{
				horse.setX(vedich[socham - 1].getX());
				horse.setY(vedich[socham - 1].getY());
				horse.setPosition(vedich[socham - 1].getPos());
				horse.setSteped(0);
				circles[horse.getPosition()].setDanhdau(10);
				horse.setWinner(vedich[socham - 1].getPos());
				break;
				}
				case 1:
			{	horse.setX(vedich[socham + 5].getX());
				horse.setY(vedich[socham + 5].getY());
				horse.setPosition(vedich[socham + 5].getPos());
				horse.setSteped(0);
				circles[horse.getPosition()].setDanhdau(10);
				horse.setWinner(vedich[socham + 5].getPos());
				break;
			}
			case 2:
			{
				horse.setX(vedich[socham + 11].getX());
				horse.setY(vedich[socham + 11].getY());
				horse.setPosition(vedich[socham + 11].getPos());
				horse.setSteped(0);				
				circles[horse.getPosition()].setDanhdau(10);
				horse.setWinner(vedich[socham + 11].getPos());
				break;
			}
			default:
			{
				horse.setX(vedich[socham + 17].getX());
				horse.setY(vedich[socham + 17].getY());
				horse.setPosition(vedich[socham + 17].getPos());
				circles[horse.getPosition()].setDanhdau(10);
				horse.setSteped(0);
				horse.setWinner(vedich[socham + 17].getPos());
				break;
				}
			}
		return 1;
	}
	
	public int winner() {
		int dem = 0;
		int ngua = 0;
		for(Horse h: getHorses()) {
			if(h.getWinner() == 3)
				dem++;
			if(h.getWinner() == 4)
				dem++;
			if(h.getWinner() == 5)
				dem++;
			if(h.getWinner() == 6)
				dem++;
			ngua++;
			if(ngua == 4) break;
			
		}
		if(dem == 4) {
			return 1;
		}
		
		return 0;
	}
}



