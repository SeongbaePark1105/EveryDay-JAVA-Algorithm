# Softeer [전광판](https://softeer.ai/practice/info.do?idx=1&eid=624&sw_prbl_sbms_sn=236105)

### 난이도 ★★

---

#### 접근 방식

> 구현 문제입니다. 처음에 전광판에 있는 숫자들을 어떻게 표현해서 비교해야 될지 고민했습니다.
>
> 이차원 배열을 이용해서 위에서 부터 내려오는데 `상, 좌, 우 ,하` 순으로 전등의 상태를 표현하였습니다.
>
> 그 다음에 각자의 단어 길이를 구하고 `1`의 자리 숫자부터 시작해야하니 각 자의 `길이 - 1`부터 시작하여 비교해주었습니다.
>
> `매개 변수`를 넘겨줄 때 `int`자료형이여야 하므로 `Character.getNumericValue()`를 사용하여  `Char`자료형을 `int`자료형으로 넘겨주었습니다.

#### 풀이

```java
import java.util.*;
import java.io.*;


public class Main
{
    static int [][] arr = {
        {1, 1, 1, 0, 1, 1, 1}, // 위에서 부터시작하여 상, 좌, 우 하, 좌, 우, 하 순
        {0, 0, 1, 0, 0, 1, 0}, 
        {1, 0, 1, 1, 1, 0, 1}, 
        {1, 0, 1, 1, 0, 1, 1}, 
        {0, 1, 1, 1, 0, 1, 0}, 
        {1, 1, 0, 1, 0, 1, 1},
        {1, 1, 0, 1, 1, 1, 1},
        {1, 1, 1, 0, 0, 1, 0},
        {1, 1, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 0, 1, 1}
    };
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int TC = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < TC; tc++){
            st = new StringTokenizer(br.readLine());
            String A = st.nextToken();
            String B = st.nextToken();
            int answer = 0;
            int alen = A.length() -1;
            int blen = B.length() -1;
            while (true){
                if (alen < 0 && blen < 0) break;
                else if (alen >= 0 && blen>=0){
                    answer += checkLight(Character.getNumericValue(A.charAt(alen)), Character.getNumericValue(B.charAt(blen)));
                } else if ( alen < 0){
                    answer += checkLight(Character.getNumericValue(B.charAt(blen)), -1);
                } else if (blen < 0){
                    answer += checkLight(Character.getNumericValue(A.charAt(alen)), -1);
                }
                alen--;
                blen--;
            }
            System.out.println(answer);
        }        
    }
    static int checkLight(int a, int b){
        int count = 0;
        if ( a == b ){
            return 0;
        } else if ( a >= 0 && b >=0){
            
            for (int i = 0; i < 7; i++){
                if (arr[a][i] != arr[b][i]) {
                    count++;
                }
            }
        } else {
            for (int i = 0;  i< 7; i++){
                count+= arr[a][i];
            }
        }
        return count;
    }
}
```

