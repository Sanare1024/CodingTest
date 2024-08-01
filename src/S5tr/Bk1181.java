package S5tr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Bk1181 { //1541 일단 포기하고 색종이부터

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];

        for (int i = 0; i < n; i++){
            arr[i] = br.readLine();
        }

        //Array 하는곳
        //길이가 짧은 것부터
        //길이가 같으면 사전 순으로
        Arrays.sort(arr, new Comparator<String>() {
            public int compare(String str1, String str2) {
                if (str1.length() == str2.length()) {
                    return str1.compareTo(str2);
                } else {
                    return str1.length() - str2.length();
                }

            }
        });


        //출력

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n - 1; i++) {
            if(!arr[i].equals(arr[i + 1])) {
                sb.append(arr[i]).append('\n');
            }
        }

        sb.append(arr[n - 1]);

        System.out.println(sb);


    }
}
