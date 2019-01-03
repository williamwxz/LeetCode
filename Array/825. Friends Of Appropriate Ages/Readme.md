# 825. Friends Of Appropriate Ages

Difficulty: 3.5

There few logic behind the questions:
1. all logic can be merged into one: **age[B] is in range of (0.5*age[A]+7, age[A]]**
2. We only need to calculate the number, so count number of people in same age.

Steps:
1. Count number of people in same age.
2. Find the sum of people in certain age range
3. Multiply the age[A]*sum(age[B]) in range.

