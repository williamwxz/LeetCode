# 835. Image Overlap

Difficulty: 3.0

Solution 1:
Brute Force, slide B on A
Time: O(n^4)
Space: O(1)

Solution 2:
Sparse Matrix, construct A and B to array A and array B.
Loop arrayA and ArrayB, use map to store value, then find the max value in map
Time: O(n^2+A*B)
Space: O(A+B)

