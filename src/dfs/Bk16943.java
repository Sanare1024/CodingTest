package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bk16943 {

    public static String a;
    public static int b;
    public static int c;
    public static boolean[] select;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = st.nextToken();
        b = Integer.parseInt(st.nextToken());

        select = new boolean[a.length()];
        c = -1; // 최대값 넣을곳 조건 성립 안할때 -1 출력해야하니
        permu(0, "");

        System.out.println(c);
    }

    public static void permu(int count, String str){
        if(count == a.length()){ //다 뽑았을때
            int num = Integer.parseInt(str);

            //조건 0으로 시작하면 안됨 && B보다 작아야함 그중에 최댓값
            if(str.charAt(0) != '0' && num < b){
                c = Math.max(c, num);
            }
            return;
        }

        //할일 조합뽑기
        for(int i = 0; i < a.length(); i++){ //
            if(select[i]) continue; // 뽑은거면 스킵

            select[i] = true;
            permu(count + 1, str + a.charAt(i));
            select[i] = false;
        }
    }
}
