package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bk14890 {

    static int n, l;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        for(int i = 0; i < n; i++){
            if(isRowPossible(i)) {
                count++;
            }
            if(isColumnPossible(i)){
                count++;
            }
        }
        System.out.println(count);
    }
    //경사로를 놓을 수 없는곳 (이 조건만 다 치면 된다는 뜻)
    //낮은 칸과 높은 칸의 높이 차이가 1이 아닌 경우
    //낮은 지점의 칸의 높이가 모두 같지 않거나, L개가 연속되지 않은 경우
    //경사로를 놓다가 범위를 벗어나는 경우

    public static boolean isRowPossible(int row){
        boolean[] isInstalled = new boolean[n]; //경사로가 이미 놓였는지 확인

        for(int i = 0; i < n - 1; i++){
            int distance = map[row][i] - map[row][i + 1];// 입력받은 행에서 이어진 2개의 높이 차이

            if(distance > 1 || distance < -1){ //낮은 칸과 높은 칸의 높이 차이가 1이 아닌 경우
                return false;
            } else if (distance == 1) { // 한칸 낮아진 경우
                for(int j = 1; j <= l; j ++){ // 다음블럭부터 L개만큼 연속되는지 확인(경사로가 설치 되는지 확인)
                    if(i + j >= n) return false; //i+j가 범위를 넘어가면 false;
                    if(isInstalled[i + j]) return false; // i부터 j까지 이미 경사로 있으면 false;
                    if(map[row][i] - 1 != map[row][i + j]) return false; //낮아진거니까 앞으로 L개 만큼 되는지 확인
                    //위에 조건 다 뚫고 왔으면 경사로 설치해도 됨
                    isInstalled[i + j] = true;
                }
            } else if(distance == -1){ //한칸 높아진 경우
                for (int j = 0; j < l; j++) { // 본인부터 뒤로 L개만큼 연속되는지 확인
                    if(i - j < 0) return false; // i - j가 범위 넘어가면 false;
                    if(isInstalled[i - j]) return false; // i부터 j까지 이미 경사로 있으면 false;
                    if (map[row][i] != map[row][i - j]) return false; //높아진거니까 뒤로 L개 만큼 되는지 확인
                    //위에 조건 다 뚫고 왔으면 경사로 설치해도 됨
                    isInstalled[i - j] = true;
                }
            }
        }
        return true;
    }
    public static boolean isColumnPossible(int column){
        boolean[] isInstalled = new boolean[n]; //경사로가 이미 놓였는지 확인

        for(int i = 0; i < n - 1; i++){
            int distance = map[i][column] - map[i + 1][column];// 입력받은 열에서 이어진 2개의 높이 차이

            if(distance > 1 || distance < -1){ //낮은 칸과 높은 칸의 높이 차이가 1이 아닌 경우
                return false;
            } else if (distance == 1) { // 한칸 낮아진 경우
                for(int j = 1; j <= l; j ++){ //다음블럭부터 L개만큼 연속되는지 확인(경사로가 설치 되는지 확인)
                    if(i + j >= n) return false; //i+j가 범위를 넘어가면 false;
                    if(isInstalled[i + j]) return false; // i부터 j까지 이미 경사로 있으면 false;
                    if(map[i][column] - 1 != map[i + j][column]) return false; //낮아진거니까 앞으로 L개 만큼 되는지 확인
                    //위에 조건 다 뚫고 왔으면 경사로 설치해도 됨
                    isInstalled[i + j] = true;
                }
            } else if(distance == -1){ //한칸 높아진 경우
                for (int j = 0; j < l; j++) { // 본인부터 뒤로 L개만큼 연속되는지 확인
                    if(i - j < 0) return false; // i - j가 범위 넘어가면 false;
                    if(isInstalled[i - j]) return false; // i부터 j까지 이미 경사로 있으면 false;
                    if(map[i][column] != map[i - j][column]) return false; //높아진거니까 뒤로 L개 만큼 되는지 확인
                    //위에 조건 다 뚫고 왔으면 경사로 설치해도 됨
                    isInstalled[i - j] = true;
                }
            }
        }

        return true;
    }
}
