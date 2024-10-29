package marathon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bk16235 {

    static int n, m, k; //  땅넓이, 양분주는거 m개, k년 후에 겨로가
    static int[][] farm; //밭의 양분
    static int[][] manure; // 주는 양분
    static PriorityQueue<Tree> springtree; // 봄나무
    static Queue<Tree> summerTree; //봄에 죽은 나무->여름나무
    static Queue<Tree> fallTree; // 가을나무

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        farm = new int[n][n];
        manure = new int[n][n];
        springtree = new PriorityQueue<>();
        summerTree = new LinkedList<>();
        fallTree = new LinkedList<>();

        //양분 입력
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                manure[i][j] = Integer.parseInt(st.nextToken());
                farm[i][j] = 5;
            }
        }
        //나무 심기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int treeOld = Integer.parseInt(st.nextToken());

            springtree.add(new Tree(x, y, treeOld));
        }

        //k년 반복
        for (int i = 0; i < k; i++) {
            spring();
            summer();
            fall();
            winter();
        }

        System.out.println(springtree.size());
    }

    //봄 - 나무는 자기 나이만큼 양분을 먹고 -> 나이 + 1 / 한칸에 나무가 여러그루면 나이가 어린것부터 / 양분이 부족해서 못먹는 나무는 즉사
    //정렬했으니까 나이 신경x
    public static void spring() {
        while (!springtree.isEmpty()) {
            Tree cTree = springtree.poll();
            int x = cTree.x;
            int y = cTree.y;
            int age = cTree.age;

            if (farm[x][y] >= age) {
                farm[x][y] = farm[x][y] - age;
                age++;
                fallTree.add(new Tree(x, y, age));
            } else { // 양분이 모자르면 즉사
                summerTree.add(new Tree(x, y, age));
            }
        }
    }
    //여름 - 봄에 죽는 나무가 양분으로 변환 -> 죽은 나무의 나이 / 2 가 그칸에 양분에 +
    public static void summer() {
        while (!summerTree.isEmpty()) {
            Tree cTree = summerTree.poll();
            farm[cTree.x][cTree.y] += cTree.age / 2;
        }
    }
    //가을 - 번식 -> 나이가 5의배수인 나무만 번식 인접한칸 8개에 나이가 1인 나무가 생김
    public static void fall() {
        while (!fallTree.isEmpty()) {
            Tree cTree = fallTree.poll();

            if (cTree.age % 5 == 0) { // 번식
                for (int i = 0; i < 8; i++) {
                    int nx = cTree.x + dx[i];
                    int ny = cTree.y + dy[i];

                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue; //범위 벗어나가면 패스
                    springtree.add(new Tree(nx, ny, 1));
                }
            }
            //5배수아니면 그냥 넣어
            springtree.add(cTree);

        }
    }
    //겨울 - 로봇으로 양분추가 -> 각 칸에 추가되는 양분의 양 = A[r][c]
    public static void winter() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                farm[i][j] += manure[i][j];
            }
        }
    }

    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    static class Tree implements Comparable<Tree> {
        int x, y, age;

        public Tree(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }

        @Override
        public int compareTo(Tree o) { //나이순 정렬
            return this.age - o.age;
        }
    }


}
