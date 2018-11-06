**Difficulty: 4**

This problem basically requires us to find the pattern of the array.

Since the number is not too large, try to list all possible arrays

1: [1]

2: [1,2]

3: [1,3,2]

4: [1,3,2,4]

5: [1,5,3,2,4]

6: [1,5,3,2,6,4]

7: [1,5,3,7,2,6,4]

8: [1,5,3,7,2,6,4,8]

Looks like number is inserting with some patterns, as the base case [1] or [1,2].\n
3 is inserted after 1, diff is 2. \n
4 is inserted after 2, diff is 2. \n
5 is inserted after 1, diff is 4. \n
6 is inserted after 2, diff is 4. \n
7 is inserted after 3, diff is 4. \n
8 is inserted after 4, diff is 4. \n

I think we can see the pattern now.
