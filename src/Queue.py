# -*- coding: utf-8 -*-
#queue.py: wenlong
#description: queue: use FIFO policy, using link list structure (O(1))
#             priority queue: use the priority queueing policy, using list structure
#                             the priority depends on the comparison operators (using built-in or __cmp__ method)
#TODO: update PriorityQueue class based on linked list

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

    def empty(self):
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
        while last:
            print last.cargo,
            last = last.next
        print


#in Priority queue, the item that is removed from the queue is not necessarily the first one that was added,
#Rather, it it the item in the queue that has the highest priority,
#And the priority depends on the comparison operators (built-in or __cmp__ method)

#using linked list,to keep the removal in a constant time, keep the list sorted
class PriorityQueue_(Queue):
    def insert(self,cargo): #keep the list sorted in the insertion
        node = Node(cargo)
        node.next = None
        #if the list is empty
        if self.head == None:
            self.head = self.last = node
        else:
            #find the least prioprity, keep it sorted
            #old_cargo = self.head.cargo
            current = self.head
            while current:
                #TODO: wanna to have a sorted list in insert
                #temp = current.next #because this isnot bi-linked list, we should keep current and current.next
                #from bigger to smaller, 4, 3, 1
                if  cargo > current.cargo: #in the sorted list, node is put between current and current.next
                    node.next = current.next
                    current.next = node
                    
                    import pdb; pdb.set_trace()
                    break    
                if cargo < current.cargo:
                    node.next = current.next #next node
                    current.next = node
                    current = current.next 
                    continue
        self.length = self.length + 1    
        
    #in the sorted list, removing the highest priority means removint the first node, O(1)

class PriorityQueue:
    def __init__(self):
        self.items = []

    def empty(self):
        return self.items == []

    def insert(self,item):
        self.items.append(item)

    def remove(self):
        max_index = 0 # hold the index of highest priority
        for i in range(0, len(self.items)):
            if self.items[i] > self.items[max_index]: # definition
                max_index = i
        item = self.items[max_index]
        self.items.pop(max_index)
        #self.items[max_index:max_index+i] = []
        return item

    def display(self):
        print self.items

"""        
def main():
    q = PriorityQueue()
    q.insert(5)
    q.insert(3)
    q.display()
    
    q.insert(4)
    q.display()
    
if __name__ == "__main__":
    main()
"""
