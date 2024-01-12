# Programmers [2 x n 타일링](https://school.programmers.co.kr/learn/courses/18/lessons/12900)

### 난이도 ★★

---

#### 접근 방식

> `dp`방식이라고 생각했고 규칙을 찾는 게 중요했습니다.
>
> 규칙을 찾아보니 `피보나치 수`인 것을 확인하였고 규칙을 바탕으로 점화식을 세워 해결하였습니다. 

#### 풀이

```java
class Solution {
    public int solution(int n) {
        int answer = 0;
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++){
            dp[i] = ( dp[i-1] + dp[i - 2] ) % 1000000007;
        }
        return dp[n];
    }
}
```

