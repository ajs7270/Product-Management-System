package GUI;

import DB.ProductList;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class MainFrame {
	  public static void main(String[] args){
	  	String filename = "productlist-norm.data";
		ProductList newList = new ProductList();
		newList.inputProductFile(filename);

	  	JFrame frm = new JFrame("Product List");
	  	frm.setBounds(500,500,800,200);
	    frm.setLayout(new BorderLayout());

	    ProductTable mainTable = new ProductTable(newList);
		mainTable.addMainTable();
	    ManageButton button = new ManageButton(mainTable, newList);

		//요구사항에 맞추어 GUI요소를 구성
	    frm.add(mainTable.tablePane,BorderLayout.CENTER);
	    frm.add(button.panel, BorderLayout.EAST);
	    frm.setVisible(true);
		//x버튼 클릭 시 종료
	    frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }
}
