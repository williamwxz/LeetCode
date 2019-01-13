# 974. Subarray Sums Divisible by K

Difficulty: 3.0

Using prefix-sum is a straight forward solution, when adding a number to prefix sum, check if there are any number in prefix-K*i and prefix+K*i

However, there is an even tricky solution, since we want all number in range of K to be found, why not just hash those numbers into same bucket? For example, if K=5, prefix=2, put it into bucket 2, if prefix=7, put it into bucket 2, then we can find all numbers which can be divisible by 5 at the same time. ```prefix=(prefix+num)%K``` is an obvious approach. **However, there are negative numbers**.
**In java, -1%5=-1!!!!!!! This is different from python**
So if you want -2 to be hashed into 3, when K=5, then +5
So whenever prefix is negative, +K