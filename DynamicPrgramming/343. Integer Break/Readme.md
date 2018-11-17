# 343. Integer Break

Difficulty:3.0

Split/Region type of DP question, we can easily split 2 into 1 and 1, or split 5 into f[1]*f[4], f[2]*f[3]

**Key Point**
1. For f[2], there will be chances that max(f[1]*f[1], **2**), as long as the is not the final number, we have to consider the case that we are not splitting anything

DP states:
f[i]=Math.max(f[i],f[j]*f[i-j])   for j in range(1,(i+1)/2), consider the case f[i]=i if not the final number
