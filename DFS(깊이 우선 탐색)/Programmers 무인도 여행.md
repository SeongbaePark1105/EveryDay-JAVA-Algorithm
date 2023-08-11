# Programmers [무인도 여행](https://school.programmers.co.kr/learn/courses/30/lessons/154540)

### 난이도 ★★

---

#### 문제 설명

> 메리는 여름을 맞아 무인도로 여행을 가기 위해 지도를 보고 있습니다. 지도에는 바다와 무인도들에 대한 정보가 표시돼 있습니다. 지도는 1 x 1크기의 사각형들로 이루어진 직사각형 격자 형태이며, 격자의 각 칸에는 'X' 또는 1에서 9 사이의 자연수가 적혀있습니다. 지도의 'X'는 바다를 나타내며, 숫자는 무인도를 나타냅니다. 이때, 상, 하, 좌, 우로 연결되는 땅들은 하나의 무인도를 이룹니다. 지도의 각 칸에 적힌 숫자는 식량을 나타내는데, 상, 하, 좌, 우로 연결되는 칸에 적힌 숫자를 모두 합한 값은 해당 무인도에서 최대 며칠동안 머물 수 있는지를 나타냅니다. 어떤 섬으로 놀러 갈지 못 정한 메리는 우선 각 섬에서 최대 며칠씩 머물 수 있는지 알아본 후 놀러갈 섬을 결정하려 합니다.
>
> 지도를 나타내는 문자열 배열 `maps`가 매개변수로 주어질 때, 각 섬에서 최대 며칠씩 머무를 수 있는지 배열에 오름차순으로 담아 return 하는 solution 함수를 완성해주세요. 만약 지낼 수 있는 무인도가 없다면 -1을 배열에 담아 return 해주세요.

#### 제한사항

>- 3 ≤ `maps`의 길이 ≤ 100
>
>  - 3 ≤ `maps[i]`의 길이 ≤ 100
>
>  - `maps[i]`는 'X' 또는 1 과 9 사이의 자연수로 이루어진 문자열입니다.
>  - 지도는 직사각형 형태입니다.

#### 입출력 예

>| maps                               | result     |
>| ---------------------------------- | ---------- |
>| ["X591X","X1X5X","X231X", "1XXX1"] | [1, 1, 27] |
>| ["XXX","XXX","XXX"]                | [-1]       |

#### 입출력 예 설명

>입출력 예 #1
>
>위 문자열은 다음과 같은 지도를 나타냅니다.
>
>![image1](https://user-images.githubusercontent.com/62426665/206862823-4633fbf1-c075-4d35-b577-26f504dcd332.png)
>
>연결된 땅들의 값을 합치면 다음과 같으며
>
>![image2](https://user-images.githubusercontent.com/62426665/209070615-ae568f20-cf06-4f88-8d4f-8e9861af2d36.png)
>
>이를 오름차순으로 정렬하면 [1, 1, 27]이 됩니다.
>
>입출력 예 #2
>
>위 문자열은 다음과 같은 지도를 나타냅니다.
>
>![image3](https://user-images.githubusercontent.com/62426665/206863265-0a371c69-d4b5-411a-972f-bdc36b90c917.png)
>
>섬이 존재하지 않기 때문에 -1을 배열에 담아 반환합니다.

#### 접근 방식

> 방문 체크를 이용하여 방문하지 않은 곳들만 `깊이 너비 탐색`을 돌려서 방문할 수 있는 곳의 값들을 더해주고 리스트에 넣어주었습니다.
>
> 그리고 `char`자료형을 `Character.getNumericValue()`를 이용하여 `int`형으로 변경하였습니다.
>
> 풀이에 보면 `list.toArray`를 이용하여 리스트를 배열로 변경하였는데 참조형타입에서만 사용할 수 있습니다.

#### 풀이

```java
import java.util.*;
class Solution {
    char [][] arr;
    boolean  [][] visited;
    int num = 0;
    int [] dy = {-1, 1, 0, 0};
    int [] dx = {0, 0, -1, 1};
    public Integer[] solution(String[] maps) {
        int len = maps.length;
        int len2 = maps[0].length();
        arr = new char[len][len2];
        visited = new boolean[len][len2];
        for (int i = 0; i < len; i++){
            for(int j = 0; j < len2; j++){
                arr[i][j] = maps[i].charAt(j);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++){
            for (int j = 0; j < len2; j++){
                if (arr[i][j] != 'X' && !visited[i][j]){
                    visited[i][j] = true;
                    num = Character.getNumericValue(arr[i][j]);
                    dfs(i, j, len, len2);
                    list.add(num);
                    num = 0;
                }
            }
        }
        Integer [] answer;
        if (list.size() != 0){
            answer = new Integer[list.size()];
            list.toArray(answer);
            Arrays.sort(answer);  
        } else {
            list.add(-1);
            answer = new Integer[list.size()];
            list.toArray(answer);
        }

        return answer;
    }
    void dfs(int y, int x, int col, int row){
        for (int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= col || nx >= row || visited[ny][nx] || arr[ny][nx] == 'X') continue;
            num += Character.getNumericValue(arr[ny][nx]);
            visited[ny][nx] = true;
            dfs(ny, nx, col, row);
        }
    }
}
```

