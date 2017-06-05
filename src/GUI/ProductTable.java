package GUI;

import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ProductTable {
	JTable table;
	JScrollPane tablePane;

	public ProductTable() {
		// TODO Auto-generated constructor stub
		String columnNames[] = { "???", "??ID", "????", "??", "???", "?????", "?? ??" };
		// ?????
		String rowData[][] = { { "Coffee", "1-00010", "1", "1000", "100", "50", "Test1" },
				{ "??", "2-50010", "2", "100", "1000", "500", "" } };

		DefaultTableModel defaultTable = new DefaultTableModel(rowData, columnNames);
		table = new JTable(defaultTable);
		table.setBackground(Color.WHITE);
		tablePane = new JScrollPane(table);
		tablePane.getViewport().setBackground(Color.white);
	}
}
