# 백준 #5525 [IOIOI](https://www.acmicpc.net/problem/5525)

### 난이도 `실버 1` `문자열` 

---

#### 접근 방식

> `IOI` 3의 구간을 반복을 시켜서 만족하는 값을 찾았습니다.
>
> 만족할 경우 `i`값을 증가시켜서 중복되는 부분을 넘어가게 해주었고
>
> `cnt`의 값과 `N`값이 같은 경우 주어진 `P(n)`의 값과 일치하기 때문에 그때 정답 카운트를 증가시켰습니다. 

#### 풀이

```java
package bk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bk_5525 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int S = Integer.parseInt(br.readLine());
    String str = br.readLine();
    int cnt = 0;
    int result = 0;
    for(int i = 1; i < S - 1; i++){
      if (str.charAt(i-1) == 'I' && str.charAt(i) == 'O' && str.charAt(i+1) == 'I'){
        cnt++;
        if (cnt == N){
          cnt--;
          result++;
        }
        i++;
      } else {
        cnt = 0;
      }
    }
    System.out.println(result);
  }
}
```

