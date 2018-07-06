package slmp.moduel.view.mainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JPanel;

import slmp.assembly.CardLayoutJPanel;
import java.awt.Color;

public class OrdersManagementJPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private CardLayoutJPanel cardPanel;
	private saleOrderJPanel saleOrder;
	private in_orderJPanel in_order;
	private out_orderJPanel out_order;
	private warehouseManagementJPanel warehouse;
	private JButton saleOrderButton;
	private JButton in_orderButton;
	private JButton out_orderButton;
	private JButton warehouseButton;
	private String userID;
	
	public String getUserID() {
		return userID;
	}
	
	public void setUserID(String userID) {
		this.userID = userID;
	}

	public OrdersManagementJPanel(String userID) {
		this.setUserID(userID);
		setLayout(null);
		
		cardPanel = new CardLayoutJPanel();
		cardPanel.setBounds(0, 42, 905, 420);
		this.add(cardPanel);
		
		//����cardlayout����
		saleOrder = new saleOrderJPanel(userID);
		in_order = new in_orderJPanel(userID);
		out_order = new out_orderJPanel(userID);
		warehouse = new warehouseManagementJPanel();
		
		cardPanel.add("saleOrder", saleOrder);
		cardPanel.add("in_order", in_order);
		cardPanel.add("out_order", out_order);
		cardPanel.add("warehouse", warehouse);
		
		//������ť
		saleOrderButton = new JButton("���۵�");
		saleOrderButton.setBounds(0, 0, 77, 27);
		saleOrderButton.setBorderPainted(false);
		add(saleOrderButton);
		
		in_orderButton = new JButton("��ⵥ");
		in_orderButton.setBounds(87, 0, 77, 27);
		in_orderButton.setBorderPainted(false);
		add(in_orderButton);
		
		out_orderButton = new JButton("���ⵥ");
		out_orderButton.setBounds(174, 0, 77, 27);
		out_orderButton.setBorderPainted(false);
		add(out_orderButton);
		
		warehouseButton = new JButton("�ֿ����");
		warehouseButton.setBounds(261, 0, 94, 27);
		warehouseButton.setBorderPainted(false);
		add(warehouseButton);
		
		//�󶨶����������¼�
		saleOrderButton.addActionListener(new shuffleListener());
		in_orderButton.addActionListener(new shuffleListener());
		out_orderButton.addActionListener(new shuffleListener());
		warehouseButton.addActionListener(new shuffleListener());

	}
	private class shuffleListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == saleOrderButton) {
				cardPanel.getCardLayout().show(cardPanel, "saleOrder");
				
			}
			else if(e.getSource() == in_orderButton) {
				cardPanel.getCardLayout().show(cardPanel, "in_order");
			}
			else if(e.getSource() == out_orderButton) {
				cardPanel.getCardLayout().show(cardPanel, "out_order");
			}
			else if(e.getSource() == warehouseButton) {
				cardPanel.getCardLayout().show(cardPanel, "warehouse");
			}
			
		}
		
	}
}
