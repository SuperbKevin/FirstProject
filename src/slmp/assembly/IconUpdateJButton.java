package slmp.assembly;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class IconUpdateJButton extends JButton {
	public IconUpdateJButton() {
		ImageIcon icon = new ImageIcon("image/modify.png");
		this.setBounds(30, 0, 27, 27);
		this.setIcon(icon);
		this.setBorderPainted(false);
	}

}
