# Programmers [월별 잡은 물고기 수 구하기](https://school.programmers.co.kr/learn/courses/30/lessons/293260)

### 난이도 ★★

---

#### 접근 방식

> `group by`를 사용하여 해결하였고 날짜 데이터 타입에서 `MONTH`를 사용하면 날짜에서 `월`을 꺼내올 수 있어 그 방법으로 해결하였습니다.

#### 풀이

```sql
select count(*) as fish_count, MONTH(time) as month from fish_info
group by MONTH(time)
order by month
```

