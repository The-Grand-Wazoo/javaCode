package paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class Draw extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static int x1;
	static int x2;
	static int y1;
	static int y2;
	static int click=0;
	static int color;
	
	public void paintComponent(Graphics g)
	{
		super.repaint();
		if(color==0)
		{
			g.setColor(Color.black);
			color=1;
		}
		else if(color==1)
		{
			g.setColor(Color.green);
			color=2;
		}
		else if(color==2)
		{
			g.setColor(Color.red);
			color=3;
		}
		else if(color==3)
		{
			g.setColor(Color.blue);
			color=0;
		}
		g.drawLine(x1,y1,x2,y2);
		
	}
	public Draw()
	{
		super.repaint();
		System.out.println("test1");
		addMouseListener(new MouseAdapter()
        {   	
            public void mousePressed(MouseEvent e)
            {  
            	if(click==0)
            	{
	                x1=(int)e.getX();
	                y1=(int)e.getY();
	                System.out.println("x1: "+x1);
	                System.out.println("y1: "+y1);
	                click=1;
            	}
                else if(click==1)
                {   	
                	x2=(int)e.getX();
                    y2=(int)e.getY();
                    System.out.println("x2: "+x2);
	                System.out.println("y2: "+y2);
                    click=0;                   
                }
            	
            }
        });
		
	}

}
