package GUI;

import DB.ProductList;
import DB.SaveFile;
import GUI.AddFrame;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ManageButton {
	JPanel panel;

	public ManageButton(){};
	public ManageButton(ProductTable mainTable, ProductList newList) {
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
				new AddFrame(mainTable, newList);
			}
		});
		deleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(mainTable.table.getSelectedRow() != -1){
					newList.record.remove(mainTable.table.getSelectedRow());
					mainTable.defaultTable.removeRow(mainTable.table.getSelectedRow());
				}
			}
		});
		modifyBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(mainTable.table.getSelectedRow() != -1){
					new ModifyFrame(mainTable, newList);
				}else{
					System.out.println("not selected row!");
				}
			}
		});
		saveFileBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SaveFile(newList.fileName, newList.record);
			}
		});
	}
}
