import java.util.Vector;

public class ErrorCheck {
    private String[] lineArray;
    private String line;

    //line으로 들어온 정보는 lineArray가 가지게 변환한다.
    ErrorCheck(String line){
        this.line = line;
        this.lineArray = line.split(":");
    }
    ErrorCheck(String[] lineArray){
        this.lineArray = lineArray;
    }

    //Error Check를 시작한다.
    public boolean CheckStart(){
        int productNum = lineArray.length;
        int price;
        int productAmount;
        int minProductAmount;

        for(int i = 0; i<lineArray.length;i++){
            lineArray[i] = lineArray[i].trim();// 요소들의 앞 뒤 공백 제거
            if(lineArray[i] == ""){
                lineArray[i]=null;
                productNum--;
            }
        }

        //원소의 갯수 5개 이하 예외처리
        if(productNum < 5){
            return false;
        }

        //제품이름.id,가격,재고,최소재고가 null이면 예외처리
        for(int i =0; i < 5;i++){
            if(lineArray[i] == null){
                return false;
            }
        }

        // 숫자여야 하는 값들이 문자 or 음수이면 예외처리
        try{
            price = Integer.valueOf(lineArray[2]);
            productAmount = Integer.valueOf(lineArray[3]);
            minProductAmount = Integer.valueOf(lineArray[4]);

            if(price<0 || productAmount <0 || minProductAmount <0){
                return false;
            }
        }catch (Exception e){  }

        return true;

    }

    public boolean IDcheck(Vector<ProductRecord> data, String ID){
        for(int i = 0; i< data.size();i++){
            if(data.get(i).getProduct()[1].equals(ID)){
                return false;
            }
        }
        return true;
    }

    public boolean IDcheck(Vector<ProductRecord> data,String ID, int index){
        for(int i = 0; i< data.size();i++){
            if(index == i){
                continue;
            }
            if(data.get(i).getProduct()[1].equals(ID)){
                return false;
            }
        }
        return true;
    }



}
