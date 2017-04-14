
public class ProductRecord {
    private String productName;
    private String productId;
    private String price;
    private String stock;
    private String minStock;
    private String memo;
    private String category;

    public ProductRecord(String[] line){
        if(line.length == 5) {
            productName =line[0];
            productId = line[1];
            price = line[2];
            stock = line[3];
            minStock = line[4];
            memo = "";
        }else{
            productName =line[0];
            productId = line[1];
            price = line[2];
            stock = line[3];
            minStock = line[4];
            memo = line[5];
        }
    }

    public ProductRecord(String productName, String productId, String price, String stock, String minStock, String memo){
        this.productName = productName;
        this.productId = productId;
        this.price = price;
        this.stock = stock;
        this.minStock = minStock;
        this.memo = memo;
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

    public void print(){
        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s", productName, productId, price, stock, minStock, memo);
    }
}
