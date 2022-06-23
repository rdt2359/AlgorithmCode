package bj;
import java.io.*;

public class BJ2839_설탕배달 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		while (N % 5 != 0 && N >= 0) {
			cnt++;
			N -= 3;
		}
		if (N < 0) {
			cnt = -1;
		} else {
			cnt += N / 5;
		}

		System.out.println(cnt);
	}

}
