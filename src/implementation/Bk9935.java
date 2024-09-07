package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bk9935 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        String bomb = br.readLine();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < word.length(); i++){ //한글자씩 잘라 넣으면서 bomb이랑 비교
            sb.append(word.charAt(i));

            if(sb.length() >= bomb.length()){ //넣기 시작한게 붐이랑 같아지면 비교시작
                boolean same = true;

                for(int j = 0; j < bomb.length(); j++){// 글자 1개씩 넣으면서 비교하기 때문에 맨뒤부터 bomb길이까지만 비교하면됨
                    if(sb.charAt((sb.length() - bomb.length() + j)) != bomb.charAt(j)){
                        same = false;
                        break; //하나라도 틀리면 브렠
                    }
                }

                if(same){ //만약에 같음 판정이 났다.
                    sb.delete(sb.length() - bomb.length(), sb.length()); //맨뒤에 같은부분 잘라내
                }
            }
        }
        //남은 문자 or FRULA

        if(sb.length() == 0){//다 터져서 없음?
            System.out.println("FRULA");
        } else { //남음
            System.out.println(sb);
        }
    }
}
