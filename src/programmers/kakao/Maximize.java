package programmers.kakao;

import java.util.ArrayList;

public class Maximize {
    static long answer;
    static char[] tool = {'+','-','*'};
    static boolean[] visited = new boolean[3];
    static ArrayList<Long> nums = new ArrayList<>();
    static ArrayList<Character> operator = new ArrayList<>();

    public static long solution(String expression) {
        //숫자랑 연산기호 분리
        //분리된걸로 우선순위 돌려가면서 조합해서 제일 큰값나오는거 확인
        answer = 0;
        visited = new boolean[3];
        nums = new ArrayList<>();
        operator = new ArrayList<>();

        String num = "";
        for (int i = 0; i < expression.length(); i++) {
            if ('0' <= expression.charAt(i) && expression.charAt(i) <= '9') { //숫자면
                num += expression.charAt(i);
            } else { // 연산기호 들어옴
                nums.add(Long.parseLong(num));
                num = "";
                operator.add(expression.charAt(i));
            }
        }
        nums.add(Long.parseLong(num)); //마지막 숫자 넣기

        dfs(0, new char[3]);

        return answer;
    }

    static void dfs(int index, char[] priority) {
        //탈출조건 - 3개 뽑혀서 우선순위 정해지면 정해진걸로 연산해서 answer 갱신
        if (index == 3) {
            //deepCopy
            ArrayList<Long> copyNums = new ArrayList<>(nums);
            ArrayList<Character> copyOper = new ArrayList<>(operator);

            for (int i = 0; i < priority.length; i++) { //우선순위
                for (int j = 0; j < copyOper.size(); j++) {
                    if (priority[i] == copyOper.get(j)) { //우선순위랑 같은 기호가 나오면 계산
                        Long result = calculate(copyNums.get(j), copyNums.get(j + 1), priority[i]);
                        copyNums.remove(j);
                        copyNums.remove(j);
                        copyOper.remove(j);
                        copyNums.add(j, result);
                        j--;
                    }
                }
            }

            answer = Math.max(answer, Math.abs(copyNums.get(0)));
            return;
        }

        //반복 - 연산기호 우선순위 조합 만들기
        for (int i = 0; i < 3; i ++) {
            if (!visited[i]) {
                visited[i] = true;
                priority[index] = tool[i];
                dfs(index + 1, priority);
                visited[i] = false;
            }
        }
    }

    private static Long calculate(Long long1, Long long2, char c) {
        long res = 0;

        switch (c) {
            case '+' : res = long1 + long2; break;
            case '-' : res = long1 - long2; break;
            case '*' : res = long1 * long2; break;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(solution("100-200*300-500+20"));
        System.out.println(solution("50*6-3*2"));
    }
}
