package slmp.main;
/**
 * ��������Main����
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
