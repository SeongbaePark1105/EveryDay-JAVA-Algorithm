package SwExpertAcademy;

import java.util.Scanner;

public class sw5215 {
	static int N, L, TC;
	static int score[], cal[];
	static boolean Selected[];
	static int answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt();
			L = sc.nextInt();
			score = new int[N];
			cal = new int[N];
			Selected = new boolean[N];
			answer = 0;
			for (int i = 0; i < N; i++) {
				score[i] = sc.nextInt();
				cal[i] = sc.nextInt();
			}
			ham(0);

			System.out.println("#" + tc + " " + answer);
		}
	}

	public static void ham(int cnt) {

		if (cnt == N) {
			int sumCal = 0;
			int sumScore = 0;

			for (int i = 0; i < N; i++) {
				if (Selected[i]) {
					sumCal += cal[i];
					sumScore += score[i];
				}
			}

			if (sumCal < L && sumScore > answer)
				answer = sumScore;

			return;
		}
		Selected[cnt] = true;
		ham(cnt + 1);
		Selected[cnt] = false;
		ham(cnt + 1);
	}

}
