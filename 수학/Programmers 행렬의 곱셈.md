# Programmers [행렬의 곱셈](https://school.programmers.co.kr/learn/courses/30/lessons/12949)

### 난이도 ★★

---

#### 접근 방식

> 행렬의 곱셈을 이해하고 있으면 `3중 반복문`으로 해결할 수 있습니다.

#### 풀이

```java
class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int [][] arr = new int[arr1.length][arr2[0].length];
        for (int i = 0; i < arr1.length; i++){
            for (int j = 0; j < arr2[0].length; j++){
                for (int k = 0; k < arr2.length; k++){
                    arr[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return arr;
    }
}
```

