package AlgorithmCT;


import java.util.Scanner;

public class Bk1427 {// 선택정렬 알고리즘 직접 해보기

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        int[] arr = new int[str.length()];  //배열로 넣어줌

        for (int i = 0; i < str.length(); i++) { //입력받기
            arr[i] = Integer.parseInt(str.substring(i, i + 1));
        }

        for (int i = 0; i < str.length(); i++) { //선택 정렬, 내림차순이니까 Max값 서치 후 기준이 되는 자리와 swap
            int max = i; // 최대값을 넣을 자리/ 앞에서부터

            for(int j = i + 1; j < str.length(); j++){ //최대값 탐색
                if( arr[j] > arr[max]) {
                    max = j;
                }
            }

            if (arr[i] < arr[max]) { // 큰수 기준 정렬
                int temp = arr[i];
                arr[i] = arr[max];
                arr[max] = temp;
            }
        }

        for(int i = 0; i < str.length(); i++){
            System.out.print(arr[i]);
        }
    }
}
