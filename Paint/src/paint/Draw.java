package paint;

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
	
	public void paintComponent(Graphics g)
	{
		super.repaint();
		System.out.println("test2");
		g.drawLine(x1,y1,x2,y2);
		x1=x2;
		y1=y2;
		click=1;
		
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
	                click=1;
            	}
                else if(click==1)
                {
                	
                	x2=(int)e.getX();
                    y2=(int)e.getY();
                    click=0;
                    
                }
            	
            }
        });
		
	}
	
	public static int nums()
	{
		return x2;
	}
}
