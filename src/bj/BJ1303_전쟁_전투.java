package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1303_전쟁_전투 {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[][] array = new String[M][N];
        for (int i = 0; i < M; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                array[i][j] = s[j];
            }
        }

        int W = 0;
        int B = 0;

        boolean[][] hasVisited = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!hasVisited[i][j]) {
                    hasVisited[i][j] = true;
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    int cnt = 1;
                    String val = array[i][j];
                    while (!q.isEmpty()) {
                        int[] remove = q.remove();
                        for (int k = 0; k < 4; k++) {
                            int nextR = remove[0] + dr[k];
                            int nextC = remove[1] + dc[k];

                            if (0 <= nextR && nextR < M && 0 <= nextC && nextC < N &&
                                    array[nextR][nextC].equals(val) && !hasVisited[nextR][nextC]) {
                                cnt++;
                                hasVisited[nextR][nextC] = true;
                                q.add(new int[]{nextR, nextC});
                            }
                        }
                    }
                    if (val.equals("B")) {
                        B += cnt * cnt;
                    } else {
                        W += cnt * cnt;
                    }
                }
            }
        }
        System.out.println(W + " " + B);
    }
}