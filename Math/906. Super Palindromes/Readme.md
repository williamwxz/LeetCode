# 906. Super Palindromes

Difficulty: 3.0

Idea:expand left and right, but we are actually looking for the number of palidromes, so we only care about the number of combination

First, we will need a function to determine if the string palidrome
Second, we keep expanding to left and right, until its out of bound

Then how to expand? 
dfs approach:
Let's consider even length string now:
1. Only if the length of string is larger than 0
2. '0' cannot be the first char

odd length
1. all single digit number is palidrome
2. expand from left and right, if square of the number is pali