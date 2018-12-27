# 956. Tallest Billboard

Difficulty: 4.5

This question looks like backnack problems, so let's try think with backnack idea,
```dp[i][sum]=max(dp[i-1][sum], dp[i-1][sum-rod[i-1]])```, but the question is asking to properly assign numbers to both side with 0 difference, and find the max length. In this case, we will not be able use classic backnack approach. 

What state can we use? Well, since the question asks to find the length of one side, then actually needs to store one side length as value of state, one approach is to use the **difference** of two sides as state, which is similiar to backnack.
Let's assume we have two sides, and they have differnce (d), and we try to add a new rod to either side. y is the original length of one side, d is difference of them
Case 1, add to tall side
|-----y-----|----d----|---x---|
|-----y-----|
Case 2, add to short side, but ```d>=x```
|-----y-----|----d----|
|-----y-----|---x---|
Case 3, add to short side, but ```d<x```
|-----y-----|----d----|
|-----y-----|-----x-----|

1. add to tall side: ```dp[d+x]=max(dp[d+x], y)```
2. add to short side: ```dp[d-x]=max(dp[d-x], y+x); if d>=x```
3. add to short side: ```dp[x-d]=max(dp[x-d],y+d); if d<x```
4. combine 2 and 3, dp[abs(d-x)]=max(dp[abs(d-x),y+min(d,x)])
max sum=5000
Time: O(n*sum)=O(n*5001)
Space: O(sum)=O(5001)

Optmize space:
Using map to store state, but since using map, the computing time will be slower.
