# 72. Edit Distance

Difficulty: 3.0

Classic DP Problem
f[i][j] => Minimum edit distance for first i char in str1, first j char in str2

if str1[i-1]!=str2[j-1]
delete: we don't want i-th char from str1 to construct str2, so f[i][j]=f[i-1][j]+1
add: we current want to add i-th to str2, but and not using j-th from str2, so f[i][j]=f[i][j-1]+1
replace: we don't want i-th and j-th char from str1 and str2, so f[i][j]=f[i-1][j-1]+1

if str1[i-1]==str2[j-1]
f[i][j]=f[i-1][j-1], just keep the current edit distance
