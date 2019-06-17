package Util;

public class Vedich {
	private int id;
	private int x;
	private int y;
	private int pos;
	
	public Vedich(int x, int y,int id,int pos) {
		this.id = id;
		this.x = x;
		this.y = y;
		this.pos = pos;
	}
	
	public int getPos() {
		return pos;
	}
	public void setPos(int pos) {
		this.pos = pos;
	}
	
	public int getValue() {
		return id;
	}
	public void setValue(int id) {
		this.id = id;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}
