package baekjoon;

import java.util.Scanner;

public class bk2493 {

	static int TC, N, Razer[], sum[], sum2;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt();
			while(N<1 || N >500000)
				N = sc.nextInt();
			for (int i = 0; i<N; i++) {
				Razer[i] = sc.nextInt();
			}
			sum = new int[N];
		}
	}
}
