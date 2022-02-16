package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class bk10974 {

	static int N, numbers[];
	static boolean[] isSeLected;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		numbers = new int[N];
		isSeLected = new boolean[N];
		Permutation(0);
	}

	public static void Permutation(int cnt) {
		if (cnt == N) {
			for (int i = 0; i < N; i++)
				System.out.print(numbers[i] + " ");
			System.out.println();
			return;
		}
		for (int i = 0; i < N; i++) {
			if (isSeLected[i])
				continue;
			numbers[cnt] = i + 1;
			isSeLected[i] = true;
			System.out.println("cnt 값 : "+ cnt);
			Permutation(cnt + 1);
			isSeLected[i] = false;
		}
	}
}
