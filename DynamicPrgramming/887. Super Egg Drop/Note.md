Difficult: 5
Classic Egg Drop problem
**Using classic Binary Search is not a good approach**
**There is a mathematical approach, but not recommended**
**Non-classic DP problem, but DP approach is recommended**

Assumption:
1<=K<=100
1<=N<=10000

Solution 0 (not accepted, TLE):
Remember, if you only have one egg left, and you are at i-floor, you will have two conditions:
1. if break, you need to go through i-1 floors
2. if not break, you need to go through N-i floors
So the base case will be, **if K==1 {return N};
Set DP states:
f[N+1][K+1] --- min moves to for N floors and K eggs
f[i][k] = min(1+f[i-1][k-1]+f[N-i][k])
Time: O(KN^2)
Space: O(K*N)


Solution 1 (accepted):
f[m][k] --- maximum steps with k eggs
1. if break, check f[m-1][k-1]
2. if not break, check f[m-1][k]
and +1 for current move
f[m][k] = f[m-1][k-1]+f[m-1][k]+1

Time: O(KlogN)???
Space: O(K*N)

Solution 2 (space optimize from solution 1)
Space: O(K)