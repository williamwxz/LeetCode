# 679. 24 Game

Difficulty: 3.5

Initially when the question was given with array of numbers, and return true/false, that might be a DP problem.
Let's think about the state, the state would be all the remaining number of the array, apparently, DP cannot handdle such variant states, i mean, i couldn't think any DP state can handle this situation. So, back to the basic, why not using DFS approach, try every single cases, see if any of it works?

For every state:
1. pick one pair, push it to a new array
2. and put the rest of numbers into array