package slmp.assembly;

import javax.swing.JPanel;
import java.awt.CardLayout;

public class CardLayoutJPanel extends JPanel {

	/**
	 * 
	 * 创建cardlayoutJPanel用与各JPanel之间切换
	 * 
	 */
	private CardLayout cardLayout;
	public CardLayoutJPanel() {
		//设置布局
		cardLayout = new CardLayout(0, 0);
		setLayout(cardLayout);
	}
	
	public CardLayout getCardLayout() {
		return cardLayout;
	}

}