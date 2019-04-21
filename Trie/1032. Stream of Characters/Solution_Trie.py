class StreamChecker:
    class Node:
        def __init__(self, key):
            self.child=[None]*26
            self.key=key
            self.isWord=False
            
    def __init__(self, words: List[str]):
        self.waiting=[]
        self.root=self.Node(' ')
        for word in words:
            cur=self.root
            for w in word:
                index=ord(w)-ord('a')
                if not cur.child[index]:
                    cur.child[index]=self.Node(w)
                cur=cur.child[index]
            cur.isWord=True

    def query(self, letter: str) -> bool:
        index=ord(letter)-ord('a')
        later=[]
        for node in self.waiting:
            if node.child[index]:
                later.append(node.child[index])
        if self.root.child[index]:
            later.append(self.root.child[index])
        self.waiting=later
        
        for node in self.waiting:
            if node.isWord:
                return True
        return False
            

# Your StreamChecker object will be instantiated and called as such:
# obj = StreamChecker(words)
# param_1 = obj.query(letter)