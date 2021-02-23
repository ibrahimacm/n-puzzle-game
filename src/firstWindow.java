import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

public class firstWindow extends JPanel{
		private JFrame window = new JFrame();
	public firstWindow() {
		window.setLocation(50, 50);
		window.setUndecorated(true);
		window.setSize(550, 550);
		window.setVisible(true);
		
		
		setBackground(new Color(0, 0, 0));
		window.getContentPane().add(this);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 0, 0));
		
		JEditorPane dtrpnLoading = new JEditorPane();
		dtrpnLoading.setToolTipText("");
		dtrpnLoading.setContentType("text");
		dtrpnLoading.setFont(new Font("Poor Richard", Font.BOLD, 18));
		dtrpnLoading.setBackground(new Color(0, 0, 0));
		dtrpnLoading.setEditable(false);
		dtrpnLoading.setForeground(new Color(255, 255, 255));
		dtrpnLoading.setText("Loading...");
		
		JEditorPane dtrpnWelcomeItsHappy = new JEditorPane();
		dtrpnWelcomeItsHappy.setEditable(false);
		dtrpnWelcomeItsHappy.setFont(new Font("Monospaced", Font.BOLD, 14));
		dtrpnWelcomeItsHappy.setText("    Welcome\r\nit's happy for us\r\n to play the game\r\n\r\n  n Puzzle Game\r\n\r\n\r\n\r\n\r\n\r\n\r\n   version 1.0");
		dtrpnWelcomeItsHappy.setForeground(new Color(255, 255, 255));
		dtrpnWelcomeItsHappy.setBackground(new Color(0, 0, 0));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(dtrpnLoading, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addGap(29))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(dtrpnWelcomeItsHappy, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
							.addGap(95))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(75)
					.addComponent(dtrpnWelcomeItsHappy, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
					.addComponent(dtrpnLoading, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(30))
		);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 217, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 550, Short.MAX_VALUE)
		);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
		try {
			Thread.sleep(5000);
			window.dispose();
			secondWindow sw = new secondWindow();
		}catch(Exception e) {System.out.println(e);}
		
		
	}
}
