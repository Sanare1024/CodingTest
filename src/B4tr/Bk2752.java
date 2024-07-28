package B4tr;

import java.util.Arrays;
import java.util.Scanner;

public class Bk2752 {//2230

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[3];

        for (int i = 0; i < 3; i++){//배열에 숫자 넣기
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr); // 배열 오름차순 정리

        for (int i = 0; i < 3; i++){//출력
            System.out.print(arr[i] + " ");
        }
    }
} //2233
