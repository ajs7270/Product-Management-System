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

    @Override
    boolean clickDone(Vector<ProductRecord> data, DefaultTableModel defaultTable,String[] saveProduct,String[] product,JTable productTable){
        ErrorCheck check = new ErrorCheck(product);
        int selected = productTable.getSelectedRow();

        product[6] = ProductRecord.setCategory(product[1]);
        saveProduct[2] = product[6];


        if(check.IDcheck(data,product[1],selected)){
            defaultTable.removeRow(selected);
            defaultTable.insertRow(selected,product);
            data.remove(selected);
            data.add(selected,new ProductRecord(saveProduct));
            return true;
        }else{
            return false;
        }
    }
}
