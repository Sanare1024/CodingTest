package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bk2164 {  //백준 2164 카드게임 (큐 형식 문제)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> deck = new LinkedList<>();
        int N = sc.nextInt();

        for (int i = 1; i <= N; i++) {  // 숫자가 1부터 N까지니까 i = 1부터
            deck.add(i);
        }

        while(deck.size() > 1){
            deck.poll();
            int a = deck.poll();
            deck.add(a);            // 위에 2줄을 합쳐서 deck.add(deck.poll); 해도 괜찮음
        }

        System.out.println(deck.poll());

    }
}

