package slmp.main;
/**
 * 程序运行Main方法
 * Launch the application.
 */
import java.awt.EventQueue;

import slmp.moduel.entity.User;
import slmp.moduel.services.UserSer;
import slmp.moduel.view.mainFrame.LoginJFrame;

public class Main {

	public static void main(String[] args) {
		LoginJFrame frame = new LoginJFrame();
		frame.runJFrame();
					
	}

}
