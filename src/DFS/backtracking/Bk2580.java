package DFS.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bk2580 {

    static int[][] sudoku = new int[9][9];
    static boolean solved;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        solved = false;

        for(int i = 0; i < 9; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++){
                sudoku[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solveSudoku(0, 0);
    }

    public static void solveSudoku(int y, int x){ //스도쿠 진행
        //탈출조건
        if(solved) return;
        //가로열 다 참(배열이니까 8이 끝)? 밑으로 한줄 내려서 다시 실행
        if(x == 9){
            solveSudoku(y + 1, 0);
            return;
        }
        //쭉쭉내려가서 y = 9에 도달하면끝 //결과 출력
        if(y == 9){
            solved = true;
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 9; i++){
                for (int j = 0; j < 9; j++) {
                    sb.append(sudoku[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
        }
        if(solved) return;
        //할일
        //입력받은 [y][x]위치가 0이면 조건 확인 후 숫자 넣기
        if(sudoku[y][x] == 0){
            for(int i = 1; i <= 9; i++){ // 1부터 9까지 조건확인
                if(possible(y, x, i)){//가능하다 나오면 i집어넣어
                    sudoku[y][x] = i;
                    solveSudoku(y, x + 1);//다음 가로칸 진행
                }
                //깨고나왔다? 다른 숫자 넣으면서 진행하다가 조건이 충족이 안되서 튕겨나온것
                // 그러니까 그칸 다시 0으로 바꾸고 다시해
                sudoku[y][x] = 0;
            }
        } else {// 숫자가 차있을때
            solveSudoku(y,x + 1);
        }
    }

    public static boolean possible(int y, int x, int num){ //가능한지 확인
        //가로줄에 겹치는 게 있는지
        for(int i = 0; i < 9; i++){
            if(sudoku[y][i] == num){ //같은게 있다면
                return false;
            }
        }
        //세로줄에 겹치는게 있는지
        for(int i = 0; i < 9; i++){
            if(sudoku[i][x] == num){
                return false;
            }
        }
        //3x3 박스에 같은게 있는지
        int boxY = y / 3 * 3;
        int boxX = x / 3 * 3;
        for(int i = boxY; i < boxY + 3; i++){
            for (int j = boxX; j < boxX + 3; j++){
                if(sudoku[i][j] == num){
                    return false;
                }
            }
        }
        return true; //위에 조건 다 뚫고 오면 가능
    }
}
