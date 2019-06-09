# 5086. Smallest Subsequence of Distinct Characters

Simple question, but just didn't use the right way to do it.

Something I missed was, if the letter already exists in stack, if you delete some letter in stack, what is the point? Since they are already in the stack, and this letter will only be able to delete some up to itself. 

So only allow other letter to delete stacks.