package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ11286_절대값_힙 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        PriorityQueue<Long> plus = new PriorityQueue<>();
        PriorityQueue<Long> minus = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            long value = Long.parseLong(br.readLine());
            if (value > 0) {
                plus.add(value);
            } else if (value < 0) {
                minus.add(value);
            } else {
                if (plus.peek() == null && minus.peek() == null) {
                    sb.append(0).append("\n");
                } else if (plus.peek() == null) {
                    sb.append(minus.remove()).append("\n");
                } else if (minus.peek() == null) {
                    sb.append(plus.remove()).append("\n");
                } else if (plus.peek() < Math.abs(minus.peek())) {
                    sb.append(plus.remove()).append("\n");
                } else {
                    sb.append(minus.remove()).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}