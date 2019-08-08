# 28. Implement strStr()

Difficulty: 4.0 possible

To generate the table:
two pointer on the pattern string
              j       i
        a b c d a b c a
        0 1 2 3 4 5 6 7
table:  0 0 0 0 1 2 3

```table[i]```=the end of previous matched pattern, **exclusively**.

The last 'a' does not match ```s[j]```, so j will jump back to ```s[table[j-1]]```, and then compare again. Why? Because j is trying to find the previous pattern, see if it can match ```s[i]```.
Some people will shift the ```table[i]``` right by 1, so ```table[i]``` becomes the end of previous matched pattern, **inclusively**.

```
if s[i]==s[j]:
    table[i]=j+1
    j++
```