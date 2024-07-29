package B2tr;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Bk1152 { //2156

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        StringTokenizer st = new StringTokenizer(str," ");
        System.out.println(st.countTokens());
    }
} //2201 StringTokenizer 들어가서 찾아봄
