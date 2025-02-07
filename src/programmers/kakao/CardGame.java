package programmers.kakao;

import java.util.*;

public class CardGame {
    //1. 카드뭉치에서 n / 3 만큼 카드 뽑음
    //2. 라운드 시작 -> 2장 뽑음(뽑을 카드 없으면 게임 종료) / 뽑을때 카드 1장당 코인1개 or 동전 안쓰고 버리기 선택
    //3. 카드에 적힌 숫자 합 = n + 1되도록 카드 2장 내면 다음라운드 / 2번 반복 / 못내면 게임 종료
    //갈 수 있는 최대 라운드 수 구하기

    int n, myCoin;
    boolean[] used; //사용한거
    boolean canNext = true;

    public int solution(int coin, int[] cards) {
        n = cards.length;
        List<Integer> hand = new ArrayList<>();
        used = new boolean[n];
        myCoin = coin;

        for (int i = 0; i < n / 3; i++) {
            hand.add(cards[i]);
        }

        int round = 1;
        for (int i = n / 3; i < n; i += 2) {
            //[2]
            hand.add(cards[i]);
            hand.add(cards[i + 1]);

            playRound(hand, n + 1, cards);

            if (myCoin < 0 || !canNext) { //코인을 못내거나
                return round;
            }

            round++;
        }

        return round;
    }

     void playRound(List<Integer> hand, int sumCard, int[] cards) {
        //들고 있는것만으로 n + 1 만들 수 있는지
        for (int i = 0; i < n / 3; i++) {
            for (int j = i + 1; j < n / 3; j++) {
                if (hand.get(i) + hand.get(j) == sumCard && !used[i] && !used[j]) {
                    used[i] = true;
                    used[j] = true;
                    return;
                }
            }
        }
        //들고 있는 걸로 안될 때 뽑은 거 포함해서 n + 1되면 그거 하고 코인 지출
        for (int i = 0; i < hand.size() - 1; i++) {
            for (int j = i + 1; j < hand.size(); j++) {
                if (hand.get(i) + hand.get(j) == sumCard && !used[i] && !used[j]) {
                    used[i] = true;
                    used[j] = true;
                    if (i >= cards.length / 3) {
                        myCoin--;
                    }
                    if (j >= cards.length / 3) {
                        myCoin--;
                    }
                    return;
                }
            }
        }

        //다 안되면 다음 라운드 못감
        canNext = false;
    }
}
