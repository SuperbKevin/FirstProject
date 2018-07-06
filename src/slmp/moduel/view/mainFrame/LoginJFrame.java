package slmp.moduel.view.mainFrame;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.border.EmptyBorder;

import slmp.assembly.ImageJPanel;
import slmp.moduel.entity.User;
import slmp.moduel.services.UserSer;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class LoginJFrame extends JFrame {

	private ImageJPanel contentPane;
	private JTextField user;
	private JPasswordField password;
	private JButton login;
	private JButton reset;
	//private ImageIcon background = new ImageIcon("image/loginbackground.png");

	/**
	 * Launch the application.
	 */
	public void runJFrame() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginJFrame frame = new LoginJFrame();
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
	public LoginJFrame() {
		this.setTitle("销售管理系统");
		
		this.setUndecorated(true); // 去掉窗口的装饰
		this.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);//采用只有关闭按键的窗口装饰风格
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 774, 472);
		
		ImageIcon backgroundIcon = new ImageIcon("image/loginbackground.png");
		Image background = backgroundIcon.getImage();
		
		contentPane = new ImageJPanel(background);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		user = new JTextField();
		user.setText("\u7528\u6237\u540D/\u8D26\u53F7");
		user.setBounds(370, 195, 175, 28);
		contentPane.add(user);
		user.setColumns(20);
		
		password = new JPasswordField();
		password.setBounds(370, 235, 175, 28);
		contentPane.add(password);
		password.setColumns(20);
		
		login = new JButton("登陆");
		login.setBounds(387, 280, 63, 31);
		contentPane.add(login);
		
		reset = new JButton("重置");
		reset.setBounds(461, 280, 63, 31);
		contentPane.add(reset);
		
		login.addActionListener(new LoginListener());
		reset.addActionListener(new LoginListener());
		user.addMouseListener(new ClickListener());
	}
	private class LoginListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == login) {
				Object[] paraArray = new Object[1];
				paraArray[0] =user.getText();
				UserSer userSer = new UserSer();
				User admin = null;
				try {
					admin = userSer.selectOneUser(paraArray);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(admin != null) {
					if(password.getText().equals( admin.getPassword())) {
						MainPageJFrame mainPage = new MainPageJFrame(admin.getId(), admin.getName());
						mainPage.runJFrame();
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(contentPane, "密码输入错误");
					}
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "用户名/账号不存在");
				}
			}
			else if(e.getSource() == reset) {
				user.setText("用户名/账号");
				password.setText("");
			}
			
		}
		
	}
	private class ClickListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource() == user) {
				user.setText("");
			}
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}

