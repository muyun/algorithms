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

    #preorder, print the root before its children
    def display(self):
        if self == None:
            return
        print self.cargo,
        if self.left != None:
            self.left.display()
        if self.right != None:
            self.right.display()

    #postorder, print the subtrees then the root node
    def displayPostorder(self):
        if self == None:
            return
        if self.left != None:
            self.left.displayPostorder()
        if self.right != None:
            self.right.displayPostorder()
        print self.cargo,

    #inorder, print the left tree, then the root and the right tree
    def displayInorder(self):
        if self == None:
            return
        if self.left != None:
            self.left.displayInorder()
        print self.cargo,
        if self.right != None:
            self.right.displayInorder()

    #do an inorder traversal and keep track of what level in the tree we are on
    def displayIndented(self,level=0):
        if self == None:
            return
        if self.left != None:
            self.left.displayIndented(level+1)
        print '  '*level + str(self.cargo)
        if self.right != None:
            self.right.displayIndented(level+1)
        
    
