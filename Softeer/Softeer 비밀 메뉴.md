# Softeer [장애물 인식 프로그램](https://softeer.ai/practice/info.do?idx=1&eid=409)

### 난이도 ★★

---

#### 접근 방식

> 구현 문제입니다.
>
> 이중 반복문을 이용하여 사용자가 누른 `메뉴 넘버`에 비밀 코드가 있는 지 차근차근 체크하면서 진행하였습니다.

#### 풀이

```java
import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int M = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int [] arr = new int[M];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }
    int [] menuNum = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++){
      menuNum[i] = Integer.parseInt(st.nextToken());
    }
    int check = 0;
    if (N >= M){
      for (int i = 0; i < N - M + 1; i++){
        for (int j = 0; j < M; j++){
          if (arr[j] == menuNum[i + j]){
            check++;
          } else continue;
        }
        if (check == M) {
          System.out.println("secret");
          return;
        }
        check = 0;
      }
    }
    System.out.println("normal");
  }
}
```

