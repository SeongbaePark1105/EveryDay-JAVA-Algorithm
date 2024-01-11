# Programmers [땅따먹기](https://school.programmers.co.kr/learn/courses/18/lessons/12913)

### 난이도 ★★

---

#### 접근 방식

> 처음에는 `dfs`로 접근했다가 `시간초과`가 나왔습니다.
>
> 그래서 다시 접근해보니 `dp`방식으로 해결할 수 있었습니다.
>
> `3중 포문`으로 `행 포문`, 그리고 열끼리 연속되지 않게 하기 위하여 `이중 포문`을 추가하였습니다.
>
> `j`와 `k`가 같지 않을 경우 해당 좌표의 값과 `전에 밟았던 땅의 값 + 이번에 밟는 땅의 값`을 더한 값을 비교하여 값을 계속 큰 값으로 갱신합니다.
>
> 마지막 행에 `0~3`열 값을 비교해서 가장 큰 값을 출력합니다.

#### 풀이

```java
import java.util.*;
class Solution {
    int solution(int[][] land) {
        int [][] dp = new int[land.length][4];
        for (int i = 0; i < 4; i++){
            dp[0][i] = land[0][i];
        }
        for (int i = 1; i < land.length; i++){
            for (int j = 0; j < 4; j++){
                for (int k = 0; k < 4; k++){
                    if (j == k) continue;
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][k] + land[i][j]);
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < 4; i++){
            answer = Math.max(answer, dp[land.length - 1][i]);
        }
        
        return answer;
    }
}
```

