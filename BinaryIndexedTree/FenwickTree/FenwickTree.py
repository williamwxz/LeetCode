class FenwickTree:
    # Use for partial sum of an array, and the array is MODIFIABLE.
    def __init__(self, N: int):
        self.tree = [0]*(N+1)

    def __lowbit(self, x: int):
        return x&(-x)

    def update(self, i: int, delta: int):
        size = len(self.tree)
        while i<size:
            self.tree[i]+=delta
            i+=self.__lowbit(i)
    
    def query(self, i: int):
        count=0
        while i>0:
            count += self.tree[i]
            i-=self.__lowbit(i)
        return count
