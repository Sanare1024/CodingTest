package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bk14891 {//1930

    //방향이 1인 경우는 시계 방향이고, -1인 경우는 반시계 방향
    //1번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 1점
    //2번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 2점
    //3번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 4점
    //4번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 8점
    static int[][] gear;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        gear = new int[4][8];

        for (int i = 0; i < 4; i++){
            String temp = br.readLine();
            for(int j = 0; j < 8; j++){
                gear[i][j] = temp.charAt(j) - '0';
            }
        }
        int k = Integer.parseInt(br.readLine());

        for(int i = 0; i < k; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1;//번호
            int dir = Integer.parseInt(st.nextToken());//방향
            //받은 번호랑 방향 -> 해당 번호 기어 좌우 체크  ->  양옆 돌아가기(연쇄 반응) - > 마지막에 가운데 돌리기
            startgear(num, dir);
        }

        System.out.println(totalscore());

    }

    public static void startgear(int num, int dir){
        leftgear(num - 1, -dir); //회전하면 맞물리니까 dir * -1
        rightgear(num + 1, -dir);
        //좌우 다돌아가고 마지막에 가운데 롤
        gearsRoll(num, dir);
    }

    public static void leftgear(int num, int dir){
        if(num < 0) return; // 기어 벗어나면 스킵
        //왼쪽기어(2)번의 시선이니까 num+1기어의 6번이랑 비교
        if(gear[num][2] == gear[num + 1][6]) return; //같은극이면 스킵
        leftgear(num - 1, -dir); //위에 조건 아니면 돌아가는거니까 왼쪽확인
        gearsRoll(num,dir); //다 확인하고 돌리기
    }

    public static void rightgear(int num, int dir){
        if(num > 3) return; // 기어 벗어나면 스킵
        //오른쪽기어(6)번의 시선이니까 num-1기어의 2번이랑 비교
        if(gear[num][6] == gear[num - 1][2]) return; //같은극이면 스킵
        rightgear(num + 1, -dir); //위에 조건 아니면 돌아가는거니까 오른쪽확인
        gearsRoll(num,dir); //다 확인하고 돌리기
    }

    public static void gearsRoll(int num, int dir){ //기어 자체 회전
        if(dir == 1){//시계
            int temp = gear[num][7];
            for(int i = 7; i > 0; i--){
                gear[num][i] = gear[num][i - 1];
            }
            gear[num][0] = temp;
        } else if(dir == -1){ //반시계
            int temp = gear[num][0];
            for(int i = 0; i <7; i++){
                gear[num][i] = gear[num][i + 1];
            }
            gear[num][7] = temp;
        }
    }

    public static int totalscore(){
        int total = 0;
        int score = 1;
        for(int i = 0; i < 4; i++){
            if(gear[i][0] == 1){
                total += score;
            }
            score *= 2;
        }
        return total;
    }
}
