# 607. Sales Person

Difficulty: 2.5

Interesting question on testing left join for excluding attributes. 
By using left join, some the attributes will be **NULL**, in this case, you can select those
are **NULL**, it can exclude some incorrect elements.

There are other solution, some of them using 
```sql
WHERE sales_id NOT IN
```
as subquerry.
