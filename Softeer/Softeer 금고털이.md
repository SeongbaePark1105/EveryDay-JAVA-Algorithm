# Softeer [금고털이](https://softeer.ai/practice/info.do?idx=1&eid=395&sw_prbl_sbms_sn=128660)

### 난이도 ★★

---

#### 접근 방식

> 기존 정렬로는 안되는 거 같아서 우선순위 큐를 이용하였습니다.

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
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        PriorityQueue<Jewel> queue = new PriorityQueue<Jewel>();
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            queue.offer(new Jewel(weight, price));
        }
        int result = 0;
        
        while(!queue.isEmpty()){
        	Jewel jewel = queue.poll();
            if(W < jewel.weight){
            	result+= W * jewel.price;
                break;
            } else {
            	result+=jewel.weight * jewel.price;
                W-=jewel.weight;
            }
        }
        System.out.print(result + "");
    }
     public static class Jewel implements Comparable<Jewel>{
     	public int weight;
        public int price;
        public Jewel(int weight, int price){
        	this.weight = weight;
        	this.price = price;
        }
     
     	@Override
        public int compareTo(Jewel jewel){
        	return this.price < jewel.price ? 1 : -1;
        }
     }
}
```

