#!/usr/bin/env python

# 1. 关于 redo/undo: 两个stack: history results, res
#
# Append
# ["0", "APPEND", "Hey"]
# ["1", "APPEND", "there"]
# ["2", "APPEND", "!"]
# "Hey there!"
# Backspace
# ["0", "APPEND", "Hey you"]
# ["1", "BACKSPACE"]
# if no character, then no delete

# UNDO
# Undo APPEND or BACKSPACE operation
# do nothing if no previous operations

# REDO
# Redo Undo operations
# If new append

# Chronological
# [timestamp, operation, data]

# Select
# 1. start index is inclusive, end index is exclusive
# 2. If end out of range, select up to the end
# 3. If select operation is followed by another Select, the most recent should be used.
# 4. If start out of range, then ignore this operation.
# 5. select + append = replace

# Bold
# 1. Select, and append *letter*


# Chronological
# 1. sort first
# 2. append, backspace

# Data
# Undo: stacks to store all previous action

class TextEditor:

    class Command:
        APPEND = "APPEND"
        BACKSPACE = "BACKSPACE"
        UNDO = "UNDO"
        REDO = "REDO"
        SELECT = "SELECT"
        INVALID = "INVALID"

    class Operation:
        def __init__(self, ops="INVALID", data="", start=-2, end=-1):
            self.ops = ops
            self.data = data
            self.start=start
            self.end=end

    def __init__(self):
        super().__init__()

        self.history = []
        self.revert = []
        self.start=-2
        self.end=-1

    def run(self, inputs) -> str:
        res = []
        inputs.sort()
        start=len(res)
        end=len(res)+1

        for i in inputs:
            operation = self.parse(i)
            if operation.ops == self.Command.APPEND:
                # reset redo
                self.revert = []

                # check select
                operation.start, operation.end = start, end

                res = self.append(operation=operation, result=res)
                start=len(res)
                end=len(res)+1
            elif operation.ops == self.Command.BACKSPACE:
                # reset redo
                self.revert = []

                if start>=len(res):
                    start, end = max(0, len(res)-1), len(res)

                # check select
                operation.start, operation.end = start, end

                res = self.backspace(operation=operation, result=res)

                start=len(res)
                end=len(res)+1

            elif operation.ops == self.Command.UNDO:
                res = self.undo(result=res)
            elif operation.ops == self.Command.REDO:
                res = self.redo(result=res)
            elif operation.ops == self.Command.SELECT:
                start,end=operation.start, operation.end
            print(res)
        return ''.join(res)

    def parse(self, s) -> Operation:
        operation = self.Operation()
        if len(s) <= 1:
            return operation
        if s[1] == self.Command.APPEND:
            if len(s) < 2:
                return operation
            operation = self.Operation(ops=self.Command.APPEND, data=s[2])
        elif s[1] == self.Command.BACKSPACE:
            operation = self.Operation(ops=self.Command.BACKSPACE)
        elif s[1] == self.Command.UNDO:
            operation = self.Operation(ops=self.Command.UNDO)
        elif s[1] == self.Command.REDO:
            operation = self.Operation(ops=self.Command.REDO)
        elif s[1] == self.Command.SELECT:
            if not s[2].isnumeric() or not s[3].isnumeric():
                return operation
            operation = self.Operation(ops=self.Command.SELECT, start=int(s[2]), end=int(s[3]))
        return operation

    def append(self, operation, result=[]):
        # append or replace
        start, end=operation.start, operation.end
        if start>=end:
            #invalid
            return result
        size=len(result)
        operation.end=start+len(operation.data)
        self.history.append(operation)
        if start<0 or start>=size:
            #append
            return result + list(operation.data)
        end=min(end, size)
        return result[:start] + list(operation.data) + result[end:]

    def backspace(self, operation, result=[]):
        start, end=operation.start, operation.end
        if start>=end:
            #invalid
            return result
        # delete last char
        # if empty, then do nothing
        if not result:
            return result
        if result:
            operation.data = result[start:end]
        operation.end=start+len(operation.data)
        self.history.append(operation)
        size=len(result)
        if start<0 or start>=size:
            return result[:-1]
        end=min(end, size)
        return result[:start] + result[end:]

    def undo(self, result=[]):
        # undo previous append and backspace
        # record previous append and backspace
        if not self.history:
            return result

        operation = self.history.pop(-1)
        self.revert.append(operation)
        start, end=operation.start, operation.end
        if operation.ops == self.Command.APPEND:
            # backspace
            result = result[:start] + result[end:]
        elif operation.ops == self.Command.BACKSPACE:
            # append
            result = result[:start] + list(operation.data) + result[start:]
        return result

    def redo(self, result=[]):
        # revert undo
        # get all undo actions into a stack
        # if there is a new append or backspace, clear stack
        if not self.revert:
            return result
        operation = self.revert.pop(-1)
        if operation.ops == self.Command.APPEND:
            # append
            result = self.append(operation=operation, result=result)
        elif operation.ops == self.Command.BACKSPACE:
            result = self.backspace(operation=operation, result=result)
        return result


def main():
    textEditor = TextEditor()
    # case 1
    data = [["0", "APPEND", "Hey"], ["1", "APPEND", " there"], ["2", "APPEND", "!"], [
        "3", "BACKSPACE"], ["4", "UNDO"], ["5", "REDO"], ["6", "UNDO"]]
    # case 2
    data = [["0", "APPEND", "Hey"], ["1", "APPEND", " there"], ["2", "APPEND", "!"], [
        "3", "BACKSPACE"], ["4", "UNDO"], ["6", "APPEND", "?"], ["6", "REDO"]]
    data = [["0", "APPEND", "Hello"], ["1", "SELECT", "1", "3"], ["3", "BACKSPACE"], ["4", "UNDO"], ["5", "REDO"]]
    data = [["0", "APPEND", "!"], ["1", "BACKSPACE"], ["2", "BACKSPACE"], ["3", "BACKSPACE"], ["4", "UNDO"]]
    data = [["0", "APPEND", "Hey"], ["1", "APPEND", " there"], ["2", "APPEND", "!"], ["3", "BOLD"], ["4", "SELECT", "1", "3"], ["5", "BOLD"], ["6", "UNDO"], ["6", "REDO"]]
    print(textEditor.run(data))


if __name__ == "__main__":
    main()
