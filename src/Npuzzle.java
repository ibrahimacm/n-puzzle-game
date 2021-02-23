import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Random;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextPane;

// We are going to create a Game of 15 Puzzle with Java 8 and Swing
// If you have some questions, feel free to ue comments ;)
public class Npuzzle extends JPanel { // our grid will be drawn in a dedicated Panel
  
  // Size of our Game of Fifteen instance
  private static int size;
  // Number of tiles
  private int nbTiles;
  // Grid UI Dimension
  private int dimension;
  // Foreground Color
  private static final Color FOREGROUND_COLOR = new Color(239, 83, 80); // we use arbitrary color
  // Random object to shuffle tiles
  private static final Random RANDOM = new Random();
  // Storing the tiles in a 1D Array of integers
  private int[] tiles;
  // Size of tile on UI
  private int tileSize;
  // Position of the blank tile
  private int blankPos;
  // Margin for the grid on the frame
  private int margin;
  // Grid UI Size
  private int gridSize;
  private boolean gameOver; // true if game over, false otherwise
  
  private int total = 0;
  private int max = 0;
  private int sizeOfS =0;
  private  Timer tm;
  private Stack<SearchNode> solutionPath;
  private SearchNode tempNode;
  private static int[] goal;
  private boolean f = true;
 
  
  private JFrame window = new JFrame();
  JTextPane textPane = new JTextPane();
  
