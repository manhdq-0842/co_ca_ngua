package Handler;

import java.awt.Image;

public class ImageTool {
	private static final int IMAGE_MAX = 100;
	private static final int TRAI1 = 90;
	private static final int TRAI2 = 91;
	private static final int TRAI3 = 92;
	private static final int TRAI4 = 93;
	private static final int CIRCLE = 20;
	private static final int CIRCLE1 = 21;
	private static final int CIRCLE2 = 22;
	private static final int CIRCLE3 = 23;
	private static final int CIRCLE4 = 24;
	private static final int HORSE1 = 30;
	private static final int HORSE2 = 31;
	private static final int HORSE3 = 32;
	private static final int HORSE4 = 33;
	private static final int VEDICH1 = 1;
	private static final int VEDICH2 = 2;
	private static final int VEDICH3 = 3;
	private static final int VEDICH4 = 4;
	private static final int VEDICH5 = 5;
	private static final int VEDICH6 = 6;
	private static final int XUCXAC1 = 41;
	private static final int XUCXAC2 = 42;
	private static final int XUCXAC3 = 43;
	private static final int XUCXAC4 = 44;
	private static final int XUCXAC5 = 45;
	private static final int XUCXAC6 = 46;
	private static final int COCANGUA = 80;
	private static final int SPEAKER1 = 81;
	private static final int SPEAKER2 = 82;
	private static final int XUCXAC = 83;
	private static final int BOLUOT = 84;
	private static final int CHUONGDO = 10;
	private static final int CHUONGVANG = 11;
	private static final int CHUONGXANHDUONG = 12;
	private static final int CHUONGXANHLA = 13;
	
	private static Image[] image = new Image[IMAGE_MAX];
	public static void loadImages() {
		image[TRAI1] 	= Handler.getImage("Images/Capture1.PNG");//hinh trai
		image[TRAI2] 	= Handler.getImage("Images/Capture.PNG");
		image[TRAI3] 	= Handler.getImage("Images/Capture3.PNG");
		image[TRAI4] 	= Handler.getImage("Images/Capture2.PNG");
		
		image[CIRCLE] 	= Handler.getImage("Images/images.jpg");	
		image[CIRCLE1] 	= Handler.getImage("Images/images1.jpg");
		image[CIRCLE2] 	= Handler.getImage("Images/images2.jpg");
		image[CIRCLE3] 	= Handler.getImage("Images/images4.jpg");
		image[CIRCLE4] 	= Handler.getImage("Images/images3.jpg");
		
		image[HORSE1] = Handler.getImage("Images/DO.GIF");
		image[HORSE2] = Handler.getImage("Images/VANG.GIF");
		image[HORSE3] = Handler.getImage("Images/DUONG.GIF");
		image[HORSE4] = Handler.getImage("Images/XANH.GIF");
		
		image[VEDICH1] = Handler.getImage("Images/so1.PNG");
		image[VEDICH2] = Handler.getImage("Images/so2.PNG");
		image[VEDICH3] = Handler.getImage("Images/so3.PNG");
		image[VEDICH4] = Handler.getImage("Images/so4.PNG");
		image[VEDICH5] = Handler.getImage("Images/so5.PNG");
		image[VEDICH6] = Handler.getImage("Images/chienthang.jpg");
	
		image[XUCXAC1] = Handler.getImage("Images/1.JPG");
		image[XUCXAC2] = Handler.getImage("Images/2.JPG");
		image[XUCXAC3] = Handler.getImage("Images/3.JPG");
		image[XUCXAC4] = Handler.getImage("Images/4.JPG");
		image[XUCXAC5] = Handler.getImage("Images/5.JPG");
		image[XUCXAC6] = Handler.getImage("Images/6.JPG");
		image[COCANGUA] = Handler.getImage("Images/cocanguamoi.png");
		image[SPEAKER1] = Handler.getImage("Images/speaker1.png");
		image[SPEAKER2] = Handler.getImage("Images/speaker2.png");
		image[XUCXAC] = Handler.getImage("Images/XucXac.png");
		image[BOLUOT] = Handler.getImage("Images/boluot.png");
		
		image[CHUONGDO] = Handler.getImage("Images/chuongnguado.png");
		image[CHUONGVANG] = Handler.getImage("Images/chuongnguavang.png");
		image[CHUONGXANHDUONG] = Handler.getImage("Images/chuongnguaxanhduong.png");
		image[CHUONGXANHLA] = Handler.getImage("Images/chuongnguaxanhlacay.png");
	}

	
	public static Image getImage(int _ID) {
		loadImages();
		return image[_ID];
	}
}
