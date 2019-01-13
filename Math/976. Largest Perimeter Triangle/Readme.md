# 976. Largest Perimeter Triangle

Difficulty: 2.0 if you know the logic, if not 3.0

Let's list the rules of triangle:
1. a+b>c
2. a+c>b
3. b+c>a

The question is asking the largest sum of 3 numbers with following the traiangle rule.
Then let's sort it first, and pick the largest 3 numbers.
But how to pick? I was thinking use 3 pointers, with the first combination, there it is.
The array must follow this rule
```
A[i]<=A[j]<=A[k], i<j<k,
```
The result will follow these rules:
```
A[i]+A[j]>A[k], i<j<k,
A[i]+A[k]>A[j]
A[j]+A[k]>A[i]
```
if ```A[i]+A[j]>A[k]``` is false, then no point to check i-1, j-1, because ```A[i]<=A[j]<=A[k], i<j<k,```
if ```A[i]+A[j]>A[k]``` is true, ```A[j]+A[k]>A[i]``` must be true, because ```A[i]<=A[j]<=A[k], i<j<k,```. ```A[j]+A[k]>A[i]``` must also be true, because ```A[k]>=A[j]``` and all numbers are positive, any number +A[k] must be larger than A[j].