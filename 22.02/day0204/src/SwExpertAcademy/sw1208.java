package SwExpertAcademy;

import java.util.Arrays;
import java.util.Scanner;

public class sw1208 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc<=10; tc++) {
			int Dump = sc.nextInt();
			int []arr = new int[100];			
			for(int i = 0; i<arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);			
			for(int i = 0; i<Dump; i++) {
				arr[0]++;
				arr[99]--;
				Arrays.sort(arr);
			}
			System.out.printf("#"+tc+" "+ (arr[99] - arr[0]));
			System.out.println();
		}
	}
}