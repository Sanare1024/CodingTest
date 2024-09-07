package baekjoon.b4tr;

import java.util.Scanner;

public class Bk5543 { //2225

    public static void main(String[] args) {
        //버거 최소가격 + 음류수최소가격 - 50 = 최소셋트가격
        int buger = 2001; //가격은 2000이하여서
        int drink = 2001;
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++){//버거 3개가격 비교
            int temp = sc.nextInt();
            if(temp < buger) {
                buger = temp;
            }
        }

        for (int i = 0; i < 2; i++){//음료 2개가격 비교
            int temp = sc.nextInt();
            if(temp < drink) {
                drink = temp;
            }
        }

        System.out.println(buger + drink - 50);
    }
}//2229
