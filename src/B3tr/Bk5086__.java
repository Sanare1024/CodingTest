package B3tr;

import java.util.Scanner;

public class Bk5086__ {//1510

    public static void main(String[] args) {
        //0 0 입력까지 무한반복,  (두 수가 같은 경우는 없)
        // 첫 번째 숫자가 두 번째 숫자의 약수라면 factor, 배수라면 multiple, 둘 다 아니라면 neither

        Scanner sc = new Scanner(System.in);
        while(true) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (a == 0 && b == 0) { //끝 설정
                break;
            }

            if (a < b && b % a == 0) { // && 는 앞에 조건 먼저보고 틀리면 뒤로 넘겨버림
                System.out.println("factor");
            } else if (a > b && a % b == 0 ) {
                System.out.println("multiple");
            } else {
                System.out.println("neither");
            }
        }

    }
} //1516
