//Postfix.cpp
//
#include <iostream>
#include <string.h>
#include "stack.cpp"
#include "queue.cpp"

int main(int argc, char *argv[])
{
    char *a = argv[1];
    int N = strlen(a);

    STACK<char> ops(N);
    //LinkList<char> ops;

    for (int i=0; i<N; i++)
    {

        if ((a[i] == '+') || (a[i] == '*'))
            ops.push(a[i]);
        if ((a[i] >= '0') && (a[i] <= '9'))
            cout << a[i] << " ";
    }
        
    cout << endl;
    ops.display();
   
    QUEUE<char> ops1;
    for (int i=0; i<N; i++)
    {
       if ((a[i] == '+') || (a[i] == '*'))
           ops1.insert(a[i]);
    }
    cout << endl;
    ops1.display();

    return 0;
}
