# Programmers [방문 길이](https://school.programmers.co.kr/learn/courses/30/lessons/49994)

### 난이도 ★★

---

#### 접근 방식

> 방문 배열을 사용하는데 4방향에서 온 것으로 방문처리를 해줘야합니다.
>
> 또한, 왕복처리로 방문 처리를 해주었습니다.

#### 풀이

```java
import java.util.*;
class Solution {
    static int [] dy = {-1, 1, 0, 0};
    static int [] dx = {0, 0, 1, -1};
    public int solution(String dirs) {
        int answer = 0;
        int [][] arr = new int[11][11];
        boolean [][][] visited = new boolean[11][11][4]; // U : 0 , D : 1, R : 2, L : 3
        int y = 5;
        int x = 5;
        for (int i = 0; i < dirs.length(); i++){
            int d = 0;
            char ch = dirs.charAt(i);
            if (ch == 'U')  d = 0;
            else if (ch == 'D') d = 1; 
            else if (ch == 'R') d = 2;
            else d = 3;
            int ny = y + dy[d];
            int nx = x + dx[d];
            if (ny < 0 || nx < 0 || ny >= 11 || nx >= 11) continue;
            if (!visited[ny][nx][d]){
                visited[ny][nx][d] = true;
                if (d % 2 == 0) d += 1;
                else d -= 1;
                visited[y][x][d] = true;
                answer++;
            }
            y = ny;
            x = nx;
        }
        return answer;
    }
}
```

