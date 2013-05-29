package pong;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class Game extends JPanel
{
	
	static int y=0;
	static int y1=50;
	public void Game()
	{
		super.repaint();
		addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent e)
			{
				KeyPressedEvt(e);
			
			}
		});
		System.out.println(14);
	}
	public void KeyPressedEvt(KeyEvent e)
	{
		KeyPressedEvt(e);
	}
	public void paintComponent(Graphics g)
	{
		int width=getWidth();
		int height=getHeight();
		System.out.println("width: "+width);
		System.out.println("height: "+height);
		g.drawRect(0,y,20,100);
		g.drawRect(height, y1, 20, 100);
		
	}
	
	public static void move()
	{
		
		
	}
	
}
