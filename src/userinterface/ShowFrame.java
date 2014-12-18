package userinterface;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import domain.Pattern;

public class ShowFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JLabel lab, lab2;
	private Pattern pattern;
	private GridBagConstraints c = new GridBagConstraints();
	public ShowFrame(Pattern p) {
		super("Show Pattern");
		
		pattern = p;
		panel = new JPanel();
		getContentPane().add(panel,BorderLayout.NORTH);
		panel.setLayout(new GridBagLayout());
		
		lab = new JLabel(pattern.getName());
		c.gridx = 0;
		c.gridy = 0;
		panel.add(lab,c);
		
		lab2 = new JLabel(pattern.getPurpose().getName());
		c.gridx = 0;
		c.gridy = 1;
		panel.add(lab2,c);
		
		
		setSize(500, 300);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

}
