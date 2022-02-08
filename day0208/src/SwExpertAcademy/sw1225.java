package SwExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class sw1225 {

	static int N;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		LinkedList<Integer> arr = new LinkedList<>();
		
		for (int tc = 1; tc <= 10; tc++) {
			int TC = Integer.parseInt(br.readLine());
			String str[] = br.readLine().split(" ");
			for(int i = 0; i<8; i++) {
				N = Integer.parseInt(str[i]);
				arr.add(N);
			}
			int num = 1;
			while(num !=0) 
			for (int j = 1; j<=5; j++) {
				num = arr.pop();
				num -= j;
				if (num <=0) {
					num = 0;
					arr.add(num);
					break;
				}else
					arr.add(num);
			}
			System.out.print("#"+tc+" ");
			for (int k = 0; k<8; k++)
				System.out.print(arr.pop()+" ");
			System.out.println();
		}
	}
}
