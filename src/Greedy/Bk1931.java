package Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Bk1931 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Meeting[] arr = new Meeting[n];

        for(int i = 0; i < n; i++){
            arr[i] = new Meeting(sc.nextInt(), sc.nextInt());
        }

        /*//Array 하는곳
        //길이가 짧은 것부터, 길이가 같으면 사전 순으로
        Arrays.sort(arr, new Comparator<String>() {
            public int compare(String str1, String str2) {
                if (str1.length() == str2.length()) {
                    return str1.compareTo(str2);
                } else {
                    return str1.length() - str2.length();
                }
            }
        });*/

        Arrays.sort(arr, new Comparator<Meeting>() { //종료시간 순서로 정렬
            @Override
            public int compare(Meeting o1, Meeting o2) {
                if(o1.end == o2.end){ // 놓친 부분 종료시간이 같았을 때 시작시간이 빠른것 순서대로 정렬
                    return o1.start - o2.start;
                }
                return o1.end - o2.end;
            }
        });

        int count = 0;
        int lastEndTime = 0;

        for(int i = 0; i < n; i++){
            if(arr[i].start >= lastEndTime) { //지금 회의의 시작시간이 직전회의의 끝난시간이랑 동일하거나 크면 가능
                count++; //조건 맞으니까 계획표에 때려넣어
                lastEndTime = arr[i].end; // 넣은 회의기준으로 마지막 회의시간 바꿔
            }
        }

        System.out.println(count);
    }

    static class Meeting{
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
