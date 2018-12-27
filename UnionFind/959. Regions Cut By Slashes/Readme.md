# 959. Regions Cut By Slashes

Difficulty: 4.0

Clearly this is an union-find question, and also most of people will approach by spliting each cell into 4 parts.
But how to split? Initially I tried to rotate each cell 45 degree, and then split, but it seems too complicated. And I don't need to, the simplest way is use offset for each cell:
0 represent **top**
1 represent **right**
2 represent **bottom**
3 represent **left**
