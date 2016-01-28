import java.awt.event.*;
import java.awt.geom.*;
import java.awt.Graphics2D;
import java.awt.Color;
import javax.swing.JOptionPane;

public class TicTacToeViewController implements MouseListener{
	
	TicTacToeView view;
	TicTacToeModel model;
	Color oColor=Color.BLUE, xColor=Color.RED;
	
	/*
	 * The constructor "glues" the components and sets up any delegates.
	 */
	public TicTacToeViewController(TicTacToeView view, TicTacToeModel model) { 
		// TODO
      this.model = model;
      this.view = view;
      //this.model = model;
      view.addMouseListener(this);
	}
	
	/** Ask the model what's the next move.
	 */
	public void play(int xpos, int ypos) {
      //System.out.println("Is empty:"+ypos+","+xpos+":"+model.isEmpty(xpos,ypos));
		if (model.isEmpty(xpos,ypos)) {
			// TO DO: Put the O in xpos ypos using the model.
            model.placeO(xpos, ypos);
         		// TO DO: Put the X using the model.
               model.putX();
			// The following two statements redraw the board. Don't change.
			drawBoard();
			view.repaint();
		}
      		model.printBoard();
		// TO DO: add the conditions inside the () of the if's that determine the winner.
		if(didWin('X')) 
			JOptionPane.showMessageDialog(null,"X Wins","Winner", JOptionPane.INFORMATION_MESSAGE);
		else if (didWin('O'))
			JOptionPane.showMessageDialog(null,"O Wins","Winner",JOptionPane.INFORMATION_MESSAGE);
	}
	
	
	/** Control the drawing of O and X.
	 * This looks at the model to see where there are Xs and Os and draws two diagonal
	 * lines or a circle (an Ellipse, actually) in the positions given.
	 */
	public void drawBoard() {
		Graphics2D g2d = (Graphics2D)view.board.getGraphics();
		
		for (int i=0; i<3; i++) 
			for(int j=0; j<3;j++) {
				model.computePos(i,j,view.board.getHeight(),view.board.getWidth());
				double xpos = model.xpos;
				double xr = model.xr;
				double ypos = model.ypos;
				double yr = model.yr;
				// TODO: Complete the expressions within the if statements as follows:
				// if the array that represents the board has a O in position i, j... else,
				// if it has an X...
				if ( model.position[i][j] == 'O') {
					//TODO: Add the ellipse to the list of shapes that the view has to draw.
					view.shapes.add(new Ellipse2D.Double(xpos-xr, ypos-yr, xr*2, yr*2));
				}
				else if (model.position[i][j] == 'X' ) {
				  view.shapes.add(new Line2D.Double(xpos-xr, ypos-yr, xpos+xr, ypos+yr));
				  view.shapes.add(new Line2D.Double(xpos-xr, ypos+yr, xpos+xr, ypos-yr));
				}
				System.out.println("Coords: xpos:"+xpos+", ypos:"+ypos+", xr"+xr+", yr"+yr);
		}
	}
	
	/** MouseListener event
	 * Converts the coordinates of the mouse into the corresponding row and column of the cell
	 */
	public void mouseClicked(MouseEvent e) {
      int xpos=e.getX()*3/view.getWidth();
      int ypos=e.getY()*3/view.getHeight();
      //System.out.println("Play "+xpos+","+ypos);
      play(xpos,ypos);
    }
    
    /**
	 * Check whether player has won
	 */
	public boolean didWin(char player) {
      	// TO DO
         // Checking for winner in diagonals  
         if(model.position[0][0] == player && model.position[1][1] == player &&  model.position[2][2] == player){
            return true;
         }
         // Checking for winner in diagonals  
         else if( model.position[0][2] == player &&  model.position[1][1] == player &&  model.position[2][0] == player){
            return true;
         }  
         else{
               for(int i= 0; i< model.position.length; i++){
                   if( model.position[i][0] == player &&  model.position[i][1] == player &&  model.position[i][2]==player){
                        return true;
                   }
                   if( model.position[0][i] == player &&  model.position[1][i] == player &&  model.position[2][i] == player){
                        return true;
                   }
               }//end of for
         }//end of else
         
         return false;
      }
	

    /** Ignore other mouse events*/
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}
