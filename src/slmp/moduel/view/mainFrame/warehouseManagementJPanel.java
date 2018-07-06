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
import slmp.assembly.IconUpdateJButton;
import slmp.moduel.services.GoodsSer;
import slmp.moduel.services.WarehouseSer;
import slmp.moduel.view.hintFrame.BD_InsertJFrame;
import slmp.moduel.view.hintFrame.BD_UpdateJFrame;
import slmp.moduel.view.hintFrame.WH_InsertJFrame;
import slmp.moduel.view.hintFrame.WH_UpdateJFrame;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class warehouseManagementJPanel extends JPanel {
	private int sortNum = 0;
	private IconInsertJButton insert;
	private IconUpdateJButton write;
	private IconDeleteJButtion delete;
	private JTable table = null;
	private List<Object> warehouseID;
	private DefaultTableModel tableModel;
	private WH_InsertJFrame wh_insert;
	private WH_UpdateJFrame wh_update;

	/**
	 * Create the panel.
	 */
	public warehouseManagementJPanel() {
		WarehouseSer warehouse = new WarehouseSer();
		List list = null;
		Object[] title = {"序号", "仓库名称"};
		try {
			list = warehouse.selectAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Object[][] info = new Object[list.size()][2];
		warehouseID = new Vector<>();
		for (int i = 0; i < list.size(); i++) {
			warehouseID.add(((Object[]) list.get(i))[0]);
			info[i][0] = ((Object[]) list.get(i))[3];
			info[i][1] = ((Object[]) list.get(i))[1];
			if((int) info[i][0] > sortNum) {
				sortNum = (int) info[i][0]+1;
			}
		}
		setLayout(null);
		
		tableModel = new DefaultTableModel(info, title);
		table = new JTable(tableModel);
		JScrollPane scoll = new JScrollPane(table);
		scoll.setBounds(0, 31, 905, 348);
		add(scoll);
		
		//添加按钮
		insert = new IconInsertJButton();
		add(insert);
		
		write = new IconUpdateJButton();
		add(write);
		
		delete = new IconDeleteJButtion();
		add(delete);

		insert.addActionListener(new CRUDLisener());
		write.addActionListener(new CRUDLisener());
		delete.addActionListener(new CRUDLisener());
	}
	
	private class CRUDLisener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == insert) {
				wh_insert = new WH_InsertJFrame();
				wh_insert.runFrame(sortNum);
			}
			else if(e.getSource() == write) {
				try {
					int num = table.getSelectedRow();
					String id = warehouseID.get(num).toString();
					wh_update = new WH_UpdateJFrame();
					wh_update.runFrame(id);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(getRootPane(), "请选择物品！");
					e1.printStackTrace();
				}
			}
			else if(e.getSource() == delete) {
				if(JOptionPane.showConfirmDialog(getRootPane(), "确定要删除所选物品？") == JOptionPane.YES_NO_OPTION) {
					WarehouseSer warehouseSer = new WarehouseSer();
				    Object[] ID = new Object[1];
				    ID[0] = warehouseID.get(table.getSelectedRow());
				    try {
					    warehouseSer.deleteByID(ID);
					    JOptionPane.showMessageDialog(getRootPane(), "删除成功！");
					    tableModel.removeRow(table.getSelectedRow());
				    } catch (Exception e1) {
				    	JOptionPane.showMessageDialog(getRootPane(), "删除失败！");
					    e1.printStackTrace();
				    }
				}
				
			}
			
		}
	}
}
