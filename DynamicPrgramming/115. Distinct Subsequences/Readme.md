# 115. Distinct Subsequences

Difficulty: 3.5

Typical DP question:
```python
n = len(S)
m = len(T)
f = [[0 for j in range(m+1)] for i in range(n+1)]
```
1. Define state
f[i][j] - number of distinct sequence with first i element in S, first J elements in T
2. Base case:
f[**i**][0] if T is empty string, then first i element will match 1 **distinct** subsequence
3. Transition
f[i][j] = f[i-1][j]+ (f[i-1][j-1] | if S[i-1]==T[j-1])
4. Computation steps
for i in range(len(S))
    for j in range(len(T))
5. Return: f[n][m]

Time: O(n*m)
Space: O(n*m)

Further improve in **Space**, only need **two row**.
Space: O(2*m) = O(m)
