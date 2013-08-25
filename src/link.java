//link.java
// A link
class link 
{
    public int iData;      // data item
    public double dData;   // data item
    public link next;      // next link in list

    public link(int id, double dd)  //constructor
    {
        iData = id;
        dData = dd;
        //next = null;  // next is auto set to null
        
    }

    public void displayLink()  // 
    {
        System.out.print("{" + iData + ", " + dData + "}");
        
    }
    
}// end class link

