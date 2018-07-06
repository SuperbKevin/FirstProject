package slmp.moduel.view.hintFrame;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import slmp.assembly.ImageJPanel;
import slmp.moduel.services.UserSer;

public class UserManagementJFrame extends JFrame {

	private ImageJPanel contentPane;
	private JTextField name;
	private JTextField password;
	private JLabel lblNewLabel_2;
	private JLabel title;
	private String userID;

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
					UserManagementJFrame frame = new UserManagementJFrame();
					frame.setUserID(id);
					frame.setInfo(userID);
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
	public UserManagementJFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 272);
		
		ImageIcon icon = new ImageIcon("image/userbackground.jpg");
		Image image = icon.getImage();
		contentPane = new ImageJPanel(image);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		title = new JLabel("用户信息");
		title.setBounds(176, 48, 72, 18);
		contentPane.add(title);
		
		//添加按键并绑定监听器
		JButton save = new JButton("保存");
		save.setBounds(176, 196, 63, 27);
		contentPane.add(save);
		
		name = new JTextField();
		name.setBounds(216, 98, 208, 24);
		contentPane.add(name);
		name.setColumns(10);
		
		password = new JTextField();
		password.setBounds(216, 145, 208, 24);
		contentPane.add(password);
		password.setColumns(10);
		
		//添加标签
		JLabel lblNewLabel_1 = new JLabel("用户名");
		lblNewLabel_1.setBounds(86, 100, 72, 18);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("密码");
		lblNewLabel_2.setBounds(86, 151, 72, 18);
		contentPane.add(lblNewLabel_2);
		
		save.addActionListener(new saveListener());
	}
	
	protected void setInfo(String id) {
		//获取用户信息
		UserSer userSer = new UserSer();
		List list = null;
		Object[] ID = new Object[1];
		ID[0] = userID;
		try {
			list = userSer.selectByID(ID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Object[] userInfo = new Object[2];
		userInfo[0] = ((Object[])(list.get(0)))[1];
		userInfo[1] = ((Object[])(list.get(0)))[2];
		name.setText(userInfo[0].toString());
		password.setText(userInfo[1].toString());
	}
	
	private class saveListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Object[] param = new Object[3];
			if(name.getText() != null) {
				param[0] = name.getText();
					if(password.getText() != null) {
						param[1] = password.getText();
						param[2] = userID;
							
						UserSer userSer = new UserSer();
						try {
							userSer.updateByID(param);;
							JOptionPane.showMessageDialog(getRootPane(), "保存成功！");
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(getRootPane(), "保存失败！");
							e1.printStackTrace();
						}
						dispose();
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "请输入新密码");
				}
			}
			else {
				JOptionPane.showMessageDialog(contentPane, "请输入新用户名");
			}
			
		}
		
	}

}
