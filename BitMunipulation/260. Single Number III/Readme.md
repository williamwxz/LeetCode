# 260. Single Number III

Difficulty: 4.0

Similiar to Single Number II, but you need to find two numbers.
Approach:
1. XOR all numbers, you will get a number (**diff**) that is the combination of two number results. 
2. What this number (**diff**) means? All the '1' bit indicate the different bits in these two number, then we can use it separate.
3. Now you can use **diff** as mask to separte all numbers into two group, but how to mask? Use all bit in **diff**? Since bit '1' in **diff** just means, there is different bit in num1 and num2, so we will just use ONLY **ONE BIT** in the **diff**.
4. We can loop from the MSB or LSB to any bit '1' in **diff**, but we can also use the concept **lowest bit** to get the lowest 1 bit.
5. THe now we can process all numbers, and separate them into two groups, use XOR, and each group will only have one number exist once. 
