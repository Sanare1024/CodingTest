package jungol;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class NaengJangGo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int arr[][] = new int[N][2];
        int range[]=new int[N];

        for (int i = 0; i < N; i++) {
            arr[i][0]=sc.nextInt();
            arr[i][1]=sc.nextInt();
        }

        Arrays.sort(arr, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {

                if(o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }

                return o1[1] - o2[1];
            }

        });

        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }

        int cnt=1;
        int refrigerator=arr[0][1];

        for (int i = 0; i < N; i++) {
            if(refrigerator < arr[i][0]) {
                refrigerator = arr[i][1];
                cnt++;
            }

        }
        System.out.println(cnt);
    }
}
