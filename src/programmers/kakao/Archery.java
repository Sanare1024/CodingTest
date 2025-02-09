package programmers.kakao;

public class Archery {
    int[] res = new int[11];//점수차가 최대일때 라이언이 쏜 화살배열
    int[] lion = {-1};//정답배열
    int max = Integer.MIN_VALUE;//최대값

    public int[] solution(int n, int[] info) {
        back(0, n, info);//라이언이 쏜 화살에 대한 조합

        if (max == -1) {//라이언이 어피치를 못 이길떄
            lion = new int[1];
            lion[0] = -1;
        }
        return lion;
    }

    public void back(int depth, int n, int[] info) {
        //화살 다 꽂았을때(종료조건)
        if (depth == n) {
            int diff = score(info);//점수차 구하기
            if (max <= diff) {//점수차 최대값 갱신
                max2= diff;
                lion = res.clone();
            }
            return;
        }

        //res[i]<=info[i] -> i과녁에 라이언이 화살을 더 많이 맞추면 반복문 종료한다.
        for (int i = 0; i < info.length && res[i] <= info[i]; i++) {
            res[i] += 1;
            back(depth + 1, n, info);
            res[i] -= 1;
        }
    }

    //점수차 구하기
    public int score(int[] info) {
        int apeach = 0, lion = 0;
        for (int i = 0; i < res.length; i++) {
            if (info[i] == 0 && res[i] == 0) continue;//i원소에 둘다 0개 맞췄을땐 무시.
            if (info[i] >= res[i]) apeach += (10 - i);
            else lion += (10 - i);
        }

        int diff = lion - apeach;
        if (diff <= 0) return -1;
        return diff;
    }

    //===========================================================//
    int max2, ans[], apeach[];

    void find(int n, int cur) {
        int score = 0, state[] = new int[11];
        for (int i = 1; i <= 10; i++) {
            if ((cur & 1 << i) > 0) {
                n -= state[10 - i] = apeach[10 - i] + 1;
                if (n < 0) return;
                score += i;
            } else if (apeach[10 - i] > 0) score -= i;
        }
        if (score <= 0) return;
        state[10] = n;
        if (max2 < score) {
            max2 = score;
            ans = state;
        } else if (max2 == score) {
            for (int i = 10; i >= 0; i--) {
                if (ans[i] != state[i]) {
                    if (state[i] > ans[i])
                        ans = state;
                    return;
                }
            }
        }
    }

    int[] solution2(int n, int[] info) {
        apeach = info;
        for (int i = 1; i < 1 << 11; i++)
            if (Integer.bitCount(i) <= n)
                find(n, i);

        return max2 == 0 ? new int[]{-1} : ans;
    }
}
