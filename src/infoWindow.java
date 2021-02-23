import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

public class infoWindow extends JPanel{
		private JFrame window = new JFrame();
	public infoWindow() {
		window.setLocation(50, 50);
		window.setUndecorated(true);
		window.setSize(550, 550);
		window.setVisible(true);
		
		
		setBackground(new Color(51, 0, 0));
		window.getContentPane().add(this);
		
		JLabel lbIcon = new JLabel("");
		lbIcon.setIcon(new ImageIcon("infoWindow2.png"));
		
		JLabel lbIcon_1 = new JLabel("");
		lbIcon_1.setIcon(new ImageIcon("infoWindow2.png"));
		
		JEditorPane dtrpnWelcomeNPuzzle = new JEditorPane();
		dtrpnWelcomeNPuzzle.setEditable(false);
		dtrpnWelcomeNPuzzle.setText("                   Welcome \r\n   \r\nn puzzle game, it's a game to slove a numbers.\r\nn is integer number from 2 to 16.\r\nyou put the n number then you choose\r\nthe algorathem to solve and will be solved\r\nthen you will see the information \r\nabout the algorathem.");
		dtrpnWelcomeNPuzzle.setForeground(new Color(255, 255, 255));
		dtrpnWelcomeNPuzzle.setFont(new Font("Monospaced", Font.BOLD, 17));
		dtrpnWelcomeNPuzzle.setBackground(new Color(51, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.addMouseListener(new panelButton(panel_1));
		panel_1.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				window.dispose();
				secondWindow m = new secondWindow();
			}
		});
		panel_1.setBackground(new Color(51, 0, 0));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(99)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lbIcon))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lbIcon_1, GroupLayout.PREFERRED_SIZE, 512, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(36)
							.addComponent(dtrpnWelcomeNPuzzle, GroupLayout.PREFERRED_SIZE, 476, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(28, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addComponent(lbIcon_1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(dtrpnWelcomeNPuzzle, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lbIcon, GroupLayout.PREFERRED_SIZE, 84, Short.MAX_VALUE)
					.addGap(28))
		);
		
		JLabel lblNewLabel = new JLabel("Back");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblNewLabel.setBackground(new Color(51, 0, 0));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		setLayout(groupLayout);
	}
}