package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bk1074 {
	static int arr[][], N, r, c, size, cnt, ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		size = 1 << N;
		arr = new int[size][size];
		cnt = 0;
		arrZ(0, 0, size, size);
		System.out.println(ans);
	}

	static void arrZ(int si, int sj, int ei, int ej) {
		if(r<si || ei<=r || c<sj || ej<=c) { 
			cnt += (ei-si)*(ej-sj);
			return;
		}
		
		if(ei-si==1) { 
			if(si==r && sj==c) { 
				ans = cnt;
			}
			cnt++;
			return;
		}
		
		int mi = (si+ei)/2;
		int mj = (sj+ej)/2;
		
		arrZ(si, sj, mi, mj); // 1
		arrZ(si, mj, mi, ej); // 2
		arrZ(mi, sj, ei, mj); // 3
		arrZ(mi, mj, ei, ej); // 4
	}

}
