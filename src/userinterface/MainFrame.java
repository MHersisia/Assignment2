package userinterface;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import domain.Context;

public class MainFrame extends JFrame {
	
	private Context con;

	private static final long serialVersionUID = 1L;
	
	private JButton mb1,mb2;
	private JPanel panel;
	
	public MainFrame(Context c) {
		super("Pattern Tool");
		
		con = c;
		
		panel = new JPanel();
        getContentPane().add(panel, BorderLayout.NORTH);
        panel.setLayout(new GridLayout(0, 1, 0, 0));
        
        mb1 = new JButton("Add pattern");
        panel.add(mb1);
        mb1.addActionListener(addPattern);
        
        mb2 = new JButton("Edit pattern");
        panel.add(mb2);
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
