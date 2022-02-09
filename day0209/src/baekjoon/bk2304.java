package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class bk2304 {
	static int N, L, H, sum, tempx, tempy, leftcnt, heightcnt, maxHeight, maxHeighty, z;

	public static void main(String[] args) throws NumberFormatException, IOException {
		long start = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ArrayList<Lhnum> list = new ArrayList<>();
		sum = 0;
		leftcnt = 0;
		heightcnt = 0;
		maxHeight = 0;
		maxHeighty = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			L = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			list.add(new Lhnum(L, H));
			// ArrayList, LinkedList 등 은 Collection.sort() 사용
		}
		Collections.sort(list);
		maxHeight = list.get(0).height; // 처음에는 0번 인덱스를 최고 높이로 설정
		maxHeighty = 0;
		for (z = 0; z < N; z++) {
			if (z == N - 1)  // 아래 if문 비교하면 배열 초과 오류가 뜨니 방지
				break;
			 else if (maxHeight <= list.get(z+1).height) { // 빌딩 높이를 비교해서 최대 높이 설정
				maxHeight = list.get(z+1).height;
				maxHeighty = z+1;
			}
		}

		for (int j = 0; j < maxHeighty; j++) { // 왼쪽부터 오른쪽까지 넓이 구하기
			for (int k = j + 1; k <= maxHeighty; k++) {
				if (list.get(j).height > list.get(k).height) {
					leftcnt += 1;
				} else if (list.get(j).height <= list.get(k).height) {
					sum += (list.get(k).left - list.get(j).left) * list.get(j).height;
					j += leftcnt;
					break;
				}
			}
			leftcnt = 0;
		}
		for (int w = N - 1; w > maxHeighty; w--) { // 오른쪽부터 왼쪽까지 넓이 구하기
			for (int e = w - 1; e >= maxHeighty; e--) {
				if (list.get(w).height > list.get(e).height) {
					heightcnt += 1;
				} else if (list.get(w).height <= list.get(e).height) {
					sum += Math.abs((list.get(w).left - list.get(e).left) * list.get(w).height);
					w -= heightcnt;
					break;
				}
			}
			heightcnt = 0;
		}
		sum += maxHeight;
		System.out.println(sum);
	}

	static class Lhnum implements Comparable<Lhnum> { // Collection.sort() 를 사용하기 위해선
														// Comparable<?> 인터페이스 상속해야함
		int left;
		int height;

		Lhnum(int l, int h) {
			this.left = l;
			this.height = h;
		}

		@Override
		public int compareTo(Lhnum o) {
			return this.left - o.left;
		}
	}
}
