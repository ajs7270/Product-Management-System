package project;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AddFrame {
	JPanel panel1, panel2;

	public AddFrame() {
		// TODO Auto-generated constructor stub
		JFrame frm = new JFrame("Add A New Product Line");
		JButton done = new JButton("done");

		frm.setBounds(500, 500, 800, 100);
		frm.setLayout(new BorderLayout());

		panel1 = new JPanel();
		panel1.setLayout(new GridLayout(2, 7));
		
		

		panel2 = new JPanel();
		panel2.add(done);

		frm.add(panel1, BorderLayout.CENTER);
		frm.add(panel2, BorderLayout.EAST);
		frm.setVisible(true);
		
		done.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("done");
				frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
	}
}
