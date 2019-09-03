# 670. Maximum Swap

Difficulty: 4.0

THe goal here is to scan the array, find the largest number that is larger than the current number, if there are same largest number, use the last one. 

For example:
1993 => for 1, what is the largest number? 9! But what is the last largest number? 9 at index 2, so swap 1 and 9 at index 2. It becomes 9913! 