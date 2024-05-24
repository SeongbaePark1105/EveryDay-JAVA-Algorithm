# Programmers [조건에 맞는 사원 정보 조회하기](https://school.programmers.co.kr/learn/courses/30/lessons/284527)

### 난이도 ★★

---

#### 접근 방식

> `group by` 와 `order by `절에 `limit`을 사용하여 해결하였습니다.

#### 풀이

```sql
select sum(hg.score) as score, he.emp_no as emp_no, he.emp_name as emp_name, he.position as position, he.email as email
from hr_grade as hg join hr_employees as he
on hg.emp_no = he.emp_no
where hg.year = 2022
group by he.emp_no
order by score desc limit 1;
```

