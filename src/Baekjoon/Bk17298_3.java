package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Bk17298_3 {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int nge[] = new int[N];

        for (int i = 0; i < N; i++) {
            nge[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> res = new Stack<Integer>();
        Stack<Integer> temp = new Stack<Integer>();

        for (int i = N-1; i >= 0; i--) {

            int right = nge[i];
            //4 3 5 2 7
            while(!temp.isEmpty() && right >= temp.peek()) {
                temp.pop();
            }

            if(temp.isEmpty()) {
                res.add(-1);
            } else {
                res.add(temp.peek());//맨 왼쪽 가장큰수
            } //res [-1 7 7 5 5] 거꾸로하면 정답

            temp.add(right);
            //temp [7 5 4] 1 2 3 4
        }


        StringBuilder sb = new StringBuilder();

        while(!res.isEmpty()) {
            sb.append(res.pop()+" ");
        }

        System.out.println(sb);

    }

}
