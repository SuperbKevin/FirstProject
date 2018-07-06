package slmp.moduel.view.hintFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import slmp.assembly.IDGenerator;
import slmp.moduel.services.SaleOrderSer;
import slmp.moduel.services.UserSer;
import slmp.moduel.services.WarehouseSer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

public class WH_InsertJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private int sort;

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	/**
	 * Launch the application.
	 */
	public void runFrame(int sort) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WH_InsertJFrame frame = new WH_InsertJFrame();
					frame.setSort(sort);
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
	public WH_InsertJFrame() {
		setTitle("添加仓库");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 382, 205);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel title = new JLabel("仓库信息");
		title.setBounds(128, 13, 72, 18);
		contentPane.add(title);
		
		JButton save = new JButton("保存");
		save.setBounds(137, 131, 63, 27);
		contentPane.add(save);
		
		name = new JTextField();
		name.setBounds(166, 69, 184, 24);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel label = new JLabel("仓库名称");
		label.setBounds(49, 72, 72, 18);
		contentPane.add(label);
		
		save.addActionListener(new saveListener());
	}
	private class saveListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Object[] param = new Object[3];
			if(name.getText() != null) {
				param[0] = IDGenerator.generateID();
				param[1] = name.getText();
				param[2] = sort;
				WarehouseSer warehouseSer = new WarehouseSer();
				try {
					warehouseSer.insert(param);
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
