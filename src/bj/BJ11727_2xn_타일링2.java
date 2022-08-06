package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11727_2xn_타일링2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] save = new int[1001];
        save[1] = 1;
        save[2] = 3;
        for (int i = 3; i <= N; i++) {
            save[i] = (save[i - 1] + save[i - 2] * 2) % 10007;
        }
        System.out.println(save[N]);
    }
}