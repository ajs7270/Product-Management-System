package GUI;

import DB.ProductList;

import java.awt.Color;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ProductTable {
	public JTable table;
	public JScrollPane tablePane;
	public DefaultTableModel defaultTable;

	public ProductTable() {
		String columnNames[] = { "제품명", "제품ID", "카테고리", "가격", "재고수", "최소재고량", "기타 메모" };
		// 예시데이터
		String rowData[][] = { { "Coffee", "1-00010", "1", "1000", "100", "50", "Test1" },
			{ "연필", "2-50010", "2", "100", "1000", "500", "" } };
		defaultTable = new DefaultTableModel(rowData, columnNames);
	}

	public ProductTable(ProductList list) {
		String[] columnName = {"제품명", "제품ID", "카테고리", "가격", "재고수", "최소재고량", "기타 메모"};

		defaultTable = new DefaultTableModel(columnName,0); // d

		for(int i = 0;i <list.getIndex();i++){
			defaultTable.addRow(list.record.get(i).getData());
		}
	}

	public void addMainTable(){
		table = new JTable(defaultTable){ // 셀 수정을 금지
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		table.getTableHeader().setReorderingAllowed(false); // 셀 이동 금지
		table.setBackground(Color.WHITE);
		tablePane = new JScrollPane(table);
		tablePane.getViewport().setBackground(Color.white);
	}
}
