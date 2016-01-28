import javax.swing.*;

public class TicTacToeApp {
	public static void main(String[] args) {
	   TicTacToeView view = new TicTacToeView();
      TicTacToeModel model = new TicTacToeModel();
      TicTacToeViewController controller = new TicTacToeViewController(view, model);
		view.setVisible(true);
	}
}
