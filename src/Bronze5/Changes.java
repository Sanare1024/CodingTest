package Bronze5;

import java.util.Scanner;

public class Changes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int C = sc.nextInt();

            int quarter = C / 25;
            C %= 25; // 이거 연산자 따로 있지 않나

            int dim = C / 10;
            C %= 10;

            int nickel = C / 5;
            C %= 5;

            int penny = C;

            System.out.println(quarter + " " + dim + " " + nickel + " " + penny); //공백 이거말고 넣는방법 없나?
            /*StringBuilder sb = new StringBuilder();
            sb.append(quarter).append(" ").append(dim).append(" ").append(nickel).append(" ").append(penny);*/
        }
    }
}
