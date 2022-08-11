package bj;

import java.io.*;
import java.util.StringTokenizer;

public class BJ1890_점프 {
    static int N;
    static int[][] map;
    static long[][] dp;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new long[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(DFS(0, 0));
    }

    public static long DFS(int x, int y) {
        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        if (x == N - 1 && y == N - 1) {
            return 1;
        }

        dp[x][y] = 0;

        int dx = x + map[x][y];
        int dy = y + map[x][y];

        if (dx >= N && dy >= N) {
            return 0;
        }

        if (dx < N) {
            dp[x][y] = Math.max(dp[x][y], dp[x][y] + DFS(x + map[x][y], y));
        }

        if (dy < N) {
            dp[x][y] = Math.max(dp[x][y], dp[x][y] + DFS(x, y + map[x][y]));
        }

        return dp[x][y];
    }

}