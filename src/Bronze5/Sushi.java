package Bronze5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sushi {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] sushi = new int[N]; //초밥 개수
        int[] Eat = new int[d + 1]; //먹은 초밥 종류

        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;

        for (int i = 0; i < k; i++) { //맨처음 k개 집었을때
            if (Eat[sushi[i]] == 0) {
                count++;
            }
            Eat[sushi[i]]++;
        }

        int result = count; //처음에 k개 선택했을때 결과넣기

        //여기부터 슬라이딩
        for (int i = 0; i < N; i++) {
            if (result <= count) {
                if (Eat[c] == 0) { // 만약 먹은것중에 쿠폰이 없으면
                    result = count + 1; //1카운트 해주고
                } else {
                    result = count; //아니면 고대로
                }
            }

            if (Eat[sushi[i]] == 1) {
                count = count - 1;
            }
            Eat[sushi[i]]--;

            if (Eat[sushi[(i + k) % N]] == 0) {
                count = count + 1;
            }

            Eat[sushi[(i + k) % N]]++;
            
        }

        System.out.println(result);

    }
}
