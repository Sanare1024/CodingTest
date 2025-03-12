package goldRun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Bk16637 {
    public static int n;
    public static ArrayList<Integer> number;
    public static ArrayList<Character> cal;
    public static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        char[] input = br.readLine().toCharArray();

        number = new ArrayList<>();
        cal = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (input[i] == '*' || input[i] == '+' || input[i] == '-') {
                cal.add(input[i]);
            } else {
                number.add(input[i] - '0');
            }
        }

        dfs(number.get(0), 0);


        System.out.println(ans);
    }

    public static void dfs(int result, int idx) {
        //탈출조건
        if (idx == cal.size()) {
            ans = Math.max(ans, result);
            return;
        }
        //반복
        // 괄호를 안치는 경우
        dfs(cal(result, number.get(idx + 1), cal.get(idx)), idx + 1);

        // 괄호를 치는 경우
        if (idx + 2 <= cal.size()) {
            dfs(cal(result, cal(number.get(idx + 1), number.get(idx + 2), cal.get(idx + 1)), cal.get(idx)), idx + 2);

        }
    }


    public static int cal(int a, int b, char cal_str) {
        if (cal_str == '*') {
            return a * b;
        } else if (cal_str == '-') {
            return a - b;
        } else {
            return a + b;
        }
    }
}
