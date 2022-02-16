package SwExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class sw1289 {
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int TC = Integer.parseInt(br.readLine());
 
        for (int i = 0; i < TC; i++) {
            String in = br.readLine();
            int cnt = 0;
            char chk = '0';
            for (int j = 0; j< in.length(); j++) {
                if( chk != in.charAt(j)) {
                    cnt++;
                    chk = in.charAt(j);
                }
            }
            System.out.println("#" + (i+1) + " " + cnt);
        }
    }
}