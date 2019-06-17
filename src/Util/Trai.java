package Util;

import java.util.Arrays;

public class Trai {
	private int X;
	private int Y;
	private int ID;
	private int soCaNguaTrongChuong;
	private Horse[] horses = new Horse[4];
	
	public int getSoCaNguaTrongChuong() {
		return soCaNguaTrongChuong;
	}
	public void setSoCaNguaTrongChuong(int soCaNguaTrongChuong) {
		this.soCaNguaTrongChuong = soCaNguaTrongChuong;
	}
	public Trai(int X, int Y, int ID) {//1 chuong co 4 con ngua
		this.X = X;
		this.Y = Y;
		this.ID = ID;
		this.soCaNguaTrongChuong = 4;
		horses[0] = new Horse(ID + 20, X+1, Y+1, -1,0,-1);//ngua 1
		horses[1] = new Horse(ID + 20, X+3, Y+1, -1,0,-1);//ngua 2
		horses[2] = new Horse(ID + 20, X+1, Y+3, -1,0,-1);//ngua 3
		horses[3] = new Horse(ID + 20, X+3, Y+3, -1,0,-1);//ngua 4
	}
	
	public Horse[] getHorses()
	{
		
		return this.horses;
	}
	
	public int getX() {
		return X;
	}
	public void setX(int x) {
		X = x;
	}
	public int getY() {
		return Y;
	}
	public void setY(int y) {
		Y = y;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	
}
