/**
 * 
 * @author nardo
 *Board class is a grid of 3by3 blocks
 */
class Board {

	public Block[][] blocks;
	private int state = 0;
	
	/**
	 * default constructor creates the gameboard for tic tac toe
	 */
	public Board() {
		this.blocks = new Block[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
		        this.blocks[i][j] = new Block();
		    }
		}
	}
	
	/**
	 * checks the i'th row of the grid for a win
	 * @param i
	 * @return
	 */
	private int checkRow(int i) {
		if(this.blocks[i][0].getState() != 0) {
			if((this.blocks[i][0].getState() == this.blocks[i][1].getState()) 
			&& (this.blocks[i][1].getState() == this.blocks[i][2].getState())) {
				return this.blocks[i][0].getState();
			}
		}
		return 0;
	}
	/**
	 * checks the diagonals of the grid for a win
	 * @return
	 */
	private int checkDiagonals() {
		if(this.blocks[1][1].getState() != 0) {
			if((this.blocks[0][0].getState() == this.blocks[1][1].getState())
			&& (this.blocks[1][1].getState() == this.blocks[2][2].getState())){
				return this.blocks[1][1].getState();
			}
			else if((this.blocks[2][0].getState() == this.blocks[1][1].getState())
			&& (this.blocks[1][1].getState() == this.blocks[0][2].getState())) {
				return this.blocks[1][1].getState();
			}
		}
		return 0;
	}
	/**
	 * checks the i'th column of the gird for a win
	 * @param i
	 * @return
	 */
	private int checkCol(int i) {
		if(this.blocks[0][i].getState() != 0) {
			if((this.blocks[0][i].getState() == this.blocks[1][i].getState()) 
			&& (this.blocks[1][i].getState() == this.blocks[2][i].getState())) {
				return this.blocks[0][i].getState();
			}
		}
		return 0;
	}
	/**
	 * displays the current state of the board
	 */
	public void displayBoard() {
		
		System.out.print("" + this.blocks[0][0] + "|" + this.blocks[0][1] + "|" + this.blocks[0][2] + "\n");
	    System.out.print("" + this.blocks[1][0] + "|" + this.blocks[1][1] + "|" + this.blocks[1][2] + "\n");
	    System.out.print("" + this.blocks[2][0] + "|" + this.blocks[2][1] + "|" + this.blocks[2][2] + "\n");
		
	}
	/**
	 * displays the board with all available options for the player to make a move
	 */
	public void displayPlayerSelectionBoard() {
		int count = 1;
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(this.blocks[i][j].getState() == 0) {
					System.out.print(count);
				}else {
					System.out.print(this.blocks[i][j]);
				}
				if(j != 2) {
					System.out.print("|");
				}
				count++;
				
			}
			System.out.print("\n");
		}
	   	
	}
	/**
	 * allows the player to make a move on to the coordinates of i and j
	 * @param i
	 * @param j
	 * @return
	 */
	public boolean makeMove(int i, int j) {
		if(i < 1) {
			return false;
		}
		if(i == 1) {
			if(this.blocks[0][0].getState() == 0) {
				this.blocks[0][0].setState(j);
				return true;
			}
		}
		if(i == 2) {
			if(this.blocks[0][1].getState() == 0) {
				this.blocks[0][1].setState(j);
				return true;
			}
		}
		if(i == 3) {
			if(this.blocks[0][2].getState() == 0) {
				this.blocks[0][2].setState(j);
				return true;
			}
		}
		if(i == 4) {
			if(this.blocks[1][0].getState() == 0) {
				this.blocks[1][0].setState(j);
				return true;
			}
		}
		if(i == 5) {
			if(this.blocks[1][1].getState() == 0) {
				this.blocks[1][1].setState(j);
				return true;
			}
		}
		if(i == 6) {
			if(this.blocks[1][2].getState() == 0) {
				this.blocks[1][2].setState(j);
				return true;
			}
		}
		if(i == 7) {
			if(this.blocks[2][0].getState() == 0) {
				this.blocks[2][0].setState(j);
				return true;
			}
		}
		if(i == 8) {
			if(this.blocks[2][1].getState() == 0) {
				this.blocks[2][1].setState(j);
				return true;
			}
		}
		if(i == 9) {
			if(this.blocks[2][2].getState() == 0) {
				this.blocks[2][2].setState(j);
				return true;
			}
		}
		return false;
	}
	/**
	 * updates the current state of the board. Either to a win or draw or neither
	 * @return
	 */
	public int updateState() {
		
		int i = checkRow(0) + checkRow(1) + checkRow(2) + checkCol(0) + checkCol(1) + checkCol(2) + checkDiagonals();
		if(i != 0) {
			this.state = i;
		}
		else {
			this.state = checkDraw();
		}
		return this.state;
	}
    /**
     * check the board for a draw
     * @return
     */
	private int checkDraw() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
		        if (this.blocks[i][j].getState() == 0) {
		            return 0;
		        }
		    }
		}
		return 3;
	}
}
