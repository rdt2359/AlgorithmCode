package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ5430_AC {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        first:
        for (int t = 0; t < T; t++) {
            String[] input = br.readLine().split("");
            int N = Integer.parseInt(br.readLine());
            int[] array = new int[N];
            String s = br.readLine();
            s = s.replace("[", "");
            s = s.replace("]", "");
            s = s.replace(",", " ");
            st = new StringTokenizer(s);
            for (int i = 0; i < N; i++) {
                array[i] = Integer.parseInt(st.nextToken());
            }
            int start = 0;
            int end = N - 1;
            boolean isReverse = false;
            for (String val : input) {
                if (val.equals("R")) {
                    isReverse = !isReverse;
                } else {
                    if (start > end) {
                        sb.append("error").append("\n");
                        continue first;
                    } else {
                        if (isReverse) {
                            end = end - 1;
                        } else {
                            start = start + 1;
                        }
                    }
                }
            }

            sb.append("[");
            if (isReverse) {
                for (int i = end; i >= start; i--) {
                    sb.append(array[i]);
                    if (i != start) {
                        sb.append(",");
                    }
                }
            } else {
                for (int i = start; i <= end; i++) {
                    sb.append(array[i]);
                    if (i != end) {
                        sb.append(",");
                    }
                }
            }
            sb.append("]").append("\n");
        }
        System.out.println(sb);
    }

}