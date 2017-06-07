import java.util.Vector;

public class ProductList {
    private String path;
    public static Vector<ProductRecord> data = new Vector<ProductRecord>();

    public ProductList(String path){
        this.path = path;
        new FileRead(path);
        new MainGUI(data,path);
    }

    public static void addProduct(String productLine){
        String[] product = productLine.split(":");
        for(int i = 0;i<product.length;i++){
            product[i] = product[i].trim();
        }
        data.add(new ProductRecord(product));
    }
    /*
    public Vector<ProductRecord> getData(){
        return data;
    }
    */

}
