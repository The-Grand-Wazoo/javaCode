package Checkers;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class Checkers extends JPanel
{
    /**
    *
    */
    private static final long serialVersionUID = -6799064229355729609L;
    private static int x;//x coordinate of piece selected
    private static int y;//y coordinate of piece selected
    private static int x1;
    private static int y1;
    private static int[][] pieces=new int[][]{
    {1,0,0,0,0,0,-1,0},//pieces are on top
    {0,1,0,0,0,0,0,-1},
    {1,0,0,0,0,0,-1,0},
    {0,1,0,0,0,0,0,-1},
    {1,0,0,0,0,0,-1,0},
    {0,1,0,0,0,0,0,-1},
    {1,0,0,0,0,0,-1,0},
    {0,1,0,0,0,0,0,-1}};
    static int selected;
    static int newSelected;
    static int move=0;
    static String player="black";
    private static int whiteScore=0;
    private static int blackScore=0;
    
    
    public void paintComponent(Graphics g)
    {
        int height=getHeight();
        int width=getWidth();
        super.repaint();
        pieces(g);
        
        //horizontal lines
        g.drawLine(0, height/8, width, height/8);
        g.drawLine(0, height/4, width,height/4);
        g.drawLine(0, (3*height)/8, width, (3*height)/8);
        g.drawLine(0, height/2, width, height/2);
        g.drawLine(0, (5*height)/8, width, (5*height)/8);
        g.drawLine(0, (3*height)/4, width, (3*height)/4);
        g.drawLine(0, (7*height)/8, width, (7*height)/8);
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
    
    public void pieces(Graphics g)
    {    	
    	for(int x=0; x<pieces.length;x++)
    	{
    		for(int y=0; y<pieces.length; y++)
    		{		
		    	if(pieces[x][y]==-1)
		    	{
		    		g.fillOval(x*74,y*72,71,71);
		    		g.setColor(Color.black);
		    	}
		    	else if(pieces[x][y]==1)
		    	{
		    		g.drawOval(x*74,y*72,71,71);
		    		
		    	}
		    	else if(pieces[x][y]==0)
		    		g.clearRect(x*74, y*72, 74, 74);	
    		}
    	}
    				
    }
   
    public Checkers()
    {
        addMouseListener(new MouseAdapter()
        {   	
            public void mousePressed(MouseEvent e)
            {   	
                x=(int)e.getX()/74;//divide by 74 so the position of the cell can be used in a
                y=(int)e.getY()/74;//2D array
               
                if(move==0)//this is when a new piece is selected to move
                {
                	x1=x;
                	y1=y;
                	selected=pieces[x1][y1];
                	
                    if(selected==0)
                    {
                        JOptionPane.showMessageDialog(null, "Please select a piece");
                        System.out.println("seleceted:"+pieces[x1][y1]);
                        
                    }
                    else
                    {
	                    if(player=="black"&&selected==-1||player=="white"&&selected==1)
	                    {
	                    	 System.out.println("seleceted:"+pieces[x1][y1]);
	                         System.out.println("x: "+x1);
	                         System.out.println("y: "+y1);
	                         move=1;
	                    }
	                    else
	                    {
	                        JOptionPane.showMessageDialog(null,"Please select your own piece");
	                       
	                    }
                	}
                }
                else
                {   
	                newSelected=pieces[x][y];
	                
	                if(newSelected==1||newSelected==-1)
	                {
	                	System.out.println(selected);
	                	JOptionPane.showMessageDialog(null,"There is already a piece there");
	                	System.out.println("There is already a piece there");
	                	repaint();
	                	move=0;
	                
	                }
	                else
	                {
	                	if(checkMove()==true)
	                	{
		                	pieces[x][y]=selected;
		 	                System.out.println("new location: "+pieces[x][y]);
		 	                pieces[x1][y1]=0;
		 	                move=0;
		 	                if(player=="black")
		 	                	player="white";
		 	                else
		 	                	player="black";
	                	}
	                	else if(checkJump()==true)
	                	{
	                		pieces[x][y]=selected;
		 	                System.out.println("new location: "+pieces[x][y]);
		 	                pieces[x1][y1]=0;
		 	                move=0;
		 	                
		 	                if(player=="white"&&pieces[x+1][y+1]==-1||player=="white"&&pieces[x-1][y+1]==-1)
		 	                {
		 	                	if(checkJump()==true)
		 	                		player="white";
		 	                }
		 	                else if(player=="black"&&pieces[x+1][y-1]==1||player=="black"&&pieces[x-1][y-1]==1)
		 	                {
		 	                	//if(pieces[x+2][y-2]==1||pieces[x-2][y-2]==1)
		 	                		//player="white";
		 	                	if(checkJump()==true)
		 	                		player="black";
		 	                }	 	                 	                 
			 	            if(player=="white")
			 	            	whiteScore+=1;
			 	            else
			 	                blackScore+=1;
			 	           if(player=="black")
			 	            	player="white";
			 	            else
			 	               	player="black";
		 	                
			 	            if(whiteScore==8)
			 	            	JOptionPane.showMessageDialog(null, "Congratulations White, you win!");
			 	            else if(blackScore==8)
			 	            	JOptionPane.showMessageDialog(null, "Congratulations Black, you win!");
	                	}
	                	else
	                	{
	                		System.out.println(checkJump());
		                	JOptionPane.showMessageDialog(null, "Not a legal move");
	                		move=0;
	                	}
	                } 
                }  
            }    
        });
    }
    
    public static boolean checkMove()
    {
    	System.out.println("x: "+x);
    	System.out.println("y: "+y);
    	if(player=="white")
    	{
	    	if(x==x1+1&&y==y1+1)
	    		return true;
	    	else if(x==x1-1&&y==y1+1)
	    		return true;
	    	else
	    		return false;
    	}
    	else
    	{
    		if(x==x1+1&&y==y1-1)
	    		return true;
	    	else if(x==x1-1&&y==y1-1)
	    		return true;
	    	else
	    		return false;
    	}
    }
    
    public static boolean checkJump()
    {
    	if(player=="white")
    	{
    		if(x==x1+2&&y==y1+2)
    		{
    			if(pieces[x1+1][y1+1]==-1)
    			{
    				pieces[x1+1][y1+1]=0;
    				return true;			
    			}
    			else
    				return false;
    			
    		}
	    	else if(x==x1-2&&y==y1+2)
	    	{
	    		if(pieces[x1-1][y1+1]==-1)
	    		{
	    			pieces[x1-1][y1+1]=0;
	    			return true;
	    		}	
    			else
    				return false;
	    	}
	    	else
	    		return false; 	
    	}
    	
    	else
    	{
    		if(x==x1+2&&y==y1-2)
    		{
    			if(pieces[x1+1][y1-1]==1)
    			{
    				pieces[x1-1][y1-1]=0;
    				return true;
    			}
    			else
    				return false;
    		}
	    	else if(x==x1-2&&y==y1-2)
	    	{
	    		if(pieces[x1-1][y1-1]==1)
	    		{
	    			pieces[x1-1][y1-1]=0;
	    			return true;
	    		}
	    		else
    				return false;
	    	}
	    	else 
	    		return false;		    
    	}
    	
    }
    
}







