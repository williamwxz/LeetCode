# 936. Stamping The Sequence

Difficulty: 3.5

Using dfs approach is definitely a wrong way, because for all dfs methods, you must know **the number of level of the dfs tree beforehead**. In this case, you cannot calculate the number of levels, then it must not be the dfs method.

Hence, using greedy method is a good approach, the question also said return an answer within 10*target.length is guaranteed, that means, the result may be large, and the result may differnt for everyone.

I was thinking to use KMP, with different substring of stamp, and find all matched index in target. If there is any match, set certain char to '#'. Then estimated time will be **O(n+n^2*m), n is length of stamp, m is length of target**. The logic could be complicated.

Let's have different approach without using KMP, we still set char to '#' when there is any match. Just using two pointer to find if substring of target is matched with stamp, igore those char with '#'. And loop it until all char in target become '#', please keep in mind that there might be chances where no substring matched. 