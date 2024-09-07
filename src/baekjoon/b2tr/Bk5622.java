package baekjoon.b2tr;

import java.util.Scanner;

public class Bk5622 { //0902

    public static void main(String[] args) {
        //ABC 3, DEF 4, GHI 5, JKL6, MNO7, PQRS8, TUV9,WXYZ10 총합계
        // switch로 charAt 찍어서 대응하는거 시간 정하고 total에 더하기
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int total = 0;

        for (int i = 0; i < str.length(); i++) {

            switch(str.charAt(i)) {

                case 'A' :
                case 'B' :
                case 'C' :
                    total = total + 3;
                    break;

                case 'D' :
                case 'E' :
                case 'F' :
                    total = total + 4;
                    break;

                case 'G' :
                case 'H' :
                case 'I' :
                    total = total + 5;
                    break;

                case 'J' :
                case 'K' :
                case 'L' :
                    total = total + 6;
                    break;

                case 'M' :
                case 'N' :
                case 'O' :
                    total = total + 7;
                    break;

                case 'P' :
                case 'Q' :
                case 'R' :
                case 'S' :
                    total = total + 8;
                    break;

                case 'T' :
                case 'U' :
                case 'V' :
                    total = total + 9;
                    break;

                case 'W' :
                case 'X' :
                case 'Y' :
                case 'Z' :
                    total = total + 10;
                    break;

            }

        }

        System.out.println(total);
    }

} //0918
