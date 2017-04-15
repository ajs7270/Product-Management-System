import java.io.File;
import java.util.Scanner;

public class ReadFile {
    Scanner input = null;
    ReadFile(String FileName){
        try {
            input = new Scanner(new File(FileName)); // file is an instance of File
        }
        catch(Exception e) {
            System.out.println("Unknown File");
            return;
        }

        while(input.hasNext()) {
            String line = input.nextLine();
            if(line.isEmpty() || line.startsWith("//")) // 주석처리
                continue;
            ErrorCheck check = new ErrorCheck(line);

            if (check.checkProduct()){
                ProductList product = new ProductList();
                product.RecodingProduct(line);
            }
        }
    }
}
