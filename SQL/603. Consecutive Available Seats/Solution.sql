Select distinct a.seat_id
From cinema as a join cinema as b On abs(a.seat_id-b.seat_id)=1
Where a.free=1 and b.free=1
Order by a.seat_id