package dfs;

import java.util.Arrays;

public class CombinationTest {

	static int[] numbers;
	static int N=4, R=4;
	static boolean[] test;
	static int K;

	public static void main(String[] args) {//{1,2,3,4} ->
		// TODO Auto-generated method stub
		numbers=new int[R];
		test = new boolean[3];
		for (int i = 0; i <= R; i++) {
			K = i;
			combination(0, 1);
		}
	}

	private static void combination(int cnt,int start) {//순서상관없이 뽑기만.
		if(cnt==K) {
			System.out.println(Arrays.toString(numbers));
			return;
		}

		for(int i=start;i<=N;i++) {
			numbers[cnt]=i;
			combination(cnt+1,i+1);//현재 위치, 그리고 뽑을 위치.
		}
	}


	private static void combination2(int cnt) {//순서상관없이 뽑기만.
		if(cnt==R) {
			System.out.println(Arrays.toString(test));
			return;
		}

		test[cnt] = true;
		combination2(cnt+1);//현재 위치, 그리고 뽑을 위치.

		test[cnt] = false;
		combination2(cnt+1);
	}
}

