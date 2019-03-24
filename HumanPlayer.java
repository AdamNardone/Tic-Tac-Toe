import java.util.Scanner;
/**
 * 
 * @author nardo
 *Human player allows a human to play the itc tac toe game
 */
public class HumanPlayer extends Player {

	public HumanPlayer(Board b, int s, String n) {
		super(b, s, n);
	}
	
	public void play(Board b) {
		this.gameboard = b;
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			
			System.out.println("Enter a valid move");
			b.displayPlayerSelectionBoard();
			
			int i = sc.nextInt();
			
			if(b.makeMove(i, this.symbol) == true) {
				break;
			}
			System.out.println("Invalid move, try again!");
		}
	}
	
}
