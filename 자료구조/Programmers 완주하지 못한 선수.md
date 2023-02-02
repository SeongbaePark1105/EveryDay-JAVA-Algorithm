# Programmers [완주하지 못한 선수](https://school.programmers.co.kr/learn/courses/30/lessons/42576)

### 난이도 ★

---

#### 문제 설명

> 수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
>
> 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.



#### 제한사항

>- 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
>- completion의 길이는 participant의 길이보다 1 작습니다.
>- 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
>- 참가자 중에는 동명이인이 있을 수 있습니다.



#### 입출력 예

> | participant                                       | completion                               |
> | ------------------------------------------------- | ---------------------------------------- |
> | ["leo", "kiki", "eden"]                           | ["eden", "kiki"]                         |
> | ["marina", "josipa", "nikola", "vinko", "filipa"] | ["josipa", "filipa", "marina", "nikola"] |



#### 접근 방식

> `HashMap`을 이용하여 풀었고 `getOrDefault`를 사용하여 값이 있으면 가져오고 없으면 0으로 기본 값을 설정해주고 +1을 해줍니다.
>
> 다음에 완주한 선수를 for문으로 돌려서 완주한 선수들은 -1을 해줘서 값을 0으로 만듭니다.
>
> 다음 `keySet()`을 이용하여 `value`를 가져오고 0이 아닌 선수를 뽑아냅니다.

#### 풀이

```java
import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i = 0; i < participant.length; i++){
            hm.put(participant[i], hm.getOrDefault(participant[i], 0) +1);
        }
        for(int i = 0; i < completion.length; i++){
            hm.put(completion[i], hm.get(completion[i]) -1);
        }
        for(String k : hm.keySet()){
            if (hm.get(k) != 0){
                answer = k;
                break;
            }
        }
        return answer;
    }
}
```

