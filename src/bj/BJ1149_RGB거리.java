package bj;
import java.io.*;

//https://www.acmicpc.net/problem/1149
public class BJ1149_RGB거리 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[][] array = new int[N][3];

		for (int i = 0; i < N; i++) {
			String[] ss = br.readLine().split(" ");
			for (int j = 0; j < 3; j++) {
				array[i][j] = Integer.parseInt(ss[j]);
			}
		}

		int[][] save = new int[N][3]; //  M번째 집이 ?색이 되며 첫번째 집부터 M번쨰 집까지 칠한 비용의 최솟값
		//초기값 설정 
		save[0][0] = array[0][0]; //빨   
		save[0][1] = array[0][1]; //초
		save[0][2] = array[0][2]; //파

		for (int i = 1; i < N; i++) {
			save[i][0] = Math.min(save[i - 1][1], save[i - 1][2]) + array[i][0];
			save[i][1] = Math.min(save[i - 1][0], save[i - 1][2]) + array[i][1];
			save[i][2] = Math.min(save[i - 1][0], save[i - 1][1]) + array[i][2];
		}

		int ans = Math.min(Math.min(save[N - 1][0], save[N - 1][1]), save[N - 1][2]);
		System.out.println(ans);
	}
}