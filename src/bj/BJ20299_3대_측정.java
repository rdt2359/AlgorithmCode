package bj;
import java.io.*;

public class BJ20299_3대_측정 {
	static int N;
	static int minValue = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		String[] ss = br.readLine().split(" ");
		int N = Integer.parseInt(ss[0]); // 문제 조건을 입력 받음
		int S = Integer.parseInt(ss[1]);
		int M = Integer.parseInt(ss[2]);
		int cnt = 0;
		for (int cc = 0; cc < N; cc++) { // 신청 동아리수만큼 반복
			String[] ss2 = br.readLine().split(" ");
			int score1 = Integer.parseInt(ss2[0]);
			int score2 = Integer.parseInt(ss2[1]);
			int score3 = Integer.parseInt(ss2[2]); // 각 학생의 점수를 입력받음
			// 각 학생의 점수가 M보다 크고, 점수의 합의 S보다 클경우만 가입 가능
			if (score1 >= M && score2 >= M && score3 >= M && score1 + score2 + score3 >= S) {
				cnt++; // 가입한 동아리수 증가
				// 가입한 학생의 점수 기록
				sb.append(score1).append(" ").append(score2).append(" ").append(score3).append(" ");
			}
		}
		// 결과 출력
		sb2.append(cnt).append("\n").append(sb);
		System.out.println(sb2);
	}
}
