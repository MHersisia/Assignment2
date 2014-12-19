package userinterface;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import domain.Context;

public class MainFrame extends JFrame {
	
	private Context con;

	private static final long serialVersionUID = 1L;
	
	private JButton mb1,mb2;
	private JPanel panel,panel2;
	private JLabel lab,lab1,lab2;
	private GridBagConstraints c = new GridBagConstraints();
	
	public MainFrame(Context cn) {
		super("Pattern Tool");
		
		con = cn;
		
		panel = new JPanel();
        getContentPane().add(panel, BorderLayout.NORTH);
        panel.setLayout(new GridBagLayout());
        
        lab = new JLabel(" ");
		c.gridx = 0;
		c.gridy = 0;		
		c.anchor = GridBagConstraints.CENTER;
		panel.add(lab,c);
        
        lab1 = new JLabel("<html><body style='width: 350 px'>Welcome by our Pattern tool. With this tool you can view Design Patterns to design software.\n After importing a pattern you are able to show, edit and delete patterns.");
        c.gridx = 0;
		c.gridy = 1;		
		c.anchor = GridBagConstraints.CENTER;
		panel.add(lab1,c);
		
		lab2 = new JLabel(" ");
		c.gridx = 0;
		c.gridy = 2;		
		c.anchor = GridBagConstraints.CENTER;
		panel.add(lab2,c);
		
		panel2 = new JPanel();
		c.gridx = 0;
		c.gridy = 2;		
		c.anchor = GridBagConstraints.CENTER;
		panel.add(panel2,c);
        
        mb1 = new JButton("Add pattern");
        c.gridx = 0;
		c.gridy = 0;		
		c.anchor = GridBagConstraints.CENTER;
		panel2.add(mb1,c);
        mb1.addActionListener(addPattern);
        
        mb2 = new JButton("All patterns");
        c.gridx = 0;
		c.gridy = 0;		
		c.anchor = GridBagConstraints.CENTER;
		panel2.add(mb2,c);
        mb2.addActionListener(editPattern);
        

		setSize(500, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}	
	
	ActionListener addPattern = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			new AddFrame(con);
		}
	};
	
	ActionListener editPattern = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			new SelectFrame(con);
		}
	};

}
