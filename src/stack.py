# -*- coding ntf8 -*-
#Stack.py: wenlong
#Description: Stack data structure
#
#abstract data type (ADT): specifies a set of operations (or methods) and the semantics of the operation (what they do),
#                        but it does not specify the implementation of the operations

class Stack:
    def __init__(self):
        self.items = []

    def push(self, item):
        self.items.append(item)

    def pop(self):
        return self.items.pop() #pop the last item on this list

    def empty():
        return (self.items == [])

    def display(self):
        print self.items
    #if __name__ == "__main__":
    

