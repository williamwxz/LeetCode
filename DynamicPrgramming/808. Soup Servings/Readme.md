# 808. Soup Servings

Difficulty: 3.0

Using dfs approach is an obvious way.
Base case:
1. ```if A<=0&&B<=0 return 1.0```
2. ```if A<=0 return 1.0```
3. ```if B<=0 return 0.0```

Two keys:
1. for the memo, don't need to use N as the actual number, N=(N+24)/25.
2. this is a little trick, if N>4800, return 1.0