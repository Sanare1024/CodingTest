package B2tr;

import java.util.Scanner;

public class Bk10809 { //2202

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        int[] alpha = new int[26];

        for (int i = 0; i < 26; i++) { //전부 -1넣기
            alpha[i] = -1;
        }

        for (int i = 0; i < word.length(); i++) {
            int a  = word.charAt(i) - 97;
            if (alpha[a] == -1) { // 처음 등장한 위치니까 뒤에 등장했을때 작동안해야함
                alpha[a] = i ;
            }
        }

        for(int i = 0; i < 26; i ++) {
            System.out.print(alpha[i] + " ");
        }

    }
} //2213
