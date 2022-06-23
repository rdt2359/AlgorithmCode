package sw;
import java.io.*;

//농작물 수확하기 https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AX5MvY2anG4DFAX1&contestProbId=AV7GLXqKAWYDFAXB&probBoxId=AX7CcH16KvoDFAVm&type=PROBLEM&problemBoxTitle=0204&problemBoxCnt=3

public class SW2805 {
	static StringBuilder sb;
	static int nn;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		nn = Integer.parseInt(br.readLine());
		for (int c = 1; c <= nn; c++) {
			int n = Integer.parseInt(br.readLine());
			int[][] array = new int[n][n];
			for (int i = 0; i < n; i++) {
				String[] ss = br.readLine().split("");
				for (int j = 0; j < n; j++) {
					array[i][j] = Integer.parseInt(ss[j]);
				}
			}
			int sum = 0;
			for (int i = 0; i < n; i++) {
				sum += array[i][n / 2];

				int tempNum = i < n - i - 1 ? i : n - i - 1;
				for (int j = 1; j <= tempNum; j++) {
					sum += array[i][n / 2 + j];
					sum += array[i][n / 2 - j];
				}
			}
			sb.append("#").append(c).append(" ").append(sum).append("\n");
		}
		System.out.println(sb);
	}
}
