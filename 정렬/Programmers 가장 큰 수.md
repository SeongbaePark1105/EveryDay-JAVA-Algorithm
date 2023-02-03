# Programmers [가장 큰 수 ](https://school.programmers.co.kr/learn/courses/30/lessons/42746)

### 난이도 ★★

---

#### 문제 설명

> 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
>
> 예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.
> 
> 0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.

#### 제한사항

>- numbers의 길이는 1 이상 100,000 이하입니다.
>- numbers의 원소는 0 이상 1,000 이하입니다.
>- 정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.

#### 입출력 예

> | numbers           | return    |
> | ----------------- | --------- |
> | [6, 10, 2]        | "6210"    |
> | [3, 30, 34, 5, 9] | "9534330" |

#### 접근 방식

> String 형으로 형변환을 먼저 해줍니다.
>
> 그 다음 Arrays.sort() 내부에서 Comparator의 compareTo()를 이용하는 방식을 이용하였습니ㅣ다.

#### 풀이

```java
import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];

        for (int i = 0; i < arr.length; i++) {
            // arr[i] = String.valueOf(numbers[i]);
            arr[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        if (arr[0].equals("0")) {
           return "0";
        }

        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            answer.append(arr[i]);
        }


        return answer.toString();

    }
}
```

