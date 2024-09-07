package baekjoon;

public class exRecur {

    static int sum = 0;

    public static void main(String[] args) {
        //재귀란 -> 내(메소드)가 나(메소드)를 호출하는 것.

//        int sum = 0;
//        for (int i = 1; i <= 10; i++) {
//            sum  += i;
//        }
        recur(1);
        System.out.println(sum);
    }

    public static void recur(int i){
        if(i == 11) return;
        sum += i;
        i += 1;
        recur(i);
    }
}