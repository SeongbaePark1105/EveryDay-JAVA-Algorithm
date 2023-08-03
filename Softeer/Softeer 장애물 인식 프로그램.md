# Softeer [장애물 인식 프로그램](https://softeer.ai/practice/info.do?idx=1&eid=409)

### 난이도 ★★

---

#### 접근 방식

> `DFS`방식으로 접근하여 해결하였습니다.
>
> 방문 배열을 이용하여 방문한 곳은 `true` 값으로 처리해주었고 `list`에 값을 담아 사이즈와 정렬 후 값을 출력해주었습니다.

#### 풀이

```java
import java.util.*;
import java.io.*;

public class Main {
  static int N;
  static int [][] arr;
  static boolean [][] visited;
  static int count;
  static int [] dy = {-1, 1, 0, 0};
  static int [] dx = {0, 0, -1, 1};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    arr = new int[N][N];
    visited = new boolean[N][N];
    count = 1;
    List<Integer> result = new ArrayList<>();


    for (int i = 0; i < N; i++){
      String str = br.readLine();
      for (int j = 0; j < N; j++){
        arr[i][j] = Character.getNumericValue(str.charAt(j));
      }
    }
    for (int i = 0; i < N; i++){
      for (int j = 0; j < N; j++){
        if (!visited[i][j] && arr[i][j] == 1){
          visited[i][j] = true;
          dfs(i, j);
          result.add(count);
          count = 1;
        }
      }
    }
    System.out.println(result.size());
    Collections.sort(result);
    for (int num : result) System.out.println(num);
  }
  static void dfs(int y, int x){
    for (int i = 0; i < 4; i++){
      int ny = dy[i] + y;
      int nx = dx[i] + x;
      if (ny < 0 || nx < 0 || ny >= N || nx >= N || visited[ny][nx] || arr[ny][nx] != 1) continue;
      visited[ny][nx] = true;
      count++;
      dfs(ny, nx);
    }
  }
}

```

