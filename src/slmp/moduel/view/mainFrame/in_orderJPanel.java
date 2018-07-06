package slmp.moduel.view.mainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import slmp.assembly.IconDeleteJButtion;
import slmp.assembly.IconInsertJButton;
import slmp.moduel.services.CategorySer;
import slmp.moduel.services.GoodsSer;
import slmp.moduel.services.StockOrderSer;
import slmp.moduel.services.UserSer;
import slmp.moduel.services.WarehouseSer;
import slmp.moduel.view.hintFrame.IO_InsertJFrame;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class in_orderJPanel extends JPanel {
	private IconInsertJButton insert;
	private IconDeleteJButtion delete;
	private List<Object> stockID;
	private JTable table;
	private DefaultTableModel tableModel;
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
	public in_orderJPanel(String id) {
		this.setUserID(id);
		
		StockOrderSer in_order = new StockOrderSer();
		GoodsSer goods = new GoodsSer();
		CategorySer category = new CategorySer();
		WarehouseSer warehouse = new WarehouseSer();
		UserSer user = new UserSer();
		List list = null;
		Object[] title = {"订单号", "商品名称", "入库数量", "所属分类", "所属仓库", "经手人"};
		
		try {
			list = in_order.selectAllStockInput();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Object[][] info = new Object[list.size()][6];
		stockID = new Vector<>();
		for (int i = 0; i < list.size(); i++) {
			stockID.add(((Object[]) list.get(i))[0]);
			info[i][0] = ((Object[]) list.get(i))[1];
			Object[][] ObjectArray = new Object[4][1];
			ObjectArray[0][0] = ((Object[]) list.get(i))[6];
			info[i][2] = ((Object[]) list.get(i))[5];
			ObjectArray[1][0] = ((Object[]) list.get(i))[4];
			ObjectArray[2][0] = ((Object[]) list.get(i))[3];
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
		
		tableModel = new DefaultTableModel(info, title);
		table = new JTable(tableModel);
		JScrollPane scoll = new JScrollPane(table);
		scoll.setBounds(0, 31, 905, 348);
		add(scoll);
		
		
		//添加按钮监听器
		insert = new IconInsertJButton();
		add(insert);
		
		delete = new IconDeleteJButtion();
		delete.setBounds(30, 0, 27, 27);
		add(delete);
		
		insert.addActionListener(new CRUDLisener());
		delete.addActionListener(new CRUDLisener());

	}
	
	private class CRUDLisener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == insert) {
				IO_InsertJFrame insertFrame = new IO_InsertJFrame();
				insertFrame.runFrame(userID);
			}
			else if(e.getSource() == delete) {
				if(JOptionPane.showConfirmDialog(getRootPane(), "确定要删除所选物品？") == JOptionPane.YES_NO_OPTION) {
					StockOrderSer stockSer = new StockOrderSer();
				    Object[] ID = new Object[1];
				    ID[0] = stockID.get(table.getSelectedRow());
				    try {
					    stockSer.deleteStockById(ID);
				    } catch (Exception e1) {
				    	JOptionPane.showMessageDialog(getRootPane(), "删除失败！");
					    e1.printStackTrace();
				    }
				    tableModel.removeRow(table.getSelectedRow());
				    JOptionPane.showMessageDialog(getRootPane(), "删除成功！");
				}
			}
	    }
	}

}
