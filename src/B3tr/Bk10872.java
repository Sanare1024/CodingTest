package B3tr;

import java.util.Scanner;

public class Bk10872 {//1027

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int temp = 1;

        for(int i = 1; i <= n; i++) {
            temp = temp * i;
        }
        System.out.println(temp);
    }
}//1029
