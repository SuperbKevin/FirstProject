package slmp.moduel.view.mainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableColumnModelListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import slmp.assembly.IconDeleteJButtion;
import slmp.assembly.IconInsertJButton;
import slmp.assembly.IconUpdateJButton;
import slmp.moduel.services.CategorySer;
import slmp.moduel.services.GoodsSer;
import slmp.moduel.services.WarehouseSer;
import slmp.moduel.view.hintFrame.BD_InsertJFrame;
import slmp.moduel.view.hintFrame.BD_UpdateJFrame;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class BaseDataJPanel extends JPanel {

	private IconInsertJButton insert;
	private IconUpdateJButton write;
	private IconDeleteJButtion delete;
	private JTable table = null;
	private List<Object> goodsID;
	private DefaultTableModel tableModel;
	private BD_InsertJFrame bd_insert;
	private BD_UpdateJFrame bd_update;
	/**
	 * Create the panel.
	 */
	public BaseDataJPanel() {
		setLayout(null);
		
		String[] title = {"名称","价格","产地","所属分类","所属仓库","库存"};
		GoodsSer goods = new GoodsSer();
		CategorySer category = new CategorySer();
		WarehouseSer warehouse = new WarehouseSer();
		List list = new Vector();
		try {
			list = goods.selectAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Object[][] info = new Object[list.size()][6];
		goodsID = new Vector<>();
		for (int i = 0; i < list.size(); i++) {
			goodsID.add(((Object[]) list.get(i))[0]);
			info[i][0]=((Object[]) list.get(i))[1];
			info[i][1]=((Object[]) list.get(i))[2];
			info[i][2]=((Object[]) list.get(i))[3];
			Object[] ObjectArray1 = new Object[1];
			ObjectArray1[0] = ((Object[]) list.get(i))[6];
			Object[] ObjectArray2 = new Object[1];
			ObjectArray2[0] = ((Object[]) list.get(i))[5];
			try {
				info[i][3] = ((Object[])category.selectByID(ObjectArray1).get(0))[1];
				info[i][4] = ((Object[])warehouse.selectByID(ObjectArray2).get(0))[1];
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			info[i][5]=((Object[]) list.get(i))[4];
		}
		
		tableModel = new DefaultTableModel(info, title);
		table = new JTable(tableModel);
		JScrollPane scollPanel = new JScrollPane(table);
		scollPanel.setBounds(0, 31, 905, 390);
		add(scollPanel);
		
		//添加按钮
		insert = new IconInsertJButton();
		insert.addActionListener(new CRUDLisener());
		add(insert);
		
		write = new IconUpdateJButton();
		write.addActionListener(new CRUDLisener());
		add(write);
		
		delete = new IconDeleteJButtion();
		delete.addActionListener(new CRUDLisener());
		add(delete);
		
	}
	
	private class CRUDLisener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == insert) {
				bd_insert = new BD_InsertJFrame();
				bd_insert.runFrame();
			}
			else if(e.getSource() == write) {
				int num = table.getSelectedRow();
				String[] info = new String[7];
				try {
					for(int i=0; i<6; i++) {
						info[i] = table.getValueAt(num, i).toString();
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(getRootPane(), "请选择物品！");
					e1.printStackTrace();
				}
				info[6] = goodsID.get(num).toString();
				bd_update = new BD_UpdateJFrame();
				bd_update.runFrame(info);
				
			}
			else if(e.getSource() == delete) {
				if(JOptionPane.showConfirmDialog(getRootPane(), "确定要删除所选物品？") == JOptionPane.YES_NO_OPTION) {
					GoodsSer goodsSer = new GoodsSer();
				    Object[] ID = new Object[1];
				    ID[0] = goodsID.get(table.getSelectedRow());
				    try {
					    goodsSer.deleteByID(ID);
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
