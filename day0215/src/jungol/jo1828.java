package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class jo1828 {
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Temp[] t = new Temp[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			t[i] = new Temp(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(t);
		int cnt = 1;
		int ref = t[0].high;
		for (int i = 1; i < N; i++) {
			if (t[i].low > ref) {
				ref = t[i].high;
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	static class Temp implements Comparable<Temp> {
		int low, high;

		public Temp(int low, int high) {
			super();
			this.low = low;
			this.high = high;
		}

		@Override
		public int compareTo(Temp o) {
			// TODO Auto-generated method stub
			return this.high - o.high;
		}
	}
}