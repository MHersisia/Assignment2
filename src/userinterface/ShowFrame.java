package userinterface;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import domain.Pattern;

public class ShowFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JLabel lab, lab2,lab3,lab4,lab5,lab6,lab7,labImage;
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
		
		lab4 = new JLabel(pattern.getContext());
		c.gridx = 0;
		c.gridy = 1;
		panel.add(lab4,c);
		
		lab5 = new JLabel(pattern.getProblem());
		c.gridx = 0;
		c.gridy = 2;
		panel.add(lab5,c);
		
		lab6 = new JLabel(pattern.getSolution());
		c.gridx = 0;
		c.gridy = 3;
		panel.add(lab6,c);
		
		lab7 = new JLabel(pattern.getConsequences());
		c.gridx = 0;
		c.gridy = 4;
		panel.add(lab7,c);
		
		lab2 = new JLabel(pattern.getPurpose().getName());
		c.gridx = 0;
		c.gridy = 5;
		panel.add(lab2,c);
		
		lab3 = new JLabel(pattern.getScope().getName());
		c.gridx = 0;
		c.gridy = 6;
		panel.add(lab3,c);
		
		lab4 = new JLabel(pattern.getContext());
		c.gridx = 0;
		c.gridy = 7;
		panel.add(lab4,c);
		try{
			URL url  = new URL(pattern.getDiagram());
			BufferedImage image = ImageIO.read(url);
			labImage = new JLabel(new ImageIcon(image));
			c.gridx = 2;
			c.gridy = 0;
			panel.add(labImage,c);
		}catch (Exception e){
			e.printStackTrace();
		} 
		setSize(500, 300);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

}
