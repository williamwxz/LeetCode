class Solution:
    def longestPrefix(self, s: str) -> str:
        if len(s)==1:
            return ''
        def buildTable(pattern):
            n=len(pattern)
            table=[0]*n
            i,j=1,0
            while i<n:
                if pattern[i]==pattern[j]:
                    table[i]=j+1
                    i+=1
                    j+=1
                else:
                    if j>0:
                        j=table[j-1]
                    else:
                        table[i]=0
                        i+=1
            return [-1]+table
        
        def kmp(txt, pat):
            N,M=len(txt), len(pat)
            i,j=0,0
            table=buildTable(pat)
            while i<N and j<M:
                if txt[i]==pat[j]:
                    i+=1
                    j+=1
                else:
                    j=table[j]
                    if j==-1:
                        i+=1
                        j=0
            return i-j
        
        i=kmp(s[1:], s[:-1])+1
        return s[i:]