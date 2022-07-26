package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1931_회의실_배정 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Meeting[] meetings = new Meeting[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            meetings[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(meetings);

        int end = 0;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (meetings[i].start >= end) {
                end = meetings[i].end;
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    static class Meeting implements Comparable<Meeting> {
        int start;
        int end;

        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            if (this.end != o.end) {
                return this.end - o.end;
            }
            return this.start - o.start;
        }
    }
}