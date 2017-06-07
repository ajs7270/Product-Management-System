import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;


public class AddButton {
    private JPanel inputPanel,buttonPanel;
    private JTextField[] textField;
    JButton done = new JButton("done");

    AddButton(Vector<ProductRecord> data, DefaultTableModel defaultTable, JTable productTable){
        JFrame addFrame = new JFrame("Add A New Product Line");

        addFrame.setBounds(500,600,800,100);
        addFrame.setLayout(new BorderLayout());

        inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2,7));

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1,1));

        inputPanel.add(new JLabel("제품명"));
        inputPanel.add(new JLabel("제품ID"));
        inputPanel.add(new JLabel("카테고리"));
        inputPanel.add(new JLabel("가격"));
        inputPanel.add(new JLabel("재고"));
        inputPanel.add(new JLabel("최소재고량"));
        inputPanel.add(new JLabel("기타 메모"));

        textField = new JTextField[7];
        for(int i = 0; i<7;i++){
            textField[i] = new JTextField();
            inputPanel.add(textField[i]);
        }

        buttonPanel.add(done);

        addFrame.add(inputPanel,BorderLayout.CENTER);
        addFrame.add(buttonPanel,BorderLayout.EAST);

        addFrame.setVisible(true);

        //done버튼의 action 감지
        done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String saveProduct[] = new String[7];
                String product[] = new String[7];
                ErrorCheck check;
                int emptyField = 0;

                //text field에 적힌 값들을 읽어옴 || 빈칸이 2개 이상이면 예외처리
                for(int i = 0,j =0 ;i<7;i++,j++){
                    product[i] = textField[i].getText();
                    if(textField[i].getText().isEmpty()){emptyField++; }
                    if(i == 2) {
                        saveProduct[6] = textField[i].getText();
                        j = j - 1;
                        continue;
                    }
                    saveProduct[j] = textField[i].getText();
                }

                if(emptyField > 1){
                    System.out.println("다시 입력 해 주세요");
                }else{
                    check = new ErrorCheck(saveProduct);
                    if(check.CheckStart()){
                        if(clickDone(data,defaultTable,saveProduct,product,productTable)){
                            addFrame.dispose();
                            addFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        }
                    }else{
                        System.out.println("잘못된 입력 값 입니다.");
                    }
                }

            }
        });
    }

    private boolean clickDone(Vector<ProductRecord> data, DefaultTableModel defaultTable,String[] saveProduct,String[] product,JTable productTable){
        ErrorCheck check = new ErrorCheck(product);

        product[6] = ProductRecord.setCategory(product[1]);
        saveProduct[2] = product[6];
        System.out.println("wlktn");

        if(check.IDcheck(data, product[1])){
            data.add(new ProductRecord(saveProduct));
            defaultTable.addRow(product);
            return true;
        }else{
            return false;
        }
    }
}
