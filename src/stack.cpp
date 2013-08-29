//stack.cpp : wenlong
//description: stack
//reference: Algorithms in c++ by Robert Sedgewick
using namespace std;

//based on array
template <class Item>
class STACK
{
public:
    STACK(int max) 
    {
        s = new Item[max];
        N = 0;
    }
    //STACK(const Item&);

    int isEmpty() const { return N == 0; }

    void push(Item item) { s[N++] = item;}
    Item pop() { return s[--N];}

private:
    Item *s; // s points to the array
    int N;  // index
};

//based on linked list
template <typename Item>
class LinkList
{
private:
    struct node
    {
        Item item;
        node* next;
        node(Item x, node* t): item(x), next(t){};
        
    };
    
    typedef node* link;
    link head; //pointer head points to the first item
    
public:
    LinkList(){ head = 0;}
    int isEmpty() const { return head == 0;}
    
    //push a new item at the front of the list, head points to this item
    void push(Item x)
    {
        // old head is given to the new node
        // and the new node is given to head
        head = new node(x, head); 
    } 

    //pop the item at the front of the list
    Item pop()
    {
        Item v = head->item;
        link t = head->next;
        delete head;
        head = t;

        return v;
    }
    
};
    
