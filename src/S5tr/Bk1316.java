package S5tr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bk1316 { //1610

    public static void main(String[] args) throws IOException {
        //모든 글자가 연속해서 나타나면 그룹 단어이지만, aabbbccb 는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다.
        // 단어는 알파벳 소문자로만 되어있고 중복되지 않으며, 길이는 최대 100

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 0; i < n; i++) {
            String word = br.readLine();

            int[] alpha = new int[26];  //나왔는지 안나왔는지 체크용

            int compare = 0;
            for(int j = 0; j < word.length(); j++) {
                int now = word.charAt(j);

                if(compare != now) { //전문자와 다른게 나왔을때
                    if(alpha[now - 97] == 0) { //아예 처음 나왔을떄
                        alpha[now - 97]++;
                        compare = now;   //이걸로 중복문자 나오면 검사x

                    } else { //전문자와 다르게 나왔지만 alpha[]자리에 0이 아니므로 나왔던 문자가 다시나왔온것 = 그룹단어x
                        count++;
                        break;
                    }
                }
            }
        }

        System.out.println(n - count);

    }
} //1702 수정의 연속이였다
