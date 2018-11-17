# 730. Count Different Palindromic Subsequences

Difficulty: 5.0

Difficult problems, there are few approach for the final correct solution:

Approach 1:
Recusion (**TLE**)
Starting from 1 char, there will be 1 subsequence

2 chars, there will be 2 subsequence
For example,
ab -> a, b = 2
aa -> a, aa = 2

more than 2 char,
if s[i]==s[j]
c -> c
bcb -> c, bcb, b, bb = 4, as we found, count=count(2*s[i+1:j-1])+2
Or
cc -> c, cc
bccb -> c, cc, bcb, bccb, b, bb = 6, count=2*count(s[i+1:j-1])+2

**Import note**
Case 1, there is **ONE** same char
b->b
bbb -> b, bb, bbb=3, there is **ONE** same char as s[i]ors[j], count=2*conut(s[i+1][j-1])+1

Case 2, there is **Two** same char
bcb->c, b, bb
bbcbb ->c, b, bb, bcb, bbbb, bbbb =6, count=2*count(s[i+1][j-1])-count(s[second b from the left][second b from the right])

Recusively call count(s), to return the count of subseqeunce.

Approach 2:
Dynamic Programming
Based on the previous approach, we can easily derive a DP solution
                if i==j:
                    f[i][j]=1
                elif j-i==1:
                    f[i][j]=2
                else:
                    if S[i]==S[j]:
                        left, right=i+1, j-1
                        while left<=right and S[left]!=S[i]:
                            left+=1
                        while left<=right and S[right]!=S[i]:
                            right-=1
                        if left>right:
                            #no same char found
                            f[i][j] = 2*f[i+1][j-1]+2
                        elif left==right:
                            #one same char found
                            f[i][j] = 2*f[i+1][j-1]+1
                        else:
                            #at least two char found
                            f[i][j] = 2*f[i+1][j-1]-f[left+1][right-1]
                    else:
                        f[i][j]=f[i][j-1]+f[i+1][j]-f[i+1][j-1]
                        
