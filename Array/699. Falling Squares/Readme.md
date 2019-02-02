# 699. Falling Squares

Difficulty: 3.5

You solve the question by using "sweep line" concept, but first in sweep line problem, you will clearly need to know the coordinate of each points. In this case, I don't know, the points could be various. 

In this case, the first data structure comes to my mind was Map, it can store random data points. However, the data points must be sorted in order to solve it as sweep line, even we can construct a long buckets to store every possibilities of coordinate, but it seems doesn't work.

What else you can do? Let's create an array to store all points, and sort them. And create an array to store the ceiling.
For each position, find the begin bucket and end bucket, find the maximum ceiling within the range of bucket, and add the current height, 
And then fill the ceiling array with current updated height.

For each position, add the maximum height to the list.