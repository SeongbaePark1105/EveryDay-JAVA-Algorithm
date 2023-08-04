# Softeer [GBC](https://softeer.ai/practice/info.do?idx=1&eid=584&sw_prbl_sbms_sn=236420)

### 난이도 ★★

---

#### 접근 방식

> 구현 문제입니다.
>
> 구현할 때 테스트 주행 거리를 벗어났을 때 그 기록을 가진채로 다음 구간이랑 비교하는 게 포인트였습니다.

#### 풀이

```java
import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int [] road = new int[N];
        int [] roadSpeed = new int[N];
        int [] run = new int[M];
        int [] runSpeed = new int[M];
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            road[i] = Integer.parseInt(st.nextToken());
            roadSpeed[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0 ; i < M; i++){
            st = new StringTokenizer(br.readLine());
            run[i] = Integer.parseInt(st.nextToken());
            runSpeed[i] = Integer.parseInt(st.nextToken());
        }
        int idx = 0;
        int answer = 0;
        for (int i = 0; i < N; i++){
            for (int j = idx; j < M; j++){
                if (road[i] < run[j]){ 
                    run[j] -= road[i]; 
                    if ( ( runSpeed[j] - roadSpeed[i] ) > 0 ){ 
                        answer = Math.max(answer, runSpeed[j] - roadSpeed[i]); 
                    }
                    break;
                } else if (road[i] > run[j]) { 
                    road[i] -= run[j]; 
                    if ( (runSpeed[j] - roadSpeed[i] ) > 0 ){ 
                        answer = Math.max(answer, runSpeed[j] - roadSpeed[i]);
                    }
                    idx++;
                } else {
                    if ( (runSpeed[j] - roadSpeed[i]) > 0){
                        answer = Math.max(answer, runSpeed[j] - roadSpeed[i]);
                    }
                    idx++;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
```

