/**
 * 
 * @author nardo
 *block class represents a single block in the tic tac toe grid
 */
class Block {
	
	private int state;// an integer representing the state of the current block
					  //0 is empty, 1 is X, 2 is O
	/**
	 * default cnstructor for block sets the current state to empty
	 */
	public Block() {
		this.state = 0;
	}
	/**
	 * sets the current state of the block according to input parameter
	 * @param i
	 * @return
	 */
	public boolean setState(int i) {
	    if (isValidState(i))
	    {
	      this.state = i;
	      return true;
	    }
	    return false;
	}
	  /**
	   * returns the current state of the block
	   * @return
	   */
	public int getState(){
	    return this.state;
	}
	/**
	 * checks if integer is a valid option for the state of the block
	 * @param i
	 * @return
	 */
	public boolean isValidState(int i) {
		if(i == 1 || i == 2) {
			return true;
		}
		return false;
	}
	/**
	 * prints which player occupies the block, if any
	 */
	public String toString() {
		if (this.state == 2) {
		      return "O";
		}
		else if (this.state == 1) {
			return "X";
		}
		    return " ";
	}

}
