Select s.name
From salesperson as s Left Join (
    orders as o Join company as c 
    On o.com_id=c.com_id and c.name='RED'
) On o.sales_id=s.sales_id
Where o.sales_id is NULL
