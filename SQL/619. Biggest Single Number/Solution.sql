# Write your MySQL query statement below
Select (
    Select num
    From number 
    Group by num
    Having count(*)=1
    Order by num desc limit 1
    ) as num

Select (if(count(*)=1, num, null)) as num
From number 
Group by num
Order by count(*), num desc limit 1