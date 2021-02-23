import java.util.ArrayList;
import java.util.Stack;

public class DFSearch
{
	private static Stack<SearchNode> solutionPath;
	private static int searchCount = 1;
	private static int max = 0;
	private static int sum = 0;
	private static int closed = 0;
	public static Stack<SearchNode> search(int[] board)
	{
		searchCount = 1;
		SearchNode root = new SearchNode(new HelpPuzzleState(board));
		Stack<SearchNode> stack = new Stack<SearchNode>();

		stack.add(root);
		max=0;
		performSearch(stack);
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

	/**
	 * Performs a DFSearch using q as the search space
	 * 
	 * 
	 *            - A SearchNode queue to be populated and searched
	 */
	public static void performSearch(Stack<SearchNode> s)
	{
		

		while (!s.isEmpty()) // while the queue is not empty
		{
			if(sum>max)
				max = sum;
			SearchNode tempNode = s.pop();

			// if tempNode is not the goal state
			if (!tempNode.getCurState().isGoal())
			{
				// generate tempNode's immediate successors
				ArrayList<State> tempSuccessors = tempNode.getCurState()
						.genSuccessors();

				/*
				 * Loop through the successors, wrap them in a SearchNode, check
				 * if they've already been evaluated, and if not, add them to
				 * the queue
				 */
				for (int i = 0; i < tempSuccessors.size(); i++)
				{
					// second parameter here adds the cost of the new node to
					// the current cost total in the SearchNode
					SearchNode newNode = new SearchNode(tempNode, tempSuccessors.get(i), tempNode.getCost() 
							+ 1, 0);
					
					if (!checkRepeats(newNode))
					{
						s.add(newNode);
						searchCount++;
					}
					else
						closed++;
				}
				sum = s.size()+closed;
				
			}
			else
			// The goal state has been found. Print the path it took to get to
			// it.
			{
				// Use a stack to track the path from the starting state to the
				// goal state
				solutionPath = new Stack<SearchNode>();
				solutionPath.push(tempNode);
				tempNode = tempNode.getParent();

				while (tempNode.getParent() != null)
				{
					solutionPath.push(tempNode);
					tempNode = tempNode.getParent();
				}
				solutionPath.push(tempNode);
				return;
				
			}
		}

		
	}
	public static int getMax() {
		return max;
	}
	public static int getSearchCount() {
		return searchCount;
	}
}