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
long fib2(long n)
{
    //when n=0
    long i = 1;
    long j = 0;
    for(long k=1; k<=n; k++)
    {
        j = i + j;
        i = j - i;
    }

    return j;
}

int fib3(int n)
{
  if (n == 0)
    return 0;

  int f[n];  //store the intermediate results
  f[0] = 0;
  f[1] = 1;

  for(int i = 2; i < n+1; i++)
  {
    f[i] = f[i-1] + f[i-2];
    cout<<"i:"<<i<<"and f[i]:"<<f[i]<<endl;
  }

  /*
    two big number addition problem
  int a = 1134903170;
  int b = 1836311903;
  long int c = a + b;
  
  cout <<"a+b"<< c << endl;
  */
  return f[n];
  
}


//involve matrices
//(Fn,Fn+1) = (0 1

int main()
{
    long num = 49;
    
    //cout<<fib1(num)<<endl;
    cout<<sizeof(int)<<endl;
    
    //cout<<fib2(num)<<endl;
    cout <<fib3(num)<<endl;

    return 0;
}

