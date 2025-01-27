package programmers.kakao;

import java.util.*;

public class Tuple {
    public static int[] solution(String s) {
        s = s.substring(2, s.length() - 2);
        s = s.replace("},{", "/");
        String[] arr = s.split("/");

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        List<Integer> list = new ArrayList<>();
        for (String str : arr) {
            String[] numList = str.split(",");
            for (String num : numList) {
                int number = Integer.parseInt(num);

                if (list.contains(number)) continue;
                list.add(number);
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }


        for (int a : answer) {
            System.out.print(a + " ");
        }
        System.out.println();

        return answer;
    }

    public static void main(String[] args) {
        solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
        solution("{{1,2,3},{2,1},{1,2,4,3},{2}}");
        solution("{{20,111},{111}}");
        solution("{{123}}");
        solution("{{4,2,3},{3},{2,3,4,1},{2,3}}");
    }
}
