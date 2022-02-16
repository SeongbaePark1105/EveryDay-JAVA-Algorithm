package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bk2563 {
	static int N, L, U, sum;
	static int arr[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[101][101];
		for (int i = 0; i < +N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			U = Integer.parseInt(st.nextToken());
			for (int j = L; j < L + 10; j++) {
				for (int k = U; k < U + 10; k++) {
					arr[j][k] = 1;
				}
			}
		}

		for (int a = 1; a <= 100; a++) {
			for (int b = 1; b <= 100; b++) {
				sum += arr[a][b];
			}
		}
		System.out.println(sum);
	}

}
