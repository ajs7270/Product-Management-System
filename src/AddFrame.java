

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddFrame {
	JPanel panel1, panel2;

	public AddFrame() {
		// TODO Auto-generated constructor stub
		JFrame frm = new JFrame("Add A New Product Line");
		JButton done = new JButton("done");

		frm.setBounds(500, 400, 800, 90);
		frm.setLayout(new BorderLayout());

		panel1 = new JPanel();
		panel1.setLayout(new GridLayout(2, 7));
		
		panel1.add(new JLabel("��ǰ��"));
		panel1.add(new JLabel("��ǰID"));
		panel1.add(new JLabel("ī�װ�"));
		panel1.add(new JLabel("����"));
		panel1.add(new JLabel("����"));
		panel1.add(new JLabel("�ּ����"));
		panel1.add(new JLabel("��Ÿ �޸�"));
		
		for(int i = 0; i<7; i++){
			panel1.add(new JTextField());
		}
		

		panel2 = new JPanel();
		panel2.setLayout(new GridLayout(1, 1));
		panel2.add(done);

		frm.add(panel1, BorderLayout.CENTER);
		frm.add(panel2, BorderLayout.EAST);
		frm.setVisible(true);
		
		done.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frm.dispose();
				frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
	}
}
