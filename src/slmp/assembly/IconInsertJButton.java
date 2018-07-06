package slmp.assembly;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class IconInsertJButton extends JButton {
	public IconInsertJButton() {
		ImageIcon icon = new ImageIcon("image/add.png");
		this.setBounds(0, 0, 27, 27);
		this.setIcon(icon);
		this.setBorderPainted(false);
		
	}

}
