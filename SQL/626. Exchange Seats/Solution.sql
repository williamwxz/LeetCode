Select id-1 as id, student
From seat
Where id%2=0

Union

Select id+1 as id, student
From seat
Where id%2=1 and id<(select count(*) from seat)

Union

Select id, student
From seat
Where id%2=1 and id=(select count(*) from seat)

Order by id asc