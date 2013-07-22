//This is the Programming Question1 on Algorithms: Design and Analysis on Stanford
//Function: compute the number of inversions in the file given
//Algorithm: fast divide-and-conquer

#include <iostream>
#include <fstream>
#include <vector>
#include <string>
#include <cstdlib> //for atoi, c type
//#include <sstream> //for sringstream, c++ type
#include <cstdio> //printf

using namespace std;

typedef vector<unsigned long long> Ivec;
typedef vector<unsigned long long>::const_iterator Iter;
typedef vector<int>::size_type Index;
//typedef unsigned long long Index;

/*
int GetArray( char *file)
{
    //vector<int> ivec;
    ifstream in(*file);

    string line;
    while(getline(in,line))
    {
        int x = atoi(line.c_str());
        vector<int> ivec.push_back(x);
    }
    

    // for(int i=0; i <ivec.size(); i++)
    //    cout << atoi(ivec[i]) <<endl;
 

    // return ivec;
    
}
*/

inline void Show(Ivec &v)
{
    for(Iter iter= v.begin(); iter< v.end(); ++iter)
        cout<< *iter<<endl;
    /*
    for(Index ix = 0; ix < v.size(); ++ix)
        cout <<v[ix]<<endl;
    */
    
}

unsigned long long CountSplitInv(Ivec &v, Index lo, Index mid, Index hi)
{
    Ivec aux(v); //aux is a copy of v

    unsigned long long count = 0;
    
    Index i = lo, j = mid + 1;
    for(Index k = lo; k <= hi; k++)
    {
        unsigned long long num = 0;
        
        if (i > mid)
        {
            v[k] = aux[j++];
            //j++;
            
        }else if (j > hi ){
            v[k] = aux[i++];
            //i++;
                        
        }else if (aux[i]<aux[j])
        {
            v[k] = aux[i++];
            //i++;
            
        }else{
            // split part
            v[k] = aux[j++];
            //j++;
            
            if ( i <= mid)
            {
                num = mid - i + 1;
                count +=num;
            }
            
         }
       
        //cout<<"cnt:"<<cnt<<endl;
        
    }

    return count;
    
}


unsigned long long SortAndCount(Ivec &v, Index lo, Index hi)
{

    if (hi <= lo)
        return 0;
    unsigned long long x=0, y=0, z=0;
    
    Index mid = lo + (hi - lo) / 2;
    x = SortAndCount( v,  lo,  mid);
    y = SortAndCount( v, mid+1, hi);

    //cout<<lo<<":"<<mid<<":"<<hi<<endl;
    z = CountSplitInv( v, lo, mid, hi);

    return x + y + z;
    
}

/*
unsigned long long Count(Ivec &v)
{
   unsigned long long z = SortAndCount(v, 0, v.size()-1);

   return z;
}
*/

int main()
{
    /*
    const char Src[]="/home/zhaowenlong/workspace/class/Algorithms/Algorithms_Design_and_Analysis_Stanford/Integer.bak";
    Ivec ivec; 

    //store the integers to array 
    ifstream in(Src);
    string line;
    while(getline(in,line))
    {
        // convert string to int
        
       // stringstream ss(line);
       // int x = 0;
       // ss >> x;
        
        unsigned long long x = atoi(line.c_str());
        
        ivec.push_back(x);
    }
    */

    //Another way to open a file
    Ivec ivec;

    unsigned long long x;
    ifstream fin("Integer");
    if(fin.is_open()){
        while(!fin.eof())
        {
            fin >> x;
            ivec.push_back(x);
            
        }

        fin.close();
        
    }
    else{
        cout<<"Cann't open the file"<<endl;
    }
    
    //Show(ivec);
 
    unsigned long long cnt = SortAndCount(ivec,0,ivec.size());
    
    cout<<"cnt:"<<cnt<<endl;
    printf("cnt:%llu\n",cnt);
    
    
    return 0;
    
}

