package Player;


import Util.Horse;

public abstract class Player {
	private int ID;
	private int diemdung;
	private int diemdungChuong;
	private int diemXP;
	private int soNguaVaoChuong = 0;
	private int X;
	
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

	private int Y;
	
	public int getDiemXP() {
		return diemXP;
	}

	public void setDiemXP(int diemXP) {
		this.diemXP = diemXP;
	}

	private Horse[] horses;
	
	Player(int ID, int diemXP, int diemdung, Horse[] horses) {
		this.ID = ID;
		this.diemdung = diemdung;
		this.diemXP = diemXP;
		this.diemdungChuong = 6;
		this.horses = horses;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getDiemdung() {
		return diemdung;
	}

	public void setDiemdung(int diemdung) {
		this.diemdung = diemdung;
	}

	public int getDiemdungChuong() {
		return diemdungChuong;
	}

	public void setDiemdungChuong(int diemdungChuong) {
		this.diemdungChuong = diemdungChuong;
	}

	public int getSoNguaVaoChuong() {
		return soNguaVaoChuong;
	}

	public void setSoNguaVaoChuong(int soNguaVaoChuong) {
		this.soNguaVaoChuong = soNguaVaoChuong;
	}

	public Horse[] getHorses() {
		return horses;
	}

	public void setHorses(Horse[] horses) {
		this.horses = horses;
	}
	
	public abstract int go(int X, int Y, int soBuoc, int turn);
	public abstract int vetrai(int turn);
	public abstract int tienquan(int X, int Y, int soBuoc, int turn);
}
