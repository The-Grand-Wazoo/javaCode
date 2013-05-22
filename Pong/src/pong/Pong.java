package pong;

import java.awt.Container;
import javax.swing.JFrame;

public class Pong 
{
	static JFrame window= new JFrame();
	static Container content=window.getContentPane();
	
	public static void createWindow()
	{
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.pack();
		window.setSize(500,500);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		window.setResizable(false);
		
	}
	public static void main(String[] args)
	{
		
		createWindow();
		Game game=new Game();
		window.add(game);
	}

}
