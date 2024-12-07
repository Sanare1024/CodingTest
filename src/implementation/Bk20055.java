package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bk20055 {

    static int n, k, count;
    static int[] conveyor;
    static boolean[] onRobot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        conveyor = new int[2 * n]; //컨베이어 체력
        onRobot = new boolean[n]; // 위쪽 컨베이어에 로봇이 있는지 확인하는 배열

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * n; i++) {
            conveyor[i] = Integer.parseInt(st.nextToken());
        }

        operation();

        System.out.println(count);
    }
    //진행순서
    // 1. 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
    // 2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히 있는다.
    //    2-1. 로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다.
    // 3. 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
    // 종료 조건 : 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다.
    static void operation() {
        count = 0;
        while (endingOption()) {// 종료조건까지 무한 반복
            //[1]
            int tempt = conveyor[conveyor.length - 1]; //마지막에 있는거 0으로 가져와야함
            for (int i = conveyor.length - 1; i > 0; i--) { //한칸씩 땡겨
                conveyor[i] = conveyor[i - 1];
            }
            conveyor[0] = tempt;

            for (int i = onRobot.length - 1; i > 0; i--) { //로봇도 옮기기
                onRobot[i] = onRobot[i - 1];
            }
            //땡겼으니 내려야하는곳 로봇 없애고 올리는곳도 비어있음
            onRobot[n - 1] = false;
            onRobot[0] = false;

            //[2]
            for (int i = onRobot.length - 1; i > 0; i--) { //앞로봇부터 한칸씩 앞으로 보내면서 컨베이어 체력깍기
                if (!onRobot[i - 1]) continue; //옮겨야하는 로봇 없으면 스킵
                if (onRobot[i]) continue; // 옮길칸에 로봇 있으면 스킵
                if (conveyor[i] < 1) continue; //옮길칸 체력이 1이상이 아니면 스킵
                //다 맞으면 옮기기
                onRobot[i] = true; //옮길칸
                onRobot[i - 1] = false; // 있던칸
                conveyor[i]--; //옮길칸 체력 줄이기
            }

            //[3]
            if (conveyor[0] > 0) {
                onRobot[0] = true;
                conveyor[0]--; //로봇 올리고 체력 줄이기
            }

            count++; //과정 끝 단계 +1
        }
    }

    static boolean endingOption(){
        int check = 0;
        for (int i = 0; i < 2 * n; i++) {
            if (conveyor[i] == 0) { // 체력 0인 컨베이너 체크
                check++;
            }

            if (check >= k) return false; //k개면 종료
        }
        return true;
    }
}
