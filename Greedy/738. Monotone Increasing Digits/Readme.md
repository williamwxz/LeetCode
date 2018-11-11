#738. Monotone Increasing Digits

Difficulty: 2.5

Logical thinking problem, this question wants to have increasing array, but **x<=y** is ok
so iterate from the last digit, if we found the previous digit is larger, then decrement the previous digit, and make all remaining digit 
to be '9'

for example:
32157
2 is larger than 1, so decrement 2 to 1, and make all right digits to be 9, so become 31999
31999
3 is larger than 1, so decreament 3 to 2, and make all right digits to be 9, so become 29999, and this is correct answer
