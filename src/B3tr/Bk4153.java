package B3tr;

import java.util.Arrays;
import java.util.Scanner;

public class Bk4153 { //1409 직각삼각형

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[3];

        while(true) { //000 입력까지 반복
            for (int i = 0; i < 3; i++){
                a[i] = sc.nextInt();
            }

            if(a[0] == 0 && a[1] == 0 && a[2] == 0){ ///000 입력하면 종료
                break;
            }

            Arrays.sort(a); //오름차순 정리

            if(a[0] * a[0] + a[1] * a[1] == a[2] * a[2]) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }
    }
}//1417
