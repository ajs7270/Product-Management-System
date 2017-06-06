package DB;


import java.util.Vector;

public class test {

    public static void main(String[] args) {
        Vector<String> testVector = new Vector<String>();
        testVector.add("1");
        testVector.add("2");
        testVector.add("3");
        testVector.remove(1);

        System.out.println(testVector);

    }
}