  public Npuzzle(final int size, int dim, int mar, int algo) {
    this.size = size;
    dimension = dim;
    margin = mar;
    
    // init tiles 
    nbTiles = size * size - 1; // -1 because we don't count blank tile
    tiles = new int[size * size];
    
    // calculate grid size and tile size
    gridSize = (dim - 2 * margin);
    tileSize = gridSize / size;
    
    setPreferredSize(new Dimension(800, 600));
    setBackground(new Color(51, 0, 0));
    setForeground(new Color(255, 255, 255));
    setFont(new Font("SansSerif", Font.BOLD, tileSize/2));
    setLayout(new CardLayout(0, 0));
    
    
    // under uesr interface
    
   
    
    JLayeredPane layeredPane = new JLayeredPane();
    add(layeredPane, "name_101770217591200");
    layeredPane.setVisible(true);
  
    
    JPanel panelBack = new JPanel();
    panelBack.setBackground(new Color(51, 0, 0));
    panelBack.setBounds(32, 535, 56, 28);
    layeredPane.add(panelBack);
    
    JLabel lblNewLabel_1 = new JLabel("Back");
    lblNewLabel_1.setForeground(Color.WHITE);
    lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
    lblNewLabel_1.setBackground(new Color(51, 0, 0));
    GroupLayout gl_panelBack = new GroupLayout(panelBack);
    gl_panelBack.setHorizontalGroup(
    	gl_panelBack.createParallelGroup(Alignment.LEADING)
    		.addGroup(Alignment.TRAILING, gl_panelBack.createSequentialGroup()
    			.addGap(8)
    			.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
    			.addContainerGap())
    );
    gl_panelBack.setVerticalGroup(
    	gl_panelBack.createParallelGroup(Alignment.LEADING)
    		.addGroup(gl_panelBack.createSequentialGroup()
    			.addComponent(lblNewLabel_1)
    			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    panelBack.setLayout(gl_panelBack);
    
    JPanel Exit = new JPanel();
    Exit.setBackground(new Color(51, 0, 0));
    Exit.setBounds(427, 535, 56, 28);
    layeredPane.add(Exit);
    
    JLabel lblExit = new JLabel("Exit");
    lblExit.setForeground(Color.WHITE);
    lblExit.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
    GroupLayout gl_Exit = new GroupLayout(Exit);
    gl_Exit.setHorizontalGroup(
    	gl_Exit.createParallelGroup(Alignment.LEADING)
    		.addGroup(gl_Exit.createSequentialGroup()
    			.addContainerGap()
    			.addComponent(lblExit, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
    			.addContainerGap())
    );
    gl_Exit.setVerticalGroup(
    	gl_Exit.createParallelGroup(Alignment.LEADING)
    		.addGroup(gl_Exit.createSequentialGroup()
    			.addComponent(lblExit, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
    			.addContainerGap())
    );
    Exit.setLayout(gl_Exit);
  
    panelBack.addMouseListener(new panelButton(panelBack));
	panelBack.addMouseListener(new MouseAdapter() {
		
		public void mouseClicked(MouseEvent arg0) {
			startWindow m = new startWindow();
			window.dispose();
		}
	});
	
	panelBack.setBackground(new Color(51, 0, 0));
    
	
    Exit.setLayout(gl_Exit);
  
    Exit.addMouseListener(new panelButton(Exit));
    textPane.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
    textPane.setEditable(false);
    
   
    textPane.setBackground(new Color(51, 0, 0));
    textPane.setForeground(new Color(255, 255, 255));
    textPane.setBounds(528, 76, 262, 298);
    layeredPane.add(textPane);
	Exit.addMouseListener(new MouseAdapter() {
		
		public void mouseClicked(MouseEvent arg0) {
			window.dispose();
		}
	});
    
    // above user interface..
	
    gameOver = true;
    
      newGame();
      
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      window.setLocation(50, 50);
      window.setUndecorated(true);
      window.setSize(550, 550);
      window.setVisible(true);
      window.getContentPane().add(this);
      window.pack();
      
      
      setGoal();
   
	
      
      JOptionPane xx = new JOptionPane();
	  xx.showMessageDialog(null, "Will Take some time. \n Be patient, please.");
      switch (algo) {
      case 0: 
      	{
    	  // Breadth First Search
      		solutionPath = null;
    	  solutionPath = BFSearch.search(tiles);
    	  total = BFSearch.getSearchCount();
    	  max = BFSearch.getMax();
    	  break;
      	}
    	  
      case 1: 
      	{
    	  // Depth First Search
      		solutionPath = null;
    	  solutionPath = DFSearch.search(tiles);
    	  total = DFSearch.getSearchCount();
    	  max = DFSearch.getMax();
    	  break;
      	}
      
      case 2:
      	{
    	  // Uniform Cost Search
      		solutionPath = null;
    	  solutionPath = UCSearch.search(tiles);
    	  total = UCSearch.getSearchCount();
    	  max = UCSearch.getMax();
    	  break; 
      	}
      
      case 3:
      	{
    	  // Depth limited search
      		solutionPath = null;
      	  JOptionPane x = new JOptionPane();
      	  int l ;
      	  boolean flag = false;
      	  do {
      		try {  
		 String t = x.showInputDialog( (flag? "Wrong, please do it again. ":" " ) +"Enter the limit for depth limit search:");
		 l = Integer.parseInt(t);
		 if(l<0)
			 flag = true;
      		}catch(Exception e) {l=-1; flag = true;}
		 
      	  }while(l<0);
      		
		 
		 
    	  solutionPath = DLSearch.search(tiles,l);
    	   f = DLSearch.getFlag();
    	   if(f) {
    		   total = DLSearch.getSearchCount();
    		   max = DLSearch.getMax();
    	   }
    	  break; 
    	  
      	}
      
      case 4:
      	{
    	  // Iterative deepening search
      		solutionPath = null;
      		  solutionPath = IDSearch.search(tiles);
		      total = IDSearch.getSearchCount();
		      max = IDSearch.getMax();
    	  break; 
      	}
      
      case 5: 
      	{
    	  // A* 
      		solutionPath = null;
    	  solutionPath = AStarSearch.search(tiles);
    	  total = AStarSearch.getSearchCount();
    	  max = AStarSearch.getMax();
    	  break; 
      	}
      
      case 6: 
      	{
    	  // Greedy Search
      		solutionPath = null;
    	  solutionPath = GreedySearch.search(tiles);
    	  total = GreedySearch.getSearchCount();
    	  max = GreedySearch.getMax();
    	  break; 
      	}
      	
      }
      
      if(solutionPath!=null) {
      sizeOfS = solutionPath.size();
      
      textPane.setText(" * Path Cost = "+(sizeOfS-1) + " \n "+ "\n" +
	    	   "\n" + " * Processed nodes = " + total + "\n" + "\n" + " * Max nodes stored = "+ max);
      }
      
      EventQueue.invokeLater(new Runnable() {
    	   public void run() {
    	    try {
    	    	sol();
    	    } catch (Exception e) {
    	     e.printStackTrace();
    	    }
    	   }
    	  });
		
     
      
    }
  
  private void sol() {
	  
	  tm = new Timer(500, new ActionListener() {
		   
		   
		   public void actionPerformed(ActionEvent arg0) {
			   
			   if(solutionPath!=null) {
			   int newBlankPos = solutionPath.pop().getCurState().getHole();
               tiles[blankPos] = tiles[newBlankPos];
               blankPos = newBlankPos;
               tiles[blankPos] = 0;
               gameOver = isSolved();
               repaint();
			   }
 				
               
               if(!f) {
            	   textPane.setText(" No Solution. ");
            	   tm.stop();
            	   return;
               }
               
		       if(isSolved()) {
		    	   setSize(800, 600);
		    	   window.setSize(800, 600);
		    	   textPane.setText(" * Path Cost = "+(sizeOfS-1) + " \n "+ "\n" +
		    	   "\n" + " * Processed nodes = " + total + "\n" + "\n" + " * Max nodes stored = "+ max);
		    	   tm.stop();
		       }
		       if(solutionPath.size() == 0)
	 				tm.stop();
		    
		       }
		     });
		  
		       tm.start();
		  
		 }
	  
	        
  private void newGame() {
    do {
      reset(); // reset in intial state
      shuffle(); // shuffle
    } while(!isSolvable()); // make it until grid be solvable
    
    if(isSolved())
    	newGame();
    gameOver = false;
    
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
	  
	  /*
    if (tiles[tiles.length - 1] != 0) // if blank tile is not in the solved position ==> not solved
      return false;
    
    for (int i = nbTiles - 1; i >= 0; i--) {
      if (tiles[i] != i + 1)
        return false;      
    }
    
    return true;
    */
	  return Arrays.equals(tiles, goal);
  }
  
  private void drawGrid(Graphics2D g) {
    for (int i = 0; i < tiles.length; i++) {
      // we convert 1D coords to 2D coords given the size of the 2D Array
      int r = i / size;
      int c = i % size;
      // we convert in coords on the UI
      int x = margin + c * tileSize;
      int y = margin + r * tileSize;
      
      // check special case for blank tile
      if(tiles[i] == 0) {
        if (gameOver) {
          g.setColor(FOREGROUND_COLOR);
          drawCenteredString(g, "\u2713", x, y);
        }
        
        continue;
      }
      
      // for other tiles
      g.setColor(getForeground());
      g.fillRoundRect(x, y, tileSize, tileSize, 25, 25);
      g.setColor(Color.BLACK);
      g.drawRoundRect(x, y, tileSize, tileSize, 25, 25);
      g.setColor(Color.BLACK);
      
      drawCenteredString(g, String.valueOf(tiles[i]), x , y);
    }
  }
  
  private void drawStartMessage(Graphics2D g) {
    if (gameOver) {
      g.setFont(getFont().deriveFont(Font.BOLD, 18));
      g.setColor(FOREGROUND_COLOR);
      String s = "";
      g.drawString(s, (getWidth() - g.getFontMetrics().stringWidth(s)) / 2,
          getHeight() - margin);
    }
  }
  
  private void drawCenteredString(Graphics2D g, String s, int x, int y) {
    // center string s for the given tile (x,y)
    FontMetrics fm = g.getFontMetrics();
    int asc = fm.getAscent();
    int desc = fm.getDescent();
    g.drawString(s,  x + (tileSize - fm.stringWidth(s)) / 2, 
        y + (asc + (tileSize - (asc + desc)) / 2));
  }
  
  
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2D = (Graphics2D) g;
    g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    drawGrid(g2D);
    drawStartMessage(g2D);

  }
  public static void setGoal() {
	  goal = new int[size*size];
	  for(int i = 1; i<=goal.length; i++) {
	  		if(i==goal.length)
	  			goal[i-1] = 0;
	  		else
	  			goal[i-1] = i;
	  	}
  }
  public static int[] getGoal() {
	  return goal;
  }
  public static int getn() {
	  return size;
  }
  public static void setn(int n) {
	  size = n;
  }
}
  
 
/* 
 *   
     
      tiles[0]= 2;
      tiles[1]= 3;
      tiles[2]= 4;
      tiles[3]= 8;
      tiles[4]= 1;
      tiles[5]= 6;
      tiles[6]= 0;
      tiles[7]= 12;
      tiles[8]= 5;
      tiles[9]= 10;
      tiles[10]= 7;
      tiles[11]= 11;
      tiles[12]= 9;
      tiles[13]= 13;
      tiles[14]= 14;
      tiles[15]= 15;
      blankPos = 6;
      
      
      
      
      _________________________________________
      
      
      tiles[0]= 1;
      tiles[1]= 2;
      tiles[2]= 3;
      tiles[3]= 4;
      tiles[4]= 5;
      tiles[5]= 6;
      tiles[6]= 7;
      tiles[7]= 8;
      tiles[8]= 9;
      tiles[9]= 10;
      tiles[10]= 11;
      tiles[11]= 12;
      tiles[12]= 13;
      tiles[13]= 14;
      tiles[14]= 15;
      tiles[15]= 16;
      tiles[16]= 17;
      tiles[17]= 18;
      tiles[18]= 19;
      tiles[19]= 0;
      tiles[20]= 21;
      tiles[21]= 22;
      tiles[22]= 23;
      tiles[23]= 24;
      tiles[24]= 20;
     
      blankPos = 19;
      
      _______________________
      
      
      tiles[0]= 1;
      tiles[1]= 2;
      tiles[2]= 3;
      tiles[3]= 0;
      tiles[4]= 4;
      tiles[5]= 6;
      tiles[6]= 7;
      tiles[7]= 5;
      tiles[8]= 8;
      
      blankPos = 3;
      
      
      _____________________
      
      
       
      tiles[0]= 3;
      tiles[1]= 1;
      tiles[2]= 6;
      tiles[3]= 4;
      tiles[4]= 5;
      tiles[5]= 12;
      tiles[6]= 9;
      tiles[7]= 7;
      tiles[8]= 10;
      tiles[9]= 2;
      tiles[10]= 11;
      tiles[11]= 8;
      tiles[12]= 13;
      tiles[13]= 14;
      tiles[14]= 15;
      tiles[15]= 0;
      blankPos = 15;
      
      
      _________________
       tiles[0]= 3;
      tiles[1]= 1;
      tiles[2]= 6;
      tiles[3]= 4;
      tiles[4]= 5;
      tiles[5]= 12;
      tiles[6]= 9;
      tiles[7]= 7;
      tiles[8]= 10;
      tiles[9]= 2;
      tiles[10]= 11;
      tiles[11]= 8;
      tiles[12]= 13;
      tiles[13]= 14;
      tiles[14]= 15;
      tiles[15]= 0;
      blankPos = 15;
      
      __________
      
       tiles[0]= 7;
      tiles[1]= 5;
      tiles[2]= 0;
      tiles[3]= 3;
      tiles[4]= 2;
      tiles[5]= 1;
      tiles[6]= 6;
      tiles[7]= 4;
      tiles[8]= 8;
     
      blankPos = 2;
      
      
 * 
 * */
