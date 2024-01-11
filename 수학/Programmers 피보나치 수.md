# Programmers [피보나치 수](https://school.programmers.co.kr/learn/courses/30/lessons/12945)

### 난이도 ★★

---

#### 접근 방식

> 반복문에서 `dp[i]`의 값을 넣을 때 `1234567`로 나눠줘야 문제를 해결할 수 있습니다.

#### 풀이

```java
class Solution {
    public int solution(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <=n; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
        }
        return dp[n];
    }
}
```

