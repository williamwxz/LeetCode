class Solution:
    def smallestSubsequence(self, text: str) -> str:
        count=collections.Counter(text)
        stack=[]
        visited=[False]*27
        def index(l):
            return ord(l)-ord('a')
        for t in text:
            if not visited[index(t)]:
                while stack and ord(stack[-1])>=ord(t) and count[stack[-1]]>0:
                    visited[index(stack[-1])]=False
                    stack.pop(-1)
                stack.append(t)
                visited[index(t)]=True
            count[t]-=1
        return ''.join(stack)