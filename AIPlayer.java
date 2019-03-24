import java.util.Random;
/**
 * 
 * @author nardo
 *allows ai player to play the game
 */
public class AIPlayer extends Player {
	
	public AIPlayer(Board b, int s, String n) {
		super(b, s, n);
	}
	
	public void play(Board b) {
		
		int i = randomChoice();
		b.makeMove(i, this.symbol);
		
	}
	
	private int randomChoice() {
		
		int[] temp = new int[9];
		Random randy = new Random();
		int count = 0;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(this.gameboard.blocks[i][j].getState() == 0) {
					temp[count] = (3 * i + 1 + j);
					count ++;
				}
			}
		}
		return temp[randy.nextInt(count)];
	}

}
