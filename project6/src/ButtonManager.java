import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;


public class ButtonManager {
    private JPanel buttonPanel;
    private JButton addBtn = new JButton("Add");
    private JButton delBtn = new JButton("Delete");
    private JButton modBtn = new JButton("Modify");
    private JButton saveBtn = new JButton("Save FIle");

    ButtonManager(Vector<ProductRecord> data, String path, JTable productTable, DefaultTableModel defaultTable){
        buttonPanel = new JPanel();

        buttonPanel.setLayout(new GridLayout(4,1));
        buttonPanel.add(addBtn);
        buttonPanel.add(delBtn);
        buttonPanel.add(modBtn);
        buttonPanel.add(saveBtn);

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddButton(data,defaultTable,productTable);
            }
        });
        delBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selected = productTable.getSelectedRow();
                if(selected != -1){
                    data.remove(selected);
                    defaultTable.removeRow(selected);
                }
            }
        });
        modBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ModifyButton(data,defaultTable,productTable);
            }
        });
        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public JPanel getButtonPanel(){
        return buttonPanel;
    }


}
