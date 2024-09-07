package dfs;

import java.util.Arrays;

public class PermutationTest {
	
	static int[] num= {1,2,3};
	static int N = 3;
	static boolean[] isSelected;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		num=new int[N];
		isSelected=new boolean[N+1];
		
		permutation(0);
	}
	
	static void permutation(int cnt) {
		if(cnt==N) {//기저조건
			System.out.println(Arrays.toString(num));//결과
			return;
		}
		
		for (int i = 1; i <= N; i++) {// i: 시도하는 숫자.
			if(isSelected[i]) continue; //사용중이면 다음으로 가라.중복 허락하지 x
			
			num[cnt]=i;//뽑은거 넣는다.
			isSelected[i] = true;//뽑았다.
			
			permutation(cnt+1);			
			//i를 선택하고 나올 수 있는 모든 상태가 생성됨.
			
			isSelected[i] = false; //i=3 풀어주고 -> 2를 풀어줘
		}
	}
}
