//enter fibonacci
#include <iostream>
#include <vector>
using namespace std;

//basic, according to the definition
int fib1(int n)
{
    if(n == 0)
        return 0;
    if(n == 1)
        return 1;
    return fib1(n-1) + fib1(n-2);
}

//a more sensible scheme would store the intermediate results
//O(n)
//However, Arithmetic operations on large numbers cannot possibly be performed in a single,constant-time step
//Think of the addition of two n-bit numbers
//So, the number of setps taken by fib2 is proportional to n*n
int fib2(int n)
{
    //when n=0
    int i = 1;
    int j = 0;
    for(int k=1; k<=n; k++)
    {
        j = i + j;
        i = j - i;
    }

    return j;
}

//involve matrices
//(Fn,Fn+1) = (0 1

int main()
{
    int num = 100;
    
    //cout<<fib1(num)<<endl;

    cout<<fib2(num)<<endl;
}

