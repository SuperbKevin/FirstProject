package slmp.assembly;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class ImageJPanel extends JPanel {
	/**
	 * 创建带有背景图片的JPanel类
	 */
	Image img;

	public Image getImg() {
		return img;
	}
	public void setImg(Image img) {
		this.img = img;
	}
	/**
	 * Create the panel.
	 */
	public ImageJPanel(Image img) {
		this.setImg(img);

	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	}

}
