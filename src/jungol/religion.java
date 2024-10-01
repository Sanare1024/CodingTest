package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class religion {

    static int N,M;
    static int[] set;

    public static void makeSet() {

        for (int i = 0; i <= N; i++) {
            set[i]=i;
        }
    }

    public static int findSet(int a) {

        if(set[a]==a) return a;

        return set[a]=findSet(set[a]);

    }

    public static boolean unionSet(int a, int b) {
        int aRoot=findSet(a);
        int bRoot=findSet(b);
        if(aRoot==bRoot) return false;
        set[bRoot]=aRoot;
        return true;

    }

    public static void main(String[] args) throws IOException, IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine()," ");
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        set=new int[N+1];

        makeSet();
        int cnt=0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine()," ");
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            unionSet(a,b);
        }

        for (int i = 1; i <= N; i++) {
            if(i==set[i])
                cnt++;
        }
        System.out.println(cnt);
    }
}
