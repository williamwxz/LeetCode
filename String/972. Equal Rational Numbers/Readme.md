# 972. Equal Rational Numbers

Difficulty: 3.5

Very tricky approach, there is an important idea behind it:
**In Java, double can represent up to 16~17 digits**

1. Separate base and digits
2. If '(' exist, repeat digit up to 16 times, append to base, return the string as double
3. If not, then return the original string as double

In this question, we utilize the inaccuracy of Double representation. 