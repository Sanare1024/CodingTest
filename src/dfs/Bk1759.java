package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bk1759 {
    //조합인데 증가하는방향
    //문자 받고 > 정렬 > 조합 > 조건 (최소 한 개의 모음+최소 두 개의 자음으로 구성) 해서 확인
    public static int L, C;
    public static char[] letter; //처음에 받을곳
    public static char[] comb; // 조합 만들어서 넣을곳

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        letter = new char[C];
        comb = new char[L];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++){
            letter[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(letter);

        dfs(0,0);
    }

    public static void dfs(int count,int start){
        //탈출조건
        if(count == L){ //L개 뽑았을때 조건확인
            //임시확인 출력
            //System.out.println(comb);
            //조건확인 메소드
            if(jogun()){
                System.out.println(comb);
            }
            return;
        }
        //할일 순서x 뽑아서 comb에 넣어
        for(int i = start; i < C; i++){
            comb[count] = letter[i];
            dfs(count + 1, i + 1);
        }
    }

    public static boolean jogun(){
        int ja = 0; //자음
        int mo = 0; //모음
        for(int i = 0; i < L; i++){ //comb의 length만큼
            if(comb[i] == 'a' || comb[i] == 'e' || comb[i] == 'i' ||comb[i] == 'o' ||comb[i] == 'u'){//모음일경우
                mo++;
            } else {
                ja++;
            }
        }
        if (mo >= 1 && ja >= 2){
            return true;
        }
        return false;
    }
}
