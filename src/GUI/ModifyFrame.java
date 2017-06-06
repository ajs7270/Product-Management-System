package GUI;

import com.sun.org.apache.xpath.internal.operations.Mod;


public class ModifyFrame extends AddFrame {

    public ModifyFrame(){};
    public ModifyFrame(ProductTable table){
        super();
        this.panel1.getComponents();
    }

    @Override
    public void doneBtn(ProductTable mainTable, String[] inputData) {
        super.doneBtn(mainTable, inputData);

    }
}
