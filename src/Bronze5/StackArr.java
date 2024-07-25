package Bronze5;

import java.util.Scanner;
import java.util.Stack;

public class StackArr {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A[] = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        //스택 구조 생성
        Stack<Integer> stack = new Stack<>();

        int num = 1;
        boolean result = false;
        StringBuffer br = new StringBuffer();

        // 수열 탐색
        for (int i = 0; i < A.length; i++) {
            int arr = A[i]; //배열값 가져오기

            if (arr >= num) {
                while (arr >= num) {
                    stack.push(num++);
                    br.append("+\n");
                }
                stack.pop();
                br.append("+\n");
            } else {
                int n = stack.pop();
                if (n > arr) {
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    br.append("-\n");
                }
            }
        }

        if (result) {
            System.out.println(br.toString());
        }

    }
}
