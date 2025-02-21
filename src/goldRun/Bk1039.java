package goldRun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bk1039 { // 교환 // bfs

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] visited = new int[1000001];

        String str = String.valueOf(N);
        int length = str.length();
        int answer = 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(str);
        while (!queue.isEmpty() && K > 0) {
            int size = queue.size();
            for (int t = 0; t < size; t++) {
                String temp = queue.poll();
                for (int i = 0; i < length - 1; i++) {
                    for (int j = i + 1; j < length; j++) {
                        char[] charArr = temp.toCharArray();
                        char charTemp = charArr[i];
                        charArr[i] = charArr[j];
                        charArr[j] = charTemp;
                        String numStr = new String(charArr);
                        int number = Integer.parseInt(numStr);
                        if ((numStr.charAt(0) != '0') && visited[number] != K) {
                            queue.add(numStr);
                            visited[number] = K;
                        }
                    }
                }
            }
            K--;
        }


        if (queue.isEmpty())
            System.out.println(-1);
        else {
            for (String num : queue) {
                answer = Math.max(Integer.parseInt(num), answer);
            }
            System.out.println(answer);
        }
    }
}
