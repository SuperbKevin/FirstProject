package slmp.moduel.view.mainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import slmp.assembly.IconInsertJButton;
import slmp.moduel.services.CategorySer;
import slmp.moduel.services.GoodsSer;
import slmp.moduel.services.SaleOrderSer;
import slmp.moduel.services.UserSer;
import slmp.moduel.services.WarehouseSer;
import slmp.moduel.view.hintFrame.SO_InsertJFrame;

public class saleOrderJPanel extends JPanel {

	private String userID;
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	/**
	 * Create the panel.
	 */
	public saleOrderJPanel(String userID) {
		this.setUserID(userID);
		
		SaleOrderSer saleOrder = new SaleOrderSer();
		GoodsSer goods = new GoodsSer();
		CategorySer category = new CategorySer();
		WarehouseSer warehouse = new WarehouseSer();
		UserSer user = new UserSer();
		List list = null;
		Object[] title = {"订单号", "商品名称", "销售数量", "所属分类", "所属仓库", "经手人"};
		
		try {
			list = saleOrder.selectAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Object[][] info = new Object[list.size()][6];
		for (int i = 0; i < list.size(); i++) {
			info[i][0] = ((Object[]) list.get(i))[1];
			Object[][] ObjectArray = new Object[4][1];
			ObjectArray[0][0] = ((Object[]) list.get(i))[6];
			info[i][2] = ((Object[]) list.get(i))[5];
			ObjectArray[1][0] = ((Object[]) list.get(i))[3];
			ObjectArray[2][0] = ((Object[]) list.get(i))[4];
			ObjectArray[3][0] = ((Object[]) list.get(i))[2];
			try {
				info[i][1] = ((Object[])goods.selectByID(ObjectArray[0]).get(0))[1];
				info[i][3] = ((Object[])category.selectByID(ObjectArray[1]).get(0))[1];
				info[i][4] = ((Object[])warehouse.selectByID(ObjectArray[2]).get(0))[1];
				info[i][5] = ((Object[])user.selectByID(ObjectArray[3]).get(0))[1];
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		setLayout(null);
		
		JTable table = new JTable(info, title);
		JScrollPane scoll = new JScrollPane(table);
		scoll.setBounds(0, 31, 905, 348);
		add(scoll);
		
		IconInsertJButton insert = new IconInsertJButton();
		add(insert);
		insert.addActionListener(new CRUDLisener());

	}
	private class CRUDLisener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			SO_InsertJFrame insertFrame = new SO_InsertJFrame();
			insertFrame.runFrame(userID);
	    }
	}

}
