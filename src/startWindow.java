import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JComboBox;

public class startWindow extends JPanel{
		private JFrame window = new JFrame();
		private JTextField nInput;
	@SuppressWarnings("unchecked")
	public startWindow() {
		window.getContentPane().setBackground(new Color(51, 0, 0));
		
		JPanel panelBack = new JPanel();
		panelBack.addMouseListener(new panelButton(panelBack));
		panelBack.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				window.dispose();
				secondWindow m = new secondWindow();
			}
		});
		panelBack.setBackground(new Color(51, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Back");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblNewLabel.setBackground(new Color(51, 0, 0));
		GroupLayout gl_panelBack = new GroupLayout(panelBack);
		gl_panelBack.setHorizontalGroup(
			gl_panelBack.createParallelGroup(Alignment.LEADING)
				.addGap(0, 63, Short.MAX_VALUE)
				.addGroup(gl_panelBack.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panelBack.setVerticalGroup(
			gl_panelBack.createParallelGroup(Alignment.LEADING)
				.addGap(0, 29, Short.MAX_VALUE)
				.addGroup(gl_panelBack.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelBack.setLayout(gl_panelBack);
		
		JPanel panelStart = new JPanel();
		
		
		panelStart.setBackground(new Color(51, 0, 0));
		
		JLabel lblPlay = new JLabel("Play");
		lblPlay.setForeground(Color.WHITE);
		lblPlay.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblPlay.setBackground(new Color(51, 0, 0));
		GroupLayout gl_panelStart = new GroupLayout(panelStart);
		gl_panelStart.setHorizontalGroup(
			gl_panelStart.createParallelGroup(Alignment.LEADING)
				.addGap(0, 63, Short.MAX_VALUE)
				.addGroup(gl_panelStart.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblPlay, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panelStart.setVerticalGroup(
			gl_panelStart.createParallelGroup(Alignment.LEADING)
				.addGap(0, 29, Short.MAX_VALUE)
				.addGroup(gl_panelStart.createSequentialGroup()
					.addComponent(lblPlay)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelStart.setLayout(gl_panelStart);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 0, 0));
		
		JPanel panel_2_3 = new JPanel();
		panel_2_3.setBackground(new Color(51, 0, 0));
		
		final JLabel exceptionTXT_1 = new JLabel("");
		exceptionTXT_1.setForeground(Color.CYAN);
		
		JLabel txtEnterNNumber = new JLabel("Enter n number :");
		txtEnterNNumber.setForeground(Color.WHITE);
		txtEnterNNumber.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		txtEnterNNumber.setBackground(new Color(51, 0, 0));
		
		nInput = new JTextField();
		nInput.setColumns(10);
		
		final JLabel exceptionTXT = new JLabel("");
		exceptionTXT.setForeground(Color.CYAN);
		
		JLabel lblChooseAlgorathems = new JLabel("Choose Algorithms:");
		lblChooseAlgorathems.setForeground(Color.WHITE);
		lblChooseAlgorathems.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblChooseAlgorathems.setBackground(new Color(51, 0, 0));
		
		JPanel panelBack_1 = new JPanel();
		panelBack_1.addMouseListener(new panelButton(panelBack_1));
		panelBack_1.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				window.dispose();
				BatchFile bf = new BatchFile();
			}
		});
		panelBack_1.setBackground(new Color(51, 0, 0));
		
		JLabel lblBatchfile = new JLabel("BatchFile");
		lblBatchfile.setForeground(Color.WHITE);
		lblBatchfile.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblBatchfile.setBackground(new Color(51, 0, 0));
		GroupLayout gl_panelBack_1 = new GroupLayout(panelBack_1);
		gl_panelBack_1.setHorizontalGroup(
			gl_panelBack_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 63, Short.MAX_VALUE)
				.addGroup(gl_panelBack_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblBatchfile, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panelBack_1.setVerticalGroup(
			gl_panelBack_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 29, Short.MAX_VALUE)
				.addGroup(gl_panelBack_1.createSequentialGroup()
					.addComponent(lblBatchfile)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelBack_1.setLayout(gl_panelBack_1);
		GroupLayout groupLayout = new GroupLayout(window.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(58)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(panel_2_3, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
									.addGap(6))
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(exceptionTXT, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblChooseAlgorathems, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(76)
							.addComponent(nInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(73)
					.addComponent(exceptionTXT_1, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)
					.addGap(84)
					.addComponent(panelBack_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(90, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(54)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panelBack, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
							.addComponent(panelStart, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
							.addGap(240))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtEnterNNumber, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(0, Short.MAX_VALUE))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(121, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtEnterNNumber)
							.addGap(27)
							.addComponent(nInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(exceptionTXT, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addGap(21)
							.addComponent(lblChooseAlgorathems)
							.addGap(26)
							.addComponent(panel_2_3, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(exceptionTXT_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addGap(34)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panelStart, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addComponent(panelBack, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(27)
							.addComponent(panelBack_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
					.addGap(104))
		);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.addItem("Breadth first search");
		comboBox.addItem("Depth first search");
		comboBox.addItem("Uniform cost search");
		comboBox.addItem("Depth limited search");
		comboBox.addItem("Iterative deepening search");
		comboBox.addItem("A* search");
		comboBox.addItem("Greedy search");
		comboBox.setSelectedItem(null);
		
		
		
		comboBox.setForeground(new Color(255, 255, 255));
		comboBox.setBackground(new Color(0, 0, 0));
		GroupLayout gl_panel_2_3 = new GroupLayout(panel_2_3);
		gl_panel_2_3.setHorizontalGroup(
			gl_panel_2_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2_3.createSequentialGroup()
					.addGap(20)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(54, Short.MAX_VALUE))
		);
		gl_panel_2_3.setVerticalGroup(
			gl_panel_2_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_2_3.setLayout(gl_panel_2_3);
		
		JTextPane txtWarining = new JTextPane();
		txtWarining.setFont(new Font("Monospaced", Font.BOLD, 13));
		txtWarining.setForeground(new Color(255, 255, 255));
		txtWarining.setText("* Warining:\r\nn input should be \r\nfrom 2 to 16 or you\r\nwill have Exception.\r\n\r\nNote:\r\nBatch file it's file\r\nstore all infomation\r\ndone on n =3\r\nby all algorithms.");
		txtWarining.setBackground(new Color(51, 0, 0));
		txtWarining.setEditable(false);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtWarining, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
					.addGap(20))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(28)
					.addComponent(txtWarining, GroupLayout.PREFERRED_SIZE, 152, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		panelStart.addMouseListener(new panelButton(panelStart));
		panelStart.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				exceptionTXT.setText("");
				exceptionTXT_1.setText("");
				
				try {
					int n ;
					
				n = (Integer.parseInt(nInput.getText()));
				if(n<2 || n>16)
					throw new customException(1);
				
				String item = (String) comboBox.getSelectedItem();
				if(item == null)
					throw new customException(2);
				
				Npuzzle gof = new Npuzzle(n, 550, 30, comboBox.getSelectedIndex());
				window.dispose();
				
				}
				catch(customException x) {
					if(x.getN() == 1) 
					exceptionTXT.setText("Invalid range. Try again from 2 to 16.");
					
					else
					exceptionTXT_1.setText("Choose Algorithem.");
					
				}
				catch(Exception e) {
					exceptionTXT.setText("Invalid. Try again");
					System.out.println(e.getMessage());
				}
				
				
			}
		});
		
		window.getContentPane().setLayout(groupLayout);
		window.setLocation(50, 50);
		window.setUndecorated(true);
		window.setSize(550, 550);
		window.setVisible(true);
	}
}
