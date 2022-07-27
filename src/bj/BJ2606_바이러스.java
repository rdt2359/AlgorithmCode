package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2606_바이러스 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Node>> list = new ArrayList<ArrayList<Node>>();
        for (int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            list.get(first).add(new Node(second));
            list.get(second).add(new Node(first));
        }


        Queue<Node> q = new LinkedList<>();
        q.add(new Node(1));
        boolean[] visited = new boolean[N+1];
        visited[1] = true;
        int cnt = 0;
        while(!q.isEmpty()){
            Node remove = q.remove();
            for(Node n : list.get(remove.value)){
                if(!visited[n.value]) {
                    visited[n.value] = true;
                    q.add(n);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    static class Node {
        int value;
        public Node(int value) {
            this.value = value;
        }
    }
}