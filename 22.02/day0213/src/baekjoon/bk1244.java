package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bk1244 {
	static int switchcnt; // 스위치 갯수
	static int switchbl[]; // 스위치 상태
	static int student; // 학생 1이면 남자, 2이면 여자
	static int gender[], stnum[]; // 학생 성별, 학생 수
	static int chk; // 여학생 부분있었는지 체크

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		switchcnt = Integer.parseInt(br.readLine());
		switchbl = new int[switchcnt + 1];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= switchcnt; i++) {
			switchbl[i] = Integer.parseInt(st.nextToken());
		}
		student = Integer.parseInt(br.readLine());
		gender = new int[student];
		stnum = new int[student];
		for (int i = 0; i < student; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			gender[i] = Integer.parseInt(st.nextToken());
			stnum[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < student; i++) {
			chk = 0;
			for (int j = 1; j <= switchcnt; j++) {
				if (gender[i] == 1) { // 남자 스위치
					if (j % stnum[i] == 0) {
						if (switchbl[j] == 0)
							switchbl[j] = 1;
						else
							switchbl[j] = 0;
					}
				} else if (gender[i] == 2) {// 여자 스위치
					chk++;
					if (stnum[i] - j == 0 || stnum[i] + j == switchcnt + 1
							|| switchbl[stnum[i] - j] != switchbl[stnum[i] + j])
						break;
					else {
						if (switchbl[stnum[i] - j] == 0) {
							switchbl[stnum[i] - j] = 1;
							switchbl[stnum[i] + j] = 1;
						} else if (switchbl[stnum[i] - j] == 1) {
							switchbl[stnum[i] - j] = 0;
							switchbl[stnum[i] + j] = 0;
						}
					}
				}
			}
			if (chk != 0) {
				if (switchbl[stnum[i]] == 0)
					switchbl[stnum[i]] = 1;
				else
					switchbl[stnum[i]] = 0;
			}
		}
		for (int i = 1; i <= switchcnt; i++) {
			System.out.print(switchbl[i] + " ");
			if (i % 20 == 0)
				System.out.println();
		}
	}
}
