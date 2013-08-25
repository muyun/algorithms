# -*- coding: utf-8 -*-  #encoding of a python file
#PostfixExpression.py: wenlong
#Description: compute the value of the postfix [ (1+2)*3 => 1 2 + 3 * ]
#Notes: 1) the import way  2) in Stack class, pop method should have the return function

from datastructure.stack import Stack  #the file is named stack too
        
def EvaluatePostfix(tokens):
    stack = Stack()
    for token in tokens:
        if token == '' or token == ' ':
            continue
        if token == '+':
            #import pdb; pdb.set_trace()
            sum = stack.pop() + stack.pop()
            stack.push(sum)
            continue
        if token == '*':
            product = stack.pop() * stack.pop()
            stack.push(product)
            continue
        else:
            stack.push(int(token))
            continue
    return stack.pop()


def main():
    input = "56 47 + 2*"
    import re
    tokens = re.split('([^0-9])', input)
    
    result = EvaluatePostfix(tokens)
    print result

if __name__ == "__main__":
    main()

