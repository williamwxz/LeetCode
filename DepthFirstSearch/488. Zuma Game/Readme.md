# 488. Zuma Game

Difficulty: 4.0

This is DFS strategy question, most of people will get in trapped because it is required to return a number.
But after we think through the question, the states of the question is hard to track.

So let's start dfs approach
I want to return the minmum number of balls needed, then we can try out every possible cases.

1. If with the existing balls, we can construct **consecutive sequence of same color**, then we can eliminate them and put them into next level.
2. The better approach is not to put ball one by one, is put as many as you can to elinimate the possible sequence. 

There are different approachs, but most of them are based on dfs.