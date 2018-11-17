# 224. Basic Calculator

Difficulty: 3.5

First thought was to use substring and recursion, but the time complexity will be large, because we need to scan for ( and ) to find the substring, so this method is not suggested.

Using **stack** would be the solution, but it will involve few logic block
1. if (, then store the current sum and sign to the stack
2. if ), then pop the stack with sign and previous sum, add to the current sum
3. if +, -, update current sum
4. if digit, compute the number

One difficult part I can think about the logic, when reach ), and +- after it, how the logic deal with it. 
