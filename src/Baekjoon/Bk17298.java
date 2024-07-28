package Baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class Bk17298 {

    public static void main(String[] args) { //오큰수
        //A[i]의 오큰수 = A[i] 오른쪽에 있으면서 A[i]보다 큰 수 중에 가장 왼쪽에 있는수 (조건에 맞는 수가 없으면 값은 -1)
        Scanner sc = new Scanner(System.in);
        Stack<Integer> st = new Stack<Integer>();

        int N = sc.nextInt();
        int[] data = new int[N]; //N 크기의 행렬 받아서 넣어둘곳

        for (int i = 0; i < N; i++) { // N 숫자들 받아넣기
            data[i] = sc.nextInt();
        }

        // A[i]보다 큰수중에 가장 왼쪽에 있는 수 = 오큰수 이기때문에
        // 조건 1. A[i] 보다 큼 2. A[i]보다 오른쪽에 있음(A[i]보다 나중에 나온 수) -> 3. 후보군중에 가장 왼쪽(가장 먼저 나온값)
        //
        for (int i = 0; i < N; i++) {
            while(!st.isEmpty() && data[st.peek()] < data[i]) { //
                data[st.pop()] = data[i];
            }
            st.push(i);
        }

        while(!st.isEmpty()) {
            data[st.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            sb.append(data[i]);
            sb.append(" ");
        }
        System.out.println(sb);
    }
}
