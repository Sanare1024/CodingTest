package B1tr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Bk2609__1 { //1631 다시 품 재귀 써서

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int r = gcb(a, b);

        System.out.println(r); //최대공약수
        System.out.println(a * b / r); // 최소공배수 = a * b / 최대공약수
    }

    public static int gcb(int a, int b){
        if(b == 0) { //b가 0 될때까지 재귀
            return a; // 0되면 최대공약수 a리턴
        }
        //gcb(a,b) -> gcb(b,r) 이때 r = a % b
        return gcb (b, a % b);
    }
} //1645
