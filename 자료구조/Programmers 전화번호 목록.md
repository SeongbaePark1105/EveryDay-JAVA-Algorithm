# Programmers [전화번호 목록](https://school.programmers.co.kr/learn/courses/30/lessons/42577)

### 난이도 ★★

---

#### 문제 설명

> 전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
> 전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.
>
> - 구조대 : 119
> - 박준영 : 97 674 223
> - 지영석 : 11 9552 4421
>
> 전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때, 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.

#### 제한사항

>- phone_book의 길이는 1 이상 1,000,000 이하입니다.
>  - 각 전화번호의 길이는 1 이상 20 이하입니다.
>  - 같은 전화번호가 중복해서 들어있지 않습니다.

#### 입출력 예

> | phone_book                        | return |
> | --------------------------------- | ------ |
> | ["119", "97674223", "1195524421"] | false  |
> | ["123","456","789"]               | true   |



#### 접근 방식

> 두 가지의 방법으로 해결하였습니다.
>
> `java`의 `library` `startsWith`을 이용해 비교할 문장의 시작이 비교할 단어가 들어가있는 지 체크할 수 있습니다.
>
> 정렬을 해서 풀게 되면 효율성을 통과할 수 있습니다.
>
> 아니면 `HashMap`을 사용하여 `map`에 저장을 한 후 모든 전화번호를 체크하면 됩니다.

#### 풀이

```java
import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        for(int i=0;i<phone_book.length-1;i++){
            if(phone_book[i+1].startsWith(phone_book[i])){
                answer = false;
                break;
            }
        }
        return answer;
        /** HashMap을 사용한 방법
        Map<String, Integer> map = new HashMap<>();

        // 1. 모든 전화번호를 HashMap에 넣는다.
        for (int i = 0; i < phone_book.length; i++) 
            map.put(phone_book[i], i);
        
        // 2. 모든 전화번호의 substring이 HashMap에 존재하는지 확인한다.
        for (int i = 0; i < phone_book.length; i++)
            for (int j = 0; j < phone_book[i].length(); j++)
                if (map.containsKey(phone_ook[i].substring(0, j)))
                    return false;

        return true;
        **/
    }
}
```

