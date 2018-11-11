#5. Longest Palindromic Substring

Difficulty:2.5

There is also a DP solution, refer to DP directory

There are other better solution,
Optimized solution: 

for each char in string, use it as end, start=end-max-1, start=end-max,
check if these substring is palidrome, 
in this case, we only consider the string large than max
