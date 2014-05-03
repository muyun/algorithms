//DateSort.java: wenlong
//Description: used as a client to test the sort function
//
//--------------------------------------------------------
import java.util.Comparator;

// Comparable interface: sort using a type's natural order
/*
  public interface Comparable<Item>
  {
     public int compareTo(Item that);
  }
*/
class DateSort implements Comparable<DateSort>
{
    private final int day;
    private final int month;
    private final int year;

    public DateSort(int d, int m, int y){
        day = d;
        month = m;
        year = y;
    }

    public int day() { return day; }
    public int month() { return month; }
    public int year() { return year; }

    public int compareTo(DateSort that)
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
        DateSort[] dates = new DateSort[4];

        DateSort date0 = new DateSort(3,12,1983);
        DateSort date1 = new DateSort(28,8,2012);
        DateSort date2 = new DateSort(3,12,1982);
        DateSort date3 = new DateSort(15,9,2013);

        dates[0] = date0;
        dates[1] = date1;
        dates[2] = date2;
        dates[3] = date3;

        Selection.sort(dates);
        Selection.display(dates);
        
    }
    
}

//Comparator interface: sort using an alternate order
/*
public interface Comparator<Key>
{
    int compare(Key v, Key w); // compare keys v and w, required property: must be a total order
}
*/

class Date
{
    private final int day;
    private final int month;
    private final int year;

    public Date(int d, int m, int y){
        day = d;
        month = m;
        year = y;
    }

    public int day() { return day; }
    public int month() { return month; }
    public int year() { return year; }

    public static final Comparator<Date> BY_YEAR = new ByYear();
    private static class ByYear implements Comparator<Date>
    {
        public int compare(Date v, Date w)
        {
           int v_year = v.year();
           int w_year = w.year();
            
            return v_year.compare(w_year);
        }
    }

    public static final Comparator<Date> BY_MONTH = new ByMonth();
    private static class ByMonth implements Comparator<Date>
    {
        public int compare(Date v, Date w)
        {
            return v.month.compare(w.month);
        }
    }
    
    public String toString()
    { return year + "-" + month + "-" + day;}
    
    public static void main(String[] args)
    {
        Date[] dates = new Date[4];

        Date date0 = new Date(3,12,1983);
        Date date1 = new Date(28,8,2012);
        Date date2 = new Date(3,12,1982);
        Date date3 = new Date(15,9,2013);

        dates[0] = date0;
        dates[1] = date1;
        dates[2] = date2;
        dates[3] = date3;

        Insertion.sort(dates, Date.BY_MONTH);
        Insertion.display(dates);

        Insertion.sort(dates, Date.BY_YEAR);
        Insertion.display(dates);
        
        
        
    }
    
}