# Programmers [문자열 내 p와 y의 개수](https://school.programmers.co.kr/learn/courses/30/lessons/12916)

### 난이도 ★

---

#### 접근 방식

> 조건이 대문자와 소문자를 신경 쓰지 않습니다. 따라서, `toUpperCase()` 나 `toLowerCase()`를 사용하여 문자를 변환한 후에 반복문을 돌려 `p` 와 `y`의 값을 구해주면 됩니다. 

#### 풀이

```java
class Solution {
    boolean solution(String s) {
        boolean answer = true;

        s = s.toUpperCase();
        int p = 0;
        int y = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == 'P') p++;
            else if (s.charAt(i) == 'Y') y++;
        }
        if (p == y) answer = true;
        else answer = false;
        return answer;
    }
}
```

