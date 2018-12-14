# 910. Smallest Range II

Difficulty: 3.5

My first thought was, this question is similiar to interval question, to find the minimum size of interval which can include all intervals.
But looks like this is **NOT** interval questions, because we can either +K, or -K, those points are **fixed**.

Here is the solution from top voted answer:
1. The one possible solution is ```result=A[n-1]-A[0]```
2. Sort the array
3. Loop though each value one by one is not right, for every loop, use ```A[i]```, and ```A[i+1]```
4. And then think about it from four cases
    - Case 1: left of e1, left of e2, same as step 1
    - Case 2: right of e1, right of e2, same as step 2
    - Case 3: right of e1, left of e2, possible results
    - Case 4: left of e1, right of e2, impossible result
5. Since we know the left bondary: ```left=A[0]+K```, right boundary: ```A[n-1]-K```
6. For every loop, we find the min and max, and then try possible result
7. Find the minimum result
