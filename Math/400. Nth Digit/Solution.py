class Solution:
    def findNthDigit(self, n: int) -> int:
        start,size,step=1,1,9
        while n>step*size:
            n-=step*size
            size+=1
            step*=10
            start*=10
        return int(str(start+(n-1)//size)[(n-1)%size])