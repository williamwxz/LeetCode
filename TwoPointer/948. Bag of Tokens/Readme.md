# 948. Bag of Tokens

Difficulty: 3.5

Using DP approach might not be approiate in this case

One approach is using greedy+2 pointers.
1. Sort the token
2. we always want subtract the less power, and gain point; and we always want add the most power, and subtract point
3. then here is the two case
    1. try subtract the less power first for gaining point first, if not
    2. try add the most power first by substracting point, if not
    3. this is max point we can get

