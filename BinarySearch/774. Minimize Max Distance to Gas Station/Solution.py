class Solution:
    def minmaxGasDist(self, stations: List[int], K: int) -> float:
        N=len(stations)
        left,right=0, stations[N-1]-stations[0]
        tolerance=1e-6
        while left<right-tolerance:
            mid=(left+right)/2
            count=0
            for a,b in zip(stations, stations[1:]):
                count+=math.ceil((b-a)/mid)-1
            if count<=K:
                right=mid
            else:
                left=mid
        return right