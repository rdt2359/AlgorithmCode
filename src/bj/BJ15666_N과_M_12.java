package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class BJ15666_N과_M_12 {
    static int N;
    static int M;
    static int[] input;
    static LinkedHashSet<String> set = new LinkedHashSet<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        input = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(input);
        recursive(0,0,"");
        StringBuilder sb = new StringBuilder();
        for(String s: set){
            sb.append(s).append("\n");
        }
        System.out.println(sb);

    }

    public static void recursive(int cnt, int index, String save) {
        if (cnt == M) {
            set.add(save);
            return;
        }
        for (int i = index; i < N; i++) {
            recursive(cnt + 1, i, save + input[i] + " ");
            recursive(cnt, i + 1, save);
        }
    }

}