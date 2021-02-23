import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;




public class AStarSearch
{
	private static int searchCount = 1; // counter for number of iterations
	private static int max = 0;
	private static int sum = 0;
	private static int closed = 0;
	private static Stack<SearchNode> solutionPath;
	
	public static Stack<SearchNode> search(int[] board)
	{
		searchCount = 1;
		SearchNode root = new SearchNode(new HelpPuzzleState(board));
		PriorityQueue<SearchNode> q = new PriorityQueue<SearchNode>();
		q.add(root);
		max = 1;
		// int d = 0;
		
		while (!q.isEmpty()) // while the queue is not empty
			{
			if(sum>max)
				max = sum;
			
			SearchNode tempNode = q.poll();
			
			// if the tempNode is not the goal state
			if (!tempNode.getCurState().isGoal()) {
				// generate tempNode's immediate successors
				ArrayList<State> tempSuccessors = tempNode.getCurState()
						.genSuccessors();
				
				for (int i = 0; i < tempSuccessors.size(); i++) {
					SearchNode checkedNode = new SearchNode(tempNode, tempSuccessors.get(i)
								, tempNode.getCost() + 1
								, ((HelpPuzzleState) tempSuccessors.get(i)).getOutOfPlace());
					
					if (!checkRepeats(checkedNode)) {
						q.add(checkedNode);
						searchCount++;
					}
					else
						closed++;
				}
				sum = q.size()+closed;
				
				
			}
			else {
				// Use a stack to track the path from the starting state to the
				// goal state
				solutionPath = new Stack<SearchNode>();
				solutionPath.push(tempNode);
				tempNode = tempNode.getParent();

				while (tempNode.getParent() != null) {
					solutionPath.push(tempNode);
					tempNode = tempNode.getParent();
				}
				solutionPath.push(tempNode);
				return solutionPath;
				
			}
		}
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
	public static int getMax() {
		return max;
	}
	public static int getSearchCount() {
		return searchCount;
	}

}