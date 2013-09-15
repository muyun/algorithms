//SortDateApp.java: wenlong
//Description: used as a client to test the sort function
//
//--------------------------------------------------------
//import java.util.Comparator;
/*
  // Comparable interface built in Java
  public interface Comparable<Item>
  {
     public int compareTo(Item that);
  }
*/
public class SortDateApp implements Comparable<SortDateApp>
{
    private final int day;
    private final int month;
    private final int year;

    public SortDateApp(int d, int m, int y){
        day = d;
        month = m;
        year = y;
    }

    public int day() { return day; }
    public int month() { return month; }
    public int year() { return year; }

    public int compareTo(SortDateApp that)
    {
        if(this.year > that.year) return +1;
        if(this.year < that.year) return -1;
        if(this.month > that.month) return +1;
        if(this.month < that.month) return -1;
        if(this.day > that.day) return +1;
        if(this.day < that.day) return -1;
        return 0;
    }

    public String toString()
    { return year + "-" + month + "-" + day;}
    
    public static void main(String[] args)
    {
        SortDateApp[] dates = new SortDateApp[4];

        SortDateApp date0 = new SortDateApp(3,12,1983);
        SortDateApp date1 = new SortDateApp(28,8,2012);
        SortDateApp date2 = new SortDateApp(3,12,1982);
        SortDateApp date3 = new SortDateApp(15,9,2013);

        dates[0] = date0;
        dates[1] = date1;
        dates[2] = date2;
        dates[3] = date3;

        Selection.sort(dates);
        Selection.display(dates);
        
    }
    
}
