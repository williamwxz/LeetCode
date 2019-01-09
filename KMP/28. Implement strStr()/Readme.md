# 28. Implement strStr()

Difficulty: 4.0 possible

To generate the table:
two pointer on the pattern string
              j       i
        a b c d a b c a
        0 1 2 3 4 5 6 7
table:  0 0 0 0 1 2 3

The last 'a' does not match ```s[j]```, so j will jump back to ```s[table[j-1]]```, and then compare again

```
if s[i]==s[j]:
    table[i]=j+1
    j++
```