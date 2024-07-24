package Bronze5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;


public class DNA {
    static int myArr[];  // int myArr[] 에서 위로뺌
    static int checkArr[];
    static int checkSecret; // 몇개가 비밀번호로 만족하는가

    public static void main(String[] args) throws IOException { //이것도 이해안감
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 상동 (Buffered는 String으로 반환)
        StringTokenizer st = new StringTokenizer(br.readLine()); // BufferedReader로 읽으면 stream 이라 나눠주는거

        int S = Integer.parseInt(st.nextToken()); //이거 뒤에 붙는거 이해안감
        int P = Integer.parseInt(st.nextToken()); //찾아보니 br로 받은 text를 int형으로 바꿔주는거
        int result = 0;
        checkArr = new int[4]; //슬라이딩 윈도우 셋팅1
        myArr = new int[4]; //상동2
        char A[] = new char[S];
        checkSecret = 0; // 몇개가 비밀번호로 만족하는가

        A = br.readLine().toCharArray(); //모르겠음
        st = new StringTokenizer(br.readLine()); // 모르겠음 말안해줌 (데이터받겠죠?)

        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            if (checkArr[i] == 0) { //checkArr[i] 가 0으로 들어왔다 = 조건1개를 만족한다
                checkSecret++;
            }
        }

        for (int i = 0; i < P; i++) { //부분문자열 처음 받을때 셋팅
            Add(A[i]);
        }

        if (checkSecret == 4) result++;

        //슬라이딩 윈도우
        for (int i = P; i < S; i++) {
            int j = i - P;
            Add(A[i]);
            Remove(A[j]); // 이동
            if (checkSecret == 4) result++;  // 이동할때마다 체크
        }

        System.out.println(result);
        br.close(); // 이것도 모르겠
    }

    private static void Remove(char c) {
        switch (c) {
            case'A' :
                if (myArr[0] == checkArr[0]) checkSecret--;
                myArr[0]--;
                break;
            case'C' :
                if (myArr[1] == checkArr[1]) checkSecret--;
                myArr[1]--;
                break;
            case'G' :
                if (myArr[2] == checkArr[2]) checkSecret--;
                myArr[2]--;
                break;
            case'T' :
                if (myArr[3] == checkArr[3]) checkSecret--;
                myArr[3]--;
                break;
        }
    }

    private static void Add(char c) {
        switch (c) {
            case'A' :
                myArr[0]++;
                if (myArr[0] == checkArr[0]) checkSecret++;
                break;
            case'C' :
                myArr[1]++;
                if (myArr[1] == checkArr[1]) checkSecret++;
                break;
            case'G' :
                myArr[2]++;
                if (myArr[2] == checkArr[2]) checkSecret++;
                break;
            case'T' :
                myArr[3]++;
                if (myArr[3] == checkArr[3]) checkSecret++;
                break;
        }
    }
}
