package dfs;

import java.util.ArrayList;
import java.util.Scanner;

public class Bk15686 {

    static int n, m;
    static int[][] map;
    static boolean[] choose;
    static ArrayList<Node> house;
    static ArrayList<Node> chicken;
    static int answer;

    public static void main(String[] args) {
        //nxn  (r,c)
        //0은 빈 칸, 1은 집, 2는 치킨집
        // |r1-r2| + |c1-c2|

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        house = new ArrayList<>();
        chicken = new ArrayList<>();
        map = new int[n][n];

        for(int i = 0; i < n; i++){
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
                if(map[i][j] == 1) {
                    house.add(new Node(i, j)); //집 좌표
                } else if (map[i][j] == 2) {
                    chicken.add(new Node(i, j)); //치킨집 좌표
                }
            }
        }

        answer = Integer.MAX_VALUE; //최소값비교를 위한 최대값설정

        choose = new boolean[chicken.size()]; //치킨집만큼 불린 배열

        dfs(0,0);
        System.out.println(answer);

    }

    public static void dfs(int count, int start) {
        if(count == m) { // m만큼 골랐으면

            int cityresult = 0; //도시의 치킨거리 ( 각 집의 모든 치킨집과의 최소거리를 합쳐놓은 총합)

            for(int i = 0; i < house.size(); i++){ //집만큼 반복
                int temp = Integer.MAX_VALUE; //최소값 찾기위한

                for(int j = 0; j < chicken.size(); j++){ //모든 치킨집과의 거리를 비교해서 최솟값 찾기
                    if(choose[j]) {
                        int distance = Math.abs(house.get(i).x - chicken.get(j).x) + Math.abs(house.get(i).y - chicken.get(j).y);

                        temp = Math.min(temp, distance); // 최소값 찾아
                    }
                }
                cityresult = cityresult + temp;
            }

            answer = Math.min(answer, cityresult); //도시의 치킨거리 비교해서 최소값 answer에 넣기

        }

        for(int i = start; i < chicken.size(); i++){ // 치킨집중에 m개 골라
            choose[i] = true; //골라
            dfs(count + 1,i + 1);
            choose[i] = false; //풀어
        }
    }

    static class Node{ //int y
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
