package SwExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw3499 {
	static int TC, N;
	static String[] text, arr1, arr2;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int suf = 0;
			text = new String[N];
			for (int i = 0; i < N; i++) {
				text[i] = st.nextToken();
			}
			suf = N / 2;
			if (N % 2 == 0) {
				arr1 = new String[suf];
				arr2 = new String[suf];
				for (int j = 0; j < suf; j++) {
					arr1[j] = text[j];
				}
				for (int k = 0; suf < N; k++, suf++) {
					arr2[k] = text[suf];
				}
			} else if (N % 2 != 0) {
				arr1 = new String[suf + 1];
				arr2 = new String[suf];
				for (int j = 0; j < suf + 1; j++) {
					arr1[j] = text[j];
				}
				for (int k = 0; suf + 1 < N; k++, suf++) {
					arr2[k] = text[suf + 1];
				}
			}
			System.out.print("#" + tc + " ");
			if (N % 2 == 0) {
				for (int a = 0; a < N / 2; a++) {
					System.out.print(arr1[a] + " " + arr2[a] + " ");
				}
			} else if (N % 2 != 0) {
				for (int b = 0; b < N / 2; b++) {
					System.out.print(arr1[b] + " " + arr2[b] + " ");
				}
				System.out.print(arr1[arr1.length - 1]);
			}

			System.out.println();
		}
	}
}
