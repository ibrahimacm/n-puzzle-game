import java.util.ArrayList;
import java.util.Arrays;

public class HelpPuzzleState implements State {
	
	 public static int totalNumber = 0;
    private static int PUZZLE_SIZE;
    private static int ninput;
    private int outOfPlace = 0;
    private static int[] GOAL;
    private int[] curBoard;

    /**
     *
     * board - the board representation for the new state to be constructed
     */
    public HelpPuzzleState(int[] board) {
    	GOAL = Npuzzle.getGoal();
    	PUZZLE_SIZE = GOAL.length;
    	ninput = Npuzzle.getn();
        curBoard = board;
        setOutOfPlace();
    }


    /*
     * Set the 'tiles out of place' distance for the current board
     */
    private void setOutOfPlace() {
        for (int i = 0; i < curBoard.length; i++) {
            if (curBoard[i] != GOAL[i]) {
            	if(curBoard[i] != 0)
                outOfPlace++;
            }
            
        }
    }

  
    /*
     * Attempt to locate the "0" spot on the current board
     *
     * @return the index of the "hole" (or 0 spot)
     */
    public int getHole() {
        // If returning -1, an error has occured. The "hole" should always exist
        // on the board and should always be found by the below loop.
        int holeIndex = -1;

        for (int i = 0; i < PUZZLE_SIZE; i++) {
            if (curBoard[i] == 0)
                holeIndex = i;
        }
        return holeIndex;
    }

    public int getOutOfPlace() {
        return outOfPlace;
    }

    /*
     * Makes a copy of the array passed to it
     */
    private int[] copyBoard(int[] state) {
        int[] ret = new int[PUZZLE_SIZE];
        for (int i = 0; i < PUZZLE_SIZE; i++) {
            ret[i] = state[i];
        }
        return ret;
    }

    
    public ArrayList<State> genSuccessors() {
        ArrayList<State> successors = new ArrayList<State>();
        int hole = getHole();
        	
        		// left
           		if(hole % ninput>0) {
        	   swapAndStore(hole - 1, hole, successors);
           		}
           		
           		//down
        	   if(hole + ninput < GOAL.length) {
               swapAndStore(hole + ninput, hole, successors);
        	   }
        	   
        	   //right
               if(hole % ninput < ninput -1) {
             	  swapAndStore(hole + 1, hole, successors);
               }
               
        	   //up
        	   if(hole - ninput>=0) {
               swapAndStore(hole - ninput, hole, successors);
        	   }
         
        	   // try to generate a state by sliding a tile rightwise into the hole
           
        	  
          
       
        return successors;
    }

   
    private void swapAndStore(int d1, int d2, ArrayList<State> s) {
        int[] cpy = copyBoard(curBoard);
        int temp = cpy[d1];
        cpy[d1] = curBoard[d2];
        cpy[d2] = temp;
        s.add((new HelpPuzzleState(cpy)));
    }

   
    public boolean isGoal() {
        return Arrays.equals(curBoard, GOAL);
    }


    /**
     * Overloaded equals method to compare two states.
     *
     * @return true or false, depending on whether the states are equal
     */

    public boolean equals(State s) {
        return Arrays.equals(curBoard, ((HelpPuzzleState) s).getCurBoard());

    }

    
    public int[] getCurBoard() {
        return curBoard;
    }
    
    
    
    

}