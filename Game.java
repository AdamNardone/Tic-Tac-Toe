import java.util.Random;
import java.util.Scanner;
/**
 * 
 * @author nardo
 *game class allows two players to use a gameboard to play the game
 */
class Game {
	
	boolean done = false;
	Board gameboard;
	int turn;
	Player playerO;
	Player playerX;
	
	/**
	 * default constructor creates a gameboard, asks user who will play the game, and then initializes the game
	 */
	public Game() {
		
		Scanner sc = new Scanner(System.in);
		this.gameboard = new Board();
		
		System.out.println("Welcome to tic tac toe!");
		int input = 0;
		
		String plyr1 = null, plyr2 = null;
		
		while(this.done != true) {
			
			System.out.println("Please select a game option: [1] Human vs Human [2] Human vs AI [3] AI vs AI");
		    input = sc.nextInt();
		    
		    if(input == 1) {
		    	
		    	System.out.println("Please enter human player X name");
		    	plyr1 = sc.next();
		    	
		    	System.out.println("Please enter human player O name");
		    	plyr2 = sc.next();
		    	
		    	this.done = true;
		    	break;
		    
		    } else if(input == 2) {
		    	
		    	System.out.println("Please enter human player X name");
		    	plyr1 = sc.next();
		    	
		    	System.out.println("Please enter AI Player O name");
		    	plyr2 = sc.next();
		    	
		    	this.done = true;
		    	break;
		    
		    } else if(input == 3) {
		    	
		    	System.out.println("Please enter AI player X name");
		    	plyr1 = sc.next();
		    	
		    	System.out.println("Please enter AI player O name");
		    	plyr2 = sc.next();
		    	
		    	this.done = true;
		    	break;
		    	
		    } else {
		    	System.out.println("Invalid selection! Try again.");
		    }
			
		}
		
		if(input == 1) {
			this.playerX = new HumanPlayer(this.gameboard, 1, plyr1);
		    this.playerO = new HumanPlayer(this.gameboard, 2, plyr2);
		}else if(input == 2) {
			this.playerX = new HumanPlayer(this.gameboard, 1, plyr1);
		    this.playerO = new AIPlayer(this.gameboard, 2, plyr2);
		}else if(input == 3) {
			this.playerX = new AIPlayer(this.gameboard, 1, plyr1);
		    this.playerO = new AIPlayer(this.gameboard, 2, plyr2);
		}
		System.out.println("Game initialized, " + plyr1 + " and " + plyr2 + " will fight to the death!");
	}
	/**
	 * start method actually starts the game, each player takes turns until an endgame condition is met
	 */
	public void start() {
		
		Random coinToss = new Random();
		boolean endgame = false;
		
		this.turn = (coinToss.nextInt(2) + 1);
		
		if(this.turn == 1) {
			System.out.println(this.playerX.name + " wins the toss! " + this.playerX.name + " will make the first move.");
		} else{
			System.out.println(this.playerO.name + " wins the toss! " + this.playerO.name + " will make the first move.");
		}
		
		while(endgame != true) {
			
			if(this.turn == 1) {
				System.out.println(this.playerX.name + " makes a move.");
				this.playerX.play(this.gameboard);
			}else {
				System.out.println(this.playerO.name + " makes a move.");
				this.playerO.play(this.gameboard);
			}
			
			if(this.gameboard.updateState() != 0) {
				endgame = true;
				break;
			}
			if(this.turn == 1) {
				this.turn = 2;
			}else {
				this.turn =1;
			}
		}
		this.gameboard.displayBoard();
		if(this.gameboard.updateState() == 1) {
			System.out.println(this.playerX.name + " is the supreme champion!");
		}else if(this.gameboard.updateState() == 2) {
			System.out.println(this.playerO.name + " is the supreme champion!");
		}else {
			System.out.println("The game is a draw!");
		}
		
	}

}
