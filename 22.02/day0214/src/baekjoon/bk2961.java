package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bk2961 {
	static int N; // 재료의 개수
	static int S[], B[]; // 신맛과 쓴맛
	static int mulS, sumB; // 신맛의 곱과 쓴맛의 합
	static boolean visit[];
	static int result; // 제일 작은 값 도출
	static int di; // 신맛과 쓴맛 차이 값을 넣어주기 위한 변수
	static int cnt = 0;
	static boolean arrvisit;
	// 신맛 S는 사용한 재료의 신맛의 곱, 쓴맛 B는 사용한 재료의 합이다.

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		S = new int[N];
		B = new int[N];
		visit = new boolean[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			S[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
		}
		result = Integer.MAX_VALUE;
		mulS = 1;
		sumB = 0;
		powerSet(0);
		System.out.println(result);
	}

	static void powerSet(int idx) {

		if (idx == N) {

			di = 0;
			mulS = 1;
			sumB = 0;
			for (int i = 0; i < N; i++) {

				if (visit[i]) {
					arrvisit = true;
					cnt++;
					mulS *= S[i];
					sumB += B[i];
				}

			}
			if (arrvisit) { // 공집합일때(?) 초기화된 값이 망치지 않기 위해 visit[i]를 방문했을 때 방문했으면 arrvisit을 true로 해서
							// 아래 계산식들이 돌아가게 한다.
				di = Math.abs(mulS - sumB);
				result = Math.min(result, di);
				arrvisit = false;
			}
			return;
		}

		visit[idx] = true;
		powerSet(idx + 1);
		visit[idx] = false;
		powerSet(idx + 1);
	}
}
