# 376. Wiggle Subsequence

Difficulty: 3.5

A naive approach will be check all the previous upward or downward trend, see which trend has longer sequence.

Notice this question, for each number, you only care the cloeset less or larger number previously.
DP approach will be:
1. Only check the closest upward or downward trend