# Definition for a point.
# class Point(object):
#     def __init__(self, a=0, b=0):
#         self.x = a
#         self.y = b

class Solution(object):
    def maxPoints(self, points):
        """
        :type points: List[Point]
        :rtype: int
        """
        n = len(points)
        if n<=1:
            return n
        result=0
        for i in range(n):
            pivot = points[i]
            record = {}
            sameX=0
            sameP=1
            maxPoint=0
            for j in range(i+1, n):
                x = pivot.x-points[j].x
                y = pivot.y-points[j].y
                if x==0 and y==0:
                    sameP+=1
                elif x==0:
                    sameX+=1
                else:
                    gcd = self.computeGCD(x, y)
                    if gcd!=0:
                        x /= gcd
                        y /= gcd
                    slope = (y,x)
                    record[slope] = record.get(slope, 0)+1
                    maxPoint = max(maxPoint, record[slope])
            maxPoint = max(maxPoint+sameP, sameX+sameP)
            result = max(result, maxPoint)
        return result
                    
    def computeGCD(self, x, y):
        while y!=0:
            tmp = y
            y = x%y
            x = tmp
        return x
        