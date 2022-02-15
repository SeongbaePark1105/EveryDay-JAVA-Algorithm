package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bk1074 {
	static int arr[][], N, r, c, size, cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		size = (int) Math.pow(2, N);
		arr = new int[size][size];
		cnt = 0;
		arrZ(N - 1);
	}

	static void arrZ(int z) {
		int size2 = (int) Math.pow(2, z);
		int arr2[][] = new int[size2][size2];

		for (int i = 0; i < size; i++) {
			for (int a = 0; a < size2; a++) {
				for (int b = 0; b < size2; b++) {
					arr2[a][b] = cnt;
					cnt++;
				}
			}
		}
	}
}
