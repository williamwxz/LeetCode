Select customer_number
From orders
Group by customer_number
Order by count(*) desc
Limit 1
