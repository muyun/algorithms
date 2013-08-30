//queue.cpp: wenlong
//description: queue
#include <iostream>
using namespace std;

template <typename Item>
class QUEUE
{
private:
    struct node
    {
        Item item;
        node* next;
        node(Item x): item(x), next(0){} 
    };

    typedef node* link;
    link head; // point the first item
    link tail; // point the last item
        
public:
    QUEUE() { head = 0;}
    int empty() const { return head == 0; }
    
    //insert new items at the end
    void insert(Item x)
    {
        link t = tail;
        tail = new node(x);
        if (head == 0)
            head = tail;
        else
            t->next = tail;
    }
    
    //remove the item at the front
    Item remove()
    {
        Item x = head->item;
        link t = head->next;
        delete head;
        head = t;
        return x;
    }

    void display()
    {
        while(head != 0)
        {
            cout<<head->item<<" ";
            head = head->next;
        }
        cout<<endl;
    }

    ~QUEUE(){};
    
};

    
