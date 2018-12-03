# 949. Largest Time for Given Digits

Difficulty: 2.0

Claim down and do the math, one thing you might not yet, you can use string comparison to find the largest time:
for example, "21:56".compareTo("22:56") will be less than 0, because "21:56" is less than "22:56".

There are many approach:
* Permutation approach (dfs), but in python, you can **iteratool.permutation**
* Random combination approach 