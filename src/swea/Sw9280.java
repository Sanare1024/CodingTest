package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sw9280 {
    //첫 번째 줄에 자연수  n 과  m 이 주어진다. (1 ≤ n  ≤ 100, 1 ≤ m  ≤ 2000)
    //n 개의 줄에 i 번째 주차 공간의 단위 무게당 요금 Ri 가 정수로 주어진다. (1 ≤ Ri  ≤ 100)
    //m 개의 줄에 차량 i 의 무게 Wi 가 정수로 주어진다. 차량번호 i 와 차량의 도착 순서는 아무런 관계가 없다. (1 ≤ Wi  ≤ 10000)
    //이후  2m 개의 줄에 차량들의 주차장 출입 순서가 하나의 정수  x 로 주어진다.
    //주어진 정수 x 가 양수면, x 번 차가 주차장에 들어옴을 뜻한다.
    //x 가 음수면, -x 번 차가 주차장을 나감을 뜻한다.
    static int n, m, ans;
    static int[] R, W, parkSpot;
    static Queue<Integer> carMove; //차 이동순서
    static Queue<Integer> waitCar; //기다리는 차 순서

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            ans = 0;

            R = new int[n + 1]; //i번째 주차장의 무게당 요금
            W = new int[m + 1]; //차량 i의 차량 무게(i랑 도착순서랑 상관없음)
            parkSpot = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                R[i] = Integer.parseInt(br.readLine());
            }
            for (int i = 1; i <= m; i++) {
                W[i] = Integer.parseInt(br.readLine());
            }


            carMove = new LinkedList<>();
            waitCar = new LinkedList<>();
            for (int i = 0; i < 2 * m; i++) { //m만큼 들어가고 나가니까 2배
                carMove.add(Integer.parseInt(br.readLine()));
            }

            parking();

            System.out.println("#" + t + " " + ans);
        }
    }

    //1. 비어있는 주차 공간이 있는지 검사한다.
    //  1-1. 비어있는 공간이 없다면, 빈 공간이 생길 때까지 차량을 입구에서 기다리게 한다.
    //  1-2. 빈 주차 공간이 있으면 진용이는 곧바로 주차를 시키며, 주차 가능한 공간 중 번호가 가장 작은 주차 공간에 주차하도록 한다.
    //2. 만약 주차를 기다리는 차량이 여러 대라면, 입구의 대기장소에서 자기 차례를 기다려야 한다. 운전자들은 예의가 바르기 때문에 새치기를 하지 않는다.

    static void parking() {
        int nowMove = 0; //차 이동 받는곳
        int waitFront = 0; // 대기 제일 앞에 차

        while (!carMove.isEmpty()) {
            nowMove = carMove.poll();
            if (nowMove > 0) { // 차 들어가는 명령
                waitCar.add(nowMove); //일단 대기장소에 넣어놓고
                waitFront = waitCar.peek(); //맨앞에 있는 차 확인
                for (int i = 1; i <= n; i++){
                    if (parkSpot[i] == 0) { //비었으면
                        parkSpot[i] = waitFront; //주차
                        ans += R[i] * W[waitFront]; // 정산
                        waitCar.poll(); //뽑아
                        break;
                    }
                }

            } else { // 차 빠지는 명령
                nowMove = nowMove * -1;
                for (int i = 1; i <= n; i++) {
                    if (parkSpot[i] == nowMove){ //차 찾아
                        parkSpot[i] = 0; // 차 빼
                        //빼고나면 빈자리 나니까 기다리는차 넣기
                        if (!waitCar.isEmpty()){
                            nowMove = waitCar.poll();
                            parkSpot[i] = nowMove; //주차
                            ans += R[i] * W[nowMove]; //정산
                            break;
                        }
                    }
                }
            }

        }
    }
}
