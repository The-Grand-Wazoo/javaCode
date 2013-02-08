package Checkers;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

public class Checkers extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6799064229355729609L;
	private static int x;//x coordinate of piece selected
	private static int y;//y coordinate of piece selected
	private static int x1;//x coordinate of move
	private static int y1;//y coordinate of move
	private static int[][] pieces=new int[][]{
		{1,0,0,0,0,0,1,0},//pieces are on top
		{0,1,0,0,0,0,0,1},
		{1,0,0,0,0,0,1,0},
		{0,1,0,0,0,0,0,1},
		{1,0,0,0,0,0,1,0},
		{0,1,0,0,0,0,0,1},
		{1,0,0,0,0,0,1,0},
		{0,1,0,0,0,0,0,1}};
	
	public void paintComponent(Graphics g)
	{
		int height=getHeight();
		int width=getWidth();
		//horizontal lines
		g.drawLine(0, height/8, width, height/8);
		g.drawLine(0, height/4, width,height/4);
		g.drawLine(0, (3*height)/8, width, (3*height)/8);
		g.drawLine(0, height/2, width, height/2);
		g.drawLine(0, (5*height)/8, width, (5*height)/8);
		g.drawLine(0, (3*height)/4, width, (3*height)/4);
		g.drawLine(0, (7*height)/8, width,  (7*height)/8);
		g.drawLine(0, height, width, height);
		//vertical lines
		g.drawLine(width/8,0,width/8,height);
		g.drawLine(width/4,0,width/4,height);
		g.drawLine((3*width)/8,0,(3*width)/8,height);
		g.drawLine(width/2,0,width/2,height);
		g.drawLine((5*width)/8,0,(5*width)/8,height);
		g.drawLine((3*width)/4,0,(3*width)/4,height);
		g.drawLine((7*width)/8,0,(7*width)/8,height);
		g.drawLine(width,0,width,height);
		
	}
	
	public Checkers()
	{
		addMouseListener(new MouseAdapter()
		{
			public void mousePressed(MouseEvent e)
			{
				System.out.println(e);
				x=(int)e.getX()/74;//divide by 74 so the position of the cell can be used in a 
				y=(int)e.getY()/74;//2D array
				pieces();
			}
		});
	}
	
	public void pieces()
	{
		int selectedPiece=pieces[x][y];
		addMouseListener(new MouseAdapter()
		{
			public void mousePressed(MouseEvent x)
			{
				System.out.println(x);
				x1=(int)x.getX()/74;//divide by 74 so the position of the cell can be used in a 
				y1=(int)x.getY()/74;//2D array
				pieces();
			}
		});
		System.out.println(selectedPiece);
		pieces[x1][y1]=selectedPiece;
		System.out.println(selectedPiece);
		
		
	}
	
	public static void move()
	{
		
	}
	
	
}



















