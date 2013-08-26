# -*- coding: utf-8 -*-
#Golfer.py: wenlong
#Description: keep track of the names and scores of golfers, using to test Priority queue
#
from datastructure.queue import PriorityQueue

class Golfer:
    def __init__(self, name, score):
        self.name = name
        self.score = score

    def __str__(self):
        return "%-16s: %d" % (self.name, self.score)

    #define comparation operator
    #the lowest score gets highest priority
    def __cmp__(self, other):
        if self.score < other.score: return 1
        if self.score > other.score: return -1
        return 0

def main():
        tiger = Golfer("Tiger Wooeds", 61)         
        phil = Golfer("Phil Mickelson", 72)
        hal = Golfer("Hal Sutton", 69)

        pq = PriorityQueue()
        pq.insert(tiger)
        pq.insert(phil)
        pq.insert(hal)
        while not pq.isEmpty():
                print pq.remove()
        
if __name__ == "__main__":
        main()
