package userinterface;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import domain.Context;
import domain.Pattern;

public class SelectFrame extends JFrame {
	private Context con;
	private JButton mb1,mb2,mb3;
	private MyComboBox mcb1,mcb2,mcb3;
	private JPanel panel,panel_1,panel_2;

	private static final long serialVersionUID = 1L;
	
	public SelectFrame(Context c) {
		super("Pattern Selector");
		
		con = c;
		
		panel = new JPanel();
        getContentPane().add(panel, BorderLayout.NORTH);
        panel.setLayout(new GridLayout(0, 1, 0, 0));
        {
            panel_1 = new JPanel();
            panel.add(panel_1);
            {                
                mcb1 = new MyComboBox(c.getPurposesString());
        		panel_1.add(mcb1);
        		
        		mcb2 = new MyComboBox(c.getScopesString());
        		panel_1.add(mcb2);
        		
        		mb1 = new JButton("Show");
        		mb1.addActionListener(showPattern);
        		panel_1.add(mb1);
            }
        }
        {
            panel_2 = new JPanel();
            panel.add(panel_2);
            panel_2.setVisible(false);
            {                
                mcb3 = new MyComboBox();
                panel_2.add(mcb3);        		
        		
        		mb2 = new JButton("Show");
        		panel_2.add(mb2);
        		mb2.addActionListener(showPatternInfo);
        		
        		mb3 = new JButton("Edit");
        		panel_2.add(mb3);
        		mb3.addActionListener(editPatternInfo);
            }
        }

		setSize(500, 300);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}	
	
	ActionListener showPattern = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			mcb3.removeAllItems();
			String pur = (String) mcb1.getSelectedItem();
			String scp = (String) mcb2.getSelectedItem();
			for(Pattern p : con.getPatterns()) {
				if(p.getPurpose().getName().equals(pur) && p.getScope().getName().equals(scp)) {
					mcb3.addItem(p.getName());
				}
			}
			panel_2.setVisible(true);
			if(mcb3.getItemCount()==0) {
				panel_2.setVisible(false);
			}
		}
	};
	
	ActionListener showPatternInfo = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String pattern = (String) mcb3.getSelectedItem();
			for(Pattern p : con.getPatterns()) {
				if(p.getName().equals(pattern)) {
					System.out.println(p.getName()+" clicked");
					new ShowFrame(p);
				}
			}			
		}
	};
	
	ActionListener editPatternInfo = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String pattern = (String) mcb3.getSelectedItem();
			for(Pattern p : con.getPatterns()) {
				if(p.getName().equals(pattern)) {
					System.out.println(p.getName()+" clicked");
					new EditFrame(p);
				}
			}	
		}
	};
	
}
