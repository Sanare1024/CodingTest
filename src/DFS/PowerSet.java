package DFS;

import java.util.Arrays;

public class PowerSet {

    static int[] numbers;
    static int N=4, R=4;
    static boolean[] test;
    static int K;

    public static void main(String[] args) {//{1,2,3,4} ->
        // TODO Auto-generated method stub
        numbers=new int[R];
        test = new boolean[R];
        powerSet(0);
    }
    private static void powerSet(int cnt) {//순서상관없이 뽑기만.
        if(cnt==R) {
            System.out.println(Arrays.toString(test));
            return;
        }

        test[cnt] = false;
        powerSet(cnt+1);

        test[cnt] = true;
        powerSet(cnt+1);//현재 위치, 그리고 뽑을 위치.
    }
}