package B2tr;

public class Bk15596 {//0942

    //Java: long sum(int[] a); (클래스 이름: Test)
    //a: 합을 구해야 하는 정수 n개가 저장되어 있는 배열 (0 ≤ a[i] ≤ 1,000,000, 1 ≤ n ≤ 3,000,000)
    //리턴값: a에 포함되어 있는 정수 n개의 합

    long sum (int[] a) {
        long sum = 0;
        for (int i = 0; i < a.length; i++){ //n 값은 안정해져 있으니 범위를 a.length 로
            sum += a[i];
        }
        return sum;
    }
} //0948
