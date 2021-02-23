
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class BFSearch {
	private static Stack<SearchNode> solutionPath;
	private static int max = 0;
	private static int sum = 0;
	private static int closed = 0;
	private static  int searchCount = 1;// counter for number of iterations
    public static Stack<SearchNode> search(int[] board) {
    	int[] x= board;
        SearchNode root = new SearchNode(new HelpPuzzleState(x));
        Queue<SearchNode> queue = new LinkedList<SearchNode>();

        queue.add(root);
        max = 1;
        performSearch(queue);
       return solutionPath;
    }

    
    private static boolean checkRepeats(SearchNode n) {
        boolean retValue = false;
        SearchNode checkNode = n;

        while (n.getParent() != null && !retValue) {
            if (n.getParent().getCurState().equals(checkNode.getCurState())) {
                retValue = true;
            }
            n = n.getParent();
        }

        return retValue;
    }


    public static void performSearch(Queue<SearchNode> q) {
    	searchCount = 1;
        try {
        while (!q.isEmpty()) 
        {
        	if(sum>max)
				max = sum;
        	
            SearchNode tempNode = q.poll();
            
            
            if (!tempNode.getCurState().isGoal()) 
            {
            	
                ArrayList<State> tempSuccessors = tempNode.getCurState()
                        .genSuccessors(); 
               
                for (int i = 0; i < tempSuccessors.size(); i++) {
                    
                    SearchNode newNode = new SearchNode(tempNode,
                            tempSuccessors.get(i), tempNode.getCost()
                            + 1, 0);

                    if (!checkRepeats(newNode)) {
                    	searchCount++;
                        q.add(newNode);
                    }
                    else
                    	closed++;
                }
                sum = q.size()+closed;
                
            } else
           
            {
            	
                solutionPath = new Stack<SearchNode>();
                solutionPath.push(tempNode);
                tempNode = tempNode.getParent();

                while (tempNode.getParent() != null) {
                    solutionPath.push(tempNode);
                    tempNode = tempNode.getParent();
                }
                solutionPath.push(tempNode);
                return;
               
            }
        }
    }catch(Exception e) {System.out.println(e.getMessage());}
       
    }
    public static int getMax() {
		return max;
	}
	public static int getSearchCount() {
		return searchCount;
	}
}