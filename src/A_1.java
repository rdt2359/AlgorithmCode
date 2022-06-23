import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A_1 {

	static int minValue = Integer.MAX_VALUE;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tt = 1; tt <= T; tt++) {
			N = Integer.parseInt(br.readLine());
			int[][] array = new int[N][2];
			for (int i = 0; i < 3; i++) {
				st = new StringTokenizer(br.readLine());
				array[i][0] = Integer.parseInt(st.nextToken()) - 1;
				array[i][1] = Integer.parseInt(st.nextToken());
			}
			// 낚시터가 3개, 0,1,2 순서 정함 -> 6가지
			boolean[] isUsed = new boolean[3];
			for (int first = 0; first < 3; first++) {
				isUsed[first] = true;
				for (int second = 0; second < 3; second++) {
					if (!isUsed[second]) {
						isUsed[second] = true;
						for (int third = 0; third < 3; third++) {
							if (!isUsed[third]) {
								int[] order = new int[] { first, second, third };
								function(0, 0, order, array, new boolean[N]);
							}
						}
						isUsed[second] = false;
					}
				}
				isUsed[first] = false;
			}
			sb.append("#").append(tt).append(" ").append(minValue).append("\n");
			minValue = Integer.MAX_VALUE;
		}
		System.out.println(sb);
	}

	public static void function(int index, int movement, final int[] order, final int[][] array, final boolean[] line) {
		if (index == 3) {
			if (minValue > movement) {
				minValue = movement;
			}
			return;
		}

		int pos = array[order[index]][0];
		int peopleNum = array[order[index]][1];
		int leftCnt = 0;
		int rightCnt = 0;

		while (peopleNum > 1) {
			while (pos - leftCnt > 0 && line[pos - leftCnt]) { // 왼쪽에 사람이 들어갈 수 있는 위치 찾기
				leftCnt++;
			}
			while (pos + rightCnt < N - 1 && line[pos + rightCnt]) { // 오른쪽에 사람이 들어갈 수 있는 위치 찾기
				rightCnt++;
			}
			// 위 경우 배열 처음이나 끝까지 차있는 경우 존재

			if (line[pos - leftCnt]) { // 왼쪽에 못넣는 경우
				line[pos + rightCnt] = true;
				movement += rightCnt + 1;
			} else if (line[pos + rightCnt]) { // 오른쪽에 못넣는 경우
				line[pos - leftCnt] = true;
				movement += leftCnt + 1;
			} else if (leftCnt < rightCnt) { // 왼쪽이 최소
				line[pos - leftCnt] = true;
				movement += leftCnt + 1;
			} else { // 오른쪽이 최소 or 같음
				line[pos + rightCnt] = true;
				movement += rightCnt + 1;
			}
			peopleNum--;
		}

		// 한명 남으면
		while (pos - leftCnt > 0 && line[pos - leftCnt]) {
			leftCnt++;
		}
		while (pos + rightCnt < N - 1 && line[pos + rightCnt]) {
			rightCnt++;
		}

		if (leftCnt == rightCnt) { // 둘다 넣을 수 있는 경우
			if (!line[pos - leftCnt]) { // 왼쪽에 넣음
				line[pos - leftCnt] = true;
				movement += (leftCnt + 1);
				function(index + 1, movement, order, array, Arrays.copyOf(line, line.length));
				line[pos - leftCnt] = false;
				movement -= (leftCnt + 1);
			}
			if (!line[pos + rightCnt]) { // 오른쪽에 넣음
				line[pos + rightCnt] = true;
				movement += rightCnt + 1;
				function(index + 1, movement, order, array, Arrays.copyOf(line, line.length));
			}
		} else {
			if (line[pos - leftCnt]) { // 왼쪽에 못넣는 경우
				line[pos + rightCnt] = true;
				movement += rightCnt + 1;
			} else if (line[pos + rightCnt]) { // 오른쪽에 못넣는 경우
				line[pos - leftCnt] = true;
				movement += leftCnt + 1;
			} else if (leftCnt < rightCnt) { // 왼쪽이 최소
				line[pos - leftCnt] = true;
				movement += leftCnt + 1;
			} else {
				line[pos + rightCnt] = true; // 오른쪽이 최소 (or 같음)
				movement += rightCnt + 1;
			}
			function(index + 1, movement, order, array, Arrays.copyOf(line, line.length));
		}
	}
}
