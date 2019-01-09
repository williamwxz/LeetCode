Select (
    Round(Min(Sqrt(Power(p1.x-p2.x, 2)+Power(p1.y-p2.y, 2))),2)
) as shortest
From point_2d as p1 Join point_2d as p2
Where !(p1.x=p2.x and p1.y=p2.y)