package paint;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;



public class Paint 
{
	public static void paintWindow()
	{
		JFrame window=new JFrame();
		Container content=window.getContentPane();
		Draw draw= new Draw();
		
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.pack();
		window.setSize(500,500);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		window.setResizable(false);
		
		content.setLayout(new GridLayout());
		content.add(draw);
		
		
	}
	public static void main(String[] args)
	{
		paintWindow();
	}
}
