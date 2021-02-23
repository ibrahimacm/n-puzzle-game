import java.util.ArrayList;
import java.util.Stack;

public class IDSearch
{
	private static Stack<SearchNode> solutionPath;
	private static int searchCount = 1;
	private static int max = 0;
	private static int sum = 0;
	private static boolean flag;
	private static SearchNode node;
	public static Stack<SearchNode> search(int[] board)
	{
		searchCount = 1;
		flag = false;
		SearchNode root = new SearchNode(new HelpPuzzleState(board));
		SearchNode temp = root;
		max=0;
		int l = 0;
		while(true) {
			sum = 0;
		 node = perform(temp,l);
		 if(flag)
			 break;
		 else {
	
			 l++;
			 searchCount++;
		 }
		}
		
		if(flag) {
			getSol(node);
		}
		
		//performSearch(stack);
		return solutionPath;
	}

	/*
	 * Helper method to check to see if a SearchNode has already been evaluated.
	 * Returns true if it has, false if it hasn't.
	 */
	private static boolean checkRepeats(SearchNode n)
	{
		boolean retValue = false;
		SearchNode checkNode = n;

		// While n's parent isn't null, check to see if it's equal to the node
		// we're looking for.
		while (n.getParent() != null && !retValue)
		{
			if (n.getParent().getCurState().equals(checkNode.getCurState()))
			{
				retValue = true;
			}
			n = n.getParent();
		}

		return retValue;
	}
	
	public static SearchNode perform(SearchNode n, int limit) {
		
		if(sum>max)
			max = sum;
		
		if(flag)
			return n;
		
		if (n.getCurState().isGoal()) {
			flag = true;
			return n; 
		}
		if(limit == 0) {
			flag = false;
			return n;
		}
		else {
			ArrayList<State> tempSuccessors = n.getCurState()
					.genSuccessors();

			/*
			 * Loop through the successors, wrap them in a SearchNode, check
			 * if they've already been evaluated, and if not, add them to
			 * the queue.
			 * 
			 */
			sum += tempSuccessors.size();
			for (int i = 0; i < tempSuccessors.size(); i++)
			{
				// second parameter here adds the cost of the new node to
				// the current cost total in the SearchNode
				SearchNode newNode = new SearchNode(n, tempSuccessors.get(i), n.getCost() 
						+ 1, 0);
				
				
				
				if (!checkRepeats(newNode))
				{	
					searchCount++;
					SearchNode node = perform(newNode, limit-1);
					sum--;
					if(flag)
						return node;
				}
			}
			return null;
		}
	}
	
	
	public static void getSol(SearchNode tempNode) {
		solutionPath = new Stack<SearchNode>();
		solutionPath.push(tempNode);
		tempNode = tempNode.getParent();

		while (tempNode.getParent() != null)
		{
			solutionPath.push(tempNode);
			tempNode = tempNode.getParent();
		}
		solutionPath.push(tempNode);
	}
	
	public static int getMax() {
		return max;
	}
	public static int getSearchCount() {
		return searchCount;
	}
	public static boolean getFlag() {
		return flag;
	}
}