import java.util.Scanner;

public class FileInput {
	try {
		Scanner input = new Scanner("productlist-norm.data"); // file is an instance of File
		}
		catch(Exception e) {
		// print error message and return;
		}
		
		while (input.hasNext()) {
		String line =  input.nextLine();
		// passing
		}
}
