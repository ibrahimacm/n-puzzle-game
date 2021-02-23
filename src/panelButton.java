import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class panelButton extends MouseAdapter{
	JPanel panel = new JPanel();
	public panelButton(JPanel panel1) {
		panel = panel1;
	}
	
	public void mouseEntered(MouseEvent arg0) {
		panel.setBackground(new Color(102,0,0));
	}
	
	public void mouseClicked(MouseEvent arg0) {
		//panel.setBackground(new Color(47,79,79));
		//(112,128,144)
	}
	public void mouseExited(MouseEvent arg0) {
		panel.setBackground(new Color(51,0,0));
	}
	public void mouseReleased(MouseEvent arg0) {
		panel.setBackground(new Color(51,0,0));
	}

}
