package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ9375_패션왕_신해빈 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                String val1 = st.nextToken();
                String val2 = st.nextToken();
                if (!map.containsKey(val2)) {
                    map.put(val2, 0);
                }
                map.put(val2, map.get(val2) + 1);
            }
            int answer = 1;
            for (int v : map.values()) {
                answer *= (v + 1);
            }
            sb.append(answer - 1).append("\n");
        }
        System.out.println(sb);
    }
}