package recursion;

import java.io.*;

public class Bk2447 {

    static int n;
    static String star[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        star = new String[n][n];
        setStar(0, 0, n, false);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                sb.append(star[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    public static void setStar(int y, int x, int n, boolean isBlank){
        //탈출조건
        if(isBlank){//boolean이 true로 넘어왔으면 공백찍고 더이상 안돌아봐도됨
            for(int i = y; i < y + n; i++){
                for (int j = x; j < x + n; j++){
                    star[i][j] = " ";
                }
            }
            return;//공백찍고 재귀 끝
        }
        if(n == 1){ //쪼개고 쪼개고 쪼개다 마지막 1까지 갔을때 마지막으로 * 찍기
            star[y][x] = "*";
            return;
        }
        //재귀 할일
        //n일때 한블럭은 n/3 1칸당 카운트해서 5되면 boolean을 바꿔서 재귀
        int block = n / 3;
        int count = 0;
        for(int i = y; i < y + n; i += block){//시작 위치, 블럭 사이즈로 건너뛰면서
            for (int j = x; j < x + n; j += block){
                count++;// -번째 블럭
                if(count != 5){ //5번째 블럭이 아닐때(구멍이 안뚫렸을때 boolean그대로 재귀)
                    setStar(i, j, block, false);//각 블럭의 시작 위치로 들어가서 재귀
                } else { //count = 5일때
                    setStar(i, j, block, true); //불린바꿔서 재귀
                }
            }
        }
    }
}
