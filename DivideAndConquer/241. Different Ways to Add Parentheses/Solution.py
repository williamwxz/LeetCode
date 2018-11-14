class Solution(object):
    memo = dict()
    def diffWaysToCompute(self, input):
        """
        :type input: str
        :rtype: List[int]
        """
        if input in self.memo:
            return self.memo[input]
        n = len(input)
        result = []
        if n==0:
            return result
        only_number = True
        for i in range(n):
            c = input[i]
            if c=='+' or c=='-' or c=='*':
                only_number = False
                left = self.diffWaysToCompute(input[0:i])
                right = self.diffWaysToCompute(input[i+1:])
                for l in left:
                    for r in right:
                        if c=='+':
                            result.append(l+r)
                        elif c=='-':
                            result.append(l-r)
                        elif c=='*':
                            result.append(l*r)
        if only_number:
            result.append(int(input))
        self.memo[input] = result
        return result
            