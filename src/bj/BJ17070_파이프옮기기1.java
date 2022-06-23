package bj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/17070
public class BJ17070_파이프옮기기1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] inputArray = new int[N][N];
		int[][] pipeSave = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				inputArray[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Queue<Pipe> queue = new LinkedList<>();
		queue.add(new Pipe(0, 1, 0));
		pipeSave[0][1]++;
		while (!queue.isEmpty()) {
			Pipe pipe = queue.remove();
			int shape = pipe.shape;
			int r = pipe.r;
			int c = pipe.c;
			// 0:- 1:\ 2:|
			if (shape == 0 || shape == 1) { // -처리
				if (c + 1 < N && inputArray[r][c + 1] != 1) {
					queue.add(new Pipe(r, c + 1, 0));
					pipeSave[r][c + 1]++;
				}
			}
			if (shape == 1 || shape == 2) { // |처리
				if (r + 1 < N && inputArray[r + 1][c] != 1) {
					queue.add(new Pipe(r + 1, c, 2));
					pipeSave[r + 1][c]++;
				}
			}
			if (r + 1 < N && c + 1 < N && inputArray[r + 1][c] != 1 && inputArray[r][c + 1] != 1
					&& inputArray[r + 1][c + 1] != 1) { // \처리
				queue.add(new Pipe(r + 1, c + 1, 1));
				pipeSave[r + 1][c + 1]++;
			}
		}
		System.out.println(pipeSave[N - 1][N - 1]);
	}

	static class Pipe {
		int r;
		int c;
		int shape; // 0:- 1:\ 2:|

		public Pipe(int r, int c, int shape) {
			this.r = r;
			this.c = c;
			this.shape = shape;
		}

	}

}