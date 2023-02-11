# Softeer [바이러스](https://softeer.ai/practice/info.do?idx=1&eid=407&sw_prbl_sbms_sn=129401)

### 난이도 ★★

---

#### 접근 방식

> int 형이 가질 수 있는 수가 넘을 수 있으므로 long 형으로 바꿔준 뒤 계산을 합니다.
>
> 그리고 나머지를 구하기 전에 꼭 증식하는 값들을 먼저 우선 순위로 구해주고 나머지를 구해줘야합니다.

#### 풀이

```java
import java.util.*;
import java.io.*;

public class Main
{
    public static int N, K, P;
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        long result = K;
        for (int i = 0; i < N; i++){
            result = (result * P) % 1000000007;
        }
        System.out.println(result);
    }
}
```

