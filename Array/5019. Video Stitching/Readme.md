# 5019. Video Stitching

Difficulty: 3.0

Methods tried:
1. Sweepline (failed)
2. Stack (might work, but too complicated)

Methods someone else used:
1. DP

Accepted methods:
1. Basic array logic

Accepted solution:
1. sort the array by interval start
2. create start and end variables, when ```start>=end```, then finish
3. for each interval, if it is less than or equal to ```start```, keep merging it until you can't
4. if no interval can be used, return -1
5. increment ```res```
