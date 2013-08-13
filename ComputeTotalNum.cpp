//ComputeTotalNum.cpp: wenlong
//Description : compute the total number of comparisons used to sort the given input
//              file by QuickSort
//TODO: this is wrong code, need to develop further
//Aug-13-2013: fix the above bug(on line 20)
#include <iostream>
#include <vector>
#include <fstream>
using namespace std;

typedef vector<unsigned long int> Ivec;
typedef vector<unsigned long int>::iterator IvecIter;
typedef vector<unsigned long int>::size_type Index;

Index Partition(Ivec &v, Index l, Index r, unsigned long &cnt)
{
    unsigned int c;
    //cout<<"l:"<<l<<",r:"<<r<<endl;
    c = r - l;
    //cout<<"c:"<<c<<endl;
    cnt += c;

    //Q1:choose 1st element as pivot
    //so, when the subarray of length m, the total of comparisions is m-1
    unsigned long int pivot = v[l];
    Index i = l + 1;
    unsigned long int temp;

    for(Index j = i; j <= r; j++)
    {
        if(v[j] < pivot)
        {
            temp = v[j];
            v[j] = v[i];
            v[i] = temp;

            i++;
        }
    }
    //swap ivec[l] and ivec[i-1]
    temp = v[l];
    v[l] = v[i-1];
    v[i-1] = temp;
    /*
    for(Index x = 0; x < v.size(); ++x)
        cout<<v[x]<<",";
    cout<<endl;
    */
    return i - 1;
    
}

void ComputeNum(Ivec &v, Index left , Index right, unsigned long &cnt)
{
    if(right < left)
        //no comparison
        return;
    //always use the first element of the array as the pivot element
    //partition the array around the pivot
    //get the index of pivot
    Index p = Partition(v, left, right, cnt);
        
    //compute 1st part
    //The old BUG: Index is an unsigned int, so when p -1 <0, it will switch an big unsigned int
    if (p  >= 1) // p -1 >=0
    {
        
        ComputeNum(v, left, p-1, cnt);
    
       //compute 2nd part
       ComputeNum(v, p+1, right, cnt);
    }
    //return x + y;
    
}


int main()
{
    unsigned long  count = 0;
    
    Ivec ivec;
    unsigned long int value;
    
    ifstream fin("QuickSort");
    if(fin.is_open())
    {
        while(fin >> value)
        {
            ivec.push_back(value);
        }
    }else
    {
        cout <<"Cann't open the file"<<endl;
    }
    
    fin.close();
    
    cout<<ivec.size()<<endl;

    //for(IvecIter iter = ivec.begin(); iter != ivec.end(); ++iter)
    //    cout<<*iter<<" ";
    //cout<<endl;

    ComputeNum(ivec, 0, ivec.size()-1, count);
    cout <<"Count:"<<count<<endl;
    
    return 0;
}

