
public class SearchNode implements Comparable<SearchNode>  {

    private State curState;
    private SearchNode parent;
    private int cost; // cost to get to this state
    private int hCost; // heuristic cost
    private int fCost; // f(n) cost

    /**
     * Constructor for the root SearchNode
     *
     * @param s the state passed in
     */
    public SearchNode(State s) {
        curState = s;
        parent = null;
        cost = 0;
        hCost = 0;
        fCost = 0;
    }

    /**
     * Constructor for all other SearchNodes
     *
     * @param prev the parent node
     * @param s    the state
     * @param c    the g(n) cost to get to this node
     * @param h    the h(n) cost to get to this node
     */
    public SearchNode(SearchNode prev, State s, int c, int h) {
        parent = prev;
        curState = s;
        cost = c;
        hCost = h;
        fCost = cost + hCost;
    }

    /**
     * @return the curState
     */
    public State getCurState() {
        return curState;
    }

    /**
     * @return the parent
     */
    public SearchNode getParent() {
        return parent;
    }

    /**
     * @return the cost
     */
    public int getCost() {
        return cost;
    }

    /**
     * @return the heuristic cost
     */
    public int getHCost() {
        return hCost;
    }

    /**
     * @return the f(n) cost for A*
     */
    public int getFCost() {
        return fCost;
    }

    public void setFCost(int fCost) {
        this.fCost = fCost;
    }
    
    public void setCost(int ncost) {
        cost =  ncost;
    }

	@Override
	public int compareTo(SearchNode o) {
		return  fCost - o.getFCost() ;
	}

}