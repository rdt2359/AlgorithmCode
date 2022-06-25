package bj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1629_곱셈 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String[] s = br.readLine().split(" ");
		Long a = Long.parseLong(s[0]);
		Long b = Long.parseLong(s[1]);
		Long c = Long.parseLong(s[2]);

		System.out.println(pow(a, b, c));
	}

	public static long pow(long a, long b, long c) {
		if (b == 1) {
			return a % c;
		}

		long temp = pow(a, b / 2, c);

		if (b % 2 == 1) {
			return (temp * temp % c) * a % c;
		}
		return temp * temp % c;

	}
}