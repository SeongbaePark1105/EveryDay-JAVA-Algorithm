# Programmers [리코쳇 로봇](https://school.programmers.co.kr/learn/courses/30/lessons/169199)

### 난이도 ★★

---

#### 문제 설명

> 리코쳇 로봇이라는 보드게임이 있습니다.
>
> 이 보드게임은 격자모양 게임판 위에서 말을 움직이는 게임으로, 시작 위치에서 목표 위치까지 최소 몇 번만에 도달할 수 있는지 말하는 게임입니다.
>
> 이 게임에서 말의 움직임은 상, 하, 좌, 우 4방향 중 하나를 선택해서 게임판 위의 장애물이나 맨 끝에 부딪힐 때까지 미끄러져 이동하는 것을 한 번의 이동으로 칩니다.
>
> 다음은 보드게임판을 나타낸 예시입니다.
>
> ```
> ...D..R
> .D.G...
> ....D.D
> D....D.
> ..D....
> ```
>
> 여기서 "."은 빈 공간을, "R"은 로봇의 처음 위치를, "D"는 장애물의 위치를, "G"는 목표지점을 나타냅니다.
> 위 예시에서는 "R" 위치에서 아래, 왼쪽, 위, 왼쪽, 아래, 오른쪽, 위 순서로 움직이면 7번 만에 "G" 위치에 멈춰 설 수 있으며, 이것이 최소 움직임 중 하나입니다.
>
> 게임판의 상태를 나타내는 문자열 배열 `board`가 주어졌을 때, 말이 목표위치에 도달하는데 최소 몇 번 이동해야 하는지 return 하는 solution함수를 완성하세요. 만약 목표위치에 도달할 수 없다면 -1을 return 해주세요.

#### 제한사항

>- 3 ≤ `board`의 길이 ≤ 100
>  - 3 ≤ `board`의 원소의 길이 ≤ 100
>  - `board`의 원소의 길이는 모두 동일합니다.
>  - 문자열은 ".", "D", "R", "G"로만 구성되어 있으며 각각 빈 공간, 장애물, 로봇의 처음 위치, 목표 지점을 나타냅니다.
>  - "R"과 "G"는 한 번씩 등장합니다.

#### 입출력 예

> | board                                                   | result |
> | ------------------------------------------------------- | ------ |
> | ["...D..R", ".D.G...", "....D.D", "D....D.", "..D...."] | 7      |
> | [".D.R", "....", ".G..", "...D"]                        | -1     |

#### 입출력 예 설명

> 입출력 예 #1
>
> - 문제 설명의 예시와 같습니다.
>
> 입출력 예 #2
> 
> ```
> .D.R
> ....
> .G..
> ...D
> ```
>
> - "R" 위치에 있는 말을 어떻게 움직여도 "G" 에 도달시킬 수 없습니다.
>- 따라서 -1을 return 합니다.

#### 접근 방식

> 정석적인 `bfs` 방법과 유사하지만 장애물이나 범위를 벗어나기 전까지 계속 값이 증가한다는게 포인트입니다.
>
> `while`문을 이용하여 계속 값을 검사하여 장애물을 만나는 지 값을 벗어나는 값이 되는 지 체크합니다.
>
> `while`문을 나오게 되면 값이 벗어나거나 장애물을 만나는 것이기 때문에 `ny`값과 `nx`값에서 더했던 값을 빼줍니다.
>
> 그리고 방문했던 곳을 체크 해주는 곳은 자기가 멈춘 곳에서만 방문 체크를 합니다.

#### 풀이

```java
import java.util.*;
class Solution {
    char [][] arr;
    int len;
    int len2;
    boolean [][] visited;
    Queue<int []> queue = new LinkedList<>();
    int [] dy = { -1, 1, 0, 0};
    int [] dx = { 0, 0, -1, 1};
    public int solution(String[] board) {
        int answer = 0;
        len = board.length;
        len2 = board[0].length();
        arr = new char[len][len2];
        visited = new boolean[len][len2];
        for (int i = 0; i < len; i++){
            for (int j = 0; j < len2; j++){
                arr[i][j] = board[i].charAt(j);
                if (arr[i][j] == 'R') queue.add(new int[]{i, j, 0});
            }
        }
        return bfs();
    }
    int bfs(){
        while(!queue.isEmpty()){           
            int y = queue.peek()[0];
            int x = queue.peek()[1];
            int cnt = queue.peek()[2];
            visited[y][x] = true;
            queue.poll();
            if (arr[y][x] == 'G') return cnt;
            for (int i = 0; i < 4; i++){
                int ny = y;
                int nx = x;
                while(inRange(ny, nx) && arr[ny][nx] != 'D'){
                    ny += dy[i];
                    nx += dx[i];
                }
                ny -= dy[i];
                nx -= dx[i];
                if (visited[ny][nx] || (y == ny && x == nx)) continue;
                visited[ny][nx] = true;
                queue.add(new int[] {ny, nx, cnt + 1});
            }
        }
        return -1;
    }
    boolean inRange(int y, int x){
        if (y >= 0 && x >= 0 && y < len && x < len2) return true;
        else return false;
    }
}
```

