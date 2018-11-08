'''
This solution has not yet completed, please DO NOT use
'''
class Solution(object):
    def shortestBridge(self, A):
        """
        :type A: List[List[int]]
        :rtype: int
        """
        n = len(A)
        m = len(A[0])
        visited = [[False for j in range(m)] for i in range(n)]
        for i in range(n):
            done=False
            for j in range(m):
                if A[i][j]==1:
                    self.mark(A, i, j, visited)
                    done=True
                    break
            if done:
                break
        queue = collections.deque()
        visited = [[False for j in range(m)] for i in range(n)]
        for i in range(n):
            for j in range(m):
                if A[i][j]==2:
                    queue.append((i,j))
                    visited[i][j] = True
        step = 0
        directions=[[-1,0],[0,1],[1,0],[0,-1]]
        while len(queue)!=0:
            size = len(queue)
            for i in range(size):
                cur = queue.popleft()
                visited[cur[0]][cur[1]] = True
                for dirs in directions:
                    nextX = cur[0]+dirs[0]
                    nextY = cur[1]+dirs[1]
                    if nextX>=0 and nextX<n and nextY>=0 and nextY<m and not visited[nextX][nextY]:
                        if A[nextX][nextY]==1:
                            return step
                        elif A[nextX][nextY]==0:
                            queue.append((nextX, nextY))
            step += 1
        return -1

    def mark(self, A, x, y, visited):
        n = len(A)
        m = len(A[0])
        if x<0 or x>=n or y<0 or y>=m or visited[x][y] or A[x][y]==0:
            return
        visited[x][y] = True
        A[x][y]=2
        directions=[[-1,0],[0,1],[1,0],[0,-1]]
        for dirs in directions:
            nextX = x+dirs[0]
            nextY = y+dirs[1]
            self.mark(A, nextX, nextY, visited)

            