# 992. Subarrays with K Different Integers

Difficulty: 4.0

In this question, we want to find the sub array with EXACTLY K unique integers.
We can do this with following subset theory, f(exact K) = f(most K) - f(most K-1)

To find out the most K, we can use sliding window methods, but in this case, we want to compute the number of combinations, we can use the following formula,
number of permutation = end index - start index + 1
