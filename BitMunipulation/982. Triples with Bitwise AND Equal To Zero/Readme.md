# 982. Triples with Bitwise AND Equal To Zero

Difficulty: 3.5

This question is quite similiar to the one I did with BloomBerg (although I didn't solve it by that time).

After reading the question, we can easily find a naive approach, just bit-wise operation every numbers, whenever we get a zero, res++. Of course, this will be TLE.

Then how to approach? Since we do not care the duplicates, so don't care about any duplication.
1. use a map, to store the number of ```(A[i]&A[j])```
2. and the loop again, ```(A[k]&key)==0```, then ```res+=map.get(key)```