class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        N=len(num)
        res=[]
        def dfs(index, expression, val, last):
            if index>=N:
                if val == target:
                    res.append(expression)
                return
            for i in range(index, N):
                curStr=num[index:i+1]
                if len(curStr)>1 and curStr[0]=='0':
                    continue
                curNum = int(curStr)
                if index==0:
                    dfs(i+1, curStr, curNum, curNum)
                else:
                    # add
                    dfs(i+1, expression+"+"+curStr, val+curNum, curNum)
                    # minus
                    dfs(i+1, expression+"-"+curStr, val-curNum, -curNum)
                    # multiply
                    mul = last*curNum
                    dfs(i+1, expression+"*"+curStr, val-last+mul, mul)
            return
        dfs(0, "", 0, 0)
        return res