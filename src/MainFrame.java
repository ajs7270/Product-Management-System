
import java.awt.BorderLayout;
import javax.swing.JFrame;

public class MainFrame {
	  public static void main(String[] args){
	        JFrame frm = new JFrame("Product List");
	        frm.setBounds(500,500,800,200);
	        frm.setLayout(new BorderLayout());
	        
	        ProductTable table = new ProductTable();
	        ManageButton button = new ManageButton();
	        
	        //�䱸���׿� ���߾� GUI��Ҹ� ���� 
	        frm.add(table.tablePane,BorderLayout.CENTER);
	        frm.add(button.panel, BorderLayout.EAST);
	        frm.setVisible(true);
	        //x��ư Ŭ�� �� ����
	        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }
}
