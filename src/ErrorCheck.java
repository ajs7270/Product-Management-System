
public class ErrorCheck {
    String[] line_arr;

    ErrorCheck(String line){
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
            return false;
        }

        try { // 가격, 재고, 최소 재고에 문자가 들어있으면 예외처리
            price = Integer.valueOf(line_arr[2]);
            stock = Integer.valueOf(line_arr[3]);
            minStock = Integer.valueOf(line_arr[4]);
        } catch (NumberFormatException e) {
            return false;
        }

        if ((price < 0) || (stock < 0) || (minStock < 0)) { // 가격, 재고, 최소재고가 음수면 예외처리
            return false;
        }


        for (int i = 0; i < ProductList.getIndex(); i++) { // id가 같을때 예외처리
            if(line_arr[1] == ProductList.record[i].getId()){
                return false;
            }
        }

        for(int i = 0; i <5;i++){
            if(line_arr[i] == null){ // 제품 이름, 제품 id, 가격, 재고, 최소재고에 null값이 들어가 있으면 예외처리
                return false;
            }
        }

        return true;
    }
}
