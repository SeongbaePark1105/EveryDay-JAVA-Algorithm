# Softeer [8단 변속기](https://softeer.ai/practice/info.do?idx=1&eid=408&sw_prbl_sbms_sn=129305)

### 난이도 ★★

---

#### 접근 방식

> 배열을 3개 만들어서 각 배열로 저장하고 비교할 배열, 오름차순 배열, 내림차순 배열로 나눕니다.
>
> 내림차순 배열은 Integer로 활용해야 람다식으로 짧게 사용할 수 있습니다.
>
> 그리고 각 배열끼리 비교 후 변속이 어떻게 되었는 지 답안으로 출력합니다.

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
        int arr[] = new int[8];
        int asc[] = new int[8];
        Integer des[] = new Integer[8];
        for (int i = 0; i < 8; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            asc[i] = arr[i];
            des[i] = arr[i];
        }
        Arrays.sort(asc);
        Arrays.sort(des, (i1, i2) -> i2 - i1);
        int acnt = 0;
        int dcnt = 0;
        for (int i= 0; i<8; i++){
            if (arr[i] == asc[i]){
                acnt++;
            }
            if (arr[i] == des[i]){
                dcnt++;
            }
        }
        if (acnt == 8){
            System.out.println("ascending");
        } else if (dcnt == 8){
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }
    }
}
```

