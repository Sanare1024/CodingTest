package jungol;

import java.util.Scanner;

public class middleValue {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //int T=sc.nextInt();
        for(int test_case=1;test_case<=1;test_case++) {
            //System.out.println("#"+test_case+" ");
            int N=sc.nextInt();
            int[] arr=new int[101];

            for (int i = 0; i < N; i++) {
                arr[sc.nextInt()]++;
            }
            int max=0;
            int index=0;
            for (int i = 0; i < N; i++) {
                max+=arr[i];//빈도를 더해서
                if(max> N/2) {//중앙넘는 순간
                    index=i;
                    break;
                }
            }
            System.out.println(index);
        }
    }
}
