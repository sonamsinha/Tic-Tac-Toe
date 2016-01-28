import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.ArrayList;

public class TicTacToeView extends JFrame{
	
	private JButton oButton, xButton;
	public JPanel board;
	public ArrayList<Shape> shapes;

    public TicTacToeView(){
		shapes = new ArrayList<Shape>();
		JPanel topPanel=new JPanel();
		topPanel.setLayout(new FlowLayout());
		add(topPanel, BorderLayout.NORTH);
		add(board=new Board(), BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
	}
	
	
	private class Board extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			int w=getWidth();
			int h=getHeight();
			Graphics2D g2d = (Graphics2D) g;

			// Draw the grid
			g2d.setPaint(Color.WHITE);
			g2d.fill(new Rectangle2D.Double(0, 0, w, h));
			g2d.setPaint(Color.BLACK);
			g2d.setStroke(new BasicStroke(4));
			g2d.draw(new Line2D.Double(0, h/3, w, h/3));
			g2d.draw(new Line2D.Double(0, h*2/3, w, h*2/3));
			g2d.draw(new Line2D.Double(w/3, 0, w/3, h));
			g2d.draw(new Line2D.Double(w*2/3, 0, w*2/3, h));
			//draw circles and xs by visiting elements in the array List.
			for(Shape shape : shapes){
				//System.out.println("Drawing :"+shape);
				g2d.setPaint(Color.BLUE);
				g2d.draw(shape);
			}
		}
	}
	
	public void addMouseListener(MouseListener ml){
		// TODO
      board.addMouseListener(ml);
   }
	
	
	public static void main(String[] args) {
		TicTacToeView ttv = new TicTacToeView();
		ttv.setVisible(true);
		
	}
}
