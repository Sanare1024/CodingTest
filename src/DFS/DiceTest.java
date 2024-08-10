package DFS;

import java.util.Arrays;
import java.util.Scanner;

public class DiceTest {
	
	static int[] numbers;
	static int N;
	static boolean[] isSelected;
	static int totalcnt;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner sc= new Scanner(System.in);
			//StringTokenizer st = new StringTokenizer(str);
			N=sc.nextInt();
			numbers = new int[N];
			isSelected = new boolean[7];
			
			int M = sc.nextInt();
			
			switch (M) {
			case 1:
				dice1(0);
				break;
			case 2:
				dice2(0);
				break;
			case 3:
				dice3(0,1);
				break;
			case 4:
				dice4(0,1);
				break;
			default:
				break;
			}
			totalcnt = 0;
	}
	
	private static void dice1(int cnt) {
		if(cnt==N) {
			totalcnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = 1; i <= 6; i++) {//중복순열
			numbers[cnt]=i;
			dice1(cnt+1);
		}
	}
	
	private static void dice2(int cnt) { //순열
		if(cnt==N) {
			totalcnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = 1; i <= 6; i++) {
			if(isSelected[i]) continue;
			numbers[cnt]=i;
			isSelected[i]=true;
			dice2(cnt+1);
			isSelected[i]=false;
			//dice2(cnt+1);
			
		}
	}
	
	private static void dice3(int cnt, int start) {//중복조합
		if(cnt==N) {
			totalcnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int i = start; i <= 6; i++) {
			numbers[cnt]=i;
			dice3(cnt+1,i);//나 다음번에도 내자리부터 뽑아.
		}
	}
	
	private static void dice4(int cnt, int start) {//조합
		if(cnt==N) {
			totalcnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int i = start; i <= 6; i++) {
			numbers[cnt]=i;
			dice4(cnt+1,i+1);//나 다음 번에는 다른거 뽑아.
		}
	}
}
