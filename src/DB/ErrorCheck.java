package DB;

/*
 * line을 입력받아 이 line에 에러가 있는지 없는지를 검사해주는 Class 
 * 에러가 있으면 에러사항과 false를 return 하고 없으면 true를 return
 */
public class ErrorCheck {
    String[] line_arr;
    String line;
    ErrorCheck(String line){
    	this.line = line;
        line_arr = line.split(":");

        for(int i=0; i<line_arr.length; i++) { // ":" 로 split한 각각의 원소의 앞,뒤 공백 제거
            line_arr[i] = line_arr[i].trim();
            if(line_arr[i] == ""){ // 원소에 아무것도 들어있지 않으면 null로 처리
                line_arr[i] = null;
            }
        }
    }

    boolean checkProduct() {
        int price;
        int stock;
        int minStock;

        if(line_arr.length <5){ // 원소의 갯수가 5보다 작으면 예외처리
        	System.out.println("Irregular product line");
        	System.out.println("Skip the input line :" + line);
            return false;
        }

        try { // 가격, 재고, 최소 재고에 문자가 들어있으면 예외처리
            price = Integer.valueOf(line_arr[2]); //가격 
            stock = Integer.valueOf(line_arr[3]); // 재고 
            minStock = Integer.valueOf(line_arr[4]); // 최소재
        } catch (NumberFormatException e) {
        	System.out.println("Illegal value");
        	System.out.println("Skip the input line :" + line);
        	return false;
        }

        if ((price < 0)) { // 가격, 재고, 최소재고가 음수면 예외처리
        	System.out.println("Illegal current price");
        	System.out.println("Skip the input line :" + line);
            return false;
        }else if(stock < 0){
        	System.out.println("Illegal current stock");
        	System.out.println("Skip the input line :" + line);
            return false;
        }else if(minStock < 0){
        	System.out.println("Illegal current minStock");
        	System.out.println("Skip the input line :" + line);
            return false;
        }else{
        	
        }


        for (int i = 0; i < ProductList.getIndex(); i++) { // id가 같을때 예외처리
            if(line_arr[1].equals(ProductList.record.get(i).getId())){
            	System.out.println("ID Conflict");
            	System.out.println("Skip the input line :" + line);
                return false;
            }
        }

        for(int i = 0; i <5;i++){
            if(line_arr[i] == null){ // 제품 이름, 제품 id, 가격, 재고, 최소재고에 null값이 들어가 있으면 예외처리
             	System.out.println("Irregular product line");
            	return false;
            }
        }

        return true;
    }
}
