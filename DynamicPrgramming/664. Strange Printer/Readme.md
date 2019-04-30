# 664. Strange Printer

Difficulty: 4.5

This is a quite difficult question, but apparently this is DP question.

Starting from len 1 letter, ```dp[i][i]=1```
What about 2 letter, 
for "aa", 1 turn
for "ab" or "ba", 2 turns

What about 3 letters
"aaa", "aba", "aab"...
Let's say ```dp[i][j]``` is from index i to index j, the minimum turns
we will try to find ```dp[i][j]=min(dp[i][k]+dp[k+1][j]) for k in [i:j+1]```
Does it work? "aba" will return 3, which is wrong, it should be 2, then how can I fix the dp above?
Why cause the issue, "ab" return 2, "a" return 1, that cause "aba" return 3.

```if s[i]==s[k]```, then the round of adding ```s[k]``` can be remove, because ```s[i]``` will take care of it.
So ```dp[i][j]=min(dp[i][k]+dp[k+1][j]-1) for k in [i:j+1]```
And now we get "aba" = 3.
