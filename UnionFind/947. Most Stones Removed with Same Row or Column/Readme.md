# 947. Most Stones Removed with Same Row or Column

Difficulty: 4.0

The most difficult part is how to approach. Since we can only remove the stones with other stones on the same column or same row, and we want to have most possible moves. So usually we would use greedy approach, find the stone with least aligned stones. However, there will be cases, all stones are share the same amount of aligned stones. But look into the following case:
[[1, 1, 0, 0, 0],
[1, 1, 0, 0, 0],
[0, 1, 1, 0, 0],
[0, 0, 1, 1, 1],
[0, 0, 0, 1, 1]]
All stones have degree of 2, if we accidentally remove the middle '1', then the result will end up with 2, which is incorrect, it should be 1.

Correct approach, looks like we keep removing stones from one cluster until only one left. It is similiar to number of island, we can determine the number of cluster first, and then use total points-cluster.
