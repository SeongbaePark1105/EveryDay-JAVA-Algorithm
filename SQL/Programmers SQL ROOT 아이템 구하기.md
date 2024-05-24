# Programmers [ROOT 아이템 구하기](https://school.programmers.co.kr/learn/courses/30/lessons/273710)

### 난이도 ★★

---

#### 접근 방식

> `is null`을 활용하면 쉽게 해결할 수 있습니다.

#### 풀이

```sql
select tree.item_id, info.item_name from item_info as info join item_tree as tree
on info.item_id = tree.item_id
where tree.parent_item_id is null
order by tree.item_id
```

