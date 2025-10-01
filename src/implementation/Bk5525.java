package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bk5525 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int count = 0;
        int ans = 0;

        for (int i = 1; i < m - 1; i++) {
            if (str.charAt(i) == 'O' && str.charAt(i+1) == 'I') {
                count++;
                if (count == n) {
                    if (str.charAt(i - (count * 2 - 1)) == 'I'){
                        ans++;
                    }
                    count--;
                }
                i += 2;
            } else {
                count = 0;
                i++;
            }
        }

        System.out.println(ans);
    }
}
