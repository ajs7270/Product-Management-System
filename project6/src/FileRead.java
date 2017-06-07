import java.io.File;
import java.util.Scanner;


public class FileRead {
    Scanner input = null;
    public FileRead(String fileName){
        try{
            input = new Scanner(new File(fileName));

            while(input.hasNext()){
                String line  = input.nextLine();
                if(line.isEmpty() || line.startsWith("//")){
                    continue;
                }else{
                    ErrorCheck check = new ErrorCheck(line);
                    if(check.CheckStart()){
                        ProductList.addProduct(line);
                    }else{
                        continue;
                    }
                }

            }
        }catch (Exception e){
            System.out.println("File Error");
        }
    }


}
