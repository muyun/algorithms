# -*- coding: utf-8 -*-
#tree.py: wenlong
#description: tree structure;
#             A tree is either 1) the empty tree, represented by None
#                              2) a ndoe that contains an object reference and two tree references

class Tree:
    def __init__(self, cargo, left=None, right=None):
        self.cargo = cargo
        self.left = left
        self.right = right

    def __str__(self):
        return str(self.cargo)

    def display(self):
        if self == None:
            return
        print self.cargo,
        self.display(self.left)
        self.display(self.right)
