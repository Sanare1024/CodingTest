package Bronze5;

import java.util.Scanner;

public class Maximum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N[] = new int[9];
        int max = 0; // 최대값을 찾고
        int lable = 0; //몇 번째인지 넣을곳


        for (int i = 0; i < N.length; i++) {
            N[i] = sc.nextInt();
            if (N[i] > max) {
                max = N[i];
                lable = i+1;
            }
        }

        for (int numbering : N) {
            N[numbering] = sc.nextInt();
            if (max < N[numbering]) {
                max = N[numbering];
                lable = (numbering + 1);
            }
        }

        System.out.println(max);
        System.out.println(lable);

    }
}
