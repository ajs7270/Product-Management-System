import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

/**
 * Created by imagelab on 2017. 6. 7..
 */
public class ModifyButton extends AddButton {
    ModifyButton(Vector<ProductRecord> data, DefaultTableModel defaultTable, JTable productTable){
        super(data,defaultTable,productTable);
    }

    private boolean clickDone(Vector<ProductRecord> data, DefaultTableModel defaultTable,String[] saveProduct,String[] product,JTable productTable){
        ErrorCheck check = new ErrorCheck(product);

        if(product[6].isEmpty()){
            product[6] = ProductRecord.setCategory(product[1]);
            saveProduct[2] = product[6];
        }

        if(check.IDcheck(data,product[1],productTable.getSelectedRow())){
            defaultTable.insertRow(productTable.getSelectedRow(),saveProduct);
            defaultTable.removeRow(productTable.getSelectedRow()+1);
            data.add(productTable.getSelectedRow(),new ProductRecord(product));
            data.remove(productTable.getSelectedRow()+1);
            return true;
        }else{
            return false;
        }
    }
}
