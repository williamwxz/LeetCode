class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        N,M=len(haystack),len(needle)
        if M==0:
            return 0
        def buildTable(pattern):
            n=len(pattern)
            table=[0]*n
            i,j=1,0
            while i<n:
                if pattern[i]==pattern[j]:
                    table[i]=j+1
                    j+=1
                    i+=1
                else:
                    if j>0:
                        j=table[j-1]
                        # go back to the previous pattern
                        # find the matches
                        # keep in mind there is NO i++ here
                    else:
                        #just set table[i] to 0
                        table[i]=j # or table[i]=0
                        i+=1
            #shift table for convenice
            return [-1]+table[:-1]
        table=buildTable(needle)
        i,j=0,0
        while i<N and j<M:
            if haystack[i]==needle[j]:
                i+=1
                j+=1
            else:
                #re-try previous/other pattern
                j=table[j]
                #if no pattern left
                if j==-1:
                    # cannot find haystack[i] in needle[j]
                    # skip haystack[i], retry everything
                    i+=1
                    j=0 #or j+=1
        return (i-M) if j==M else -1