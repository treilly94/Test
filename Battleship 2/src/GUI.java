import javax.swing.*;

import java.awt.*;


public class GUI {	
	static JButton[][] grid;
	
	static void myGridLayout(){  
	    JFrame frame =new JFrame();  
	    
	    
	    grid = new JButton[Board.boardSize][Board.boardSize];
	    for(int y = 0; y < Board.boardSize; y++){
		    for(int x = 0; x < Board.boardSize; x++){
		    	grid[x][y]=new JButton("("+x+","+y+")");   
                frame.add(grid[x][y]); //adds button to grid
		    }
		    
	    }
	          
	    frame.setLayout(new GridLayout(Board.boardSize,Board.boardSize));  
	  
	    frame.setSize(1000,1000);  
	    frame.setVisible(true);  
	}  
	
}