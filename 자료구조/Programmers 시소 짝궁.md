# Programmers [시소 짝궁](https://school.programmers.co.kr/learn/courses/30/lessons/152996)

### 난이도 ★★

---

#### 접근 방식

> 주어진 `weights`를 먼저 정렬합니다.
>
> `Map`을 활용하여 중복체크를 하여 중복된 값만 체크해줍니다.
>
> 주어진 문제를 살펴보면 비교하는 두 값이 `2`배 이상 차이나면 같은 값이 나올 수 있는 경우가 없습니다.
>
> 따라서, `시소 짝궁`을 이루려면 `값이 같거나`, `가벼운 값 * 2 == 무거운 값` , `가벼운 값 * 3 == 무거운 값 * 2`, `가벼운 값 * 4 == 무거운 값 * 3` 의 조건들만 `시소 짝궁`이라고 할 수 있습니다.
>
> 따라서, 이와 같은 조건을 수행하여 `double`형으로 값을 넣고 `map`에 넣어 비교하면 해결할 수 있습니다.

#### 풀이

```java
import java.util.*;
class Solution {
    public long solution(int[] weights) {
    	long answer = 0;
        Arrays.sort(weights);
        Map<Double, Integer> map = new HashMap<>();
        for(int i : weights) {
    		double a = i*1.0;
    		double b = (i*2.0)/3.0;
    		double c = (i*1.0)/2.0;
    		double d = (i*3.0)/4.0;
    		if(map.containsKey(a)) answer += map.get(a);
    		if(map.containsKey(b)) answer += map.get(b);
    		if(map.containsKey(c)) answer += map.get(c);
    		if(map.containsKey(d)) answer += map.get(d);
    		map.put((i*1.0), map.getOrDefault((i*1.0), 0)+1);
        }
        
        return answer;
    }
}
```

