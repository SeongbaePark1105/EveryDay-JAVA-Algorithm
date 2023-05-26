# Programmers [베스트앨범](https://school.programmers.co.kr/learn/courses/30/lessons/42579)

### 난이도 ★★★

---

#### 문제 설명

> 스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.
>
> 1. 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
>2. 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
> 3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
> 
> 노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.

#### 제한사항

>- genres[i]는 고유번호가 i인 노래의 장르입니다.
>- plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
>- genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
>- 장르 종류는 100개 미만입니다.
>- 장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
>- 모든 장르는 재생된 횟수가 다릅니다.

#### 입출력 예

> | genres                                          | plays                      | return       |
> | ----------------------------------------------- | -------------------------- | ------------ |
> | ["classic", "pop", "classic", "classic", "pop"] | [500, 600, 150, 800, 2500] | [4, 1, 3, 0] |

#### 입출력 예 설명

>classic 장르는 1,450회 재생되었으며, classic 노래는 다음과 같습니다.
>
>- 고유 번호 3: 800회 재생
>- 고유 번호 0: 500회 재생
>- 고유 번호 2: 150회 재생
>
>pop 장르는 3,100회 재생되었으며, pop 노래는 다음과 같습니다.
>
>- 고유 번호 4: 2,500회 재생
>- 고유 번호 1: 600회 재생
>
>따라서 pop 장르의 [4, 1]번 노래를 먼저, classic 장르의 [3, 0]번 노래를 그다음에 수록합니다.
>
>- 장르 별로 가장 많이 재생된 노래를 최대 두 개까지 모아 베스트 앨범을 출시하므로 2번 노래는 수록되지 않습니다.

#### 접근 방식

> `HaspMap`에 장르에 대한 재생 횟수를 정리해주고 그것을 `list`에 장르를 담아줍니다.
>
> 그리고 `list`를 람다식 정렬을 이용해 `HashMap`의 `value`값을 기준으로 `hs.get(o2) - hs.get(o1)`을 사용하여 내림차순으로 정렬해줍니다.
>
> 그 뒤에는 반복문을 이용하여 각 장르에 대해 첫 번째로 많이 들을 노래 인덱스 번호와 두 번째 인덱스 번호를 구합니다.
>
> - 여기서 두 번째 인덱스 값은 존재할 수 도 있고 존재하지 않을 수도 있습니다.
>
> 모두 구한 후에 배열에 담아 출력해줍니다.

#### 풀이

```java
import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> hs = new HashMap<>();
        for (int i = 0 ; i < genres.length; i++){
            hs.put(genres[i], hs.getOrDefault(genres[i], 0) + plays[i]);
        }
        ArrayList<String> gerne = new ArrayList<>();
        for (String str : hs.keySet()){
            gerne.add(str);
        }
        Collections.sort(gerne, (o1, o2) -> hs.get(o2) - hs.get(o1)); // value 값으로 내림차순
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < gerne.size(); i++){
            String g = gerne.get(i);
            int max = 0;
            int firstIdx = -1;
            for (int j = 0; j < genres.length; j++){
                if (g.equals(genres[j]) && max < plays[j]){
                    max = plays[j];
                    firstIdx = j;
                }
            }
            max = 0;
            int secondIdx = -1;
            for (int j = 0; j < genres.length; j++){
                if (g.equals(genres[j]) && max < plays[j] && j != firstIdx){
                    max = plays[j];
                    secondIdx = j;
                }
            }
            list.add(firstIdx);
            if (secondIdx >= 0){
                list.add(secondIdx);
            }
        }
        int [] answer = new int [list.size()];
        for (int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
```

