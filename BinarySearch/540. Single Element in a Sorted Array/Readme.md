# 540. Single Element in a Sorted Array

Difficulty: 3.5

Very Interesting binary search problem, it will definitely need to use binary search approach, but most importantly,
we need to define the edge of left and right boundary

[1,1,2,3,3], interestingly, we found the left portion, all odd index must match even index,
in right portion, all odd index will **NOT** match even index. For example nums[0]==nums[1], nums[3]!=nums[4], because nums[2]=2

left - inclusive left boundary of target range
right - inclusive right boundary of target range

1. mid = left+(right-left)/2
2. unless mid is not the last index, if mid is even index, increment to odd index
3. if nums[mid]==nums[mid-1], that means we are in left portion, left=mid+1, because left bondary must be in the un-arranged portion
4. if nums[mid]!=nums[mid-1], **tricky part**, right=mid-1, since mid should be the second '1' of [1,1], but now is not, which means there is must be something wrong with the left of mid, but should you also include mid? [.....1,1,2,3,3.....], if mid on 2, what happen? then index of 2 must be **even**!! since mid must only be **odd** index, so mid **will never** be the single number index. 
5. Until exit the while loop, return nums[left] or nums[right]