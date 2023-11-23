# Programmers [숫자 문자열과 영단어](https://school.programmers.co.kr/learn/courses/30/lessons/81301)

### 난이도 ★

---

#### 접근 방식

> 주어진 조건을 구현하고 `HashMap`의 `Value`값을 기준으로 `람다식 정렬`을 활용해 `정렬`하였습니다. 그리고 `list`에 담고 다시 `배열`에 넣어주어 값을 출력했습니다.

#### 풀이

```java
import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int len = stages.length;
        HashMap<Integer, Double> hm = new HashMap<>();
        int allCnt = 0;
        for (int i = 1; i<= N; i++){
            int cnt = 0;
            for (int stage : stages) {
                if (stage == i) {
                    cnt++;
                }
            }
            if (cnt == 0) hm.put(i, 0.0);
            else hm.put(i, (double) cnt / (len - allCnt) );
            allCnt += cnt;  
        }
        List<Integer> list = new ArrayList<>(hm.keySet());
        list.sort((s1, s2) -> hm.get(s2).compareTo(hm.get(s1)));
        int [] answer = new int[N];
        int count = 0;
        for (int num : list) {
            answer[count] = num;
            count++;
        }
        return answer;
    }
}
```

