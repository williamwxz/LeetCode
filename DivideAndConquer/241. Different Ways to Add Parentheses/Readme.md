# 241. Different Ways to Add Parentheses

Difficulty: 3

For every "parentheses" problems, one typical method we can use is stack. However, when we try to 
understand the question, the question is asking the possible results from the string, basically use
operator, return all possibilities. Then might be use some kind of dfs or **recursion**, then
**divide and conquer** algorithm comes to mind. 

Two Notes:
1. If no operators found in the string, just use parse string to get integer, instead of compute it char by char. It will signically improve the effiency.
2. Use Map<String, List<Integer>> memo, to further improve effiency a little. 
