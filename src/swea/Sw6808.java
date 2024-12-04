package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sw6808 {
    static int winCount, loseCount;
    static int[] gyu; //규영 카드순서
    static int[] in; //인영 카드순서
    static int[] notGyu; //규영이 카드가 아닌거(인영이 카드)
    static boolean[] selectedCard;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            winCount = 0;
            loseCount = 0;
            gyu = new int[9];
            in = new int[9];
            notGyu = new int[9];
            selectedCard = new boolean[9]; //조합할때 쓸 배열

            boolean[] totalCard = new boolean[18]; //전체카드
            for (int i = 0; i < 9; i++) {
                gyu[i] = Integer.parseInt(st.nextToken()); //규카드 순서는 고정이니까 바로 순서배열에 넣
                totalCard[gyu[i] - 1] = true; //들어간 숫자 체크
            }

            int index = 0;
            for (int i = 0; i < 18; i++) {
                if (totalCard[i]) continue;

                notGyu[index] = i + 1; // 안 들어간 카드 notGyu에 넣고 이걸로 조합해서 in[]에 저장해서 순서정하기
                index++;
            }

            lineUpCard(0);

            System.out.println("#" + t + " " + winCount + " " + loseCount);
        }
    }

    private static void lineUpCard(int count) {
        //조건
        if (count == 9) { //9장 뽑으면 게임 시작
            playGame();
        }
        //반복(조합)
        for (int i = 0; i < 9 ; i++){
            if (selectedCard[i]) continue; //뽑은거 패스

            selectedCard[i] = true; //뽑
            in[count] = notGyu[i]; // 순서에 넣
            lineUpCard(count + 1);
            //in[count] = 0; 안빼줘도 덮어씌워져서 상관없
            selectedCard[i] = false; //얜 풀어주기
        }
    }

    private static void playGame() {
        int gyuWin = 0;
        int inWin = 0;

        for (int i = 0; i < 9; i++) {
            if (gyu[i] > in[i]){ //규 승
                gyuWin += (gyu[i] + in[i]);
            } else { // 인 승
                inWin += (gyu[i] + in[i]);
            }
        }

        if (gyuWin > inWin) {
            winCount++;
        } else {
            loseCount++;
        }
    }
}
