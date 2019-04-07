class Solution:
    def videoStitching(self, clips: List[List[int]], T: int) -> int:
        N=len(clips)
        clips=sorted(clips)
        start,i,res=0,0,0
        while start<T:
            curEnd=-1
            while i<N and clips[i][0]<=start:
                curEnd=max(curEnd, clips[i][1])
                i+=1
            if curEnd==-1:
                return -1
            res+=1
            start=curEnd
        return res