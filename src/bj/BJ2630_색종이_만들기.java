package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2630_색종이_만들기 {
    static int[][] array;
    static int totalOne;
    static int totalZero;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int N = Integer.parseInt(br.readLine());
        array = new int[N][N];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                array[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        recursive(N, 0, 0);
        System.out.println(totalZero);
        System.out.println(totalOne);
    }

    public static void recursive(int N, int R, int C) {
        int zero = 0;
        int one = 0;

        for (int r = R; r < N + R; r++) {
            for (int c = C; c < N + C; c++) {
                if (array[r][c] == 0) {
                    zero++;
                } else {
                    one++;
                }
            }
        }
        if (zero == 0) {
            totalOne++;
            return;
        }
        if (one == 0) {
            totalZero++;
            return;
        }

        recursive(N / 2, R, C);
        recursive(N / 2, R, C + N / 2);
        recursive(N / 2, R + N / 2, C);
        recursive(N / 2, R + N / 2, C + N / 2);

    }
}