package B3tr;

import java.util.Scanner;

public class Bk2884 {//2345

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int m = sc.nextInt();

        // 나누기랑 나머지로 표현하려 했으나 00시에서 23시로 바뀌는걸 표현하기 어려워서 if 문으로 방향 바꿈
        if(h !=0 && m < 45){
            h = h -1;
            m = 60 - (45 - m);

        } else if (h == 0 && m <45) {
            h = 23;
            m =  60 - (45 - m);
        } else {
            m = m - 45;
        }

        System.out.println(h + " " + m);
    }
}//2356
