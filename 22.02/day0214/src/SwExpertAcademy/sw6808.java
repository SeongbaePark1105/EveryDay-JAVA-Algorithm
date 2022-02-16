package SwExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sw6808 {
	static int T; // 테스트 케이스 수
	static int gyu[]; // 규영이 카드
	static int in[]; // 인영이 카드
	static ArrayList<Integer> num;
	static boolean visit[];
	static int sum, sum2, win, lose, drow;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc<=T; tc++) {
			gyu = new int[9];
			in = new int[9];
			num = new ArrayList<Integer>();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < 9; i++) {
				gyu[i] = Integer.parseInt(st.nextToken());
			}
			for(int i =0; i < 18; i++) {
				num.add(i+1);
			}
			for (int i = 0; i<9; i++) {
				for(int j = 0; j<18; j++) {
					if (num.get(j) == gyu[i]) {
						num.remove(j);
						break;
					}
				}
			}
//			for (int i = 0; i<9; i++) {
//				in[i] = num.get(i);
//			}
//			for(int i = 0; i < 9; i++) {
//				System.out.print(gyu[i]+" ");
//			}System.out.println();
//			for(int i = 0; i < 9; i++) {
//				System.out.print(in[i]+" ");
//			}
			visit = new boolean[9];
			win = 0;
			lose = 0;
			drow = 0;
			permutation(0);
			System.out.println("#"+tc+" " + win +" " + lose);
		}
	}
	static void permutation(int cnt) {
		if (cnt == 9) {
			sum = 0; // 규영이
			sum2 = 0; // 인영이
			for(int i =0; i<9;i++) {
				if (gyu[i] > in[i]) // 규영이
					sum += gyu[i] + in[i];
				else if (in[i] >gyu[i]) // 인영이 
					sum2 += gyu[i] + in[i];
			}
			if (sum > sum2)
				win++;
			else if (sum2 > sum)
				lose++;
			else if (sum == sum2)
				drow++;
			return;
		}
		for (int i = 0; i<9; i++) {
			if (visit[i])
				continue;
			visit[i] = true;
			in[cnt] = num.get(i);
			permutation(cnt+1);
			visit[i] = false;
		}
		
	}
	
}
