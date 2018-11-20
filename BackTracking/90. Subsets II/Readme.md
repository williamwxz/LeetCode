# 90. Subsets II

Difficulty: 2.5

**Both solution needs to sort the array first**
Solution 1 (Better, easy to analyze)
Typical backtracking question, there are two branches for the dfs tree, **add or not add**.
Sort the array, and then skip all duplicated numbers in each layer. Add record to the result at the leaf node.
Time: O(2^n) approximately

Solution 2 (not suggest, but still quick)
Add current record to the result in each level.
Use for loop in each level, skip the duplicate numbers.
