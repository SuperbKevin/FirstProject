package slmp.moduel.view.hintFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import slmp.assembly.IDGenerator;
import slmp.moduel.services.CategorySer;
import slmp.moduel.services.GoodsSer;
import slmp.moduel.services.StockOrderSer;
import slmp.moduel.services.UserSer;
import slmp.moduel.services.WarehouseSer;

public class OO_InsertJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField amount;
	private List<Object> categoryID;
	private List<Object> warehouseID;
	private List<Object> goodsID;
	private JComboBox category;
	private JComboBox warehouse;
	private JComboBox goods;
	private String userID;
	private JLabel title;
	private JButton save;
	
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	/**
	 * Launch the application.
	 */
	public void runFrame(String id) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OO_InsertJFrame frame = new OO_InsertJFrame();
					frame.setUserID(id);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public OO_InsertJFrame() {
		setBounds(100, 100, 523, 340);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		title = new JLabel("出库信息");
		title.setBounds(210, 13, 72, 18);
		contentPane.add(title);
		
		JLabel lblNewLabel = new JLabel("商品名称");
		lblNewLabel.setBounds(101, 63, 72, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("出库数量");
		lblNewLabel_1.setBounds(101, 119, 72, 18);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("所属分类");
		lblNewLabel_2.setBounds(101, 178, 72, 18);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("所属仓库");
		lblNewLabel_3.setBounds(101, 230, 72, 18);
		contentPane.add(lblNewLabel_3);
		
		save = new JButton("保存");
		save.setBounds(218, 267, 64, 27);
		contentPane.add(save);
		
		save.addActionListener(new saveListener());
		
		amount = new JTextField();
		amount.setBounds(254, 116, 234, 24);
		contentPane.add(amount);
		amount.setColumns(10);
		
		//获取所有分类
		CategorySer categorySer = new CategorySer();
		List list = null;
		try {
			list = categorySer.selectAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Object[] categoryArray = new Object[list.size()];
		categoryID = new Vector<>();
		for (int i = 0; i < categoryArray.length; i++) {
			categoryID.add(((Object[])(list.get(i)))[0]);
			categoryArray[i] = ((Object[])(list.get(i)))[1];
		}
		category = new JComboBox(categoryArray);
		category.setBounds(254, 175, 234, 24);
		contentPane.add(category);
		
		//获取所有仓库
		WarehouseSer warehouseSer = new WarehouseSer();
		try {
			list = warehouseSer.selectAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Object[] warehouseArray = new Object[list.size()];
		warehouseID = new Vector<>();
		for (int i = 0; i < warehouseArray.length; i++) {
			warehouseID.add(((Object[])(list.get(i)))[0]);
			warehouseArray[i] = ((Object[])(list.get(i)))[1];
		}
		warehouse = new JComboBox(warehouseArray);
		warehouse.setBounds(254, 227, 234, 24);
		contentPane.add(warehouse);
		
		//获取所有物品
		GoodsSer goodsSer = new GoodsSer();
		try {
			list = goodsSer.selectAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Object[] goodsArray = new Object[list.size()];
		goodsID = new Vector<>();
		for (int i = 0; i < goodsArray.length; i++) {
			goodsID.add(((Object[])(list.get(i)))[0]);
			goodsArray[i] = ((Object[])(list.get(i)))[1];
		}
		goods = new JComboBox(goodsArray);
		goods.setBounds(254, 60, 234, 24);
		contentPane.add(goods);
	}
	
	private class saveListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Object[] param = new Object[7];
			Object[] para = new Object[2];
			Object[] id = new Object[1];
			
			if(amount.getText() != null) {
				StockOrderSer stockOrderSer = new StockOrderSer();
				GoodsSer goodsSer = new GoodsSer();
				
				param[0] = IDGenerator.generateID();
				param[1] = "16061518070001";
				//获得用户id
				UserSer userSer = new UserSer();
				param[2] = userID;
				param[3] = warehouseID.get(warehouse.getSelectedIndex());
				param[4] = categoryID.get(category.getSelectedIndex());
				param[5] = amount.getText();
				param[6] = goodsID.get(goods.getSelectedIndex());
				
				//修改物品库存
				id[0] = param[6];
				List list = new Vector<>();
				try {
					list = goodsSer.selectByID(id);
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				Double stock1 = new Double(((Object[])list.get(0))[4].toString());
				Double stock2 = new Double(param[5].toString());
				stock1 -= stock2;
				para[0] = stock1;
				para[1] = param[6];
				
				try {
					stockOrderSer.insertStockOutput(param);
					goodsSer.updateStockByID(para);
					JOptionPane.showMessageDialog(getRootPane(), "添加成功！");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(getRootPane(), "添加失败！");
					e1.printStackTrace();
				}
				dispose();
			}
			else {
				JOptionPane.showMessageDialog(contentPane, "请输入销售数量");
			}
		}
		
	}

}
