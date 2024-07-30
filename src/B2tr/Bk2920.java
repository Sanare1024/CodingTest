package B2tr;

import java.util.Scanner;

public class Bk2920 {//1039

    public static void main(String[] args) {
        //1부터 8까지 숫자가 한 번씩 등장한다.
        // 1~8 = ascending, 8 ~ 1 descending, else =  mixed

        Scanner sc = new Scanner(System.in);
        int[] arr = new int[8];

        for(int i = 0; i < 8; i++) {
            arr[i] = sc.nextInt();
        }

        String answer = ""; //답 저장
        for(int i = 0; i < 7; i++) {
            if(arr[i + 1] == arr[i] + 1){ //1씩 증가 이면
                answer = "ascending";
            } else if (arr[i + 1] == arr[i] - 1) { //1씩 감소이면
                answer = "descending";
            } else {
                answer = "mixed";
                break;
            }
        }

        System.out.println(answer);
    }
} //1051
