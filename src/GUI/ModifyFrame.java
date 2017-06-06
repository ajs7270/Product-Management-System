package GUI;

import DB.ProductList;
import com.sun.org.apache.xpath.internal.operations.Mod;


public class ModifyFrame extends AddFrame {

    public ModifyFrame(){};
    public ModifyFrame(ProductTable table, ProductList newList){
        super();
        this.panel1.getComponents();
    }

    @Override
    public void doneBtn(ProductTable mainTable,ProductList newList, String[] inputData) {


    }
}
