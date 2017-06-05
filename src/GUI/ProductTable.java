package GUI;

import DB.ProductList;

import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ProductTable {
	JTable table;
	JScrollPane tablePane;

	public ProductTable() {
		// TODO Auto-generated constructor stub
		String columnNames[] = { "제품명", "제품ID", "카테고리", "가격", "재고수", "최소재고량", "기타 메모" };
		// 예시데이터
		String rowData[][] = { { "Coffee", "1-00010", "1", "1000", "100", "50", "Test1" },
			{ "연필", "2-50010", "2", "100", "1000", "500", "" } };

	}

	public ProductTable(ProductList list) {
		// TODO Auto-generated constructor stub
		String columnNames[] = { "제품명", "제품ID", "카테고리", "가격", "재고수", "최소재고량", "기타 메모" };

		String rowData[] = list.record.toArray();
		// 예시데이터
		String rowData[][] = { { "Coffee", "1-00010", "1", "1000", "100", "50", "Test1" },
				{ "연필", "2-50010", "2", "100", "1000", "500", "" } };

	}

	public ViewTable(){
		DefaultTableModel defaultTable = new DefaultTableModel(rowData, columnNames);
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

for(int i = 0; i<size ;i++){
	for(int j = 0; j<7;j++){

		}
		}
