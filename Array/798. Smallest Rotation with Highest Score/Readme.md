# 798. Smallest Rotation with Highest Score

Difficulty: 4.0

This question will be similiar to meeting room 2
There are 3 key ideas here:
1. range is ```[0, N-1]```, and K is also in that range
2. ```(i-K)%N=A[i]```, where K is the maximum K ```A[i]``` can have to get point, if K+1, ```A[i]``` will sure lose point. In other word, ```K=(i-A[i]+1)%N``` will get the K that start losing point.
3. use the concept from meeting room 2 (sweep line)