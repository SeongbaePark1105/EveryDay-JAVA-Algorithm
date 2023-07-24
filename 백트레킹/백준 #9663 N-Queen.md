백준 #9663 [N-Queen](https://www.acmicpc.net/problem/9663)
=============
### 난이도 `골드 4 ` `백트래킹` `브루트포스 알고리즘`

------

#### 접근 방식

> 1차원 배열로 해결하였고 인덱스를 `열`, 인덱스의 값을 `행`으로 이용하였습니다.
>
> 각 행별로 놓을 수 있는 위치에 있을 때 재귀호출을 해주고, 모두 배치 되었을 시에서 `count`값을 증가시켜서 경우의 수를 찾아냈습니다.
>
> 체크 조건은 열의 행과 `i열`의 행이 일치할경우 `false`를 리턴해주었고
>
> 대각선상에 놓여있는 경우는 열의 차와 행의 차가 같을 경우인데 같을 경우에 `false`를 리턴해주었습니다.

```java
package bk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bk_9663 {
  static int N;
  static int [] arr;
  static int count;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    arr = new int[N];
    count = 0;
    nQueen(0);
    System.out.println(count);
  }
  private static void nQueen(int depth){
    if (depth == N){
      count++;
      return ;
    }
    for (int i = 0; i < N; i++){
      arr[depth] = i;
      if (checkQueen(depth)){
        nQueen(depth+1);
      }
    }
  }

  private static boolean checkQueen(int col){
    for (int i = 0; i < col; i++){
      if (arr[i] == arr[col]){
        return false;
      } else if(Math.abs(col - i) == Math.abs(arr[col] - arr[i])){
        return false;
      }
    }
    return true;
  }
}
```
