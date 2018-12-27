Select distinct t1.id,
(Case 
    When t1.p_id is NULL Then 'Root'
    When t2.id is NULL Then 'Leaf'
    Else 'Inner'
End) as Type
From 
(
    tree as t1 left join tree as t2
    On t1.id=t2.p_id
)
