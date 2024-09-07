package baekjoon.s5tr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Bk11650 { //1441 - 1500까지 허리아파서 잠시 쉬다옴
    // 1500 - 1514까지 설명을 읽었으나 상당부분 이해안감

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2]; //x y 받을려고

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); //x 좌표를 받은 것
            arr[i][1] = Integer.parseInt(st.nextToken()); //y 좌표를 받은 것
        }


        System.out.println(arr[0][2]);
        /* arr

        // arr[1][0][1]
         ((0,1),(0,1)), ((0,1),(0,1)),
         ((3,4),(3,4)), ((3,4),(3,4)), //arr[3][2] -> 범위에 없는거니까 에러 ArrayIndexOutOfBoundsException

        */

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] e1, int[] e2) { // return된 결과가 음수인지 양수인지 0인지에 따라서 비교
                if(e1[0] == e2[0]) {//x가 같을경우	// 첫번째 원소가 같다면 두 번째 원소끼리 비교
                    return e1[1] - e2[1]; //y끼리 비교
                }
                else {
                    return e1[0] - e2[0]; //x 가 같지 않으니까 x끼리 비교
                }
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i][0] + " " + arr[i][1]).append('\n');
        }
        System.out.println(sb);

        //역방향? x가 클수록 앞에다가 둬  y도 마찬가지


    }
} //1524 따라 쓰긴했음 //1533 다시봐도 어렵;;
