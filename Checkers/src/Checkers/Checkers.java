/*
 * John Sinclair
 */
package Checkers;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class Checkers extends JPanel
{
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
    private static String piece="";
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
	                	else if(checkJump(x1, y1,x ,y)==true)
	                	{
	                		pieces[x][y]=selected;//new location selected is equal to the selected piece
		 	                System.out.println("new location: "+pieces[x][y]);
		 	                pieces[x1][y1]=0;
		 	                		
		 	                if(player=="white")
			 	            	whiteScore+=1;
			 	            else
			 	                blackScore+=1;
		 	                System.out.println(checkDoubleJump(x1,y1));
		 	                if(checkDoubleJump(x1,y1)==true)//using new x and y postion for checking double jump
		 	                {
		 	                	System.out.println("true");
		 	                	if(player=="white")
		 	                		player="white";
		 	                	else if(player=="black")
		 	                		player="black";
		 	                }
		 	                else
		 	                {
		 	                	//System.out.println("false");
		 	                	if(player=="black")
				 	            	player="white";
				 	            else
				 	               	player="black";
		 	                }
			 	       
		 	                if(whiteScore==8)
			 	            	JOptionPane.showMessageDialog(null, "Congratulations White, you win!");
			 	            else if(blackScore==8)
			 	            	JOptionPane.showMessageDialog(null, "Congratulations Black, you win!");
		 	                move=0;
	                	}
	                	else
	                	{
	                		//System.out.println(checkJump());
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
	    	if(x==x1+1&&y==y1+1)//x1 is the original location. x is the new location.
	    		return true;
	    	else if(x==x1-1&&y==y1+1)
	    		return true;
	    	else
	    		return false;
    	}
    	else if(player=="black")
    	{
    		if(x==x1+1&&y==y1-1)
	    		return true;
	    	else if(x==x1-1&&y==y1-1)
	    		return true;
	    	else
	    		return false;
    	}
    	return false;
    }
    
    public static boolean checkJump(int x2, int y2, int a, int b )
    {
    	if(player=="white")
    	{
    		if(a==x2+2&&b==y2+2)//a and b are the selected piece and the x2/y2 are for the where the piece is moving
    		{
    			if(pieces[x2+1][y2+1]==-1)
    			{
    				pieces[x2+1][y2+1]=0;
    				return true;			
    			}
    			else
    				return false;	
    		}
	    	else if(a==x2-2&&b==y2+2)
	    	{
	    		if(pieces[x2-1][y2+1]==-1)
	    		{
	    			pieces[x2-1][y2+1]=0;
	    			return true;
	    		}	
    			else
    				return false;
	    	}
	    	else
	    		return false; 	
    	}
    	
    	else if(player=="black")
    	{
    		if(a==x2+2&&b==y2-2)
    		{
    			if(pieces[x2+1][y2-1]==1)
    			{
    				pieces[x2+1][y2-1]=0;
    				return true;
    			}
    			else
    				return false;
    		}
	    	else if(a==x2-2&&b==y2-2)
	    	{
	    		if(pieces[x2-1][y2-1]==1)
	    		{
	    			pieces[x2-1][y2-1]=0;
	    			return true;
	    		}
	    		else
    				return false;
	    	}
	    	else 
	    		return false;		    
    	}
    	else
    		return false;
    }
    
   
    public static boolean checkDoubleJump(int x, int y)//x and y for pieces
    {
    	if(player=="black")
    	{
    		for(int a=0; a<7; a++)
    		{
    			if(pieces[x][y]!=pieces[0][a])
    			{	
	    			if(pieces[x+1][y-1]==1)
		    			if(pieces[x+2][y-2]==0)
		    				return true;
		    		else if(pieces[x-1][y-1]==1)
		    			if(pieces[x-2][y-2]==0)
		    				return true;
    			}
    		}	    		    			
    	}
    	else if(player=="white")
    	{
    		for(int a=0; a<7; a++)
    		{
    			if(pieces[x][y]!=pieces[0][a])
    			{	
	    			if(pieces[x+1][y+1]==-1)
		    			if(pieces[x+2][y+2]==0)
		    				return true;
		    		else if(pieces[x-1][y+1]==-1)
		    			if(pieces[x-2][y+2]==0)
		    				return true;
    			}
    		}	    		    			
    	}
    	return false;
    	
    }
    
    public static boolean checkKing()
    {
	    if(player=="black")	
    		for(int y=0;y<7;y++)
		    	if(pieces[0][y]==-1)
		    		return true;
		else if(player=="white")
			for(int a=0; a<7; a++)
				if(pieces[7][a]==1)
					return true;
	    return false;
	    
    }
    
    public static boolean king()
    {
    	if(player=="black"&&checkKing()==true)
    	{
    		piece="king";
    	}
    	else if(player=="white"&&checkKing()==true)
    	{
    		
    	}
    	
    	return false;
    }

}







