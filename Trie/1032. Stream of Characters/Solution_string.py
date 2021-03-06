class StreamChecker:

    def __init__(self, words: List[str]):
        self.s=''
        self.record=collections.defaultdict(set)
        for word in words:
            self.record[word[-1]].add(word)

    def query(self, letter: str) -> bool:
        self.s+=letter
        return any(self.s.endswith(word) for word in self.record[letter])
        
# Your StreamChecker object will be instantiated and called as such:
# obj = StreamChecker(words)
# param_1 = obj.query(letter)