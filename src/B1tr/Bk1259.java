package B1tr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bk1259 {// 1724

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {// 0 입력받을때 까지 루프
            String str = br.readLine();
            boolean pelin = true;

            if (str.equals("0")) { //0 입력하면 break
                break;
            }

            for (int i = 0; i < str.length() / 2; i++){ //끝까지 보지않고 절반 부분까지 보고 반대 절반이랑 비교하면 됨
                if(str.charAt(i) != str.charAt(str.length() - i - 1)) {
                    pelin = false;
                    break;
                }
            }

            if (pelin) {
                System.out.println("yes"); //pelin이 참이면
            } else {
                System.out.println("no"); // 그짓
            }
        }
    }
} //1735
