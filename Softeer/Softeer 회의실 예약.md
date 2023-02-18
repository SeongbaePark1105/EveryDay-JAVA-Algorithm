# Softeer [회의실 예약](https://softeer.ai/practice/info.do?idx=1&eid=626)

### 난이도 ★★

---

#### 접근 방식

> 구현 문제이다.
>
> boolean을 이용해 예약된 시간인지 아닌 지 확인하구 check boolean을 이용하여 시작 시간인지 종료 시간인지 구분을 하였다.
>
> 종료 시간이 18시면 for문으로 돌렸을 경우 배열에 들어가 있지가 않기 때문에 따로 조건을 만들어서 해결해주었다.
>
> Queue에 담고 각 회의실마다 이용할 수 있는 시간들을 기록하였고 없으면 없다고 출력해주고 있으면 몇 타임 이용할 수 있는 지 몇시부터 몇시까지인지 `StringBuiler`에 담아서 출력해주었다.

#### 풀이

```java
import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (int i = 0 ; i < N; i++){
            list.add(br.readLine());
        }
        Collections.sort(list);
        for (int i = 0; i < N; i++){
            map.put(list.get(i), i);
        }
        boolean [][] visited = new boolean[N][9];
        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int roomName = map.get(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            for (int j = start; j < end; j ++){
                visited[roomName][j - 9] = true;
            }
        }
        for (int i = 0; i < N; i++){
                sb.append("Room " + list.get(i) + ":\n");
                boolean check = true;
                Queue<int[]> checkList = new LinkedList<>();
                int startTime = 0;
                int endTime = 0;
            for (int k = 0; k < 9; k++){
                if(!visited[i][k] && check){
                    startTime = k+9;
                    check = false;
                } else if (visited[i][k] && !check){
                    check = true;
                    endTime = k+9;
                }
                if (k == 8 && !check){
                    check = true;
                    endTime= k +10;
                }
                if (startTime != 0 && endTime != 0){
                    checkList.add(new int[]{startTime, endTime});
                    startTime = 0;
                    endTime = 0;
                }
            }
            if(checkList.size() == 0){
                sb.append("Not available\n");
            } else {
                sb.append(checkList.size() +" available:\n");
                while(!checkList.isEmpty()){
                    int startT = checkList.peek()[0];
                    int endT = checkList.peek()[1];
                    checkList.poll();
                    if(startT == 9){
                        sb.append("09"+"-"+endT+"\n");
                    } else{
                        sb.append(startT+"-"+endT+"\n");
                    }
                }
            }
            if(i != N-1){
                sb.append("-----\n");
            }
        }
        System.out.println(sb);
    }
}
```

