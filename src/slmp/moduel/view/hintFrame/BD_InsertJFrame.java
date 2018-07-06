package slmp.moduel.view.hintFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.UUID;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import slmp.assembly.IDGenerator;
import slmp.moduel.services.CategorySer;
import slmp.moduel.services.GoodsSer;
import slmp.moduel.services.WarehouseSer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class BD_InsertJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField price;
	private JTextField location;
	private JTextField amount;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JComboBox category;
	private JComboBox warehouse;
	private List<Object> categoryID;
	private List<Object> warehouseID;
	private JLabel title;

	/**
	 * Launch the application.
	 */
	public void runFrame() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BD_InsertJFrame frame = new BD_InsertJFrame();
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
	public BD_InsertJFrame() {
		this.setTitle("�����Ʒ");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 632, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		title = new JLabel("��Ʒ��Ϣ");
		title.setBounds(224, 13, 72, 18);
		contentPane.add(title);
		
		//��Ӱ������󶨼�����
		JButton save = new JButton("����");
		save.setBounds(233, 300, 63, 27);
		contentPane.add(save);
		save.addActionListener(new saveListener());
		
		name = new JTextField();
		name.setBounds(304, 57, 296, 24);
		contentPane.add(name);
		name.setColumns(10);
		
		price = new JTextField();
		price.setBounds(304, 94, 296, 24);
		contentPane.add(price);
		price.setColumns(10);
		
		location = new JTextField();
		location.setBounds(304, 134, 296, 24);
		contentPane.add(location);
		location.setColumns(10);
		
		amount = new JTextField();
		amount.setBounds(304, 171, 296, 24);
		contentPane.add(amount);
		amount.setColumns(10);
		
		//��ȡ���з���
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
		category.setBounds(304, 208, 296, 24);
		contentPane.add(category);
		
		//��ȡ���вֿ�
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
		warehouse.setBounds(304, 245, 296, 24);
		contentPane.add(warehouse);
		
		
		//��ӱ�ǩ
		JLabel lblNewLabel_1 = new JLabel("��Ʒ����");
		lblNewLabel_1.setBounds(122, 60, 72, 18);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("��Ʒ�۸�");
		lblNewLabel_2.setBounds(122, 100, 72, 18);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("��Ʒ����");
		lblNewLabel_3.setBounds(122, 137, 72, 18);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("��Ʒ���");
		lblNewLabel_4.setBounds(122, 174, 72, 18);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("��������");
		lblNewLabel_5.setBounds(122, 211, 72, 18);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("�����ֿ�");
		lblNewLabel_6.setBounds(122, 248, 72, 18);
		contentPane.add(lblNewLabel_6);
	}
	
	private class saveListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Object[] param = new Object[7];
			if(name.getText() != null) {
				param[1] = name.getText();
				if(price.getText() != null) {
					param[2] = price.getText();
					if(location.getText() != null) {
						param[3] = location.getText();
						if(amount.getText() != null) {
							param[4] = amount.getText();
							param[5] = warehouseID.get(warehouse.getSelectedIndex());
							param[6] = categoryID.get(category.getSelectedIndex());
							
							//�Զ�����32λid
							param[0] = IDGenerator.generateID();
							
							GoodsSer goodsSer = new GoodsSer();
							try {
								goodsSer.insert(param);
								JOptionPane.showMessageDialog(getRootPane(), "��ӳɹ���");
							} catch (Exception e1) {
								JOptionPane.showMessageDialog(getRootPane(), "���ʧ�ܣ�");
								e1.printStackTrace();
							}
							dispose();
						}
						else {
							JOptionPane.showMessageDialog(contentPane, "��������Ʒ���");
						}
					}
					else {
						JOptionPane.showMessageDialog(contentPane, "��������Ʒ����");
					}
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "��������Ʒ�۸�");
				}
			}
			else {
				JOptionPane.showMessageDialog(contentPane, "��������Ʒ����");
			}
			
		}
		
	}
}
