package visao;

import javax.swing.JFrame;
import java.awt.Color;

public class InterfaceMenu extends JFrame {
	private static final long serialVersionUID = 1L;

	public InterfaceMenu() {
		getContentPane().setBackground(new Color(128, 0, 0));
		
		
		
		
		setSize(800, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
