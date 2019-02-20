# 334. Increasing Triplet Subsequence

Difficulty: 3.0

My first approach was using increasing stack, but seem doable solution. However, in the case ```[1,2,-10,7]```, 1 and 2 is valid solution, but -10 will pop all the number out of the stack, so 7 won't be able to find smallers before it, and the solution will be failed to return true.

Then what to do? Since if we found three numbers of increasing sequence, we are done. For each number, it only care if there are two smaller numbers ahead. So let's create two numbers with max int
```python
if num<=low:
    low=num
elif num<=high:
    high=num
```
if there is a smaller number, than just replace them.
if the number is larger than the previous two, then return true.