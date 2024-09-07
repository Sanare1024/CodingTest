package baekjoon.b3tr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bk11721 {//1456

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i));
            if ((i + 1) % 10 == 0) {//10번째마다 엔터 한번씩 (배열이니까 + 1)
                System.out.println();
            }
        }

    }
}//1508
