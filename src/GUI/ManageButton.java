package GUI;

import GUI.AddFrame;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ManageButton {
	JPanel panel;

	public ManageButton() {
		JButton addBtn = new JButton("Add");
		JButton deleteBtn = new JButton("Delete");
		JButton modifyBtn = new JButton("Modify");
		JButton saveFileBtn = new JButton("Save File");

		panel = new JPanel();

		panel.setLayout(new GridLayout(4, 1));
		panel.add(addBtn);
		panel.add(deleteBtn);
		panel.add(modifyBtn);
		panel.add(saveFileBtn);

		addBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddFrame();
			}
		});
		deleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		modifyBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ModifyFrame();
			}
		});
		saveFileBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
	}
}
