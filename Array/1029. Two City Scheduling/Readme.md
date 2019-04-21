# 1029. Two City Scheduling

Difficulty: 3.5

This should be a easy question, but I was struggling on using complex data structure such as priority queue, or complex algorithm such dfs.

This question is similiar to lowest cost for flight to A and B city with two groups of people, maybe because I kinda saw this question before, some people use priority queue, then I was stuck on that concept.

Most important concept ```cost[0]-cost[1]```, the further negative means, ```cost[0]``` is much lower than ```cost[1]```

Approach:
1. **Sort by ```cost[0]-cost[1]```, then we can know which city we will prefer to choose**
2. For the fisrt half, take the ```cost[0]```
3. Same thing for the second half