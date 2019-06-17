package Handler;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Handler {
	public static Image getImage(String path) {
		ImageIcon img = new ImageIcon(path);
		return img.getImage();
	}
}
