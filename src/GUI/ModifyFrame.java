package GUI;

import DB.ErrorCheck;
import DB.ProductList;
import DB.ProductRecord;
import com.sun.org.apache.xpath.internal.operations.Mod;


public class ModifyFrame extends AddFrame {
    ProductTable table;
    public ModifyFrame(){};
    public ModifyFrame(ProductTable table, ProductList newList){
        super(table,newList);
    }

    @Override
    public void doneBtn(ProductTable mainTable,ProductList newList, String[] inputData) {
        mainTable.defaultTable.insertRow(mainTable.table.getSelectedRow(),inputData);
        mainTable.defaultTable.removeRow(mainTable.table.getSelectedRow()+1);
        newList.record.add(mainTable.table.getSelectedRow(),new ProductRecord(inputData));
        newList.record.remove(mainTable.table.getSelectedRow()+1);
    }

    public boolean errorCheck(String[] inputData,ProductTable mainTable){

        String[] checkData = new String[6];

        for(int i = 0 , j = 0; i<7; i++, j++){
            if(i == 2){ // 카테고리 데이터가 채워져 있다면 검사하지 않고 자동으로 id를 분석하여 추가
                if(inputData[i].isEmpty()){
                    inputData[i] = ProductRecord.findCategory(inputData[1]);
                }
                j = j-1; continue;
            }
            checkData[j] = inputData[i];
        }

        ErrorCheck check = new ErrorCheck(checkData);

        if (check.checkProduct(mainTable.table.getSelectedRow())){ // 에러가 있는지 체크하고 에러가 없으면 Product 추가
            return true;
        }else{
            return false;
        }
    }
}
