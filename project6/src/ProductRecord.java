
public class ProductRecord {
    private String name;
    private String ID;
    private String price;
    private String productAmount;
    private String minProductAmount;
    private String memo;
    private String category;

    public String getName(){
        return name;
    }
    public String getID(){
        return ID;
    }
    public String getPrice(){
        return price;
    }
    public String getProductAmount(){
        return productAmount;
    }
    public String getMinProductAmount() {
        return minProductAmount;
    }
    public String getMemo(){
        return memo;
    }
    public String getCategory(){
        return category;
    }

    public ProductRecord(String[] product){
        this.name = product[0];
        this.ID = product[1];
        this.price = product[2];
        this.productAmount = product[3];
        this.minProductAmount = product[4];
        if(product.length == 6){
            this.memo = product[5];
            this.category = setCategory(this.ID);
        }else{
            this.memo = product[5];
            this.category = product[6]; // category는 product[6]넣는다
        }

    }
    public static String setCategory(String ID){
        String categoryNumPoint = ID.substring(0, 1);;
        try{
            int categoryNum = Integer.valueOf(categoryNumPoint);
            switch (categoryNum){
                case 1:
                    return "Food";
                case 2:
                    return "Office";
                case 3:
                    return "Music";
                case 4:
                    return "Health";
                case 5:
                    return "Clothing";
                default:
                    return "error";
            }
        }catch (Exception e){
            return "error";
        }
    }

    public String[] getProduct(){
        String[] Product = {name,ID,price,productAmount,minProductAmount,memo,category};
        return Product;
    }
    public String[] getProductTable(){
        String[] Product = {name,ID,category,price,productAmount,minProductAmount,memo};
        return Product;
    }
}
