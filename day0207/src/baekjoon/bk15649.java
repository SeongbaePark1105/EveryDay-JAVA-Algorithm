package baekjoon;

import java.util.Scanner;

public class bk15649 {

	static int N, M, input[], numbers[];
	static boolean isSeLected[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		input = new int[N];
		numbers = new int[N];
		isSeLected = new boolean[N];
		for (int j = 0; j < N; j++) {
			input[j] = j + 1;
		}

		Permutation(0);
	}

	public static void Permutation(int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++)
				System.out.printf(numbers[i] + " ");
			System.out.println();
			return;
		}

		for (int i = 0; i < N; i++) {
			if (isSeLected[i])
				continue;
			numbers[cnt] = input[i];
			isSeLected[i] = true;
			Permutation(cnt + 1);
			isSeLected[i] = false;
		}
	}
}
