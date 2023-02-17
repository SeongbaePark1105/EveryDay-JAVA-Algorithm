# Softeer [지도 자동 구축](https://softeer.ai/practice/info.do?idx=1&eid=413)

### 난이도 ★★

---

#### 접근 방식

> 규칙을 찾으면 쉬운 문제이다.
>
> 점화식을 세워 배열에 값들을 넣어준 뒤 테스트 케이스 값들에 맞게 출력해준다.

#### 풀이

```java
import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N  = Integer.parseInt(br.readLine());
        double [] arr = new double[16];
        arr[0] = 2;
        for (int i = 1; i < 16; i++){
            arr[i] = (arr[i-1] * 2 -1);
        }
        double result = Math.pow(arr[N], 2);
        System.out.println((int)result);
    }
}
```

