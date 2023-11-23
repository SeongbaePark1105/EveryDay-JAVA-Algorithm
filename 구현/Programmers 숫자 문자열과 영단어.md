# Programmers [숫자 문자열과 영단어](https://school.programmers.co.kr/learn/courses/30/lessons/81301)

### 난이도 ★

---

#### 접근 방식

> 문자열에 영어로 된 숫자가 있는 지 `contains`로 확인하여 `replace`로 간단하게 치환하여 해결하였습니다.

#### 풀이

```java
class Solution {
    public int solution(String s) {
        String[] arr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i = 0; i < 10; i++){
            if (s.contains(arr[i])) s = s.replace(arr[i], Integer.toString(i));
        }
        return Integer.parseInt(s);
    }
}
```

