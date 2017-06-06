package GUI;

import DB.ErrorCheck;
import DB.ProductList;
import DB.ProductRecord;

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
	AddFrame(){};
	public AddFrame(ProductTable mainTable, ProductList newList) {
		// TODO Auto-generated constructor stub
		JFrame frm = new JFrame("Add A New Product Line");
		JButton done = new JButton("done");

		frm.setBounds(500, 400, 800, 90);
		frm.setLayout(new BorderLayout());

		panel1 = new JPanel();
		panel1.setLayout(new GridLayout(2, 7));

		panel1.add(new JLabel("제품명"));
		panel1.add(new JLabel("제품ID"));
		panel1.add(new JLabel("카테고리"));
		panel1.add(new JLabel("가격"));
		panel1.add(new JLabel("재고수"));
		panel1.add(new JLabel("최소재고량"));
		panel1.add(new JLabel("기타 메모"));

		JTextField[] textField = new JTextField[7];

		for(int i = 0; i<7; i++){
			textField[i] = new JTextField();
			panel1.add(textField[i]);
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
				String inputData[] = new String[7];
				for(int i= 0; i<7; i++){
					inputData[i] = textField[i].getText();
				}
				if(errorCheck(inputData)){
					doneBtn(mainTable,newList,inputData);
					frm.dispose();
					frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}else{
					System.out.println("잘못된 입력 값 입니다.");
				}
			}
		});
	}
	public void doneBtn(ProductTable mainTable, ProductList newList, String[] inputData){
		mainTable.defaultTable.addRow(inputData);
		newList.record.add(new ProductRecord(inputData));
	}

	public boolean errorCheck(String[] inputData){

		String[] checkData = new String[6];

		for(int i = 0 , j = 0; i<7; i++, j++){
			if(i == 2){ // 카테고리 데이터는 체크하지 않음
				j = j-1; continue;
			}
			checkData[j] = inputData[i];
		}

		ErrorCheck check = new ErrorCheck(checkData);

		if (check.checkProduct()){ // 에러가 있는지 체크하고 에러가 없으면 Product 추가
			return true;
		}else{
			return false;
		}
	}

}
