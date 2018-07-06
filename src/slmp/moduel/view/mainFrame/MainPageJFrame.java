package slmp.moduel.view.mainFrame;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.EmptyBorder;

import slmp.assembly.CardLayoutJPanel;
import slmp.assembly.ImageJPanel;
import slmp.moduel.services.UserSer;
import slmp.moduel.view.hintFrame.UserManagementJFrame;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class MainPageJFrame extends JFrame {

	private JPanel contentPane;
	private JButton homepaButton;
	private JButton baseDataButton;
	private JButton ordersManagementButton;
	private JButton userButton;
	private CardLayoutJPanel cardPanel;
	private ImageJPanel homePage;
	private BaseDataJPanel baseData;
	private OrdersManagementJPanel ordersManagement;
	private static String UserID;
	private static String UserName;

	public static String getUserName() {
		return UserName;
	}

	public static void setUserName(String userName) {
		UserName = userName;
	}

	public String getUserID() {
		return UserID;
	}

	public void setUserID(String userID) {
		UserID = userID;
	}

	/**
	 * Launch the application.
	 */
	
	public void runJFrame() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPageJFrame frame = new MainPageJFrame(UserID, UserName);
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
	public MainPageJFrame(String id, String name) {
		this.setUserID(id);
		this.setUserName(name);
		
		this.setTitle("销售管理系统");
		
		//改变窗口边框装饰
		this.setUndecorated(true);
		this.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//创建cardlayout布局的JPanel并添加相应组件
		cardPanel = new CardLayoutJPanel();
		cardPanel.setBounds(14, 53, 905, 420);
		contentPane.add(cardPanel);
		
		//添加带有背景图片的主页面
		ImageIcon homepageIcon = new ImageIcon("image/indexbackground.png");
		Image homapageBackground = homepageIcon.getImage();
		homePage = new ImageJPanel(homapageBackground);
		
		baseData = new BaseDataJPanel();
		ordersManagement = new OrdersManagementJPanel(UserID);
		
		cardPanel.add("homePage", homePage);
		cardPanel.add("baseData", baseData);
		cardPanel.add("ordersManagement", ordersManagement);
		
		//添加按键并绑定按钮事件
		ImageIcon homeIcon = new ImageIcon("image/home.png");
		homepaButton = new JButton(homeIcon);
		homepaButton.setContentAreaFilled(false);
		homepaButton.setBounds(14, 13, 33, 27);
		homepaButton.setBorderPainted(false);
		contentPane.add(homepaButton);
		
		ImageIcon baseDataIcon = new ImageIcon("image/baseData.png");
		baseDataButton = new JButton(baseDataIcon);
		baseDataButton.setContentAreaFilled(false);
		baseDataButton.setBounds(57, 13, 33, 27);
		baseDataButton.setBorderPainted(false);
		contentPane.add(baseDataButton);
		
		ImageIcon purchase_sale_stockIcon = new ImageIcon("image/purchase_sale_stock.png");
		ordersManagementButton = new JButton(purchase_sale_stockIcon);
		ordersManagementButton.setContentAreaFilled(false);
		ordersManagementButton.setBounds(100, 13, 33, 27);
		ordersManagementButton.setBorderPainted(false);
		contentPane.add(ordersManagementButton);
		
		JLabel lblNewLabel = new JLabel("欢迎，" + UserName);
		lblNewLabel.setBounds(835, 19, 84, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel();
		ImageIcon maleIcon = new ImageIcon("image/male.png");
		lblNewLabel_1.setIcon(maleIcon);
		lblNewLabel_1.setBounds(804, 19, 33, 15);
		contentPane.add(lblNewLabel_1);
		
		ImageIcon icon = new ImageIcon("image/userManager.png");
		userButton = new JButton(icon);
		userButton.setBorderPainted(false);
		userButton.setContentAreaFilled(false);
		userButton.setBounds(769, 13, 33, 23);
		contentPane.add(userButton);
		
		homepaButton.addActionListener(new shuffleListener());
		baseDataButton.addActionListener(new shuffleListener());
		ordersManagementButton.addActionListener(new shuffleListener());
		userButton.addActionListener(new shuffleListener());
	}

	private class shuffleListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == homepaButton) {
				cardPanel.getCardLayout().show(cardPanel, "homePage");
				
			}
			else if(e.getSource() == baseDataButton) {
				cardPanel.getCardLayout().show(cardPanel, "baseData");
			}
			else if(e.getSource() == ordersManagementButton) {
				cardPanel.getCardLayout().show(cardPanel, "ordersManagement");
			}
			else if(e.getSource() == userButton) {
				UserManagementJFrame userInfo = new UserManagementJFrame();
				userInfo.runFrame(UserID);
			}
			
		}
		
	}
}
