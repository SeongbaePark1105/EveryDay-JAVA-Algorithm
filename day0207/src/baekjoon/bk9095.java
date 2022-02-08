package baekjoon;

import java.util.Scanner;

public class bk9095 {
	
	static int TC, N, sum;
	static int numbers[] = new int[11];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TC = sc.nextInt();
		numbers[1] = 1;
		numbers[2] = 2;
		numbers[3] = 4;
		for (int tc = 1; tc<=TC; tc++) {
			N = sc.nextInt();
			while(N<4 && N>11) {
				N = sc.nextInt();
			}
			for(int i = 4; i<=N; i++) {
				numbers[i] = numbers[i-1] + numbers[i-2] + numbers[i-3];
			}
			System.out.println(numbers[N]);
		}
	}
}
