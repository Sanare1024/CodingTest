package B1tr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bk1032 { //1007

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] str = new String[n];//n개의 파일 이름 받을곳

        for (int i = 0; i < n; i++) {
            str[i] = br.readLine();
        }

        StringBuilder sb = new StringBuilder();
        //파일 이름의 길이는 모두 같고 길이는 최대 50이다. 파일이름은 알파벳 소문자와 '.' 로만 이루어져 있다.
        for (int i = 0; i < str[0].length(); i++) {
            boolean check = true;

            for (int j = 1; j < str.length; j++) {
                if(str[0].charAt(i) != str[j].charAt(i)) { //
                    check = false;
                    break;
                }
            }

            if(check){
                sb.append(str[0].charAt(i));
            } else {
                sb.append("?");
            }

        }

        System.out.println(sb);

    }
}//1030
