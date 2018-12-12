# 87. Scramble String

Difficulty: 4.0

## Naive Approach:
DFS, similiar to check if two trees are twisted.
But one thing to be clarified is that, check 
isScramble(str1[0:i], str2[0:i])&&isScramble(str1[i:], str2[i:])
OR
isScramble(str1[**i**], str2[**0:-i**])&&isScramble(str1[**0:i**], str2[**-i:**])
And also this approach is super slow, so using **memo** to reduce time complexity.

## Naive Approach with Memo:
Add map to record previous result, refer to solution.java

## Most voted approach:
Instead using map, just check if all char exist in both string, this is **fastest solution**, amazing!
Refer to solution1.java
