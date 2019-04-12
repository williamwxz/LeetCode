# 282. Expression Add Operators

Difficulty: 4.0

Don't be faked by the label(divided conquer) of the question. This is DFS question.

Base case:
1. All numbers have been used/splitted
2. If the value is equal to target, add to result
   
## In process
### Add or Minus
1. Get the current slice of number
2. Use the current value, +/- the current slice
3. Add the current number to expression

### Multiply
1. Same 
2. Use the current value, -previous number+(previous*current slice)
3. Add "*" and current slice to expression

## Corner case
1. you cannot have "005" case
2. for the first number, you don't need need to add to expression, you use it as the expression.