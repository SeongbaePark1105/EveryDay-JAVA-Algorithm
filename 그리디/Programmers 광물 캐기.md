# Programmers [광물캐기](https://school.programmers.co.kr/learn/courses/30/lessons/172927)

### 난이도 ★★

---

#### 접근 방식

> `그리디`로 풀어야 합니다.
>
> 문제를 읽어보면 `다이아`, `철`, `곡궹이`순으로 광물을 캐는 게 제일 피로도가 적게듭니다.
>
> `section`이라는 배열에 광물들을 각 곡궹이로 캘 경우의 값들을 넣어줍니다.
>
> 피로도는 `돌 곡궹이`로 캤을 경우 가장 피로도가 큽니다.
>
> 따라서, `section`배열을 `돌 곡궹이`로 캤을 경우로 `내림차순`정렬을 합니다.
>
> 그 다음에는 주어진 곡궹이 수로 해당 광물을 캐는 반복문을 만들었고 각 곡궹이들을 다 썼으면 다음 곡궹이를 쓸 수 있도록 구현하였고 피로도 값을 계속 증가시켜 값을 구할 수 있었습니다.

#### 풀이

```java
import java.util.*;
class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int picksCount = picks[0] + picks[1] + picks[2];
        // 0 : 다이아, 1 : 철, 2 : 돌
        int [][] section = new int[minerals.length / 5 + 1][3];
        for (int i = 0; i < minerals.length && picksCount > 0; i++){
            if (minerals[i].equals("diamond")){
                section[i/5][0] += 1;
                section[i/5][1] += 5;
                section[i/5][2] += 25;
            } else if (minerals[i].equals("iron")){
                section[i/5][0] += 1;
                section[i/5][1] += 1;
                section[i/5][2] += 5;
            } else {
                section[i/5][0] += 1;
                section[i/5][1] += 1;
                section[i/5][2] += 1;
            }
            if ( i % 5 == 4) picksCount--;
        }
        Arrays.sort(section, ((o1, o2) -> (o2[2] - o1[2])));
        int i, pick;
        for (i = 0, pick = 0; i < section.length; i++){
            while(pick < 3 && picks[pick] == 0) pick++;
            if (pick == 3) break;
            picks[pick]--;
            answer += section[i][pick];
        }
        return answer;
    }
}
```

