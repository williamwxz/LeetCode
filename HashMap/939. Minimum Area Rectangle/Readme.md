#939. Minimum Area Rectangle

Difficulty: 4

Idea1:<br/>
Similiar to interval questions, however, all points are randomly distributed, and they are not interval, this method won't work<br/>

Idea2: hash x segment as string into hashmap, **TLE** fail<br/>
for each two point, (x1, x2):set(y value) into hashmap<br/>
Time: O(n^2), close to correct approach, but using string to hash would be slow<br/>
also I will need to post process the hashmap, to find the min area<br/>

Idea3: use two diagonal points to find min area<br/>
Time: O(n^2) <br/>
use hashmap,  (x):set(y value)<br/>
for for points, to check if map point1.x has point2.y in set, and point2.x has point1.y in set<br/>
if yes, get the area<br/>
result: AC<br/>