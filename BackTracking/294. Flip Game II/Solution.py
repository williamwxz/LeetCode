class Solution(object):
    def canWin(self, s):
        """
        :type s: str
        :rtype: bool
        """
        n = len(s)
        def canWinHelper(array):
            for i in range(n-1):
                if array[i]=='+' and array[i+1]=='+':
                    array[i]='-'
                    array[i+1]='-'
                    win = not canWinHelper(array)
                    array[i]='+'
                    array[i+1]='+'
                    if win:
                        return True
            return False
        return canWinHelper(list(s))