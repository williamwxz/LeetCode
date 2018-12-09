# 955. Delete Columns to Make Sorted II

Difficulty: 2.5

Actually this is straigh forward solution, but i over-think it.

Simple steps:
1. loop each column
2. loop each string
3. if the first i column can make it lexicographic, then ok
4. if not, then delete this column for all string

Note:
1. **FIRST** i column to make all string lexicographic, don't just check the i-th column ONLY, that is why you were failed in the contest
