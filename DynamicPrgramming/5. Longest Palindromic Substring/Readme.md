#5. Longest Palindromic Substring

Difficulty:2.5

Very classical DP problem, be careful
when s[i]==s[j], it will use f[i+1][j-1], in this case, please check if **previous substring are also palidrome**
Time: O(n^2)
Space: O(n^2)

There are other better solution,
Optimized solution: 
loop each char in the string, 
for odd length string, use it as center, expand to each side,
for even length string, use it and its adjacent as center, expand each side
Space: O(1)
Time: O(n)~O(n^2)