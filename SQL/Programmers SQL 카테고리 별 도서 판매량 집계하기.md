# Programmers [카테고리 별 도서 판매량 집계하기](https://school.programmers.co.kr/learn/courses/30/lessons/144855)

### 난이도 ★★★

---

#### 접근 방식

> `join`으로 먼저 `book_id` 기준으로 묶고 `where` 에서 `like`문을 써 `2022-01` 을 포함한 날짜만 추출하였습니다.
>

#### 풀이

```sql
select b.category, sum(bs.sales) as total_sales from book as b
join book_sales as bs on b.book_id = bs.book_id 
where bs.sales_date like "%2022-01%"
group by category
order by category;
```

