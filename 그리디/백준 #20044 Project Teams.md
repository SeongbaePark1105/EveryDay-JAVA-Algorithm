# 백준 #20044 [Project Teams](https://www.acmicpc.net/problem/20044)

### 난이도 `실버 4 `  `그리디 알고리즘` `정렬`

---

#### 접근 방식

> 배열을 `2*N`으로 선언해주고 주어진 값들을 담고 `오름차순`으로 정렬합니다.
>
> 그 다음 제일 작은 값과 제일 큰 값을 더하고 최솟값을 구하는 반복문을 실행시켜서 가장 합이 작은 값을 구합니다.

#### 풀이

```java
package bk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class bk_20044 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int [] arr = new  int[2*N];
    for (int i = 0 ; i < 2*N; i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr);
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < N; i++){
      min = Math.min(min, arr[i] + arr[2*N - 1 - i]);
    }
    System.out.println(min);
  }
}
```

