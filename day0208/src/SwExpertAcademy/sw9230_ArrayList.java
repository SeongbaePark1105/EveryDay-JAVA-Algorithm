package SwExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class sw9230_ArrayList {
	static int TC, N, M, max, sum, weight, cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		TC = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
		for (int tc = 1; tc <= TC; tc++) {
			max = 0;			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken()); // 과자 봉지 수
			M = Integer.parseInt(st.nextToken()); // 과자 2봉지 무게 제한
			ArrayList<Integer> list = new ArrayList<>();
			st = new StringTokenizer(br.readLine()," ");
			list.clear();
			for (int k = 0; k < N; k++) {
				weight = Integer.parseInt(st.nextToken());
				list.add(k, weight);
			}
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					sum = list.get(i) + list.get(j); // 리스트의 인덱스로 값을 불러와서 봉지의 합을 구함
					if (max < sum && sum <= M) {
						max = sum; 
					}
				}
			}
			if(max == 0)
				max = -1;
			System.out.println("#" + tc + " " + max);
		}
	}
}
