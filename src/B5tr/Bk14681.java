package B5tr;

import java.util.Scanner;

public class Bk14681 { //1510

    public static void main(String[] args) {
        //x y 입력
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        //x y로 사분면 확인 후 번호출력
        if (x > 0 && y > 0){
            System.out.println("1");
        } else if (x < 0 && y > 0) {
            System.out.println("2");
        } else if (x < 0 && y < 0) {
            System.out.println("3");
        } else if (x > 0 && y < 0) {
            System.out.println("4");
        }
    }
} //1513
