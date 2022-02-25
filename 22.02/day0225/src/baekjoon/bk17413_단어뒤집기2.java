package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class bk17413_단어뒤집기2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> st = new Stack<>();
		String str = br.readLine();
		int count = 0;
		while (count < str.length()) {
			if (str.charAt(count) == '<') {
				while (str.charAt(count) != '>') {
					System.out.print(str.charAt(count));
					count++;
				}
				if (str.charAt(count) == '>') {
					System.out.print(str.charAt(count));
					count++;
				}

			} 
			else if (str.charAt(count) == ' ') {
				System.out.print(str.charAt(count));
				count++;
			} 
			else {
				while (str.charAt(count) != '<' && str.charAt(count) != ' ' && str.charAt(count) != '>') {
					st.add(str.charAt(count));
					count++;
					if (count == str.length())
						break;
				}
				while (!st.isEmpty()) {
					System.out.print(st.pop());
				}
			}
		}
	}
}
