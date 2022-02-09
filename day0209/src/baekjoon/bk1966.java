package baekjoon;

import java.util.LinkedList;
import java.util.Scanner;

public class bk1966 {
	static int TC, N, M;
	static String num;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TC = sc.nextInt();
		for (int tc = 1; tc<=TC; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			LinkedList<Integer> list = new LinkedList<>();
			for (int i = 0 ; i < N; i++) {
				list.add(sc.nextInt());
			}
		}
	}
}
