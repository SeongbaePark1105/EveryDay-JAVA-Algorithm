# Programmers [연속 부분 수열 합의 개수](https://school.programmers.co.kr/learn/courses/30/lessons/131701)

### 난이도 ★★

---

#### 접근 방식

> 처음에는 `for문`을 3개 사용해서 풀었습니다.
>
> `size` 반복문은 길이가 `size`인 연속 부분 수열을 만들기 위한 반복문이고
>
> `i` 반복문은 `elements`배열의 `index`값이고
>
> `j` 반복문은 `size`길이 만큼 배열에서 만들 수 있는 값을 만드는 반복문입니다.
>
> 하지만, 다른 방법을 이용하여 반복문을 2개로 줄일 수 있었습니다.
>
> `반복문 2개`를 이용한 방법은 각 배열의 인덱스부터 만들 수 있는 자릿수를 다 만드는 것입니다.
>
> 이렇게 하면 각 인덱스에서 시작해서 만들수 있는 길이만큼의 값을 `Set`에 넣을 수 있습니다.

#### 풀이

```java
import java.util.*;
class Solution {
    public int solution(int[] elements) {
        Set<Integer> sums = new HashSet<>();

        int len = elements.length;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = 0; j < len; j++) {
                sum += elements[(i+j) % len];
                sums.add(sum);
            }
        }
		/*
		for (int size = 1; size<= elements.length; size++){
            for (int i = 0; i < elements.length; i++){
                int sum = 0;
                for (int j = i; j < i + size; j++){
                    sum += elements[j % elements.length];
                }
                set.add(sum);
            }
        }
		*/
        return sums.size();
    }
}
```

