# 791. Custom Sort String

Difficulty: 2.0

It should be an easy question, but there are few approach

Approach 1:
Time: O(mlogm) m is length of T
1. use map to store the order of char in S
2. use sorting to sort T

Approach 2:
Time: O(n+m), n is length of S
1. put number of exist of char T, into a map
2. loop S, use the number of char in one bucket, to construct string
3. loop the remain char in bucket, construct string, order doesn't matter
