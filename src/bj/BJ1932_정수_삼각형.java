package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1932_정수_삼각형 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] array = new int[N][N];
        int[][] save = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        save[0][0] = array[0][0];
        for (int i = 1; i < N; i++) {
            save[i][0] = save[i - 1][0] + array[i][0];
            save[i][i] = save[i - 1][i - 1] + array[i][i];
            for (int j = 1; j < i; j++) {
                save[i][j] = Math.max(save[i - 1][j - 1], save[i - 1][j]) + array[i][j];
            }
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (max < save[N - 1][i]) {
                max = save[N - 1][i];
            }
        }
        System.out.println(max);
    }
}