class Solution:
    def findMinStep(self, board: str, hand: str) -> int:
        hand=collections.Counter(hand)
        def dfs(board, hand):
            if len(board)==0:
                return 0
            res=float('inf')
            left=0
            while left<len(board):
                right=left
                while right<len(board) and board[left]==board[right]:
                    right+=1
                needed=3-(right-left)
                if hand[board[left]]>=needed:
                    needed=needed if needed>=0 else 0
                    hand[board[left]]-=needed
                    tmp=dfs(board[:left]+board[right:], hand)
                    if tmp>=0:
                        res=min(res, tmp+needed)
                    hand[board[left]]+=needed
                left=right
            if res<float('inf'):
                return res
            return -1
        return dfs(board, hand)      