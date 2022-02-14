package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bk3040 {
	static int N[] = new int[9];
	static boolean visit[] = new boolean[9];
	static int sum;
	static int result[] = new int[7];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 9; i++) {
			N[i] = Integer.parseInt(br.readLine());
		}

		powerSet(0, 0);
	}
	
	static void powerSet(int idx, int start) {
		
		if (idx == 7) {
			int sum = 0;
			for (int i = 0; i < 7; i++) {
				sum += result[i];
			}
			if (sum == 100) {
				for (int i = 0; i < 7; i++) {
					System.out.println(result[i]);

				}
				return;
			}
			return;
		}

		for (int i = start; i < 9; i++) {
			result[idx] = N[i];
			powerSet(idx + 1, i + 1);

		}

	}
}