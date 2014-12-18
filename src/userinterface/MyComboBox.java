package userinterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class MyComboBox extends JComboBox<String> {
	
	private static final long serialVersionUID = 1L;
	
	public MyComboBox() {
		super();
	}

	public MyComboBox(String[] s) {
		super(s);
		this.addActionListener(al);
	}
	
	
	ActionListener al = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//
		}
	};

}
