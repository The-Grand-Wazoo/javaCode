package pong;

import java.awt.Container;
import javax.swing.JFrame;

public class Window 
{
	public static void createWindow()
	{
		JFrame window= new JFrame();
		Container content=window.getContentPane();
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(500,500);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		window.setResizable(false);
		
	}
	
	
}
