import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;


public class MainGUI {
    private String[] columnName = {"제품명", "제품ID", "카테고리", "가격", "재고수", "최소재고량", "기타 메모"};
    private DefaultTableModel defaultTable = new DefaultTableModel(columnName,0);
    private JTable table;
    private JScrollPane scrollTablePanel;
    MainGUI(Vector<ProductRecord> data, String path){

        //gui의 가장 바탕이 되는 창을 만든다.
        JFrame frame = new JFrame("Product List");
        frame.setBounds(500,500,800,200);
        frame.setLayout(new BorderLayout());


        //gui표를 만든다
        //file data를 바탕으로 표에 데이터 추가
        for(int i = 0; i< data.size();i++){
            defaultTable.addRow(data.get(i).getProductTable());
        }

        //셀 수정 금지
        table = new JTable(defaultTable){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        //셀 이동 금지
        table.getTableHeader().setReorderingAllowed(false);

        //표 배경바꿈
        table.setBackground(Color.WHITE);
        scrollTablePanel = new JScrollPane(table);
        scrollTablePanel.getViewport().setBackground(Color.white);

        //button 생성
        ButtonManager button = new ButtonManager(data,path,table,defaultTable);

        frame.add(scrollTablePanel,BorderLayout.CENTER);
        frame.add(button.getButtonPanel(), BorderLayout.EAST);

        frame.setVisible(true);
        //x버튼 클릭시 종료
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
