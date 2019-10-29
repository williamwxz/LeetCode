# 410. Split Array Largest Sum

Difficulty: 4.0

1. Try all possible sum from ```max(nums)``` to ```sum(nums)```
2. count how many subarray can be broken down with the possible sum.
3. If the ```count<=m```, then the sum could be too large or just ok
4. If the ```count>m```, then the sum is too small. 