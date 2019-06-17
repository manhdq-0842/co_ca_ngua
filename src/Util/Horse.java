package Util;

public class Horse {
	private int ID;
	private int position;
	private int X;
	private int Y;
	private int steped;
	private int winner;
	
	public Horse(int iD, int x, int y, int position,int steped,int winner) {
		ID = iD;
		this.position = position;
		X = x;
		Y = y;
		this.steped = steped;
		this.winner = winner;
		
	}
	public int getWinner() {
		return winner;
	}
	public void setWinner(int winner) {
		this.winner = winner;
	}
	public int getSteped() {
		return steped;
	}
	public void setSteped(int steped) {
		this.steped += steped;
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
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	
	}
		
}
