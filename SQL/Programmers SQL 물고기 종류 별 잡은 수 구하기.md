# Programmers [물고기 종류 별 잡은 수 구하기](https://school.programmers.co.kr/learn/courses/30/lessons/293257)

### 난이도 ★★

---

#### 접근 방식

> `group by`를 사용하여 해결하였습니다.

#### 풀이

```sql
select count(*) as FISH_COUNT, fn.fish_name from fish_info as fi
join fish_name_info as fn
on fi.fish_type = fn.fish_type
group by fn.fish_name
order by FISH_COUNT DESC;
```

