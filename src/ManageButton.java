package project;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ManageButton {
	JPanel panel;

	public ManageButton() {
		JButton btn1 = new JButton("Add");
		JButton btn2 = new JButton("Delete");
		JButton btn3 = new JButton("Modify");
		JButton btn4 = new JButton("Save File");

		panel = new JPanel();

		panel.setLayout(new GridLayout(4, 1));
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(btn4);
		
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
			}
		});
	}
}
