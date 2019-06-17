package Util;

public class Circle {
	private int valueID;
	private int X;
	private int Y;
	private int pos;
	private int danhdau = 10;
	
	public Circle(int X, int Y, int value, int pos,int danhdau) {
		this.X = X;
		this.Y = Y;
		this.valueID = value;
		this.pos =pos;
		this.danhdau = danhdau;
	}
	

	public int getDanhdau() {
		return danhdau;
	}

	public void setDanhdau(int danhdau) {
		this.danhdau = danhdau;
	}

	public int getValueID() {
		return valueID;
	}
	public void setValueID(int valueID) {
		this.valueID = valueID;
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
	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}
	
}
