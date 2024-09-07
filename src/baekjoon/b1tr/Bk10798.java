package baekjoon.b1tr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bk10798 {//1737

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] board = new char[5][15]; //5줄 최대 15글자 단어

        int longword = 0; //제일 긴 단어 확인

        for(int i = 0; i < 5; i++){
            String word = br.readLine();

            if (longword < word.length()) { //제일 긴단어 넣기
                longword = word.length();
            }
            for (int j = 0; j < word.length(); j++) { //글자 까진 넣었음..
                board[i][j] = word.charAt(j);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < longword; i++){//세로로 읽으니까 반대로
            for(int j = 0; j < 5; j++) {
                if(board[j][i] == '\0') continue; //널값이면 현재단계 스킵
                sb.append(board[j][i]);
            }
        }
        System.out.println(sb);
    }
} //1759 세탁소
