package sw;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

//https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AX5MvY2anG4DFAX1&contestProbId=AWgv9va6HnkDFAW0&probBoxId=AX72N0PKVAUDFAW0+&type=PROBLEM&problemBoxTitle=0214&problemBoxCnt=++1+

public class SW6808_규영이와_인영이의_카드게임 {
	static StringBuilder sb;
	static StringTokenizer st;
	static ArrayList<Integer> in;
	static ArrayList<Integer> gyu;
	static int inWin;
	static int gyuWin;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int C = 1; C <= TC; C++) {
			inWin = 0;
			gyuWin = 0;
			String[] s = br.readLine().split(" ");
			boolean[] numCheck = new boolean[19];
			in = new ArrayList<Integer>();
			gyu = new ArrayList<Integer>();
			for (int i = 0; i < 9; i++) {
				gyu.add(Integer.parseInt(s[i]));
				numCheck[Integer.parseInt(s[i])] = true;
			}
			for (int i = 1; i <= 18; i++) {
				if (!numCheck[i]) {
					in.add(i);
				}
			}
			boolean[] isUsed = new boolean[9];
			function(0, 0, 0, isUsed);
			sb.append("#").append(C).append(" ").append(gyuWin).append(" ").append(inWin).append("\n");
		}
		System.out.println(sb);
	}

	public static void function(int cnt, int gyuScore, int inScore, boolean[] isUsed) {
		if (cnt > 8) {
			if (gyuScore > inScore) {
				gyuWin++;
			} else if (inScore > gyuScore) {
				inWin++;
			}
			return;
		}
		for (int i = 0; i < 9; i++) {
			if (!isUsed[i]) {
				isUsed[i] = true;
				if (gyu.get(cnt) > in.get(i)) {
					function(cnt + 1, gyuScore + gyu.get(cnt) + in.get(i), inScore, isUsed);
				} else {
					function(cnt + 1, gyuScore, inScore + gyu.get(cnt) + in.get(i), isUsed);
				}
				isUsed[i] = false;
			}
		}
	}
}
