package DB;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Vector;

/**
 * Created by 5p on 2017-06-07.
 */
public class SaveFile {
    public SaveFile(){ }
    public SaveFile(String filename, Vector<ProductRecord> record){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            for(int i=0;i < record.size();i++){
                printFile(writer,record.get(i));
            }
            writer.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
    private void printFile(BufferedWriter writer, ProductRecord data){
        try{
            writer.write(data.getName());
            writer.write(":");
            writer.write(data.getId());
            writer.write(":");
            writer.write(data.getPrice());
            writer.write(":");
            writer.write(data.getStock());
            writer.write(":");
            writer.write(data.getMinStock());
            writer.write(":");
            writer.write(data.getMemo());
            writer.newLine();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
