/**
 * 
 * @author nardo
 *player class allows a player to play the game
 *each player has a name and a symbol, either x or o
 */
public abstract class Player {
	
	public Board gameboard;
	public String name;
	public int symbol;
	
	public Player(Board b, int s, String n) {
		this.gameboard = b;
		this.symbol = s;
		this.name = n;
	}
	
	public abstract void play(Board b);
	
	public String toString() {
		return this.name;
	}

}
