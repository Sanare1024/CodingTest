package implementation;

import java.io.IOException;
import java.util.ArrayList;

public class Ckj_snail {

    static int[][] map;
    static int count, mapSize;
    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        int input[] = {3};
        mapSize = 1;
        list = new ArrayList<>();

        for(int i = 0; i < input.length; i++){
            list.add(input[i]);
            mapSize = mapSize * input[i];
        }
        count = 1;
        map = new int[mapSize][mapSize];

        setSnail(0, 0, list.size() - 1, mapSize, false);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    public static void setSnail(int y, int x, int index, int size, boolean isEnd){
        int num = list.get(index);
        //탈출조건
        if(isEnd){
            int r = y;
            int c = x;
            int total = num * num;
            int dir = 0;

            while(true){
                if(total == 0){ // 멈춰
                    return;
                }
                map[r][c] = count;
                count++;
                total--;
                int nr = r + dy[dir];
                int nc = c + dx[dir];
                int nDir = dir;

                if(nr < y || nc < x || nr >= y + num || nc >= x + num){ //달팽이 범위를 나가거나
                    nDir = (dir + 1) % 4;
                }
                else if(map[nr][nc] != 0){ //앞에 이미 적은거면 방향 꺽기
                    nDir = (dir + 1) % 4;
                }

                if(nDir == dir){//방향이 안꺽였으면
                    r = nr;
                    c = nc;
                } else { //방향 꺽임
                    r = r + dy[nDir];
                    c = c + dx[nDir];
                    dir = nDir;
                }
            }
        }

        int block = size / num;
        int r = y;
        int c = x;
        int total = num * num;
        int dir = 0;
        while(true){
            if (total == 0){
                break;
            }

            if(index == 0){
                setSnail(r, c, index , block , true);
                break;
            } else {
                setSnail(r, c, index - 1, block , false);
            }

            total--;

            int nr = r + block * dy[dir];
            int nc = c + block * dx[dir];
            int nDir = dir;

            if(nr < y || nc < x || nr >= y + block * num || nc >= x + block * num){ //범위를 나가거나
                nDir = (dir + 1) % 4;
            }
            else if(map[nr][nc] != 0){ //앞에 이미 적은거면 방향 꺽기
                nDir = (dir + 1) % 4;
            }

            if(nDir == dir){//방향이 안꺽였으면
                r = nr;
                c = nc;
            } else { //방향 꺽임
                r = r + block * dy[nDir];
                c = c + block * dx[nDir];
                dir = nDir;
            }
        }
    }

    static int[] dy = {0,1,0,-1};
    static int[] dx = {1,0,-1,0}; //우하좌상
}
