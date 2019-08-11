# 1156. Swap For Longest Repeated Character Substring

Difficulty: 3.0

This could be an easy question **if** you can list all possible cases:
1. abc -> 1
2. aba -> 2
3. aba.....a ->  swap the **middle** b with a from somewhere else
4. aaabb -> nothing you can swap
5. aabb ....a -> swap the **end** b with a from somewhere else

For case 3 and 5, in order to know if there is a letter you can swap from, you must **count** the frequency. 
