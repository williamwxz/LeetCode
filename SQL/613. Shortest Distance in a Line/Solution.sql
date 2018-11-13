Select Min(p1.x-p2.x) As shortest
From
point As p1 Join point As p2
On p1.x>p2.x
