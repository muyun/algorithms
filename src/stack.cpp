//stack.cpp : wenlong
//description: stack
//reference: Algorithms in c++ by Robert Sedgewick
#include <iostream>
using namespace std;

template <class Item>
class STACK
{
public:
    STACK(int max) 
    {
        s = new Item[max];
        N = 0;
    }

    int isEmpty() const { return N == 0; }

    void push(Item item) { s[N++] = item;}
    Item pop() { return s[--N];}

private:
    Item *s; // s points to the array
    int N;  // index
};



