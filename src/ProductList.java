
public class ProductList {

    static ProductRecord[] record = new ProductRecord[100];
    private static int index = 0;
    int printList = 0;
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
        new ReadFile(File);
        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s %-15s\n", "Product Name", "Product Id", "Category", "Price", "Stock", "MinStock", "Memo");
        System.out.println("----------------------------------------------------------------------------------------------------------");
        for(; printList<index; printList++){
            System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s\n", record[printList].getName() , record[printList].getId(), record[printList].getCategory() , record[printList].getPrice(), record[printList].getStock(), record[printList].getMinStock(),record[printList].getMemo());
        }
        System.out.printf("\n");
    }

}
