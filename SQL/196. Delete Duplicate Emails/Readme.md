# 196. Delete Duplicate Emails

Difficulty: 3.0

It should be a easy inner join problem, but it is my first time to do **DELETE** sql problem on LC.

Note:
```sql
Select *
From Person as p1 Join Person as p2
On p1.Email=p2.Email
```

It should return
1 job@email 1 job@email
1 job@email 3 job@email
2 sam@email 2 sam@emmil
3 job@email 1 job@email
3 job@email 3 job@email

So add 
```sql
Where p1.Id>p2.Id
```

The logic above needs to be verified

