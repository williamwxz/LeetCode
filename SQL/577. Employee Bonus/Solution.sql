Select e.name, b.bonus
From Employee as e Left Join Bonus as b
On e.empId=b.empId
Where bonus<1000 or bonus is NULL