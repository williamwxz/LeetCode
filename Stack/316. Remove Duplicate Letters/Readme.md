# 316. Remove Duplicate Letters

Difficulty: 3.5

Without a doubt, this question will need monotonic increasing stack.

But there will involve few logic
1. count the existance of all char
2. loop each char in the string
3. if the char already exist in the stack, then no point to push it again, then just skip this char
4. if the char not exist, then we need to pop the larger element out of the stack, but how?
   1. if the char to be pop, will not be added again, then you can't pop
   2. so only pop the char which will be added again later