package DB;/*
 *  product의 list 들을 관리하는 Class index를 잘 조정하면 입력할때마다 추가모드 또는 수정모드로 열 수 있다.
 */

import DB.ProductRecord;
import DB.ReadFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class ProductList {

    public static Vector<ProductRecord> record = new Vector<ProductRecord>();
    public String fileName;
    private static int index = 0;

    public ProductList(){}
   
    public static void RecodingProduct(String line){// 정상 line을 입력받아 이를 passing하고 배열형태로 저장 
        String[] line_arr = line.split(":"); 

        for(int i=0; i<line_arr.length; i++) { // ":" 로 split한 각각의 원소의 앞,뒤 공백 제거
            line_arr[i]=line_arr[i].trim();
        }
        
        record.add(new ProductRecord(line_arr));
        index++;
    }


    public void displayProductList(String File){
    	index = 0;

        new ReadFile(File);
        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s %-15s\n", "Product Name", "Product Id", "Category", "Price", "Stock", "MinStock", "Memo");
        System.out.println("----------------------------------------------------------------------------------------------------------");
        for(int i = 0; i<index; i++){
            System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s %-15s\n", record.get(i).getName() , record.get(i).getId(), record.get(i).getCategory() , record.get(i).getPrice(), record.get(i).getStock(), record.get(i).getMinStock(),record.get(i).getMemo());
        }
        System.out.printf("\n");
    }

    public void inputProductFile(String File){
        new ReadFile(File);
        fileName = File;
    }

    public static int getIndex(){return index;}
}
