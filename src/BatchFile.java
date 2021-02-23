import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

public class BatchFile {
	private static final Random RANDOM = new Random();
	private int[] tiles = new int[9];
	private int blankPos ;
	private int nbTiles = 8;
	private int[] goal = new int[9];
	private int path;
	private int total;
	private int max;
	private XWPFDocument document = new XWPFDocument(); 
	
	
	@WARNINGS
	public BatchFile() {
		
		
		try {
			
			  JOptionPane x = new JOptionPane();
			  x.showMessageDialog(null, "Will Take from 10 to 15 Min. \nWill show message when it's done.");
			  
			  
		      FileOutputStream out = new FileOutputStream(new File("BatchFile.docx"));
		      
		    p();
		    
			
			
			
			
			
		      
		     
		     
			  document.write(out);
		      out.close();
		      
		      x.showMessageDialog(null, "Done, Complete");
		      
		      secondWindow sw = new secondWindow();
		      
			} catch (Exception e) {
				// TODO: handle exception
			}
		
		
	}
	
	
	public void p() {
		setGoal();
		newGame();
		Npuzzle.setn(3);
		Npuzzle.setGoal();
		
		XWPFParagraph para = document.createParagraph();
	      XWPFRun run3 = para.createRun();
	      run3.setText("\n          ");
	      
		 XWPFParagraph paragraph = document.createParagraph();
	      XWPFRun run = paragraph.createRun();
	      run.setText("The initial state: ");
	      XWPFTable table2 = document.createTable();
	      //create first row
	      XWPFTableRow tableROne = table2.getRow(0);
	      tableROne.getCell(0).setText( ""+tiles[0]+"\t");
	      tableROne.addNewTableCell().setText(" " + tiles[1]+"\t");
	      tableROne.addNewTableCell().setText(" " + tiles[2]+"\t");
	      //create second row
	      XWPFTableRow tableRTwo = table2.createRow();
	      tableRTwo.getCell(0).setText(" " + tiles[3]+"\t");
	      tableRTwo.getCell(1).setText(" " + tiles[4]+"\t");
	      tableRTwo.getCell(2).setText(" " + tiles[5]+"\t");
	      //create third row
	      XWPFTableRow tableRThree = table2.createRow();
	      tableRThree.getCell(0).setText(" " + tiles[6]+"\t");
	      tableRThree.getCell(1).setText(" " + tiles[7]+"\t");
	      tableRThree.getCell(2).setText(" " + tiles[8]+"\t");
	      
	      XWPFParagraph paragraph2 = document.createParagraph();
	      XWPFRun run2 = paragraph2.createRun();
	      run2.setText("Comparison table between 7 search algorithms with same initial state. (Puzzle Game 3*3)");
	      //create table
	      XWPFTable table = document.createTable();
	      
	      //create rows
	      XWPFTableRow tableRowOne = table.getRow(0);
	      XWPFTableRow tableRowTwo = table.createRow();
	      XWPFTableRow tableRowThree = table.createRow();
	      XWPFTableRow tableRowFour = table.createRow();
	      
	      tableRowOne.getCell(0).setText("Info \\ Algorithms");
	      tableRowOne.addNewTableCell().setText("Breadth First");
	      tableRowOne.addNewTableCell().setText("Depth First");
	      tableRowOne.addNewTableCell().setText("Uniform Cost");
	      tableRowOne.addNewTableCell().setText("Depth Limited");
	      tableRowOne.addNewTableCell().setText("Iterative Deepening");
	      tableRowOne.addNewTableCell().setText("  A*\t");
	      tableRowOne.addNewTableCell().setText("Greedy");
	      
	      
	      // info
	      tableRowTwo.getCell(0).setText("Path Cost");
	      tableRowThree.getCell(0).setText("Processed Nodes");
	      tableRowFour.getCell(0).setText("Maximum Stored Nodes");
	      
	      
	      path = BFSearch.search(tiles).size();
	      total = BFSearch.getSearchCount();
	      max = BFSearch.getMax();
	      
	      //BFS
	      tableRowTwo.addNewTableCell().setText(" "+(path-1));
	      tableRowThree.addNewTableCell().setText(" "+total);
	      tableRowFour.addNewTableCell().setText(" "+ max);
	     
	      path = DFSearch.search(tiles).size();
	      total = DFSearch.getSearchCount();
	      max = DFSearch.getMax();
	      
	      //DFS
	      tableRowTwo.addNewTableCell().setText(" "+(path-1));
	      tableRowThree.addNewTableCell().setText(" "+total);
	      tableRowFour.addNewTableCell().setText(" "+ max);
	      
	      path = UCSearch.search(tiles).size();
	      total = UCSearch.getSearchCount();
	      max = UCSearch.getMax();
	      
	      //UCS
	      tableRowTwo.addNewTableCell().setText(" "+(path-1));
	      tableRowThree.addNewTableCell().setText(" "+total);
	      tableRowFour.addNewTableCell().setText(" "+ max);
	      
	      
	 
	     Stack<SearchNode> solutionPath = DLSearch.search(tiles,20);
	     total = DLSearch.getSearchCount();
	     max = DLSearch.getMax();
	      
	      //DLS
	      tableRowTwo.addNewTableCell().setText(" "+(solutionPath != null ? (solutionPath.size()-1):"No Solution"));
	      tableRowThree.addNewTableCell().setText(" "+total);
	      tableRowFour.addNewTableCell().setText(" "+ max);
	      
	      path = IDSearch.search(tiles).size();
	      total = IDSearch.getSearchCount();
	      max = IDSearch.getMax();
	      
	      //IDS
	      tableRowTwo.addNewTableCell().setText(" "+(path-1));
	      tableRowThree.addNewTableCell().setText(" "+total);
	      tableRowFour.addNewTableCell().setText(" "+ max);
	      
	      path = AStarSearch.search(tiles).size();
	      total = AStarSearch.getSearchCount();
	      max = AStarSearch.getMax();
	      
	      //A*
	      tableRowTwo.addNewTableCell().setText(" "+(path-1));
	      tableRowThree.addNewTableCell().setText(" "+total);
	      tableRowFour.addNewTableCell().setText(" "+ max);
	      
	      path = GreedySearch.search(tiles).size();
	      total = GreedySearch.getSearchCount();
	      max = GreedySearch.getMax();
	      //GS
	      tableRowTwo.addNewTableCell().setText(" "+(path-1));
	      tableRowThree.addNewTableCell().setText(" "+total);
	      tableRowFour.addNewTableCell().setText(" "+ max);
	      
	      
	}
	
	
	private void newGame() {
	    do {
	      reset(); // reset in intial state
	      shuffle(); // shuffle
	    } while(!isSolvable()); // make it until grid be solvable
	    
	    if(isSolved())
	    	newGame();
	    
	  }
	  
