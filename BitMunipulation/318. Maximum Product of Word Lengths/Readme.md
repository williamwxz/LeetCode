# 318. Maximum Product of Word Lengths

Difficulty: 3.5

The naive approach is pretty obvious:
1. find the string doesn't have common letters
2. find the max multiplication of length of the two strings

Is anyway to find the string with uncommon letters? By somehow hashing? 
First thing comes to my mind is to use set, every string have there own set, but it still take time to scan each string.
What about compress the string, for example, "aaabbb" becomes "ab", because the extra letters doesn't matter, so we can encode each string into unique id, that can identify if two string share common letters. wait, maybe not, "aaabbb", "bbbaaa" will be encoded as "ab" or "ba", but they share common letters!

Some people will use bit operation, since there are 26 letters, and each int is 32 bits, we can encode each string into bit! For example, "aaaabbbb" can be encoded to 0x02. "abc" -> 0x03. 

Then the remaining is easy.