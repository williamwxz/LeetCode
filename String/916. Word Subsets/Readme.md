# 916. Word Subsets

Difficulty: 3.5

Few logic behind it:
1. It will use ```int[26]``` for sure, to count the existance of char.
2. if b is subset is a, a must have all char in b, with at least amount of char in b
3. for condition above, it must match all b
4. so count the minimum existance of all b, for all a, match every char
