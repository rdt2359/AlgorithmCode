package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class BJ15663_N과_M_9 {
    static int N;
    static int M;
    static int[] input;
    static int[] nums;
    static boolean[] save;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        LinkedHashSet<String> set = new LinkedHashSet<>();
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        input = new int[N];
        nums = new int[M];

        st = new StringTokenizer(br.readLine());
        save = new boolean[N];
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(input);
        recursive(0, set);
        for (String s : set) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }

    public static void recursive(int cnt, LinkedHashSet<String> set) {
        if (cnt == M) {
            String s = "";
            for (int i : nums) {
                s = s + i + " ";
            }
            set.add(s);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!save[i]) {
                save[i] = true;

                nums[cnt] = input[i];
                recursive(cnt + 1, set);
                save[i] = false;
            }
        }
    }
}