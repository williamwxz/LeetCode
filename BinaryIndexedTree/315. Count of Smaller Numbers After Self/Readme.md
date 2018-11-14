# 315. Count of Smaller Numbers After Self

Difficulty: 4.0

There are many other solutions, but using binary index tree is one of the best solutions.

Few key ideas:
1. Construct a new array for binary indexed tree, using each number as index, the frequency of each number as the value
2. Use min value as first index of the array
3. index=nums[i]-min+**1**, here +1 is **very important** because for every query, we are find the sum of frequency of **smaller number**, which mean query(**number-1**), if we just nums[i]-min as number, there will be possible that query a negative index. 
4. More importantly, **binary indexed tree index must start from 1**, so for example, if min value is 1, current nums[i] is 1, then index will be nums[i]-min+1=1, if nums[i]-min=0, when try to update index=0, the update loop will go infinitely, which leads to TLE
5. Finally, start looping from the original array, query (nums[i]-min+1)-1 to find smaller number frequency, and then update(nums[i]-min+1)
   