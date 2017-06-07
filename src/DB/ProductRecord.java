package DB;/*
 * 정상적인 product의 String[]을 입력받아 각각의 사항을 객체로 저장 
 */

public class
ProductRecord {
    private String productName;
    private String productId;
    private String price;
    private String stock;
    private String minStock;
    private String memo;
    private String category;

    ProductRecord(){}
    
    public ProductRecord(String[] line){
        if(line.length == 5) {
            productName =line[0];
            productId = line[1];
            category = findCategory(productId);
            price = line[2];
            stock = line[3];
            minStock = line[4];
            memo = "";
        }else if(line.length == 6){
            productName =line[0];
            productId = line[1];
            category = findCategory(productId);
            price = line[2];
            stock = line[3];
            minStock = line[4];
            memo = line[5];
        }else{
            productName =line[0];
            productId = line[1];
            price = line[3];
            stock = line[4];
            minStock = line[5];
            memo = line[6];
            if(line[2].isEmpty()){
                category = findCategory(productId);
            }else{
                category = line[2];
            }
        }
    }

    public ProductRecord(String productName, String productId, String price, String stock, String minStock, String memo){
        this.productName = productName;
        this.productId = productId;
        this.category = findCategory(productId);
        this.price = price;
        this.stock = stock;
        this.minStock = minStock;
        this.memo = memo;
    }

    public static String findCategory(String id) {
        id = id.substring(0, 1);
        if (id.contains("1")) {
            return "Food";
        } else if (id.contains("2")) {
            return "Office";
        } else if (id.contains("3")) {
            return "Muisc";
        } else if (id.contains("4")) {
            return "Health";
        } else if (id.contains("5")) {
            return "Clothing";
        } else {
            return "Error";
        }
    }
    public void setName(String productName){
        this.productName=productName;
    }

    public void setId(String productId){
        this.productId = productId;
    }

    public void setCategory(String category){
        this.category=category;
    }

    public void setPrice(String price){
        this.price = price;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public void setMinStock(String minStock) {
        this.minStock = minStock;
    }

    public void setMemo(String memo) {
        this.memo=memo;
    }

    public String getName(){
        return productName;
    }

    public String getId(){
        return productId;
    }

    public String getCategory(){
        return category;
    }

    public String getPrice(){
        return price;
    }

    public String getStock() {
        return stock;
    }

    public String getMinStock() {
        return minStock;
    }

    public String getMemo() {
        return memo;
    }

    public String[] getData(){
        String data[] = {productName, productId, category, price, stock, minStock, memo};
        return data;
    }

    public void print(){
        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s", productName, productId, price, stock, minStock, memo);
    }

}
