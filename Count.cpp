#include <iostream>
#include <fstream>
#include <vector>
#include <string>
#include <cstdlib> //for atoi, c type
//#include <sstream> //for sringstream, c++ type
#include <cstdio> //printf

using namespace std;

typedef vector<int> Ivec;
typedef vector<int>::const_iterator Iter;
//typedef vector<int>::size_type Index;
typedef unsigned int Index;

unsigned long long cnt = 0;

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

void CountSplitInv(Ivec &v, Index lo, Index mid, Index hi)
{
    Ivec aux(v); //aux is a copy of v
    
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
                cnt +=num;
            }
            
         }
       
        //cout<<"cnt:"<<cnt<<endl;
        
    }
    
}


int SortAndCount(Ivec &v, Index lo, Index hi)
{
    if (hi <= lo)
        return 0;
    Index mid = lo + (hi - lo) / 2;
    SortAndCount( v,  lo,  mid);
    SortAndCount( v, mid+1, hi);

    //cout<<lo<<":"<<mid<<":"<<hi<<endl;
    CountSplitInv( v, lo, mid, hi);
    
}

void Count(Ivec &v)
{
   SortAndCount(v, 0, v.size()-1);
   //cout<<v.size()<<".."<<endl;
      
   //Show(v);
   
}


int main()
{
    const char Src[]="/home/zhaowenlong/workspace/class/Algorithms/Algorithms_Design_and_Analysis_Stanford/Integer";
    Ivec ivec; 

    //store the integers to array 
    ifstream in(Src);
    string line;
    while(getline(in,line))
    {
        // convert string to int
        /*
        stringstream ss(line);
        int x = 0;
        ss >> x;
        */
        unsigned long long x = atoi(line.c_str());
        
        ivec.push_back(x);
    }
 
    //Show(ivec);
 
    Count(ivec);
    
    cout<<"cnt:"<<cnt<<endl;
    printf("cnt:%llu\n",cnt);
    
    
    return 0;
    
}

