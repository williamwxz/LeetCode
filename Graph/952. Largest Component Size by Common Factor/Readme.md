# 952. Largest Component Size by Common Factor

Difficulty: 4.5

Union-Find is an obvious approach, but how to link each node together is the problem.

Approach 1, using Greatest Common Divisor, **TLE**

Approach 2, link each node to their factor, **AC**
1. create parents array from 0 to the max number
2. for each number, union with their factors, and also remember to union their **ALL** factors (that is why union(parents, a, a/k) comes to place)
3. finally, using a hash map, to record their parent count, find the max parent count
   