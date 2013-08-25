# -*- coding: utf-8 -*-
#queue.py: wenlong
#description: queue: use FIFO policy, using link list structure (O(1))
#             priority queue: use the priority queueing policy, using list structure
#                             the priority depends on the comparison operators (using built-in or __cmp__ method)
#

class Node:
    def __init__(self, cargo = None, next = None):
        self.cargo = cargo
        self.next = next

    def __str__(self):
        return str(self.cargo)
    
# class Queue actually defines a bi-direction queue, 
# two invariants: 1) lenght is the number of nodes in the queue
#                 2) the last node has next equal to None
# the head points to the first Node and the last points to the last Node
class Queue:
    def __init__(self):
        self.length = 0  # num of the queue
        self.head = None # reference to the first Node
        self.last = None # reference to the last Node

    def isEmpty(self):
        return (self.length == 0)

    #insert the Node to last position, O(1)
    def insert(self, cargo): 
        node = Node(cargo)
        node.next = None
        #if queue is empty
        if self.head == None:
            self.head = self.last = node
            #self.length = self.length + 1
        else:
            #find the last node
            last = self.last
            #append the new node
            last.next = node
            self.last = node
        self.length = self.length + 1

    # remove the first Node and return its cargo, O(1)
    def remove(self): 
        cargo = self.head.cargo
        self.head = self.head.next
        self.length = self.length - 1
        if self.length == 0:
            self.last = None
        return cargo

    def display(self):
        last = self.head
        while last.next:
            print last.cargo,
            last = last.next
        print


#in Priority queue, the item that is removed from the queue is not necessarily the first one that was added,
#Rather, it it the item in the queue that has the highest priority,
#And the priority depends on the comparison operators (built-in or __cmp__ method)
class PriorityQueue:
    def __init__(self):
        self.items = []

    def isEmpty(self):
        return self.items == []

    def insert(self):
        self.items.append(self)

    def remove(self):
        max_index = 0 # hold the index of highest priority
        for i in range(0, len(self.items)):
            if self.items[i] > self.items[max_index] # definition
                max_index = i
        item = self.items[max_index]
        self.items.pop(max_index)
        #self.items[max_index:max_index+i] = []
        return item

    def display(self):
        print self.items
                            
