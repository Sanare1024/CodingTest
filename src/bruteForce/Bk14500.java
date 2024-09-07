package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bk14500 {

    static int n, m;
    static int[][] map;
    static int max = Integer.MIN_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        type1_1();
        type1_2();
        type2();
        type3_1();
        type3_2();
        type3_3();
        type3_4();
        type3_5();
        type3_6();
        type3_7();
        type3_8();
        type4_1();
        type4_2();
        type4_3();
        type4_4();
        type5_1();
        type5_2();
        type5_3();
        type5_4();

        System.out.println(max);
    }
    // 1: 일직선
    // 2: 네모
    // 3: ㄴ 자
    // 4: ㄱㄴ 자
    // 5: ㅗ 자
    public static void type1_1(){ //1 - 누은거
        for(int i = 0; i < n - 3; i++){
            for(int j = 0; j < m; j++){
                int sum = map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i + 3][j];
                max = Math.max(sum, max);
            }
        }
    }
    public static void type1_2(){ // 1- 세운거
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m - 3; j++){
                int sum = map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i][j + 3];
                max = Math.max(sum, max);
            }
        }
    }
    public static void type2(){ //네모는 하나
        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < m - 1; j++){
                int sum = map[i][j] + map[i + 1][j] + map[i][j + 1] + map[i + 1][j + 1];
                max = Math.max(sum, max);
            }
        }
    }
    public static void type3_1(){
        for(int i = 0; i < n - 2; i++){
            for(int j = 0; j < m - 1; j++){
                int sum = map[i][j] + map[i][j + 1] + map[i + 1][j + 1] + map[i + 2][j + 1];
                max = Math.max(sum, max);
            }
        }
    }
    public static void type3_2(){
        for(int i = 0; i < n - 2; i++){
            for(int j = 0; j < m - 1; j++){
                int sum = map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i + 2][j + 1];
                max = Math.max(sum, max);
            }
        }
    }
    public static void type3_3(){
        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < m - 2; j++){
                int sum = map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i + 1][j + 2];
                max = Math.max(sum, max);
            }
        }
    }
    public static void type3_4(){
        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < m - 2; j++){
                int sum = map[i][j] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 1][j + 2];
                max = Math.max(sum, max);
            }
        }
    }
    public static void type3_5(){
        for(int i = 0; i < n - 2; i++){
            for(int j = 0; j < m - 1; j++){
                int sum = map[i][j] + map[i][j + 1] + map[i + 1][j] + map[i + 2][j];
                max = Math.max(sum, max);
            }
        }
    }
    public static void type3_6(){
        for(int i = 0; i < n - 2; i++){
            for(int j = 0; j < m - 1; j++){
                int sum = map[i][j + 1] + map[i + 1][j + 1] + map[i + 2][j + 1] + map[i + 2][j];
                max = Math.max(sum, max);
            }
        }
    }
    public static void type3_7(){
        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < m - 2; j++){
                int sum = map[i + 1][j] + map[i + 1][j + 1] + map[i + 1][j + 2] + map[i][j + 2];
                max = Math.max(sum, max);
            }
        }
    }
    public static void type3_8(){
        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < m - 2; j++){
                int sum = map[i][j] + map[i + 1][j] + map[i][j + 1] + map[i][j + 2];
                max = Math.max(sum, max);
            }
        }
    }
    public static void type4_1(){
        for(int i = 0; i < n - 2; i++){
            for(int j = 0; j < m - 1; j++){
                int sum = map[i][j] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 2][j + 1];
                max = Math.max(sum, max);
            }
        }
    }
    public static void type4_2(){
        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < m - 2; j++){
                int sum = map[i + 1][j] + map[i + 1][j + 1] + map[i][j + 1] + map[i][j + 2];
                max = Math.max(sum, max);
            }
        }
    }
    public static void type4_3(){
        for(int i = 0; i < n - 2; i++){
            for(int j = 0; j < m - 1; j++){
                int sum = map[i][j + 1] + map[i + 1][j + 1] + map[i + 1][j] + map[i + 2][j];
                max = Math.max(sum, max);
            }
        }
    }
    public static void type4_4(){
        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < m - 2; j++){
                int sum = map[i][j] + map[i][j + 1] + map[i + 1][j + 1] + map[i + 1][j + 2];
                max = Math.max(sum, max);
            }
        }
    }
    public static void type5_1(){
        for(int i = 0; i < n - 2; i++){
            for(int j = 0; j < m - 1; j++){
                int sum = map[i + 1][j] + map[i][j + 1] + map[i + 1][j + 1] + map[i + 2][j + 1];
                max = Math.max(sum, max);
            }
        }
    }
    public static void type5_2(){
        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < m - 2; j++){
                int sum = map[i][j] + map[i][j + 1] + map[i + 1][j + 1] + map[i][j + 2];
                max = Math.max(sum, max);
            }
        }
    }
    public static void type5_3(){
        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < m - 2; j++){
                int sum = map[i + 1][j] + map[i + 1][j + 1] + map[i][j + 1] + map[i + 1][j + 2];
                max = Math.max(sum, max);
            }
        }
    }
    public static void type5_4(){
        for(int i = 0; i < n - 2; i++){
            for(int j = 0; j < m - 1; j++){
                int sum = map[i][j] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 2][j];
                max = Math.max(sum, max);
            }
        }
    }


}
