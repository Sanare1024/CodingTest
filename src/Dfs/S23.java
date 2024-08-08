package Dfs;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;

public class S23 {

    public static void main(String[] args) {


        ArrayList<Integer> arr = new ArrayList();  //배열의 진화판
        arr.add(9);
        arr.add(4);
        arr.add(12312);
        arr.add(312);
        arr.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });


        System.out.println(arr.get(3));
    }
}
