package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class bk11399 {
	static int N, P, sum, num, resultsum;
	static ArrayList<Integer> PI = new ArrayList<Integer>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		sum = 0;
		for (int i = 0; i<N; i++) {
			P = Integer.parseInt(st.nextToken());
			PI.add(P);
		}
		Collections.sort(PI); // 오름차순으로 정렬해서 더해주려고 함
		for (int j = 0; j<N; j++) {
			num = PI.get(j);
			sum += num;
			resultsum += sum; // 모두 걸리는 시간을 구해야하니 다 더해줘야함
		}
		System.out.println(resultsum);
	}
}
