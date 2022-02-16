package SwExpertAcademy;

import java.util.LinkedList;
import java.util.Scanner;

public class sw1228 {
	static int N, cnt;
	static String str;
	static String Instr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			LinkedList<Integer> list = new LinkedList<>();
			N = sc.nextInt();
			for (int i = 0; i < N; i++) {
				list.add(sc.nextInt());
			}
			cnt = sc.nextInt();
			for (int j = 0; j < cnt; j++) {
				String I = sc.next(); // 변경 암호문에서 I 짜르기
				int X = sc.nextInt(); // 삽입 인덱스 번호
				int Y = sc.nextInt(); // 데이터 삽입 숫자
				for (int k = 0; k < Y; k++) {
					list.add(X, sc.nextInt());
					X += 1; // 다음 인덱스 
				}
			}
			System.out.printf("#" + tc + " ");
			for (int h = 0; h < 10; h++) {
				System.out.print(list.pop() + " ");
			}
			System.out.println();
		}

	}
}
