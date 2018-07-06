package slmp.assembly;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class IconDeleteJButtion extends JButton {
	public IconDeleteJButtion() {
		ImageIcon icon = new ImageIcon("image/delete.png");
		this.setBounds(60, 0, 27, 27);
		this.setIcon(icon);
		this.setBorderPainted(false);
	}

}
