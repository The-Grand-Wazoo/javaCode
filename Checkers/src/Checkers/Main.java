/*
 * John Sinclair
 */

package Checkers;

import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JFrame;

public class Main
{
	public static void gameWindow()
	{
		JFrame window=new JFrame();
		Container content=window.getContentPane();
		Checkers game= new Checkers();
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(600,600);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		window.setResizable(false);
		content.setLayout(new GridLayout());
		content.add(game);
		
	}

	public static void main(String[] args) 
	{
		gameWindow();
		
	} 

}
