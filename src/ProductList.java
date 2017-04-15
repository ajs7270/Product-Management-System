
public class ProductList {

    static ProductRecord[] record = new ProductRecord[100];
    private static int index = 0;
    
    ProductList(){}
    static int getIndex(){return index;}

    public void RecodingProduct(String line){
        String[] line_arr = line.split(":");

        for(int i=0; i<line_arr.length; i++) { // ":" 로 split한 각각의 원소의 앞,뒤 공백 제거
            line_arr[i]=line_arr[i].trim();
        }
        record[index] = new ProductRecord(line_arr);
        index++;
    }


    public void displayProductList(String File){
    	index = 0;
        new ReadFile(File);
        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s %-15s\n", "Product Name", "Product Id", "Category", "Price", "Stock", "MinStock", "Memo");
        System.out.println("----------------------------------------------------------------------------------------------------------");
        for(int i = 0; i<index; i++){
            System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s %-15s\n", record[i].getName() , record[i].getId(), record[i].getCategory() , record[i].getPrice(), record[i].getStock(), record[i].getMinStock(),record[i].getMemo());
        }
        System.out.printf("\n");
    }

}
