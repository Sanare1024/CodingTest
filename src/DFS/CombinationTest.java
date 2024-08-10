package DFS;

import java.util.Arrays;

public class CombinationTest {
	
	static int[] numbers;
	static int N=5, R=3;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		numbers=new int[R];
		
		combination(0, 1);
	}

	private static void combination(int cnt,int start) {
		if(cnt==R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i=start;i<=N;i++) {
			numbers[cnt]=i;
			combination(cnt+1,i+1);//현재 위치, 그리고 뽑을 위치.
		}
	}
}