	  private void reset() {
	    for (int i = 0; i < tiles.length; i++) {
	      tiles[i] = (i + 1) % tiles.length;
	    }
	    
	    // we set blank cell at the last
	    blankPos = tiles.length - 1;
	  }
	  
	  private void shuffle() {
	    // don't include the blank tile in the shuffle, leave in the solved position
	    int n = nbTiles;
	    
	    while (n > 1) {
	      int r = RANDOM.nextInt(n--);
	      int tmp = tiles[r];
	      tiles[r] = tiles[n];
	      tiles[n] = tmp;
	    }
	  }
	  
	  // Only half permutations o the puzzle are solvable
	  // Whenever a tile is preceded by a tile with higher value it counts
	  // as an inversion. In our case, with the blank tile in the solved position,
	  // the number of inversions must be even for the puzzle to be solvable
	  private boolean isSolvable() {
	    int countInversions = 0;
	    
	    for (int i = 0; i < nbTiles; i++) {
	      for (int j = 0; j < i; j++) {
	        if (tiles[j] > tiles[i])
	          countInversions++;
	      }
	    }
	    
	    return countInversions % 2 == 0;
	  }
	  
	  private boolean isSolved() {
		  return Arrays.equals(tiles, goal);
	  }
	  
	  private void setGoal() {
		  for(int i = 1; i<=goal.length; i++) {
		  		if(i==goal.length)
		  			goal[i-1] = 0;
		  		else
		  			goal[i-1] = i;
		  	}
	  }
}
