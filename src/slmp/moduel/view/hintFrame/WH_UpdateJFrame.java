package slmp.moduel.view.hintFrame;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import slmp.moduel.services.WarehouseSer;

public class WH_UpdateJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private String warehouseId;

	public String getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(String warehouseId) {
		this.warehouseId = warehouseId;
	}

	/**
	 * Launch the application.
	 */
	public void runFrame(String id) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WH_UpdateJFrame frame = new WH_UpdateJFrame();
					frame.setWarehouseId(id);
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
	public WH_UpdateJFrame() {
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
			Object[] param = new Object[2];
			if(name.getText() != null) {
				param[0] = name.getText();
				param[1] = warehouseId;
				WarehouseSer warehouseSer = new WarehouseSer();
				try {
					warehouseSer.updateByID(param);
					JOptionPane.showMessageDialog(getRootPane(), "更新成功！");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(getRootPane(), "更新失败！");
					e1.printStackTrace();
				}
				dispose();
			}
			else {
				JOptionPane.showMessageDialog(contentPane, "请输入仓库名称");
			}
		}
		
	}

}
