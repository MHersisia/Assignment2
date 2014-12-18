package userinterface;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import domain.Context;

public class AddFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel panel;
	private JButton mb1,mb2;
	private JFileChooser fc;
	private Context con;
	
	public AddFrame(Context c) {
		super("Add Pattern");
		
		con = c;
		
		panel = new JPanel();
        getContentPane().add(panel, BorderLayout.NORTH);
        panel.setLayout(new GridLayout(0, 1, 0, 0));
        
        mb1 = new JButton("Select patterns");
        panel.add(mb1);
        mb1.addActionListener(selectPatterns);

        

		setSize(500, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	ActionListener selectPatterns = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			fc = new JFileChooser();
			fc.setDialogTitle("Choose a pattern");
			fc.setMultiSelectionEnabled(true);
			int returnVal = fc.showOpenDialog(panel);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File[] files = fc.getSelectedFiles();
				for(int i = 0;i<files.length;i++) {
					String ext = files[i].getName().substring(files[i].getName().lastIndexOf('.'));
					if(ext!=null && ext!="") {
						con.parseToPattern(files[i].getPath(),files[i].getName(),ext);
					}
				}
			}	
		}
	};

}
