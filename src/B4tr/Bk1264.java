package B4tr;

import java.util.Scanner;

public class Bk1264 {//2314

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) { //# 받을때까지 무한정 돌아가게
            String Sentence = sc.nextLine();
            int count = 0;

            if (Sentence.equals("#")) { //# 받으면 멈추게
                break;
            }

            for (int i = 0; i < Sentence.length(); i++){ //아까 charAt 은 아스키코드라고 했고 char a = 'a' 하면 아스키코드값이 나왔으니 이렇게 비교할수 있겠다 싶었음
                char a = Sentence.charAt(i);
                if(a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u' || a == 'A' || a == 'E' || a == 'I' || a == 'O' || a == 'U') {
                    count++;
                }
            }
            System.out.println(count);

        }
    }
}//2330
