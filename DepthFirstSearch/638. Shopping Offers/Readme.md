# 638. Shopping Offers

Difficulty: 3.0

Typical dfs question,
base case, when all the needs become zero.
but firstly, in the logic, try to use not use any specials as one of the case, and check the min cost if using any of the specials.

To optimize it, we will need to create a helper function with **ONE** addition parameter, let's call it "start", which means, which specials should we start to count. Because we will keep loop the same special until the current special is no longer valid. For example, we will keep using the 1st special recursively until 1st special is invalid, then continue from the 2nd special. 