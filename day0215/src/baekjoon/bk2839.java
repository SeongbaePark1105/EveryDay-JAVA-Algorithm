package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bk2839 {
	static int N; // 설탕 킬로그램
	static int cnt;
	static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		result = 0;
		while (true) {
			if (N % 5 == 0) {
				result += N / 5;
				System.out.println(result);
				break;
			} else {
				N -= 3;
				result++;
			}

			if (N < 0) {
				System.out.println(-1);
				break;
			}
		}
	}
}
