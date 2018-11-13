#613. Shortest Distance in a Line

Difficulty: 1

Beginner practice, it should use self-join, but I thought I need to shift the second table and subtract the first table, which is not correct

Solution:

Use self-join, when value in the first table is larger than the second table, use it, and subtract table 1 to table 2, get a colume with subtraction.
Since the question is looking for min value, return min value.
