# Softeer [성적 평가](https://softeer.ai/practice/info.do?idx=1&eid=1309&sw_prbl_sbms_sn=130007)

### 난이도 ★★★

---

#### 접근 방식

> 우선순위 큐는 점수를 기준으로 내림차순 이기 때문에 높은 점수 순으로 탐색합니다.
>
> 점수가 동일하면 같은 등수 값을 주고 다르면 +1을 더해서 등수를 매겨줍니다.
>
> 전체 등수는 점수 총합을 기준으로 계산해줍니다.

#### 풀이

```java
import java.util.*;
import java.io.*;


public class Main
{
    static int N;
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int[] totalPoint = new int[N];
        for (int TC = 0; TC < 3; TC++){
            PriorityQueue<Pair> pq = new PriorityQueue<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++){
                int point = Integer.parseInt(st.nextToken());
                pq.offer(new Pair(i, point));
                totalPoint[i] += point;
            }
            int[] grades = getGrade(pq);
            for(int i = 0 ; i < N; i++){
                System.out.print(grades[i] + " ");
            }
            System.out.println();
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++){
            pq.offer(new Pair(i, totalPoint[i]));
        }
        int [] totalGrades = getGrade(pq);
        for (int i = 0; i < N; i++){
            System.out.print(totalGrades[i] + " ");
        }
        System.out.println();

    }
    
    static int[] getGrade(PriorityQueue<Pair> pq){
        int[] grades = new int[N];
        Pair first = pq.poll();
        int grade = 1;
        int prevPoint = first.point;
        int sameCount = 1;

        grades[first.idx] = grade;
        while(!pq.isEmpty()){
			Pair pair = pq.poll();

			if(prevPoint != pair.point){
				grade += sameCount;
				sameCount = 1;
			}
			else{
				sameCount++;
			}

			grades[pair.idx] = grade;
			prevPoint = pair.point;
		}

		return grades;
    }

    static class Pair implements Comparable<Pair>{
        int idx;
        int point;
        public Pair(int idx, int point){
            this.idx = idx;
            this.point = point;
        }

        @Override
        public int compareTo(Pair p){
            return p.point - this.point;
        }
    }
}
```

