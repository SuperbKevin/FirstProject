package slmp.assembly;

import javax.swing.JPanel;
import java.awt.CardLayout;

public class CardLayoutJPanel extends JPanel {

	/**
	 * 
	 * ����cardlayoutJPanel�����JPanel֮���л�
	 * 
	 */
	private CardLayout cardLayout;
	public CardLayoutJPanel() {
		//���ò���
		cardLayout = new CardLayout(0, 0);
		setLayout(cardLayout);
	}
	
	public CardLayout getCardLayout() {
		return cardLayout;
	}

}