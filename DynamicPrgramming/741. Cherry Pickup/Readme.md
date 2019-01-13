# 741. Cherry Pickup

Difficulty: 4.5

This is a hard problem. My initial approach was:
1. Use dp to find the max cherries from left top to bottom for single path
2. Set all the cell it passed by to 0
3. Re-run the dp, and find the max cherries again

The problem for the algorithm above was, you need to know the path for max cherries pick up at the first time, it will be costly.

Since the question is asking the max cherries for two paths, we can actually imagine there are two person walk from the top left, to right bottom.

There are other approach, which makes more sense:
f(i, j, p, q) - the max cherries pick at (i,j) for the first time, and (p,q) for the second time.
then the transition could be:
```f(i, j, p, q)=max(f(i-1, j, p-1, q), f(i-1, j, p, q-1), f(i, j-1, p-1, q), f(i, j-1, p, q))+grid[i][j]+grid[p][q] if (grid[i][j]>=0&&grid[p][q]>=0)```

To optimize it, we found that the number of total steps for (i,j) will be same as (p,q), so ```i+j=p+q=n``, and n will be in range(0, 2*N).
Then the transition function become:
```
f(i-1, n-i, p-i, n-p)=f(n-1, i-1, p-1)
f(i-1, n-i, p, n-p-1)=f(n-1, i-1, p)
f(i, n-i-1, p-i, n-p)=f(n-1, i, p-1)
f(i, n-i-1, p, n-p-1)=f(n-1, i, p)
```